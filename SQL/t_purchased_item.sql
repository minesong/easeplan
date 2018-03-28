/*
 Navicat Premium Data Transfer

 Source Server         : ease
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : content

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 28/03/2018 13:07:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_purchased_item
-- ----------------------------
DROP TABLE IF EXISTS `t_purchased_item`;
CREATE TABLE `t_purchased_item`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'tupian',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'biaoti',
  `price` decimal(10, 2) DEFAULT NULL,
  `detail_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建时间',
  `create_time` datetime(0) DEFAULT NULL COMMENT '详情ID',
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '是否删除，0-未删除；1-已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '已经购买内容表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
