/*
Navicat MySQL Data Transfer

Source Server         : ezdb
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : ezdb

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-10-26 17:38:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for episode
-- ----------------------------
DROP TABLE IF EXISTS `episode`;
CREATE TABLE `episode` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CLARITY` varchar(40) DEFAULT NULL COMMENT '清晰度',
  `SRC` varchar(100) DEFAULT NULL COMMENT '来源',
  `URL` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `SIGN` varchar(40) DEFAULT NULL COMMENT '标记',
  `USABLE` int(2) DEFAULT '0' COMMENT '是否有效0-有效，1-无效',
  `MD5` varchar(60) DEFAULT NULL COMMENT 'name的md5值',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
