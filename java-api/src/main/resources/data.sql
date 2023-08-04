INSERT INTO Users (user_id, name, email) VALUES (1, 'Alex', 'alex@email.com');
INSERT INTO Users (user_id, name, email) VALUES (2, 'Neeharika', 'neeharika@email.com');
INSERT INTO Users (user_id, name, email) VALUES (3, 'Teodora', 'teodora@email.com');

INSERT INTO Book (book_id, name) VALUES (1, 'trading_book_1');
INSERT INTO Book (book_id, name) VALUES (2, 'trading_book_2');
INSERT INTO Book (book_id, name) VALUES (3, 'trading_book_3');
INSERT INTO Book (book_id, name) VALUES (4, 'trading_book_4');
INSERT INTO Book (book_id, name) VALUES (5, 'trading_book_5');
INSERT INTO Book (book_id, name) VALUES (6, 'trading_book_6');

INSERT INTO BookUser (bookuser_id, book_id, user_id) VALUES (1, 1, 1);
INSERT INTO BookUser (bookuser_id, book_id, user_id) VALUES (2, 2, 1);
INSERT INTO BookUser (bookuser_id, book_id, user_id) VALUES (3, 3, 1);
INSERT INTO BookUser (bookuser_id, book_id, user_id) VALUES (4, 4, 1);
INSERT INTO BookUser (bookuser_id, book_id, user_id) VALUES (5, 1, 2);
INSERT INTO BookUser (bookuser_id, book_id, user_id) VALUES (6, 2, 2);
INSERT INTO BookUser (bookuser_id, book_id, user_id) VALUES (7, 3, 2);


INSERT INTO Security(Security_ID,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,bond_maturity_date,book_id) VALUES (1,'XS1988387210',NULL,'BNPParibasIssu 4,37% Microsoft Corp (USD)',437,'CORP',1000,'USD','active','2021-08-05',1);
INSERT INTO Security(Security_ID,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,bond_maturity_date,book_id) VALUES (2,'USN0280EAR64','123456780','Airbus 3.15%  USD',315,'CORP',900,'USD','active','2021-07-30',2);
INSERT INTO Security(Security_ID,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,bond_maturity_date,book_id) VALUES (3,'A12356111','123456bh0','UBS Facebook (USD)',2,'CORP',900,'USD','active','2021-09-30',3);
INSERT INTO Security(Security_ID,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,bond_maturity_date,book_id) VALUES (4,'A12356111','123456bh0','UBS Facebook (USD)',2,'CORP',900,'USD','active','2021-09-30',2);
INSERT INTO Security(Security_ID,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,bond_maturity_date,book_id) VALUES (5,'USU02320AG12','AMZN 3.15 08/22/27 REGS','Amazon',315,'CORP',900,'USD','active','2021-08-03',4);
INSERT INTO Security(Security_ID,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,bond_maturity_date,book_id) VALUES (6,'GB00B6460505','BDCHBW8','HM Treasury United Kingdon',075,'GOVN',900,'GBP','active','2021-08-09',6);
INSERT INTO Security(Security_ID,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,bond_maturity_date,book_id) VALUES (7,'US87973RAA86','87973RAA8','TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S',202,'SOVN',690,'USD','active','2021-08-06',4);
INSERT INTO Security(Security_ID,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,bond_maturity_date,book_id) VALUES (8,'IE00B29LNP31','87973RAA8','First Norway Alpha Kl.IV',1123,'SOVN',340,'USD','active','2030-12-22',4);


INSERT INTO Counterparty(counterparty_id,name) VALUES (1,'AZ Holdings Inc');
INSERT INTO Counterparty(counterparty_id,name) VALUES (2,'Acme co');
INSERT INTO Counterparty(counterparty_id,name) VALUES (3,'Sovereign Investments');
INSERT INTO Counterparty(counterparty_id,name) VALUES (4,'Astra Trading Ltd');
INSERT INTO Counterparty(counterparty_id,name) VALUES (5,'Muncipal Gov Of Orange County');
INSERT INTO Counterparty(counterparty_id,name) VALUES (6,'Goldman Sachs');
INSERT INTO Counterparty(counterparty_id,name) VALUES (7,'UBS');
INSERT INTO Counterparty(counterparty_id,name) VALUES (8,'Barclays');
INSERT INTO Counterparty(counterparty_id,name) VALUES (9,'British Telecom');
INSERT INTO Counterparty(counterparty_id,name) VALUES (10,'Pension Holdings');
INSERT INTO Counterparty(counterparty_id,name) VALUES (11,'Zurich Pension fund 4');

INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (1,'USD','buy','open',50,90,'2021-08-04','2021-05-13',1,1);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (2,'GBP','sell','open',40,8956,'2021-08-04','2021-02-04',1,1);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (3,'USD','buy','open',1000,105775,'2021-08-23','2021-05-13',2,2);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (4,'GBP','sell','open',900,105775,'2021-09-10','2021-02-04',2,2);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (5,'USD','buy','open',50,90,'2021-08-23','2021-05-13',3,3);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (6,'USD','buy','open',1000,105775,'2021-08-23','2021-05-13',4,2);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (7,'USD','sell','open',50,90,'2021-08-23','2021-05-13',3,4);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (8,'GBP','buy','open',60,9856,'2021-09-27','2021-02-04',5,5);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (9,'USD','buy','open',50,9856,'2021-08-23','2021-08-23',5,5);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (10,'GBP','buy','open',1100,11035,'2021-09-27','2021-09-27',6,6);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (11,'GBP','sell','open',900,11035,'2021-09-28','2021-09-28',6,6);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (12,'GBP','buy','open',2000,11035,'2021-09-29','2021-09-29',7,6);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (13,'GBP','sell','open',2000,11035,'2021-09-30','2021-09-30',7,6);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (14,'GBP','buy','open',1000,11035,'2021-10-01','2021-10-01',8,6);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (15,'GBP','buy','open',900,11035,'2019-10-02','2019-10-02',8,6);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (16,'GBP','sell','open',1900,11035,'2019-10-03','2019-10-03',8,6);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (17,'GBP','buy','open',600,11035,'2018-10-04','2018-10-04',9,6);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (18,'GBP','buy','open',600,11035,'2019-10-05','2019-10-05',10,6);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (19,'GBP','buy','open',700,11035,'2021-06-06','2021-06-06',10,6);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (20,'GBP','sell','open',1300,11035,'2021-10-07','2011-10-07',10,6);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (21,'USD','buy','open',60,10013,'2021-09-27','2012-02-04',11,7);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (22,'USD','buy','open',50,10013,'2021-08-23','2012-08-23',11,7);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (23,'USD','buy','open',75,10013,'2021-09-27','2013-02-04',11,7);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (24,'USD','buy','open',50,10013,'2021-08-23','2014-08-23',11,7);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (25,'USD','buy','open',300,9876,'2021-09-27','2016-02-04',11,8);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (26,'USD','buy','open',300,9876,'2021-08-23','2012-08-23',11,8);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (27,'USD','buy','open',300,9876,'2021-09-27','2013-02-04',11,8);
INSERT INTO Trade(trade_id,currency,type,status,quantity,unit_price,trade_settlement_date,trade_date,counterparty_id,security_id) VALUES (28,'USD','sell','open',300,9876,'2021-08-23','2015-08-23',11,8);
