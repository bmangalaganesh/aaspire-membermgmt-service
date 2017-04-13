INSERT INTO ADDRESS("id","country","line1","line2","post_code", "state", "suburb") VALUES('101','Australia', '68 Drummond Street',' ', '3053', 'VIC', 'Carlton');
INSERT INTO ADDRESS("id","country","line1","line2","post_code", "state", "suburb") VALUES('102','Australia', 'Kay Street',' ', '3053', 'VIC', 'Carlton');
INSERT INTO ADDRESS("id","country","line1","line2","post_code", "state", "suburb") VALUES('103','Australia', '118 Westgarth Street',' ', '3070', 'VIC', 'Northcote');
INSERT INTO ADDRESS("id","country","line1","line2","post_code", "state", "suburb") VALUES('104','Australia', '7 Sherwin Street',' ', '3031', 'VIC', 'Kensington');
INSERT INTO ADDRESS("id","country","line1","line2","post_code", "state", "suburb") VALUES('105','Australia', '10 Dartford Street',' ', '3031', 'VIC', 'Flemington');
INSERT INTO ADDRESS("id","country","line1","line2","post_code", "state", "suburb") VALUES('106','Australia', '369 High Street',' ', '3101', 'VIC', 'Kew');
INSERT INTO ADDRESS("id","country","line1","line2","post_code", "state", "suburb") VALUES('107','Australia', '336 Union Road',' ', '3103', 'VIC', 'Balwyn');
INSERT INTO ADDRESS("id","country","line1","line2","post_code", "state", "suburb") VALUES('108','Australia', '4 Lynch Court',' ', '3103', 'VIC', 'Balwyn');
INSERT INTO ADDRESS("id","country","line1","line2","post_code", "state", "suburb") VALUES('109','Australia', '49 Metung Street',' ', '3103', 'VIC', 'Balwyn');
INSERT INTO ADDRESS("id","country","line1","line2","post_code", "state", "suburb") VALUES('110','Australia', '68 Mary Street',' ', '3101', 'VIC', 'Kew');
INSERT INTO ADDRESS("id","country","line1","line2","post_code", "state", "suburb") VALUES('111','Australia', '9 Belfairs Street',' ', '4109', 'QLD', 'Robertson');
INSERT INTO ADDRESS("id","country","line1","line2","post_code", "state", "suburb") VALUES('112','Australia', '4 Kidd St',' ', '4109', 'QLD', 'Robertson');
INSERT INTO ADDRESS("id","country","line1","line2","post_code", "state", "suburb") VALUES('113','Australia', '38 Keats Street',' ', '4109', 'QLD', 'Sunnybank');
INSERT INTO ADDRESS("id","country","line1","line2","post_code", "state", "suburb") VALUES('114','Australia', '481 Beenleigh Road',' ', '4109', 'QLD', 'Sunnybank');


INSERT INTO MEMBER ("id","date_of_birth","plan","email","given_name","phone_number","status","surname","title","address_id","last_employer","account_balance") VALUES ('201', '1991-01-01','Standard','minerva@bartoletti.net','Eloy','280-643-8136','ACTIVE','Abbott','Mr','101','PWC',10000);
INSERT INTO MEMBER ("id","date_of_birth","plan","email","given_name","phone_number","status","surname","title","address_id","last_employer","account_balance") VALUES ('202', '1992-01-01','Standard','randal@murray.co','Jorge','222-431-2945','ACTIVE','Torp','Mr','102','Melbourne Water',100000);
INSERT INTO MEMBER ("id","date_of_birth","plan","email","given_name","phone_number","status","surname","title","address_id","last_employer","account_balance") VALUES ('203', '1993-01-01','Standard','prince@binspagac.com','Arnold','1-859-310-1845','ACTIVE','Kling','Mr','103','Australian Super',20000);
INSERT INTO MEMBER ("id","date_of_birth","plan","email","given_name","phone_number","status","surname","title","address_id","last_employer","account_balance") VALUES ('204', '1994-01-01','Standard','helena_mueller@bayer.org','Glen','(971) 734-0246','ACTIVE','Bergstrom','Mr','104','Richmond Tigers',15000);
INSERT INTO MEMBER ("id","date_of_birth","plan","email","given_name","phone_number","status","surname","title","address_id","last_employer","account_balance") VALUES ('205', '1995-01-01','Standard','verona_huel@orn.biz','Sylvester','(561) 127-8977','ACTIVE','Boyle','Mr','105','Melbourne Uni',5000);
INSERT INTO MEMBER ("id","date_of_birth","plan","email","given_name","phone_number","status","surname","title","address_id","last_employer","account_balance") VALUES ('206', '1996-01-01','Standard','elwin_herman@reichelhamill.io','Sammy','768-633-0862','ACTIVE','Doyle','Mr','110','United Energy',7000);
INSERT INTO MEMBER ("id","date_of_birth","plan","email","given_name","phone_number","status","surname","title","address_id","last_employer","account_balance") VALUES ('207', '1997-01-01','Standard','brad.bins@lynchkaulke.info','Zoila','0422-337-757','ACTIVE','Cormier','Ms','111','AAPT',10000);
INSERT INTO MEMBER ("id","date_of_birth","plan","email","given_name","phone_number","status","surname","title","address_id","last_employer","account_balance") VALUES ('208', '1998-01-01','Standard','alanis@casperbreitenberg.io','Alessandro','661-987-9857','ACTIVE','Mante','Ms','112','Suncorp',10000);
INSERT INTO MEMBER ("id","date_of_birth","plan","email","given_name","phone_number","status","surname","title","address_id","last_employer","account_balance") VALUES ('209', '1990-01-01','Standard','albina.dickinson@sanfordkozey.info','Dayna','198-871-9021','ACTIVE','Grady','Ms','113','Bluewolf',15000);
INSERT INTO MEMBER ("id","date_of_birth","plan","email","given_name","phone_number","status","surname","title","address_id","last_employer","account_balance") VALUES ('210', '1991-02-02','Standard','ludie_hauck@mann.info','Lennie','781.146.5668','ACTIVE','Keebler','Ms','114','Salesforce',50000);


