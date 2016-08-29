/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Version : 50624
 Source Host           : localhost
 Source Database       : cd_forum

 Target Server Version : 50624
 File Encoding         : utf-8

 Date: 08/28/2016 18:00:08 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tforum_comment`
-- ----------------------------
DROP TABLE IF EXISTS `tforum_comment`;
CREATE TABLE `tforum_comment` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `content` text COMMENT '内容',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '上级编号',
  `updater` varchar(32) DEFAULT NULL COMMENT '操作人',
  `update_datetime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tforum_plate`
-- ----------------------------
DROP TABLE IF EXISTS `tforum_plate`;
CREATE TABLE `tforum_plate` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `site_code` varchar(32) DEFAULT NULL COMMENT '站点编号',
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
  `publisher` varchar(32) DEFAULT NULL COMMENT '发布人',
  `publish_datetime` datetime DEFAULT NULL COMMENT '发布时间',
  `approver` varchar(32) DEFAULT NULL COMMENT '审核人',
  `approve_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `approve_note` varchar(255) DEFAULT NULL COMMENT '审核说明',
  `is_report` varchar(4) DEFAULT NULL COMMENT '是否举报',
  `reporter` varchar(32) DEFAULT NULL COMMENT '举报人',
  `report_datetime` datetime DEFAULT NULL COMMENT '举报时间',
  `report_note` varchar(255) DEFAULT NULL COMMENT '举报说明',
  `status` varchar(4) DEFAULT NULL COMMENT '状态(0 待审核 1 审核通过 2 审核不同 3 已发布)',
  `is_headline` varchar(4) DEFAULT NULL COMMENT '是否头条',
  `is_top` varchar(4) DEFAULT NULL COMMENT '是否置顶',
  `is_essence` varchar(4) DEFAULT NULL COMMENT '是否精华',
  `read_time` int(11) DEFAULT NULL COMMENT '阅读次数',
  `plate_code` varchar(32) DEFAULT NULL COMMENT '板块编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tforum_post_talk`
-- ----------------------------
DROP TABLE IF EXISTS `tforum_post_talk`;
CREATE TABLE `tforum_post_talk` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) DEFAULT NULL COMMENT '类型(1 点赞 2 收藏 3 打赏 4 举报)',
  `post_code` varchar(32) DEFAULT NULL COMMENT '帖子编号',
  `updater` varchar(32) DEFAULT NULL COMMENT '操作人',
  `update_datetime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tforum_site`
-- ----------------------------
DROP TABLE IF EXISTS `tforum_site`;
CREATE TABLE `tforum_site` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `leader` varchar(255) DEFAULT NULL COMMENT '负责人',
  `contacts` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(255) DEFAULT NULL COMMENT '地区',
  `is_hot` varchar(4) DEFAULT NULL COMMENT '是否推荐',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
