create table TB_USER (
    id bigint auto_increment,
    name varchar(50),
    balance int,
    primary key (id)
);

create table TB_USER_TRANSACTION (
    id bigint auto_increment,
    user_id bigint,
    amount int,
    transaction_date timestamp,
    foreign key (user_id) references TB_USER(id) on delete cascade
    -- foreign key (user_id) references TB_USER(id) - REMOVE USER BUT MAINTAIN HISTORY TRANSACTION
);