package com.distocraft.dc5000.repository.dwhrep;

import java.sql.SQLException;
import java.sql.Timestamp; // NOPMD : eeipca : may not be used
import java.util.Date; // NOPMD : eeipca : may not be used
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import ssc.rockfactory.FactoryRes;
import ssc.rockfactory.RockDBObject;
import ssc.rockfactory.RockException;
import ssc.rockfactory.RockFactory;
import ssc.rockfactory.RockResultSet;
import ssc.rockfactory.DataValidator;

@SuppressWarnings({"PMD.SuspiciousConstantFieldName"}) // eeipca : columns are in UPPERCASE
public class Measurementcolumn implements Cloneable,RockDBObject  {

    private String MTABLEID;
    private String DATANAME;
    private Long COLNUMBER;
    private String DATATYPE;
    private Integer DATASIZE;
    private Integer DATASCALE;
    private Long UNIQUEVALUE;
    private Integer NULLABLE;
    private String INDEXES;
    private String DESCRIPTION;
    private String DATAID;
    private String RELEASEID;
    private Integer UNIQUEKEY;
    private Integer INCLUDESQL;
    private String COLTYPE;
    private Integer FOLLOWJOHN;
   
  private String timeStampName = "LAST_UPDATED"; // NOPMD : Dont set as static or final, unit tests change this via reflection

  private String[] columnsAndSequences = {  };

  private final String[] primaryKeyNames = {    "MTABLEID"    ,"DATANAME"   };

  private RockFactory rockFact;

  private boolean newItem;
  
  private Set<String> modifiedColumns = new HashSet<String>();
  
  private boolean validateData = false;
  
  private Measurementcolumn original; 

  public Measurementcolumn(final RockFactory rockFact) {
  	this(rockFact, false);
  	original = null; 
  }

  /**
   * Constructor to initialize all objects to null
   */
  public Measurementcolumn(final RockFactory rockFact, final boolean validate) {
    this.rockFact = rockFact;
    this.newItem = true;
    this.validateData = validate;
    
         this.MTABLEID = null;
         this.DATANAME = null;
         this.COLNUMBER = null;
         this.DATATYPE = null;
         this.DATASIZE = null;
         this.DATASCALE = null;
         this.UNIQUEVALUE = null;
         this.NULLABLE = null;
         this.INDEXES = null;
         this.DESCRIPTION = null;
         this.DATAID = null;
         this.RELEASEID = null;
         this.UNIQUEKEY = null;
         this.INCLUDESQL = null;
         this.COLTYPE = null;
         this.FOLLOWJOHN = null;
      	original = null; 

  }

  /**
   * Constructor for primary selection from database PRIMARY KEY MUST BE DEFINED
   * 
   * @params primarykeys
   * @exception SQLException
   */
  public Measurementcolumn(final RockFactory rockFact   ,final String MTABLEID ,final String DATANAME ) throws SQLException,
      RockException {
    try {
      this.rockFact = rockFact;

            this.MTABLEID = MTABLEID;
            this.DATANAME = DATANAME;
      
      final RockResultSet results = rockFact.setSelectSQL(true, this);
      final Iterator<Measurementcolumn> it = rockFact.getData(this, results);
      if (it.hasNext()) {
        final Measurementcolumn o = it.next();

              this.MTABLEID = o.getMtableid();
              this.DATANAME = o.getDataname();
              this.COLNUMBER = o.getColnumber();
              this.DATATYPE = o.getDatatype();
              this.DATASIZE = o.getDatasize();
              this.DATASCALE = o.getDatascale();
              this.UNIQUEVALUE = o.getUniquevalue();
              this.NULLABLE = o.getNullable();
              this.INDEXES = o.getIndexes();
              this.DESCRIPTION = o.getDescription();
              this.DATAID = o.getDataid();
              this.RELEASEID = o.getReleaseid();
              this.UNIQUEKEY = o.getUniquekey();
              this.INCLUDESQL = o.getIncludesql();
              this.COLTYPE = o.getColtype();
              this.FOLLOWJOHN = o.getFollowjohn();
       
        results.close();
        this.newItem = false;
  	    this.original = this; 
      } else {
        results.close();
  	    this.original = this; 
        throw new SQLException(FactoryRes.CANNOT_GET_TABLE_DATA + "Measurementcolumn");
      }
    } catch (SQLException sqlE) {
      throw sqlE;
    }
  }

