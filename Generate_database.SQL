/*
Created: 04.11.2020
Modified: 17.11.2020
Model: Salon samochodowy PL
Database: Oracle 19c
*/


-- Create sequences section -------------------------------------------------

CREATE SEQUENCE BiuraSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE AdresySeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE StanowiskaSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE PracownicySeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE WynagrodzeniaSeq1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE PojazdySeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE PocztySeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE SalonySeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE MarkiSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE ModeleSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE UslugiSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE KlienciSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE PakietySeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

-- Create tables section -------------------------------------------------

-- Table Biura

CREATE TABLE Biura(
  Nr_biura Integer NOT NULL,
  Nazwa Varchar2(30 ) NOT NULL,
  Data_zalozenia Date NOT NULL,
  Nr_adresu Integer NOT NULL
)
/

-- Create indexes for table Biura

CREATE INDEX IX_Biura_maja_adresy ON Biura (Nr_adresu)
/

-- Add keys for table Biura

ALTER TABLE Biura ADD CONSTRAINT Biuro_PK PRIMARY KEY (Nr_biura)
/

-- Table Salony

CREATE TABLE Salony(
  Nr_salonu Integer NOT NULL,
  Nazwa Varchar2(20 ) NOT NULL,
  Status Char(1 ) NOT NULL,
  Nr_biura Integer NOT NULL
)
/

-- Create indexes for table Salony

CREATE INDEX IX_Posiadaja_salony ON Salony (Nr_biura)
/

-- Add keys for table Salony

ALTER TABLE Salony ADD CONSTRAINT Unique_Identifier2 PRIMARY KEY (Nr_salonu)
/

-- Table Pracownicy

CREATE TABLE Pracownicy(
  Nr_pracownika Integer NOT NULL,
  Imie Varchar2(20 ) NOT NULL,
  Nazwisko Varchar2(30 ) NOT NULL,
  Dzial Varchar2(13 ) NOT NULL,
  Data_urodzenia Date NOT NULL,
  PESEL Char(11 ),
  Plec Char(1 ) NOT NULL
        CHECK (Plec IN ('K','M')),
  Data_umowy Date,
  Nr_biura Integer NOT NULL,
  Nr_adresu Integer NOT NULL,
  Nr_stanowiska Integer NOT NULL
)
/

-- Create indexes for table Pracownicy

CREATE INDEX IX_Zatrudniaja ON Pracownicy (Nr_biura)
/

CREATE INDEX IX_Pracownicy_maja ON Pracownicy (Nr_adresu)
/

CREATE INDEX IX_Obejmuja_stanowisko ON Pracownicy (Nr_stanowiska)
/

-- Add keys for table Pracownicy

ALTER TABLE Pracownicy ADD CONSTRAINT Unique_Identifier3 PRIMARY KEY (Nr_pracownika)
/

-- Table and Columns comments section

COMMENT ON COLUMN Pracownicy.Dzial IS 'Dzial'
/
COMMENT ON COLUMN Pracownicy.Data_umowy IS 'Data wygaśnięcia umowy z pracownikiem '
/

-- Table Pojazdy

CREATE TABLE Pojazdy(
  Nr_pojazdu Integer NOT NULL,
  Wartosc Float NOT NULL,
  VIN Varchar2(17 ) NOT NULL,
  Rodzaj_paliwa Varchar2(20 ) NOT NULL
        CHECK (Rodzaj_paliwa In ('OLEJ','BENZYNA','LPG','ELEKTRYCZNY','INNY')),
  Moc Integer NOT NULL,
  Pojemnosc_silnika Number NOT NULL,
  Dostepnosc Char(3 ) NOT NULL
        CHECK (Dostepnosc In ('TAK','NIE')),
  Kolor Varchar2(25 ) NOT NULL,
  Nr_rejestracyjny Varchar2(10 ),
  Koszt_transportu Float,
  Nr_biura Integer NOT NULL,
  Nr_pracownika Integer NOT NULL,
  Nr_uslugi Integer NOT NULL,
  Nr_modelu Integer NOT NULL
)
/

-- Create indexes for table Pojazdy

CREATE INDEX IX_Posiadaja ON Pojazdy (Nr_biura)
/

CREATE INDEX IX_Opiekuja_sie ON Pojazdy (Nr_pracownika)
/

CREATE INDEX IX_Korzystaja ON Pojazdy (Nr_uslugi)
/

