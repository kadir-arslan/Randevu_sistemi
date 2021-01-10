use hastane ;

CREATE TABLE poliklinik (
pol_id INT  PRIMARY KEY  AUTO_INCREMENT ,
pol_name VARCHAR(20) 
);
CREATE TABLE doktorlar (
dok_id INT PRIMARY KEY  AUTO_INCREMENT,
dok_name VARCHAR(40),
dok_pol_id INT,
FOREIGN KEY(dok_pol_id) REFERENCES poliklinik(pol_id) ON DELETE SET NULL
);
CREATE TABLE hafta (
h_dok_id INT ,
gun  date ,
s09_00 BIGINT ,
s09_30 BIGINT ,
s10_00 BIGINT ,
s10_30 BIGINT ,
s11_00 BIGINT ,
s11_30 BIGINT ,
s13_00 BIGINT ,
s13_30 BIGINT ,
s14_00 BIGINT ,
s14_30 BIGINT ,
s15_00 BIGINT ,
s15_30 BIGINT ,
s16_00 BIGINT ,
s16_30 BIGINT ,
FOREIGN KEY(h_dok_id) REFERENCES doktorlar(dok_id) ON DELETE SET NULL
);

CREATE TABLE hastalar (
tc BIGINT PRIMARY KEY,
isim VARCHAR(40),
sifre VARCHAR(16) not null
);