  /**
   * Constructor to select the object according to whereObject from the db NO PRIMARY KEY DEFINED
   * 
   * @param whereObject
   *          the where part is constructed from this object
   * @exception SQLException
   */
  public Measurementcolumn(final RockFactory rockFact, final Measurementcolumn whereObject) throws SQLException,
      RockException {
    try {
      this.rockFact = rockFact;
      final RockResultSet results = rockFact.setSelectSQL(false, whereObject);
      final Iterator<Measurementcolumn> it = rockFact.getData(whereObject, results);
      if (it.hasNext()) {
        final Measurementcolumn o = it.next();
                this.MTABLEID = o.getMtableid();
                this.DATANAME = o.getDataname();
                this.COLNUMBER = o.getColnumber();
                this.DATATYPE = o.getDatatype();
                this.DATASIZE = o.getDatasize();
                this.DATASCALE = o.getDatascale();
                this.UNIQUEVALUE = o.getUniquevalue();
                this.NULLABLE = o.getNullable();
                this.INDEXES = o.getIndexes();
                this.DESCRIPTION = o.getDescription();
                this.DATAID = o.getDataid();
                this.RELEASEID = o.getReleaseid();
                this.UNIQUEKEY = o.getUniquekey();
                this.INCLUDESQL = o.getIncludesql();
                this.COLTYPE = o.getColtype();
                this.FOLLOWJOHN = o.getFollowjohn();
                results.close();
        this.newItem = false;
  	    this.original = this; 
      } else {
        results.close();
  	    this.original = this; 
        throw new SQLException(FactoryRes.CANNOT_GET_TABLE_DATA + "Measurementcolumn");
      }
    } catch (SQLException sqlE) {
      throw sqlE;
    }
  }

  public Set<String> gimmeModifiedColumns(){   
    return modifiedColumns;  
  }

  public void setModifiedColumns(final Set<String> modifiedColumns){
    this.modifiedColumns = modifiedColumns;  
  }

  public void cleanModifiedColumns(){   
    modifiedColumns.clear();  
  }

  /**
   * Method for getting the table name
   * 
   * @return String name of the corresponding table
   */
  public String getTableName() {
    return "Measurementcolumn";
  }

  /**
   * Update object contents into database PRIMARY KEY MUST BE DEFINED
   * 
   * @exception SQLException
   */
  public int updateDB() throws SQLException, RockException {
    this.newItem = false;
    return rockFact.updateData(this, true, null);
  }

  /**
   * Update object contents into database PRIMARY KEY MUST BE DEFINED
   * 
   * @param boolean
   *          useTimestamp if false, the timestamp is not used to compare if the data has been
   *          changed during the transaction
   * @exception SQLException
   */
  public int updateDB(final boolean useTimestamp) throws SQLException, RockException {
    this.newItem = false;
    return rockFact.updateData(this, true, null, useTimestamp);
  }

  /**
   * Update object contents into database NO PRIMARY KEY DEFINED
   * 
   * @param boolean
   *          useTimestamp if false, the timestamp is not used to compare if the data has been
   *          changed during the transaction
   * @param <this
   *          object type> whereObject the where part is constructed from this object
   * @exception SQLException
   */
  public int updateDB(final boolean useTimestamp, final Measurementcolumn whereObject) throws SQLException, RockException {
    this.newItem = false;
    return rockFact.updateData(this, false, whereObject, useTimestamp);
  }

  /**
   * Insert object contents into database
   * 
   * @exception SQLException
   */
  public int insertDB() throws SQLException, RockException {
    this.newItem = false;
    return rockFact.insertData(this);
  }

  /**
   * Insert object contents into database
   * 
   * @param boolean
   *          useTimestamp if false, the timestamp is not used to compare if the data has been
   *          changed during the transaction
   * @param boolean
   *          useSequence if false the sequence columns don't get their values from db sequences
   * @exception SQLException
   */
  public int insertDB(final boolean useTimestamp, final boolean useSequence) throws SQLException, RockException {
    this.newItem = false;
    return rockFact.insertData(this, useTimestamp, useSequence);
  }

  /**
   * Delete object contents from database PRIMARY KEY MUST BE DEFINED
   * 
   * @exception SQLException
   */
  public int deleteDB() throws SQLException, RockException {
    this.newItem = true;
    return rockFact.deleteData(true, this);
  }

  /**
   * Delete object contents from database NO PRIMARY KEY DEFINED
   * 
   * @param <this
   *          object type> whereObject the where part is constructed from this object
   * @exception SQLException
   */
  public int deleteDB(final Measurementcolumn whereObject) throws SQLException, RockException {
    this.newItem = true;
    return rockFact.deleteData(false, whereObject);
  }

