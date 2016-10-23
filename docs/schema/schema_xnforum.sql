/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Version : 50624
 Source Host           : localhost
 Source Database       : csw_forum

 Target Server Version : 50624
 File Encoding         : utf-8

 Date: 10/09/2016 11:34:46 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tforum_keyword`
-- ----------------------------
DROP TABLE IF EXISTS `tforum_keyword`;
CREATE TABLE `tforum_keyword` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `word` varchar(255) DEFAULT NULL COMMENT '词语',
  `weight` int(11) DEFAULT NULL COMMENT '权重(0-1 0.5以上黑，0.5以下白)',
  `level` varchar(4) DEFAULT NULL COMMENT '作用等级',
  `reaction` varchar(4) DEFAULT NULL COMMENT '反应(1 直接拦截/2 替换**)',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tforum_plate`
-- ----------------------------
DROP TABLE IF EXISTS `tforum_plate`;
CREATE TABLE `tforum_plate` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `kind` varchar(4) DEFAULT NULL COMMENT '大类',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `location` varchar(4) DEFAULT NULL COMMENT '位置(1 帖子引流)',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '版主编号',
  `site_code` varchar(32) DEFAULT NULL COMMENT '站点编号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(1 可见 0 不可见)',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tforum_post`
-- ----------------------------
DROP TABLE IF EXISTS `tforum_post`;
CREATE TABLE `tforum_post` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `pic` text COMMENT '图片',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `publisher` varchar(32) DEFAULT NULL COMMENT '发布人',
  `publish_datetime` datetime DEFAULT NULL COMMENT '发布时间',
  `approver` varchar(32) DEFAULT NULL COMMENT '审核人',
  `approve_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `approve_note` varchar(255) DEFAULT NULL COMMENT '审核说明',
  `location` varchar(4) DEFAULT NULL COMMENT '位置(A 置顶 B 精华 C头条)',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `plate_code` varchar(32) DEFAULT NULL COMMENT '板块编号',
  `is_lock` char(1) DEFAULT NULL COMMENT '是否锁帖',
  `valid_datetime_start` datetime DEFAULT NULL COMMENT '有效期起',
  `valid_datetime_end` datetime DEFAULT NULL COMMENT '有效期止',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tforum_post_talk`
-- ----------------------------
DROP TABLE IF EXISTS `tforum_post_talk`;
CREATE TABLE `tforum_post_talk` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) DEFAULT NULL COMMENT '类型(1 点赞 2 收藏 3 打赏 4 举报 5 阅读)',
  `post_code` varchar(32) DEFAULT NULL COMMENT '帖子编号',
  `talker` varchar(32) DEFAULT NULL COMMENT '操作人',
  `talk_datetime` datetime DEFAULT NULL COMMENT '操作时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tforum_comment`
-- ----------------------------
DROP TABLE IF EXISTS `tforum_comment`;
CREATE TABLE `tforum_comment` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `content` text COMMENT '内容',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '上级编号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `commer` varchar(32) DEFAULT NULL COMMENT '评论人',
  `comm_datetime` datetime DEFAULT NULL COMMENT '评论时间',
  `approver` varchar(32) DEFAULT NULL COMMENT '审核人',
  `approve_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `approve_note` varchar(255) DEFAULT NULL COMMENT '审核意见',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tforum_product`
-- ----------------------------
DROP TABLE IF EXISTS `tforum_product`;
CREATE TABLE `tforum_product` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(64) DEFAULT NULL,
  `kind` varchar(4) DEFAULT NULL COMMENT '类别',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `description` text COMMENT '描述',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(1 上架中 0 已下架)',
  `price` bigint(20) DEFAULT NULL COMMENT '价格',
  `quantity` int(11) DEFAULT NULL COMMENT '库存',
  `site_code` varchar(32) DEFAULT NULL COMMENT '站点编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tforum_prod_order`
-- ----------------------------
DROP TABLE IF EXISTS `tforum_prod_order`;
CREATE TABLE `tforum_prod_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `product_code` varchar(32) DEFAULT NULL COMMENT '商品编号',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(0 待支付 1 已支付 2 待提货  3 已取货)',
  `pay_price` bigint(20) DEFAULT NULL COMMENT '支付价格',
  `payer` varchar(32) DEFAULT NULL COMMENT '支付人',
  `pay_datetime` datetime DEFAULT NULL COMMENT '支付时间',
  `taker` varchar(32) DEFAULT NULL COMMENT '提货人',
  `take_datetime` datetime DEFAULT NULL COMMENT '提货时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;