-- MySQL dump 10.13  Distrib 8.1.0, for macos12.6 (x86_64)
--
-- Host: 43.138.27.118    Database: lab
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item` varchar(128) DEFAULT NULL,
  `full_name` varchar(256) DEFAULT NULL,
  `vendor` varchar(128) DEFAULT NULL,
  `catalog` varchar(128) DEFAULT NULL,
  `last_ordered_date` datetime DEFAULT NULL,
  `last_received_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (1,'human NFAT engineered','UniRack™ and UniRack™Jr. Centrifuge Tube Racks, Simport Scientific - S500-25Y, UniRack™ Jr.','Addgene','13-711-7M','2023-12-09 09:17:44',NULL),(2,'Item1','Full Name1','Vendor1','Catalog1',NULL,NULL),(4,'Item1','Full Name1','Vendor1','Catalog1',NULL,NULL);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `owner` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `distributor` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `channel` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `unit` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `qty` int DEFAULT NULL,
  `unit_price` decimal(10,2) DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `location` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `date_request` datetime DEFAULT NULL,
  `date_order` datetime DEFAULT NULL,
  `date_received` datetime DEFAULT NULL,
  `link` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `inventory_id` int DEFAULT NULL,
  `notes` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (8,'test','Roman Jerala','B2P','50ml',1,30.00,30.00,'Diana\'s DNA Box','2023-12-09 18:28:06','2023-12-09 18:28:06','2023-12-09 18:28:06','https://google.com',1,NULL),(9,'test','Roman Jerala','Amazon','150ml',2,40.00,80.00,'Diana\'s DNA Box','2023-12-09 18:28:06','2023-12-09 18:28:06','2023-12-09 18:28:06','https://google.com',1,NULL),(10,'test','Roman Jerala','Amazon','200ml',3,50.00,150.00,'Diana\'s DNA Box','2023-12-09 18:28:06','2023-12-09 18:28:06','2023-12-09 18:28:06','https://google.com',1,NULL),(11,NULL,'Distributor1',NULL,'20ml',2,3.00,NULL,NULL,'2023-12-09 00:00:00',NULL,NULL,'1 Link',4,NULL);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
  `age` int DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sex` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `status` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `active` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Jone',18,'test1@baomidou.com','2','MAN','0',0),(2,'Jack',20,'test2@baomidou.com','3','MAN','0',0),(3,'Tom',28,'test3@baomidou.com','3','MAN','0',0),(4,'Sandy',21,'test4@baomidou.com','5','WOMAN','1',1),(5,'Billie',24,'test5@baomidou.com','6','WOMAN','1',1),(6,'JH',22,'test6@baomidou.com','1','MAN','1',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-09 19:06:19