  /**
   * Saves the data into the database
   * 
   * @exception SQLException
   */
  public void saveDB() throws SQLException, RockException {

    if (this.newItem) {
      insertDB();
    } else {
      if (isPrimaryDefined()) {
        rockFact.updateData(this, true, this, true);
      } else {
        throw new RockException("Cannot use rock.Measurementcolumn.saveDB(), no primary key defined");
      }
    }
    this.newItem = false;
    this.setOriginal(this);
  }

  /**
   * Saves the data into the database (without primary key update)
   * 
   * @exception SQLException
   */
  public void saveToDB() throws SQLException, RockException {

    if (this.newItem) {
      insertDB();
    } else if (this.gimmeModifiedColumns().size() > 0) {
      rockFact.updateData(this, false, this.getOriginal(), true);
    }
    this.newItem = false;
    this.setOriginal(this);
  }


  /**
   * Prints the object out as XML
   * 
   * @exception SQLException
   */
    public String toXML_tag() throws SQLException, RockException {
    final StringBuffer sbuff = new StringBuffer();
    sbuff.append("<Measurementcolumn ");
        sbuff.append("MTABLEID=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.MTABLEID),12, true)+"\" ");
        sbuff.append("DATANAME=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.DATANAME),12, true)+"\" ");
        sbuff.append("COLNUMBER=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.COLNUMBER),2, true)+"\" ");
        sbuff.append("DATATYPE=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.DATATYPE),12, true)+"\" ");
        sbuff.append("DATASIZE=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.DATASIZE),4, true)+"\" ");
        sbuff.append("DATASCALE=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.DATASCALE),4, true)+"\" ");
        sbuff.append("UNIQUEVALUE=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.UNIQUEVALUE),2, true)+"\" ");
        sbuff.append("NULLABLE=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.NULLABLE),4, true)+"\" ");
        sbuff.append("INDEXES=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.INDEXES),12, true)+"\" ");
        sbuff.append("DESCRIPTION=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.DESCRIPTION),12, true)+"\" ");
        sbuff.append("DATAID=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.DATAID),12, true)+"\" ");
        sbuff.append("RELEASEID=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.RELEASEID),12, true)+"\" ");
        sbuff.append("UNIQUEKEY=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.UNIQUEKEY),4, true)+"\" ");
        sbuff.append("INCLUDESQL=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.INCLUDESQL),4, true)+"\" ");
        sbuff.append("COLTYPE=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.COLTYPE),12, true)+"\" ");
        sbuff.append("FOLLOWJOHN=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.FOLLOWJOHN),4, true)+"\" ");
        sbuff.append("DiffStatus=\"\"");
    sbuff.append(" />\n");  
    return sbuff.toString();
  }

  /**
   * Prints the object out as XML
   * 
   * @exception SQLException
   */
   
    public String toXML_startTag() throws SQLException, RockException {
    final StringBuffer sbuff = new StringBuffer();
    sbuff.append("<Measurementcolumn ");
        sbuff.append("MTABLEID=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.MTABLEID),12, true)+"\" ");
        sbuff.append("DATANAME=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.DATANAME),12, true)+"\" ");
        sbuff.append("COLNUMBER=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.COLNUMBER),2, true)+"\" ");
        sbuff.append("DATATYPE=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.DATATYPE),12, true)+"\" ");
        sbuff.append("DATASIZE=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.DATASIZE),4, true)+"\" ");
        sbuff.append("DATASCALE=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.DATASCALE),4, true)+"\" ");
        sbuff.append("UNIQUEVALUE=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.UNIQUEVALUE),2, true)+"\" ");
        sbuff.append("NULLABLE=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.NULLABLE),4, true)+"\" ");
        sbuff.append("INDEXES=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.INDEXES),12, true)+"\" ");
        sbuff.append("DESCRIPTION=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.DESCRIPTION),12, true)+"\" ");
        sbuff.append("DATAID=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.DATAID),12, true)+"\" ");
        sbuff.append("RELEASEID=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.RELEASEID),12, true)+"\" ");
        sbuff.append("UNIQUEKEY=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.UNIQUEKEY),4, true)+"\" ");
        sbuff.append("INCLUDESQL=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.INCLUDESQL),4, true)+"\" ");
        sbuff.append("COLTYPE=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.COLTYPE),12, true)+"\" ");
        sbuff.append("FOLLOWJOHN=\""+DataValidator.wrap(DataValidator.escapeXML(""+this.FOLLOWJOHN),4, true)+"\" ");
        sbuff.append("DiffStatus=\"\"");
    sbuff.append(" >\n"); 
    return sbuff.toString();
  }

