
CREATE TABLE IF NOT EXISTS Product_Category(

                                               ID INT PRIMARY KEY AUTO_INCREMENT,
                                               NAME VARCHAR(50),
                                               DESCRIPTION VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Supplier(

                                       ID INT PRIMARY KEY AUTO_INCREMENT,
                                       NAME VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Product(

                                      ID INT PRIMARY KEY AUTO_INCREMENT,
                                      NAME VARCHAR(50),
                                      DESCRIPTION VARCHAR(100),
                                      PRICE DECIMAL,
                                      WEIGHT DOUBLE PRECISION,
                                      CATEGORYID INT,
                                      SUPPLIERID INT,
                                      IMAGE_URL VARCHAR(50),
                                      FOREIGN KEY (CATEGORYID) REFERENCES Product_Category(ID),
                                      FOREIGN KEY (SUPPLIERID) REFERENCES Supplier(ID)
);

CREATE TABLE IF NOT EXISTS LOCATION(

                                       ID INT PRIMARY KEY AUTO_INCREMENT,
                                       NAME VARCHAR(50),
                                       COUNTRY VARCHAR(50),
                                       CITY VARCHAR(50),
                                       COUNTY VARCHAR(50),
                                       STREET VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Stock(

                                    PRODUCTID INT,
                                    LOCATIONID INT,
                                    QUANTITY INT,
                                    FOREIGN KEY (PRODUCTID) REFERENCES Product(ID),
                                    FOREIGN KEY (LOCATIONID) REFERENCES LOCATION(ID),
                                    CONSTRAINT PK_Stock PRIMARY KEY (PRODUCTID, LOCATIONID)
);

CREATE TABLE  IF NOT EXISTS Customer(

                                        ID INT PRIMARY KEY AUTO_INCREMENT,
                                        FIRSTNAME VARCHAR(50),
                                        LASTNAME VARCHAR(50),
                                        USERNAME VARCHAR(50),
                                        PASSWORD VARCHAR(50),
                                        EMAIL VARCHAR(50)
);

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

CREATE TABLE IF NOT EXISTS OrderDetails(

                                           PRODUCTID INT,
                                           ORDERID INT,
                                           FOREIGN KEY (PRODUCTID) REFERENCES Product(ID),
                                           FOREIGN KEY (ORDERID) REFERENCES OrderT(ID),
                                           CONSTRAINT PK_Order PRIMARY KEY (PRODUCTID, ORDERID)
);

CREATE TABLE IF NOT EXISTS Revenue(
                                      ID INT PRIMARY KEY AUTO_INCREMENT,
                                      LOCATIONID INT,
                                      FOREIGN KEY (LOCATIONID) REFERENCES LOCATION(ID),
                                      DATE DATETIME,
                                      SUM DECIMAL
);