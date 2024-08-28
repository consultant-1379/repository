insert into META_DATABASES (USERNAME, VERSION_NUMBER, TYPE_NAME, CONNECTION_ID, CONNECTION_NAME, CONNECTION_STRING, PASSWORD, DESCRIPTION, DRIVER_NAME, DB_LINK_NAME) values ('SA', '0', 'USER', 1, 'dwhrep', 'jdbc:hsqldb:mem:dwhrep', '', 'DWH Repository Database', 'org.hsqldb.jdbcDriver', null);

insert into DATAINTERFACE (INTERFACENAME, STATUS, INTERFACETYPE, DESCRIPTION, DATAFORMATTYPE, INTERFACEVERSION, LOCKEDBY, LOCKDATE, PRODUCTNUMBER, ENIQ_LEVEL, RSTATE) values ('INTF_DIM_E_GRAN_SCGR', 1, 'measurement', '', 'ascii', '((102))', null, null, null, '2.0', 'R22A');

insert into InterfaceMeasurement (TAGID, DATAFORMATID, INTERFACENAME, TRANSFORMERID, STATUS, MODIFTIME, DESCRIPTION, TECHPACKVERSION, INTERFACEVERSION) values ('SCGR', 'DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR:ascii', 'INTF_DIM_E_GRAN_SCGR', 'DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR:ascii', 1, '2010-05-18 02:08:11', 'Default tags for DIM_E_GRAN_SCGR in DIM_E_GRAN:((6)) with format ascii.', 'N/A', '((102))');

insert into DataFormat (DATAFORMATID, TYPEID, VERSIONID, OBJECTTYPE, FOLDERNAME, DATAFORMATTYPE) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR:ascii', 'DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR', 'DIM_E_GRAN:((6))', 'Reference', 'DIM_E_GRAN_SCGR', 'ascii');

insert into ReferenceColumn (TYPEID, DATANAME, COLNUMBER, DATATYPE, DATASIZE, DATASCALE, UNIQUEVALUE, NULLABLE, INDEXES, UNIQUEKEY, INCLUDESQL, INCLUDEUPD, COLTYPE, DESCRIPTION, UNIVERSECLASS, UNIVERSEOBJECT, UNIVERSECONDITION, DATAID, BASEDEF) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR', 'BSC_NAME', 102, 'varchar', 35, 0, 255, 1, 'HG', 1, 1, 1, 'COLUMN', '', null, null, null, 'bscName', 0);
insert into ReferenceColumn (TYPEID, DATANAME, COLNUMBER, DATATYPE, DATASIZE, DATASCALE, UNIQUEVALUE, NULLABLE, INDEXES, UNIQUEKEY, INCLUDESQL, INCLUDEUPD, COLTYPE, DESCRIPTION, UNIVERSECLASS, UNIVERSEOBJECT, UNIVERSECONDITION, DATAID, BASEDEF) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR', 'CREATED', 108, 'datetime', 0, 0, 255, 1, 'HG', 0, 1, 0, 'PUBLICCOL', null, null, null, null, null, 1);
insert into ReferenceColumn (TYPEID, DATANAME, COLNUMBER, DATATYPE, DATASIZE, DATASCALE, UNIQUEVALUE, NULLABLE, INDEXES, UNIQUEKEY, INCLUDESQL, INCLUDEUPD, COLTYPE, DESCRIPTION, UNIVERSECLASS, UNIVERSEOBJECT, UNIVERSECONDITION, DATAID, BASEDEF) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR', 'MODIFIED', 109, 'datetime', 0, 0, 255, 1, 'HG', 0, 1, 1, 'PUBLICCOL', null, null, null, null, null, 1);
insert into ReferenceColumn (TYPEID, DATANAME, COLNUMBER, DATATYPE, DATASIZE, DATASCALE, UNIQUEVALUE, NULLABLE, INDEXES, UNIQUEKEY, INCLUDESQL, INCLUDEUPD, COLTYPE, DESCRIPTION, UNIVERSECLASS, UNIVERSEOBJECT, UNIVERSECONDITION, DATAID, BASEDEF) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR', 'MODIFIER', 110, 'varchar', 32, 0, 255, 1, 'HG', 0, 1, 1, 'PUBLICCOL', null, null, null, null, null, 1);
insert into ReferenceColumn (TYPEID, DATANAME, COLNUMBER, DATATYPE, DATASIZE, DATASCALE, UNIQUEVALUE, NULLABLE, INDEXES, UNIQUEKEY, INCLUDESQL, INCLUDEUPD, COLTYPE, DESCRIPTION, UNIVERSECLASS, UNIVERSEOBJECT, UNIVERSECONDITION, DATAID, BASEDEF) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR', 'NO_ABIS_DEV', 105, 'int', 0, 0, 255, 1, 'HG', 0, 1, 1, 'COLUMN', '', null, null, null, 'numberOfAbisDevices', 0);
insert into ReferenceColumn (TYPEID, DATANAME, COLNUMBER, DATATYPE, DATASIZE, DATASCALE, UNIQUEVALUE, NULLABLE, INDEXES, UNIQUEKEY, INCLUDESQL, INCLUDEUPD, COLTYPE, DESCRIPTION, UNIVERSECLASS, UNIVERSEOBJECT, UNIVERSECONDITION, DATAID, BASEDEF) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR', 'OSS_ID', 101, 'varchar', 50, 0, 255, 1, 'HG', 1, 1, 1, 'COLUMN', '', null, null, null, 'OSS_ID', 0);
insert into ReferenceColumn (TYPEID, DATANAME, COLNUMBER, DATATYPE, DATASIZE, DATASCALE, UNIQUEVALUE, NULLABLE, INDEXES, UNIQUEKEY, INCLUDESQL, INCLUDEUPD, COLTYPE, DESCRIPTION, UNIVERSECLASS, UNIVERSEOBJECT, UNIVERSECONDITION, DATAID, BASEDEF) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR', 'SC', 104, 'varchar', 35, 0, 255, 1, 'HG', 1, 1, 1, 'COLUMN', '', null, null, null, 'superChannel', 0);
insert into ReferenceColumn (TYPEID, DATANAME, COLNUMBER, DATATYPE, DATASIZE, DATASCALE, UNIQUEVALUE, NULLABLE, INDEXES, UNIQUEKEY, INCLUDESQL, INCLUDEUPD, COLTYPE, DESCRIPTION, UNIVERSECLASS, UNIVERSEOBJECT, UNIVERSECONDITION, DATAID, BASEDEF) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR', 'SCGR', 103, 'varchar', 35, 0, 255, 1, 'HG', 1, 1, 1, 'COLUMN', '', null, null, null, 'superChannelGroup', 0);
insert into ReferenceColumn (TYPEID, DATANAME, COLNUMBER, DATATYPE, DATASIZE, DATASCALE, UNIQUEVALUE, NULLABLE, INDEXES, UNIQUEKEY, INCLUDESQL, INCLUDEUPD, COLTYPE, DESCRIPTION, UNIVERSECLASS, UNIVERSEOBJECT, UNIVERSECONDITION, DATAID, BASEDEF) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR', 'STATUS', 107, 'varchar', 16, 0, 255, 1, 'HG', 0, 1, 1, 'PUBLICCOL', null, null, null, null, null, 1);
insert into ReferenceColumn (TYPEID, DATANAME, COLNUMBER, DATATYPE, DATASIZE, DATASCALE, UNIQUEVALUE, NULLABLE, INDEXES, UNIQUEKEY, INCLUDESQL, INCLUDEUPD, COLTYPE, DESCRIPTION, UNIVERSECLASS, UNIVERSEOBJECT, UNIVERSECONDITION, DATAID, BASEDEF) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR', 'VENDOR', 106, 'varchar', 16, 0, 255, 1, 'HG', 0, 1, 1, 'PUBLICCOL', null, null, null, null, null, 1);

