-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Dic 15, 2020 alle 20:50
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
-- Database: `iocaller`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `admindisistema`
--

CREATE TABLE `admindisistema` (
  `Username` varchar(32) NOT NULL,
  `Password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `admindisistema`
--

INSERT INTO `admindisistema` (`Username`, `Password`) VALUES
('alfonsoalonso', 'triscoppe99'),
('marcoamore', 'ginopi19'),
('mariorenzo', 'serie9'),
('pasqualeserie', 'serie2000'),
('vanessarina', 'racchetta20');

-- --------------------------------------------------------

--
-- Struttura della tabella `agentedivendita`
--

CREATE TABLE `agentedivendita` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(32) NOT NULL,
  `Cognome` varchar(32) NOT NULL,
  `NumeroDiTelefono` varchar(10) NOT NULL,
  `Email` varchar(32) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `Competenze` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `agentedivendita`
--

INSERT INTO `agentedivendita` (`ID`, `Nome`, `Cognome`, `NumeroDiTelefono`, `Email`, `Password`, `Competenze`) VALUES
(1, 'Luigi', 'Esposito', '0814673337', 'luigi.esposito@unina.it', 'Luigi_2020', 'Vendita Polizze'),
(2, 'Albano', 'Carrisi', '3346657758', 'albano.carrisi@unina.it', 'Albano_2020', 'Vendita Aspirapolvere'),
(3, 'Giuseppe', 'Garibaldi', '3892226753', 'giuseppe.garibaldi@unina.it', 'Giuseppe_2020', 'Vendita Pacchetti Vacanze'),
(4, 'Francesco', 'Renzo', '3286764631', 'francesco.renzo@unina.it', 'Francesco_2020', 'Vendita Fibra Ottica'),
(5, 'Luigi', 'Alessio', '3782225547', 'luigi.alessio@unina.it', 'Luigi_2020', 'Ristrutturazioni');

-- --------------------------------------------------------

--
-- Struttura della tabella `amministratore`
--

CREATE TABLE `amministratore` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(32) NOT NULL,
  `Cognome` varchar(32) NOT NULL,
  `DataDiNascita` date NOT NULL,
  `Residenza` varchar(32) NOT NULL,
  `Indirizzo` varchar(32) NOT NULL,
  `NumeroDiTelefono` char(10) NOT NULL,
  `Email` varchar(32) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `Competenze` varchar(32) NOT NULL,
  `Qualifica` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `amministratore`
--

INSERT INTO `amministratore` (`ID`, `Nome`, `Cognome`, `DataDiNascita`, `Residenza`, `Indirizzo`, `NumeroDiTelefono`, `Email`, `Password`, `Competenze`, `Qualifica`) VALUES
(1, 'Matteo', 'Politano', '1979-10-19', 'Taranto', 'Via Alcide De Gasperi 56', '3267447548', 'matteo.politano@unina.it', 'Matteo_2020', 'Settore Aspirapolveri', 'Tecnico'),
(2, 'Gabriele', 'D\'Annunzio', '1984-06-17', 'Napoli', 'Via Roma 76', '3548748884', 'gabriele.annunzio@unina.it', 'Gabriele_2020', 'Settore turistico', 'Responsabile prenotazioni'),
(3, 'Vincenzo', 'De Luca', '1978-11-07', 'Bologna', 'Via Amici 3', '0736433337', 'vincenzo.deluca@unina.it', 'Vincenzo_2020', 'Settore Amministrativo', 'Contabile'),
(4, 'Alessia', 'Marini', '1989-11-07', 'Milano', 'Via Ippolito 38', '0632832271', 'alessia.marini@unina.it', 'Alessia_2020', 'Settore HR', 'Responsabile'),
(5, 'Marta', 'Alini', '1989-03-20', 'Verona', 'Via Marte 38', '3785784449', 'marta.alini@unina.it', 'Marta_2020', 'Settore Commerciale', 'CEO');

-- --------------------------------------------------------

--
-- Struttura della tabella `appuntamento`
--

CREATE TABLE `appuntamento` (
  `ID` int(11) NOT NULL,
  `NomeAppuntamento` varchar(32) NOT NULL,
  `Data` date NOT NULL,
  `Ora` varchar(32) NOT NULL,
  `Note` varchar(32) NOT NULL,
  `IDappuntamentofallito` int(11) NOT NULL,
  `IDAgente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `appuntamento`
--

INSERT INTO `appuntamento` (`ID`, `NomeAppuntamento`, `Data`, `Ora`, `Note`, `IDappuntamentofallito`, `IDAgente`) VALUES
(1, 'Vendita Folletto', '2020-11-17', '10:00', 'Secondo piano, scala A', 0, 4),
(2, 'Installazione Fibra', '2020-10-21', '9:30', 'Condominio con citofono numerico', 0, 5),
(3, 'Stipula Polizza sulla vita', '2020-09-17', '17:00', 'Portare i moduli precompilati', 0, 2),
(4, 'Riparazione porta d\'ingresso', '2019-09-17', '11:00', 'Porta blindata', 0, 1),
(5, 'Riparazione Fibra', '2020-12-10', '11:00', 'Cabina nr 345', 2, 5);

-- --------------------------------------------------------

--
-- Struttura della tabella `centralinista`
--

CREATE TABLE `centralinista` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(32) NOT NULL,
  `Cognome` varchar(32) NOT NULL,
  `DataDiNascita` date NOT NULL,
  `Residenza` varchar(32) NOT NULL,
  `Indirizzo` varchar(32) NOT NULL,
  `NumeroDiTelefono` varchar(10) NOT NULL,
  `Email` varchar(32) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `Competenze` varchar(32) NOT NULL,
  `Qualifica` varchar(32) NOT NULL,
  `Stato` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `centralinista`
--

INSERT INTO `centralinista` (`ID`, `Nome`, `Cognome`, `DataDiNascita`, `Residenza`, `Indirizzo`, `NumeroDiTelefono`, `Email`, `Password`, `Competenze`, `Qualifica`, `Stato`) VALUES
(1, 'Lavinia', 'Molisani', '1997-10-30', 'Napoli', 'Via Medina 34', '3783442918', 'lavinia.molisani@unina.it', 'Lavinia_2020', 'Consulenza aspirapolveri', 'Impiegata', 'disponibile'),
(2, 'Mario', 'Rossi', '1988-07-22', 'Roma', 'Corso Garibaldi 30', '0267444783', 'mario.rossi@unina.it', 'Mario_2020', 'Cambio operatore telefonico', 'Impiegato', 'disponibile'),
(3, 'Gemma', 'Baresi', '1966-04-18', 'Rovigo', 'Via Sassari 55', '3237637003', 'gemma.baresi66@unina.it', 'Gemma_2020', 'Assistenza Post-Vendita', 'Impiegata Senior', 'occupata'),
(4, 'Francesco', 'Gargano', '1978-10-19', 'Potenza', 'Via Marina 98', '3982667003', 'francesco.gargano@unina.it', 'Francesco_2020', 'Esperto di trading', 'Apprendista', 'occupato'),
(5, 'Edoardo', 'Bertilaccio', '1998-10-19', 'Napoli', 'Corso Verona 65', '3543863855', 'edoardo.bertilaccio@unina.it', 'Edoardo_2020', 'Cambio offerta luce e gas', 'Apprendista', 'disponibile');

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
  `Sesso` varchar(1) NOT NULL,
  `DataDiNascita` date NOT NULL,
  `Indirizzo` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `contatto`
--

INSERT INTO `contatto` (`ID`, `Nome`, `Cognome`, `NumeroDiTelefono`, `Citta`, `Sesso`, `DataDiNascita`, `Indirizzo`) VALUES
(1, 'Pietro', 'Smusi', '3613878783', 'Napoli', 'M', '2000-04-15', 'Via Napoli 31'),
(2, 'Marco', 'Piccolo', '0814569654', 'Napoli', 'M', '2000-04-13', 'Via degli Ulivi 314'),
(3, 'Giuseppe', 'Picci', '3331222457', 'Napoli', 'M', '1970-11-10', 'Via Calastro 30'),
(4, 'Marco', 'Posti', '3429485761', 'Napoli', 'M', '1980-05-24', 'Via Vittoria 34'),
(5, 'Mara', 'Caibo', '3231231233', 'Empoli', 'F', '1990-08-05', 'Via Empoli 16');

-- --------------------------------------------------------

--
-- Struttura della tabella `contattolistacontatti`
--

CREATE TABLE `contattolistacontatti` (
  `IDContatto` int(11) NOT NULL,
  `IDListaContatti` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `contattolistacontatti`
--

INSERT INTO `contattolistacontatti` (`IDContatto`, `IDListaContatti`) VALUES
(1, 3),
(2, 3),
(3, 3),
(4, 3),
(5, 5);

-- --------------------------------------------------------

--
-- Struttura della tabella `gruppo`
--

CREATE TABLE `gruppo` (
  `ID` int(11) NOT NULL,
  `Descrizione` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `gruppo`
--

INSERT INTO `gruppo` (`ID`, `Descrizione`) VALUES
(1, 'Telefonia'),
(2, 'Viaggi'),
(3, 'Aspirapolvere'),
(4, 'Assicurazioni'),
(5, 'Consulenza finanziaria');

-- --------------------------------------------------------

--
-- Struttura della tabella `gruppocentralinista`
--

CREATE TABLE `gruppocentralinista` (
  `IDCentralinista` int(11) NOT NULL,
  `IDGruppo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `gruppocentralinista`
--

INSERT INTO `gruppocentralinista` (`IDCentralinista`, `IDGruppo`) VALUES
(1, 4),
(2, 1),
(2, 2),
(3, 1),
(5, 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `listacontatti`
--

CREATE TABLE `listacontatti` (
  `ID` int(11) NOT NULL,
  `NomeLista` varchar(32) NOT NULL,
  `DescrizioneLista` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `listacontatti`
--

INSERT INTO `listacontatti` (`ID`, `NomeLista`, `DescrizioneLista`) VALUES
(1, 'Organizzazione viaggi', 'Zona Milano e dintorni'),
(2, 'Assistenza acquisto Bitcoin', 'Solo contatti nati dopo il 1990'),
(3, 'Abbonamento TIM', 'Zona Napoli e dintorni'),
(4, 'Sostituzione Folletto', 'Solo contatti di sesso F'),
(5, 'Finanziamento ristrutturazione', 'Solo contatti nati dopo il 1970');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `admindisistema`
--
ALTER TABLE `admindisistema`
  ADD PRIMARY KEY (`Username`);

--
-- Indici per le tabelle `agentedivendita`
--
ALTER TABLE `agentedivendita`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `amministratore`
--
ALTER TABLE `amministratore`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `appuntamento`
--
ALTER TABLE `appuntamento`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Agente` (`IDAgente`),
  ADD KEY `Appuntamento` (`IDappuntamentofallito`);

--
-- Indici per le tabelle `centralinista`
--
ALTER TABLE `centralinista`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `contatto`
--
ALTER TABLE `contatto`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `contattolistacontatti`
--
ALTER TABLE `contattolistacontatti`
  ADD PRIMARY KEY (`IDContatto`,`IDListaContatti`);

--
-- Indici per le tabelle `gruppo`
--
ALTER TABLE `gruppo`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `gruppocentralinista`
--
ALTER TABLE `gruppocentralinista`
  ADD PRIMARY KEY (`IDCentralinista`,`IDGruppo`);

--
-- Indici per le tabelle `listacontatti`
--
ALTER TABLE `listacontatti`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `agentedivendita`
--
ALTER TABLE `agentedivendita`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `amministratore`
--
ALTER TABLE `amministratore`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `appuntamento`
--
ALTER TABLE `appuntamento`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `centralinista`
--
ALTER TABLE `centralinista`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `contatto`
--
ALTER TABLE `contatto`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `gruppo`
--
ALTER TABLE `gruppo`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `listacontatti`
--
ALTER TABLE `listacontatti`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `appuntamento`
--
ALTER TABLE `appuntamento`
  ADD CONSTRAINT `Agente` FOREIGN KEY (`IDAgente`) REFERENCES `agentedivendita` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
