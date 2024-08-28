package com.distocraft.dc5000.etl.rock;

import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ssc.rockfactory.RockFactory;

/**
 * Test class for Meta_transformation_tablesFactory. Testing handling of all the objects in
 * Meta_transformation_tables table.
 */
public class Meta_transformation_tablesFactoryTest {

  private static Meta_transformation_tablesFactory objUnderTest;

  private static RockFactory rockFactory;

  private static Meta_transformation_tables whereObject;

  private static Connection con = null;

  private static Statement stmt;

  private static Field vec;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    /* Reflecting the private fields */
    vec = Meta_transformation_tablesFactory.class.getDeclaredField("vec");
    vec.setAccessible(true);

    /* Creating connection for rockfactory */
    try {
      Class.forName("org.hsqldb.jdbcDriver").newInstance();
      con = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "sa", "");
    } catch (Exception e) {
      e.printStackTrace();
    }
    stmt = con.createStatement();
    stmt.execute("CREATE TABLE Meta_transformation_tables ( TRANSF_TABLE_ID BIGINT  ,TRANSF_TABLE_NAME VARCHAR(31) ,DESCRIPTION VARCHAR(31) ,VERSION_NUMBER VARCHAR(31) ,IS_LOOKUP VARCHAR(31) ,CONNECTION_ID BIGINT  ,TABLE_ID BIGINT  ,KEY_COLUMN_ID BIGINT  ,VALUE_COLUMN_ID BIGINT )");
    
    /* Initializing rockfactory */
    rockFactory = new RockFactory("jdbc:hsqldb:mem:testdb", "sa", "", "org.hsqldb.jdbcDriver", "con", true);

    /* Creating where object which tells what sort of query is to be done */
    whereObject = new Meta_transformation_tables(rockFactory);
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {

    /* Cleaning up after test */
    stmt.execute("DROP TABLE Meta_transformation_tables");
    con = null;
    objUnderTest = null;
  }
  
  @Before
  public void setUp() throws Exception {

    /* Adding example data to table */
	  stmt.executeUpdate("INSERT INTO Meta_transformation_tables VALUES( 3  ,'testTRANSF_TABLE_NAME3'  ,'testDESCRIPTION3'  ,'testVERSION_NUMBER3'  ,'testIS_LOOKUP3'  ,3  ,3  ,3  ,3 )");
	  stmt.executeUpdate("INSERT INTO Meta_transformation_tables VALUES( 2  ,'testTRANSF_TABLE_NAME2'  ,'testDESCRIPTION2'  ,'testVERSION_NUMBER2'  ,'testIS_LOOKUP2'  ,2  ,2  ,2  ,2 )");
	  stmt.executeUpdate("INSERT INTO Meta_transformation_tables VALUES( 1  ,'testTRANSF_TABLE_NAME1'  ,'testDESCRIPTION1'  ,'testVERSION_NUMBER1'  ,'testIS_LOOKUP1'  ,1  ,1  ,1  ,1 )");

    /* Initializing tested object before each test */
    objUnderTest = new Meta_transformation_tablesFactory(rockFactory, whereObject);
  }
  
  @After
  public void tearDown() throws Exception {

    /* Cleaning up after each test */
    stmt.executeUpdate("DELETE FROM Meta_transformation_tables");
    objUnderTest = null;
  }
  
  /**
   * Testing Meta_transformation_tablesFactory constructor. All rows found from Meta_transformation_tables
   * table are put into vector.
   */
  @Test
  public void testMeta_transformation_tablesFactoryConstructorWithWhereObject() throws Exception {

    /* Calling the tested constructor */
    objUnderTest = new Meta_transformation_tablesFactory(rockFactory, whereObject);

    /* Asserting all Meta_transformation_tabless are found and put into vector */
    try {
      Vector<Meta_transformation_tables> actualVector = (Vector) vec.get(objUnderTest);
      String actual = actualVector.size() + ", " + actualVector.get(0).getTransf_table_id() + ", " +  actualVector.get(1).getTransf_table_id() + ", " +  actualVector.get(2).getTransf_table_id();
      String expected = "3, 3, 2, 1";
      assertEquals(expected, actual);
    } catch (ArrayIndexOutOfBoundsException aioobe) {
      fail("Test Failed - One or more Meta_transformation_tabless was not loaded from the table!\n " + aioobe);
    }
  }
  
  /**
   * Testing constructor with negative case where rockfactory object is null.
   */
  @Test
  public void testMeta_transformation_tablesFactoryConstructorWithWhereObjectNullRockfactory() throws Exception {

    /* Asserting that variables are initialized */
    try {
      objUnderTest = new Meta_transformation_tablesFactory(null, whereObject);
      fail("Test failed - NullPointerException was expected as rockfactory was initialized as null!");
    } catch (NullPointerException npe) {
      // test passed
    } catch (Exception e) {
      fail("Test failed - Unexpected exception occurred!\n" + e);
    }
  }
  
  /**
   * Testing Meta_transformation_tablesFactory constructor. All rows found from Meta_transformation_tables
   * table are put into vector and data validation is on.
   */
  @Test
  public void testMeta_transformation_tablesFactoryConstructorWithValidate() throws Exception {

    /* Calling the tested constructor */
    objUnderTest = new Meta_transformation_tablesFactory(rockFactory, whereObject, true);

    /* Asserting all Meta_transformation_tabless are found and put into vector */
    try {     
      Vector<Meta_transformation_tables> actualVector = (Vector) vec.get(objUnderTest);
      String actual = actualVector.size() + ", " + actualVector.get(0).isValidateData() + ", " +  actualVector.get(1).isValidateData() + ", " +  actualVector.get(2).isValidateData();
      String expected = 3 + ", " + true + ", " + true + ", " + true;
      assertEquals(expected, actual);
    } catch (ArrayIndexOutOfBoundsException aioobe) {
      fail("Test Failed - One or more aggregations was not loaded from the table!\n " + aioobe);
    }
  }
  
  /**
   * Testing constructor with negative case where rockfactory object is null.
   */
  @Test
  public void testMeta_transformation_tablesFactoryConstructorWithValidateNullRockfactory() throws Exception {

    /* Asserting that variables are initialized */
    try {
      objUnderTest = new Meta_transformation_tablesFactory(null, whereObject, true);
      fail("Test failed - NullPointerException was expected as rockfactory was initialized as null!");
    } catch (NullPointerException npe) {
      // test passed
    } catch (Exception e) {
      fail("Test failed - Unexpected exception occurred!\n" + e);
    }
  }
  
  /**
   * Testing Meta_transformation_tablesFactory constructor. All rows found from Meta_transformation_tables
   * table are put into vector and data validation is on.
   */
  @Test
  public void testMeta_transformation_tablesFactoryConstructorWithOrderClause() throws Exception {

    /* Calling the tested constructor */
    objUnderTest = new Meta_transformation_tablesFactory(rockFactory, whereObject, "ORDER BY TRANSF_TABLE_ID");

    /* Asserting all Meta_transformation_tabless are found and put into vector */
    try {
      Vector<Meta_transformation_tables> actualVector = (Vector) vec.get(objUnderTest);
      String actual = actualVector.size() + ", " + actualVector.get(0).getTransf_table_id() + ", " +  actualVector.get(1).getTransf_table_id() + ", " +  actualVector.get(2).getTransf_table_id();
      String expected = "3, 1, 2, 3";
      assertEquals(expected, actual);
    } catch (ArrayIndexOutOfBoundsException aioobe) {
      fail("Test Failed - One or more Meta_transformation_tabless was not loaded from the table!\n " + aioobe);
    }
  }
  
  /**
   * Testing constructor with negative case where rockfactory object is null.
   */
  @Test
  public void testMeta_transformation_tablesFactoryConstructorWithOrderClauseNullRockfactory() throws Exception {

    /* Asserting that variables are initialized */
    try {
      objUnderTest = new Meta_transformation_tablesFactory(null, whereObject, "ORDER BY TRANSF_TABLE_ID");
      fail("Test failed - NullPointerException was expected as rockfactory was initialized as null!");
    } catch (NullPointerException npe) {
      // test passed
    } catch (Exception e) {
      fail("Test failed - Unexpected exception occurred!\n" + e);
    }
  }
  
  /**
   * Testing Element retrieving from a vector at certain location.
   */
  @Test
  public void testGetElementAtWithGenericInput() throws Exception {

    assertEquals("2", objUnderTest.getElementAt(1).getTransf_table_id().toString());
  }
  
  /**
   * Testing Element retrieving from a vector at certain location.
   */
  @Test
  public void testGetElementAtOutOfBounds() throws Exception {

    assertEquals(null, objUnderTest.getElementAt(5));
  }
  
  /**
   * Testing size retrieving of the vector containing Meta_transformation_tables objects.
   */
  @Test
  public void testSize() throws Exception {

    assertEquals(3, objUnderTest.size());
  }
  
  /**
   * Testing vector retrieving containing Meta_transformation_tables objects.
   */
  @Test
  public void testGet() throws Exception {

    try {
      Vector<Meta_transformation_tables> actualVector = objUnderTest.get();
      String actual = actualVector.size() + ", " + actualVector.get(0).getTransf_table_id() + ", " +  actualVector.get(1).getTransf_table_id() + ", " +  actualVector.get(2).getTransf_table_id();
      String expected = "3, 3, 2, 1";
      assertEquals(expected, actual);
    } catch (ArrayIndexOutOfBoundsException aioobe) {
      fail("Test Failed - One or more aggregations was not loaded from the table!\n " + aioobe);
    }
  }
  
  /**
   * Test comparing two Meta_transformation_tables objects. True is returned if the two vectors
   * containing the objects are the same, otherwise false.
   */
  @Test
  public void testEqualsWithSameObjects() throws Exception {

    /* Creating another vector with the same objects */
    Vector otherVector = new Vector();
    for (int i = 3; i > 0; i--) {
      Meta_transformation_tables testObject = new Meta_transformation_tables(rockFactory, Long.parseLong(i + ""), "testVERSION_NUMBER" + i);
      otherVector.add(testObject);
    }

    /* Asserting the two vectors are the same */
    assertEquals(true, objUnderTest.equals(otherVector));
  }
  
  /**
   * Test comparing two Meta_transformation_tables objects. True is returned if the two vectors
   * containing the objects are the same, otherwise false.
   */
  @Test
  public void testEqualsWithSameVector() throws Exception {

    /* Creating another vector with the same vector */
    Vector otherVector = (Vector) vec.get(objUnderTest);

    /* Asserting the two vectors are the same */
    assertEquals(true, objUnderTest.equals(otherVector));
  }
  
  /**
   * Test comparing two Meta_transformation_tables objects. True is returned if the two vectors
   * containing the objects are the same, otherwise false.
   */
  @Test
  public void testEqualsWithNullVector() throws Exception {

    Vector otherVector = null;
    assertEquals(false, objUnderTest.equals(otherVector));
  }
  
  /**
   * Test comparing two Meta_transformation_tables objects. True is returned if the two vectors
   * containing the objects are the same, otherwise false.
   */
  @Test
  public void testEqualsWithDifferentAmountOfObjects() throws Exception {

    /* Creating another vector with only one object */
    Vector otherVector = new Vector();
    Meta_transformation_tables testObject = new Meta_transformation_tables(rockFactory, 1L, "testVERSION_NUMBER1");
    otherVector.add(testObject);
    
    /* Asserting the two vectors are the same */
    assertEquals(false, objUnderTest.equals(otherVector));
  }
  
  /**
   * Test comparing two Meta_transformation_tables objects. True is returned if the two vectors
   * containing the objects are the same, otherwise false.
   */
  @Test
  public void testEqualsWithDifferentObjects() throws Exception {

    /* Creating another vector with different objects */
    Vector otherVector = new Vector();
    for (int i = 1; i < 4; i++) {
      Meta_transformation_tables testObject = new Meta_transformation_tables(rockFactory, Long.parseLong(i + ""), "testVERSION_NUMBER" + i);
      otherVector.add(testObject);
    }
    
    /* Asserting the two vectors are the same */
    assertEquals(false, objUnderTest.equals(otherVector));
  }
  
  /**
   * Test deleting objects from the database.
   */
  @Test
  public void testDeleteDB() throws Exception {
    
    /* Calling the tested object */
    String actual = objUnderTest.deleteDB() + ", ";
    
    /* Getting row count */
    int rows = 0;
    ResultSet res = stmt.executeQuery("SELECT COUNT(*) FROM Meta_transformation_tables");
    while (res.next()) {
      rows = res.getInt(1);
    }
    
    /* Asserting object is deleted from the database */
    actual += rows;
    assertEquals(3 + ", " + 0, actual);
  }
  
  /**
   * Test object cloning.
   */
  @Test
  public void testClone() throws Exception {
    
    /* Asserting if cloning works */
    Object clonedObject = objUnderTest.clone();
    assertEquals(Meta_transformation_tablesFactory.class, clonedObject.getClass());
  }
}