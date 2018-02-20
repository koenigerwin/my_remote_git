

DROP TABLE IF EXISTS `menu_permission`;
CREATE TABLE `menu_permission` (
  `mp_id` int(11) NOT NULL AUTO_INCREMENT,
  `mp_pmsn_id` int(11) DEFAULT NULL COMMENT '权限id',
  `mp_menu_id` int(11) NOT NULL DEFAULT '0' COMMENT '菜单id',
  `mp_create_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `mp_create_datetime` varchar(50) NOT NULL DEFAULT '' COMMENT '创建日期',
  `mp_update_uid` int(11) NOT NULL DEFAULT '0' COMMENT '修改人id',
  `mp_updatetime` varchar(50) NOT NULL DEFAULT '' COMMENT '创建日期',
  `default1` varchar(20) DEFAULT NULL COMMENT '备用字段',
  `default2` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`mp_id`),
  KEY `fk_menu` (`mp_menu_id`),
  KEY `fk_permission` (`mp_pmsn_id`),
  CONSTRAINT `fk_menu` FOREIGN KEY (`mp_menu_id`) REFERENCES `menu` (`menu_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_permission` FOREIGN KEY (`mp_pmsn_id`) REFERENCES `permission` (`pmsn_id`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


INSERT INTO `menu_permission` VALUES (1,4,1,1,'2018-01-26 15:38:34',2,'2018-01-26 15:38:34',NULL,NULL),(2,5,1,1,'2018-01-26 15:38:34',3,'2018-01-26 15:38:34',NULL,NULL),(3,6,1,0,'0',0,'0',NULL,NULL),(4,7,1,0,'0',0,'0',NULL,NULL),(6,10,1,1,'2018-01-26 15:38:34',2,'2018-01-26 15:38:34',NULL,NULL);
