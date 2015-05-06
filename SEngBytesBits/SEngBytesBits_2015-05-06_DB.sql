# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: localhost (MySQL 5.6.21)
# Database: SEngBytesBits
# Generation Time: 2015-05-06 21:24:41 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table Articulo
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Articulo`;

CREATE TABLE `Articulo` (
  `idArticulo` varchar(45) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `tema` varchar(45) NOT NULL,
  `fechaPublicacion` datetime NOT NULL,
  `publicado` tinyint(1) NOT NULL,
  `autorizado` tinyint(1) NOT NULL,
  `idRevista` varchar(45) NOT NULL,
  `idJuez` varchar(45) NOT NULL,
  PRIMARY KEY (`idArticulo`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

LOCK TABLES `Articulo` WRITE;
/*!40000 ALTER TABLE `Articulo` DISABLE KEYS */;

INSERT INTO `Articulo` (`idArticulo`, `titulo`, `tema`, `fechaPublicacion`, `publicado`, `autorizado`, `idRevista`, `idJuez`)
VALUES
	('Ar1','Inteligencia Artificial en los Negocios','A.I.','2015-03-13 00:00:00',1,1,'R1','J1'),
	('Ar2','Internet en los Colegios','Internet','2015-02-13 00:00:00',1,1,'R2','J2'),
	('Ar3','Bitcoin y el Lavado de Dinero','Bitcoin','2014-03-14 00:00:00',1,1,'R3','J2'),
	('Ar4','Analisis de Datos','Big Data','2014-08-12 00:00:00',1,1,'R4','J3'),
	('Ar5','Realidad Virtual en Juegos','V.R.','2014-08-14 00:00:00',1,1,'R4','J1');

/*!40000 ALTER TABLE `Articulo` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ArticuloAutor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ArticuloAutor`;

