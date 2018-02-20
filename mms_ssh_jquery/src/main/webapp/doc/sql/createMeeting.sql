# Host: localhost  (Version: 5.5.15)
# Date: 2018-01-12 17:22:17
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "meeting"
#

DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting` (
  `meeting_id` int(11) NOT NULL AUTO_INCREMENT,
  `meeting_title` varchar(50) NOT NULL DEFAULT '' COMMENT '会议标题',
  `meeting_user_ids` varchar(200) NOT NULL DEFAULT '' COMMENT '会议参与者',
  `meeting_content` varchar(1000) DEFAULT NULL COMMENT '会议内容',
  `meeting_begintime` varchar(50) NOT NULL DEFAULT '' COMMENT '会议开始时间',
  `meeting_endtime` varchar(50) NOT NULL DEFAULT '' COMMENT '会议结束时间',
  `meeting_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '会议负责人',
  `meeting_room_id` int(11) NOT NULL DEFAULT '0' COMMENT '所在会议室',
  `meeting_is_enable` char(2) NOT NULL DEFAULT '1' COMMENT '是否删除',
  `meeting_success` char(2) NOT NULL DEFAULT '0' COMMENT '是否预订成功',
  `meeting_status` char(2) NOT NULL DEFAULT '1' COMMENT '会议状态',
  `meeting_create_datetime` varchar(50) NOT NULL DEFAULT '' COMMENT '创建时间',
  `meeting_create_name` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人名',
  `meeting_update_datetime` varchar(50) NOT NULL DEFAULT '' COMMENT '修改时间',
  `meeting_update_name` varchar(50) NOT NULL DEFAULT '' COMMENT '修改人名',
  `meeting_default1` varchar(50) NOT NULL DEFAULT '' COMMENT '默认字段1',
  `meeting_default2` varchar(50) NOT NULL DEFAULT '' COMMENT '默认字段2',
  PRIMARY KEY (`meeting_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "meeting"
#

INSERT INTO `meeting` VALUES (1,'年会','001;002;003','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,'1','0','1','Fri Jan 12 17:16:56 CST 2018','xx','2018-01-10 12:20:34','2','',''),(2,'年会','001;002;003','年','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,'1','0','1','Fri Jan 12 17:17:57 CST 2018','xx','','','',''),(3,'年会','001;002;003','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,'1','0','1','Fri Jan 12 17:06:35 CST 2018','xx','','','',''),(4,'年会','001;002;003','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,'1','0','1','Fri Jan 12 17:16:56 CST 2018','xx','','','',''),(5,'年会','001;002;003','年会.....','2017-12-23 23:34:12','2017-12-23 23:34:12',2,1,'1','0','1','Fri Jan 12 17:17:57 CST 2018','xx','','','','');