CREATE INDEX IX_Pojazdy_maja_modele ON Pojazdy (Nr_modelu)
/

-- Add keys for table Pojazdy

ALTER TABLE Pojazdy ADD CONSTRAINT Unique_Identifier8 PRIMARY KEY (Nr_pojazdu)
/

-- Table and Columns comments section

COMMENT ON COLUMN Pojazdy.Wartosc IS 'Wartosc auta'
/
COMMENT ON COLUMN Pojazdy.Moc IS 'Moc silnika'
/
COMMENT ON COLUMN Pojazdy.Dostepnosc IS 'Dostepnosc auta (tak lub nie)'
/
COMMENT ON COLUMN Pojazdy.Kolor IS 'Kolor auta'
/
COMMENT ON COLUMN Pojazdy.Koszt_transportu IS 'Koszt transportu do klienta (salonu)'
/

-- Table Klienci

CREATE TABLE Klienci(
  Nr_klienta Integer NOT NULL,
  Imie Varchar2(20 ) NOT NULL,
  Nazwisko Varchar2(30 ) NOT NULL
)
/

-- Add keys for table Klienci

ALTER TABLE Klienci ADD CONSTRAINT Unique_Identifier13 PRIMARY KEY (Nr_klienta)
/

-- Table Obsady

CREATE TABLE Obsady(
  Nr_pracownika Integer NOT NULL,
  Nr_salonu Integer NOT NULL,
  Data_od Date NOT NULL,
  Data_do Date NOT NULL,
  Nazwa_salonu Varchar2(30 ) NOT NULL,
  Nazwisko_pracownika Char(30 ) NOT NULL
)
/

-- Table and Columns comments section

COMMENT ON COLUMN Obsady.Data_od IS 'Data, od której pracownik będzie realizował obsadę'
/
COMMENT ON COLUMN Obsady.Data_do IS 'Data, do której pracownik będzie realizował obsadę'
/
COMMENT ON COLUMN Obsady.Nazwa_salonu IS 'Nazwa salonu'
/
COMMENT ON COLUMN Obsady.Nazwisko_pracownika IS 'Nazwisko pracownika'
/

-- Table Adresy

CREATE TABLE Adresy(
  Nr_adresu Integer NOT NULL,
  Miasto Varchar2(20 ) NOT NULL,
  Ulica Varchar2(30 ) NOT NULL,
  Nr_lokalu Varchar2(5 ) NOT NULL,
  Nr_poczty Integer NOT NULL
)
/

-- Create indexes for table Adresy

CREATE INDEX IX_Adres_ma_poczte ON Adresy (Nr_poczty)
/

-- Add keys for table Adresy

ALTER TABLE Adresy ADD CONSTRAINT PK_Adresy PRIMARY KEY (Nr_adresu)
/

-- Table and Columns comments section

COMMENT ON COLUMN Adresy.Nr_adresu IS 'Unikatowy numer adresu'
/
COMMENT ON COLUMN Adresy.Miasto IS 'Miasto w adresie'
/
COMMENT ON COLUMN Adresy.Ulica IS 'Ulica w adresie'
/
COMMENT ON COLUMN Adresy.Nr_lokalu IS 'Numer lokalu w adresie (np. 6A/10)'
/

-- Table Poczty

CREATE TABLE Poczty(
  Nr_poczty Integer NOT NULL,
  Kod_poczty Char(6 ) NOT NULL,
  Poczta Varchar2(20 ) NOT NULL
)
/

-- Add keys for table Poczty

ALTER TABLE Poczty ADD CONSTRAINT PK_Poczty PRIMARY KEY (Nr_poczty)
/

ALTER TABLE Poczty ADD CONSTRAINT Kod_poczty UNIQUE (Kod_poczty)
/

-- Table and Columns comments section

COMMENT ON COLUMN Poczty.Nr_poczty IS 'Unikatowy identyfikator poczty'
/
COMMENT ON COLUMN Poczty.Kod_poczty IS 'Kod pocztowy'
/
COMMENT ON COLUMN Poczty.Poczta IS 'Siedziba poczty'
/

-- Table Stanowiska

CREATE TABLE Stanowiska(
  Nr_stanowiska Integer NOT NULL,
  Nazwa Varchar2(30 ) NOT NULL,
  Opis Varchar2(400 ) NOT NULL
)
/

-- Add keys for table Stanowiska

ALTER TABLE Stanowiska ADD CONSTRAINT PK_Stanowiska PRIMARY KEY (Nr_stanowiska)
/