CREATE TABLE `ArticuloAutor` (
  `idArticulo` varchar(45) NOT NULL,
  `idAutor` varchar(45) NOT NULL,
  PRIMARY KEY (`idArticulo`,`idAutor`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

LOCK TABLES `ArticuloAutor` WRITE;
/*!40000 ALTER TABLE `ArticuloAutor` DISABLE KEYS */;

INSERT INTO `ArticuloAutor` (`idArticulo`, `idAutor`)
VALUES
	('Ar1','A1'),
	('Ar2','A2'),
	('Ar3','A3'),
	('Ar4','A1'),
	('Ar5','A2');

/*!40000 ALTER TABLE `ArticuloAutor` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Autor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Autor`;

CREATE TABLE `Autor` (
  `idAutor` varchar(45) NOT NULL,
  `nombreCompleto` varchar(45) NOT NULL,
  `fechaNacimiento` datetime NOT NULL,
  `corporacion` varchar(45) DEFAULT NULL,
  `sexo` char(1) NOT NULL,
  `permiso` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

LOCK TABLES `Autor` WRITE;
/*!40000 ALTER TABLE `Autor` DISABLE KEYS */;

INSERT INTO `Autor` (`idAutor`, `nombreCompleto`, `fechaNacimiento`, `corporacion`, `sexo`, `permiso`, `tipo`, `username`, `password`)
VALUES
	('A1','Isabela Garza','1991-05-21 00:00:00','','F','Autorizado','No activo','isa@me.com','password'),
	('A2','Paulina Escalante','1990-04-21 00:00:00','Tec de Monterrey','F','Autorizado','No activo','pau@me.com','password'),
	('A3','Ricardo Gonzalez','1995-04-23 00:00:00','UDEM','M','Autorizado','No activo','ric@me.com','password');

/*!40000 ALTER TABLE `Autor` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table CartaEditor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `CartaEditor`;

CREATE TABLE `CartaEditor` (
  `idCarta` varchar(45) NOT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `fechaPublicacion` datetime DEFAULT NULL,
  `tema` varchar(45) DEFAULT NULL,
  `publicado` tinyint(1) DEFAULT NULL,
  `idEditor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCarta`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

LOCK TABLES `CartaEditor` WRITE;
/*!40000 ALTER TABLE `CartaEditor` DISABLE KEYS */;

INSERT INTO `CartaEditor` (`idCarta`, `titulo`, `fechaPublicacion`, `tema`, `publicado`, `idEditor`)
VALUES
	('C1','Carta a los Ingenieros','2015-03-14 00:00:00','Etica',1,'E1'),
	('C2','Software en el Ambito Profesional','2015-02-20 00:00:00','Etica',1,'E1'),
	('C3','Carta por el Dia de Pi','2014-03-12 00:00:00','Etica',1,'E1'),
	('C4','Carta a Jovenes Desarrolladores','2014-08-11 00:00:00','Etica',1,'E1');

/*!40000 ALTER TABLE `CartaEditor` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Editor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Editor`;

CREATE TABLE `Editor` (
  `idEditor` varchar(45) NOT NULL,
  `nombreCompleto` varchar(45) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `fechaNacimiento` datetime DEFAULT NULL,
  `fechaEntrada` datetime DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEditor`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

LOCK TABLES `Editor` WRITE;
/*!40000 ALTER TABLE `Editor` DISABLE KEYS */;

INSERT INTO `Editor` (`idEditor`, `nombreCompleto`, `sexo`, `fechaNacimiento`, `fechaEntrada`, `username`, `password`)
VALUES
	('E1','Walter Mitty','M','1980-03-23 00:00:00','2014-03-02 00:00:00','walt@me.com','password');

/*!40000 ALTER TABLE `Editor` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Juez
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Juez`;

CREATE TABLE `Juez` (
  `idJuez` varchar(45) NOT NULL,
  `nombreCompleto` varchar(45) NOT NULL,
  `fechaNacimiento` datetime NOT NULL,
  `sexo` char(1) NOT NULL,
  `fechaEntrada` datetime NOT NULL,
  `idEditor` varchar(45) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idJuez`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

LOCK TABLES `Juez` WRITE;
/*!40000 ALTER TABLE `Juez` DISABLE KEYS */;

INSERT INTO `Juez` (`idJuez`, `nombreCompleto`, `fechaNacimiento`, `sexo`, `fechaEntrada`, `idEditor`, `username`, `password`)
VALUES
	('J1','Manuel Maltos','1959-02-24 00:00:00','M','2015-01-23 00:00:00','E1','manuel@me.com','password'),
	('J2','Julissa Portillo','1991-12-14 00:00:00','F','2015-02-02 00:00:00','E1','juli@me.com','password'),
	('J3','Sofia Morena','1982-11-23 00:00:00','F','2014-11-23 00:00:00','E1','sofi@me.com','password');

/*!40000 ALTER TABLE `Juez` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Orden
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Orden`;

CREATE TABLE `Orden` (
  `idOrden` varchar(45) NOT NULL,
  `precio` double DEFAULT NULL,
  `descuento` double DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fechaExpiracion` datetime DEFAULT NULL,
  `tipoRevista` char(1) DEFAULT NULL,
  `idSuscriptor` varchar(45) DEFAULT NULL,
  `idPago` varchar(45) DEFAULT NULL,
  `idAutor` varchar(45) DEFAULT NULL,
  `idJuez` varchar(45) DEFAULT NULL,
  `idRevista` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idOrden`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;



# Dump of table Pago
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Pago`;

CREATE TABLE `Pago` (
  `idPago` varchar(45) NOT NULL,
  `cantidad` double NOT NULL,
  `fechaPago` varchar(45) NOT NULL,
  PRIMARY KEY (`idPago`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;



# Dump of table Revista
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Revista`;

CREATE TABLE `Revista` (
  `idRevista` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fechaPublicacion` datetime NOT NULL,
  `numeroImpresiones` int(11) NOT NULL,
  `idCarta` varchar(45) NOT NULL,
  PRIMARY KEY (`idRevista`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

LOCK TABLES `Revista` WRITE;
/*!40000 ALTER TABLE `Revista` DISABLE KEYS */;

INSERT INTO `Revista` (`idRevista`, `nombre`, `fechaPublicacion`, `numeroImpresiones`, `idCarta`)
VALUES
	('R1','Maravillas Tecnologicas','2015-03-24 00:00:00',120,'C1'),
	('R2','Investigaciones en Nanotecnologia','2015-02-24 00:00:00',100,'C2'),
	('R3','Productos del Internet','2014-03-24 00:00:00',160,'C3'),
	('R4','Libros vs. Ipad','2014-08-24 00:00:00',180,'C4');

/*!40000 ALTER TABLE `Revista` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Suscriptor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Suscriptor`;

CREATE TABLE `Suscriptor` (
  `idSuscriptor` varchar(45) NOT NULL,
  `nombreCompleto` varchar(45) NOT NULL,
  `corporacion` varchar(45) DEFAULT NULL,
  `fechaNacimiento` datetime NOT NULL,
  `fechaEntrada` datetime NOT NULL,
  `sexo` char(1) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `tarjetaCredito` varchar(45) NOT NULL,
  `clave` int(11) NOT NULL,
  `fechaExpiracion` datetime DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idSuscriptor`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

LOCK TABLES `Suscriptor` WRITE;
/*!40000 ALTER TABLE `Suscriptor` DISABLE KEYS */;

INSERT INTO `Suscriptor` (`idSuscriptor`, `nombreCompleto`, `corporacion`, `fechaNacimiento`, `fechaEntrada`, `sexo`, `direccion`, `tarjetaCredito`, `clave`, `fechaExpiracion`, `username`, `password`)
VALUES
	('S1','Raul Jimenez','','1994-05-12 00:00:00','2014-08-23 00:00:00','M','Garza Sada 12','130043598234576',1234,'2017-04-01 00:00:00','raul@me.com','password'),
	('S2','1','','1994-05-12 00:00:00','2014-08-23 00:00:00','M','1','1',1,'2017-04-01 00:00:00','1','1');

/*!40000 ALTER TABLE `Suscriptor` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