INSERT INTO IDENTITYINFO ("id","type","document_number","issuer","issue_date","expiry_date","member_id") VALUES ('301', 'LICENSE','3102876208','VIC','1991-02-09','2021-02-02','201');
INSERT INTO IDENTITYINFO ("id","type","document_number","issuer","issue_date","expiry_date","member_id") VALUES ('302', 'LICENSE','3352947972','VIC','1992-02-08','2022-02-02','202');
INSERT INTO IDENTITYINFO ("id","type","document_number","issuer","issue_date","expiry_date","member_id") VALUES ('303', 'LICENSE','1020531875','VIC','1993-02-07','2023-02-02','203');
INSERT INTO IDENTITYINFO ("id","type","document_number","issuer","issue_date","expiry_date","member_id") VALUES ('304', 'LICENSE','5467198322','VIC','1994-02-06','2024-02-02','204');
INSERT INTO IDENTITYINFO ("id","type","document_number","issuer","issue_date","expiry_date","member_id") VALUES ('305', 'LICENSE','6290530115','VIC','1995-02-05','2025-02-02','205');
INSERT INTO IDENTITYINFO ("id","type","document_number","issuer","issue_date","expiry_date","member_id") VALUES ('306', 'LICENSE','5592755795','VIC','1996-02-04','2026-02-02','206');
INSERT INTO IDENTITYINFO ("id","type","document_number","issuer","issue_date","expiry_date","member_id") VALUES ('307', 'LICENSE','8880481027','QLD','1997-02-02','2027-02-02','207');
INSERT INTO IDENTITYINFO ("id","type","document_number","issuer","issue_date","expiry_date","member_id") VALUES ('308', 'LICENSE','2060041410','QLD','1998-02-02','2028-02-02','208');
INSERT INTO IDENTITYINFO ("id","type","document_number","issuer","issue_date","expiry_date","member_id") VALUES ('309', 'LICENSE','2644039823','QLD','1999-02-02','2029-02-02','209');
INSERT INTO IDENTITYINFO ("id","type","document_number","issuer","issue_date","expiry_date","member_id") VALUES ('310', 'LICENSE','5356560542','QLD','1991-03-02','2021-03-02','210');

INSERT INTO IDENTITYINFO ("id","type","document_number","issuer","issue_date","expiry_date","member_id") VALUES ('311', 'PASSPORT','6419916706','VIC','1991-04-02','2021-04-01','201');
INSERT INTO IDENTITYINFO ("id","type","document_number","issuer","issue_date","expiry_date","member_id") VALUES ('312', 'PASSPORT','5261282598','VIC','1991-05-02','2021-05-01','202');
INSERT INTO IDENTITYINFO ("id","type","document_number","issuer","issue_date","expiry_date","member_id") VALUES ('313', 'PASSPORT','7836904477','VIC','1991-06-02','2021-06-01','203');
INSERT INTO IDENTITYINFO ("id","type","document_number","issuer","issue_date","expiry_date","member_id") VALUES ('314', 'PASSPORT','8341816491','VIC','1991-07-02','2021-07-01','204');
INSERT INTO IDENTITYINFO ("id","type","document_number","issuer","issue_date","expiry_date","member_id") VALUES ('315', 'PASSPORT','5005820711','VIC','1991-08-02','2021-08-01','205');










 








