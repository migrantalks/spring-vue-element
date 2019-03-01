drop table if exists `t_member`;
create table `t_member` (
  `id` bigint(20) not null auto_increment comment 'ID',
  `name` varchar(100) not null comment '名字',
  `sex` char(2) default 0 comment '性别',
  `date` datetime default null comment '创建时间',
  primary key (`id`)
) engine=innodb auto_increment=2 default charset=utf8;