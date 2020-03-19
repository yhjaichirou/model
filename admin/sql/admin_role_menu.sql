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

 Date: 27/02/2020 12:35:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_menu`;
CREATE TABLE `admin_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin_role_menu
-- ----------------------------
INSERT INTO `admin_role_menu` VALUES (1, 1, 1);
INSERT INTO `admin_role_menu` VALUES (2, 2, 1);
INSERT INTO `admin_role_menu` VALUES (3, 3, 1);
INSERT INTO `admin_role_menu` VALUES (4, 4, 1);
INSERT INTO `admin_role_menu` VALUES (7, 7, 1);
INSERT INTO `admin_role_menu` VALUES (8, 8, 1);
INSERT INTO `admin_role_menu` VALUES (9, 9, 1);
INSERT INTO `admin_role_menu` VALUES (31, 1, 2);
INSERT INTO `admin_role_menu` VALUES (32, 2, 2);
INSERT INTO `admin_role_menu` VALUES (33, 4, 2);
INSERT INTO `admin_role_menu` VALUES (34, 3, 2);
INSERT INTO `admin_role_menu` VALUES (35, 9, 2);

SET FOREIGN_KEY_CHECKS = 1;
