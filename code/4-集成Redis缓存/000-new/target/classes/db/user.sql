/*
Navicat MySQL Data Transfer

Source Server         : jd5
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2019-09-05 12:05:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `userName` varchar(32) NOT NULL COMMENT '用户名称',
  `passWord` varchar(50) NOT NULL COMMENT '用户密码',
  `realName` varchar(32) DEFAULT NULL COMMENT '中文名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'anson', '123', '张三');
INSERT INTO `user` VALUES ('2', 'Alex', '123', '李四');
INSERT INTO `user` VALUES ('3', 'kks', '123', '王五');
