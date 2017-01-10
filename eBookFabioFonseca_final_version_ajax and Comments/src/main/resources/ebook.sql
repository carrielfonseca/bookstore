DROP DATABASE IF EXISTS EBOOK;

CREATE DATABASE EBOOK;

USE EBOOK;

GRANT ALL  ON EBOOK TO "root"@"%" IDENTIFIED BY "anaefabio";

GRANT ALL  ON EBOOK TO "root"@"localhost" IDENTIFIED BY "anaefabio";

DROP TABLE IF EXISTS BOOK_INVENTORY;

CREATE TABLE BOOK_INVENTORY(
  ISBN_NUMBER int(11)  AUTO_INCREMENT,
  TITLE varchar(30)  DEFAULT '',
  AUTHOR varchar(30)  DEFAULT '',
  PUBLISHER varchar(60)  DEFAULT '',
  NUMBER_OF_PAGES INT(11) DEFAULT NULL,
  GENRE varchar(20)  DEFAULT '',
  IMAGE  varchar(20) DEFAULT NULL,
  WHOLE_SALE_PRICE double DEFAULT NULL,
  LIST_PRICE  double DEFAULT NULL,
  DATE_ENTERED_INTO_INVENTORY datetime DEFAULT NULL,
  REMOVAL_STATUS boolean DEFAULT NULL,
  NUMBER_OF_UNITS int(11) ,
  PRIMARY KEY (ISBN_NUMBER)
) ENGINE=InnoDB;



DROP TABLE IF EXISTS CUSTOMER_REVIEWS;

CREATE TABLE CUSTOMER_REVIEWS (
  ID int(11)  AUTO_INCREMENT,
  ISBN_NUMBER int(11) ,
  DATE_OF_REVIEW datetime DEFAULT NULL,
  CLIENT_NAME varchar(60),
  RATING int(11),
  REVIEW_TEXT varchar(700),
  APPROVAL_STATUS boolean DEFAULT 0,
  PRIMARY KEY (ID),
  FOREIGN KEY (ISBN_NUMBER) REFERENCES BOOK_INVENTORY(ISBN_NUMBER)
) ENGINE=InnoDB;


DROP TABLE IF EXISTS CLIENTS;

CREATE TABLE CLIENTS (
  CLIENT_NUMBER int(11)  AUTO_INCREMENT,
  LAST_NAME varchar(60),
  FIRST_NAME varchar(60),
  USERNAME varchar(60),
  PASSWORD varchar(60),
  COMPANY_NAME varchar(60),
  ADDRESS_1 varchar(60),
  ADDRESS_2 varchar(60),
  CITY varchar(60),
  PROVINCE varchar(60),
  POSTAL_CODE varchar(60),
  HOME_TELEPHONE varchar(60),
  CELL_PHONE varchar(60),
  EMAIL varchar(60),  
  PRIMARY KEY (CLIENT_NUMBER)
) ENGINE=InnoDB;


DROP TABLE IF EXISTS INVOICE;

CREATE TABLE INVOICE (
  SALE_NUMBER int(11)  AUTO_INCREMENT,
  CLIENT_NUMBER int(11),
  DATE_OF_SALE datetime DEFAULT NULL,
  TOTAL_NET_VALUE double,
  GST double,
  TOTAL_GROSS_VALUE double,  
  PRIMARY KEY (SALE_NUMBER),
  FOREIGN KEY (CLIENT_NUMBER) REFERENCES CLIENTS(CLIENT_NUMBER)
) ENGINE=InnoDB;


DROP TABLE IF EXISTS INVOICE_DETAILS;

CREATE TABLE INVOICE_DETAILS (
  ID int(11)  AUTO_INCREMENT,
  SALE_NUMBER int(11),
  ISBN_NUMBER int(11), 
  PRICE  double,
  PRIMARY KEY (ID),
  FOREIGN KEY (SALE_NUMBER) REFERENCES INVOICE(SALE_NUMBER)
) ENGINE=InnoDB;


--------------------------------------------------------------

INSERT INTO BOOK_INVENTORY ( TITLE, AUTHOR, PUBLISHER, NUMBER_OF_PAGES, GENRE, IMAGE, 
WHOLE_SALE_PRICE, LIST_PRICE, DATE_ENTERED_INTO_INVENTORY, REMOVAL_STATUS, NUMBER_OF_UNITS) values 

