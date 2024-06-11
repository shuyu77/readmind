/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80100
Source Host           : localhost:3306
Source Database       : social

Target Server Type    : MYSQL
Target Server Version : 80100
File Encoding         : 65001

Date: 2024-06-11 22:09:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collegemajors
-- ----------------------------
DROP TABLE IF EXISTS `collegemajors`;
CREATE TABLE `collegemajors` (
  `college_id` int NOT NULL,
  `major_id` int NOT NULL,
  PRIMARY KEY (`college_id`,`major_id`) USING BTREE,
  KEY `major_id` (`major_id`) USING BTREE,
  CONSTRAINT `collegemajors_ibfk_1` FOREIGN KEY (`college_id`) REFERENCES `colleges` (`college_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `collegemajors_ibfk_2` FOREIGN KEY (`major_id`) REFERENCES `majors` (`major_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of collegemajors
-- ----------------------------
INSERT INTO `collegemajors` VALUES ('1', '1');
INSERT INTO `collegemajors` VALUES ('2', '2');
INSERT INTO `collegemajors` VALUES ('2', '3');
INSERT INTO `collegemajors` VALUES ('2', '4');
INSERT INTO `collegemajors` VALUES ('2', '5');
INSERT INTO `collegemajors` VALUES ('2', '6');
INSERT INTO `collegemajors` VALUES ('2', '7');
INSERT INTO `collegemajors` VALUES ('3', '8');
INSERT INTO `collegemajors` VALUES ('3', '9');
INSERT INTO `collegemajors` VALUES ('3', '10');
INSERT INTO `collegemajors` VALUES ('4', '11');
INSERT INTO `collegemajors` VALUES ('4', '12');
INSERT INTO `collegemajors` VALUES ('4', '13');
INSERT INTO `collegemajors` VALUES ('4', '14');
INSERT INTO `collegemajors` VALUES ('5', '15');
INSERT INTO `collegemajors` VALUES ('5', '16');
INSERT INTO `collegemajors` VALUES ('5', '17');
INSERT INTO `collegemajors` VALUES ('6', '18');
INSERT INTO `collegemajors` VALUES ('6', '19');
INSERT INTO `collegemajors` VALUES ('6', '20');
INSERT INTO `collegemajors` VALUES ('7', '21');
INSERT INTO `collegemajors` VALUES ('7', '22');
INSERT INTO `collegemajors` VALUES ('7', '23');
INSERT INTO `collegemajors` VALUES ('8', '24');
INSERT INTO `collegemajors` VALUES ('8', '25');
INSERT INTO `collegemajors` VALUES ('8', '26');
INSERT INTO `collegemajors` VALUES ('8', '27');
INSERT INTO `collegemajors` VALUES ('8', '28');
INSERT INTO `collegemajors` VALUES ('9', '29');
INSERT INTO `collegemajors` VALUES ('9', '30');
INSERT INTO `collegemajors` VALUES ('9', '31');
INSERT INTO `collegemajors` VALUES ('9', '32');
INSERT INTO `collegemajors` VALUES ('10', '33');
INSERT INTO `collegemajors` VALUES ('10', '34');
INSERT INTO `collegemajors` VALUES ('11', '35');
INSERT INTO `collegemajors` VALUES ('11', '36');
INSERT INTO `collegemajors` VALUES ('11', '37');
INSERT INTO `collegemajors` VALUES ('11', '38');
INSERT INTO `collegemajors` VALUES ('11', '39');
INSERT INTO `collegemajors` VALUES ('12', '40');
INSERT INTO `collegemajors` VALUES ('12', '41');
INSERT INTO `collegemajors` VALUES ('12', '42');
INSERT INTO `collegemajors` VALUES ('12', '43');
INSERT INTO `collegemajors` VALUES ('13', '44');
INSERT INTO `collegemajors` VALUES ('13', '45');
INSERT INTO `collegemajors` VALUES ('13', '46');
INSERT INTO `collegemajors` VALUES ('13', '47');
INSERT INTO `collegemajors` VALUES ('13', '48');
INSERT INTO `collegemajors` VALUES ('14', '49');
INSERT INTO `collegemajors` VALUES ('14', '50');
INSERT INTO `collegemajors` VALUES ('14', '51');
INSERT INTO `collegemajors` VALUES ('14', '52');
INSERT INTO `collegemajors` VALUES ('15', '53');
INSERT INTO `collegemajors` VALUES ('15', '54');
INSERT INTO `collegemajors` VALUES ('15', '55');
INSERT INTO `collegemajors` VALUES ('15', '56');
INSERT INTO `collegemajors` VALUES ('16', '57');
INSERT INTO `collegemajors` VALUES ('16', '58');
INSERT INTO `collegemajors` VALUES ('16', '59');
INSERT INTO `collegemajors` VALUES ('17', '60');
INSERT INTO `collegemajors` VALUES ('17', '61');
INSERT INTO `collegemajors` VALUES ('14', '62');
INSERT INTO `collegemajors` VALUES ('17', '63');
INSERT INTO `collegemajors` VALUES ('17', '64');
INSERT INTO `collegemajors` VALUES ('17', '65');

-- ----------------------------
-- Table structure for colleges
-- ----------------------------
DROP TABLE IF EXISTS `colleges`;
CREATE TABLE `colleges` (
  `college_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci NOT NULL,
  PRIMARY KEY (`college_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of colleges
-- ----------------------------
INSERT INTO `colleges` VALUES ('1', '马克思主义学院');
INSERT INTO `colleges` VALUES ('2', '经济与管理学院');
INSERT INTO `colleges` VALUES ('3', '政法学院');
INSERT INTO `colleges` VALUES ('4', '教育科学学院');
INSERT INTO `colleges` VALUES ('5', '体育与健康学院');
INSERT INTO `colleges` VALUES ('6', '文学与传媒学院');
INSERT INTO `colleges` VALUES ('7', '外国语言文化学院');
INSERT INTO `colleges` VALUES ('8', '数学与统计学院');
INSERT INTO `colleges` VALUES ('9', '生命科学学院');
INSERT INTO `colleges` VALUES ('10', '机械与汽车工程学院');
INSERT INTO `colleges` VALUES ('11', '电子与电气工程学院');
INSERT INTO `colleges` VALUES ('12', '计算机科学与软件学院');
INSERT INTO `colleges` VALUES ('13', '环境与化学学院');
INSERT INTO `colleges` VALUES ('14', '食品与制药学院');
INSERT INTO `colleges` VALUES ('15', '旅游与历史文化学院');
INSERT INTO `colleges` VALUES ('16', '音乐学院');
INSERT INTO `colleges` VALUES ('17', '美术学院、设计学院');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `post_id` int NOT NULL,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `post_id` (`post_id`) USING BTREE,
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('1', '1', '1', 'This is a comment on the first postThis is a comment on the first posThis is a comment on the first posThis is a comment on the first posThis is a comment on the first pos', '2024-03-31 18:36:14');
INSERT INTO `comments` VALUES ('2', '2', '1', '提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”', '2024-03-31 18:36:20');
INSERT INTO `comments` VALUES ('3', '3', '3', '提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”提供者。陌生人既远又近、既近又远的关系 正在转变成一种既亲密又陌生、既不确定义认同 的混合关系。美国社会学教授Molz把这种新型 的人际关系称为“讨悦的陌生人”', '2024-03-31 18:36:14');
INSERT INTO `comments` VALUES ('4', '4', '4', 'I like this post.', '2024-03-31 18:36:14');
INSERT INTO `comments` VALUES ('5', '5', '5', 'Another comment here.', '2024-03-31 18:36:14');
INSERT INTO `comments` VALUES ('6', '6', '6', 'Keep up the good work!', '2024-03-31 18:36:14');
INSERT INTO `comments` VALUES ('7', '7', '7', 'Interesting point.', '2024-03-31 18:36:14');
INSERT INTO `comments` VALUES ('8', '8', '8', 'I have a question about this.', '2024-03-31 18:36:14');
INSERT INTO `comments` VALUES ('9', '9', '9', 'Nice post!', '2024-03-31 18:36:14');
INSERT INTO `comments` VALUES ('10', '10', '10', 'Looking forward to more posts.', '2024-03-31 18:36:14');
INSERT INTO `comments` VALUES ('11', '2', '1', '123', '2024-04-14 18:13:37');
INSERT INTO `comments` VALUES ('21', '11', '3', '123', '2024-04-14 22:05:06');
INSERT INTO `comments` VALUES ('22', '11', '3', '123', '2024-04-14 22:05:08');
INSERT INTO `comments` VALUES ('23', '11', '28', '123', '2024-04-14 22:05:10');
INSERT INTO `comments` VALUES ('24', '11', '29', '123', '2024-04-14 22:22:04');
INSERT INTO `comments` VALUES ('26', '1', '28', '5555', '2024-04-14 23:10:56');
INSERT INTO `comments` VALUES ('29', '11', '6', '123', '2024-04-14 23:12:57');
INSERT INTO `comments` VALUES ('33', '11', '1', '123', '2024-04-17 22:40:24');
INSERT INTO `comments` VALUES ('34', '11', '3', '11', '2024-04-23 23:12:05');
INSERT INTO `comments` VALUES ('35', '11', '3', '123', '2024-04-23 23:25:56');

-- ----------------------------
-- Table structure for follows
-- ----------------------------
DROP TABLE IF EXISTS `follows`;
CREATE TABLE `follows` (
  `follow_id` int NOT NULL AUTO_INCREMENT,
  `follower_id` int NOT NULL,
  `followee_id` int NOT NULL,
  `follow_status` enum('ACTIVE','INACTIVE') CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci DEFAULT 'ACTIVE',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`follow_id`) USING BTREE,
  KEY `follower_id` (`follower_id`) USING BTREE,
  KEY `followee_id` (`followee_id`) USING BTREE,
  CONSTRAINT `follows_ibfk_1` FOREIGN KEY (`follower_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `follows_ibfk_2` FOREIGN KEY (`followee_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of follows
-- ----------------------------
INSERT INTO `follows` VALUES ('1', '1', '2', 'ACTIVE', '2024-03-31 18:36:14');
INSERT INTO `follows` VALUES ('2', '2', '3', 'ACTIVE', '2024-03-31 18:36:14');
INSERT INTO `follows` VALUES ('3', '3', '1', 'ACTIVE', '2024-03-31 18:36:14');
INSERT INTO `follows` VALUES ('4', '4', '5', 'INACTIVE', '2024-03-31 18:36:14');
INSERT INTO `follows` VALUES ('5', '5', '4', 'ACTIVE', '2024-03-31 18:36:14');
INSERT INTO `follows` VALUES ('6', '6', '7', 'ACTIVE', '2024-03-31 18:36:14');
INSERT INTO `follows` VALUES ('7', '7', '6', 'ACTIVE', '2024-03-31 18:36:14');
INSERT INTO `follows` VALUES ('8', '8', '9', 'ACTIVE', '2024-03-31 18:36:14');
INSERT INTO `follows` VALUES ('9', '9', '11', 'INACTIVE', '2024-03-31 18:36:14');
INSERT INTO `follows` VALUES ('10', '10', '11', 'ACTIVE', '2024-03-31 18:36:14');
INSERT INTO `follows` VALUES ('46', '1', '11', null, '2024-04-20 01:17:36');

-- ----------------------------
-- Table structure for likes
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes` (
  `like_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `post_id` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`like_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `post_id` (`post_id`) USING BTREE,
  CONSTRAINT `likes_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `likes_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of likes
-- ----------------------------
INSERT INTO `likes` VALUES ('1', '1', '28', '2024-03-31 18:36:14');
INSERT INTO `likes` VALUES ('2', '2', '29', '2024-03-31 18:36:14');
INSERT INTO `likes` VALUES ('3', '3', '2', '2024-03-31 18:36:14');
INSERT INTO `likes` VALUES ('4', '1', '3', '2024-03-31 18:36:14');
INSERT INTO `likes` VALUES ('5', '4', '4', '2024-03-31 18:36:14');
INSERT INTO `likes` VALUES ('6', '5', '4', '2024-03-31 18:36:14');
INSERT INTO `likes` VALUES ('7', '5', '5', '2024-03-31 18:36:14');
INSERT INTO `likes` VALUES ('8', '6', '5', '2024-03-31 18:36:14');
INSERT INTO `likes` VALUES ('9', '7', '6', '2024-03-31 18:36:14');
INSERT INTO `likes` VALUES ('10', '8', '7', '2024-03-31 18:36:14');
INSERT INTO `likes` VALUES ('13', '11', '28', '2024-04-15 22:14:24');
INSERT INTO `likes` VALUES ('16', '11', '3', '2024-04-23 23:12:07');
INSERT INTO `likes` VALUES ('19', '11', '2', '2024-04-27 22:16:59');

-- ----------------------------
-- Table structure for majors
-- ----------------------------
DROP TABLE IF EXISTS `majors`;
CREATE TABLE `majors` (
  `major_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci NOT NULL,
  PRIMARY KEY (`major_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of majors
-- ----------------------------
INSERT INTO `majors` VALUES ('1', '思想政治教育专业');
INSERT INTO `majors` VALUES ('2', '会计学');
INSERT INTO `majors` VALUES ('3', '电子商务');
INSERT INTO `majors` VALUES ('4', '市场营销');
INSERT INTO `majors` VALUES ('5', '人力资源管理');
INSERT INTO `majors` VALUES ('6', '国际经济与贸易');
INSERT INTO `majors` VALUES ('7', '投资学');
INSERT INTO `majors` VALUES ('8', '法学');
INSERT INTO `majors` VALUES ('9', '行政管理');
INSERT INTO `majors` VALUES ('10', '知识产权');
INSERT INTO `majors` VALUES ('11', '学前教育');
INSERT INTO `majors` VALUES ('12', '小学教育');
INSERT INTO `majors` VALUES ('13', '应用心理');
INSERT INTO `majors` VALUES ('14', '教育技术');
INSERT INTO `majors` VALUES ('15', '体育教育');
INSERT INTO `majors` VALUES ('16', '社会体育指导与管理');
INSERT INTO `majors` VALUES ('17', '休闲体育');
INSERT INTO `majors` VALUES ('18', '汉语言文学');
INSERT INTO `majors` VALUES ('19', '广播电视学');
INSERT INTO `majors` VALUES ('20', '网络与新媒体');
INSERT INTO `majors` VALUES ('21', '英语');
INSERT INTO `majors` VALUES ('22', '商务英语');
INSERT INTO `majors` VALUES ('23', '日语');
INSERT INTO `majors` VALUES ('24', '数学与应用数学');
INSERT INTO `majors` VALUES ('25', '信息与计算科学');
INSERT INTO `majors` VALUES ('26', '统计学');
INSERT INTO `majors` VALUES ('27', '金融数学');
INSERT INTO `majors` VALUES ('28', '应用统计学');
INSERT INTO `majors` VALUES ('29', '生物科学');
INSERT INTO `majors` VALUES ('30', '生物技术');
INSERT INTO `majors` VALUES ('31', '园林');
INSERT INTO `majors` VALUES ('32', '风景园林');
INSERT INTO `majors` VALUES ('33', '机械设计制造及其自动化');
INSERT INTO `majors` VALUES ('34', '车辆工程');
INSERT INTO `majors` VALUES ('35', '电子信息科学与技术');
INSERT INTO `majors` VALUES ('36', '通信工程');
INSERT INTO `majors` VALUES ('37', '电子科学与技术');
INSERT INTO `majors` VALUES ('38', '电气工程及其自动化');
INSERT INTO `majors` VALUES ('39', '物理学');
INSERT INTO `majors` VALUES ('40', '计算机科学与技术');
INSERT INTO `majors` VALUES ('41', '物联网工程');
INSERT INTO `majors` VALUES ('42', '软件工程');
INSERT INTO `majors` VALUES ('43', '数据科学与大数据技术');
INSERT INTO `majors` VALUES ('44', '化学');
INSERT INTO `majors` VALUES ('45', '精细化工');
INSERT INTO `majors` VALUES ('46', '环境工程');
INSERT INTO `majors` VALUES ('47', '环境资源科学');
INSERT INTO `majors` VALUES ('48', '化妆品技术与工程');
INSERT INTO `majors` VALUES ('49', '制药工程');
INSERT INTO `majors` VALUES ('50', '食品科学与工程');
INSERT INTO `majors` VALUES ('51', '食品质量与安全');
INSERT INTO `majors` VALUES ('52', '食品营养与健康');
INSERT INTO `majors` VALUES ('53', '旅游管理');
INSERT INTO `majors` VALUES ('54', '酒店管理');
INSERT INTO `majors` VALUES ('55', '历史学');
INSERT INTO `majors` VALUES ('56', '地理科学');
INSERT INTO `majors` VALUES ('57', '音乐学');
INSERT INTO `majors` VALUES ('58', '音乐表演');
INSERT INTO `majors` VALUES ('59', '舞蹈学');
INSERT INTO `majors` VALUES ('60', '美术学');
INSERT INTO `majors` VALUES ('61', '视觉传达设计');
INSERT INTO `majors` VALUES ('62', '环境设计');
INSERT INTO `majors` VALUES ('63', '动画');
INSERT INTO `majors` VALUES ('64', '工艺美术');
INSERT INTO `majors` VALUES ('65', '产品设计');

-- ----------------------------
-- Table structure for managers
-- ----------------------------
DROP TABLE IF EXISTS `managers`;
CREATE TABLE `managers` (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci NOT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci DEFAULT NULL,
  `role` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE KEY `account` (`account`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of managers
-- ----------------------------
INSERT INTO `managers` VALUES ('1', 'admin1', 'f770f939f1c036e3dc1297a67595326d', '79e262a81dd19d40ae008f74eb59edce', '1112223333', 'Administrator', '2024-03-31 18:36:14', '2024-04-28 00:19:18');
INSERT INTO `managers` VALUES ('2', 'admin2', 'Admin Two', '1877fcc1b7ec74e144d319929edb40a9', '2223334444', 'Superuser', '2024-03-31 18:36:14', '2024-04-22 16:23:07');
INSERT INTO `managers` VALUES ('3', 'admin3', 'Admin Three', 'adminpass1', '1112223333', 'Administrator', '2024-03-31 18:36:14', '2024-03-31 18:36:14');
INSERT INTO `managers` VALUES ('4', 'admin4', 'Admin Four', 'adminpass2', '2223334444', 'Superuser', '2024-03-31 18:36:14', '2024-03-31 18:36:14');
INSERT INTO `managers` VALUES ('5', 'admin5', 'Admin Five', 'adminpass1', '1112223333', 'Administrator', '2024-03-31 18:36:14', '2024-03-31 18:36:14');
INSERT INTO `managers` VALUES ('6', 'admin6', 'Admin Six', 'adminpass2', '2223334444', 'Superuser', '2024-03-31 18:36:14', '2024-03-31 18:36:14');
INSERT INTO `managers` VALUES ('7', 'admin7', 'Admin Seven', 'adminpass1', '1112223333', 'Administrator', '2024-03-31 18:36:14', '2024-03-31 18:36:14');
INSERT INTO `managers` VALUES ('8', 'admin8', 'Admin Eight', 'adminpass2', '2223334444', 'Superuser', '2024-03-31 18:36:14', '2024-03-31 18:36:14');
INSERT INTO `managers` VALUES ('9', 'admin9', 'Admin Nine', 'adminpass1', '1112223333', 'Administrator', '2024-03-31 18:36:14', '2024-03-31 18:36:14');
INSERT INTO `managers` VALUES ('10', 'admin10', 'Admin Ten', 'adminpass10', '9998887777', 'Manager', '2024-03-31 18:36:14', '2024-03-31 18:36:14');

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages` (
  `message_id` int NOT NULL AUTO_INCREMENT,
  `sender_id` int NOT NULL,
  `receiver_id` int NOT NULL,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci NOT NULL,
  `sent_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `read_status` tinyint(1) DEFAULT '0',
  `deleted_status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`message_id`) USING BTREE,
  KEY `sender_id` (`sender_id`) USING BTREE,
  KEY `receiver_id` (`receiver_id`) USING BTREE,
  CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`sender_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `messages_ibfk_2` FOREIGN KEY (`receiver_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of messages
-- ----------------------------
INSERT INTO `messages` VALUES ('3', '3', '4', 'Can we meet for lunch today?', '2024-03-31 18:36:14', '0', '0');
INSERT INTO `messages` VALUES ('4', '4', '3', 'Sure, where do you want to go?', '2024-03-31 18:36:14', '0', '0');
INSERT INTO `messages` VALUES ('5', '5', '6', 'Hi, I need your help with something.', '2024-03-31 18:36:14', '0', '0');
INSERT INTO `messages` VALUES ('6', '6', '5', 'What is it?', '2024-03-31 18:36:14', '0', '0');
INSERT INTO `messages` VALUES ('7', '1', '3', 'Did you finish that project?', '2024-03-31 18:36:14', '0', '0');
INSERT INTO `messages` VALUES ('8', '3', '1', 'Yes, I just finished it.', '2024-03-31 18:36:14', '0', '0');
INSERT INTO `messages` VALUES ('9', '2', '4', 'Let us grab a coffee this weekend.', '2024-03-31 18:36:14', '0', '0');
INSERT INTO `messages` VALUES ('10', '4', '2', 'Sounds great!', '2024-03-31 18:36:14', '0', '0');
INSERT INTO `messages` VALUES ('13', '11', '1', '今天有空吗？', '2024-04-22 22:37:10', '0', '0');
INSERT INTO `messages` VALUES ('14', '1', '11', '晚上有空', '2024-04-22 22:37:17', '0', '0');
INSERT INTO `messages` VALUES ('15', '11', '1', '那要不要一起去跑步', '2024-04-22 22:37:22', '0', '0');
INSERT INTO `messages` VALUES ('16', '1', '11', '可以哇，大概几点那样', '2024-04-22 22:37:29', '0', '0');
INSERT INTO `messages` VALUES ('17', '11', '1', '大概8点那样', '2024-04-22 22:37:35', '0', '0');
INSERT INTO `messages` VALUES ('18', '11', '1', '我过去找你', '2024-04-22 22:37:50', '0', '0');
INSERT INTO `messages` VALUES ('19', '1', '11', '好的嘞', '2024-04-22 22:37:54', '0', '0');
INSERT INTO `messages` VALUES ('22', '2', '11', '出发', '2024-04-22 23:52:36', '0', '0');
INSERT INTO `messages` VALUES ('25', '11', '2', '来了', '2024-04-26 15:04:05', '0', '0');
INSERT INTO `messages` VALUES ('26', '11', '1', '1', '2024-04-26 17:03:41', '0', '0');

-- ----------------------------
-- Table structure for pictures
-- ----------------------------
DROP TABLE IF EXISTS `pictures`;
CREATE TABLE `pictures` (
  `pictures_id` int NOT NULL AUTO_INCREMENT,
  `posts_id` int NOT NULL,
  `image` varchar(255) NOT NULL,
  PRIMARY KEY (`pictures_id`),
  KEY `pictures_posts` (`posts_id`),
  CONSTRAINT `pictures_posts` FOREIGN KEY (`posts_id`) REFERENCES `posts` (`post_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of pictures
-- ----------------------------
INSERT INTO `pictures` VALUES ('1', '1', 'https://pic1.zhimg.com/v2-86a6e519c7a8e4c4586e8fb8f7d8f07c_r.jpg');
INSERT INTO `pictures` VALUES ('2', '1', 'https://pic2.zhimg.com/80/v2-f55bbab3f89dc4573bf61f42a9a39081_1440w.webp');
INSERT INTO `pictures` VALUES ('3', '7', 'http://m.qpic.cn/psc?/V52A3KaK2bOdwM1FIz7o14kBqy1LBiZe/ruAMsa53pVQWN7FLK88i5s.wB5u0n3Jjk*XAm7XnbZYCQqcO5VMiEPAFod6q6v9RNg*nwyxILCjh4roXaY3h5QtSufxPa3s1kc6pBGwYau4!/b&bo=OAS9AwAAAAABB6I!&rf=viewer_4');
INSERT INTO `pictures` VALUES ('4', '2', 'http://m.qpic.cn/psc?/V52A3KaK2bOdwM1FIz7o14kBqy1LBiZe/ruAMsa53pVQWN7FLK88i5vOgnGIp.F8wqvI4UMsAm6XlNT5YUde*vVYlKbAkdx2dMn1jYPA6Qcu4hAwSzpMG7KM.12TCDuuAekNQOD9p3Ic!/b&bo=OASPBAAAAAABB5c!&rf=viewer_4');
INSERT INTO `pictures` VALUES ('5', '29', 'http://m.qpic.cn/psc?/V52A3KaK2bOdwM1FIz7o14kBqy1LBiZe/ruAMsa53pVQWN7FLK88i5vOgnGIp.F8wqvI4UMsAm6Xo77FXsgBM0sZqR0OyDKAmohe8O8irsl15Ltcrep3yJ*bMJgfqaxNNSpQaaWM6O9o!/b&bo=OAQKBQAAAAABBxM!&rf=viewer_4');
INSERT INTO `pictures` VALUES ('29', '38', 'wxfile://tmp_06d2743f7cae17213a854a9149e2ef90e5f99ed69fe1403e.jpg');

-- ----------------------------
-- Table structure for posts
-- ----------------------------
DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts` (
  `post_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci NOT NULL,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci NOT NULL,
  `images` text CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci,
  `likes_count` int DEFAULT '0',
  `comments_count` int DEFAULT '0',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`post_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of posts
-- ----------------------------
INSERT INTO `posts` VALUES ('1', '1', 'Post Title 1', '找个吃饭搭子', 'http://sauzyzttl.hn-bkt.clouddn.com/ce4d4b7133e1d26b1be4fe24a1ccca0.png?e=1711359544&token=c3NOVwieocC3a7LvVYZ4BVdbdoYz6RwSD7X-Q-H5:dlvT9q9_iGVHlPQW9SLzmDE4f-A=', '0', '0', '2024-04-14 18:36:14', '2024-04-23 00:21:19');
INSERT INTO `posts` VALUES ('2', '1', 'Post Title 2', '有没有美女帅哥想一起拍照嘛，最近创作瓶颈想找人创作互勉', 'http://m.qpic.cn/psc?/V52A3KaK2bOdwM1FIz7o14kBqy1LBiZe/ruAMsa53pVQWN7FLK88i5vOgnGIp.F8wqvI4UMsAm6XlNT5YUde*vVYlKbAkdx2dMn1jYPA6Qcu4hAwSzpMG7KM.12TCDuuAekNQOD9p3Ic!/b&bo=OASPBAAAAAABB5c!&rf=viewer_4', '2', '2', '2024-02-28 18:36:14', '2024-04-27 22:16:59');
INSERT INTO `posts` VALUES ('3', '3', 'Post Title 3', '请问有生物考研的打字吗？可以一起交流一下', 'http://sauzyzttl.hn-bkt.clouddn.com/ce4d4b7133e1d26b1be4fe24a1ccca0.png?e=1711359544&token=c3NOVwieocC3a7LvVYZ4BVdbdoYz6RwSD7X-Q-H5:dlvT9q9_iGVHlPQW9SLzmDE4f-A=', '0', '5', '2024-04-12 18:36:14', '2024-04-27 22:06:56');
INSERT INTO `posts` VALUES ('4', '4', 'Post Title 4', '这周六一起搭车去高铁站', 'https://img.zcool.cn/community/0122a15d22b574a801213763e36eba.jpg@2o.jpg', '2', '1', '2024-03-21 18:36:14', '2024-04-23 00:21:30');
INSERT INTO `posts` VALUES ('5', '5', 'Post Title 5', '分享一下这个四六级线上学习活动群，主要针对四六级听力和阅读，有很多方法分享，想了解的伙伴们可以进一下群', 'http://sauzyzttl.hn-bkt.clouddn.com/ce4d4b7133e1d26b1be4fe24a1ccca0.png?e=1711359544&token=c3NOVwieocC3a7LvVYZ4BVdbdoYz6RwSD7X-Q-H5:dlvT9q9_iGVHlPQW9SLzmDE4f-A=', '0', '0', '2024-03-31 18:36:14', '2024-04-23 00:21:30');
INSERT INTO `posts` VALUES ('6', '6', 'Post Title 6', '找一个一起乐跑的搭子，一般晚上跑', 'http://sauzyzttl.hn-bkt.clouddn.com/ce4d4b7133e1d26b1be4fe24a1ccca0.png?e=1711359544&token=c3NOVwieocC3a7LvVYZ4BVdbdoYz6RwSD7X-Q-H5:dlvT9q9_iGVHlPQW9SLzmDE4f-A=', '2', '1', '2024-04-03 18:36:14', '2024-04-23 00:21:30');
INSERT INTO `posts` VALUES ('7', '7', 'Post Title 7', '学校的游泳池什么时候开放？平时有人一起去游泳吗？', 'http://m.qpic.cn/psc?/V52A3KaK2bOdwM1FIz7o14kBqy1LBiZe/ruAMsa53pVQWN7FLK88i5s.wB5u0n3Jjk*XAm7XnbZYCQqcO5VMiEPAFod6q6v9RNg*nwyxILCjh4roXaY3h5QtSufxPa3s1kc6pBGwYau4!/b&bo=OAS9AwAAAAABB6I!&rf=viewer_4', '0', '0', '2024-03-31 18:36:14', '2024-04-23 00:29:46');
INSERT INTO `posts` VALUES ('8', '8', 'Post Title 8', '有没有宝子想五一一起去贵州旅游的，找个女生的搭子一起', 'http://sauzyzttl.hn-bkt.clouddn.com/ce4d4b7133e1d26b1be4fe24a1ccca0.png?e=1711359544&token=c3NOVwieocC3a7LvVYZ4BVdbdoYz6RwSD7X-Q-H5:dlvT9q9_iGVHlPQW9SLzmDE4f-A=', '2', '1', '2024-03-31 18:36:14', '2024-04-23 00:21:30');
INSERT INTO `posts` VALUES ('9', '9', 'Post Title 9', '投稿！看着学校里面的猫猫们健康长大，很感谢大家给猫猫们带来幸福,看得人心暖暖的', 'http://sauzyzttl.hn-bkt.clouddn.com/ce4d4b7133e1d26b1be4fe24a1ccca0.png?e=1711359544&token=c3NOVwieocC3a7LvVYZ4BVdbdoYz6RwSD7X-Q-H5:dlvT9q9_iGVHlPQW9SLzmDE4f-A=', '0', '0', '2024-03-31 18:36:14', '2024-04-23 00:21:30');
INSERT INTO `posts` VALUES ('10', '10', 'Post Title 10', '有没有今年考农学的同学来交流一下', 'http://sauzyzttl.hn-bkt.clouddn.com/ce4d4b7133e1d26b1be4fe24a1ccca0.png?e=1711359544&token=c3NOVwieocC3a7LvVYZ4BVdbdoYz6RwSD7X-Q-H5:dlvT9q9_iGVHlPQW9SLzmDE4f-A=', '5', '3', '2024-03-31 18:36:14', '2024-04-23 00:21:30');
INSERT INTO `posts` VALUES ('28', '11', '1', '有没有一起去广州天河区考编的搭子，这周末一起过去', 'http://m.qpic.cn/psc?/V52A3KaK2bOdwM1FIz7o14kBqy3cMgIE/ruAMsa53pVQWN7FLK88i5ivQoIEBkftXFHirBaEG*QIgPsHvLHKVyGAUOshQeOBHeZc0A2tJfPyRW3i6eB3hhuQeLURW2AchIG5bOEX*PEI!/b&bo=egE4AQAAAAADB2A!&rf=viewer_4', '0', '0', '2024-04-17 23:00:02', '2024-04-23 00:21:30');
INSERT INTO `posts` VALUES ('29', '11', '1', '最近大四考研失败了心情好低落，感觉无法接受努力了这么久失败的结果，每天都好伤心怎么走出来。', 'http://m.qpic.cn/psc?/V52A3KaK2bOdwM1FIz7o14kBqy1LBiZe/ruAMsa53pVQWN7FLK88i5vOgnGIp.F8wqvI4UMsAm6Xo77FXsgBM0sZqR0OyDKAmohe8O8irsl15Ltcrep3yJ*bMJgfqaxNNSpQaaWM6O9o!/b&bo=OAQKBQAAAAABBxM!&rf=viewer_4', '0', '0', '2024-04-17 23:00:19', '2024-04-23 00:39:55');
INSERT INTO `posts` VALUES ('38', '12', '1', '学校的实验大楼好久没来啦', '', '0', '0', '2024-04-26 16:06:46', '2024-06-11 22:09:08');

-- ----------------------------
-- Table structure for post_tags
-- ----------------------------
DROP TABLE IF EXISTS `post_tags`;
CREATE TABLE `post_tags` (
  `post_id` int NOT NULL,
  `tag_id` int NOT NULL,
  PRIMARY KEY (`post_id`,`tag_id`) USING BTREE,
  KEY `tag_id` (`tag_id`) USING BTREE,
  CONSTRAINT `post_tags_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `post_tags_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`tag_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of post_tags
-- ----------------------------
INSERT INTO `post_tags` VALUES ('5', '1');
INSERT INTO `post_tags` VALUES ('5', '2');
INSERT INTO `post_tags` VALUES ('9', '3');
INSERT INTO `post_tags` VALUES ('6', '4');
INSERT INTO `post_tags` VALUES ('7', '4');
INSERT INTO `post_tags` VALUES ('4', '5');
INSERT INTO `post_tags` VALUES ('8', '5');
INSERT INTO `post_tags` VALUES ('3', '7');
INSERT INTO `post_tags` VALUES ('10', '7');
INSERT INTO `post_tags` VALUES ('29', '7');
INSERT INTO `post_tags` VALUES ('1', '8');
INSERT INTO `post_tags` VALUES ('2', '13');
INSERT INTO `post_tags` VALUES ('28', '14');

-- ----------------------------
-- Table structure for schoolcolleges
-- ----------------------------
DROP TABLE IF EXISTS `schoolcolleges`;
CREATE TABLE `schoolcolleges` (
  `school_id` int NOT NULL,
  `college_id` int NOT NULL,
  PRIMARY KEY (`school_id`,`college_id`) USING BTREE,
  KEY `college_id` (`college_id`) USING BTREE,
  CONSTRAINT `schoolcolleges_ibfk_1` FOREIGN KEY (`school_id`) REFERENCES `schools` (`school_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `schoolcolleges_ibfk_2` FOREIGN KEY (`college_id`) REFERENCES `colleges` (`college_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of schoolcolleges
-- ----------------------------
INSERT INTO `schoolcolleges` VALUES ('1', '1');
INSERT INTO `schoolcolleges` VALUES ('1', '2');
INSERT INTO `schoolcolleges` VALUES ('1', '3');
INSERT INTO `schoolcolleges` VALUES ('1', '4');
INSERT INTO `schoolcolleges` VALUES ('1', '5');
INSERT INTO `schoolcolleges` VALUES ('1', '6');
INSERT INTO `schoolcolleges` VALUES ('1', '7');
INSERT INTO `schoolcolleges` VALUES ('1', '8');
INSERT INTO `schoolcolleges` VALUES ('1', '9');
INSERT INTO `schoolcolleges` VALUES ('1', '10');
INSERT INTO `schoolcolleges` VALUES ('1', '11');
INSERT INTO `schoolcolleges` VALUES ('1', '12');
INSERT INTO `schoolcolleges` VALUES ('1', '13');
INSERT INTO `schoolcolleges` VALUES ('1', '14');
INSERT INTO `schoolcolleges` VALUES ('1', '15');
INSERT INTO `schoolcolleges` VALUES ('1', '16');
INSERT INTO `schoolcolleges` VALUES ('1', '17');

-- ----------------------------
-- Table structure for schools
-- ----------------------------
DROP TABLE IF EXISTS `schools`;
CREATE TABLE `schools` (
  `school_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci NOT NULL,
  `location` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci,
  PRIMARY KEY (`school_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of schools
-- ----------------------------
INSERT INTO `schools` VALUES ('1', '肇庆学院', '肇庆', '肇庆学院（Zhaoqing University）是由广东省人民政府主办、广东省教育厅主管的具有硕士学位授予权的公办全日制本科高校，位于广东省珠三角城市肇庆。');
INSERT INTO `schools` VALUES ('2', '广东工商学院', 's', 's');

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `tag_id` int NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`tag_id`) USING BTREE,
  UNIQUE KEY `tag_name` (`tag_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tags
-- ----------------------------
INSERT INTO `tags` VALUES ('1', '四级', '2024-03-31 18:36:14');
INSERT INTO `tags` VALUES ('2', '六级', '2024-03-31 18:36:14');
INSERT INTO `tags` VALUES ('3', '宠物', '2024-03-31 18:36:14');
INSERT INTO `tags` VALUES ('4', '运动', '2024-03-31 18:36:14');
INSERT INTO `tags` VALUES ('5', '出行', '2024-03-31 18:36:14');
INSERT INTO `tags` VALUES ('6', '游戏', '2024-03-31 18:36:14');
INSERT INTO `tags` VALUES ('7', '考研', '2024-03-31 18:36:14');
INSERT INTO `tags` VALUES ('8', '美食', '2024-03-31 18:36:14');
INSERT INTO `tags` VALUES ('11', '跑步', '2024-04-17 15:09:54');
INSERT INTO `tags` VALUES ('12', '游泳', '2024-04-17 15:12:33');
INSERT INTO `tags` VALUES ('13', '摄影', '2024-04-23 00:22:53');
INSERT INTO `tags` VALUES ('14', '考编', '2024-04-23 00:24:58');
INSERT INTO `tags` VALUES ('15', '软考', '2024-04-26 15:03:33');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(50) COLLATE utf8mb3_german2_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci NOT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci DEFAULT NULL,
  `introduction` text CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `school_id` int DEFAULT NULL,
  `college_id` int DEFAULT NULL,
  `major_id` int DEFAULT NULL,
  `stu_number` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci DEFAULT NULL,
  `session_key` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_german2_ci NOT NULL,
  PRIMARY KEY (`user_id`,`account`),
  KEY `school_id` (`school_id`) USING BTREE,
  KEY `college_id` (`college_id`) USING BTREE,
  KEY `major_id` (`major_id`) USING BTREE,
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`school_id`) REFERENCES `schools` (`school_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `users_ibfk_2` FOREIGN KEY (`college_id`) REFERENCES `colleges` (`college_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `users_ibfk_3` FOREIGN KEY (`major_id`) REFERENCES `majors` (`major_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_german2_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '*KIKO', 'password1', 'https://tse1-mm.cn.bing.net/th/id/OIP-C.MUwdIjJAcNRKY6-K0YDd6QAAAA?rs=1&pid=ImgDetMain', '*KIKO', '1234567890', '唱跳', '2024-03-31 18:36:14', '2024-04-23 00:20:09', '1', '1', '1', '20200001', '');
INSERT INTO `users` VALUES ('2', 'user1', 'password2', 'http://m.qpic.cn/psc?/V52A3KaK2bOdwM1FIz7o14kBqy1LBiZe/ruAMsa53pVQWN7FLK88i5hcUywGlE.jumtvRR0qLtHDBx0xoHFT4ESzLEtimdvHG3I1ZswXGYnaNRt4Tr3gk1cC2Ds7VJLXHpgmj7wIJ*QA!/b&bo=OAQbBAAAAAABBwM!&rf=viewer_4', '没有星期八', '0987654321', '乒乓球', '2024-03-31 18:36:14', '2024-04-23 00:20:09', '1', '2', '3', '20200002', '');
INSERT INTO `users` VALUES ('3', 'user1', 'password1', 'https://ts1.cn.mm.bing.net/th/id/R-C.3049959b8c06c802d16d535975ce730d?rik=FBkdTolVCAOemQ&riu=http%3a%2f%2fimg.touxiangwu.com%2fuploads%2fallimg%2f2022053119%2fjal1spg1ses.jpg&ehk=N8IhTcYE9yv5m4YWdmWaapxNQ3WOo723iAOlTPGir5I%3d&risl=&pid=ImgRaw&r=0', '冰葡萄', '1234567890', '羽毛球', '2024-03-31 18:36:14', '2024-04-23 00:20:09', '1', '2', '4', '20200001', '');
INSERT INTO `users` VALUES ('4', 'user1', 'password2', 'http://m.qpic.cn/psc?/V52A3KaK2bOdwM1FIz7o14kBqy1LBiZe/ruAMsa53pVQWN7FLK88i5hcUywGlE.jumtvRR0qLtHDesla6O8A0Lw7ygd7kUhI8QVeh1ANHzTvVHjNBqPSrRtad2RclcMGC8I1Te1KZpco!/b&bo=.gD6AAAAAAABByA!&rf=viewer_4', '喜洋洋', '0987654321', '跳舞', '2024-03-31 18:36:14', '2024-04-23 00:20:09', '1', '3', '8', '20200002', '');
INSERT INTO `users` VALUES ('5', 'user1', 'password1', 'http://m.qpic.cn/psc?/V52A3KaK2bOdwM1FIz7o14kBqy1LBiZe/ruAMsa53pVQWN7FLK88i5hcUywGlE.jumtvRR0qLtHBO1.81gl92mF8w.5SU0KOCMQ*5xjoEWfgOezjLs94LZTzORIpOqeXyb6EsT4Kb36A!/b&bo=gAJwBAAAAAABB9Y!&rf=viewer_4', '小狗不开心', '1234567890', '跑步', '2024-03-31 18:36:14', '2024-04-23 00:20:09', '1', '3', '9', '20200001', '');
INSERT INTO `users` VALUES ('6', 'user1', 'password2', 'http://m.qpic.cn/psc?/V52A3KaK2bOdwM1FIz7o14kBqy1LBiZe/ruAMsa53pVQWN7FLK88i5hcUywGlE.jumtvRR0qLtHDTFbUY.Nb8WtK1cCwNLZN3QdMzTzNtF3XtIofgXHgzGl0.HVfS8Pb6fYspJqlssyA!/b&bo=gAKAAgAAAAABByA!&rf=viewer_4', '风止何安', '0987654321', '篮球', '2024-03-31 18:36:14', '2024-04-23 00:20:09', '1', '8', '24', '20200002', '');
INSERT INTO `users` VALUES ('7', 'user1', 'password1', 'http://m.qpic.cn/psc?/V52A3KaK2bOdwM1FIz7o14kBqy1LBiZe/ruAMsa53pVQWN7FLK88i5sxlUHn2K.Vsc05ObkWgDMeSJNgDmQlnAWYhZvLyP*m0UuFKMWHFQjsgMCHL0EHwLDRW3Cte5RP4f3B*5tEd1N4!/b&bo=NwQkBAAAAAABBzM!&rf=viewer_4', '鸽子', '1234567890', '手工', '2024-03-31 18:36:14', '2024-04-23 00:20:09', '1', '12', '40', '20200001', '');
INSERT INTO `users` VALUES ('8', 'user1', 'password2', 'http://m.qpic.cn/psc?/V52A3KaK2bOdwM1FIz7o14kBqy1LBiZe/ruAMsa53pVQWN7FLK88i5sxlUHn2K.Vsc05ObkWgDMfASqLoSd.OhkKJphge6vP3l5Qiuiih.HAJPTht9DiKcVC5yEvgfLIz6xyoHW727bg!/b&bo=gAKBAgAAAAABByE!&rf=viewer_4', '等等', '0987654321', '唱歌', '2024-03-31 18:36:14', '2024-04-23 00:20:09', '1', '12', '41', '20200002', '');
INSERT INTO `users` VALUES ('9', 'user1', 'password1', 'http://m.qpic.cn/psc?/V52A3KaK2bOdwM1FIz7o14kBqy1LBiZe/ruAMsa53pVQWN7FLK88i5sxlUHn2K.Vsc05ObkWgDMcAcGKwEbf0.n33MN*GR9.B046sR.eENrzFi6PCNqSB7yMLj12VlaTHadMEHJDMcA8!/b&bo=LwIwAgAAAAABBz8!&rf=viewer_4', '虾仁猪心', '1234567890', '画画', '2024-03-31 18:36:14', '2024-04-23 00:20:09', '1', '13', '44', '20200001', '');
INSERT INTO `users` VALUES ('10', 'user1', 'password2', 'http://m.qpic.cn/psc?/V52A3KaK2bOdwM1FIz7o14kBqy1LBiZe/ruAMsa53pVQWN7FLK88i5sxlUHn2K.Vsc05ObkWgDMeB2fjlBq3vJHrgyjbPCPG7ZYXZ0RRjkFi3QA3MkJgcSD2hY6AHiMKQxugmCZfnS3Y!/b&bo=6AFvAQAAAAABB6c!&rf=viewer_4', '奥利奥好吃', '0987654321', '摄影', '2024-03-31 18:36:14', '2024-04-23 00:20:09', '1', '13', '45', '20200002', '');
INSERT INTO `users` VALUES ('11', 'oDQTL6_cZ8rHGDbfQExVO_-wD1zw', null, '', '困', null, '吉他唱', '2024-04-03 19:17:58', '2024-06-11 22:08:42', '1', '6', '19', '202124101133', '5vwblHBUU7lhzzlH8Hk7Gg==');
INSERT INTO `users` VALUES ('12', 'oDQTL628qSQ1LhRKbrnYwaZw813w', null, '', '喵呜不停', null, null, '2024-04-26 15:55:28', '2024-06-11 22:08:45', null, null, null, null, 'shUhvn4cNR9rqyIsCJ2+SA==');
