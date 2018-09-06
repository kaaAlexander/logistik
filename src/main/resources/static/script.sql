   insert into `user` (`user_id`,`company_name`,`email`,`first_name`,`password`,`phone_number`,`role`,`second_name`,`third_name`,`unp`)
   values (1,'admin','admin','admin','$2a$06$ghanMsZ.hslEuE6b0BdBzupOKtoQsghnYe5FTZixau07.4dL1QSMa','admin','ROLE_ADMIN','admin','admin','unp');
     insert into `user` (`user_id`,`company_name`,`email`,`first_name`,`phone_number`,`role`,
     `second_name`,`third_name`,`unp`)
     values (2,'Roga I kopita','kaa.alexander@tut.by','Alex','+3752911111111','USER_ROLE','Alex','Alex','unp');
     insert into `user` (`user_id`,`company_name`,`email`,`first_name`,`phone_number`,`role`,
     `second_name`,`third_name`,`unp`)
     values (3,'Good Deal','levic.vlad@mail.ru','Vlad','+3752911111111','USER_ROLE','Alex','Alex','unp');

     ALTER TABLE country CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
     ALTER TABLE  province CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
     ALTER TABLE exit_point CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
     ALTER TABLE customer_service CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
     ALTER TABLE user CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;