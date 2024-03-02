
CREATE DATABASE PsiAplikacija;


use PsiAplikacija;


CREATE TABLE RasaPsa (
	RasaID int PRIMARY KEY  NOT NULL AUTO_INCREMENT,
    ImeRase varchar(255),
    Opis varchar(500)
);

INSERT INTO RasaPsa (ImeRase,Opis)
VALUES("Pudla","mali pas");

Select * from RasaPsa;


CREATE TABLE VlasnikPsa (
    VlasnikID int PRIMARY KEY  NOT NULL AUTO_INCREMENT,
	ImeVlasnika varchar(50)
);



Select * From VlasnikPsa;



CREATE TABLE Pas (
   PasID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
   ImePsa varchar(50),
   Godine varchar(50),
   RasaID int,
   VlasnikID int,
   FOREIGN KEY (RasaID) REFERENCES RasaPsa(RasaID),
   FOREIGN KEY (VlasnikID) REFERENCES VlasnikPsa(VlasnikID)
   
);



select * from Pas;




