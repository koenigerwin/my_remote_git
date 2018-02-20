/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.1.36-community 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `userinfo` (
	`user_id` int (11),
	`user_logon` varchar (90),
	`user_password` varchar (150),
	`user_name` varchar (150),
	`user_gender` char (45),
	`user_mobile` varchar (45),
	`user_email` varchar (90),
	`user_phone` varchar (90),
	`user_level` char (6),
	`user_descritpion` varchar (600),
	`user_status` int (10),
	`user_birth` varchar (600),
	`user_weixin` varchar (90),
	`user_icon` varchar (150),
	`user_created_datetime` varchar (150),
	`user_created_name` varchar (150),
	`user_updated_datetime` varchar (600),
	`user_updated_name` varchar (150),
	`user_default1` varchar (150),
	`user_default2` varchar (150),
	`user_role_id` int (10)
); 

