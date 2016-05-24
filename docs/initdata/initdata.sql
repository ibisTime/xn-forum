INSERT INTO `tsys_role` (`code`,`name`,`level`,`updater`,`update_datetime`,`remark`,`kind`) VALUES ('SR201600000000000001','超级管理员','1','admin',now(),'','1');

INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600000000000000','根目录','1','#','1','admin',now(),NULL,'','');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000001','权限管理','1','#','1','admin',now(),'','SM201600000000000000','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000002','权限管理','1','#','1','admin',now(),'','SM201600001000000001','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000003','角色管理','1','/security/role.htm','1','admin',now(),'','SM201600001000000002','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000004','新增','2','/role/add','1','admin',now(),'','SM201600001000000003','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000005','修改','2','/role/edit','2','admin',now(),'','SM201600001000000003','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000006','删除','2','/role/drop','3','admin',now(),'','SM201600001000000003','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000007','分配菜单','2','/role/menuRole/change','4','admin',now(),'','SM201600001000000003','1');
-- INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000008','用户管理','1','/security/user.htm','2','admin',now(),'','SM201600001000000002','1');
-- INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000009','新增','2','/user/add','1','admin',now(),'','SM201600001000000008','1');
-- INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000010','代注册','2','/user/replaceAdd','2','admin',now(),'','SM201600001000000008','1');
-- INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000011','修改联系方式','2','/user/edit','3','admin',now(),'','SM201600001000000008','1');
-- INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000012','注销','2','/user/drop','1','admin',now(),'','SM201600001000000008','1');
-- INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000013','设置角色','2','/user/userRole/changeRole','4','admin',now(),'','SM201600001000000008','1');
-- INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000014','补充实名信息','2','/user/real','1','admin',now(),'','SM201600001000000008','1');
-- INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000015','重置登录密码','2','/user/rePwd','5','admin',now(),'','SM201600001000000008','1');
-- INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000016','重置交易密码','2','/user/reTradePwd','6','admin',now(),'','SM201600001000000008','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000017','运营管理','1','#','2','admin',now(),'','SM201600000000000000','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000018','日常管理','1','#','1','admin',now(),'','SM201600001000000017','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000025','数据字典管理','1','/general/dict.htm','3','admin',now(),'','SM201600001000000018','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000026','增加','2','/general/dict/add','1','admin',now(),'','SM201600001000000025','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000027','修改','2','/general/dict/edit','1','admin',now(),'','SM201600001000000025','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000028','删除','2','/general/dict/drop','2','admin',now(),'','SM201600001000000025','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000031','运维管理','1','#','3','admin',now(),'','SM201600000000000000','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000032','系统参数','1','#','1','admin',now(),'','SM201600001000000031','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000033','菜单设置','1','/security/menu.htm','1','admin',now(),'','SM201600001000000032','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000034','修改','2','/menu/edit','1','admin',now(),'','SM201600001000000033','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000035','系统参数设置','1','/general/sys_param.htm','2','admin',now(),'','SM201600001000000032','1');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`kind`) VALUES ('SM201600001000000036','修改','2','/general/sys_param/edit','1','admin',now(),'','SM201600001000000035','1');


/*
-- Query: SELECT * FROM develop_m_moom.tsys_menu_role
LIMIT 0, 50000

-- Date: 2016-05-16 08:41
*/
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (1,'SR201600000000000001','SM201600000000000000','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (2,'SR201600000000000001','SM201600001000000000','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (3,'SR201600000000000001','SM201600001000000001','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (4,'SR201600000000000001','SM201600001000000002','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (5,'SR201600000000000001','SM201600001000000003','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (6,'SR201600000000000001','SM201600001000000004','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (7,'SR201600000000000001','SM201600001000000005','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (8,'SR201600000000000001','SM201600001000000006','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (9,'SR201600000000000001','SM201600001000000007','admin',now(),NULL);
-- INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (10,'SR201600000000000001','SM201600001000000008','admin',now(),NULL);
-- INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (11,'SR201600000000000001','SM201600001000000009','admin',now(),NULL);
-- INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (12,'SR201600000000000001','SM201600001000000010','admin',now(),NULL);
-- INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (13,'SR201600000000000001','SM201600001000000011','admin',now(),NULL);
-- INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (14,'SR201600000000000001','SM201600001000000012','admin',now(),NULL);
-- INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (15,'SR201600000000000001','SM201600001000000013','admin',now(),NULL);
-- INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (16,'SR201600000000000001','SM201600001000000014','admin',now(),NULL);
-- INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (17,'SR201600000000000001','SM201600001000000015','admin',now(),NULL);
-- INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (18,'SR201600000000000001','SM201600001000000016','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (19,'SR201600000000000001','SM201600001000000017','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (20,'SR201600000000000001','SM201600001000000018','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (27,'SR201600000000000001','SM201600001000000025','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (28,'SR201600000000000001','SM201600001000000026','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (29,'SR201600000000000001','SM201600001000000027','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (30,'SR201600000000000001','SM201600001000000028','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (31,'SR201600000000000001','SM201600001000000029','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (32,'SR201600000000000001','SM201600001000000030','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (33,'SR201600000000000001','SM201600001000000031','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (34,'SR201600000000000001','SM201600001000000032','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (35,'SR201600000000000001','SM201600001000000033','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (36,'SR201600000000000001','SM201600001000000034','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (37,'SR201600000000000001','SM201600001000000035','admin',now(),NULL);
INSERT INTO `tsys_menu_role` (`id`,`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`) VALUES (38,'SR201600000000000001','SM201600001000000036','admin',now(),NULL);
