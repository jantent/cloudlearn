CREATE DATABASE IF NOT EXISTS cloud
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;

USE cloud;

-- 用户表
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
  uid           INT AUTO_INCREMENT
  COMMENT '用户自增ID',
  user_name     VARCHAR(100)                        NOT NULL
  COMMENT '姓名',
  account       VARCHAR(128)                        NOT NULL
  COMMENT '用户名',
  sex           INTEGER                             NOT NULL
  COMMENT '性别',
  phone_number  VARCHAR(22)                         NOT NULL
  COMMENT '电话号码',
  user_password VARCHAR(100)                        NOT NULL
  COMMENT '密码',
  email         VARCHAR(64)                         NOT NULL
  COMMENT '电子邮件',
  created_time  TIMESTAMP DEFAULT current_timestamp NOT NULL
  COMMENT '创建时间',
  modified_time TIMESTAMP COMMENT '修改时间',

  PRIMARY KEY (uid)
);

-- 操作日志表
DROP TABLE IF EXISTS t_log;
CREATE TABLE t_log (
  id        INT AUTO_INCREMENT
  COMMENT '自增ID',
  client_ip VARCHAR(64)    COMMENT '客户端IP',
  who       INTEGER        COMMENT '人员',
  log_when      TIMESTAMP      COMMENT '时间',
  action    VARCHAR(128)   COMMENT '操作',
  detail    VARCHAR(2048)  COMMENT '详情',
  result    INTEGER        COMMENT '结果,1成功，0失败',

  PRIMARY KEY (id)
);

-- 管理员表
DROP TABLE IF EXISTS t_admin;
CREATE TABLE t_admin (
  id           INT AUTO_INCREMENT
  COMMENT '自增ID',
  username     VARCHAR(32) COMMENT '用户名',
  password     VARCHAR(64) COMMENT '密码',
  email        VARCHAR(64)                         NOT NULL
  COMMENT '电子邮件',
  created_time TIMESTAMP DEFAULT current_timestamp NOT NULL
  COMMENT '创建时间',

  PRIMARY KEY (id)
);

INSERT INTO t_admin(username, password, email) VALUES ('admin','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','jantent@foxmail.com');