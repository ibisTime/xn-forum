/*
-- Query: select `to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,now() as `update_datetime`,`remark` from tsys_dict
LIMIT 0, 50000

-- Date: 2016-10-11 16:07
*/
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'user_status','用户状态','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','user_status','0','正常','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','user_status','1','程序锁定','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','user_status','2','人工锁定','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'id_kind','证件类型','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','id_kind','1','身份证','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'role_level','角色等级','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','role_level','1','运维','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','role_level','2','运营','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','role_level','3','客户','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'res_type','资源类型','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','res_type','1','菜单','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','res_type','2','按钮','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'lock_direction','锁定方向','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','lock_direction','1','用锁','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','lock_direction','2','解锁','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'jour_status','流水状态','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','jour_status','0','免对账','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','jour_status','1','待对账','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','jour_status','2','已对账待调帐','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','jour_status','9','已对账且账已平','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'true_false','对错','admin',now(),NULL);
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','true_false','1','是','admin',now(),NULL);
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','true_false','0','否','admin',now(),NULL);

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'active_status','激活状态','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','active_status','0','未启用','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','active_status','1','启用','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'view_type','视图类型','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','view_type','1','菜单','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','view_type','2','广告图','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','view_type','3','模块','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','view_type','4','引流','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','view_type','5','启动页','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'city_location','城市优先级','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','city_location','0','不启用','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','city_location','1','正常','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','city_location','2','推荐','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'plate_kind','版块分类','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','1','美食','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','2','情感','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','3','时尚','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','4','阅读','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','5','旅游摄影','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','6','相亲','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','7','跳蚤市场','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','8','求职','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','9','房产','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','10','理财','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','11','八卦','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','12','早知道','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','13','结婚','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','14','家居','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','15','亲子','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','16','教育','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','17','健康','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','18','汽车','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','19','宠物','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','20','运动','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_kind','21','其他','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'plate_location','版块地位','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_location','1','引流','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','plate_location','2','普通','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'post_location','版块地位','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','post_location','1','置顶','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','post_location','2','精华','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'post_status','帖子状态','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','post_status','0','待审核','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','post_status','1','审核通过','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','post_status','2','审核不通过','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','post_status','3','已发布','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'user_kind','用户等级','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','user_kind','1','新手','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','user_kind','2','初出茅庐','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','user_kind','3','元老','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'kw_reaction','关键字反应','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','kw_reaction','1','屏蔽','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','kw_reaction','2','审核','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','kw_reaction','3','拒绝','admin',now(),'');


INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'rule_kind','规则类别','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','rule_kind','1','积分项','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','rule_kind','2','举报数','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'rule_type','规则类型','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','rule_type','A','注册送积分','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','rule_type','B','每日签到','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','rule_type','C','资料完善','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','rule_type','D','发帖','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','rule_type','E','评论','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','rule_type','F','加精华','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','rule_type','G','举报','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'prod_kind','产品类别','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','prod_kind','A','数码','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','prod_kind','B','家纺','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'prod_status','产品状态','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','prod_status','0','未发布','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','prod_status','1','上架中','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','prod_status','2','已下架','admin',now(),'');

INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','0',NULL,'order_status','订单状态','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','order_status','1','已支付','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','order_status','2','已取货','admin',now(),'');
INSERT INTO `tsys_dict` (`to_system`,`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`) VALUES ('8','1','order_status','3','作废','admin',now(),'');


