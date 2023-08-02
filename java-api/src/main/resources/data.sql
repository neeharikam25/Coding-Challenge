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

