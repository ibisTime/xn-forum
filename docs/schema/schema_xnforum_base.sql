CREATE TABLE `tsys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号（自增长）',
  `type` char(1) DEFAULT NULL COMMENT '类型（第一层/第二层）',
  `parent_key` varchar(32) DEFAULT NULL COMMENT '父key',
  `dkey` varchar(32) DEFAULT NULL COMMENT 'key',
  `dvalue` varchar(255) DEFAULT NULL COMMENT '值',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tsys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` varchar(4) DEFAULT NULL COMMENT '类型',
  `ckey` varchar(32) DEFAULT NULL COMMENT 'key值',
  `cvalue` varchar(255) DEFAULT NULL COMMENT '值',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


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

DROP TABLE IF EXISTS `tforum_bplate_template`;
CREATE TABLE `tforum_bplate_template` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tforum_bplate`;
CREATE TABLE `tforum_bplate` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '站点编号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tforum_splate_template`;
CREATE TABLE `tforum_splate_template` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `bplate_code` varchar(4) DEFAULT NULL COMMENT '大板块编号',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tforum_splate`;
CREATE TABLE `tforum_splate` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `bplate_code` varchar(4) DEFAULT NULL COMMENT '大板块编号',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `moderator` varchar(32) DEFAULT NULL COMMENT '版主编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '站点编号',
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
  `title` text CHARACTER SET utf8mb4 COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COMMENT '内容',
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
  `remark` text DEFAULT NULL COMMENT '备注',
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
  `content` text CHARACTER SET utf8mb4 COMMENT '内容',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '上级编号',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `commer` varchar(32) DEFAULT NULL COMMENT '评论人',
  `comm_datetime` datetime DEFAULT NULL COMMENT '评论时间',
  `approver` varchar(32) DEFAULT NULL COMMENT '审核人',
  `approve_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `approve_note` varchar(255) DEFAULT NULL COMMENT '审核意见',
  `remark` text COMMENT '备注',
  `post_code` varchar(32) DEFAULT NULL COMMENT '帖子编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;






SET FOREIGN_KEY_CHECKS = 1;