  /**
   * Prints the object out as XML
   * 
   * @exception SQLException
   */
   
    public String toXML_endTag() throws SQLException, RockException {
    final StringBuffer sbuff = new StringBuffer();
    sbuff.append("</Measurementcolumn>\n");
    return sbuff.toString();
  }

  /**
   * Prints the object out as a sql Insert clause
   * 
   * @exception SQLException
   */
   
  public String toSQLInsert(){
       
    final StringBuffer sbuff = new StringBuffer();
    sbuff.append("insert into Measurementcolumn ( ");
	    		sbuff.append("MTABLEID");
		    		sbuff.append(", DATANAME");
	    		sbuff.append(", COLNUMBER");
	    		sbuff.append(", DATATYPE");
	    		sbuff.append(", DATASIZE");
	    		sbuff.append(", DATASCALE");
	    		sbuff.append(", UNIQUEVALUE");
	    		sbuff.append(", NULLABLE");
	    		sbuff.append(", INDEXES");
	    		sbuff.append(", DESCRIPTION");
	    		sbuff.append(", DATAID");
	    		sbuff.append(", RELEASEID");
	    		sbuff.append(", UNIQUEKEY");
	    		sbuff.append(", INCLUDESQL");
	    		sbuff.append(", COLTYPE");
	    		sbuff.append(", FOLLOWJOHN");
	        sbuff.append(" ) values ( ");
    	        sbuff.append(""+DataValidator.wrap(""+this.MTABLEID,12)+"");
        	        sbuff.append(", "+DataValidator.wrap(""+this.DATANAME,12)+"");
    	        sbuff.append(", "+DataValidator.wrap(""+this.COLNUMBER,2)+"");
    	        sbuff.append(", "+DataValidator.wrap(""+this.DATATYPE,12)+"");
    	        sbuff.append(", "+DataValidator.wrap(""+this.DATASIZE,4)+"");
    	        sbuff.append(", "+DataValidator.wrap(""+this.DATASCALE,4)+"");
    	        sbuff.append(", "+DataValidator.wrap(""+this.UNIQUEVALUE,2)+"");
    	        sbuff.append(", "+DataValidator.wrap(""+this.NULLABLE,4)+"");
    	        sbuff.append(", "+DataValidator.wrap(""+this.INDEXES,12)+"");
    	        sbuff.append(", "+DataValidator.wrap(""+this.DESCRIPTION,12)+"");
    	        sbuff.append(", "+DataValidator.wrap(""+this.DATAID,12)+"");
    	        sbuff.append(", "+DataValidator.wrap(""+this.RELEASEID,12)+"");
    	        sbuff.append(", "+DataValidator.wrap(""+this.UNIQUEKEY,4)+"");
    	        sbuff.append(", "+DataValidator.wrap(""+this.INCLUDESQL,4)+"");
    	        sbuff.append(", "+DataValidator.wrap(""+this.COLTYPE,12)+"");
    	        sbuff.append(", "+DataValidator.wrap(""+this.FOLLOWJOHN,4)+"");
    	    sbuff.append(" );\n");   
    return sbuff.toString();
  }
  

   public String getMtableid() { 
    return this.MTABLEID;
  }
   public String getDataname() { 
    return this.DATANAME;
  }
   public Long getColnumber() { 
    return this.COLNUMBER;
  }
   public String getDatatype() { 
    return this.DATATYPE;
  }
   public Integer getDatasize() { 
    return this.DATASIZE;
  }
   public Integer getDatascale() { 
    return this.DATASCALE;
  }
   public Long getUniquevalue() { 
    return this.UNIQUEVALUE;
  }
   public Integer getNullable() { 
    return this.NULLABLE;
  }
   public String getIndexes() { 
    return this.INDEXES;
  }
   public String getDescription() { 
    return this.DESCRIPTION;
  }
   public String getDataid() { 
    return this.DATAID;
  }
   public String getReleaseid() { 
    return this.RELEASEID;
  }
   public Integer getUniquekey() { 
    return this.UNIQUEKEY;
  }
   public Integer getIncludesql() { 
    return this.INCLUDESQL;
  }
   public String getColtype() { 
    return this.COLTYPE;
  }
   public Integer getFollowjohn() { 
    return this.FOLLOWJOHN;
  }
 

