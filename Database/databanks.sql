-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Dic 11, 2020 alle 20:37
-- Versione del server: 10.4.16-MariaDB
-- Versione PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `databanks`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `contatto`
--

CREATE TABLE `contatto` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(32) NOT NULL,
  `Cognome` varchar(32) NOT NULL,
  `NumeroDiTelefono` char(10) NOT NULL,
  `Citta` varchar(32) NOT NULL,
  `Sesso` char(1) NOT NULL,
  `DataDiNascita` date NOT NULL,
  `Indirizzo` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `contatto`
--

INSERT INTO `contatto` (`ID`, `Nome`, `Cognome`, `NumeroDiTelefono`, `Citta`, `Sesso`, `DataDiNascita`, `Indirizzo`) VALUES
(1, 'Salvatore', 'Nappo', '3248951767', 'Bratislava', 'M', '1950-05-08', 'Via Bratislava 21'),
(2, 'Pietro', 'Smusi', '3613878783', 'Napoli', 'M', '2000-04-15', 'Via Napoli 31'),
(3, 'Maria', 'Ponti', '3237853243', 'Roma', 'F', '1930-06-24', 'Via Roma 66'),
(4, 'Mara', 'Caibo', '3231231233', 'Empoli', 'F', '1990-08-05', 'Via Empoli 16'),
(5, 'Luigi', 'Alberti', '3358756410', 'Savona', 'M', '1999-12-13', 'Via Savona 29'),
(6, 'Marco', 'Talento', '3458676390', 'Moncenisio', 'M', '1999-04-14', 'Via dei giovani 33'),
(7, 'Giovanni', 'Sperti', '3345678987', 'Modena', 'M', '1935-04-12', 'Via dei gigli 44'),
(8, 'Luca', 'Degni', '3334567654', 'Ercolano', 'M', '1945-02-18', 'Via Cupa 99'),
(9, 'Mario', 'DeLeo', '3245622345', 'Ercolano', 'M', '2019-05-10', 'Via Fiorillo 82'),
(10, 'Emanuele', 'Patierno', '3331652234', 'Ponticelli', 'M', '1950-06-09', 'Via Purgatorio 14'),
(11, 'Marco', 'Piccolo', '0814569654', 'Napoli', 'M', '2000-04-13', 'Via degli Ulivi 314'),
(12, 'Adalgisa', 'Alino', '0815647236', 'Ventotene', 'M', '1900-12-31', 'Via dei Mille 10'),
(13, 'Luca', 'De Luca', '0618659636', 'Roma', 'M', '1920-08-18', 'Via Cuparella 22'),
(14, 'Verde', 'De Maio', '0215687451', 'Milano', 'M', '1990-08-13', 'Via Veneto 159'),
(15, 'Emanuele', 'Naruto', '0247584562', 'Lecce', 'M', '1950-08-31', 'Via Inferno 158'),
(16, 'Giuseppe', 'Picci', '3331222457', 'Napoli', 'M', '1970-11-10', 'Via Calastro 30'),
(17, 'Antonio', 'Mazzola', '3331257683', 'Roma', 'M', '1960-06-17', 'Via Circumvallazione 20'),
(18, 'Diego', 'Maradona', '3234566723', 'Chiavari', 'M', '1940-06-17', 'Via Pagliarone 14'),
(19, 'Mario', 'Setaro', '3332457689', 'Torre del Greco', 'M', '1989-10-10', 'Via Viuli 19'),
(20, 'Luisa', 'Pocchia', '3332356789', 'Castellammare', 'F', '1960-06-05', 'Via dei Mille 81'),
(21, 'Marco', 'Togni', '3981231845', 'Folgore', 'M', '2015-01-01', 'Via fine 90'),
(22, 'Paolo', 'Sperti', '3331964868', 'Milano', 'M', '2010-04-12', 'Via del monte 15'),
(23, 'Antonio', 'Russo', '3218127345', 'Portici', 'M', '1990-07-13', 'Via Mortale 88'),
(24, 'Marco', 'Posti', '3429485761', 'Napoli', 'M', '1980-05-24', 'Via Vittoria 34'),
(25, 'Emanuele', 'Verdi', '3331461281', 'Sassari', 'M', '1996-06-17', 'Via Inferno 66');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `contatto`
--
ALTER TABLE `contatto`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `contatto`
--
ALTER TABLE `contatto`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
