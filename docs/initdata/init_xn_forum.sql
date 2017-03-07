/*
-- Query: SELECT * FROM csw_forum.tforum_category
LIMIT 0, 10000

-- Date: 2017-03-02 11:08
*/
INSERT INTO `tforum_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`) VALUES ('FL2016100000000000001','0','1','城市生活',NULL,1,'1','0');
INSERT INTO `tforum_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`) VALUES ('FL2016100000000000002','0','1','便民中心',NULL,1,'1','0');
INSERT INTO `tforum_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`) VALUES ('FL2016100000000000003','0','1','同城活动',NULL,1,'1','0');

/*
-- Query: SELECT * FROM csw_forum.tforum_plate where site_code = '0'
LIMIT 0, 10000

-- Date: 2017-03-02 11:11
*/
INSERT INTO `tforum_plate` (`code`,`name`,`kind`,`pic`,`location`,`order_no`,`user_id`,`site_code`,`status`,`updater`,`update_datetime`,`remark`) VALUES ('BK0000000000001','情感','FL2016100000000000001',NULL,NULL,NULL,'','0','1',NULL,NULL,NULL);
INSERT INTO `tforum_plate` (`code`,`name`,`kind`,`pic`,`location`,`order_no`,`user_id`,`site_code`,`status`,`updater`,`update_datetime`,`remark`) VALUES ('BK0000000000002','吃货','FL2016100000000000001',NULL,NULL,NULL,'','0','1',NULL,NULL,NULL);
INSERT INTO `tforum_plate` (`code`,`name`,`kind`,`pic`,`location`,`order_no`,`user_id`,`site_code`,`status`,`updater`,`update_datetime`,`remark`) VALUES ('BK0000000000003','车友','FL2016100000000000001',NULL,NULL,NULL,'','0','1',NULL,NULL,NULL);
INSERT INTO `tforum_plate` (`code`,`name`,`kind`,`pic`,`location`,`order_no`,`user_id`,`site_code`,`status`,`updater`,`update_datetime`,`remark`) VALUES ('BK0000000000004','求助','FL2016100000000000001',NULL,NULL,NULL,'','0','1',NULL,NULL,NULL);
INSERT INTO `tforum_plate` (`code`,`name`,`kind`,`pic`,`location`,`order_no`,`user_id`,`site_code`,`status`,`updater`,`update_datetime`,`remark`) VALUES ('BK0000000000005','招聘','FL2016100000000000002',NULL,NULL,NULL,'','0','1',NULL,NULL,NULL);
INSERT INTO `tforum_plate` (`code`,`name`,`kind`,`pic`,`location`,`order_no`,`user_id`,`site_code`,`status`,`updater`,`update_datetime`,`remark`) VALUES ('BK0000000000006','出租','FL2016100000000000002',NULL,NULL,NULL,'','0','1',NULL,NULL,NULL);
INSERT INTO `tforum_plate` (`code`,`name`,`kind`,`pic`,`location`,`order_no`,`user_id`,`site_code`,`status`,`updater`,`update_datetime`,`remark`) VALUES ('BK0000000000007','二手','FL2016100000000000002',NULL,NULL,NULL,'','0','1',NULL,NULL,NULL);
INSERT INTO `tforum_plate` (`code`,`name`,`kind`,`pic`,`location`,`order_no`,`user_id`,`site_code`,`status`,`updater`,`update_datetime`,`remark`) VALUES ('BK0000000000008','活动','FL2016100000000000003',NULL,NULL,NULL,'','0','1',NULL,NULL,NULL);