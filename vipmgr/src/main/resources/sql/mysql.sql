CREATE DATABASE IF NOT EXISTS cloud default character set utf8 collate utf8_general_ci;

USE cloud;


DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user(
  uid INT AUTO_INCREMENT COMMENT '用户自增ID',
  user_name VARCHAR(100) NOT NULL COMMENT '姓名' ,
  account VARCHAR(128) NOT NULL COMMENT '用户名',
  sex INTEGER NOT NULL COMMENT '性别' ,
  phone_number VARCHAR(22) NOT NULL COMMENT '电话号码',
  user_password VARCHAR(100)  NOT NULL COMMENT '密码',
  email VARCHAR(64) NOT NULL COMMENT '电子邮件',
  created_time TIMESTAMP DEFAULT current_timestamp NOT NULL COMMENT '创建时间',
  modified_time TIMESTAMP COMMENT '修改时间',

  PRIMARY KEY (uid)
);