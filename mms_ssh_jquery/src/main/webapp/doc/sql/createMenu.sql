

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


drop table  if exists menu_log;
create table menu_log(
	menu_log_id integer(11)  primary key auto_increment  comment '日志编号'  ,
	menu_log_content varchar(1000) not null  comment '日志内容',
	menu_log_operator varchar(50) not null comment '操作人名',
	menu_log_operator_datetime date not null  comment '操作时间',
	menu_log_operation varchar(10) not null comment '动作名称'
)
