CREATE TABLE TRAINS (
  ID INTEGER IDENTITY PRIMARY KEY,
  BUSINESS_ID VARCHAR(30) NOT NULL,
  ORIGIN VARCHAR(50) NOT NULL,
  DESTINATION VARCHAR(50) NOT NULL,
  DEPARTURE TIMESTAMP NOT NULL,
  ARRIVAL TIMESTAMP NOT NULL
);

CREATE TABLE PRICEOFFERS (
  ID INTEGER IDENTITY PRIMARY KEY,
  OFFER_NAME VARCHAR(30) NOT NULL,
  TRAVEL_CLASS VARCHAR(255) NOT NULL,
  PRICE DECIMAL(5, 2) NOT NULL,
  CURRENCY VARCHAR(3) NOT NULL,
  OFFER_TRAIN_ID INTEGER NOT NULL,

  CONSTRAINT FK_OFFER_TRAINS FOREIGN KEY (OFFER_TRAIN_ID) REFERENCES TRAINS (ID)
);

CREATE TABLE FARERULES (
  ID VARCHAR(100) NOT NULL,
  RULE VARCHAR(255) NOT NULL,
  PRICE_OFFER INTEGER NOT NULL,

  CONSTRAINT PK_FARERULES PRIMARY KEY (ID),
  CONSTRAINT FK_PRICEOFFERS FOREIGN KEY (PRICE_OFFER) REFERENCES PRICEOFFERS (ID)
);

CREATE TABLE CARRIAGE_SEATS (
  ID INTEGER IDENTITY PRIMARY KEY,
  CARRIAGE_NUMBER INTEGER NOT NULL,
  SEATS_TRAIN_ID INTEGER NOT NULL,
  TRAVEL_CLASS VARCHAR(255) NOT NULL,

  CONSTRAINT FK_SEATS_TRAINS FOREIGN KEY (SEATS_TRAIN_ID) REFERENCES TRAINS (ID)
);

CREATE TABLE SEATS (
  ID INTEGER IDENTITY PRIMARY KEY,
  NAME VARCHAR(4) NOT NULL,
  CARRIAGE_ID INTEGER,
  AVAILABLE BOOLEAN DEFAULT TRUE,

  CONSTRAINT FK_CARRIAGE_SEATS FOREIGN KEY (CARRIAGE_ID) REFERENCES CARRIAGE_SEATS (ID)
);
