DROP TABLE IF EXISTS `m_blog`;
CREATE TABLE `m_blog`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`     bigint(20)   NOT NULL COMMENT '用户Id',
    `title`       varchar(255) NOT NULL COMMENT '标题',
    `description` varchar(255) NOT NULL COMMENT '摘要',
    `content`     longtext COMMENT '内容',
    `create_time` datetime     NOT NULL COMMENT '创建时间',
    `update_time` datetime     NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `status`      tinyint(4) DEFAULT NULL COMMENT '状态',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 15
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Records of m_blog
-- ----------------------------
INSERT INTO `m_blog`
VALUES ('1', '1', '生活就像海洋，只有意志坚强的人才能到达彼岸', '这里是摘要哈哈哈', '内容？？？', '2020-05-21 22:08:42', '0');
INSERT INTO `m_blog`
VALUES ('2', '1', '最值得学习的博客项目',
        'blog是一个基于Springboot2.1.2开发的博客学习项目，为了让项目融合更多的知识点，达到学习目的，编写了详细的从0到1开发文档。主要学习包括：自定义Freemarker标签，使用shiro+redis完成了会话共享，redis的set结构完成本周热议排行榜，t-io+websocket完成即时消息通知和群聊，rabbitmq+elasticsearch完成博客内容搜索引擎等。值得学习的地方很多！',
        '**推荐阅读：**\r\n\r\n[分享一套SpringBoot开发博客系统源码，以及完整开发文档！速度保存！](https://mp.weixin.qq.com/s/jz6e977xP-OyaAKNjNca8w)\r\n\r\n[Github上最值得学习的100个Java开源项目，涵盖各种技术栈！](https://mp.weixin.qq.com/s/N-U0TaEUXnBFfBsmt_OESQ)\r\n\r\n[2020年最新的常问企业面试题大全以及答案](https://mp.weixin.qq.com/s/lR5LC5GnD2Gs59ecV5R0XA)',
        '2020-05-28 09:36:38', '0');
INSERT INTO `m_blog`
VALUES ('7', '1', '你真的会写单例模式吗?',
        '单例模式可能是代码最少的模式了，但是少不一定意味着简单，想要用好、用对单例模式，还真得费一番脑筋。本文对 Java 中常见的单例模式写法做了一个总结，如有错漏之处，恳请读者指正。',
        '> 作者：吃桔子的攻城狮 来源：http://www.tekbroaden.com/singleton-java.html\n\n\n单例模式可能是代码最少的模式了，但是少不一定意味着简单，想要用好、用对单例模式，还真得费一番脑筋。本文对 Java 中常见的单例模式写法做了一个总结，如有错漏之处，恳请读者指正。\n\n饿汉法\n===\n\n顾名思义，饿汉法就是在第一次引用该类的时候就创建对象实例，而不管实际是否需要创建。代码如下：\n\n```\npublic class Singleton {  \n    private static Singleton = new Singleton();\n    private Singleton() {}\n    public static getSingleton(){\n        return singleton;\n    }\n}\n\n```\n\n这样做的好处是编写简单，但是无法做到延迟创建对象。但是我们很多时候都希望对象可以尽可能地延迟加载，从而减小负载，所以就需要下面的懒汉法：\n',
        '2020-05-22 00:42:44', '0');
INSERT INTO `m_blog`
VALUES ('9', '1', '真正理解Mysql的四种隔离级别@',
        '事务是应用程序中一系列严密的操作，所有操作必须成功完成，否则在每个操作中所作的所有更改都会被撤消。也就是事务具有原子性，一个事务中的一系列的操作要么全部成功，要么一个都不做。\n\n事务的结束有两种，当事务中的所以步骤全部成功执行时，事务提交。如果其中一个步骤失败，将发生回滚操作，撤消撤消之前到事务开始时的所以操作。',
        '### 什么是事务  \n\n> 事务是应用程序中一系列严密的操作，所有操作必须成功完成，否则在每个操作中所作的所有更改都会被撤消。也就是事务具有原子性，一个事务中的一系列的操作要么全部成功，要么一个都不做。\n> \n> 事务的结束有两种，当事务中的所以步骤全部成功执行时，事务提交。如果其中一个步骤失败，将发生回滚操作，撤消撤消之前到事务开始时的所以操作。\n\n**事务的 ACID**\n\n事务具有四个特征：原子性（ Atomicity ）、一致性（ Consistency ）、隔离性（ Isolation ）和持续性（ Durability ）。这四个特性简称为 ACID 特性。\n\n> 1 、原子性。事务是数据库的逻辑工作单位，事务中包含的各操作要么都做，要么都不做\n> \n> 2 、一致性。事 务执行的结果必须是使数据库从一个一致性状态变到另一个一致性状态。因此当数据库只包含成功事务提交的结果时，就说数据库处于一致性状态。如果数据库系统 运行中发生故障，有些事务尚未完成就被迫中断，这些未完成事务对数据库所做的修改有一部分已写入物理数据库，这时数据库就处于一种不正确的状态，或者说是 不一致的状态。',
        '2020-05-22 22:04:46', '0');

-- ----------------------------
-- Table structure for m_permission
-- ----------------------------
DROP TABLE IF EXISTS `m_permission`;
CREATE TABLE `m_permission`
(
    `id`         bigint(64)  NOT NULL COMMENT '主键',
    `name`       varchar(50) NOT NULL COMMENT '权限名',
    `url`        varchar(1000) DEFAULT NULL COMMENT '类型为页面时，代表前端路由地址，类型为按钮时，代表后端接口地址',
    `type`       int(2)      NOT NULL COMMENT '权限类型，页面-1，按钮-2',
    `permission` varchar(50)   DEFAULT NULL COMMENT '权限表达式',
    `method`     varchar(50)   DEFAULT NULL COMMENT '后端接口访问方式',
    `sort`       int(11)     NOT NULL COMMENT '排序',
    `parent_id`  bigint(64)  NOT NULL COMMENT '父级id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='权限表';

-- ----------------------------
-- Records of m_permission
-- ----------------------------
BEGIN;
INSERT INTO `m_permission`
VALUES (1072806379288399872, '测试页面', '/test', 1, 'page:test', NULL, 1, 0);
INSERT INTO `m_permission`
VALUES (1072806379313565696, '测试页面-查询', '/**/test', 2, 'btn:test:query', 'GET', 1, 1072806379288399872);
INSERT INTO `m_permission`
VALUES (1072806379330342912, '测试页面-添加', '/**/test', 2, 'btn:test:insert', 'POST', 2, 1072806379288399872);
INSERT INTO `m_permission`
VALUES (1072806379342925824, '监控在线用户页面', '/monitor', 1, 'page:monitor:online', NULL, 2, 0);
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
    `id`          bigint(64)  NOT NULL COMMENT '主键',
    `name`        varchar(50) NOT NULL COMMENT '角色名',
    `description` varchar(100) DEFAULT NULL COMMENT '描述',
    `create_time` datetime    NOT NULL COMMENT '创建时间',
    `update_time` datetime    NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='角色表';

-- ----------------------------
-- Records of m_role
-- ----------------------------
BEGIN;
INSERT INTO `m_role`
VALUES (1072806379208708096, '管理员', '超级管理员', 1544611947239, 1544611947239);
INSERT INTO `m_role`
VALUES (1072806379238068224, '普通用户', '普通用户', 1544611947246, 1544611947246);
COMMIT;

-- ----------------------------
-- Table structure for m_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `m_role_permission`;
CREATE TABLE `m_role_permission`
(
    `role_id`       bigint(64) NOT NULL COMMENT '角色主键',
    `permission_id` bigint(64) NOT NULL COMMENT '权限主键',
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
    `id`          bigint(64)  NOT NULL COMMENT '主键',
    `username`    varchar(50) NOT NULL COMMENT '用户名',
    `password`    varchar(60) NOT NULL COMMENT '密码',
    `nickname`    varchar(255)         DEFAULT NULL COMMENT '昵称',
    `phone`       varchar(11)          DEFAULT NULL COMMENT '手机',
    `email`       varchar(50)          DEFAULT NULL COMMENT '邮箱',
    `birthday`    bigint(13)           DEFAULT NULL COMMENT '生日',
    `sex`         int(2)               DEFAULT NULL COMMENT '性别，男-1，女-2',
    `status`      int(2)      NOT NULL DEFAULT '1' COMMENT '状态，启用-1，禁用-0',
    `create_time` datetime    NOT NULL COMMENT '创建时间',
    `update_time` datetime    NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
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
        '17300000000', 'admin@xkcoding.com', 785433600000, 1, 1, 1544611947032, 1544611947032);
INSERT INTO `m_user`
VALUES (1072806378780889088, 'user', '$2a$10$OUDl4thpcHfs7WZ1kMUOb.ZO5eD4QANW5E.cexBLiKDIzDNt87QbO', '普通用户',
        '17300001111', 'user@xkcoding.com', 785433600000, 1, 1, 1544611947234, 1544611947234);
COMMIT;

-- ----------------------------
-- Table structure for m_user_role
-- ----------------------------
DROP TABLE IF EXISTS `m_user_role`;
CREATE TABLE `m_user_role`
(
    `user_id` bigint(64) NOT NULL COMMENT '用户主键',
    `role_id` bigint(64) NOT NULL COMMENT '角色主键',
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

SET FOREIGN_KEY_CHECKS = 1;