-- Table and Columns comments section

COMMENT ON COLUMN Stanowiska.Nr_stanowiska IS 'Unikatowy identyfikator stanowiska'
/
COMMENT ON COLUMN Stanowiska.Nazwa IS 'Nazwa stanowiska'
/
COMMENT ON COLUMN Stanowiska.Opis IS 'Opis stanowiska'
/

-- Table Wynagrodzenia

CREATE TABLE Wynagrodzenia(
  Nr_wynagrodzenia Integer NOT NULL,
  Data Date NOT NULL,
  Kwota_podstawowa Number(8,2) NOT NULL,
  Kwota_dodatkowa Number(8,2),
  Nr_pracownika Integer NOT NULL
)
/

-- Create indexes for table Wynagrodzenia

CREATE INDEX IX_Zarabiaja ON Wynagrodzenia (Nr_pracownika)
/

-- Add keys for table Wynagrodzenia

ALTER TABLE Wynagrodzenia ADD CONSTRAINT PK_Wynagrodzenia PRIMARY KEY (Nr_wynagrodzenia)
/

-- Table and Columns comments section

COMMENT ON COLUMN Wynagrodzenia.Nr_wynagrodzenia IS 'Unikatowy numer wynagrodzenia'
/
COMMENT ON COLUMN Wynagrodzenia.Data IS 'Data wypłaty'
/
COMMENT ON COLUMN Wynagrodzenia.Kwota_podstawowa IS 'Kwota podstawowa wynagrodzenia'
/
COMMENT ON COLUMN Wynagrodzenia.Kwota_dodatkowa IS 'Kwota dodatkowa (premia)'
/

-- Table Uslugi

CREATE TABLE Uslugi(
  Nr_uslugi Integer NOT NULL,
  Liczba Integer NOT NULL,
  Rodzaj_platnosci Char(7 ) NOT NULL
        CHECK (Rodzaj_platnosci In ('PARAGON','FAKTURA')),
  Data Date NOT NULL,
  Nr_pracownika Integer NOT NULL,
  Nr_klienta Integer NOT NULL
)
/

-- Create indexes for table Uslugi

CREATE INDEX IX_Swiadcza ON Uslugi (Nr_pracownika)
/

CREATE INDEX IX_Kupuja ON Uslugi (Nr_klienta)
/

-- Add keys for table Uslugi

ALTER TABLE Uslugi ADD CONSTRAINT PK_Uslugi PRIMARY KEY (Nr_uslugi)
/

-- Table and Columns comments section

COMMENT ON COLUMN Uslugi.Nr_uslugi IS 'Unikatowy identyfiaktor uslugi'
/
COMMENT ON COLUMN Uslugi.Liczba IS 'Liczba zakupionych obiektow (aut, ubezpieczen)'
/
COMMENT ON COLUMN Uslugi.Rodzaj_platnosci IS 'Rodzaj płatności (paragon lub faktura)'
/
COMMENT ON COLUMN Uslugi.Data IS 'Data'
/

-- Table Sprzedaze

CREATE TABLE Sprzedaze(
  Nr_uslugi Integer NOT NULL,
  Gwarancja Date NOT NULL,
  Cena Float NOT NULL
)
/

-- Add keys for table Sprzedaze

ALTER TABLE Sprzedaze ADD CONSTRAINT PK_Sprzedaze PRIMARY KEY (Nr_uslugi)
/

-- Table and Columns comments section

COMMENT ON COLUMN Sprzedaze.Gwarancja IS 'Gwarancja (podana data stanowi okres upłynięcia umowy gwarancyjnej)'
/
COMMENT ON COLUMN Sprzedaze.Cena IS 'Cena'
/

-- Table Wynajmy

CREATE TABLE Wynajmy(
  Nr_uslugi Integer NOT NULL,
  Okres_wynajmu Date NOT NULL,
  Wplata_poczatkowa Float,
  Oplata_miesieczna Float NOT NULL
)
/

-- Add keys for table Wynajmy

ALTER TABLE Wynajmy ADD CONSTRAINT PK_Wynajmy PRIMARY KEY (Nr_uslugi)
/

-- Table and Columns comments section

COMMENT ON COLUMN Wynajmy.Okres_wynajmu IS 'Okres wynajmu'
/
COMMENT ON COLUMN Wynajmy.Wplata_poczatkowa IS 'Wpłata początkowa'
/
COMMENT ON COLUMN Wynajmy.Oplata_miesieczna IS 'Opłata za miesiąc użytkowania auta'
/

