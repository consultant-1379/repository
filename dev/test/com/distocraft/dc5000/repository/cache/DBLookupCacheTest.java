package com.distocraft.dc5000.repository.cache;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.distocraft.dc5000.common.StaticProperties;
import com.ericsson.eniq.common.testutilities.DatabaseTestUtils;

import ssc.rockfactory.RockFactory;

public class DBLookupCacheTest {

	private String sql;
	private RockFactory rockFactory = null;
	private Logger mockLog;
	private DBLookupCache dbLookUpCache;
	private Properties prop;
	final String driver = "org.hsqldb.jdbcDriver";
	final String dburl = "jdbc:hsqldb:mem:testdb";
	final String dbusr = "SA";
	final String dbpwd = "";
	private DBLookupCacheTest dblookup;
	private Connection con;
	private PreparedStatement stmt ;
	private ResultSet rs;
	private Class classObj;
	private Field clauseMapField;
	private Method updateMethod;
	private String sqlQuery = "";
	private Map map = new HashMap();
	// map of map
	private Map mom = new HashMap(); 
	
	@Before
	public void setUp() throws Exception {
		//rockFactory = DatabaseTestUtils.getTestDbConnection();
		dblookup = new DBLookupCacheTest();
		dbLookUpCache = new DBLookupCache( dburl, dbusr, dbpwd);
		classObj = dbLookUpCache.getClass();
		map.put("key", "value");

	}

	@Test
	public void testUpdate() { 
		try {
			sqlQuery = "SELECT CURRENT_DATE AS today, CURRENT_TIME AS now FROM (VALUES(0))";//"select getdate()";
			dbLookUpCache = new DBLookupCache(dburl, dbusr, dbpwd);
			mom.put(sqlQuery, map);
			clauseMapField = classObj.getDeclaredField("clause_map");
			clauseMapField.setAccessible(true);
			clauseMapField.set(dbLookUpCache, mom);
			updateMethod = DBLookupCache.class.getDeclaredMethod("update", String.class);
			updateMethod.setAccessible(true);
			updateMethod.invoke(dbLookUpCache, sqlQuery);
		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	@Test
	public void testCloseConnection() {
		try {
			updateMethod = DBLookupCache.class.getDeclaredMethod("closeConnection", Connection.class, PreparedStatement.class, ResultSet.class);
			updateMethod.setAccessible(true);
			con = null;
			stmt = null;
		    rs=null;
		    updateMethod.invoke(dbLookUpCache, con, stmt, rs);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

	@Ignore
	public void testUpdate1() {
		try {
			sqlQuery = "select * from drop";
			DBLookupCacheTest dblookup = new DBLookupCacheTest();
			classObj = dbLookUpCache.getClass();
			mom.put(sqlQuery, map);
			clauseMapField = classObj.getDeclaredField("clause_map");
			clauseMapField.setAccessible(true);
			clauseMapField.set(dbLookUpCache, mom);
			updateMethod = DBLookupCache.class.getDeclaredMethod("update", String.class);
			updateMethod.setAccessible(true);
			updateMethod.invoke(dbLookUpCache, sqlQuery);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
