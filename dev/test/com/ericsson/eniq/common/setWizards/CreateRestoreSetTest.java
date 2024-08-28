package com.ericsson.eniq.common.setWizards;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ssc.rockfactory.RockFactory;
import utils.TestUtils;

public class CreateRestoreSetTest {
  private final boolean isScheduling = true;

  private final int techpackId = 123;

  private static final String COUNT_SET_NAME = "Count_Set";

  private static final String setVersion = "((12))";

  private static final String versionId = "EVENT_E_SGEH:((12))";

  private static RockFactory dwhrep = null;

  private static RockFactory etlrep = null;

  @Before
  public void setUp() throws Exception {
    etlrep = CreateRockFactoryHelper.createEtlRepRockFactory();
    dwhrep = CreateRockFactoryHelper.createDwhRepFactory();
    TestUtils.loadSetup(dwhrep, "createCountSets");
  }

  @After
  public void tearDown() throws Exception {
    CreateRockFactoryHelper.cleanUpRockFactory();
    etlrep = null;
    dwhrep = null;
  }

  @Test
  public void checkThatCreateAndRemoveSetsWorksForCountSets() throws Exception {
    final CreateRestoreSet CreateRestoreSet = new CreateRestoreSet(COUNT_SET_NAME, setVersion, versionId, dwhrep,
        etlrep, techpackId, isScheduling);

    // META_TRANSFER_ACTIONS should be empty here
    ResultSet resultSet = CreateRockFactoryHelper.executeQueryOnEtlRep("SELECT * FROM META_TRANSFER_ACTIONS");
    assertFalse(resultSet.next());

    // META_COLLECTIONS should be empty here
    resultSet = CreateRockFactoryHelper.executeQueryOnEtlRep("SELECT * FROM META_COLLECTIONS");
    assertFalse(resultSet.next());

    CreateRestoreSet.create(false);

    // Check META_TRANSFER_ACTIONS
    resultSet = CreateRockFactoryHelper.executeQueryOnEtlRep("SELECT * FROM META_TRANSFER_ACTIONS");
    assertTrue(resultSet.next());
    assertEquals("((12))", resultSet.getString(1));
    assertEquals("1", resultSet.getString(2));
    assertEquals("1", resultSet.getString(3));
    assertEquals("123", resultSet.getString(4));
    assertEquals("BackupLoader", resultSet.getString(5));
    assertEquals("Restore_Count_DAY_DAY", resultSet.getString(6));
    assertEquals("0", resultSet.getString(7));
    assertEquals(null, resultSet.getString(8));
    assertEquals("", resultSet.getString(9));
    assertEquals("", resultSet.getString(10));
    assertEquals("Y", resultSet.getString(11));
    assertEquals("2", resultSet.getString(12));
    assertEquals("", resultSet.getString(13));
    assertEquals("", resultSet.getString(14));
    assertEquals("", resultSet.getString(15));
    assertEquals("", resultSet.getString(16));

    assertTrue(resultSet.next());
    assertEquals("((12))", resultSet.getString(1));
    assertEquals("2", resultSet.getString(2));
    assertEquals("2", resultSet.getString(3));
    assertEquals("123", resultSet.getString(4));
    assertEquals("BackupLoader", resultSet.getString(5));
    assertEquals("Restore_Count_15MIN_DAY", resultSet.getString(6));
    assertEquals("0", resultSet.getString(7));
    assertEquals(null, resultSet.getString(8));
    assertEquals("", resultSet.getString(9));
    assertEquals("", resultSet.getString(10));
    assertEquals("Y", resultSet.getString(11));
    assertEquals("2", resultSet.getString(12));
    assertEquals("", resultSet.getString(13));
    assertEquals("", resultSet.getString(14));
    assertEquals("", resultSet.getString(15));
    assertEquals("", resultSet.getString(16));


    assertFalse(resultSet.next());

    // Check META_COLLECTIONS
    resultSet = CreateRockFactoryHelper.executeQueryOnEtlRep("SELECT * FROM META_COLLECTIONS");
    assertTrue(resultSet.next());
    assertEquals("1", resultSet.getString(1));
    assertEquals("Restore_Count_DAY_DAY", resultSet.getString(2));
    assertEquals(null, resultSet.getString(3));
    assertEquals(null, resultSet.getString(4));
    assertEquals(null, resultSet.getString(5));
    assertEquals(null, resultSet.getString(6));
    assertEquals("0", resultSet.getString(7));
    assertEquals("0", resultSet.getString(8));
    assertEquals("0", resultSet.getString(9));
    assertEquals("N", resultSet.getString(10));
    assertEquals("N", resultSet.getString(11));
    assertEquals(null, resultSet.getString(12));
    assertEquals("((12))", resultSet.getString(13));
    assertEquals("123", resultSet.getString(14));
    assertEquals(null, resultSet.getString(15));
    assertEquals("0", resultSet.getString(16));
    assertEquals("72000", resultSet.getString(17));
    assertEquals("Y", resultSet.getString(18));
    assertEquals("Backup", resultSet.getString(19));
    assertEquals("Y", resultSet.getString(20));
    assertEquals(null, resultSet.getString(21));
    assertEquals("N", resultSet.getString(22));
    assertEquals(null, resultSet.getString(23));

    assertTrue(resultSet.next());
    assertEquals("2", resultSet.getString(1));
    assertEquals("Restore_Count_15MIN_DAY", resultSet.getString(2));
    assertEquals(null, resultSet.getString(3));
    assertEquals(null, resultSet.getString(4));
    assertEquals(null, resultSet.getString(5));
    assertEquals(null, resultSet.getString(6));
    assertEquals("0", resultSet.getString(7));
    assertEquals("0", resultSet.getString(8));
    assertEquals("0", resultSet.getString(9));
    assertEquals("N", resultSet.getString(10));
    assertEquals("N", resultSet.getString(11));
    assertEquals(null, resultSet.getString(12));
    assertEquals("((12))", resultSet.getString(13));
    assertEquals("123", resultSet.getString(14));
    assertEquals(null, resultSet.getString(15));
    assertEquals("0", resultSet.getString(16));
    assertEquals("72000", resultSet.getString(17));
    assertEquals("Y", resultSet.getString(18));
    assertEquals("Backup", resultSet.getString(19));
    assertEquals("Y", resultSet.getString(20));
    assertEquals(null, resultSet.getString(21));
    assertEquals("N", resultSet.getString(22));
    assertEquals(null, resultSet.getString(23));

    assertFalse(resultSet.next());

    CreateRestoreSet.removeSets();
    // META_TRANSFER_ACTIONS should be empty again after remove
    resultSet = CreateRockFactoryHelper.executeQueryOnEtlRep("SELECT * FROM META_TRANSFER_ACTIONS");
    assertFalse(resultSet.next());

    // META_COLLECTIONS should be empty again after remove
    resultSet = CreateRockFactoryHelper.executeQueryOnEtlRep("SELECT * FROM META_COLLECTIONS");
    assertFalse(resultSet.next());
  }
}