  public String gettimeStampName() {
    return timeStampName;
  }

  public String[] getcolumnsAndSequences() {
    return columnsAndSequences;
  }

  public String[] getprimaryKeyNames() {
    return primaryKeyNames;
  }

  public RockFactory getRockFactory() {
    return this.rockFact;
  }

  public void removeNulls() {
     if (MTABLEID == null) {
      MTABLEID = "";
    }
     if (DATANAME == null) {
      DATANAME = "";
    }
     if (COLNUMBER == null) {
      COLNUMBER = new Long (0);
    }
     if (DATATYPE == null) {
      DATATYPE = "";
    }
     if (DATASIZE == null) {
      DATASIZE = new Integer (0);
    }
     if (DATASCALE == null) {
      DATASCALE = new Integer (0);
    }
     if (UNIQUEVALUE == null) {
      UNIQUEVALUE = new Long (0);
    }
     if (NULLABLE == null) {
      NULLABLE = new Integer (0);
    }
     if (INDEXES == null) {
      INDEXES = "";
    }
     if (DESCRIPTION == null) {
      DESCRIPTION = "";
    }
     if (DATAID == null) {
      DATAID = "";
    }
     if (RELEASEID == null) {
      RELEASEID = "";
    }
     if (UNIQUEKEY == null) {
      UNIQUEKEY = new Integer (0);
    }
     if (INCLUDESQL == null) {
      INCLUDESQL = new Integer (0);
    }
     if (COLTYPE == null) {
      COLTYPE = "";
    }
     if (FOLLOWJOHN == null) {
      FOLLOWJOHN = new Integer (0);
    }
   }

   public void setMtableid(final String MTABLEID) {
    if (validateData){
      DataValidator.validateData((Object)MTABLEID,"MTABLEID",12,255,0);
    }
    modifiedColumns.add("MTABLEID");
    this.MTABLEID = MTABLEID;
  }
   public void setDataname(final String DATANAME) {
    if (validateData){
      DataValidator.validateData((Object)DATANAME,"DATANAME",12,128,0);
    }
    modifiedColumns.add("DATANAME");
    this.DATANAME = DATANAME;
  }
   public void setColnumber(final Long COLNUMBER) {
    if (validateData){
      DataValidator.validateData((Object)COLNUMBER,"COLNUMBER",2,9,0);
    }
    modifiedColumns.add("COLNUMBER");
    this.COLNUMBER = COLNUMBER;
  }
   public void setDatatype(final String DATATYPE) {
    if (validateData){
      DataValidator.validateData((Object)DATATYPE,"DATATYPE",12,50,0);
    }
    modifiedColumns.add("DATATYPE");
    this.DATATYPE = DATATYPE;
  }
   public void setDatasize(final Integer DATASIZE) {
    if (validateData){
      DataValidator.validateData((Object)DATASIZE,"DATASIZE",4,10,0);
    }
    modifiedColumns.add("DATASIZE");
    this.DATASIZE = DATASIZE;
  }
   public void setDatascale(final Integer DATASCALE) {
    if (validateData){
      DataValidator.validateData((Object)DATASCALE,"DATASCALE",4,10,0);
    }
    modifiedColumns.add("DATASCALE");
    this.DATASCALE = DATASCALE;
  }
   public void setUniquevalue(final Long UNIQUEVALUE) {
    if (validateData){
      DataValidator.validateData((Object)UNIQUEVALUE,"UNIQUEVALUE",2,9,0);
    }
    modifiedColumns.add("UNIQUEVALUE");
    this.UNIQUEVALUE = UNIQUEVALUE;
  }
   public void setNullable(final Integer NULLABLE) {
    if (validateData){
      DataValidator.validateData((Object)NULLABLE,"NULLABLE",4,10,0);
    }
    modifiedColumns.add("NULLABLE");
    this.NULLABLE = NULLABLE;
  }
   public void setIndexes(final String INDEXES) {
    if (validateData){
      DataValidator.validateData((Object)INDEXES,"INDEXES",12,20,0);
    }
    modifiedColumns.add("INDEXES");
    this.INDEXES = INDEXES;
  }
   public void setDescription(final String DESCRIPTION) {
    if (validateData){
      DataValidator.validateData((Object)DESCRIPTION,"DESCRIPTION",12,32000,0);
    }
    modifiedColumns.add("DESCRIPTION");
    this.DESCRIPTION = DESCRIPTION;
  }
   public void setDataid(final String DATAID) {
    if (validateData){
      DataValidator.validateData((Object)DATAID,"DATAID",12,255,0);
    }
    modifiedColumns.add("DATAID");
    this.DATAID = DATAID;
  }
   public void setReleaseid(final String RELEASEID) {
    if (validateData){
      DataValidator.validateData((Object)RELEASEID,"RELEASEID",12,50,0);
    }
    modifiedColumns.add("RELEASEID");
    this.RELEASEID = RELEASEID;
  }
   public void setUniquekey(final Integer UNIQUEKEY) {
    if (validateData){
      DataValidator.validateData((Object)UNIQUEKEY,"UNIQUEKEY",4,10,0);
    }
    modifiedColumns.add("UNIQUEKEY");
    this.UNIQUEKEY = UNIQUEKEY;
  }
   public void setIncludesql(final Integer INCLUDESQL) {
    if (validateData){
      DataValidator.validateData((Object)INCLUDESQL,"INCLUDESQL",4,10,0);
    }
    modifiedColumns.add("INCLUDESQL");
    this.INCLUDESQL = INCLUDESQL;
  }
   public void setColtype(final String COLTYPE) {
    if (validateData){
      DataValidator.validateData((Object)COLTYPE,"COLTYPE",12,16,0);
    }
    modifiedColumns.add("COLTYPE");
    this.COLTYPE = COLTYPE;
  }
   public void setFollowjohn(final Integer FOLLOWJOHN) {
    if (validateData){
      DataValidator.validateData((Object)FOLLOWJOHN,"FOLLOWJOHN",4,10,0);
    }
    modifiedColumns.add("FOLLOWJOHN");
    this.FOLLOWJOHN = FOLLOWJOHN;
  }
 

  

