create database online_retailers default character set utf8mb4 default collate utf8mb4_unicode_ci;

create table user_table(
    id int not null primary key,
    name varchar(256) null,
    age smallint not null default 0,
    sex tinyint(1) not null default 0 comment '性别0: 男性 1：女性',
    city varchar(256) null,
    address varchar(256) null,
    create_time timestamp not null DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp not null DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    del tinyint(1) not null default 0
);

create table commodity_table(
    id bigint not null primary key,
    name varchar(256) null,
    price decimal(6,2),
    details varchar(256) null default '商品详情',
    pics varchar(1024) null,
    create_time timestamp not null DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp not null DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    del tinyint(1) not null default 0
);

create table order_table(
    id bigint not null primary key,
    name varchar(256) null,
    commodity_id bigint not null,
    user_id int not null,
    price decimal(6,2),
    details varchar(256) null default '订单详情',
    status tinyint(1) not null default 0,
    create_time timestamp not null DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp not null DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    del tinyint(1) not null default 0
);