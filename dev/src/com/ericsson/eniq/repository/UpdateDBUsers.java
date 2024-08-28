package com.ericsson.eniq.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.distocraft.dc5000.etl.rock.Meta_databases;
import com.ericsson.eniq.common.Utils;

import ssc.rockfactory.RockException;
import ssc.rockfactory.RockFactory;

public class UpdateDBUsers {
	public static final Log log = LogFactory.getLog("repository.UpdateDBUsers");

  private UpdateDBUsers() {

  }

  public static int updateMetaDatabases(final String user, final String oldPassword,
      final String newPassword) {
	
    RockFactory etlRep = null;
    int numberOfRowsupdated = 0;
    if (user == null || oldPassword == null || newPassword == null) {
      return numberOfRowsupdated;
    }

    final List<Meta_databases> databases = DBUsersGet.getMetaDatabases("ALL", "ALL");
    for (Meta_databases m : databases) {
      try { 
        if (oldPassword.equals(m.getPassword()) && user.equalsIgnoreCase(m.getUsername())) {
          etlRep = getRockFactoryObject();
          final Meta_databases metaDatabaseObject = getNewMetaDataBaseObject(etlRep);
          final Meta_databases whereMdb = getNewMetaDataBaseObject(etlRep);
          metaDatabaseObject.setPassword(Encryption.encrypt(newPassword));
          metaDatabaseObject.setEncryption_flag("YY");
          metaDatabaseObject.setDecryptionRequired(false);
          whereMdb.setUsername(user);
         //NOSONAR TO implement encryption mechanism and where clause is set on the basis of user	-whereMdbSetPassword(oldPassword, m, whereMdb);
          numberOfRowsupdated = metaDatabaseObject.updateDB(false, whereMdb);
          if(user.equalsIgnoreCase("etlrep") && numberOfRowsupdated != 0) {
        	  FileInputStream in = new FileInputStream("/eniq/sw/conf/ETLCServer.properties"); 
				Properties props = new Properties();
				props.load(in);
				in.close();
				FileOutputStream out = new FileOutputStream("/eniq/sw/conf/ETLCServer.properties");
				props.setProperty(ETLCServerProperties.DBPASSWORD, Encryption.encrypt(newPassword));
				props.store(out, null);
				out.close();
          } 
          break;
          
        } 
      } catch (Exception ex) {
    	  log.debug(ex);
      } finally {
    	 
        finallyBlock(etlRep);	
      }
    }
    return numberOfRowsupdated;
  }

private static void whereMdbSetPassword(final String oldPassword, Meta_databases m, final Meta_databases whereMdb) {//NOSONAR
		  whereMdb.setPassword(Base64.getEncoder().encodeToString(oldPassword.trim().getBytes())); 
}



private static void finallyBlock(RockFactory etlRep) {
	try {
		if (etlRep != null)
			etlRep.getConnection().close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

  /**
   * For bypassing PMD.
   */
  private static Meta_databases getNewMetaDataBaseObject(final RockFactory etlRep) {
    return new Meta_databases(etlRep);
  }

  /**
   * @return
   * @throws IOException
   * @throws RockException
   * @throws SQLException
   * @throws Exception
   */
  private static RockFactory getRockFactoryObject() throws IOException, SQLException, RockException {
    String engUser = null;
    String engPass = null;
    String url = null;
    String driver = null;
    Properties props = null;

    final String confDir = System.getProperty("CONF_DIR", "/eniq/sw/conf");

    props = new ETLCServerProperties(confDir + File.separator + "ETLCServer.properties");

    engUser = props.getProperty(ETLCServerProperties.DBUSERNAME);
    engPass = props.getProperty(ETLCServerProperties.DBPASSWORD);
    url = props.getProperty(ETLCServerProperties.DBURL);
    driver = props.getProperty(ETLCServerProperties.DBDRIVERNAME);

    return new RockFactory(url, engUser, engPass, driver, "DBUsersScript", true);

  }


}
