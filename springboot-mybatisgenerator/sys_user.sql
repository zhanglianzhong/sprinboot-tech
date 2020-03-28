/*
 Navicat Premium Data Transfer

 Source Server         : studyDb
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 192.168.245.101:3306
 Source Schema         : studyDB

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 28/03/2020 15:20:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `userName` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `userState` int(2) NOT NULL DEFAULT '1' COMMENT '用户状态,1-启用,-1禁用',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `userDesc` varchar(300) DEFAULT NULL COMMENT '描述',
  `userImg` varchar(300) DEFAULT '/app/img/user2-160x160.jpg' COMMENT '头像',
  `deptId` varchar(50) DEFAULT NULL COMMENT '部门主键',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_unique_index` (`userName`(5)) USING BTREE COMMENT '用户名唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', 'admin', '999999', 1, '2019-11-03 11:08:28', '超级管理员,具有最高权限', '/app/img/user2-160x160.jpg', '111');
INSERT INTO `sys_user` VALUES ('2', 'tenant', '000000', 1, '2019-11-03 11:51:36', '租客公用账户', '/app/img/user2-160x160.jpg', '222');
INSERT INTO `sys_user` VALUES ('3', 'zhanglianzhong', '222222', 1, '2019-11-03 11:43:36', '系统运维人员', '/app/img/user2-160x160.jpg', '333');
INSERT INTO `sys_user` VALUES ('4', 'guoyunping', '333333', 1, '2019-11-03 11:09:43', '二房东管理用户', '/app/img/user2-160x160.jpg', '444');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
