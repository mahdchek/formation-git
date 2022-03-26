CREATE TABLE IF NOT EXISTS product (
    id integer primary key,
    name varchar(64) not null,
    category varchar(64),
    price integer
    );