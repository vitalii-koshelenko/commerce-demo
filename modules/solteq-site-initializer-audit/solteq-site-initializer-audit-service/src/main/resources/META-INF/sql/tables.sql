create table sq_SIAuditEntry (
	siAuditEntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	siKey VARCHAR(75) null,
	processingTime LONG,
	status INTEGER,
	message VARCHAR(2000) null
);