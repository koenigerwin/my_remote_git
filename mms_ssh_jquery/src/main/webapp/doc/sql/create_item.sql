
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `items_id` int(11) NOT NULL COMMENT '功能id',
  `items_name` varchar(50) NOT NULL DEFAULT '' COMMENT '功能名',
  `pmsn_id` int(11) DEFAULT NULL COMMENT '权限id',
  `items_pmsn_url` varchar(200) DEFAULT NULL COMMENT '菜单的功能url',
  `is_delete` int(11) NOT NULL DEFAULT '0' COMMENT '逻辑删除 0删除 1未删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='具体功能菜单';


INSERT INTO `item` VALUES (1,'全部预定',1,'addMethod()1',1),(1,'我的预定',2,'deleteMethod()1',1);
