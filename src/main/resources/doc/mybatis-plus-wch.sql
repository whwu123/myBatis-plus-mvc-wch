/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mybatis-plus

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-06-13 13:42:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `file_name` varchar(255) DEFAULT NULL COMMENT '文件名字',
  `file_type` varchar(255) DEFAULT NULL COMMENT '文件类型',
  `file_path` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `file_size` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `file_status` int(2) DEFAULT NULL COMMENT '状态',
  `file_fid` varchar(50) DEFAULT NULL COMMENT '外键ID',
  `file_createdate` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  `file_format` varchar(50) DEFAULT NULL COMMENT '文件格式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_file
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL COMMENT '用户ID',
  `name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `age` int(3) DEFAULT NULL COMMENT '用户年龄',
  `type` int(1) DEFAULT '0' COMMENT '0、禁用 1、正常, 如果使用tinyint(1)，mysql连接没加tinyInt1isBit=false，默认mysql驱动会把值转成boolean',
  `ctime` datetime DEFAULT NULL COMMENT '自定义填充的创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('784972358981328902', 'Tom', '24', '1', '2017-06-25 20:53:33');
INSERT INTO `sys_user` VALUES ('784972358981328903', 'Jammy', '21', '1', '2017-06-25 20:53:37');
INSERT INTO `sys_user` VALUES ('1138730945680297986', '21', '21', '0', '2019-06-12 16:53:09');
