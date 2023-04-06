/*
 Navicat Premium Data Transfer

 Source Server         : luna-local
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : hros

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 06/04/2023 21:55:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for adjustsalary
-- ----------------------------
DROP TABLE IF EXISTS `adjustsalary`;
CREATE TABLE `adjustsalary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL,
  `asDate` date DEFAULT NULL COMMENT '调薪日期',
  `beforeSalary` int(11) DEFAULT NULL COMMENT '调前薪资',
  `afterSalary` int(11) DEFAULT NULL COMMENT '调后薪资',
  `reason` varchar(255) DEFAULT NULL COMMENT '调薪原因',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `pid` (`eid`) USING BTREE,
  CONSTRAINT `adjustsalary_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of adjustsalary
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for appraise
-- ----------------------------
DROP TABLE IF EXISTS `appraise`;
CREATE TABLE `appraise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL,
  `appDate` date DEFAULT NULL COMMENT '考评日期',
  `appResult` varchar(32) DEFAULT NULL COMMENT '考评结果',
  `appContent` varchar(255) DEFAULT NULL COMMENT '考评内容',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `pid` (`eid`) USING BTREE,
  CONSTRAINT `appraise_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of appraise
-- ----------------------------
BEGIN;
INSERT INTO `appraise` VALUES (43, 5271, '2023-03-15', '5', '转正考评', '转正通过');
COMMIT;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '部门名称',
  `parentId` int(11) DEFAULT NULL,
  `depPath` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `isParent` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES (1, '总公司', -1, '.1', 1, 1);
INSERT INTO `department` VALUES (148, '小部门', 1, '.1.148', 1, 1);
INSERT INTO `department` VALUES (149, '小小部门', 148, '.1.148.149', 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(10) DEFAULT NULL COMMENT '员工姓名',
  `gender` char(4) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `idCard` char(18) DEFAULT NULL COMMENT '身份证号',
  `wedlock` enum('已婚','未婚','离异') DEFAULT NULL COMMENT '婚姻状况',
  `nationId` int(11) DEFAULT NULL COMMENT '民族',
  `nativePlace` varchar(20) DEFAULT NULL COMMENT '籍贯',
  `politicId` int(11) DEFAULT NULL COMMENT '政治面貌',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `departmentId` int(11) DEFAULT NULL COMMENT '所属部门',
  `jobLevelId` int(11) DEFAULT NULL COMMENT '职称ID',
  `posId` int(11) DEFAULT NULL COMMENT '职位ID',
  `engageForm` varchar(8) DEFAULT NULL COMMENT '聘用形式',
  `tiptopDegree` enum('博士','硕士','本科','大专','高中','初中','小学','其他') DEFAULT NULL COMMENT '最高学历',
  `specialty` varchar(32) DEFAULT NULL COMMENT '所属专业',
  `school` varchar(32) DEFAULT NULL COMMENT '毕业院校',
  `beginDate` date DEFAULT NULL COMMENT '入职日期',
  `workState` enum('在职','离职') DEFAULT '在职' COMMENT '在职状态',
  `workID` char(8) DEFAULT NULL COMMENT '工号',
  `contractTerm` double DEFAULT NULL COMMENT '合同期限',
  `conversionTime` date DEFAULT NULL COMMENT '转正日期',
  `notWorkDate` date DEFAULT NULL COMMENT '离职日期',
  `beginContract` date DEFAULT NULL COMMENT '合同起始日期',
  `endContract` date DEFAULT NULL COMMENT '合同终止日期',
  `workAge` int(11) DEFAULT NULL COMMENT '工龄',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_name` (`name`) USING BTREE,
  KEY `departmentId` (`departmentId`) USING BTREE,
  KEY `jobId` (`jobLevelId`) USING BTREE,
  KEY `dutyId` (`posId`) USING BTREE,
  KEY `nationId` (`nationId`) USING BTREE,
  KEY `politicId` (`politicId`) USING BTREE,
  KEY `workID_key` (`workID`) USING BTREE,
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`),
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`jobLevelId`) REFERENCES `joblevel` (`id`),
  CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`posId`) REFERENCES `position` (`id`),
  CONSTRAINT `employee_ibfk_4` FOREIGN KEY (`nationId`) REFERENCES `nation` (`id`),
  CONSTRAINT `employee_ibfk_5` FOREIGN KEY (`politicId`) REFERENCES `politicsstatus` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5272 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of employee
-- ----------------------------
BEGIN;
INSERT INTO `employee` VALUES (5268, '小红', '男', '1998-10-08', '150124199510081276', '未婚', 1, '中国', 3, '00000001@qq.com', '15692756582', '江苏盐城', 1, 14, 33, '劳动合同', '本科', '软件工程', '盐城师范学院', '2023-03-03', '在职', '00000001', 1, '2023-03-03', NULL, '2023-03-03', '2024-03-11', NULL);
INSERT INTO `employee` VALUES (5271, '小白', '男', '1998-10-08', '150124199510081276', '未婚', 1, '重庆', 3, '123123@qq.com', '15696756582', '无', 148, 16, 33, '劳动合同', '博士', '软件工程', '盐城师范', '2023-03-03', '在职', '00000002', 0, '2023-03-03', NULL, '2023-03-03', '2023-03-03', NULL);
COMMIT;

-- ----------------------------
-- Table structure for employee_recycle
-- ----------------------------
DROP TABLE IF EXISTS `employee_recycle`;
CREATE TABLE `employee_recycle` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(10) DEFAULT NULL COMMENT '员工姓名',
  `gender` char(4) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `idCard` char(18) DEFAULT NULL COMMENT '身份证号',
  `wedlock` enum('已婚','未婚','离异') DEFAULT NULL COMMENT '婚姻状况',
  `nationId` int(11) DEFAULT NULL COMMENT '民族',
  `nativePlace` varchar(20) DEFAULT NULL COMMENT '籍贯',
  `politicId` int(11) DEFAULT NULL COMMENT '政治面貌',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `departmentId` int(11) DEFAULT NULL COMMENT '所属部门',
  `jobLevelId` int(11) DEFAULT NULL COMMENT '职称ID',
  `posId` int(11) DEFAULT NULL COMMENT '职位ID',
  `engageForm` varchar(8) DEFAULT NULL COMMENT '聘用形式',
  `tiptopDegree` enum('博士','硕士','本科','大专','高中','初中','小学','其他') DEFAULT NULL COMMENT '最高学历',
  `specialty` varchar(32) DEFAULT NULL COMMENT '所属专业',
  `school` varchar(32) DEFAULT NULL COMMENT '毕业院校',
  `beginDate` date DEFAULT NULL COMMENT '入职日期',
  `workState` enum('在职','离职') DEFAULT '在职' COMMENT '在职状态',
  `workID` char(8) DEFAULT NULL COMMENT '工号',
  `contractTerm` double DEFAULT NULL COMMENT '合同期限',
  `conversionTime` date DEFAULT NULL COMMENT '转正日期',
  `notWorkDate` date DEFAULT NULL COMMENT '离职日期',
  `beginContract` date DEFAULT NULL COMMENT '合同起始日期',
  `endContract` date DEFAULT NULL COMMENT '合同终止日期',
  `workAge` int(11) DEFAULT NULL COMMENT '工龄',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `departmentId` (`departmentId`) USING BTREE,
  KEY `jobId` (`jobLevelId`) USING BTREE,
  KEY `dutyId` (`posId`) USING BTREE,
  KEY `nationId` (`nationId`) USING BTREE,
  KEY `politicId` (`politicId`) USING BTREE,
  KEY `workID_key` (`workID`) USING BTREE,
  CONSTRAINT `employee_recycle_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`),
  CONSTRAINT `employee_recycle_ibfk_2` FOREIGN KEY (`jobLevelId`) REFERENCES `joblevel` (`id`),
  CONSTRAINT `employee_recycle_ibfk_3` FOREIGN KEY (`posId`) REFERENCES `position` (`id`),
  CONSTRAINT `employee_recycle_ibfk_4` FOREIGN KEY (`nationId`) REFERENCES `nation` (`id`),
  CONSTRAINT `employee_recycle_ibfk_5` FOREIGN KEY (`politicId`) REFERENCES `politicsstatus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of employee_recycle
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for employeeec
-- ----------------------------
DROP TABLE IF EXISTS `employeeec`;
CREATE TABLE `employeeec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL COMMENT '员工编号',
  `ecDate` date DEFAULT NULL COMMENT '奖罚日期',
  `ecReason` varchar(255) DEFAULT NULL COMMENT '奖罚原因',
  `ecPoint` int(11) DEFAULT NULL COMMENT '奖罚分',
  `ecType` int(11) DEFAULT NULL COMMENT '奖罚类别，0：奖，1：罚',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `pid` (`eid`) USING BTREE,
  CONSTRAINT `employeeec_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of employeeec
-- ----------------------------
BEGIN;
INSERT INTO `employeeec` VALUES (131, 5271, '2023-03-15', '测试', NULL, 19, '测试');
COMMIT;

-- ----------------------------
-- Table structure for employeeremove
-- ----------------------------
DROP TABLE IF EXISTS `employeeremove`;
CREATE TABLE `employeeremove` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL,
  `afterDepId` int(11) DEFAULT NULL COMMENT '调动后部门',
  `afterJobId` int(11) DEFAULT NULL COMMENT '调动后职位',
  `removeDate` date DEFAULT NULL COMMENT '调动日期',
  `reason` varchar(255) DEFAULT NULL COMMENT '调动原因',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `pid` (`eid`) USING BTREE,
  CONSTRAINT `employeeremove_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of employeeremove
-- ----------------------------
BEGIN;
INSERT INTO `employeeremove` VALUES (11, 5268, 1, 15, '2023-03-10', NULL, NULL);
INSERT INTO `employeeremove` VALUES (12, 5268, 1, 14, '2023-03-10', NULL, NULL);
INSERT INTO `employeeremove` VALUES (13, 5268, 1, 14, '2023-03-10', NULL, NULL);
INSERT INTO `employeeremove` VALUES (14, 5268, 1, 14, '2023-03-10', NULL, NULL);
INSERT INTO `employeeremove` VALUES (15, 5268, 1, 14, '2023-03-10', NULL, NULL);
INSERT INTO `employeeremove` VALUES (16, 5271, 148, 16, '2023-03-15', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for employeetrain
-- ----------------------------
DROP TABLE IF EXISTS `employeetrain`;
CREATE TABLE `employeetrain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL COMMENT '员工编号',
  `trainstartDate` date DEFAULT NULL COMMENT '培训开始日期',
  `trainfinishDate` datetime DEFAULT NULL COMMENT '培训结束日期',
  `trainContent` varchar(255) DEFAULT NULL COMMENT '培训内容',
  `trainstatus` tinyint(4) DEFAULT NULL COMMENT '培训状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `pid` (`eid`) USING BTREE,
  CONSTRAINT `employeetrain_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=229 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of employeetrain
-- ----------------------------
BEGIN;
INSERT INTO `employeetrain` VALUES (228, 5271, '2023-03-15', '2023-03-16 00:00:00', '转正', 4, '转正培训');
COMMIT;

-- ----------------------------
-- Table structure for empsalary
-- ----------------------------
DROP TABLE IF EXISTS `empsalary`;
CREATE TABLE `empsalary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `eid` (`eid`) USING BTREE,
  KEY `empsalary_ibfk_2` (`sid`) USING BTREE,
  CONSTRAINT `empsalary_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`),
  CONSTRAINT `empsalary_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `salary` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of empsalary
-- ----------------------------
BEGIN;
INSERT INTO `empsalary` VALUES (109, 5268, 10);
INSERT INTO `empsalary` VALUES (110, 5268, 26);
INSERT INTO `empsalary` VALUES (111, 5271, 10);
COMMIT;

-- ----------------------------
-- Table structure for fileup
-- ----------------------------
DROP TABLE IF EXISTS `fileup`;
CREATE TABLE `fileup` (
  `fileld` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `filePath` varchar(255) DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  `fileSize` varchar(255) DEFAULT NULL,
  `fileType` varchar(255) DEFAULT NULL,
  `fileDate` datetime DEFAULT NULL,
  PRIMARY KEY (`fileld`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of fileup
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for hr
-- ----------------------------
DROP TABLE IF EXISTS `hr`;
CREATE TABLE `hr` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'hrID',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(16) DEFAULT NULL COMMENT '住宅电话',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `enabled` tinyint(1) DEFAULT '1',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `userface` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `employee_id` int(1) DEFAULT NULL COMMENT '员工Id',
  `work_date` text,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of hr
-- ----------------------------
BEGIN;
INSERT INTO `hr` VALUES (3, '系统管理员', '18568887789', '029-82881234', '深圳南山', 1, 'admin', '$2a$10$ey5EvT8bEjRGvlAV2Bs6Su8ct9V/h69UxTs7TSn8t8..nNpLs3igu', 'https://imgsa.baidu.com/forum/pic/item/a832bc315c6034a8df786e5ac31349540823766e.jpg', NULL, NULL, ',2023-02-28,2023-03-07,2023-03-14,2023-03-15,2023-03-20,2023-03-08,2023-03-02,2023-03-10,2023-03-16,2023-03-24,2023-03-06');
INSERT INTO `hr` VALUES (5, '李白', '18568123489', '029-82123434', '海口美兰', 1, 'libai', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://imgsa.baidu.com/forum/pic/item/a832bc315c6034a8df786e5ac31349540823766e.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (10, '韩愈', '18568123666', '029-82111555', '广州番禺', 1, 'hanyu', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://imgsa.baidu.com/forum/pic/item/f9ebc3cec3fdfc0323f23563dc3f8794a5c2267e.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (11, '柳宗元', '18568123377', '029-82111333', '广州天河', 1, 'liuzongyuan', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://imgsa.baidu.com/forum/pic/item/3ea40f2442a7d933062c32a8a54bd11372f00178.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (12, '曾巩', '18568128888', '029-82111222', '广州越秀', 1, 'zenggong', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://imgsa.baidu.com/forum/pic/item/83a0d0a20cf431ad9c5595e24336acaf2fdd9879.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (13, '徐凤年', '18568887789', '029-82881234', '深圳南山', 1, 'xufengnian', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', 'https://imgsa.baidu.com/forum/pic/item/a832bc315c6034a8df786e5ac31349540823766e.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (15, '徐晓', '18568123489', '029-82123434', '海口美兰', 1, 'xuxiao', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://imgsa.baidu.com/forum/pic/item/a832bc315c6034a8df786e5ac31349540823766e.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (16, '轩辕青峰', '18568123666', '029-82111555', '广州番禺', 1, 'xuanyuanqingfeng', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://imgsa.baidu.com/forum/pic/item/f9ebc3cec3fdfc0323f23563dc3f8794a5c2267e.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (17, '青鸟', '18568123377', '029-82111333', '广州天河', 1, 'qingniao', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://imgsa.baidu.com/forum/pic/item/3ea40f2442a7d933062c32a8a54bd11372f00178.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (18, '超级用户', '18568128888', '029-82111222', '广州越秀', 1, 'root', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://imgsa.baidu.com/forum/pic/item/83a0d0a20cf431ad9c5595e24336acaf2fdd9879.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (19, '徐脂虎', '18568887789', '029-82881234', '深圳南山', 1, 'xuzhihu', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', 'https://imgsa.baidu.com/forum/pic/item/3ea40f2442a7d933062c32a8a54bd11372f00178.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (20, '徐渭熊', '18568123489', '029-82123434', '海口美兰', 1, 'xuweixiong', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://imgsa.baidu.com/forum/pic/item/a832bc315c6034a8df786e5ac31349540823766e.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (21, '徐念凉', '18568123666', '029-82111555', '广州番禺', 1, 'xunianliang', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://imgsa.baidu.com/forum/pic/item/f9ebc3cec3fdfc0323f23563dc3f8794a5c2267e.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (22, '太阿剑九黄', '18568123377', '029-82111333', '广州天河', 1, 'laohuang', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://imgsa.baidu.com/forum/pic/item/3ea40f2442a7d933062c32a8a54bd11372f00178.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (23, '白衣僧人李当心', '18568128888', '029-82111222', '广州越秀', 1, 'lidangxin', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://imgsa.baidu.com/forum/pic/item/a832bc315c6034a8df786e5ac31349540823766e.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (24, '武帝城于新郎', '18568887789', '029-82881234', '深圳南山', 1, 'yuxinlang', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', 'https://imgsa.baidu.com/forum/pic/item/f9ebc3cec3fdfc0323f23563dc3f8794a5c2267e.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (25, '南诏韦淼', '18568123489', '029-82123434', '海口美兰', 1, 'weita', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://imgsa.baidu.com/forum/pic/item/3ea40f2442a7d933062c32a8a54bd11372f00178.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (26, '东越剑池柴青山', '18568123666', '029-82111555', '广州番禺', 1, '东越剑池柴青山', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://imgsa.baidu.com/forum/pic/item/83a0d0a20cf431ad9c5595e24336acaf2fdd9879.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (28, '温华', '18568128888', '029-82111222', '广州越秀', 1, 'zenggong', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517070040185&di=be0375e0c3db6c311b837b28c208f318&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Fpost%2F20150213%2F6%2F20150213141918532.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (29, '李义山', '18568887789', '029-82881234', '深圳南山', 1, 'liyishan', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (30, '王初冬', '18568123489', '029-82123434', '海口美兰', 1, 'wangchudong', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (31, '陆丞燕', '18568123666', '029-82111555', '广州番禺', 1, '陆丞燕', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1406745149,1563524794&fm=27&gp=0.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (32, '鱼玄机', '18568123377', '029-82111333', '广州天河', 1, 'yuxuanji', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515233756&di=0856d923a0a37a87fd26604a2c871370&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2014-09-27%2F041716704.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (33, '南宫仆射', '18568128888', '029-82111222', '广州越秀', 1, '南宫仆射', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517070040185&di=be0375e0c3db6c311b837b28c208f318&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Fpost%2F20150213%2F6%2F20150213141918532.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (34, '姜泥', '18568887789', '029-82881234', '深圳南山', 1, '姜泥', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (35, '西楚曹长卿', '18568123489', '029-82123434', '海口美兰', 1, '曹长卿', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (36, '孙希济　', '18568123666', '029-82111555', '广州番禺', 1, '孙希济', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1406745149,1563524794&fm=27&gp=0.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (38, '耶律洪才', '18568128888', '029-82111222', '广州越秀', 1, '耶律洪才', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517070040185&di=be0375e0c3db6c311b837b28c208f318&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Fpost%2F20150213%2F6%2F20150213141918532.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (39, '赫连武威', '18568887789', '029-82881234', '深圳南山', 1, '赫连武威', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (40, '呼延大观', '18568123489', '029-82123434', '海口美兰', 1, '呼延大观', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (41, '轩辕敬城', '18568123666', '029-82111555', '广州番禺', 1, '轩辕敬城', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1406745149,1563524794&fm=27&gp=0.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (43, '耶律洪才', '18568128888', '029-82111222', '广州越秀', 1, '耶律洪才', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517070040185&di=be0375e0c3db6c311b837b28c208f318&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Fpost%2F20150213%2F6%2F20150213141918532.jpg', NULL, NULL, NULL);
INSERT INTO `hr` VALUES (44, '员工角色', '2342342', '32423423', '员工角色', 1, '员工角色', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', 'https://imgsa.baidu.com/forum/pic/item/a832bc315c6034a8df786e5ac31349540823766e.jpg', '员工角色', NULL, NULL);
INSERT INTO `hr` VALUES (45, '小红', '2342342', '32423423', '测试', 1, '小红', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', 'https://imgsa.baidu.com/forum/pic/item/a832bc315c6034a8df786e5ac31349540823766e.jpg', '测试小红', 5268, NULL);
INSERT INTO `hr` VALUES (46, '小白', '15696756582', '32423423', '无', 1, '小白', '$2a$10$KGgUwzjGXyIwLovDLccnkOfTYMVMSIFs4CMVpH/.f1DxRN.DPvnuO', 'https://imgsa.baidu.com/forum/pic/item/a832bc315c6034a8df786e5ac31349540823766e.jpg', NULL, 5271, '2023-03-09,2023-03-14,2023-03-19,2023-03-27,2023-04-04,2023-04-03,2023-03-29');
COMMIT;

-- ----------------------------
-- Table structure for hr_role
-- ----------------------------
DROP TABLE IF EXISTS `hr_role`;
CREATE TABLE `hr_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hrid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `rid` (`rid`) USING BTREE,
  KEY `hr_role_ibfk_1` (`hrid`) USING BTREE,
  CONSTRAINT `hr_role_ibfk_1` FOREIGN KEY (`hrid`) REFERENCES `hr` (`id`),
  CONSTRAINT `hr_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=537 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of hr_role
-- ----------------------------
BEGIN;
INSERT INTO `hr_role` VALUES (511, 45, 34);
INSERT INTO `hr_role` VALUES (512, 44, 34);
INSERT INTO `hr_role` VALUES (524, 16, 6);
INSERT INTO `hr_role` VALUES (525, 16, 2);
INSERT INTO `hr_role` VALUES (530, 10, 6);
INSERT INTO `hr_role` VALUES (531, 5, 2);
INSERT INTO `hr_role` VALUES (532, 3, 6);
INSERT INTO `hr_role` VALUES (536, 46, 34);
COMMIT;

-- ----------------------------
-- Table structure for joblevel
-- ----------------------------
DROP TABLE IF EXISTS `joblevel`;
CREATE TABLE `joblevel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '职称名称',
  `titleLevel` enum('正高级','副高级','中级','初级','员级') DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of joblevel
-- ----------------------------
BEGIN;
INSERT INTO `joblevel` VALUES (9, '教授', '正高级', '2018-01-11 21:19:14', 0);
INSERT INTO `joblevel` VALUES (14, '初级工程师', '初级', '2018-01-14 16:18:50', 1);
INSERT INTO `joblevel` VALUES (15, '中级工程师', '中级', '2018-01-14 16:19:00', 1);
INSERT INTO `joblevel` VALUES (16, '高级工程师', '副高级', '2018-01-14 16:19:14', 1);
COMMIT;

-- ----------------------------
-- Table structure for logtype
-- ----------------------------
DROP TABLE IF EXISTS `logtype`;
CREATE TABLE `logtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `logtypemsg` varchar(255) DEFAULT NULL,
  `adddate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of logtype
-- ----------------------------
BEGIN;
INSERT INTO `logtype` VALUES (1, '系统设置修改', '2020-01-06 10:36:46');
INSERT INTO `logtype` VALUES (2, '员工入职', '2020-01-06 10:37:08');
INSERT INTO `logtype` VALUES (3, '员工奖惩', '2020-01-06 10:37:12');
INSERT INTO `logtype` VALUES (4, '员工培训', '2020-01-06 10:37:15');
INSERT INTO `logtype` VALUES (5, '员工调薪', '2020-01-06 10:37:19');
COMMIT;

-- ----------------------------
-- Table structure for main_notice
-- ----------------------------
DROP TABLE IF EXISTS `main_notice`;
CREATE TABLE `main_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `mainbody` mediumtext COMMENT '内容',
  `authon` varchar(11) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of main_notice
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL,
  `path` varchar(64) DEFAULT NULL,
  `component` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `iconCls` varchar(64) DEFAULT NULL,
  `keepAlive` tinyint(1) DEFAULT NULL,
  `requireAuth` tinyint(1) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `parentId` (`parentId`) USING BTREE,
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (1, '/', NULL, NULL, '主菜单', NULL, NULL, NULL, NULL, 1);
INSERT INTO `menu` VALUES (2, '/', '/home', 'Home', '员工资料', 'fa fa-user-circle-o', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (3, '/', '/home', 'Home', '人事管理', 'fa fa-address-card-o', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (4, '/', '/home', 'Home', '薪资管理', 'fa fa-money', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (5, '/', '/home', 'Home', '统计管理', 'fa fa-bar-chart', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (6, '/', '/home', 'Home', '系统管理', 'fa fa-windows', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (7, '/employee/basic/**', '/emp/basic', 'EmpBasic', '员工档案', 'fa fa-id-card-o', NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (8, '/employee/advanced/**', '/emp/adv', 'EmpAdv', '高级资料', 'fa fa-id-card', NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (9, '/employee/basic/**', '/emp/basic2', 'EmpBasic2', '基本资料', 'fa fa-id-card-o', NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (10, '/personnel/ec/**', '/per/ec', 'PerEc', '员工奖惩', 'fa fa-american-sign-language-interpreting', NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (11, '/personnel/train/**', '/per/train', 'PerTrain', '员工培训', 'fa fa-user-plus', NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (12, '/personnel/salary/**', '/per/salary', 'PerSalary', '员工调薪', 'fa fa-braille', NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (13, '/personnel/remove/**', '/per/mv', 'PerMv', '调动职务', 'fa fa-blind', NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (14, '/salary/sob/**', '/sal/sob', 'SalSob', '工资账套管理', 'fa fa-credit-card-alt ', NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (15, '/salary/sobcfg/**', '/sal/sobcfg', 'SalSobCfg', '员工账套设置', 'fa fa-cc-amex', NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (16, '/salary/table/**', '/sal/table', 'SalTable', '工资表管理', 'fa fa-indent', NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (19, '/statistics/all/**', '/sta/all', 'StaAll', '综合信息统计', 'fa fa-area-chart', NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (20, '/statistics/score/**', '/sta/score', 'StaScore', '员工积分统计', 'fa fa-line-chart', NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (21, '/statistics/personnel/**', '/sta/pers', 'StaPers', '人事信息分析', 'fa fa-pie-chart', NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (22, '/statistics/recored/**', '/sta/record', 'StaRecord', '人事记录分析', 'fa fa-bar-chart', NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (23, '/system/basic/**', '/sys/basic', 'SysBasic', '基础信息设置', 'fa fa-stack-overflow', NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (24, '/system/cfg/**', '/sys/cfg', 'SysCfg', '系统管理', 'fa fa-steam-square', NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (25, '/system/log/**', '/sys/log', 'SysLog', '操作日志管理', 'fa fa-list', NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (26, '/system/hr/**', '/sys/hr', 'SysHr', '操作员管理', 'fa fa-users', NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (27, '/system/hr/**', '/sys/hrbase', 'SysHrBase', '个人中心', 'fa fa-users', NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (28, '/employee/basic/**', '/emp/calenderBox', 'EmpCalenderBox', '员工打卡', 'fa fa-braille', NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (29, '/personnel/train/**', '/per/train2', 'PerTrain2', '个人培训', 'fa fa-user-plus', NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (30, '/personnel/ec/**', '/per/ec2', 'PerEc2', '个人奖惩', 'fa fa-american-sign-language-interpreting', NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (31, '/personnel/remove/**', '/per/mv2', 'PerMv2', '个人调动', 'fa fa-blind', NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (32, '/personnel/salary/**', '/per/salary2', 'PerSalary2', '个人调薪', 'fa fa-braille', NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (33, '/personnel/ec/**', '/per/work', 'PerWork', '考勤管理', 'fa fa-american-sign-language-interpreting', NULL, 1, 3, 1);
COMMIT;

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `mid` (`mid`) USING BTREE,
  KEY `rid` (`rid`) USING BTREE,
  CONSTRAINT `menu_role_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`),
  CONSTRAINT `menu_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1142 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
BEGIN;
INSERT INTO `menu_role` VALUES (922, 8, 2);
INSERT INTO `menu_role` VALUES (923, 7, 2);
INSERT INTO `menu_role` VALUES (924, 10, 2);
INSERT INTO `menu_role` VALUES (925, 11, 2);
INSERT INTO `menu_role` VALUES (926, 12, 2);
INSERT INTO `menu_role` VALUES (927, 13, 2);
INSERT INTO `menu_role` VALUES (928, 14, 2);
INSERT INTO `menu_role` VALUES (929, 15, 2);
INSERT INTO `menu_role` VALUES (930, 16, 2);
INSERT INTO `menu_role` VALUES (931, 19, 2);
INSERT INTO `menu_role` VALUES (932, 20, 2);
INSERT INTO `menu_role` VALUES (933, 21, 2);
INSERT INTO `menu_role` VALUES (934, 22, 2);
INSERT INTO `menu_role` VALUES (935, 23, 2);
INSERT INTO `menu_role` VALUES (936, 24, 2);
INSERT INTO `menu_role` VALUES (937, 25, 2);
INSERT INTO `menu_role` VALUES (938, 26, 2);
INSERT INTO `menu_role` VALUES (1085, 8, 34);
INSERT INTO `menu_role` VALUES (1086, 9, 34);
INSERT INTO `menu_role` VALUES (1087, 28, 34);
INSERT INTO `menu_role` VALUES (1088, 29, 34);
INSERT INTO `menu_role` VALUES (1089, 30, 34);
INSERT INTO `menu_role` VALUES (1090, 31, 34);
INSERT INTO `menu_role` VALUES (1091, 32, 34);
INSERT INTO `menu_role` VALUES (1092, 27, 34);
INSERT INTO `menu_role` VALUES (1117, 8, 6);
INSERT INTO `menu_role` VALUES (1118, 9, 6);
INSERT INTO `menu_role` VALUES (1119, 28, 6);
INSERT INTO `menu_role` VALUES (1120, 29, 6);
INSERT INTO `menu_role` VALUES (1121, 30, 6);
INSERT INTO `menu_role` VALUES (1122, 31, 6);
INSERT INTO `menu_role` VALUES (1123, 32, 6);
INSERT INTO `menu_role` VALUES (1124, 7, 6);
INSERT INTO `menu_role` VALUES (1125, 10, 6);
INSERT INTO `menu_role` VALUES (1126, 11, 6);
INSERT INTO `menu_role` VALUES (1127, 12, 6);
INSERT INTO `menu_role` VALUES (1128, 13, 6);
INSERT INTO `menu_role` VALUES (1129, 33, 6);
INSERT INTO `menu_role` VALUES (1130, 14, 6);
INSERT INTO `menu_role` VALUES (1131, 15, 6);
INSERT INTO `menu_role` VALUES (1132, 16, 6);
INSERT INTO `menu_role` VALUES (1133, 19, 6);
INSERT INTO `menu_role` VALUES (1134, 20, 6);
INSERT INTO `menu_role` VALUES (1135, 21, 6);
INSERT INTO `menu_role` VALUES (1136, 22, 6);
INSERT INTO `menu_role` VALUES (1137, 23, 6);
INSERT INTO `menu_role` VALUES (1138, 24, 6);
INSERT INTO `menu_role` VALUES (1139, 25, 6);
INSERT INTO `menu_role` VALUES (1140, 26, 6);
INSERT INTO `menu_role` VALUES (1141, 27, 6);
COMMIT;

-- ----------------------------
-- Table structure for msgcontent
-- ----------------------------
DROP TABLE IF EXISTS `msgcontent`;
CREATE TABLE `msgcontent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of msgcontent
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for nation
-- ----------------------------
DROP TABLE IF EXISTS `nation`;
CREATE TABLE `nation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of nation
-- ----------------------------
BEGIN;
INSERT INTO `nation` VALUES (1, '汉族');
INSERT INTO `nation` VALUES (2, '蒙古族');
INSERT INTO `nation` VALUES (3, '回族');
INSERT INTO `nation` VALUES (4, '藏族');
INSERT INTO `nation` VALUES (5, '维吾尔族');
INSERT INTO `nation` VALUES (6, '苗族');
INSERT INTO `nation` VALUES (7, '彝族');
INSERT INTO `nation` VALUES (8, '壮族');
INSERT INTO `nation` VALUES (9, '布依族');
INSERT INTO `nation` VALUES (10, '朝鲜族');
INSERT INTO `nation` VALUES (11, '满族');
INSERT INTO `nation` VALUES (12, '侗族');
INSERT INTO `nation` VALUES (13, '瑶族');
INSERT INTO `nation` VALUES (14, '白族');
INSERT INTO `nation` VALUES (15, '土家族');
INSERT INTO `nation` VALUES (16, '哈尼族');
INSERT INTO `nation` VALUES (17, '哈萨克族');
INSERT INTO `nation` VALUES (18, '傣族');
INSERT INTO `nation` VALUES (19, '黎族');
INSERT INTO `nation` VALUES (20, '傈僳族');
INSERT INTO `nation` VALUES (21, '佤族');
INSERT INTO `nation` VALUES (22, '畲族');
INSERT INTO `nation` VALUES (23, '高山族');
INSERT INTO `nation` VALUES (24, '拉祜族');
INSERT INTO `nation` VALUES (25, '水族');
INSERT INTO `nation` VALUES (26, '东乡族');
INSERT INTO `nation` VALUES (27, '纳西族');
INSERT INTO `nation` VALUES (28, '景颇族');
INSERT INTO `nation` VALUES (29, '柯尔克孜族');
INSERT INTO `nation` VALUES (30, '土族');
INSERT INTO `nation` VALUES (31, '达斡尔族');
INSERT INTO `nation` VALUES (32, '仫佬族');
INSERT INTO `nation` VALUES (33, '羌族');
INSERT INTO `nation` VALUES (34, '布朗族');
INSERT INTO `nation` VALUES (35, '撒拉族');
INSERT INTO `nation` VALUES (36, '毛难族');
INSERT INTO `nation` VALUES (37, '仡佬族');
INSERT INTO `nation` VALUES (38, '锡伯族');
INSERT INTO `nation` VALUES (39, '阿昌族');
INSERT INTO `nation` VALUES (40, '普米族');
INSERT INTO `nation` VALUES (41, '塔吉克族');
INSERT INTO `nation` VALUES (42, '怒族');
INSERT INTO `nation` VALUES (43, '乌孜别克族');
INSERT INTO `nation` VALUES (44, '俄罗斯族');
INSERT INTO `nation` VALUES (45, '鄂温克族');
INSERT INTO `nation` VALUES (46, '崩龙族');
INSERT INTO `nation` VALUES (47, '保安族');
INSERT INTO `nation` VALUES (48, '裕固族');
INSERT INTO `nation` VALUES (49, '京族');
INSERT INTO `nation` VALUES (50, '塔塔尔族');
INSERT INTO `nation` VALUES (51, '独龙族');
INSERT INTO `nation` VALUES (52, '鄂伦春族');
INSERT INTO `nation` VALUES (53, '赫哲族');
INSERT INTO `nation` VALUES (54, '门巴族');
INSERT INTO `nation` VALUES (55, '珞巴族');
INSERT INTO `nation` VALUES (56, '基诺族');
COMMIT;

-- ----------------------------
-- Table structure for oplog
-- ----------------------------
DROP TABLE IF EXISTS `oplog`;
CREATE TABLE `oplog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `logtype` tinyint(4) DEFAULT NULL COMMENT '日志类型，',
  `addDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加日期',
  `operate` varchar(255) DEFAULT NULL COMMENT '操作内容',
  `hrname` varchar(255) DEFAULT NULL COMMENT '操作员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2659 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of oplog
-- ----------------------------
BEGIN;
INSERT INTO `oplog` VALUES (2649, 1, '2023-03-19 16:38:35', '角色权限变更', '系统管理员');
INSERT INTO `oplog` VALUES (2650, 1, '2023-03-19 16:54:31', '角色权限变更', '系统管理员');
INSERT INTO `oplog` VALUES (2651, 1, '2023-03-19 17:30:50', '角色权限变更', '系统管理员');
INSERT INTO `oplog` VALUES (2652, 1, '2023-03-19 17:31:55', '角色权限变更', '系统管理员');
INSERT INTO `oplog` VALUES (2653, 1, '2023-03-19 17:36:49', '角色权限变更', '系统管理员');
INSERT INTO `oplog` VALUES (2654, 1, '2023-03-19 17:36:57', '角色权限变更', '系统管理员');
INSERT INTO `oplog` VALUES (2655, 8, '2023-03-27 21:28:49', '操作员角色更新', '小白');
INSERT INTO `oplog` VALUES (2656, 8, '2023-03-27 21:28:55', '操作员角色更新', '小白');
INSERT INTO `oplog` VALUES (2657, 8, '2023-03-27 21:29:27', '操作员角色更新', '小白');
INSERT INTO `oplog` VALUES (2658, 1, '2023-04-06 21:01:26', '角色权限变更', '系统管理员');
COMMIT;

-- ----------------------------
-- Table structure for politicsstatus
-- ----------------------------
DROP TABLE IF EXISTS `politicsstatus`;
CREATE TABLE `politicsstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of politicsstatus
-- ----------------------------
BEGIN;
INSERT INTO `politicsstatus` VALUES (1, '中共党员');
INSERT INTO `politicsstatus` VALUES (2, '中共预备党员');
INSERT INTO `politicsstatus` VALUES (3, '群众');
COMMIT;

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '职位',
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of position
-- ----------------------------
BEGIN;
INSERT INTO `position` VALUES (29, '技术总监', '2023-03-10 20:58:54', 1);
INSERT INTO `position` VALUES (30, '运营总监', '2020-01-05 17:51:25', 1);
INSERT INTO `position` VALUES (33, '研发工程师', '2019-12-26 10:41:10', 1);
INSERT INTO `position` VALUES (34, '运维工程师', '2020-01-14 23:02:49', 1);
INSERT INTO `position` VALUES (115, '前端工程师', '2020-01-21 19:48:54', 0);
INSERT INTO `position` VALUES (117, '销售工程师', '2020-01-05 17:52:12', 1);
INSERT INTO `position` VALUES (118, '技术顾问', '2020-01-05 17:52:18', 1);
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `nameZh` varchar(64) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE,
  UNIQUE KEY `nameZh` (`nameZh`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (2, 'ROLE_personnel', '人事专员');
INSERT INTO `role` VALUES (6, 'ROLE_admin', '系统管理员');
INSERT INTO `role` VALUES (34, 'ROLE_员工角色', '员工角色');
COMMIT;

-- ----------------------------
-- Table structure for rwards_punishments
-- ----------------------------
DROP TABLE IF EXISTS `rwards_punishments`;
CREATE TABLE `rwards_punishments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rpsystem_id` int(11) DEFAULT NULL,
  `rpmsg` varchar(255) DEFAULT NULL,
  `rpiont` int(11) DEFAULT NULL,
  `createrp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `rpmsg` (`rpmsg`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of rwards_punishments
-- ----------------------------
BEGIN;
INSERT INTO `rwards_punishments` VALUES (2, 1, '记小功', 3, '2019-12-28 10:32:50');
INSERT INTO `rwards_punishments` VALUES (3, 1, '记大功', 5, '2019-12-28 10:33:33');
INSERT INTO `rwards_punishments` VALUES (4, 1, '通报批评', -1, '2019-12-28 10:33:58');
INSERT INTO `rwards_punishments` VALUES (5, 1, '记小过', -5, '2019-12-28 10:34:19');
INSERT INTO `rwards_punishments` VALUES (9, 3, '罚款500元', -5, '2019-12-28 10:35:02');
INSERT INTO `rwards_punishments` VALUES (10, 3, '奖金50元', -2, '2019-12-28 10:35:03');
INSERT INTO `rwards_punishments` VALUES (19, 1, '嘉奖', 4, '2020-01-01 16:25:25');
INSERT INTO `rwards_punishments` VALUES (20, 5, '带薪调休', 1, '2020-01-01 16:53:07');
INSERT INTO `rwards_punishments` VALUES (21, 1, '晋职晋级', -2, '2020-01-06 10:40:26');
INSERT INTO `rwards_punishments` VALUES (22, 5, '年假+1', 3, '2020-01-11 19:05:55');
INSERT INTO `rwards_punishments` VALUES (23, 5, '团建+1', 2, '2020-01-11 19:07:07');
COMMIT;

-- ----------------------------
-- Table structure for rwardsandpunishments
-- ----------------------------
DROP TABLE IF EXISTS `rwardsandpunishments`;
CREATE TABLE `rwardsandpunishments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rpsystem` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of rwardsandpunishments
-- ----------------------------
BEGIN;
INSERT INTO `rwardsandpunishments` VALUES (1, '行政奖惩类');
INSERT INTO `rwardsandpunishments` VALUES (3, '经济奖惩类');
INSERT INTO `rwardsandpunishments` VALUES (5, '专项奖励类');
COMMIT;

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `basicSalary` int(11) DEFAULT NULL COMMENT '基本工资',
  `bonus` int(11) DEFAULT NULL COMMENT '奖金',
  `lunchSalary` int(11) DEFAULT NULL COMMENT '午餐补助',
  `trafficSalary` int(11) DEFAULT NULL COMMENT '交通补助',
  `allSalary` int(11) DEFAULT NULL COMMENT '应发工资',
  `pensionBase` int(11) DEFAULT NULL COMMENT '养老金基数',
  `pensionPer` float DEFAULT NULL COMMENT '养老金比率',
  `createDate` timestamp NULL DEFAULT NULL COMMENT '启用时间',
  `medicalBase` int(11) DEFAULT NULL COMMENT '医疗基数',
  `medicalPer` float DEFAULT NULL COMMENT '医疗保险比率',
  `accumulationFundBase` int(11) DEFAULT NULL COMMENT '公积金基数',
  `accumulationFundPer` float DEFAULT NULL COMMENT '公积金比率',
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of salary
-- ----------------------------
BEGIN;
INSERT INTO `salary` VALUES (10, 2000, 2000, 400, 1000, 7400, 2000, 0.07, '2020-01-11 19:54:24', 2000, 0.07, 2000, 0.07, '人事部工资账套');
INSERT INTO `salary` VALUES (13, 10000, 3000, 500, 500, 18000, 4000, 0.07, '2020-01-11 19:54:24', 4000, 0.07, 4000, 0.07, '运维部工资账套');
INSERT INTO `salary` VALUES (26, 10000, 50, 200, 100, 7850, 10000, 0.08, '2023-03-10 21:07:53', 10000, 0.05, 10000, 0.12, '测试讨帐');
COMMIT;

-- ----------------------------
-- Table structure for sysmsg
-- ----------------------------
DROP TABLE IF EXISTS `sysmsg`;
CREATE TABLE `sysmsg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL COMMENT '消息id',
  `type` int(11) DEFAULT '0' COMMENT '0表示群发消息',
  `hrid` int(11) DEFAULT NULL COMMENT '这条消息是给谁的',
  `state` int(11) DEFAULT '0' COMMENT '0 未读 1 已读',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `hrid` (`hrid`) USING BTREE,
  KEY `sysmsg_ibfk_1` (`mid`) USING BTREE,
  CONSTRAINT `sysmsg_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `msgcontent` (`id`),
  CONSTRAINT `sysmsg_ibfk_2` FOREIGN KEY (`hrid`) REFERENCES `hr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sysmsg
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Procedure structure for addDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `addDep`;
delimiter ;;
CREATE PROCEDURE `addDep`(in depName varchar(32),in parentId int,in enabled boolean,out result int,out result2 int)
begin
  declare did int;
  declare pDepPath varchar(64);
  insert into department set name=depName,parentId=parentId,enabled=enabled;
  select row_count() into result;
  select last_insert_id() into did;
  set result2=did;
  select depPath into pDepPath from department where id=parentId;
  update department set depPath=concat(pDepPath,'.',did) where id=did;
  update department set isParent=true where id=parentId;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deleteDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteDep`;
delimiter ;;
CREATE PROCEDURE `deleteDep`(in did int,out result int)
begin
  declare ecount int;
  declare pid int;
  declare pcount int;
  select count(*) into ecount from employee where departmentId=did;
  if ecount>0 then set result=-1;
  else 
  select parentId into pid from department where id=did;
  delete from department where id=did and isParent=false;
  select row_count() into result;
  select count(*) into pcount from department where parentId=pid;
  if pcount=0 then update department set isParent=false where id=pid;
  end if;
  end if;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