-- Table Ubezpieczenia

CREATE TABLE Ubezpieczenia(
  Nr_uslugi Integer NOT NULL,
  Okres_ubezpieczenia Date NOT NULL,
  Nr_pakietu Integer NOT NULL
)
/

-- Create indexes for table Ubezpieczenia

CREATE INDEX IX_Wystepuja_w ON Ubezpieczenia (Nr_pakietu)
/

-- Add keys for table Ubezpieczenia

ALTER TABLE Ubezpieczenia ADD CONSTRAINT PK_Ubezpieczenia PRIMARY KEY (Nr_uslugi)
/

-- Table and Columns comments section

COMMENT ON COLUMN Ubezpieczenia.Okres_ubezpieczenia IS 'Okres ubezpieczenia'
/

-- Table Marki

CREATE TABLE Marki(
  Nr_marki Integer NOT NULL,
  Marka Varchar2(30 ) NOT NULL
)
/

-- Add keys for table Marki

ALTER TABLE Marki ADD CONSTRAINT PK_Marki PRIMARY KEY (Nr_marki)
/

-- Table and Columns comments section

COMMENT ON TABLE Marki IS 'Encja Marka'
/
COMMENT ON COLUMN Marki.Nr_marki IS 'Unikatowy identyfikator marki'
/
COMMENT ON COLUMN Marki.Marka IS 'Marka'
/

-- Table Modele

CREATE TABLE Modele(
  Nr_modelu Integer NOT NULL,
  Kod_modelu Varchar2(20 ) NOT NULL,
  Opis Varchar2(400 ),
  Nr_marki Integer NOT NULL
)
/

-- Create indexes for table Modele

CREATE INDEX IX_Maja_model ON Modele (Nr_marki)
/

-- Add keys for table Modele

ALTER TABLE Modele ADD CONSTRAINT PK_Modele PRIMARY KEY (Nr_modelu)
/

ALTER TABLE Modele ADD CONSTRAINT Kod_modelu UNIQUE (Kod_modelu)
/

-- Table and Columns comments section

COMMENT ON TABLE Modele IS 'Encja Model'
/
COMMENT ON COLUMN Modele.Nr_modelu IS 'Unikatowy identyfikator modelu'
/
COMMENT ON COLUMN Modele.Kod_modelu IS 'Kod modelu'
/
COMMENT ON COLUMN Modele.Opis IS 'Opis modelu'
/

-- Table Pakiety

CREATE TABLE Pakiety(
  Nr_pakietu Integer NOT NULL,
  Nazwa Varchar2(7 ) NOT NULL
        CHECK (Nazwa In ('ZLOTY','SREBRNY','BRAZOWY')),
  Oplata_miesieczna Float NOT NULL
)
/

-- Add keys for table Pakiety

ALTER TABLE Pakiety ADD CONSTRAINT PK_Pakiety PRIMARY KEY (Nr_pakietu)
/

-- Table and Columns comments section

COMMENT ON TABLE Pakiety IS 'Encja Pakiety'
/
COMMENT ON COLUMN Pakiety.Nr_pakietu IS 'Unikalny identyfikator pakietu'
/
COMMENT ON COLUMN Pakiety.Nazwa IS 'Nazwa pakietu (ZLOTY, SREBRNY lub BRAZOWY)'
/
COMMENT ON COLUMN Pakiety.Oplata_miesieczna IS 'Opłata miesięczna'
/

-- Trigger for sequence BiuraSeq1 for column Nr_biura in table Biura ---------
CREATE OR REPLACE TRIGGER ts_Biura_BiuraSeq1 BEFORE INSERT
ON Biura FOR EACH ROW
BEGIN
  :new.Nr_biura := BiuraSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Biura_BiuraSeq1 AFTER UPDATE OF Nr_biura
ON Biura FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_biura in table Biura as it uses sequence.');
END;
/

-- Trigger for sequence SalonySeq1 for column Nr_salonu in table Salony ---------
CREATE OR REPLACE TRIGGER ts_Salony_SalonySeq1 BEFORE INSERT
ON Salony FOR EACH ROW
BEGIN
  :new.Nr_salonu := SalonySeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Salony_SalonySeq1 AFTER UPDATE OF Nr_salonu
ON Salony FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_salonu in table Salony as it uses sequence.');
END;
/

