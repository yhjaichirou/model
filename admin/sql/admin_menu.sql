/*
 Navicat Premium Data Transfer

 Source Server         : 百度
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 119.3.172.243:3306
 Source Schema         : miniupload

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 27/02/2020 12:34:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sort` int(10) NOT NULL DEFAULT 1,
  `pid` int(11) NULL DEFAULT 0 COMMENT '二级菜单 一级：0',
  `status` int(1) NULL DEFAULT 1,
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin_menu
-- ----------------------------
INSERT INTO `admin_menu` VALUES (1, '首页', 1, 0, 1, '', NULL);
INSERT INTO `admin_menu` VALUES (2, '数据管理', 1, 0, 1, 'export/index', NULL);
INSERT INTO `admin_menu` VALUES (3, '系统管理', 1, 0, 1, 'index/index', NULL);
INSERT INTO `admin_menu` VALUES (4, '文件下载', 1, 2, 1, 'export/download', NULL);
INSERT INTO `admin_menu` VALUES (7, '模块管理', 1, 3, 0, 'index/menu', NULL);
INSERT INTO `admin_menu` VALUES (8, '角色管理', 1, 3, 1, 'index/role', NULL);
INSERT INTO `admin_menu` VALUES (9, '用户管理', 1, 3, 1, 'index/user', NULL);

SET FOREIGN_KEY_CHECKS = 1;
