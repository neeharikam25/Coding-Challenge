DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS BookUser;
DROP TABLE IF EXISTS Counterparty;
DROP TABLE IF EXISTS Security;
DROP TABLE IF EXISTS Trade;


CREATE TABLE Users (
    user_id INT NOT NULL,
    name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,

    PRIMARY KEY(user_id)
);

CREATE TABLE Book (
    book_id INT NOT NULL,
    name VARCHAR(250) NOT NULL ,

    PRIMARY KEY(book_id)
);

CREATE TABLE BookUser (
    bookuser_id INT NOT NULL,
    book_id INT NOT NULL,
    user_id INT NOT NULL,

    FOREIGN KEY (book_id) REFERENCES Book(book_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    PRIMARY KEY ( bookuser_id)
);

CREATE TABLE Security (

    security_id INT NOT NULL,
    isin VARCHAR(250) NOT NULL,
    cusip VARCHAR(250) DEFAULT NULL,
    issuer_name VARCHAR(250) NOT NULL,
    coupon FLOAT NOT NULL,
    security_type VARCHAR(250) NOT NULL,
    face_value FLOAT NOT NULL,
    security_currency VARCHAR(10) NOT NULL,
    security_status VARCHAR(10) NOT NULL,
    bond_maturity_date DATE NOT NULL,
    book_id INT NOT NULL,


    FOREIGN KEY (book_id) REFERENCES Book(book_id),
    PRIMARY KEY ( security_id)
);

CREATE TABLE Counterparty (

    counterparty_id INT NOT NULL,
    name VARCHAR(250) NOT NULL,

    PRIMARY KEY  (counterparty_id)
);


CREATE TABLE Trade (

    trade_id INT NOT NULL,
    currency VARCHAR(10) NOT NULL,
    type  VARCHAR(250) NOT NULL,
    status VARCHAR(10) NOT NULL,
    quantity FLOAT NOT NULL,
    unit_price FLOAT NOT NULL,
    trade_settlement_date DATE NOT NULL,
    trade_date DATE NOT NULL,
    counterparty_id INT NOT NULL,
    security_id INT NOT NULL,

    FOREIGN KEY (security_id) REFERENCES Security(security_id),
    FOREIGN KEY (counterparty_id) REFERENCES Counterparty(counterparty_id),
    PRIMARY KEY ( trade_id)
);


