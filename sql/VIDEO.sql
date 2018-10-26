/*
Navicat MySQL Data Transfer

Source Server         : ezdb
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : ezdb

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-10-26 17:38:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MD5` varchar(60) NOT NULL COMMENT 'name的md5值',
  `NAME` varchar(100) DEFAULT NULL COMMENT '名称',
  `DIRECTOR` varchar(40) DEFAULT NULL COMMENT '导演',
  `YEAR` varchar(10) DEFAULT NULL COMMENT '年份',
  `ACTORS` varchar(200) DEFAULT NULL COMMENT '主演',
  `LOCATION` varchar(40) DEFAULT NULL COMMENT '地区：内地、港台',
  `CLASSIFY` varchar(40) DEFAULT NULL COMMENT '分类：电影、电视、动漫',
  `CATEGORY` varchar(60) DEFAULT NULL COMMENT '类型：国产剧、美剧',
  `LANGUAGE` varchar(20) DEFAULT NULL COMMENT '语言：中文、粤语',
  `DESC` varchar(200) DEFAULT NULL COMMENT '剧情：古装、爱情',
  `IMG` varchar(200) DEFAULT NULL COMMENT '图片',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '详情：剧情介绍',
  `SRC` varchar(20) DEFAULT NULL COMMENT '来源',
  `FINISHED` int(1) DEFAULT '0' COMMENT '是否完结0-未完结，1-完结',
  `LASTNUM` varchar(10) DEFAULT NULL COMMENT '最新剧集',
  `STATUS` varchar(10) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
