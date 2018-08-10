-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: demo2
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `transactiontab`
--

DROP TABLE IF EXISTS `transactiontab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactiontab` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tdate` date DEFAULT NULL,
  `mdate` date DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `showtime` varchar(45) DEFAULT NULL,
  `sitid` varchar(150) DEFAULT NULL,
  `user` varchar(100) DEFAULT NULL,
  `bill` int(11) DEFAULT NULL,
  `totalsit` int(11) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactiontab`
--

LOCK TABLES `transactiontab` WRITE;
/*!40000 ALTER TABLE `transactiontab` DISABLE KEYS */;
INSERT INTO `transactiontab` VALUES (25,'2018-07-20','2018-07-26','dragonBall','4:30pm','1,2,3,4,12,104,78,77,146,127','aik',17000,10,'1'),(26,'2018-07-20','2018-07-26','dragonBall','7:30pm','1,2,3','aik',6000,3,'1'),(27,'2018-07-21','2018-07-26','dragonBall','7:30pm','10,11,12,13,14,15,16','aik',14000,7,'1'),(28,'2018-07-21','2018-07-26','dragonBall','7:30pm','20,28,27,34,49,45','Ariful Islam Khokon',12000,6,'01911807199'),(29,'2018-07-21','2018-07-26','dragonBall','7:30pm','39,38,36,37','Ariful Islam Khokon',8000,4,'01911807199'),(30,'2018-07-22','2018-07-23','fff','7:30pm','10,11,19','aik',369,3,'1'),(31,'2018-07-22','2018-07-23','fff','7:30pm','20,21,28,35','aik',492,4,'1'),(32,'2018-07-23','2018-07-23','fff','4:30pm','1,2,10','Ariful Islam Khokon',369,3,'01911807199'),(33,'2018-07-23','2018-07-23','fff','4:30pm','27,28,29,30,34,36','ahad',738,6,'123'),(34,'2018-07-24','2018-07-25','ljj','4:30pm','1,2,10,11','ahad',4000,4,'123'),(35,'2018-07-24','2018-07-25','ljj','4:30pm','13,21,29,36,35,42','ahad',6000,6,'123'),(36,'2018-08-07','2018-08-10','Avenger','4:30pm','1,11,12,106,117,122,121,120','ahad',12000,8,'123'),(37,'2018-08-07','2018-08-10','Avenger','4:30pm','14','ahad',2000,1,'123'),(38,'2018-08-07','2018-08-10','Avenger','4:30pm','26','ahad',2000,1,'123'),(39,'2018-08-07','2018-08-10','Avenger','4:30pm','26','ahad',2000,1,'123'),(40,'2018-08-07','2018-08-10','Avenger','4:30pm','26','ahad',2000,1,'123'),(41,'2018-08-07','2018-08-10','Avenger','7:30pm','1','ahad',2000,1,'123');
/*!40000 ALTER TABLE `transactiontab` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-10 11:43:41
