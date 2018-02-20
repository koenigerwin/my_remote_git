/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.27 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `userinfo_log` (
	`USER_LOG_ID` double ,
	`USER_LOG_CONTENT` varchar (3000),
	`USER_LOG_OPERATOR` varchar (150),
	`USER_LOG_OPERATOR_DATETIME` datetime ,
	`USER_LOG_OPERATION` varchar (150),
	`IS_SUCCESS` tinyint (1)
); 
insert into `userinfo_log` (`USER_LOG_ID`, `USER_LOG_CONTENT`, `USER_LOG_OPERATOR`, `USER_LOG_OPERATOR_DATETIME`, `USER_LOG_OPERATION`, `IS_SUCCESS`) values('1','insert  xxxx','刘龙龙','2017-12-28 17:25:11','新增用户','1');
insert into `userinfo_log` (`USER_LOG_ID`, `USER_LOG_CONTENT`, `USER_LOG_OPERATOR`, `USER_LOG_OPERATOR_DATETIME`, `USER_LOG_OPERATION`, `IS_SUCCESS`) values('2','insert UserInfo {user_id=null, user_logon=123ssa, user_password=null, user_name=null, user_gender=null, user_mobile=null, user_email=4933171401@qq.com, user_phone=null, user_level=null, user_descritpion=null, user_status=null, user_birth=null, user_weixin=null, user_icon=null, user_created_datetime=null, user_created_name=2017-08-12 2:7:3, user_updated_datetime=null, user_updated_name=null, user_default1=null, user_default2=null, user_role_id=null, role_name=null}','刘龙龙','2017-12-29 11:03:45','title：新增用户','1');
insert into `userinfo_log` (`USER_LOG_ID`, `USER_LOG_CONTENT`, `USER_LOG_OPERATOR`, `USER_LOG_OPERATOR_DATETIME`, `USER_LOG_OPERATION`, `IS_SUCCESS`) values('3','deleteUserInfo {user_id=1, user_logon=fffsssa, user_password=null, user_name=null, user_gender=null, user_mobile=null, user_email=4933171401@qq.com, user_phone=null, user_level=null, user_descritpion=null, user_status=null, user_birth=null, user_weixin=null, user_icon=null, user_created_datetime=null, user_created_name=null, user_updated_datetime=null, user_updated_name=null, user_default1=null, user_default2=null, user_role_id=null, role_name=null}','刘s龙a','2017-12-29 11:09:34','title：删除用户','1');
insert into `userinfo_log` (`USER_LOG_ID`, `USER_LOG_CONTENT`, `USER_LOG_OPERATOR`, `USER_LOG_OPERATOR_DATETIME`, `USER_LOG_OPERATION`, `IS_SUCCESS`) values('4','update UserInfo}','刘a龙s龙','2017-12-29 11:30:21','title：更新用户','1');
insert into `userinfo_log` (`USER_LOG_ID`, `USER_LOG_CONTENT`, `USER_LOG_OPERATOR`, `USER_LOG_OPERATOR_DATETIME`, `USER_LOG_OPERATION`, `IS_SUCCESS`) values('5','update UserInfo{userName:vvvasss}','刘a龙s龙','2017-12-29 11:33:43','title：更新用户','1');
insert into `userinfo_log` (`USER_LOG_ID`, `USER_LOG_CONTENT`, `USER_LOG_OPERATOR`, `USER_LOG_OPERATOR_DATETIME`, `USER_LOG_OPERATION`, `IS_SUCCESS`) values('6','update UserInfo{userName:(source:hhhvvssa;target:vvvasss),userBirth:(source:;target:2017-08-12 02:07:43)}','刘a龙s龙','2017-12-29 11:44:53','title：更新用户','1');
insert into `userinfo_log` (`USER_LOG_ID`, `USER_LOG_CONTENT`, `USER_LOG_OPERATOR`, `USER_LOG_OPERATOR_DATETIME`, `USER_LOG_OPERATION`, `IS_SUCCESS`) values('7','deleteUserInfo {user_id=1, user_logon=fffsssa, user_password=, user_name=, user_gender=, user_mobile=, user_email=4933171401@qq.com, user_phone=, user_level=, user_descritpion=, user_status=, user_birth=, user_weixin=, user_icon=, user_created_datetime=, user_created_name=, user_updated_datetime=, user_updated_name=, user_default1=, user_default2=, user_role_id=0, role_name=}','刘s龙a','2017-12-29 15:42:45','title：删除用户','1');
