CREATE DATABASE  IF NOT EXISTS `projetofinal` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `projetofinal`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: projetofinal
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `anamnese`
--

DROP TABLE IF EXISTS `anamnese`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anamnese` (
  `idAnamnese` int NOT NULL AUTO_INCREMENT,
  `exameFisico` varchar(100) DEFAULT NULL,
  `data` varchar(100) DEFAULT NULL,
  `Pessoa_id_Paciente` int NOT NULL,
  `Pessoa_id_Medico` int NOT NULL,
  `hipotesesDiag` varchar(100) DEFAULT NULL,
  `diagDefinitivo` varchar(100) DEFAULT NULL,
  `laudo` varchar(100) DEFAULT NULL,
  `exameComplementar` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idAnamnese`),
  UNIQUE KEY `idAnamnese_UNIQUE` (`idAnamnese`),
  KEY `fk_Anamnese_Pessoa1` (`Pessoa_id_Paciente`),
  KEY `fk_Anamnese_Pessoa2` (`Pessoa_id_Medico`),
  CONSTRAINT `fk_Anamnese_Pessoa1` FOREIGN KEY (`Pessoa_id_Paciente`) REFERENCES `pessoa` (`id_pessoa`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_Anamnese_Pessoa2` FOREIGN KEY (`Pessoa_id_Medico`) REFERENCES `pessoa` (`id_pessoa`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anamnese`
--

LOCK TABLES `anamnese` WRITE;
/*!40000 ALTER TABLE `anamnese` DISABLE KEYS */;
INSERT INTO `anamnese` VALUES (26,'Queda de moto','Thu Jun 15 18:59:34 BRT 2023',15,1,'','','','Raio X'),(27,'machucou de correr','Sat Jun 17 11:47:42 BRT 2023',16,1,'','','','exame de urina'),(28,'','Sat Jun 17 11:48:17 BRT 2023',15,1,'pode ter ocorrido fraqueza no joelho','','',''),(29,'teste','Tue Jun 20 19:15:59 BRT 2023',15,1,'teste 22222','teste 22222','teste 22222','teste 22222'),(30,'TESTE 44444','Tue Jun 20 19:20:41 BRT 2023',15,18,'','TESTE 44444','TESTE 44444','TESTE 44444');
/*!40000 ALTER TABLE `anamnese` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa` (
  `id_pessoa` int NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `DataNasc` varchar(45) NOT NULL,
  `Sexo` varchar(45) NOT NULL,
  `NomeMae` varchar(45) NOT NULL,
  `NaturalidadeMuni` varchar(45) NOT NULL,
  `Endereco` varchar(45) NOT NULL,
  `NaturalidadeEsta` varchar(45) NOT NULL,
  `flagMedico` int NOT NULL,
  PRIMARY KEY (`id_pessoa`),
  UNIQUE KEY `id_pessoa_UNIQUE` (`id_pessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'Hugo Martins Cavalcante','13/01/2001','Feminino','Marcia Luiz Martins','Patos De Minas','Rua 4 quadra 21 lote 14 A Taquaralto V','Minas Gerais',1),(14,'jose','13/01/2001','Masculino','ana','Palmas','rua 4','TO',2),(15,'jose','13/01/2001','Masculino','ana','Palmas','rua','TO',2),(16,'jose almeida','15/02/2001','Masculino','Ana lucia','Palmas','ALAMEDA 2','Tocantins',2),(18,'Vinicius Oliveira Costa','01-01-2021','Masculino','MÃ£e Teste','PALMAS','RUA TESTE','TOCANTINS',1);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `Login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `pessoaID` int NOT NULL,
  PRIMARY KEY (`Login`,`pessoaID`),
  UNIQUE KEY `Login_UNIQUE` (`Login`),
  KEY `fk_usuario_Medico1` (`pessoaID`),
  CONSTRAINT `fk_usuario_Medico1` FOREIGN KEY (`pessoaID`) REFERENCES `pessoa` (`id_pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('100','000',15),('1000','123',1),('1111','123',18),('555555555','123',16);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-20 19:29:25
