/*
Navicat MySQL Data Transfer

Source Server         : MYSQL
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : crawl

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-04-12 15:17:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `letter` varchar(2) DEFAULT NULL,
  `job_type` int(11) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '安庆', 'https://aq.lianjia.com/', 'A', '0', '安徽');
INSERT INTO `city` VALUES ('2', '滁州', 'https://cz.fang.lianjia.com/', 'A', '0', '安徽');
INSERT INTO `city` VALUES ('3', '合肥', 'https://hf.lianjia.com/', 'A', '0', '安徽');
INSERT INTO `city` VALUES ('4', '马鞍山', 'https://mas.lianjia.com/', 'A', '0', '安徽');
INSERT INTO `city` VALUES ('5', '芜湖', 'https://wuhu.lianjia.com/', 'A', '0', '安徽');
INSERT INTO `city` VALUES ('6', '北京', 'https://bj.lianjia.com/', 'B', '0', '北京');
INSERT INTO `city` VALUES ('7', '重庆', 'https://cq.lianjia.com/', 'C', '0', '重庆');
INSERT INTO `city` VALUES ('8', '福州', 'https://fz.lianjia.com/', 'F', '0', '福建');
INSERT INTO `city` VALUES ('9', '龙岩', 'https://ly.fang.lianjia.com/', 'F', '0', '福建');
INSERT INTO `city` VALUES ('10', '泉州', 'https://quanzhou.lianjia.com/', 'F', '0', '福建');
INSERT INTO `city` VALUES ('11', '厦门', 'https://xm.lianjia.com/', 'F', '0', '福建');
INSERT INTO `city` VALUES ('12', '漳州', 'https://zhangzhou.lianjia.com/', 'F', '0', '福建');
INSERT INTO `city` VALUES ('13', '东莞', 'https://dg.lianjia.com/', 'G', '0', '广东');
INSERT INTO `city` VALUES ('14', '佛山', 'https://fs.lianjia.com/', 'G', '0', '广东');
INSERT INTO `city` VALUES ('15', '广州', 'https://gz.lianjia.com/', 'G', '0', '广东');
INSERT INTO `city` VALUES ('16', '惠州', 'https://hui.lianjia.com/', 'G', '0', '广东');
INSERT INTO `city` VALUES ('17', '江门', 'https://jiangmen.lianjia.com/', 'G', '0', '广东');
INSERT INTO `city` VALUES ('18', '清远', 'https://qy.lianjia.com/', 'G', '0', '广东');
INSERT INTO `city` VALUES ('19', '深圳', 'https://sz.lianjia.com/', 'G', '0', '广东');
INSERT INTO `city` VALUES ('20', '珠海', 'https://zh.lianjia.com/', 'G', '0', '广东');
INSERT INTO `city` VALUES ('21', '湛江', 'https://zhanjiang.lianjia.com/', 'G', '0', '广东');
INSERT INTO `city` VALUES ('22', '中山', 'https://zs.lianjia.com/', 'G', '0', '广东');
INSERT INTO `city` VALUES ('23', '黄石', 'https://huangshi.lianjia.com/', 'H', '0', '湖北');
INSERT INTO `city` VALUES ('24', '黄冈', 'https://hg.fang.lianjia.com/', 'H', '0', '湖北');
INSERT INTO `city` VALUES ('25', '武汉', 'https://wh.lianjia.com/', 'H', '0', '湖北');
INSERT INTO `city` VALUES ('26', '襄阳', 'https://xy.lianjia.com/', 'H', '0', '湖北');
INSERT INTO `city` VALUES ('27', '咸宁', 'https://xn.fang.lianjia.com/', 'H', '0', '湖北');
INSERT INTO `city` VALUES ('28', '宜昌', 'https://yichang.lianjia.com/', 'H', '0', '湖北');
INSERT INTO `city` VALUES ('29', '常州', 'https://changzhou.lianjia.com/', 'J', '0', '江苏');
INSERT INTO `city` VALUES ('30', '淮安', 'https://ha.lianjia.com/', 'J', '0', '江苏');
INSERT INTO `city` VALUES ('31', '昆山', 'https://ks.lianjia.com/', 'J', '0', '江苏');
INSERT INTO `city` VALUES ('32', '南京', 'https://nj.lianjia.com/', 'J', '0', '江苏');
INSERT INTO `city` VALUES ('33', '南通', 'https://nt.lianjia.com/', 'J', '0', '江苏');
INSERT INTO `city` VALUES ('34', '苏州', 'https://su.lianjia.com/', 'J', '0', '江苏');
INSERT INTO `city` VALUES ('35', '无锡', 'https://wx.lianjia.com/', 'J', '0', '江苏');
INSERT INTO `city` VALUES ('36', '徐州', 'https://xz.lianjia.com/', 'J', '0', '江苏');
INSERT INTO `city` VALUES ('37', '盐城', 'https://yc.lianjia.com/', 'J', '0', '江苏');
INSERT INTO `city` VALUES ('38', '镇江', 'https://zj.lianjia.com/', 'J', '0', '江苏');
INSERT INTO `city` VALUES ('39', '大连', 'https://dl.lianjia.com/', 'L', '0', '辽宁');
INSERT INTO `city` VALUES ('40', '丹东', 'https://dd.lianjia.com/', 'L', '0', '辽宁');
INSERT INTO `city` VALUES ('41', '沈阳', 'https://sy.lianjia.com/', 'L', '0', '辽宁');
INSERT INTO `city` VALUES ('42', '呼和浩特', 'https://hhht.lianjia.com/', 'N', '0', '内蒙古');
INSERT INTO `city` VALUES ('43', '上海', 'https://sh.lianjia.com/', 'S', '0', '上海');
INSERT INTO `city` VALUES ('44', '天津', 'https://tj.lianjia.com/', 'T', '0', '天津');
INSERT INTO `city` VALUES ('45', '大理', 'https://dali.fang.lianjia.com/', 'Y', '0', '云南');
INSERT INTO `city` VALUES ('46', '昆明', 'https://km.lianjia.com/', 'Y', '0', '云南');
INSERT INTO `city` VALUES ('47', '西双版纳', 'https://xsbn.fang.lianjia.com/', 'Y', '0', '云南');
INSERT INTO `city` VALUES ('48', '杭州', 'https://hz.lianjia.com/', 'Z', '0', '浙江');
INSERT INTO `city` VALUES ('49', '湖州', 'https://huzhou.lianjia.com/', 'Z', '0', '浙江');
INSERT INTO `city` VALUES ('50', '嘉兴', 'https://jx.lianjia.com/', 'Z', '0', '浙江');
INSERT INTO `city` VALUES ('51', '金华', 'https://jh.lianjia.com/', 'Z', '0', '浙江');
INSERT INTO `city` VALUES ('52', '宁波', 'https://nb.lianjia.com/', 'Z', '0', '浙江');
INSERT INTO `city` VALUES ('53', '绍兴', 'https://sx.lianjia.com/', 'Z', '0', '浙江');
INSERT INTO `city` VALUES ('54', '台州', 'https://taizhou.lianjia.com/', 'Z', '0', '浙江');
INSERT INTO `city` VALUES ('55', '温州', 'https://wz.lianjia.com/', 'Z', '0', '浙江');
