show databases;

CREATE DATABASE nemo CHARACTER SET utf8 COLLATE utf8_general_ci;

use nemo;

CREATE TABLE `user` (
    `id`  int(11) NOT NULL AUTO_INCREMENT,
    `name`  varchar(255) NOT NULL ,
    `address`  text NULL ,
    `email`  text NULL ,
    PRIMARY KEY (`id`)
);


select * from user;