  public void setcolumnsAndSequences(final String[] newColsAndSeqs) {
    this.columnsAndSequences = newColsAndSeqs;
  }

  /**
   * dbEquals method test wheather the objects primary key values are equal.
   */
  @SuppressWarnings({"PMD.SimplifyBooleanReturns", "PMD.SimplifyBooleanExpressions"})
  public boolean dbEquals(final Measurementcolumn o) {

         if ((((this.MTABLEID == null) || (o.MTABLEID == null)) && (this.MTABLEID != o.MTABLEID))
            || (((this.DATANAME == null) || (o.DATANAME == null)) && (this.DATANAME != o.DATANAME))
          ){
    return false;
    } else
         if ((((this.MTABLEID != null) && (o.MTABLEID != null)) && (this.MTABLEID.equals(o.MTABLEID) == false))
            || (((this.DATANAME != null) && (o.DATANAME != null)) && (this.DATANAME.equals(o.DATANAME) == false))
          ){
    return false;
    } else {
      return true;
    }
  }

  /**
   * equals method test wheather the objects field values and the parametrs objects field values
   * are equal.
   */

  @SuppressWarnings({"PMD.SimplifyBooleanExpressions", "PMD.SimplifyBooleanReturns"})
  public boolean equals(final Measurementcolumn o) {

         if ((((this.MTABLEID == null) || (o.MTABLEID == null)) && (this.MTABLEID != o.MTABLEID))
            || (((this.DATANAME == null) || (o.DATANAME == null)) && (this.DATANAME != o.DATANAME))
            || (((this.COLNUMBER == null) || (o.COLNUMBER == null)) && (this.COLNUMBER != o.COLNUMBER))
            || (((this.DATATYPE == null) || (o.DATATYPE == null)) && (this.DATATYPE != o.DATATYPE))
            || (((this.DATASIZE == null) || (o.DATASIZE == null)) && (this.DATASIZE != o.DATASIZE))
            || (((this.DATASCALE == null) || (o.DATASCALE == null)) && (this.DATASCALE != o.DATASCALE))
            || (((this.UNIQUEVALUE == null) || (o.UNIQUEVALUE == null)) && (this.UNIQUEVALUE != o.UNIQUEVALUE))
            || (((this.NULLABLE == null) || (o.NULLABLE == null)) && (this.NULLABLE != o.NULLABLE))
            || (((this.INDEXES == null) || (o.INDEXES == null)) && (this.INDEXES != o.INDEXES))
            || (((this.DESCRIPTION == null) || (o.DESCRIPTION == null)) && (this.DESCRIPTION != o.DESCRIPTION))
            || (((this.DATAID == null) || (o.DATAID == null)) && (this.DATAID != o.DATAID))
            || (((this.RELEASEID == null) || (o.RELEASEID == null)) && (this.RELEASEID != o.RELEASEID))
            || (((this.UNIQUEKEY == null) || (o.UNIQUEKEY == null)) && (this.UNIQUEKEY != o.UNIQUEKEY))
            || (((this.INCLUDESQL == null) || (o.INCLUDESQL == null)) && (this.INCLUDESQL != o.INCLUDESQL))
            || (((this.COLTYPE == null) || (o.COLTYPE == null)) && (this.COLTYPE != o.COLTYPE))
            || (((this.FOLLOWJOHN == null) || (o.FOLLOWJOHN == null)) && (this.FOLLOWJOHN != o.FOLLOWJOHN))
          ){
    return false;
    } else
         if ((((this.MTABLEID != null) && (o.MTABLEID != null)) && (this.MTABLEID.equals(o.MTABLEID) == false))
            || (((this.DATANAME != null) && (o.DATANAME != null)) && (this.DATANAME.equals(o.DATANAME) == false))
            || (((this.COLNUMBER != null) && (o.COLNUMBER != null)) && (this.COLNUMBER.equals(o.COLNUMBER) == false))
            || (((this.DATATYPE != null) && (o.DATATYPE != null)) && (this.DATATYPE.equals(o.DATATYPE) == false))
            || (((this.DATASIZE != null) && (o.DATASIZE != null)) && (this.DATASIZE.equals(o.DATASIZE) == false))
            || (((this.DATASCALE != null) && (o.DATASCALE != null)) && (this.DATASCALE.equals(o.DATASCALE) == false))
            || (((this.UNIQUEVALUE != null) && (o.UNIQUEVALUE != null)) && (this.UNIQUEVALUE.equals(o.UNIQUEVALUE) == false))
            || (((this.NULLABLE != null) && (o.NULLABLE != null)) && (this.NULLABLE.equals(o.NULLABLE) == false))
            || (((this.INDEXES != null) && (o.INDEXES != null)) && (this.INDEXES.equals(o.INDEXES) == false))
            || (((this.DESCRIPTION != null) && (o.DESCRIPTION != null)) && (this.DESCRIPTION.equals(o.DESCRIPTION) == false))
            || (((this.DATAID != null) && (o.DATAID != null)) && (this.DATAID.equals(o.DATAID) == false))
            || (((this.RELEASEID != null) && (o.RELEASEID != null)) && (this.RELEASEID.equals(o.RELEASEID) == false))
            || (((this.UNIQUEKEY != null) && (o.UNIQUEKEY != null)) && (this.UNIQUEKEY.equals(o.UNIQUEKEY) == false))
            || (((this.INCLUDESQL != null) && (o.INCLUDESQL != null)) && (this.INCLUDESQL.equals(o.INCLUDESQL) == false))
            || (((this.COLTYPE != null) && (o.COLTYPE != null)) && (this.COLTYPE.equals(o.COLTYPE) == false))
            || (((this.FOLLOWJOHN != null) && (o.FOLLOWJOHN != null)) && (this.FOLLOWJOHN.equals(o.FOLLOWJOHN) == false))
          ){
    return false;
    } else {
      return true;
    }
  }
  
