
DROP TABLE IF EXISTS `userinfo_main`;
CREATE TABLE `userinfo_main` (
  `user_id` int(11) NOT NULL,
  `user_created_datetime` varchar(50) NOT NULL,
  `user_created_name` int(11) NOT NULL,
  `user_email` varchar(30) NOT NULL,
  `user_isEnable` varchar(10) DEFAULT NULL,
  `user_logon` varchar(30) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_status` int(11) NOT NULL,
  `user_dept_id` int(11) DEFAULT NULL,
  `user_per_id` int(11) DEFAULT NULL,
  `user_role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_qkusn643lqm2b2otj3ipuk9rs` (`user_email`),
  UNIQUE KEY `UK_sqo4guq3ecw4hy8597uxiuhnb` (`user_logon`),
  KEY `FK_7p53j8lbacfuh8nmpr9l9jpj4` (`user_dept_id`),
  KEY `FK_lrrcqh6ns84338a3sisg43lnp` (`user_role_id`),
  CONSTRAINT `FK_7p53j8lbacfuh8nmpr9l9jpj4` FOREIGN KEY (`user_dept_id`) REFERENCES `department` (`dept_id`),
  CONSTRAINT `FK_lrrcqh6ns84338a3sisg43lnp` FOREIGN KEY (`user_role_id`) REFERENCES `role` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `userinfo_main` VALUES (1,'1',1,'1','1','1','yx','123',1,NULL,NULL,NULL),(9,'2',2,'2','1','2','superTz','1212',1,NULL,NULL,NULL);
