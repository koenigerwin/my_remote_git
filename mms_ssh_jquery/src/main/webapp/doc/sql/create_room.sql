# Host: localhost  (Version: 5.5.15)
# Date: 2018-01-16 17:48:29
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "room"
#

DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` int(10) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(20) NOT NULL DEFAULT '' COMMENT '会议室名称',
  `room_size` int(10) NOT NULL DEFAULT '' COMMENT ' 会议室人数',
  `room_is_enable` varchar(2) NOT NULL DEFAULT '' COMMENT '会议室状态',
  `room_discribtion` varchar(200) DEFAULT NULL COMMENT '会议室描述',
  `room_create_time` varchar(50) NOT NULL DEFAULT '' COMMENT '创建时间',
  `room_create_name` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人名称',
  `room_update_time` varchar(50) NOT NULL DEFAULT '' COMMENT '修改时间',
  `room_update_name` varchar(50) NOT NULL DEFAULT '' COMMENT '修改任命',
  `room_location` varchar(50) NOT NULL DEFAULT '' COMMENT '会议室地址'
  `room_default1` varchar(50) NOT NULL DEFAULT '' COMMENT '默认字段1',
  `room_default2` varchar(50) NOT NULL DEFAULT '' COMMENT '默认字段2',
  
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;