("The House of Atreus","Aeschylus","Penguin Books", 221,"Drama", "img1.jpg", 10.0, 14.0, "2014-01-23 0:00:00", 0, 5),
("Dramatiska arbeten","Alfhilf Agreli","Penguin Books", 303,"Drama", "img2.jpg", 12.0, 17.0, "2012-09-22 0:00:00", 0, 7),
("Octavia","Vittorio Alfieri","Penguin Books", 251,"Drama", "img3.jpg", 32.0, 44.0, "2010-04-30 0:00:00", 0, 3),
("The Birds","Aristophanes","Conrad", 111,"Drama", "img4.jpg", 50.0, 70.0, "2009-05-10 0:00:00", 0, 2),
("The StepMother","Balzac","Lyrics Pub Books", 550,"Drama", "img5.jpg", 22.0, 33.0, "2009-05-10 0:00:00", 0, 2),
("The Arabian Nights","Anonymous","Lyrics Pub Books", 307,"Fantasy", "img6.jpg", 20.0, 25.0, "2007-06-10 0:00:00", 0, 2),
("The Master Key","Frank Baum","Journey Pub Books", 404, "Fantasy", "img7.jpg", 15.0, 20.0, "2007-08-22 0:00:00", 0, 2),
("The Ghost","Arnold Bennet","Journey Pub Books", 203, "Fantasy", "img8.jpg", 8.0, 16.0, "2010-10-11 0:00:00", 0, 2),
("Living Alone","Stella Benson","Sad Pub Books", 307, "Fantasy", "img9.jpg", 30.0, 35.0, "2012-04-15 0:00:00", 0, 2),
("Alice in Wonderland","Lewis Carroll","Wonder Pub Books", 220, "Fantasy", "img10.jpg", 5.0, 70.0, "2007-08-22 0:00:00", 0, 2),
("Rollo in Holland","Jacob Abbott","Penguin Books", 221,"Adventure", "img11.jpg", 10.0, 14.0, "2014-01-23 0:00:00", 0, 5),
("David Crockett","John Aboott","Penguin Books", 303,"Adventure", "img12.jpg", 12.0, 17.0, "2012-09-22 0:00:00", 0, 7),
("In a New World","Horatio Alger","Penguin Books", 251,"Adventure", "img13.jpg", 32.0, 44.0, "2010-04-30 0:00:00", 0, 3),
("The Great Taboo","Grant Allen","Conrad", 111,"Adventure", "img14.jpg", 50.0, 70.0, "2009-05-10 0:00:00", 0, 2),
("The Outdoor Chums","Quincy Allen","Lyrics Pub Books", 550,"Adventure", "img15.jpg", 22.0, 33.0, "2009-05-10 0:00:00", 0, 2),
("Beowulf","Anonymous","Lyrics Pub Books", 307,"Epic", "img16.jpg", 20.0, 25.0, "2007-06-10 0:00:00", 0, 2),
("The Iliad","Homer","Journey Pub Books", 404, "Epic", "img17.jpg", 15.0, 20.0, "2007-08-22 0:00:00", 0, 2),
("The Odyssey","Homer","Journey Pub Books", 203, "Epic", "img18.jpg", 8.0, 16.0, "2010-10-11 0:00:00", 0, 2),
("Paradise Lost","John Milton","Sad Pub Books", 307, "Epic", "img19.jpg", 30.0, 35.0, "2012-04-15 0:00:00", 0, 2),
("The Divine Comedy","Dante","Wonder Pub Books", 220, "Epic", "img20.jpg", 5.0, 70.0, "2007-08-22 0:00:00", 0, 2);

INSERT INTO CLIENTS (LAST_NAME, FIRST_NAME, USERNAME, PASSWORD, COMPANY_NAME, ADDRESS_1, ADDRESS_2, CITY, 
PROVINCE, POSTAL_CODE, HOME_TELEPHONE, CELL_PHONE, EMAIL) values

("Fonseca","Fabio", "consumer", "concordia", "Concordia Ltd", "6695 Ste Catherine", "Suite 1", "Montreal", "Quebec",
"H3S K4H", "555-7171", "555-1234", "fabio@gmail.com"),
("Fogel","Ken", "manager", "concordia", "Concordia Ltd", "6695 Ste Catherine", "Suite 2", "Montreal", "Quebec",
"2H3 2G1", "555-4545", "555-7777", "fogel@gmail.com");

