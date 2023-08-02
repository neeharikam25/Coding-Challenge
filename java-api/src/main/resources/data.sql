INSERT INTO Users (user_id, name, email) VALUES (1, 'Alex', 'alex@email');
INSERT INTO Users (user_id, name, email) VALUES (2, 'Neeharika', 'neeharika@email');
INSERT INTO Users (user_id, name, email) VALUES (3, 'Teodora', 'teodora@email');

INSERT INTO Book (book_id, name) VALUES (1, 'trading_book_1');
INSERT INTO Book (book_id, name) VALUES (2, 'trading_book_2');
INSERT INTO Book (book_id, name) VALUES (3, 'trading_book_3');
INSERT INTO Book (book_id, name) VALUES (4, 'trading_book_4');
INSERT INTO Book (book_id, name) VALUES (5, 'trading_book_5');
INSERT INTO Book (book_id, name) VALUES (6, 'trading_book_6');

INSERT INTO BookUser ( book_id, user_id) VALUES ( 1, 1);
INSERT INTO BookUser ( book_id, user_id) VALUES ( 2, 1);
INSERT INTO BookUser ( book_id, user_id) VALUES ( 3, 1);
INSERT INTO BookUser ( book_id, user_id) VALUES ( 4, 1);
INSERT INTO BookUser ( book_id, user_id) VALUES ( 1, 2);
INSERT INTO BookUser ( book_id, user_id) VALUES ( 2, 2);
INSERT INTO BookUser ( book_id, user_id) VALUES ( 3, 2);

INSERT INTO Security(security_id,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,book_id) VALUES (1,'XS1988387210',NULL,'BNPParibasIssu 4,37% Microsoft Corp (USD)',437,'CORP',1000,'USD','active',1);
INSERT INTO Security(security_id,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,book_id) VALUES (2,'USN0280EAR64','123456780','Airbus 3.15%  USD',315,'CORP',900,'USD','active',2);
INSERT INTO Security(security_id,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,book_id) VALUES (3,'A12356111','123456bh0','UBS Facebook (USD)',2,'CORP',900,'USD','active',3);
INSERT INTO Security(security_id,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,book_id) VALUES (4,'A12356111','123456bh0','UBS Facebook (USD)',2,'CORP',900,'USD','active',2);
INSERT INTO Security(security_id,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,book_id) VALUES (5,'USU02320AG12','AMZN 3.15 08/22/27 REGS','Amazon',315,'CORP',900,'USD','active',4);
INSERT INTO Security(security_id,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,book_id) VALUES (6,'GB00B6460505','BDCHBW8','HM Treasury United Kingdon',075,'GOVN',900,'GBP','active',6);
INSERT INTO Security(security_id,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,book_id) VALUES (7,'US87973RAA86','87973RAA8','TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S',202,'SOVN',690,'USD','active',4);
INSERT INTO Security(security_id,isin,cusip,issuer_name,coupon,security_type,face_value,security_currency,security_status,book_id) VALUES (8,'IE00B29LNP31','87973RAA8','First Norway Alpha Kl.IV',1123,'SOVN',340,'USD','active',4);

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




