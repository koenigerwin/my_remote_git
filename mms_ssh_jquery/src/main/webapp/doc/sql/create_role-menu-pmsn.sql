DROP TABLE IF EXISTS `role_menu_pmsn`;
CREATE TABLE `role_menu_pmsn` (
  `rmp_Id` int(11) NOT NULL AUTO_INCREMENT,
  `rmp_mp_id` int(11) NOT NULL DEFAULT '0' COMMENT '菜单权限关系id',
  `rmp_role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色id',
  `rmp_create_uid` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `rmp_create_datetime` varchar(255) NOT NULL DEFAULT '系统当前时间' COMMENT '创建时间',
  `rmp_uim_id` int(11) NOT NULL DEFAULT '0' COMMENT '操作人id',
  `rmp_updatetime` varchar(255) NOT NULL DEFAULT '' COMMENT '修改时间',
  `default1` varchar(50) DEFAULT NULL COMMENT '备用字段',
  `default2` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`rmp_Id`),
  KEY `FK_ggurt2xepd9imf8uriukithmb` (`rmp_mp_id`),
  KEY `FK_prc5pcisnk9rabeahhx2w47n0` (`rmp_role_id`),
  CONSTRAINT `fk_role` FOREIGN KEY (`rmp_role_id`) REFERENCES `role` (`ROLE_ID`) ON DELETE CASCADE,
  CONSTRAINT `pk_menu_permission` FOREIGN KEY (`rmp_mp_id`) REFERENCES `menu_permission` (`mp_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='角色-菜单-权限关系表';

INSERT INTO `role_menu_pmsn` VALUES (3,1,7,0,'2018-01-17 13:15:15',3,'2018-01-26 17:51:42',NULL,NULL),(6,2,7,0,'2018-01-26 17:51:42',2,'2018-01-26 17:51:42',NULL,NULL),(11,3,1,0,'2018-01-25 11:44:03',9,'2018-01-26 17:51:42',NULL,NULL),(20,2,1,0,'2018-01-26 01:15:44',77,'2018-01-26 17:51:42',NULL,NULL);