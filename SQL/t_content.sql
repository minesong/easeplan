
UPDATE 2017.3.20
ALTER TABLE t_purchased_item  ADD INDEX detail_id_index (detail_id)
ALTER TABLE t_user  ADD INDEX detail_id_index (detail_id)
------------------------------------------------------------------------------

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

 Date: 28/03/2018 13:09:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_content
-- ----------------------------
DROP TABLE IF EXISTS `t_content`;
CREATE TABLE `t_content`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片uri',
  `price` decimal(10, 2) DEFAULT NULL COMMENT '价格',
  `is_sale` tinyint(4) DEFAULT NULL COMMENT '是否售出',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) DEFAULT NULL COMMENT '最后修改时间',
  `is_delete` tinyint(4) DEFAULT 0 COMMENT '是否删除，0-未删除；1-已删除',
  `detail_id` bigint(11) UNSIGNED DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '内容表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_content
-- ----------------------------
INSERT INTO `t_content` VALUES (1, '标题党', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=957038992,2649125789&fm=27&gp=0.jpg', 8.88, 0, '2018-03-21 22:44:53', '2018-03-27 11:09:26', 0, 1);
INSERT INTO `t_content` VALUES (2, 'biaoti', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=957038992,2649125789&fm=27&gp=0.jpg', 9.66, 0, '2018-03-21 22:44:53', '2018-03-27 21:27:57', 0, 2);
INSERT INTO `t_content` VALUES (3, '标题', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2679332005,3936952309&fm=27&gp=0.jpg', 11.20, 1, '2018-03-21 22:44:53', '2018-03-20 22:44:56', 1, 3);
INSERT INTO `t_content` VALUES (4, '标题党', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3907563172,2215117419&fm=27&gp=0.jpg', 6.66, 0, '2018-03-21 22:44:53', '2018-03-25 14:42:59', 0, 4);
INSERT INTO `t_content` VALUES (5, '标题党', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4265780169,4282155964&fm=27&gp=0.jpg', 6.55, 0, '2018-03-21 22:44:53', '2018-03-23 18:36:43', 0, 5);
INSERT INTO `t_content` VALUES (6, '标题党', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3689657463,2299562820&fm=27&gp=0.jpg', 16.66, 1, '2018-03-21 22:44:53', '2018-03-23 00:00:00', 0, 6);
INSERT INTO `t_content` VALUES (7, '标题', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4265780169,4282155964&fm=27&gp=0.jpg', 111111.11, 1, '2018-03-21 22:44:53', '2018-03-20 22:44:56', 0, 7);
INSERT INTO `t_content` VALUES (8, '标题', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2717469583,1185134067&fm=27&gp=0.jpg', 111266.66, 1, '2018-03-21 22:44:53', '2018-03-20 22:44:56', 1, 8);
INSERT INTO `t_content` VALUES (9, '新增', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1093950722,1689053277&fm=200&gp=0.jpg', 8.88, 1, '2018-03-23 13:17:22', '2018-03-23 13:17:22', 0, 9);
INSERT INTO `t_content` VALUES (26, '123', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3936700828,4158776287&fm=27&gp=0.jpg', 9.63, 1, '2018-03-23 13:38:08', '2018-03-23 13:38:09', 0, 26);
INSERT INTO `t_content` VALUES (31, '111', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=39506615,341085327&fm=27&gp=0.jpg', 8.30, 1, '2018-03-23 13:39:53', '2018-03-23 13:39:53', 0, 31);
INSERT INTO `t_content` VALUES (32, '110', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1391858302,589047052&fm=27&gp=0.jpg', 11.66, 1, '2018-03-23 13:41:16', '2018-03-26 22:23:07', 0, 34);
INSERT INTO `t_content` VALUES (34, '22', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2265579857,3308330732&fm=27&gp=0.jpg', 99999.00, 1, '2018-03-23 13:48:47', '2018-03-26 22:26:28', 0, 36);

SET FOREIGN_KEY_CHECKS = 1;
