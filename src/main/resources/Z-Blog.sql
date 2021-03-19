CREATE DATABASE IF NOT EXISTS zblog DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `m_blog`;
CREATE TABLE `m_blog` (
      `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
      `user_id` bigint(40) NOT NULL DEFAULT '0' COMMENT '用户Id',
      `title` varchar(255) NOT NULL DEFAULT '' COMMENT '标题',
      `description` varchar(255) NOT NULL DEFAULT '' COMMENT '摘要',
      `content_id` bigint(40) NOT NULL DEFAULT '0' COMMENT '内容Id',
      `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
      `read_number` bigint(40) NOT NULL DEFAULT '0' COMMENT '阅读数',
      `like_number` bigint(40) NOT NULL DEFAULT '0' COMMENT '点赞数',
      `comment_number` bigint(40) NOT NULL DEFAULT '0' COMMENT '评论数',
      `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
      `comment_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '评论状态',
      PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8 COMMENT '博客信息';


CREATE TABLE `m_blog_content` (
      `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
      `content` longtext NOT NULL COMMENT '内容',
      `blog_id` bigint(40) NOT NULL DEFAULT '0' COMMENT '对应文章ID',
      PRIMARY KEY (`id`),
      UNIQUE KEY `blog_id` (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '博客内容';

-- ----------------------------
-- Records of m_blog
-- ----------------------------
INSERT INTO `m_blog`
VALUES ('2', '1', '真正理解Mysql的四种隔离级别@', '事务是应用程序中一系列严密的操作，所有操作必须成功完成，否则在每个操作中所作的所有更改都会被撤消。也就是事务具有原子性，一个事务中的一系列的操作要么全部成功，要么一个都不做。\n\n事务的结束有两种，当事务中的所以步骤全部成功执行时，事务提交。如果其中一个步骤失败，将发生回滚操作，撤消撤消之前到事务开始时的所以操作 ','2',now(),now(), '0','0','0','0','0');

INSERT INTO `m_blog_content` VALUES ('2', '### 什么是事务  \n\n> 事务是应用程序中一系列严密的操作，所有操作必须成功完成，否则在每个操作中所作的所有更改都会被撤消。也就是事务具有原子性，一个事务中的一系列的操作要么全部成功，要么一个都不做。\n> \n> 事务的结束有两种，当事务中的所以步骤全部成功执行时，事务提交。如果其中一个步骤失败，将发生回滚操作，撤消撤消之前到事务开始时的所以操作。\n\n**事务的 ACID**\n\n事务具有四个特征：原子性（ Atomicity ）、一致性（ Consistency ）、隔离性（ Isolation ）和持续性（ Durability ）。这四个特性简称为 ACID 特性。\n\n> 1 、原子性。事务是数据库的逻辑工作单位，事务中包含的各操作要么都做，要么都不做\n> \n> 2 、一致性。事 务执行的结果必须是使数据库从一个一致性状态变到另一个一致性状态。因此当数据库只包含成功事务提交的结果时，就说数据库处于一致性状态。如果数据库系统 运行中发生故障，有些事务尚未完成就被迫中断，这些未完成事务对数据库所做的修改有一部分已写入物理数据库，这时数据库就处于一种不正确的状态，或者说是 不一致的状态。', '2');

-- ----------------------------
-- Table structure for m_permission
-- ----------------------------
DROP TABLE IF EXISTS `m_permission`;
CREATE TABLE `m_permission`
(
    `id`  bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` varchar(50) NOT NULL DEFAULT '' COMMENT '权限名',
    `url`  varchar(200) DEFAULT NULL COMMENT '类型为页面时，代表前端路由地址，类型为按钮时，代表后端接口地址',
    `type`  tinyint(1) unsigned NOT NULL DEFAULT 1 COMMENT '权限类型，页面-1，按钮-2',
    `permission` varchar(50) NOT NULL DEFAULT '' COMMENT '权限表达式',
    `method` varchar(50) NOT NULL DEFAULT '' COMMENT '后端接口访问方式',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
    `parent_id` bigint(40)  NOT NULL DEFAULT 0 COMMENT '父级id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='权限表';

-- ----------------------------
-- Records of m_permission
-- ----------------------------
BEGIN;
INSERT INTO `m_permission`
VALUES (1072806379288399872, '测试页面', '/test', 1, 'page:test', '', 1, 0);
INSERT INTO `m_permission`
VALUES (1072806379313565696, '测试页面-查询', '/**/test', 2, 'btn:test:query', 'GET', 1, 1072806379288399872);
INSERT INTO `m_permission`
VALUES (1072806379330342912, '测试页面-添加', '/**/test', 2, 'btn:test:insert', 'POST', 2, 1072806379288399872);
INSERT INTO `m_permission`
VALUES (1072806379342925824, '监控在线用户页面', '/monitor', 1, 'page:monitor:online', '', 2, 0);
INSERT INTO `m_permission`
VALUES (1072806379363897344, '在线用户页面-查询', '/**/api/monitor/online/user', 2, 'btn:monitor:online:query', 'GET', 1,
        1072806379342925824);
INSERT INTO `m_permission`
VALUES (1072806379384868864, '在线用户页面-踢出', '/**/api/monitor/online/user/kickout', 2, 'btn:monitor:online:kickout',
        'DELETE', 2, 1072806379342925824);
COMMIT;

-- ----------------------------
-- Table structure for m_role
-- ----------------------------
DROP TABLE IF EXISTS `m_role`;
CREATE TABLE `m_role`
(
    `id` bigint(40)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名',
    `description` varchar(100) NOT NULL DEFAULT '' COMMENT '描述',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='角色表';

-- ----------------------------
-- Records of m_role
-- ----------------------------
BEGIN;
INSERT INTO `m_role`
VALUES (1072806379208708096, '管理员', '超级管理员', now(),now());
INSERT INTO `m_role`
VALUES (1072806379238068224, '普通用户', '普通用户', now(),now());
COMMIT;

-- ----------------------------
-- Table structure for m_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `m_role_permission`;
CREATE TABLE `m_role_permission`
(
    `role_id` bigint(40) NOT NULL COMMENT '角色主键',
    `permission_id` bigint(40) NOT NULL COMMENT '权限主键',
    PRIMARY KEY (`role_id`, `permission_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='角色权限关系表';

-- ----------------------------
-- Records of m_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `m_role_permission`
VALUES (1072806379208708096, 1072806379288399872);
INSERT INTO `m_role_permission`
VALUES (1072806379208708096, 1072806379313565696);
INSERT INTO `m_role_permission`
VALUES (1072806379208708096, 1072806379330342912);
INSERT INTO `m_role_permission`
VALUES (1072806379208708096, 1072806379342925824);
INSERT INTO `m_role_permission`
VALUES (1072806379208708096, 1072806379363897344);
INSERT INTO `m_role_permission`
VALUES (1072806379208708096, 1072806379384868864);
INSERT INTO `m_role_permission`
VALUES (1072806379238068224, 1072806379288399872);
INSERT INTO `m_role_permission`
VALUES (1072806379238068224, 1072806379313565696);
COMMIT;

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user`
(
    `id`          bigint(40)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username`    varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
    `password`    varchar(60) NOT NULL DEFAULT '' COMMENT '密码',
    `nickname`    varchar(255) NOT NULL DEFAULT '' COMMENT '昵称',
    `phone`       varchar(11) NOT NULL DEFAULT '' COMMENT '手机',
    `email`       varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
    `birthday`    bigint(13) NOT NULL DEFAULT 0 COMMENT '生日',
    `sex`         tinyint(1) unsigned NOT NULL DEFAULT 1 COMMENT '性别，男-1，女-2',
    `status`      tinyint(1) unsigned NOT NULL DEFAULT 1 COMMENT '状态，启用-1，禁用-0',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`),
    UNIQUE KEY `phone` (`phone`),
    UNIQUE KEY `email` (`email`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户表';

-- ----------------------------
-- Records of m_user
-- ----------------------------
BEGIN;
INSERT INTO `m_user`
VALUES (1072806377661009920, 'admin', '$2a$10$64iuSLkKNhpTN19jGHs7xePvFsub7ZCcCmBqEYw8fbACGTE3XetYq', '管理员',
        '17300000000', 'admin@xkcoding.com', 785433600000, 1, 1, now(),now());
INSERT INTO `m_user`
VALUES (1072806378780889088, 'user', '$2a$10$OUDl4thpcHfs7WZ1kMUOb.ZO5eD4QANW5E.cexBLiKDIzDNt87QbO', '普通用户',
        '17300001111', 'user@xkcoding.com', 785433600000, 1, 1, now(),now());
COMMIT;

-- ----------------------------
-- Table structure for m_user_role
-- ----------------------------
DROP TABLE IF EXISTS `m_user_role`;
CREATE TABLE `m_user_role`
(
    `user_id` bigint(64) NOT NULL DEFAULT 0 COMMENT '用户主键',
    `role_id` bigint(64) NOT NULL DEFAULT 0 COMMENT '角色主键',
    PRIMARY KEY (`user_id`, `role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户角色关系表';

-- ----------------------------
-- Records of m_user_role
-- ----------------------------
BEGIN;
INSERT INTO `m_user_role`
VALUES (1072806377661009920, 1072806379208708096);
INSERT INTO `m_user_role`
VALUES (1072806378780889088, 1072806379238068224);
COMMIT;

DROP TABLE IF EXISTS `m_login`;
CREATE TABLE `m_login` (
    `id` bigint(40) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id` bigint(40) NOT NULL DEFAULT 0 COMMENT '用户主键',
    `ip` varchar(20) NOT NULL DEFAULT '' COMMENT '操作地址的IP',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '第一次登陆时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近登陆时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uniq_userid` (`user_id`)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8 COMMENT ='用户登陆表';

DROP TABLE IF EXISTS `m_blog_visit`;
CREATE TABLE `m_blog_visit` (
    `id` bigint(40) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `ip` varchar(20) NOT NULL DEFAULT '' COMMENT '访问IP',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '第一次访问时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近访问时间',
    `blog_id` bigint(64)  NOT NULL DEFAULT 0 COMMENT '文章ID',
    PRIMARY KEY (`id`),
    index idx_blogId (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '文章阅读量表';

DROP TABLE IF EXISTS `m_comment`;
CREATE TABLE `m_comment` (
   `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
   `content` varchar(200) NOT NULL DEFAULT '' COMMENT '评论内容',
   `parent_id` bigint(40) NOT NULL DEFAULT 0 COMMENT '回复的评论ID',
   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
   `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
   `blog_id` bigint(40) NOT NULL DEFAULT 0 COMMENT '文章ID',
   `user_id` bigint(40) NOT NULL DEFAULT 0 COMMENT '用户ID',
   `status` tinyint(1) unsigned NOT NULL DEFAULT 1 COMMENT '是否有效，默认为1为有效，0为无效',
   `is_read`  tinyint(1) unsigned NOT NULL DEFAULT 1 COMMENT '是否已读，默认为0 未读，为1已读',
   PRIMARY KEY (`id`),
   index idx_blogId (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '文章评论表';

DROP TABLE IF EXISTS `m_label`;
CREATE TABLE `m_label` (
   `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
   `name` varchar(20) NOT NULL DEFAULT '' COMMENT '标签名称',
   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
   `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
   `status`  tinyint(1) unsigned NOT NULL DEFAULT 1 COMMENT '是否有效，默认为1有效，为0无效',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '标签表';

DROP TABLE IF EXISTS `m_blog_label`;
CREATE TABLE `m_blog_label`(
    `blog_id` bigint(40) NOT NULL DEFAULT 0 COMMENT '博客主键',
    `label_id` bigint(40) NOT NULL DEFAULT 0 COMMENT '标签主键',
    PRIMARY KEY (`blog_id`, `label_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT ='博客标签关系表';

DROP TABLE IF EXISTS `m_announcement`;
CREATE TABLE `m_announcement` (
   `id` int(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
   `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
   `title` varchar(255) NOT NULL DEFAULT '' COMMENT '标题' ,
   `detail` text NOT NULL COMMENT '详情',
   `status`  tinyint(1) unsigned NOT NULL DEFAULT 1 COMMENT '是否有效，默认为1有效，为0无效',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '系统通知表';

DROP TABLE IF EXISTS `m_user_announcement`;
CREATE TABLE `m_user_announcement`(
    `user_id` bigint(40) NOT NULL DEFAULT 0 COMMENT '用户主键',
    `announcement_id` bigint(40) NOT NULL DEFAULT 0 COMMENT '通知主键',
    `is_read`  tinyint(1) unsigned NOT NULL DEFAULT 1 COMMENT '是否已读，默认为0 未读，为1已读',
    PRIMARY KEY (`user_id`, `announcement_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT ='用户通知关系表';

DROP TABLE IF EXISTS `m_like`;
CREATE TABLE `m_like` (
     `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
     `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
     `blog_id` bigint(40) NOT NULL DEFAULT 0 COMMENT '文章ID',
     `user_id` bigint(40) NOT NULL DEFAULT 0 COMMENT '用户ID',
     `status` tinyint(1) unsigned NOT NULL DEFAULT 1 COMMENT '是否有效，默认为1为有效，0为无效',
     `is_read`  tinyint(1) unsigned NOT NULL DEFAULT 1 COMMENT '是否已读，默认为0 未读，为1已读',
     PRIMARY KEY (`id`),
     index idx_blogId (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '文章点赞';

SET FOREIGN_KEY_CHECKS = 1;


