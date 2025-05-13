/*
 Navicat Premium Data Transfer

 Source Server         : Vin
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 18/09/2022 11:33:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `good_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `good_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` int(0) NOT NULL,
  `unit` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `v_price` int(0) NOT NULL,
  `vendorId` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_goods_vendor`(`vendorId`) USING BTREE,
  CONSTRAINT `fk_goods_vendor` FOREIGN KEY (`vendorId`) REFERENCES `vendor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 'c001', 'cz', 22, 'kg', 33, 3);
INSERT INTO `goods` VALUES (2, 'c001', '橙汁', 5, '瓶', 4, 3);
INSERT INTO `goods` VALUES (3, 'c001', '巧克力', 25, '盒', 45, 1);
INSERT INTO `goods` VALUES (5, '1', '1', 222, '1', 1, 2);
INSERT INTO `goods` VALUES (10, '1', '可乐', 4, '罐', 2, 1);

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `store_Num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `store_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `store_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 76 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES (1, 'c001', '全家便利店（成都绿地中央广场店）', '绿地中央广场');
INSERT INTO `store` VALUES (2, 'c002', '7-Eleven', '广州开发区科汇二街2号');
INSERT INTO `store` VALUES (3, 'c003', '京东便利店', '万科米酷C3');
INSERT INTO `store` VALUES (4, 'c004', '维克佳（新园新村店）', '新园新村南街3号');
INSERT INTO `store` VALUES (5, 'c005', '松鼠便利', '新塘南约大街1号');
INSERT INTO `store` VALUES (6, 'c006', '天福便利店', '天河区华旭街1号');
INSERT INTO `store` VALUES (7, 'c007', '喜市多（高普店）', '天河区高普路1029号');
INSERT INTO `store` VALUES (8, 'c008', '解忧杂货铺', '你找不到');
INSERT INTO `store` VALUES (78, 'c009', 'aaaaa', 'sssss');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_date` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'admin', '1234', '333', '222', '2022-09-15 09:43:01.000000');
INSERT INTO `user` VALUES (3, '李四', '1234', '12345678923', '广西', '2022-09-15 10:21:52.000000');
INSERT INTO `user` VALUES (7, 'admin', '1234', '123', '哈哈', '2022-09-15 14:11:01.000000');
INSERT INTO `user` VALUES (9, '123', '1234', '414', '发生', '2022-09-15 20:57:40.000000');
INSERT INTO `user` VALUES (11, 'zzz', '1234', '214', 'g', '2022-09-16 16:15:09.000000');
INSERT INTO `user` VALUES (14, 'admin', '1234', '1', '1', '2022-09-16 17:58:13.000000');

-- ----------------------------
-- Table structure for vendor
-- ----------------------------
DROP TABLE IF EXISTS `vendor`;
CREATE TABLE `vendor`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `vendor_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vendor_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vendor
-- ----------------------------
INSERT INTO `vendor` VALUES (1, 'c001', '达能食品加工有限公司');
INSERT INTO `vendor` VALUES (2, 'c002', '农夫山泉服份有限公司');
INSERT INTO `vendor` VALUES (3, 'c003', '百事可乐有限公司');
INSERT INTO `vendor` VALUES (4, 'v007', '辛可乐有限公司');

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_date` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vip
-- ----------------------------
INSERT INTO `vip` VALUES (1, 'adminvip', '8888', 'vip', '2022-09-17 17:41:17.000000');
INSERT INTO `vip` VALUES (14, '11', '122', '22', '2022-09-17 18:17:07.000000');

SET FOREIGN_KEY_CHECKS = 1;
