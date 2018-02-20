# Host: localhost  (Version: 5.5.15)
# Date: 2018-02-05 10:02:01
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "meeting"
#

DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting` (
  `meeting_id` int(11) NOT NULL AUTO_INCREMENT,
  `meeting_title` varchar(50) NOT NULL DEFAULT '' COMMENT '会议标题',
  `meeting_content` varchar(1000) DEFAULT NULL COMMENT '会议内容',
  `meeting_begintime` varchar(50) NOT NULL DEFAULT '' COMMENT '会议开始时间',
  `meeting_endtime` varchar(50) DEFAULT NULL COMMENT '会议结束时间',
  `meeting_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '会议负责人',
  `meeting_room_id` int(11) NOT NULL DEFAULT '0' COMMENT '所在会议室',
  `meeting_status` int(2) NOT NULL DEFAULT '1' COMMENT '会议状态',
  `meeting_create_datetime` varchar(50) NOT NULL DEFAULT '' COMMENT '创建时间',
  `meeting_create_name` int(11) NOT NULL DEFAULT '0' COMMENT '创建人名',
  `meeting_update_datetime` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `meeting_update_name` varchar(50) DEFAULT NULL COMMENT '修改人名',
  `meeting_default1` varchar(50) DEFAULT NULL COMMENT '默认字段1',
  `meeting_default2` varchar(50) DEFAULT NULL COMMENT '默认字段2',
  PRIMARY KEY (`meeting_id`),
  KEY `fk_meeting_room_id` (`meeting_room_id`),
  KEY `FK_ejuraxlto54pgee7thrm89qmy` (`meeting_user_id`),
  CONSTRAINT `FK_ejuraxlto54pgee7thrm89qmy` FOREIGN KEY (`meeting_user_id`) REFERENCES `userinfo_main` (`user_id`),
  CONSTRAINT `fk_meeting_room_id` FOREIGN KEY (`meeting_room_id`) REFERENCES `room` (`room_id`),
  CONSTRAINT `fk_meeting_user_id` FOREIGN KEY (`meeting_user_id`) REFERENCES `userinfo` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

#
# Data for table "meeting"
#

INSERT INTO `meeting` VALUES (7,'年会','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',1,1,1,'Wed Jan 17 11:52:47 CST 2018',1,'','','',''),(8,'1','1','1','1',1,1,1,'1',1,'1','1','1','1'),(9,'年会','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,1,'Wed Jan 17 13:14:57 CST 2018',1,'','','',''),(10,'年会','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,1,'Wed Jan 17 15:55:52 CST 2018',11,'','','',''),(11,'年会','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,1,'Thu Jan 18 11:21:42 CST 2018',1,'','','',''),(13,'年会','11111.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,1,'Tue Jan 23 15:16:34 CST 2018',1,'','','',''),(14,'lcd','??.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,1,'Fri Jan 19 13:53:05 CST 2018',1,'','','',''),(15,'lcd','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,1,'Fri Jan 19 13:54:49 CST 2018',1,'','','',''),(16,'lcdlcd','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,1,'Fri Jan 19 15:45:13 CST 2018',1,'','','',''),(17,'腊八八','11111.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,1,'Mon Jan 29 13:45:54 CST 2018',1,'','','',''),(24,'年会','1','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,1,'',1,'','','',''),(26,'年会','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,1,'Tue Jan 23 15:14:35 CST 2018',1,'未填写','未填写','',''),(27,'年会','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',1,1,1,'Tue Jan 23 15:16:15 CST 2018',1,'未填写','未填写','',''),(28,'腊八八','11111.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,1,'Wed Jan 24 16:10:21 CST 2018',1,'未填写','未填写','',''),(47,'1','1','1','1',1,1,1,'1',1,'1','1','1','1'),(48,'1','1','1','1',1,1,1,'1',1,'1','1','1','1'),(65,'年会lcd','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,1,'Sun Jan 28 09:25:03 CST 2018',1,NULL,NULL,NULL,NULL),(66,'年会lcd','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,1,'Mon Jan 29 13:41:30 CST 2018',1,NULL,NULL,NULL,NULL),(70,'年会lcd','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,0,'Wed Jan 31 11:26:57 CST 2018',1,NULL,NULL,NULL,NULL),(71,'年会lcd','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,1,'Wed Jan 31 11:36:03 CST 2018',1,NULL,NULL,NULL,NULL),(73,'腊八八','11111.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,0,'Fri Feb 02 09:29:41 CST 2018',1,NULL,NULL,NULL,NULL);
