create table Persoana
(
idPersoana int,
numePersoana varchar(45),
emailPersoana varchar(45),
constraint persoana_idPersoana_pk primary key(idPersoana)
);

create table Produs
(
idProdus int,
numeProdus varchar(45),
cantitate int,
constraint produs_idProdus_pk primary key(idProdus)
);

create table Comanda
(idComanda int,
idPersoanaComanda int,
numePersoanaComanda varchar(45),
emailPersoanaComanda varchar(45),
idProdusComanda int,
numeProdusComanda varchar(45),
cantitateComanda int,
constraint comanda_idComanda_pk primary key(idComanda),
constraint comanda_idProducomandasComanda_fk foreign key (idProdusComanda) references Produs(idProdus),
constraint comanda_idPersoanaComanda_fk foreign key (idPersoanaComanda) references Persoana(idPersoana)
);

insert into persoana values(1,'Marius Stefan', 'ms@yahoo.com');
insert into persoana values(2,'George Andrei', 'ga@yahoo.com');
insert into persoana values(3,'Robert Sabin', 'rs@yahoo.com');
insert into persoana values(4,'Valentin Sorin', 'vs@yahoo.com');
insert into persoana values(5,'Sebastian Victor', 'sv@yahoo.com');
insert into persoana values(6,'Ianis Popescu', 'ip@yahoo.com');
insert into persoana values(7,'Octavian Florin', 'of@yahoo.com');
insert into persoana values(8,'Teodor Vlad', 'tv@yahoo.com');
insert into persoana values(9,'Victor Liviu', 'vl@yahoo.com');
insert into persoana values(10,'Radu Madalin', 'rm@yahoo.com');
insert into persoana values(11,'Stefan Alexandru', 'sa@yahoo.com');
insert into persoana values(12,'Marian George', 'mg@yahoo.com');
insert into persoana values(13,'Andrei Vasile', 'av@yahoo.com');
insert into persoana values(14,'Paul Ivan', 'pi@yahoo.com');
insert into persoana values(15,'Eugen Laurentiu', 'el@yahoo.com');
insert into persoana values(16,'Florentin Horia', 'fh@yahoo.com');
insert into persoana values(17,'Mihai Gabriel', 'mg@yahoo.com');
insert into persoana values(18,'Pavel Nicolae', 'pn@yahoo.com');
insert into persoana values(19,'George Madalin', 'gm@yahoo.com');
insert into persoana values(20,'Rares Roberto', 'rr@yahoo.com');
insert into persoana values(21,'Ionescu George', 'ig@yahoo.com');

insert into produs values(1,'iPhone 12', 5);
insert into produs values(2,'Google Pixel 5', 10);
insert into produs values(3,'Samsung Galaxy Note 20', 15);
insert into produs values(4,'Xiaomi Redmi 10X Pro', 12);
insert into produs values(5,'Televizor LED Smart SAMSUNG 1234AA', 15);
insert into produs values(6,'Televizor LED Smart VORTEX 4321BB', 10);
insert into produs values(7,'Televizor LED PHILIPS 5678CC', 15);
insert into produs values(8,'Soundbar SAMSUNG DD-1234', 5);
insert into produs values(9,'Soundbar SONY EE-4321', 8);
insert into produs values(10,'PlayStation 5', 10);

#insert into comanda values(1,2,10,2);
#insert into comanda values(2,3,3,1);
#insert into comanda values(3,12,9,3);
#insert into comanda values(4,13,5,4);