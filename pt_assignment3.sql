-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: apr. 22, 2021 la 02:32 PM
-- Versiune server: 8.0.22
-- Versiune PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Bază de date: `pt_assignment3`
--

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `comanda`
--

CREATE TABLE `comanda` (
  `idComanda` int NOT NULL,
  `idPersoanaComanda` int DEFAULT NULL,
  `numePersoanaComanda` varchar(45) DEFAULT NULL,
  `emailPersoanaComanda` varchar(45) DEFAULT NULL,
  `idProdusComanda` int DEFAULT NULL,
  `numeProdusComanda` varchar(45) DEFAULT NULL,
  `cantitateComanda` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Eliminarea datelor din tabel `comanda`
--

INSERT INTO `comanda` (`idComanda`, `idPersoanaComanda`, `numePersoanaComanda`, `emailPersoanaComanda`, `idProdusComanda`, `numeProdusComanda`, `cantitateComanda`) VALUES
(1, 2, 'George Andrei', 'ga@yahoo.com', 3, 'Samsung Galaxy Note 20', 2),
(2, 8, 'Teodor Vlad', 'tv@yahoo.com', 10, 'Playstation 5', 3);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `persoana`
--

CREATE TABLE `persoana` (
  `idPersoana` int NOT NULL,
  `numePersoana` varchar(45) DEFAULT NULL,
  `emailPersoana` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Eliminarea datelor din tabel `persoana`
--

INSERT INTO `persoana` (`idPersoana`, `numePersoana`, `emailPersoana`) VALUES
(1, 'Marius Stefan', 'ms@yahoo.com'),
(2, 'George Andrei', 'ga@yahoo.com'),
(3, 'Robert Sabin', 'rs@yahoo.com'),
(4, 'Valentin Sorin', 'vs@yahoo.com'),
(5, 'Sebastian Victor', 'sv@yahoo.com'),
(6, 'Ianis Popescu', 'ip@yahoo.com'),
(7, 'Octavian Florin', 'of@yahoo.com'),
(8, 'Teodor Vlad', 'tv@yahoo.com'),
(9, 'Victor Liviu', 'vl@yahoo.com'),
(10, 'Radu Madalin', 'rm@yahoo.com'),
(11, 'Stefan Alexandru', 'sa@yahoo.com'),
(12, 'Marian George', 'mg@yahoo.com'),
(13, 'Andrei Vasile', 'av@yahoo.com'),
(14, 'Paul Ivan', 'pi@yahoo.com'),
(15, 'Eugen Laurentiu', 'el@yahoo.com'),
(16, 'Florentin Horia', 'fh@yahoo.com'),
(17, 'Mihai Gabriel', 'mg@yahoo.com'),
(18, 'Pavel Nicolae', 'pn@yahoo.com'),
(19, 'George Madalin', 'gm@yahoo.com'),
(20, 'Rares Roberto', 'rr@yahoo.com'),
(21, 'Ionescu George', 'ig@yahoo.com');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `produs`
--

CREATE TABLE `produs` (
  `idProdus` int NOT NULL,
  `numeProdus` varchar(45) DEFAULT NULL,
  `cantitate` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Eliminarea datelor din tabel `produs`
--

INSERT INTO `produs` (`idProdus`, `numeProdus`, `cantitate`) VALUES
(1, 'iPhone 12', 5),
(2, 'Google Pixel 5', 10),
(3, 'Samsung Galaxy Note 20', 11),
(4, 'Xiaomi Redmi 10X Pro', 11),
(5, 'Televizor LED Smart SAMSUNG 1234AA', 14),
(6, 'Televizor LED Smart VORTEX 4321BB', 10),
(7, 'Televizor LED PHILIPS 5678CC', 11),
(8, 'Soundbar SAMSUNG DD-1234', 5),
(9, 'Soundbar SONY EE-4321', 8),
(10, 'Playstation 5', 5);

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `comanda`
--
ALTER TABLE `comanda`
  ADD PRIMARY KEY (`idComanda`),
  ADD KEY `comanda_idProdusComanda_fk` (`idProdusComanda`),
  ADD KEY `comanda_idPersoanaComanda_fk` (`idPersoanaComanda`);

--
-- Indexuri pentru tabele `persoana`
--
ALTER TABLE `persoana`
  ADD PRIMARY KEY (`idPersoana`);

--
-- Indexuri pentru tabele `produs`
--
ALTER TABLE `produs`
  ADD PRIMARY KEY (`idProdus`);

--
-- Constrângeri pentru tabele eliminate
--

--
-- Constrângeri pentru tabele `comanda`
--
ALTER TABLE `comanda`
  ADD CONSTRAINT `comanda_idPersoanaComanda_fk` FOREIGN KEY (`idPersoanaComanda`) REFERENCES `persoana` (`idPersoana`),
  ADD CONSTRAINT `comanda_idProdusComanda_fk` FOREIGN KEY (`idProdusComanda`) REFERENCES `produs` (`idProdus`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
