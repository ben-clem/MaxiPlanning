-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jun 06, 2020 at 01:02 AM
-- Server version: 5.7.26
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `MaxiPlanning`
--

-- --------------------------------------------------------

--
-- Table structure for table `cours`
--

CREATE TABLE `cours` (
  `ID_Cours` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cours`
--

INSERT INTO `cours` (`ID_Cours`, `Nom`) VALUES
(1, 'Analyse de Fourier'),
(2, 'Anglais'),
(3, 'Anthropologie'),
(4, 'Arabe'),
(5, 'Bases de données'),
(6, 'Droit du travail '),
(7, 'Electronique'),
(8, 'Electrostatique'),
(9, 'Ethique de l\'ingénieur'),
(10, 'Ondes'),
(11, 'POO Java'),
(12, 'Probabilités et Statistiques'),
(13, 'Théorie des graphes'),
(14, 'Thermodynamique'),
(15, 'Traitement du Signal'),
(16, 'VHDL'),
(17, 'Web Dynamique');

-- --------------------------------------------------------

--
-- Table structure for table `enseignant`
--

CREATE TABLE `enseignant` (
  `ID_utilisateur` int(11) NOT NULL,
  `ID_cours` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enseignant`
--

INSERT INTO `enseignant` (`ID_utilisateur`, `ID_cours`) VALUES
(3, 1),
(47, 2),
(48, 3),
(36, 4),
(37, 5),
(41, 6),
(39, 7),
(4, 8),
(45, 8),
(48, 9),
(45, 10),
(35, 11),
(3, 12),
(46, 13),
(5, 14),
(39, 15),
(39, 16),
(38, 17);

-- --------------------------------------------------------

--
-- Table structure for table `etudiant`
--

CREATE TABLE `etudiant` (
  `ID_Utilisateur` int(11) NOT NULL,
  `Numero` int(11) NOT NULL,
  `ID_Groupe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`ID_Utilisateur`, `Numero`, `ID_Groupe`) VALUES
(6, 1, 4),
(7, 75011, 7),
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
(34, 29, 10),
(43, 777, 7);

-- --------------------------------------------------------

--
-- Table structure for table `groupe`
--

CREATE TABLE `groupe` (
  `ID_groupe` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `ID_promotion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groupe`
--

INSERT INTO `groupe` (`ID_groupe`, `Nom`, `ID_promotion`) VALUES
(1, 'Gr01', 1),
(2, 'Gr02', 1),
(3, 'Gr03', 1),
(4, 'Gr01', 2),
(5, 'Gr02', 2),
(6, 'Gr03', 2),
(7, 'Gr01', 3),
(8, 'Gr02', 3),
(9, 'Gr03', 3),
(10, 'Gr01', 4),
(11, 'Gr02', 4),
(12, 'Gr03', 4),
(13, 'GrTest', 2);

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

CREATE TABLE `promotion` (
  `ID_promotion` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`ID_promotion`, `Nom`) VALUES
(1, 'Ing1'),
(2, 'Ing2'),
(3, 'Ing3'),
(4, 'Ing4'),
(5, 'Ing5');

-- --------------------------------------------------------

--
-- Table structure for table `salle`
--

CREATE TABLE `salle` (
  `ID_salle` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Capacite` int(11) NOT NULL,
  `ID_site` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salle`
--

INSERT INTO `salle` (`ID_salle`, `Nom`, `Capacite`, `ID_site`) VALUES
(1, 'EM010', 200, 1),
(2, 'EM011', 200, 1),
(3, 'SC001', 50, 1),
(4, 'SC002', 50, 1),
(5, 'C201', 80, 3),
(6, 'C202', 80, 3),
(7, 'P304', 50, 2),
(8, 'P305', 50, 2);

-- --------------------------------------------------------

--
-- Table structure for table `seance`
--

CREATE TABLE `seance` (
  `ID_seance` int(11) NOT NULL,
  `Semaine` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Heure_debut` time NOT NULL,
  `Heure_fin` time NOT NULL,
  `Etat` int(11) NOT NULL,
  `ID_cours` int(11) NOT NULL,
  `ID_type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seance`
--

INSERT INTO `seance` (`ID_seance`, `Semaine`, `Date`, `Heure_debut`, `Heure_fin`, `Etat`, `ID_cours`, `ID_type`) VALUES
(13, 24, '2020-06-08', '08:30:00', '10:00:00', 1, 1, 2),
(14, 24, '2020-06-09', '09:30:00', '11:00:00', 1, 6, 1),
(15, 24, '2020-06-10', '15:00:00', '16:30:00', 1, 4, 1),
(16, 24, '2020-06-11', '08:30:00', '10:00:00', 1, 11, 6),
(17, 24, '2020-06-12', '09:00:00', '10:30:00', 1, 14, 3),
(18, 24, '2020-06-08', '10:15:00', '11:45:00', 1, 15, 4),
(19, 24, '2020-06-09', '12:00:00', '13:30:00', 1, 5, 5),
(20, 24, '2020-06-10', '16:45:00', '18:15:00', 1, 16, 6),
(21, 24, '2020-06-09', '16:00:00', '17:30:00', 1, 2, 1),
(22, 24, '2020-06-12', '15:00:00', '16:30:00', 1, 3, 1),
(23, 25, '2020-06-15', '13:00:00', '14:30:00', 1, 10, 3),
(24, 25, '2020-06-15', '08:30:00', '10:00:00', 1, 4, 1),
(25, 25, '2020-06-15', '12:00:00', '13:30:00', 1, 13, 4),
(26, 25, '2020-06-16', '14:30:00', '16:00:00', 1, 6, 1),
(27, 25, '2020-06-17', '08:30:00', '10:00:00', 1, 2, 1),
(28, 25, '2020-06-17', '11:00:00', '12:30:00', 1, 13, 2),
(29, 25, '2020-06-18', '10:00:00', '11:30:00', 1, 17, 4),
(30, 25, '2020-06-19', '08:30:00', '10:00:00', 1, 17, 4),
(31, 25, '2020-06-17', '15:00:00', '16:30:00', 1, 8, 2),
(32, 24, '2020-06-10', '08:30:00', '10:00:00', 1, 5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `seance_enseignants`
--

CREATE TABLE `seance_enseignants` (
  `ID_seance` int(11) NOT NULL,
  `ID_utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seance_enseignants`
--

INSERT INTO `seance_enseignants` (`ID_seance`, `ID_utilisateur`) VALUES
(13, 3),
(17, 5),
(16, 35),
(15, 36),
(24, 36),
(19, 37),
(32, 37),
(29, 38),
(30, 38),
(18, 39),
(20, 39),
(14, 41),
(26, 41),
(23, 45),
(31, 45),
(25, 46),
(28, 46),
(21, 47),
(27, 47),
(22, 48);

-- --------------------------------------------------------

--
-- Table structure for table `seance_groupes`
--

CREATE TABLE `seance_groupes` (
  `ID_seance` int(11) NOT NULL,
  `ID_groupe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seance_groupes`
--

INSERT INTO `seance_groupes` (`ID_seance`, `ID_groupe`) VALUES
(32, 1),
(15, 2),
(18, 2),
(32, 2),
(15, 3),
(24, 4),
(15, 5),
(13, 7),
(14, 7),
(16, 7),
(17, 7),
(18, 7),
(19, 7),
(20, 7),
(21, 7),
(22, 7),
(23, 7),
(24, 7),
(25, 7),
(26, 7),
(27, 7),
(28, 7),
(29, 7),
(30, 7),
(31, 7),
(32, 7),
(13, 9),
(20, 10),
(16, 11),
(19, 11);

-- --------------------------------------------------------

--
-- Table structure for table `seance_salles`
--

CREATE TABLE `seance_salles` (
  `ID_seance` int(11) NOT NULL,
  `ID_salle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seance_salles`
--

INSERT INTO `seance_salles` (`ID_seance`, `ID_salle`) VALUES
(15, 1),
(22, 1),
(23, 1),
(31, 1),
(16, 2),
(24, 2),
(32, 2),
(13, 3),
(15, 3),
(19, 3),
(24, 3),
(27, 3),
(18, 4),
(20, 4),
(28, 4),
(13, 5),
(15, 5),
(20, 5),
(21, 5),
(29, 5),
(14, 6),
(20, 6),
(22, 6),
(30, 6),
(17, 7),
(25, 7),
(28, 7),
(14, 8),
(18, 8),
(26, 8);

-- --------------------------------------------------------

--
-- Table structure for table `site`
--

CREATE TABLE `site` (
  `ID_site` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `type_cours` (
  `ID_type` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `utilisateur` (
  `ID_utilisateur` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Prenom` varchar(255) NOT NULL,
  `Droit` int(11) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_utilisateur`, `Nom`, `Prenom`, `Droit`, `Email`, `Password`) VALUES
(1, 'La Souris', 'Mimi', 1, 'mimi@lasouris.com', 'lolilol'),
(2, 'Saad', 'Marie', 1, 'mariesaad@ece.fr', 'titi'),
(3, 'Coudray', 'Fabienne', 2, 'coudray@ece.fr', 'coucou'),
(4, 'Crambes', 'Christine', 2, 'crambes@ece.fr', 'haha'),
(5, 'Mouhali', 'Waleed', 2, 'mouhali@ece.fr', 'popo'),
(6, 'Le Brishoual', 'Thomas', 4, 'thomas@ece.fr', 'toto'),
(7, 'Clemenceau', 'Benoît', 4, 'benoit@ece.fr', 'ben'),
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
(39, 'Mokhber', 'Arash', 3, 'mokhber@ece.fr', 'momo'),
(40, 'Baujault', 'Christophe', 1, 'cricri@bojo.com', 'brrr'),
(41, 'Professeur', 'Le', 3, 'casa@papel.com', 'netflix'),
(42, 'Admin', 'Admin', 1, 'admin@admin.com', 'admin'),
(43, 'Test', 'Etudiant', 4, '4', '4'),
(44, 'Test', 'Professeur', 3, '3', '3'),
(45, 'Ferdeghini', 'Filippo', 3, 'filippo@ece.fr', 'cosinus'),
(46, 'Girinsky', 'Olivier', 3, 'olivier@ece.fr', 'olive'),
(47, 'Reese', 'James', 3, 'james@ece.fr', 'damn'),
(48, 'Luxereau', 'Anne', 3, 'anne@ece.fr', 'oui');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`ID_Cours`);

--
-- Indexes for table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`ID_utilisateur`,`ID_cours`),
  ADD KEY `enseignant_cours_fk` (`ID_cours`);

--
-- Indexes for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`ID_Utilisateur`),
  ADD UNIQUE KEY `Numero` (`Numero`),
  ADD KEY `etudiant_groupe_fk` (`ID_Groupe`),
  ADD KEY `etudiant_utilisateur_fk` (`ID_Utilisateur`);

--
-- Indexes for table `groupe`
--
ALTER TABLE `groupe`
  ADD PRIMARY KEY (`ID_groupe`),
  ADD KEY `groupe_promotion_fk` (`ID_promotion`);

--
-- Indexes for table `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`ID_promotion`) USING BTREE;

--
-- Indexes for table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`ID_salle`),
  ADD KEY `salle_site_fk` (`ID_site`);

--
-- Indexes for table `seance`
--
ALTER TABLE `seance`
  ADD PRIMARY KEY (`ID_seance`),
  ADD KEY `seance_cours_fk` (`ID_cours`),
  ADD KEY `seance_type_fk` (`ID_type`);

--
-- Indexes for table `seance_enseignants`
--
ALTER TABLE `seance_enseignants`
  ADD PRIMARY KEY (`ID_seance`,`ID_utilisateur`),
  ADD KEY `se_enseignant_fk` (`ID_utilisateur`);

--
-- Indexes for table `seance_groupes`
--
ALTER TABLE `seance_groupes`
  ADD PRIMARY KEY (`ID_seance`,`ID_groupe`),
  ADD KEY `sg_groupe_fk` (`ID_groupe`);

--
-- Indexes for table `seance_salles`
--
ALTER TABLE `seance_salles`
  ADD PRIMARY KEY (`ID_seance`,`ID_salle`),
  ADD KEY `ss_salle_fk` (`ID_salle`);

--
-- Indexes for table `site`
--
ALTER TABLE `site`
  ADD PRIMARY KEY (`ID_site`);

--
-- Indexes for table `type_cours`
--
ALTER TABLE `type_cours`
  ADD PRIMARY KEY (`ID_type`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`ID_utilisateur`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cours`
--
ALTER TABLE `cours`
  MODIFY `ID_Cours` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=118;

--
-- AUTO_INCREMENT for table `groupe`
--
ALTER TABLE `groupe`
  MODIFY `ID_groupe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `promotion`
--
ALTER TABLE `promotion`
  MODIFY `ID_promotion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `salle`
--
ALTER TABLE `salle`
  MODIFY `ID_salle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `seance`
--
ALTER TABLE `seance`
  MODIFY `ID_seance` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `site`
--
ALTER TABLE `site`
  MODIFY `ID_site` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `type_cours`
--
ALTER TABLE `type_cours`
  MODIFY `ID_type` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `ID_utilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

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