-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 15, 2020 at 04:42 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `MaxiPlanning`
--

-- --------------------------------------------------------

--
-- Table structure for table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `ID_Cours` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_Cours`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cours`
--

INSERT INTO `cours` (`ID_Cours`, `Nom`) VALUES
(1, 'Anthropologie'),
(2, 'Droit du travail '),
(3, 'Thermodynamique'),
(4, 'Bases de données'),
(5, 'Théorie des graphes'),
(6, 'Ethique de l\'ingénieur'),
(7, 'Electrostatique'),
(8, 'Anglais'),
(9, 'Arabe'),
(10, 'POO Java'),
(11, 'Traitement du Signal'),
(12, 'Analyse de Fourier'),
(13, 'Web Dynamique'),
(14, 'Electronique'),
(15, 'Probabilités et Statistiques'),
(16, 'VHDL'),
(17, 'Ondes');

-- --------------------------------------------------------

--
-- Table structure for table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `ID_utilisateur` int(11) NOT NULL,
  `ID_cours` int(11) NOT NULL,
  PRIMARY KEY (`ID_utilisateur`,`ID_cours`),
  KEY `enseignant_cours_fk` (`ID_cours`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enseignant`
--

INSERT INTO `enseignant` (`ID_utilisateur`, `ID_cours`) VALUES
(35, 1),
(5, 3),
(37, 4),
(37, 5),
(35, 6),
(5, 7),
(36, 8),
(36, 9),
(38, 10),
(39, 11),
(3, 12),
(38, 13),
(3, 15),
(39, 16);

-- --------------------------------------------------------

--
-- Table structure for table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID_Utilisateur` int(11) NOT NULL,
  `Numero` int(11) NOT NULL,
  `ID_Groupe` int(11) NOT NULL,
  PRIMARY KEY (`ID_Utilisateur`),
  KEY `etudiant_groupe_fk` (`ID_Groupe`),
  KEY `etudiant_utilisateur_fk` (`ID_Utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`ID_Utilisateur`, `Numero`, `ID_Groupe`) VALUES
(6, 1, 4),
(7, 2, 4),
(8, 3, 1),
(9, 4, 1),
(10, 5, 1),
(11, 6, 3),
(12, 7, 2),
(13, 8, 2),
(14, 9, 1),
(15, 10, 5),
(16, 11, 5),
(17, 12, 7),
(18, 13, 7),
(19, 14, 3),
(20, 15, 4),
(21, 16, 4),
(22, 17, 6),
(23, 18, 5),
(24, 19, 6),
(25, 20, 8),
(26, 21, 8),
(27, 22, 9),
(28, 23, 9),
(29, 24, 11),
(30, 25, 12),
(31, 26, 11),
(32, 27, 12),
(33, 28, 10),
(34, 29, 10);

-- --------------------------------------------------------

--
-- Table structure for table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `ID_groupe` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `ID_promotion` int(11) NOT NULL,
  PRIMARY KEY (`ID_groupe`),
  KEY `groupe_promotion_fk` (`ID_promotion`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groupe`
--

INSERT INTO `groupe` (`ID_groupe`, `Nom`, `ID_promotion`) VALUES
(1, 'Groupe 1', 1),
(2, 'Groupe 2', 1),
(3, 'Groupe 3', 1),
(4, 'Groupe 1', 2),
(5, 'Groupe 2', 2),
(6, 'Groupe 3', 2),
(7, 'Groupe 1', 3),
(8, 'Groupe 2', 3),
(9, 'Groupe 3', 3),
(10, 'Groupe 1', 4),
(11, 'Groupe 2', 4),
(12, 'Groupe 3', 4);

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `ID_promotion` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_promotion`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`ID_promotion`, `Nom`) VALUES
(1, 'Promotion 2021'),
(2, 'Promotion 2022'),
(3, 'Promotion 2023'),
(4, 'Promotion 2020');

-- --------------------------------------------------------

--
-- Table structure for table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `ID_salle` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Capacite` int(11) NOT NULL,
  `ID_site` int(11) NOT NULL,
  PRIMARY KEY (`ID_salle`),
  KEY `salle_site_fk` (`ID_site`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salle`
--

INSERT INTO `salle` (`ID_salle`, `Nom`, `Capacite`, `ID_site`) VALUES
(1, 'EM010', 200, 1),
(2, 'EM011', 200, 1),
(3, 'SC 001', 50, 3),
(4, 'SC 002', 50, 3),
(5, 'C201', 80, 2),
(6, 'C202', 80, 2);

-- --------------------------------------------------------

--
-- Table structure for table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `ID_seance` int(11) NOT NULL AUTO_INCREMENT,
  `Semaine` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Heure_debut` varchar(255) NOT NULL,
  `Heure_fin` varchar(255) NOT NULL,
  `Etat` int(11) NOT NULL,
  `ID_cours` int(11) NOT NULL,
  `ID_type` int(11) NOT NULL,
  PRIMARY KEY (`ID_seance`),
  KEY `seance_cours_fk` (`ID_cours`),
  KEY `seance_type_fk` (`ID_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `seance_enseignants`
--

DROP TABLE IF EXISTS `seance_enseignants`;
CREATE TABLE IF NOT EXISTS `seance_enseignants` (
  `ID_seance` int(11) NOT NULL,
  `ID_utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`ID_seance`,`ID_utilisateur`),
  KEY `se_enseignant_fk` (`ID_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `seance_groupes`
--

DROP TABLE IF EXISTS `seance_groupes`;
CREATE TABLE IF NOT EXISTS `seance_groupes` (
  `ID_seance` int(11) NOT NULL,
  `ID_groupe` int(11) NOT NULL,
  PRIMARY KEY (`ID_seance`,`ID_groupe`),
  KEY `sg_groupe_fk` (`ID_groupe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `seance_salles`
--

DROP TABLE IF EXISTS `seance_salles`;
CREATE TABLE IF NOT EXISTS `seance_salles` (
  `ID_seance` int(11) NOT NULL,
  `ID_salle` int(11) NOT NULL,
  PRIMARY KEY (`ID_seance`,`ID_salle`),
  KEY `ss_salle_fk` (`ID_salle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `ID_site` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_site`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `site`
--

INSERT INTO `site` (`ID_site`, `Nom`) VALUES
(1, 'E1'),
(2, 'E2'),
(3, 'E3');

-- --------------------------------------------------------

--
-- Table structure for table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `ID_type` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_type`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type_cours`
--

INSERT INTO `type_cours` (`ID_type`, `Nom`) VALUES
(1, 'Interactif'),
(2, 'Magistral'),
(3, 'TD'),
(4, 'TP'),
(5, 'Soutien'),
(6, 'Projet');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID_utilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Prenom` varchar(255) NOT NULL,
  `Droit` int(11) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_utilisateur`, `Nom`, `Prenom`, `Droit`, `Email`, `Password`) VALUES
(1, 'La Souris', 'Mimi', 1, 'mimi@lasouris.com', 'lolilol'),
(2, 'Saad', 'Marie', 1, 'mariesaad@ece.fr', 'titi'),
(3, 'Coudray', 'Fabienne', 3, 'coudray@ece.fr', 'coucou'),
(4, 'Crambes', 'Christine', 2, 'crambes@ece.fr', 'haha'),
(5, 'Mouhali', 'Waleed', 3, 'mouhali@ece.fr', 'popo'),
(6, 'Le Brishoual', 'Thomas', 4, 'thomas@ece.fr', 'toto'),
(7, 'Clemenceau', 'Benoit', 4, 'benoit@ece.fr', 'ben'),
(8, 'Benallou', 'Miriam', 4, 'miriam@ece.fr', 'mimi'),
(9, 'Malan', 'Jasmine', 4, 'jasmine@ece.fr', 'jas'),
(10, 'Bizord', 'Alexandre', 4, 'bizord@ece.fr', 'alex'),
(11, 'Touchent', 'Rian', 4, 'rian@ece.fr', 'rian'),
(12, 'Prevost', 'Claire', 4, 'prevost@ece.fr', 'claire'),
(13, 'Zaatar', 'Kim', 4, 'zaatar@ece.fr', 'kim'),
(14, 'Herduin', 'Pierre', 4, 'pierre@ece.fr', 'heyhey'),
(15, 'Anbari', 'Jade', 4, 'anbari@ece.fr', 'jade'),
(16, 'Bouchenoire', 'Gauthier', 4, 'bouchenoire@ece.fr', 'gauthier'),
(17, 'Dunston', 'Jean', 4, 'dunston@ece.fr', 'jean'),
(18, 'Attal', 'Gabriel', 4, 'attal@ece.fr', 'gab'),
(19, 'Stephane', 'Juliette', 4, 'stephane@ece.fr', 'juju'),
(20, 'Quidet', 'Victor', 4, 'quidet@ece.fr', 'victor'),
(21, 'Loizeau', 'Adrien', 4, 'loizeau@ece.fr', 'lol'),
(22, 'Godinot', 'Victor', 4, 'godinot@ece.fr', 'torvic'),
(23, 'Perreau', 'Etienne', 4, 'perreau@ece.fr', 'pero'),
(24, 'Gautier', 'Lola', 4, 'gautier@ece.fr', 'gogo'),
(25, 'Kui', 'Jacky', 4, 'jacky@ece.fr', 'kui'),
(26, 'Zaz', 'Hedi', 4, 'zaz@ece.fr', 'hedi'),
(27, 'Benslimane', 'Youssef', 4, 'benslimane@ece.fr', 'yoyo'),
(28, 'Remy', 'Ghidaglia', 4, 'remy@ece.fr', 'ghighi'),
(29, 'Martinon', 'Adrien', 4, 'martinon@ece.fr', 'adri'),
(30, 'Gabriel', 'Pierre', 4, 'gabriel@ece.fr', 'tutu'),
(31, 'Betoulle', 'Florian', 4, 'betoulle@ece.fr', 'flo'),
(32, 'Marrec', 'Lucas', 4, 'marrec@ece.fr', 'lulu'),
(33, 'Saadoune', 'Benjamin', 4, 'saadoune@ece.fr', 'popopo'),
(34, 'Desmoulins', 'Aurore', 4, 'desmoulins@ece.fr', 'auwowa'),
(35, 'Maupile', 'Jean', 3, 'maupile@ece.fr', 'momo'),
(36, 'Bennani', 'Zineb', 3, 'bennani@ece.fr', 'mimi'),
(37, 'Rendler', 'Elisabeth', 3, 'rendler@ece.fr', 'lala'),
(38, 'Falih', 'Issam', 3, 'falih@ece.fr', 'issam'),
(39, 'Mokhber', 'Arash', 3, 'mokhber@ece.fr', 'momo');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `enseignant_cours_fk` FOREIGN KEY (`ID_cours`) REFERENCES `cours` (`ID_Cours`),
  ADD CONSTRAINT `enseignant_utilisateur_fk` FOREIGN KEY (`ID_utilisateur`) REFERENCES `utilisateur` (`ID_utilisateur`);

--
-- Constraints for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_groupe_fk` FOREIGN KEY (`ID_Groupe`) REFERENCES `groupe` (`ID_groupe`),
  ADD CONSTRAINT `etudiant_utilisateur_fk` FOREIGN KEY (`ID_Utilisateur`) REFERENCES `utilisateur` (`ID_utilisateur`);

--
-- Constraints for table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `groupe_promotion_fk` FOREIGN KEY (`ID_promotion`) REFERENCES `promotion` (`ID_promotion`);

--
-- Constraints for table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `salle_site_fk` FOREIGN KEY (`ID_site`) REFERENCES `site` (`ID_site`);

--
-- Constraints for table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `seance_cours_fk` FOREIGN KEY (`ID_cours`) REFERENCES `cours` (`ID_Cours`),
  ADD CONSTRAINT `seance_type_fk` FOREIGN KEY (`ID_type`) REFERENCES `type_cours` (`ID_type`);

--
-- Constraints for table `seance_enseignants`
--
ALTER TABLE `seance_enseignants`
  ADD CONSTRAINT `se_enseignant_fk` FOREIGN KEY (`ID_utilisateur`) REFERENCES `enseignant` (`ID_utilisateur`),
  ADD CONSTRAINT `se_seance_fk` FOREIGN KEY (`ID_seance`) REFERENCES `seance` (`ID_seance`);

--
-- Constraints for table `seance_groupes`
--
ALTER TABLE `seance_groupes`
  ADD CONSTRAINT `sg_groupe_fk` FOREIGN KEY (`ID_groupe`) REFERENCES `groupe` (`ID_groupe`),
  ADD CONSTRAINT `sg_seance_fk` FOREIGN KEY (`ID_seance`) REFERENCES `seance` (`ID_seance`);

--
-- Constraints for table `seance_salles`
--
ALTER TABLE `seance_salles`
  ADD CONSTRAINT `ss_salle_fk` FOREIGN KEY (`ID_salle`) REFERENCES `salle` (`ID_salle`),
  ADD CONSTRAINT `ss_seance_fk` FOREIGN KEY (`ID_seance`) REFERENCES `seance` (`ID_seance`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
