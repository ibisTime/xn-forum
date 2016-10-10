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
--  Table structure for `tforum_navigate`
-- ----------------------------
DROP TABLE IF EXISTS `tforum_navigate`;
CREATE TABLE `tforum_navigate` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` varchar(4) DEFAULT NULL COMMENT '类型(1 菜单 2 banner 3 模块 4 引流)',
  `url` varchar(255) DEFAULT NULL COMMENT '访问Url',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(1 显示 0 不显示)',
  `is_global` varchar(4) DEFAULT NULL COMMENT '是否全局(1 是 0 否)',
  `order_no` int(11) DEFAULT NULL COMMENT '相对位置编号',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父编号',
  `site_code` varchar(32) DEFAULT NULL COMMENT '站点编号',
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
  `category` varchar(4) DEFAULT NULL COMMENT '大类',
  `user_id` varchar(32) DEFAULT NULL COMMENT '版主编号',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `site_code` varchar(32) DEFAULT NULL COMMENT '站点编号',
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
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(0 待审核 1 审核通过 2 审核不通过 3 已发布)',
  `publisher` varchar(32) DEFAULT NULL COMMENT '发布人',
  `publish_datetime` datetime DEFAULT NULL COMMENT '发布时间',
  `approver` varchar(32) DEFAULT NULL COMMENT '审核人',
  `approve_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `approve_note` varchar(255) DEFAULT NULL COMMENT '审核说明',
  `position` varchar(4) DEFAULT NULL COMMENT '位置(1 置顶 2 精华 3 头条)',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `plate_code` varchar(32) DEFAULT NULL COMMENT '板块编号',
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
--  Table structure for `tforum_prod_order`
-- ----------------------------
DROP TABLE IF EXISTS `tforum_prod_order`;
CREATE TABLE `tforum_prod_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `product_code` varchar(32) DEFAULT NULL COMMENT '商品编号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(1 已支付 2 已取货)',
  `pay_price` bigint(20) DEFAULT NULL COMMENT '支付价格',
  `payer` varchar(32) DEFAULT NULL COMMENT '支付人',
  `pay_datetime` datetime DEFAULT NULL COMMENT '支付时间',
  `dealer` varchar(32) DEFAULT NULL COMMENT '确认人',
  `deal_datetime` datetime DEFAULT NULL COMMENT '确认时间',
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
  `category` varchar(4) DEFAULT NULL COMMENT '类别',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `description` text COMMENT '描述',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(1 上架中 0 已下架)',
  `price` bigint(20) DEFAULT NULL COMMENT '价格',
  `site_cdoe` varchar(32) DEFAULT NULL COMMENT '站点编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tforum_rule`
-- ----------------------------
DROP TABLE IF EXISTS `tforum_rule`;
CREATE TABLE `tforum_rule` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `category` varchar(4) DEFAULT NULL COMMENT '类别(1 积分 2 举报)',
  `type` varchar(4) DEFAULT NULL COMMENT '类型(A注册送积分/B 每次签到/C 资料完善/D 发帖/E 评论  /F 加精华)',
  `level` varchar(4) DEFAULT NULL COMMENT '作用等级(1 一级/2 二级/3 三级)',
  `value` int(11) DEFAULT NULL COMMENT '值(积分数/次数)',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tforum_site`
-- ----------------------------
DROP TABLE IF EXISTS `tforum_site`;
CREATE TABLE `tforum_site` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '站点名称',
  `province` varchar(255) DEFAULT NULL COMMENT '省',
  `city` varchar(255) DEFAULT NULL COMMENT '市',
  `area` varchar(255) DEFAULT NULL COMMENT '区',
  `user_id` varchar(255) DEFAULT NULL COMMENT '负责人编号',
  `priority` varchar(4) DEFAULT NULL COMMENT '优先级( 0 不启用 1 正常 2 推荐）',
  `is_default` varchar(4) DEFAULT NULL COMMENT '是否默认',
  `domain` varchar(255) DEFAULT NULL COMMENT '域名(预留)',
  `logo` varchar(255) DEFAULT NULL COMMENT 'logo(预留)',
  `address` varchar(255) DEFAULT NULL COMMENT '取货地址',
  `telephone` varchar(32) DEFAULT NULL COMMENT '电话(预留)',
  `description` varchar(255) DEFAULT NULL COMMENT '简介(预留)',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱(预留)',
  `qr_code` varchar(255) DEFAULT NULL COMMENT '二维码(预留)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;