-- Trigger for sequence PracownicySeq1 for column Nr_pracownika in table Pracownicy ---------
CREATE OR REPLACE TRIGGER ts_Pracownicy_PracownicySeq1 BEFORE INSERT
ON Pracownicy FOR EACH ROW
BEGIN
  :new.Nr_pracownika := PracownicySeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Pracownicy_PracownicySeq1 AFTER UPDATE OF Nr_pracownika
ON Pracownicy FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_pracownika in table Pracownicy as it uses sequence.');
END;
/

-- Trigger for sequence PojazdySeq1 for column Nr_pojazdu in table Pojazdy ---------
CREATE OR REPLACE TRIGGER ts_Pojazdy_PojazdySeq1 BEFORE INSERT
ON Pojazdy FOR EACH ROW
BEGIN
  :new.Nr_pojazdu := PojazdySeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Pojazdy_PojazdySeq1 AFTER UPDATE OF Nr_pojazdu
ON Pojazdy FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_pojazdu in table Pojazdy as it uses sequence.');
END;
/

-- Trigger for sequence KlienciSeq1 for column Nr_klienta in table Klienci ---------
CREATE OR REPLACE TRIGGER ts_Klienci_KlienciSeq1 BEFORE INSERT
ON Klienci FOR EACH ROW
BEGIN
  :new.Nr_klienta := KlienciSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Klienci_KlienciSeq1 AFTER UPDATE OF Nr_klienta
ON Klienci FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_klienta in table Klienci as it uses sequence.');
END;
/

-- Trigger for sequence AdresySeq1 for column Nr_adresu in table Adresy ---------
CREATE OR REPLACE TRIGGER ts_Adresy_AdresySeq1 BEFORE INSERT
ON Adresy FOR EACH ROW
BEGIN
  :new.Nr_adresu := AdresySeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Adresy_AdresySeq1 AFTER UPDATE OF Nr_adresu
ON Adresy FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_adresu in table Adresy as it uses sequence.');
END;
/

-- Trigger for sequence PocztySeq1 for column Nr_poczty in table Poczty ---------
CREATE OR REPLACE TRIGGER ts_Poczty_PocztySeq1 BEFORE INSERT
ON Poczty FOR EACH ROW
BEGIN
  :new.Nr_poczty := PocztySeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Poczty_PocztySeq1 AFTER UPDATE OF Nr_poczty
ON Poczty FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_poczty in table Poczty as it uses sequence.');
END;
/

-- Trigger for sequence StanowiskaSeq1 for column Nr_stanowiska in table Stanowiska ---------
CREATE OR REPLACE TRIGGER ts_Stanowiska_StanowiskaSeq1 BEFORE INSERT
ON Stanowiska FOR EACH ROW
BEGIN
  :new.Nr_stanowiska := StanowiskaSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Stanowiska_StanowiskaSeq1 AFTER UPDATE OF Nr_stanowiska
ON Stanowiska FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_stanowiska in table Stanowiska as it uses sequence.');
END;
/

-- Trigger for sequence WynagrodzeniaSeq1 for column Nr_wynagrodzenia in table Wynagrodzenia ---------
CREATE OR REPLACE TRIGGER ts_Wynagrodzenia_WynagrodzeniaSeq1 BEFORE INSERT
ON Wynagrodzenia FOR EACH ROW
BEGIN
  :new.Nr_wynagrodzenia := WynagrodzeniaSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Wynagrodzenia_WynagrodzeniaSeq1 AFTER UPDATE OF Nr_wynagrodzenia
ON Wynagrodzenia FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_wynagrodzenia in table Wynagrodzenia as it uses sequence.');
END;
/

-- Trigger for sequence UslugiSeq1 for column Nr_uslugi in table Uslugi ---------
CREATE OR REPLACE TRIGGER ts_Uslugi_UslugiSeq1 BEFORE INSERT
ON Uslugi FOR EACH ROW
BEGIN
  :new.Nr_uslugi := UslugiSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Uslugi_UslugiSeq1 AFTER UPDATE OF Nr_uslugi
ON Uslugi FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_uslugi in table Uslugi as it uses sequence.');
END;
/

-- Trigger for sequence MarkiSeq1 for column Nr_marki in table Marki ---------
CREATE OR REPLACE TRIGGER ts_Marki_MarkiSeq1 BEFORE INSERT
ON Marki FOR EACH ROW
BEGIN
  :new.Nr_marki := MarkiSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Marki_MarkiSeq1 AFTER UPDATE OF Nr_marki
