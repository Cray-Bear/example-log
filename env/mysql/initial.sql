CREATE TABLE `t_user`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT,
    `real_name`   varchar(24) NOT NULL COMMENT '真实姓名',
    `id_no`       varchar(20) NOT NULL COMMENT '身份证号',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    `remark`      VARCHAR(200) COMMENT 'remark',
    PRIMARY KEY (`id`),
    unique KEY `idx_user` (`real_name`, `id_no`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '用户实名信息表';


insert into t_user (id, real_name, id_no, create_time, remark) values (1, '赵一', '340207202211152258', '2022-11-14 07:13:59', now());
insert into t_user (id, real_name, id_no, create_time, remark) values (2, '钱二', '469025202211159836', '2022-11-14 07:13:59', now());
insert into t_user (id, real_name, id_no, create_time, remark) values (3, '孙三', '21140420221115365X', '2022-11-14 07:13:59', now());
insert into t_user (id, real_name, id_no, create_time, remark) values (4, '李四', '513433202211159554', '2022-11-14 07:13:59', now());
insert into t_user (id, real_name, id_no, create_time, remark) values (5, '周五', '140727202211159033', '2022-11-14 07:13:59', now());
insert into t_user (id, real_name, id_no, create_time, remark) values (6, '吴六', '120116202211151319', '2022-11-14 07:13:59', now());


ALTER TABLE t_user ADD real_name_cipher varchar(100) DEFAULT NULL COMMENT '真实姓名-密文列';
ALTER TABLE t_user ADD id_no_cipher varchar(100) DEFAULT NULL COMMENT '身份证号-密文列';



