/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 22/09/2019 13:51:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cou
-- ----------------------------
DROP TABLE IF EXISTS `cou`;
CREATE TABLE `cou`  (
  `cid` int(5) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cou
-- ----------------------------
INSERT INTO `cou` VALUES (1, 'JavaEE');
INSERT INTO `cou` VALUES (2, 'JavaSE');
INSERT INTO `cou` VALUES (3, 'Android');

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`  (
  `cid` int(5) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES (1, '中国');
INSERT INTO `country` VALUES (2, '美国');

-- ----------------------------
-- Table structure for middle
-- ----------------------------
DROP TABLE IF EXISTS `middle`;
CREATE TABLE `middle`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `stuId` int(5) NULL DEFAULT NULL,
  `couId` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of middle
-- ----------------------------
INSERT INTO `middle` VALUES (1, 1, 1);
INSERT INTO `middle` VALUES (2, 1, 2);
INSERT INTO `middle` VALUES (3, 2, 2);
INSERT INTO `middle` VALUES (4, 2, 3);
INSERT INTO `middle` VALUES (5, 3, 2);
INSERT INTO `middle` VALUES (6, 3, 3);

-- ----------------------------
-- Table structure for minister
-- ----------------------------
DROP TABLE IF EXISTS `minister`;
CREATE TABLE `minister`  (
  `mid` int(5) NOT NULL AUTO_INCREMENT,
  `mname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `countryId` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of minister
-- ----------------------------
INSERT INTO `minister` VALUES (1, '张三', 1);
INSERT INTO `minister` VALUES (2, '李四', 1);
INSERT INTO `minister` VALUES (3, 'Tom', 2);
INSERT INTO `minister` VALUES (4, 'Jim', 2);

-- ----------------------------
-- Table structure for newslabel
-- ----------------------------
DROP TABLE IF EXISTS `newslabel`;
CREATE TABLE `newslabel`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of newslabel
-- ----------------------------
INSERT INTO `newslabel` VALUES (1, '娱乐新闻', 0);
INSERT INTO `newslabel` VALUES (2, '体育新闻', 0);
INSERT INTO `newslabel` VALUES (3, '内地影视', 1);
INSERT INTO `newslabel` VALUES (4, '港台明星', 1);
INSERT INTO `newslabel` VALUES (5, 'NBA', 2);
INSERT INTO `newslabel` VALUES (6, 'CBA', 2);
INSERT INTO `newslabel` VALUES (7, '仙剑', 3);
INSERT INTO `newslabel` VALUES (8, '琅琊榜', 3);
INSERT INTO `newslabel` VALUES (9, '周星驰', 4);
INSERT INTO `newslabel` VALUES (10, '张学友', 4);
INSERT INTO `newslabel` VALUES (11, '湖人', 5);
INSERT INTO `newslabel` VALUES (12, '骑士', 5);
INSERT INTO `newslabel` VALUES (13, '北京篮球', 6);

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu`  (
  `sid` int(5) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES (1, '张三');
INSERT INTO `stu` VALUES (2, '李四');
INSERT INTO `stu` VALUES (3, '王五');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(20) NULL DEFAULT NULL,
  `score` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '小小小万', 22, NULL);
INSERT INTO `student` VALUES (3, '小万', 23, '93.0');
INSERT INTO `student` VALUES (5, '小万', 23, '93.0');
INSERT INTO `student` VALUES (16, '小万', 23, '93.0');
INSERT INTO `student` VALUES (17, '小万', 23, '93.0');
INSERT INTO `student` VALUES (18, '小万', 23, '60');
INSERT INTO `student` VALUES (19, '小万', 23, '60');
INSERT INTO `student` VALUES (20, '小万', 23, '60');
INSERT INTO `student` VALUES (21, '小万', 23, '60');
INSERT INTO `student` VALUES (22, '小万', 23, '60');
INSERT INTO `student` VALUES (23, '小万', 23, '60');
INSERT INTO `student` VALUES (24, '小万', 23, '60');
INSERT INTO `student` VALUES (25, '小万', 23, '60');
INSERT INTO `student` VALUES (26, '小万', 23, '60');
INSERT INTO `student` VALUES (27, '小万', 23, '60');
INSERT INTO `student` VALUES (28, '小万', 23, '60');
INSERT INTO `student` VALUES (29, '小万', 23, '60');
INSERT INTO `student` VALUES (32, '小万', 23, '60');
INSERT INTO `student` VALUES (33, '小万', 23, '60');
INSERT INTO `student` VALUES (34, '小万', 23, '60');
INSERT INTO `student` VALUES (35, '小万', 23, '60');
INSERT INTO `student` VALUES (36, '小万', 23, '60');
INSERT INTO `student` VALUES (37, '小万', 23, '60');
INSERT INTO `student` VALUES (38, '小万', 23, '60');
INSERT INTO `student` VALUES (39, '大万', 23, '60');
INSERT INTO `student` VALUES (47, '小万', 23, '93.0');
INSERT INTO `student` VALUES (48, '小万', 23, '93.0');
INSERT INTO `student` VALUES (49, '小万', 23, '93.0');
INSERT INTO `student` VALUES (50, '小万', 23, '93.0');

SET FOREIGN_KEY_CHECKS = 1;
