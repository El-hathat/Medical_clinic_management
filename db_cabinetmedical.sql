-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 04 août 2023 à 13:43
-- Version du serveur : 10.4.25-MariaDB
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `db_cabinetmedical`
--

-- --------------------------------------------------------

--
-- Structure de la table `certificat`
--

CREATE TABLE `certificat` (
  `num` int(11) NOT NULL,
  `date_cer` date NOT NULL,
  `nbjours` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `consultation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `certificat`
--

INSERT INTO `certificat` (`num`, `date_cer`, `nbjours`, `type`, `consultation`) VALUES
(23, '2023-06-23', 5, 'accedent de travail', 22);

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

CREATE TABLE `consultation` (
  `num` int(11) NOT NULL,
  `date_consultation` date DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `frq_card` float DEFAULT NULL,
  `poids` float DEFAULT NULL,
  `prix` float DEFAULT NULL,
  `taille` int(11) DEFAULT NULL,
  `temperature` float DEFAULT NULL,
  `patient` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `consultation`
--

INSERT INTO `consultation` (`num`, `date_consultation`, `designation`, `frq_card`, `poids`, `prix`, `taille`, `temperature`, `patient`) VALUES
(22, '2023-06-23', 'gtgtgtgt', 90, 88, 600, 177, 38, 'd'),
(24, '2023-06-23', 'bbbbb', 39, 77, 950, 77, 38, 'd');

-- --------------------------------------------------------

--
-- Structure de la table `dossier_medicale`
--

CREATE TABLE `dossier_medicale` (
  `num` int(11) NOT NULL,
  `sang` varchar(255) DEFAULT NULL,
  `situation` varchar(255) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `date_creation` date DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `patient` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `dossier_medicale`
--

INSERT INTO `dossier_medicale` (`num`, `sang`, `situation`, `date_naissance`, `date_creation`, `note`, `patient`) VALUES
(21, 'B-', 'Celebataire', '2023-06-15', '2023-06-23', 'ffffffffff', 'd');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(25);

-- --------------------------------------------------------

--
-- Structure de la table `medcin`
--

CREATE TABLE `medcin` (
  `cin` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `etat` bit(1) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `nom_cabinet` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `medcin`
--

INSERT INTO `medcin` (`cin`, `email`, `etat`, `nom`, `nom_cabinet`, `prenom`, `pwd`, `role`) VALUES
('a', 'a', b'1', 'a', 'a', 'a', '$2a$10$cosEtfDvKd/wEGQID/6HnOcOorwROT8hmdZsGNOBT7IxptYGnBNbW', 'medcin'),
('hat', 'hathatmed', b'1', 'hathatmed', 'hathatmed', 'hathatmed', '$2a$10$bdq1vlfM0iuEDXWTbsmuCeVb1dt3EUIyWKqcjTs3iOIAXyGOpWGVq', 'medcin'),
('p', 'p', b'1', 'p', 'a', 'jjjjjj', '$2a$10$rXPKuDlS19o1a./GiHPkEOihHO3LYVJBK9vpriT2PofDZtqPjFUWi', 'secretaire'),
('sam', 'alasahbi', b'1', 'hathatmed', 'hathatmed', 'hathatmed', '$2a$10$Lf3EDEmd2LO6eEdkeBacde.2EdVJXtyeY4qZtde/WCDR5lx2zgLEm', 'medcin'),
('sim', 'alilo', b'1', 'hathatmed', 'hathatmed', 'hathatmed', '$2a$10$3J2.9A41uCUGhbhP9.GWte/ehB5eg7KgmlYWebE68Dps7GiA4sNC.', 'medcin');

-- --------------------------------------------------------

--
-- Structure de la table `ordonnance`
--

CREATE TABLE `ordonnance` (
  `num` int(11) NOT NULL,
  `date_ordonnance` date DEFAULT NULL,
  `medicaments` varchar(255) DEFAULT NULL,
  `consultation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `cin` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `cabinet` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `etat` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `sexe` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `medcin` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`cin`, `adresse`, `age`, `cabinet`, `email`, `etat`, `nom`, `prenom`, `sexe`, `tel`, `medcin`) VALUES
('d', 'ddddd', 19, 'a', 'd@gmail.com', 'En Attente', 'd', 'd', 'Masculin', '0766665', 'p');

