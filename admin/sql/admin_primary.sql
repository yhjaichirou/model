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

 Date: 27/02/2020 12:35:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_primary
-- ----------------------------
DROP TABLE IF EXISTS `admin_primary`;
CREATE TABLE `admin_primary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(5) NOT NULL,
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT 1,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin_primary
-- ----------------------------
INSERT INTO `admin_primary` VALUES (1, 1, '超级管理员权限，管理员管理', 1, '');
INSERT INTO `admin_primary` VALUES (2, 2, '监督管理，分配支部管理员权限', 1, '');
INSERT INTO `admin_primary` VALUES (3, 3, '系统指标管理', 1, '');
INSERT INTO `admin_primary` VALUES (4, 4, '基本内容管理', 1, '');
INSERT INTO `admin_primary` VALUES (12, 5, '创建党委、党总支、党支部', 1, '属于社区、村、乡镇的单位可以创建党支部，其他创建党委');
INSERT INTO `admin_primary` VALUES (13, 5, '只可创建下级党组织', 1, '管理员只可创建当前组织一下的党组织（例如：当前党总支，只可创建党支部）');
INSERT INTO `admin_primary` VALUES (14, 3, '指标录入考核', 1, '指标录入考核');

SET FOREIGN_KEY_CHECKS = 1;