ON Marki FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_marki in table Marki as it uses sequence.');
END;
/

-- Trigger for sequence ModeleSeq1 for column Nr_modelu in table Modele ---------
CREATE OR REPLACE TRIGGER ts_Modele_ModeleSeq1 BEFORE INSERT
ON Modele FOR EACH ROW
BEGIN
  :new.Nr_modelu := ModeleSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Modele_ModeleSeq1 AFTER UPDATE OF Nr_modelu
ON Modele FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_modelu in table Modele as it uses sequence.');
END;
/

-- Trigger for sequence PakietySeq1 for column Nr_pakietu in table Pakiety ---------
CREATE OR REPLACE TRIGGER ts_Pakiety_PakietySeq1 BEFORE INSERT
ON Pakiety FOR EACH ROW
BEGIN
  :new.Nr_pakietu := PakietySeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Pakiety_PakietySeq1 AFTER UPDATE OF Nr_pakietu
ON Pakiety FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column Nr_pakietu in table Pakiety as it uses sequence.');
END;
/


-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE Pracownicy ADD CONSTRAINT Zatrudniaja FOREIGN KEY (Nr_biura) REFERENCES Biura (Nr_biura)
/



ALTER TABLE Salony ADD CONSTRAINT Posiadaja_salony FOREIGN KEY (Nr_biura) REFERENCES Biura (Nr_biura)
/



ALTER TABLE Pojazdy ADD CONSTRAINT Posiadaja FOREIGN KEY (Nr_biura) REFERENCES Biura (Nr_biura)
/



ALTER TABLE Pojazdy ADD CONSTRAINT Opiekuja_sie FOREIGN KEY (Nr_pracownika) REFERENCES Pracownicy (Nr_pracownika)
/



ALTER TABLE Adresy ADD CONSTRAINT Adres_ma_poczte FOREIGN KEY (Nr_poczty) REFERENCES Poczty (Nr_poczty)
/



ALTER TABLE Biura ADD CONSTRAINT Biura_maja_adresy FOREIGN KEY (Nr_adresu) REFERENCES Adresy (Nr_adresu)
/



ALTER TABLE Pracownicy ADD CONSTRAINT Pracownicy_maja FOREIGN KEY (Nr_adresu) REFERENCES Adresy (Nr_adresu)
/



ALTER TABLE Pracownicy ADD CONSTRAINT Obejmuja_stanowisko FOREIGN KEY (Nr_stanowiska) REFERENCES Stanowiska (Nr_stanowiska)
/



ALTER TABLE Wynagrodzenia ADD CONSTRAINT Zarabiaja FOREIGN KEY (Nr_pracownika) REFERENCES Pracownicy (Nr_pracownika)
/



ALTER TABLE Ubezpieczenia ADD CONSTRAINT Uslugi_Ubezpieczenia FOREIGN KEY (Nr_uslugi) REFERENCES Uslugi (Nr_uslugi)
/



ALTER TABLE Wynajmy ADD CONSTRAINT Uslugi_Wynajmy FOREIGN KEY (Nr_uslugi) REFERENCES Uslugi (Nr_uslugi)
/



ALTER TABLE Sprzedaze ADD CONSTRAINT Uslugi_Sprzedaze FOREIGN KEY (Nr_uslugi) REFERENCES Uslugi (Nr_uslugi)
/



ALTER TABLE Uslugi ADD CONSTRAINT Swiadcza FOREIGN KEY (Nr_pracownika) REFERENCES Pracownicy (Nr_pracownika)
/



ALTER TABLE Uslugi ADD CONSTRAINT Kupuja FOREIGN KEY (Nr_klienta) REFERENCES Klienci (Nr_klienta)
/



ALTER TABLE Pojazdy ADD CONSTRAINT Korzystaja FOREIGN KEY (Nr_uslugi) REFERENCES Uslugi (Nr_uslugi)
/



ALTER TABLE Modele ADD CONSTRAINT Maja_model FOREIGN KEY (Nr_marki) REFERENCES Marki (Nr_marki)
/



ALTER TABLE Pojazdy ADD CONSTRAINT Pojazdy_maja_modele FOREIGN KEY (Nr_modelu) REFERENCES Modele (Nr_modelu)
/



ALTER TABLE Ubezpieczenia ADD CONSTRAINT Wystepuja_w FOREIGN KEY (Nr_pakietu) REFERENCES Pakiety (Nr_pakietu)
/





