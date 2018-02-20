/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.27 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `roleinfo_log` (
	`ROLE_LOG_ID` double ,
	`ROLE_LOG_CONTENT` varchar (3000),
	`ROLE_LOG_OPERATOR` varchar (150),
	`ROLE_LOG_OPERATOR_DATETIME` datetime ,
	`ROLE_LOG_OPERATION` varchar (150),
	`IS_SUCCESS` tinyint (1)
); 
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('2','insert Role {roleId=1, roleName=管理员, roleDecription=, roleIcon=, roleIsEnable=}','刘龙龙','2017-12-29 15:20:01','title：新增用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('3','','刘s龙a','2017-12-29 15:22:13','title：删除用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('4','','刘s龙a','2017-12-29 15:26:25','title：删除用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('5','update Role}','刘a龙s龙','2017-12-29 15:28:39','title：更新用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('6','','刘s龙a','2017-12-29 15:31:11','title：删除用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('7','','刘s龙a','2017-12-29 15:32:12','title：删除用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('8','','刘s龙a','2017-12-29 15:33:02','title：删除用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('9','','刘s龙a','2017-12-29 15:37:35','title：删除用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('10','','刘s龙a','2017-12-29 15:38:30','title：删除用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('11','insert Role {roleName=管理员, roleDecription=, roleIcon=, roleIsEnable=, RoleCreatedDatetime=, roleUpdatedDatetime=, roleDefault1=, roleDefault2=}','刘龙龙','2017-12-29 15:38:30','title：新增用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('12','update Role}','刘a龙s龙','2017-12-29 15:38:30','title：更新用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('13','','刘s龙a','2017-12-29 15:38:46','title：删除用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('14','','刘s龙a','2017-12-29 15:39:47','title：删除用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('15','','刘s龙a','2017-12-29 15:41:38','title：删除用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('16','insert Role {roleName=管理员, roleDecription=, roleIcon=, roleIsEnable=, RoleCreatedDatetime=, roleUpdatedDatetime=, roleDefault1=, roleDefault2=}','刘龙龙','2017-12-29 15:41:38','title：新增用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('17','update Role}','刘a龙s龙','2017-12-29 15:41:38','title：更新用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('18','','刘s龙a','2017-12-29 15:41:54','title：删除用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('19','','刘s龙a','2017-12-29 15:44:43','title：删除用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('20','deleteRole {roleName=管理员, roleDecription=, roleIcon=D:/图片, roleIsEnable=, RoleCreatedDatetime=2017-12-29 12:33:33, roleUpdatedDatetime=, roleDefault1=, roleDefault2=}','刘s龙a','2017-12-29 15:45:20','title：删除用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('21','update Role{','刘a龙s龙','2017-12-29 15:46:30','title：更新用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('22','update Role{','刘a龙s龙','2017-12-29 15:48:00','title：更新用户','1');
insert into `roleinfo_log` (`ROLE_LOG_ID`, `ROLE_LOG_CONTENT`, `ROLE_LOG_OPERATOR`, `ROLE_LOG_OPERATOR_DATETIME`, `ROLE_LOG_OPERATION`, `IS_SUCCESS`) values('23','update Role{roleName:(source:管理员;target:用2户),roleIcon:(source:D:/图片;target:),RoleCreatedDatetime:(source:2017-12-29 12:33:33;target:)}','刘a龙s龙','2017-12-29 15:51:26','title：更新用户','1');
