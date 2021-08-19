alter table AccessRulesData drop constraint FKABB4C1DFDBBC970;
alter table AdminEntityData drop constraint FKD9A99EBCB3A110AD;
drop table if exists AccessRulesData cascade;
drop table if exists AdminEntityData cascade;
drop table if exists AdminGroupData cascade;
drop table if exists AdminPreferencesData cascade;
drop table if exists ApprovalData cascade;
drop table if exists AuditRecordData cascade;
drop table if exists AuthorizationTreeUpdateData cascade;
drop table if exists Base64CertData cascade;
drop table if exists CAData cascade;
drop table if exists CRLData cascade;
drop table if exists CertReqHistoryData cascade;
drop table if exists CertificateData cascade;
drop table if exists CertificateProfileData cascade;
drop table if exists CryptoTokenData cascade;
drop table if exists EndEntityProfileData cascade;
drop table if exists GlobalConfigurationData cascade;
drop table if exists InternalKeyBindingData cascade;
drop table if exists KeyRecoveryData cascade;
drop table if exists PeerData cascade;
drop table if exists ProfileData cascade;
drop table if exists PublisherData cascade;
drop table if exists PublisherQueueData cascade;
drop table if exists BlacklistData cascade;
drop table if exists RoleData cascade;
drop table if exists RoleMemberData cascade;
drop table if exists ServiceData cascade;
drop table if exists UserData cascade;
drop table if exists UserDataSourceData cascade;
drop table if exists NoConflictCertificateData cascade;
drop table if exists AcmeAuthorizationData cascade;
drop table if exists AcmeChallengeData cascade;
drop table if exists AcmeNonceData cascade;
drop table if exists AcmeAccountData cascade;
drop table if exists AcmeOrderData cascade;
drop table if exists SctData cascade;
drop table if exists OcspResponseData cascade;