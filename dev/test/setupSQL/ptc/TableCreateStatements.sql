CREATE TABLE META_DATABASES (
	USERNAME VARCHAR(30),
	VERSION_NUMBER VARCHAR(32),
	TYPE_NAME VARCHAR(15),
	CONNECTION_ID NUMERIC(38),
	CONNECTION_NAME VARCHAR(30), 
	CONNECTION_STRING VARCHAR(200), 
	PASSWORD VARCHAR(30), 
	DESCRIPTION VARCHAR(32000), 
	DRIVER_NAME VARCHAR(100), 
	DB_LINK_NAME VARCHAR(128)
);

CREATE TABLE DWHPartition (
	STORAGEID VARCHAR(255),
	TABLENAME VARCHAR(255),
	STARTTIME TIMESTAMP,
	ENDTIME TIMESTAMP,
	STATUS VARCHAR(10),
	LOADORDER INTEGER
);
CREATE TABLE PartitionPlan (
	PARTITIONPLAN VARCHAR(128),
	DEFAULTSTORAGETIME NUMERIC(20),
	DEFAULTPARTITIONSIZE NUMERIC(20),
	MAXSTORAGETIME NUMERIC(20),
	PARTITIONTYPE TINYINT
);
CREATE TABLE DWHType (
	TECHPACK_NAME VARCHAR(30),
	TYPENAME VARCHAR(255),
	TABLELEVEL VARCHAR(50),
	STORAGEID VARCHAR(255),
	PARTITIONSIZE NUMERIC(9),
	PARTITIONCOUNT NUMERIC(9),
	STATUS VARCHAR(50),
	TYPE VARCHAR(50),
	OWNER VARCHAR(50),
	VIEWTEMPLATE VARCHAR(255),
	CREATETEMPLATE VARCHAR(255),
	NEXTPARTITIONTIME TIMESTAMP,
	BASETABLENAME VARCHAR(125),
	DATADATECOLUMN VARCHAR(128),
	PUBLICVIEWTEMPLATE VARCHAR(255),
	PARTITIONPLAN VARCHAR(128)
);
CREATE TABLE TPActivation (
	TECHPACK_NAME VARCHAR(30),
	STATUS VARCHAR(10),
	VERSIONID VARCHAR(128),
	TYPE VARCHAR(10),
	MODIFIED INTEGER
);
CREATE TABLE TypeActivation (
	TECHPACK_NAME VARCHAR(30),
	STATUS VARCHAR(10),
	TYPENAME VARCHAR(255),
	TABLELEVEL VARCHAR(50),
	STORAGETIME NUMERIC(15),
	TYPE VARCHAR(12),
	PARTITIONPLAN VARCHAR(128)
);