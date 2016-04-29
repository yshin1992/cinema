create database cinema default charset=utf8;

use cinema;

create table cinema(
id bigint auto_increment primary key,
cinema_name nvarchar(100) not null,/* 电影名称*/
director nvarchar(100) not null,/* 导演 */
actor nvarchar(200) not null,/* 演员 */
address nvarchar(30) not null,/* 地区 */
play_time datetime not null, /* 上映时间 */
cinema_desc text, /* 电影简介 */
poster blob /* 电影海报 */
) engine = InnoDB charset=utf8;

alter table cinema comment '电影信息表';

create table administrator(
id int auto_increment primary key comment '主键',
username nvarchar(100) not null comment '用户名',
password char(32) not null comment '密码',
create_time timestamp not null comment '创建时间',
valid_flag bit default 1 not null comment '有效标识'
) engine = InnoDB charset=utf8;

alter table administrator comment '管理员信息表';