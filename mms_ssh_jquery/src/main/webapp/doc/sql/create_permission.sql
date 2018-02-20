

RODP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `pmsn_id` int(11) NOT NULL AUTO_INCREMENT,
  `pmsn_name` varchar(50) NOT NULL DEFAULT '无' COMMENT '子功能名字',
  `pmsn_description` varchar(200) DEFAULT NULL COMMENT '权限的描述',
  `pmsn_url` varchar(50) DEFAULT NULL COMMENT 'url地址',
  `pmsn_create_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `pmsn_create_datetime` varchar(50) NOT NULL DEFAULT '系统当前时间' COMMENT '权限创建时间',
  `pmsn_uim_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `pmsn_updatetime` varchar(50) NOT NULL DEFAULT '' COMMENT '修改时间',
  `default1` varchar(50) DEFAULT NULL COMMENT '备用字段',
  `default2` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`pmsn_id`) COMMENT '主键'
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='子菜单项目';

INSERT INTO `permission` VALUES (4,'查询',NULL,NULL,1,'2018-01-24 15:38:34',1,'2018-01-24 15:38:34',NULL,NULL),(5,'修改',NULL,NULL,1,'2018-01-24 15:38:34',1,'2018-01-24 15:38:34',NULL,NULL),(6,'测试修改','测试修改',NULL,0,'2018-01-24 15:16:19',2,'2018-01-24 15:38:34',NULL,NULL),(7,'测试2','这是一条测试数据',NULL,0,'2018-01-25 00:26:00',9,'1',NULL,NULL),(10,'测试5',NULL,NULL,0,'2018-01-26 01:01:03',33,'2018-01-26 01:29:03',NULL,NULL),(12,'测试3',NULL,NULL,0,'2018-01-26 10:14:09',2,'2018-01-26 10:14:09',NULL,NULL),(13,'测试2','这是一条测试数据',NULL,0,'2018-01-26 14:06:53',9,'2018-01-26 14:06:53',NULL,NULL),(14,'测试2','这是一条测试数据',NULL,0,'2018-01-26 14:08:48',9,'2018-01-26 14:08:48',NULL,NULL),(15,'测试2','这是一条测试数据',NULL,0,'2018-01-26 14:09:43',9,'2018-01-26 14:09:43',NULL,NULL);