-- --------------------------------------------------------

--
-- Structure de la table `plage_horaire`
--

CREATE TABLE `plage_horaire` (
  `id_plage` int(11) NOT NULL,
  `date_plage` date DEFAULT NULL,
  `heure_deb` varchar(255) DEFAULT NULL,
  `heure_fin` varchar(255) DEFAULT NULL,
  `medcin` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

CREATE TABLE `rdv` (
  `num` int(11) NOT NULL,
  `daterdv` datetime DEFAULT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `heurerdv` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `medcin` varchar(255) DEFAULT NULL,
  `patient` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `rdv`
--

INSERT INTO `rdv` (`num`, `daterdv`, `etat`, `heurerdv`, `note`, `medcin`, `patient`) VALUES
(13, '2023-06-18 00:00:00', 'en attente', '11:18', 'gdgdgdgdg', 'p', 'd');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `certificat`
--
ALTER TABLE `certificat`
  ADD PRIMARY KEY (`num`),
  ADD KEY `FKa6adcj5wlna3lxxrssc6ecu3c` (`consultation`);

--
-- Index pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD PRIMARY KEY (`num`),
  ADD KEY `FKtbfp9uco7x5ey4vckqblkycs3` (`patient`);

--
-- Index pour la table `dossier_medicale`
--
ALTER TABLE `dossier_medicale`
  ADD PRIMARY KEY (`num`),
  ADD KEY `FKkyt4eb03j9l3y8dd61uc33unk` (`patient`);

--
-- Index pour la table `medcin`
--
ALTER TABLE `medcin`
  ADD PRIMARY KEY (`cin`);

--
-- Index pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  ADD PRIMARY KEY (`num`),
  ADD KEY `FKib6g60lav9dxmf9l511ssogo9` (`consultation`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`cin`),
  ADD KEY `FK5sof89gnyk03pxx605rbau8ws` (`medcin`);

--
-- Index pour la table `plage_horaire`
--
ALTER TABLE `plage_horaire`
  ADD PRIMARY KEY (`id_plage`),
  ADD KEY `FK8in77d66te8nmak0w2lkklhfj` (`medcin`);

--
-- Index pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD PRIMARY KEY (`num`),
  ADD KEY `FKdnqy7vo5cemb0k1wpglcdqhrf` (`medcin`),
  ADD KEY `FKbnlg1y5rf3h7otgrmypgaxv3d` (`patient`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `plage_horaire`
--
ALTER TABLE `plage_horaire`
  MODIFY `id_plage` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `rdv`
--
ALTER TABLE `rdv`
  MODIFY `num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `certificat`
--
ALTER TABLE `certificat`
  ADD CONSTRAINT `FKa6adcj5wlna3lxxrssc6ecu3c` FOREIGN KEY (`consultation`) REFERENCES `consultation` (`num`);

--
-- Contraintes pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `FKtbfp9uco7x5ey4vckqblkycs3` FOREIGN KEY (`patient`) REFERENCES `patient` (`cin`);

--
-- Contraintes pour la table `dossier_medicale`
--
ALTER TABLE `dossier_medicale`
  ADD CONSTRAINT `FKkyt4eb03j9l3y8dd61uc33unk` FOREIGN KEY (`patient`) REFERENCES `patient` (`cin`);

--
-- Contraintes pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  ADD CONSTRAINT `FKib6g60lav9dxmf9l511ssogo9` FOREIGN KEY (`consultation`) REFERENCES `consultation` (`num`);

--
-- Contraintes pour la table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `FK5sof89gnyk03pxx605rbau8ws` FOREIGN KEY (`medcin`) REFERENCES `medcin` (`cin`);

--
-- Contraintes pour la table `plage_horaire`
--
ALTER TABLE `plage_horaire`
  ADD CONSTRAINT `FK8in77d66te8nmak0w2lkklhfj` FOREIGN KEY (`medcin`) REFERENCES `medcin` (`cin`);

--
-- Contraintes pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD CONSTRAINT `FKbnlg1y5rf3h7otgrmypgaxv3d` FOREIGN KEY (`patient`) REFERENCES `patient` (`cin`),
  ADD CONSTRAINT `FKdnqy7vo5cemb0k1wpglcdqhrf` FOREIGN KEY (`medcin`) REFERENCES `medcin` (`cin`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
