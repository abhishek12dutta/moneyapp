
insert into money_app_user (user_email,user_username,user_password,user_active_status,created_timestamp) values('abhishek12dutta@gmail.com','abhipicku','sasa',1,'2008-01-01 00:00:01');


CREATE TABLE `money_app_user_details` (
  `user_address_line1` varchar(255) NOT NULL,
  `user_address_line2` varchar(255) DEFAULT NULL,
  `user_country` varchar(255) NOT NULL,
  `user_phn_extension` int(11) NOT NULL,
  `user_phone_no` int(11) NOT NULL,
  `user_pincode` int(11) DEFAULT NULL,
  `user_user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_user_id`),
  CONSTRAINT `FKr209d0pt542vt43dihenicios` FOREIGN KEY (`user_user_id`) REFERENCES `money_app_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `money_app_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_timestamp` datetime DEFAULT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_active_status` tinyint(1) DEFAULT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