insert into DataItem (DATAFORMATID, DATANAME, COLNUMBER, DATAID, PROCESS_INSTRUCTION, DATATYPE, DATASIZE, DATASCALE) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR:ascii', 'BSC_NAME', 102, 'bscName', '', 'varchar', 35, 0);          
insert into DataItem (DATAFORMATID, DATANAME, COLNUMBER, DATAID, PROCESS_INSTRUCTION, DATATYPE, DATASIZE, DATASCALE) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR:ascii', 'CREATED', 108, 'CREATED', '', 'datetime', 0, 0);           
insert into DataItem (DATAFORMATID, DATANAME, COLNUMBER, DATAID, PROCESS_INSTRUCTION, DATATYPE, DATASIZE, DATASCALE) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR:ascii', 'MODIFIED', 109, 'MODIFIED', '', 'datetime', 0, 0);         
insert into DataItem (DATAFORMATID, DATANAME, COLNUMBER, DATAID, PROCESS_INSTRUCTION, DATATYPE, DATASIZE, DATASCALE) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR:ascii', 'MODIFIER', 110, 'MODIFIER', '', 'varchar', 32, 0);         
insert into DataItem (DATAFORMATID, DATANAME, COLNUMBER, DATAID, PROCESS_INSTRUCTION, DATATYPE, DATASIZE, DATASCALE) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR:ascii', 'NO_ABIS_DEV', 105, 'numberOfAbisDevices', '', 'int', 0, 0);
insert into DataItem (DATAFORMATID, DATANAME, COLNUMBER, DATAID, PROCESS_INSTRUCTION, DATATYPE, DATASIZE, DATASCALE) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR:ascii', 'OSS_ID', 101, 'OSS_ID', '', 'varchar', 50, 0);             
insert into DataItem (DATAFORMATID, DATANAME, COLNUMBER, DATAID, PROCESS_INSTRUCTION, DATATYPE, DATASIZE, DATASCALE) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR:ascii', 'SC', 104, 'superChannel', '', 'varchar', 35, 0);           
insert into DataItem (DATAFORMATID, DATANAME, COLNUMBER, DATAID, PROCESS_INSTRUCTION, DATATYPE, DATASIZE, DATASCALE) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR:ascii', 'SCGR', 103, 'superChannelGroup', '', 'varchar', 35, 0);    
insert into DataItem (DATAFORMATID, DATANAME, COLNUMBER, DATAID, PROCESS_INSTRUCTION, DATATYPE, DATASIZE, DATASCALE) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR:ascii', 'STATUS', 107, 'STATUS', '', 'varchar', 16, 0);             
insert into DataItem (DATAFORMATID, DATANAME, COLNUMBER, DATAID, PROCESS_INSTRUCTION, DATATYPE, DATASIZE, DATASCALE) values ('DIM_E_GRAN:((6)):DIM_E_GRAN_SCGR:ascii', 'VENDOR', 106, 'VENDOR', '', 'varchar', 16, 0);             