/**
 * ----------------------------------------------------------------------- *
 * Copyright (C) 2019 LM Ericsson Limited. All rights reserved. *
 * -----------------------------------------------------------------------
 */
package com.ericsson.eniq.repository.dbusers;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import com.distocraft.dc5000.etl.rock.Meta_databases;
import com.distocraft.dc5000.etl.rock.Meta_databasesFactory;
import com.ericsson.eniq.repository.DBUsersGet;
import com.ericsson.eniq.repository.ETLCServerProperties;
import com.ericsson.eniq.repository.Encryption;
import com.ericsson.eniq.repository.UpdateDBUsers;

import ssc.rockfactory.RockFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esuramo
 *
 */
public class UpdateDBPass {

	private static final String DCUSER = "dcuser";
	private static Logger log = Logger.getLogger("dbusers.UpdateDBPass");

	private UpdateDBPass() {
	}

	public static void main(final String[] args) {
		int affectedRows = 0;
		String requestedUser = null;
		String oldPassword = null;
		String newPassword = null;
		RockFactory etlRep = null;

		if (args == null || (args.length != 1 && args.length != 3)) {
			System.out.println("Invalid parameters.");
			System.exit(1);
		}

		if (args[0].equalsIgnoreCase("ALL")) {
			////Encrypt all the un-encrypted passwords in Meta_Databases and exit
			try {
				Meta_databases whereMdbN;
				Meta_databases whereMdbY;
				Meta_databases newMdb;
				etlRep = getRockFactoryObj();
				whereMdbN = new Meta_databases(etlRep);
				whereMdbN.setEncryption_flag("N");
				 Meta_databasesFactory mdFact = new Meta_databasesFactory(etlRep, whereMdbN);
				 Vector<Meta_databases> dbs = mdFact.get();
				for (Meta_databases md : dbs) {
					newMdb = new Meta_databases(etlRep);
					newMdb.setPassword(Encryption.encrypt(md.getPassword()));
					newMdb.setEncryption_flag("YY");

					newMdb.setDecryptionRequired(false);
					Meta_databases whereObject = new Meta_databases(etlRep);
					whereObject.setUsername(md.getUsername());
					affectedRows = affectedRows + newMdb.updateDB(false, whereObject);
				}
				
				whereMdbY = new Meta_databases(etlRep);
				whereMdbY.setEncryption_flag("Y");
				mdFact = new Meta_databasesFactory(etlRep, whereMdbY);
				dbs = mdFact.get();	
				
				for (Meta_databases md : dbs) {
					newMdb = new Meta_databases(etlRep);
					
						newMdb.setPassword(Encryption.encrypt(md.getPassword()));
						newMdb.setEncryption_flag("YY");
					newMdb.setDecryptionRequired(false);
					Meta_databases whereObject = new Meta_databases(etlRep);
					whereObject.setUsername(md.getUsername());
					affectedRows = affectedRows + newMdb.updateDB(false, whereObject);
					
				}
				
				
			} catch (Exception e) {
				 log.log(Level.SEVERE, "Encryption failed error", e);
				System.exit(3);
			} finally{
				try {
					if (etlRep != null)
						etlRep.getConnection().close();
				} catch (SQLException e) {
					 log.log(Level.SEVERE, "Encryption failed error", e);
				}	
			} 
		} else if (args[0].equalsIgnoreCase("ByPass")) {
			////Encrypt the new password and update it in the Meta_Databases table and then exit
			requestedUser = args[1];
			try {
				Meta_databases whereObject;
				Meta_databases newMdb;
				etlRep = getRockFactoryObj();
				newMdb = new Meta_databases(etlRep);
				newMdb.setPassword(Encryption.encrypt(newPassword));
				newMdb.setEncryption_flag("YY");
				newMdb.setDecryptionRequired(false);
				whereObject = new Meta_databases(etlRep);
				whereObject.setUsername(requestedUser);
				affectedRows = newMdb.updateDB(false, whereObject);
			} catch (Exception e) {
				System.out.println("Exception occurred while updating password for: " + requestedUser +":" + e);
				e.printStackTrace();
				System.exit(3);
			} finally{
				try {
					if (etlRep != null)
						etlRep.getConnection().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			} 
		} else {
			requestedUser = args[0];
			oldPassword = args[1];
			newPassword = args[2];
			try {
				final List<Meta_databases> databases = DBUsersGet.getMetaDatabases("ALL", "ALL");
				for (Meta_databases m : databases) {
					if (oldPassword.equals(m.getPassword()) && requestedUser.equalsIgnoreCase(m.getUsername())) {
						affectedRows = UpdateDBUsers.updateMetaDatabases(requestedUser, oldPassword, newPassword);
						System.exit(0);
					}
				}
				System.out.println(
						"The username '"+requestedUser+"' and password is incorrect and doesnot exist in the database.");
				log.info(
						"The username '"+requestedUser+"' and password is incorrect and doesnot exist in the database.");
				System.exit(2);
			} catch (Exception e) {
				System.out.println("Exception occurred while updating password for: " + requestedUser +":" + e);
				log.info("Exception occurred while updating password for: " + requestedUser +":" + e);
				e.printStackTrace();
				System.exit(3);
			}  
		}
		
		System.exit(0);
	}
	
	public static RockFactory getRockFactoryObj() throws Exception {
		final String confDir = System.getProperty("CONF_DIR", "/eniq/sw/conf");
		Properties props = new ETLCServerProperties(confDir + File.separator + "ETLCServer.properties");;
		return new RockFactory(props.getProperty(ETLCServerProperties.DBURL),
				props.getProperty(ETLCServerProperties.DBUSERNAME),
				props.getProperty(ETLCServerProperties.DBPASSWORD),
				props.getProperty(ETLCServerProperties.DBDRIVERNAME), "UpdateDBPassword", false);
	}
}
