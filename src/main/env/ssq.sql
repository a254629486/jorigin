/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.6.25 : Database - ssq
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssq` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ssq`;

/*Table structure for table `totalball` */

DROP TABLE IF EXISTS `totalball`;

CREATE TABLE `totalball` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `opendate` date DEFAULT NULL,
  `red1` int(11) DEFAULT NULL,
  `red2` int(11) DEFAULT NULL,
  `red3` int(11) DEFAULT NULL,
  `red4` int(11) DEFAULT NULL,
  `red5` int(11) DEFAULT NULL,
  `red6` int(11) DEFAULT NULL,
  `blue` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `totalball` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
