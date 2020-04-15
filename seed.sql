
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE if exists 'user';
create table user
(
    id         int auto_increment comment '主键id'
        primary key,
    account    varchar(45)   null comment '账号',
    password   varchar(200)  null comment '密码',
    name       varchar(255)  null comment '用户昵称',
    sex        int default 0 null comment '性别（1：男 2：女）',
    email      varchar(45)   null comment '电子邮件',
    phone      varchar(45)   null comment '电话',
    roleid     int           null comment '角色id',
    status     int default 0 null comment '状态(1：启用  2：冻结）',
    deleted    int default 0 null comment '是否被删除',
    createtime datetime      null comment '创建时间',
    version    int default 0 null comment '保留字段',
    constraint user_email_uindex
        unique (email)
)
    comment '用户表' ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ;

INSERT INTO user (id, account, password, name, sex, email, phone, roleid, status, deleted, createtime, version) VALUES (1, 'admin', 'admin', 'admin', 1, '111111@163.com', '123456789', 1, 1, 0, '2020-04-15 22:29:05', 0);

DROP TABLE if exists 'user_role';

create table user_role
(
    id         int auto_increment comment '主键id'
        primary key,
    roleid     int           null comment '序号',
    name       varchar(255)  null comment '角色名称',
    permission varchar(255)  null comment '用户权限',
    tips       varchar(255)  null comment '提示',
    version    int default 0 null comment '保留字段',
    deleted    int default 0 null comment '逻辑删除'
)
    comment '角色表' ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


INSERT INTO user_role (id, roleid, name, permission, tips, version, deleted) VALUES (1, 1, 'admin', 'admin', '管理员', 0, 0);


-- 表 --
ALTER TABLE user CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 字段 --
ALTER TABLE user CHANGE name name VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

SET FOREIGN_KEY_CHECKS = 1;