

drop table  if exists menu;
create table menu(
	menu_id integer(11)  primary key auto_increment  comment '菜单编号'  ,
	menu_name varchar(50) not null unique  comment '菜单名称',
	menu_url varchar(100) not null unique comment '菜单url',
	menu_icon varchar(30)  comment '菜单图标',
	menu_parent integer(10)   default null comment '菜单父级菜单',
	menu_description varchar(200)   comment '菜单描述',
	menu_sort_id varchar(100) unique  comment '菜单排序号',
	menu_nlevel integer(11)    comment '菜单层级',
	menu_is_enable char(2)  not null default '1' comment '菜单状态 0-未激活状态 1-已激活状态 2-已经删除 3-未审核通过',
	menu_created_datetime date  not null  comment '创建时间',
	menu_created_name varchar(50)  not null  comment '修改人名',
	menu_updated_datetime date  not null  comment '最近一次修改时间',
	menu_updated_name varchar(50)  not null  comment '最近一次修改人名',
	menu_default1 varchar(10)   comment '填充字段',
	menu_default2 varchar(10)   comment '填充字段'
	
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
INSERT INTO `menu` VALUES (0,'2018-01-31 20:31:21',1,NULL,NULL,'系统管理','1.ico','系统管理',0,NULL,',0','1','2018-01-31 20:31:21',1,'../welcome.htm','1'),(1,'2018-01-31 20:31:21',1,'',NULL,'用户模版','2.ico','用户界面',1,'0',',0,1','1','2018-02-21 14:23:26',1,'../user/userMain','2'),(2,'2018-01-31 20:31:21',2,NULL,NULL,'用户登录','3.ico','用户登录',2,'1',',0,1,2','1','2018-01-31 20:31:21',1,'../role/role_list','1'),(3,'2018-01-31 20:31:21',2,NULL,NULL,'用户登录2','4.ico','用户登录2',3,'2',',0,1,2,3','1','2018-01-31 20:31:21',1,'user_index.jsp','1'),(4,'2018-01-31 20:31:21',3,NULL,NULL,'用户注销','5.ico','用户注销',2,'1',',0,1,4','1','2018-01-31 20:31:21',1,'ser.jsp','2'),(5,'2018-01-31 20:31:21',4,NULL,NULL,'菜单信息','1.ico','菜单信息',1,'0',',0,5','1','2018-02-21 14:23:26',1,'../menu/queryAll','3'),(6,'2018-01-31 20:31:21',1,NULL,NULL,'we','1.ico','ew',2,'5',',0,5,6','1','2018-01-31 20:31:21',1,'we','1'),(7,'2018-01-31 20:31:21',1,NULL,NULL,'desceww','1.ico','测试2',2,'5',',0,5,7','1','2018-01-31 20:31:21',1,'../sm/position/getPositionsForward','3'),(8,'2018-01-31 20:31:21',1,NULL,NULL,'weew','1.ico','测试3',2,'5',',0,5,8','1','2018-01-31 20:31:21',1,'../sm/wew','2'),(9,'2018-02-21 14:23:26',1,NULL,NULL,'','1.ico','权限管理',1,'0',',0,9','1','2018-02-21 14:23:26',1,'','1'),(10,'2018-02-21 14:23:26',1,NULL,NULL,'','1.ico','权限信息',2,'9',',0,9,10','1','2018-02-21 14:23:26',1,'/clps_mms/sm/grantview/showAllPmsn','-1'),(11,'2018-02-21 14:23:26',1,NULL,NULL,'','1.ico','授权信息',2,'9',',0,9,11','1','2018-02-21 14:23:26',1,'/clps_mms/sm/grantview/showRoleMenuPmsn','-1');


drop table  if exists menu_log;
create table menu_log(
	menu_log_id integer(11)  primary key auto_increment  comment '日志编号'  ,
	menu_log_content varchar(1000) not null  comment '日志内容',
	menu_log_operator varchar(50) not null comment '操作人名',
	menu_log_operator_datetime date not null  comment '操作时间',
	menu_log_operation varchar(10) not null comment '动作名称'
)
