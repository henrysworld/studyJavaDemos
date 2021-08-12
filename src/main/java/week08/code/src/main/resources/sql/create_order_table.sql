create table t_order(
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