CREATE TABLE IF NOT EXISTS OrderT(
                                     ID INT PRIMARY KEY AUTO_INCREMENT,
                                     SHIPPEDFROM INT,
                                     FOREIGN KEY (SHIPPEDFROM) REFERENCES LOCATION(ID),
                                     CUSTOMERID INT,
                                     FOREIGN KEY (CUSTOMERID) REFERENCES Customer(ID),
                                     CREATEDAT DATETIME,
                                     CITY VARCHAR(50),
                                     COUNTRY VARCHAR(50),
                                     STREET VARCHAR(50)
);