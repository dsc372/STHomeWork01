/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : db_sthomework01

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2021-04-24 16:13:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生学号（唯一）',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学生姓名',
  `birDate` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学生出生日期',
  `gender` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学生性别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2018000010 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('2018000001', '韦鲁斯', '20000101', '男');
INSERT INTO `t_student` VALUES ('2018000002', '霞', '19990101', '女');
INSERT INTO `t_student` VALUES ('2018000003', '艾希', '19980101', '女');
INSERT INTO `t_student` VALUES ('2018000004', '伊泽瑞尔', '19970101', '男');
INSERT INTO `t_student` VALUES ('2018000005', '凯特琳', '19960101', '女');
INSERT INTO `t_student` VALUES ('2018000006', '卡莎', '19950101', '女');
INSERT INTO `t_student` VALUES ('2018000007', '德莱文', '19940101', '男');
INSERT INTO `t_student` VALUES ('2018000008', '薇恩', '19930101', '女');