  /**
   * to enable a public clone method inherited from Object class (private method)
   */
  public Object clone() {
    Object o = null;
    try {
      o = super.clone();
    } catch (CloneNotSupportedException e) {
    }
    return o;
  }

  /**
   * Is the primakey defined for this table
   */
  public boolean isPrimaryDefined() {
    return this.primaryKeyNames.length > 0;
  }

  /**
   * Sets the member variables to Db default values
   */
  public void setDefaults() {

  }

  /**
   * Does the the object exist in the database
   * 
   * @return boolean true if exists else false.
   */
  public boolean existsDB() throws SQLException, RockException {
    final RockResultSet results = rockFact.setSelectSQL(false, this);
    final Iterator it = rockFact.getData(this, results);
    if (it.hasNext()) {
      results.close();
      return true;
    }
    results.close();
    return false;
  }

  
  /**
  * get columnSize
  * return 255
  */
  public static int getMtableidColumnSize() {
    
     return 255;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getMtableidDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 12
  */
  public static int getMtableidSQLType() {
    
    return 12;   
  }
    
 
  /**
  * get columnSize
  * return 128
  */
  public static int getDatanameColumnSize() {
    
     return 128;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getDatanameDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 12
  */
  public static int getDatanameSQLType() {
    
    return 12;   
  }
    
 
  /**
  * get columnSize
  * return 9
  */
  public static int getColnumberColumnSize() {
    
     return 9;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getColnumberDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 2
  */
  public static int getColnumberSQLType() {
    
    return 2;   
  }
    
 
  /**
  * get columnSize
  * return 50
  */
  public static int getDatatypeColumnSize() {
    
     return 50;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getDatatypeDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 12
  */
  public static int getDatatypeSQLType() {
    
    return 12;   
  }
    
 
  /**
  * get columnSize
  * return 10
  */
  public static int getDatasizeColumnSize() {
    
     return 10;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getDatasizeDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 4
  */
  public static int getDatasizeSQLType() {
    
    return 4;   
  }
    
 
  /**
  * get columnSize
  * return 10
  */
  public static int getDatascaleColumnSize() {
    
     return 10;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getDatascaleDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 4
  */
  public static int getDatascaleSQLType() {
    
    return 4;   
  }
    
 
  /**
  * get columnSize
  * return 9
  */
  public static int getUniquevalueColumnSize() {
    
     return 9;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getUniquevalueDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 2
  */
  public static int getUniquevalueSQLType() {
    
    return 2;   
  }
    
 
  /**
  * get columnSize
  * return 10
  */
  public static int getNullableColumnSize() {
    
     return 10;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getNullableDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 4
  */
  public static int getNullableSQLType() {
    
    return 4;   
  }
    
 
  /**
  * get columnSize
  * return 20
  */
  public static int getIndexesColumnSize() {
    
     return 20;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getIndexesDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 12
  */
  public static int getIndexesSQLType() {
    
    return 12;   
  }
    
 
  /**
  * get columnSize
  * return 32000
  */
  public static int getDescriptionColumnSize() {
    
     return 32000;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getDescriptionDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 12
  */
  public static int getDescriptionSQLType() {
    
    return 12;   
  }
    
 
  /**
  * get columnSize
  * return 255
  */
  public static int getDataidColumnSize() {
    
     return 255;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getDataidDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 12
  */
  public static int getDataidSQLType() {
    
    return 12;   
  }
    
 
  /**
  * get columnSize
  * return 50
  */
  public static int getReleaseidColumnSize() {
    
     return 50;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getReleaseidDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 12
  */
  public static int getReleaseidSQLType() {
    
    return 12;   
  }
    
 
  /**
  * get columnSize
  * return 10
  */
  public static int getUniquekeyColumnSize() {
    
     return 10;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getUniquekeyDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 4
  */
  public static int getUniquekeySQLType() {
    
    return 4;   
  }
    
 
  /**
  * get columnSize
  * return 10
  */
  public static int getIncludesqlColumnSize() {
    
     return 10;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getIncludesqlDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 4
  */
  public static int getIncludesqlSQLType() {
    
    return 4;   
  }
    
 
  /**
  * get columnSize
  * return 16
  */
  public static int getColtypeColumnSize() {
    
     return 16;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getColtypeDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 12
  */
  public static int getColtypeSQLType() {
    
    return 12;   
  }
    
 
  /**
  * get columnSize
  * return 10
  */
  public static int getFollowjohnColumnSize() {
    
     return 10;   
  }

 /**
  * get DecimalDigits
  * return 0
  */
  public static int getFollowjohnDecimalDigits() {
    
     return 0;   
  }
  
 /**
  * get SQLType
  * return 4
  */
  public static int getFollowjohnSQLType() {
    
    return 4;   
  }
    
   public boolean isNewItem() {
    return newItem;
  }

  public void setNewItem(final boolean newItem) {
    this.newItem = newItem;
  }

  public boolean isValidateData() {
    return validateData;
  }

  public void setValidateData(final boolean validateData) {
    this.validateData = validateData;
  }

  public Measurementcolumn getOriginal() {
    return original;
  }
   
  public void setOriginal(final Measurementcolumn original) {
    this.original = (Measurementcolumn) original.clone();
  }
   
  /**
   * Return true if rock object is new, modified or changed
   *
   */ 
  public boolean isUpdated() {
    return isNew() || isModified() || isChanged();
  }
   
  /**
   * Return true if rock object is new 
   *
   */ 
  public boolean isNew() {
    return (original == null);
  }
   
  /**
   * Return true if rock object is modified (values can be same)
   *
   */ 
  public boolean isModified() {
    return (gimmeModifiedColumns().size() > 0);
  }
   
  /**
   * Return true if rock object is changed 
   *
   */ 
  public boolean isChanged() {
    if (original != null) {
    	return (!this.equals(original));
    }
    return false;
  }

}
