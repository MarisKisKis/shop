create table if not exists desktopPCs
(
    id bigint primary key,
    serial_number character varying(256),
    producer character varying(256),
    price float,
    amount_at_stock bigint,
    formFactor character varying(50)
);

create table if not exists hardDrives
(
    id bigint primary key,
    serial_number character varying(256),
    producer character varying(256),
    price float,
    amount_at_stock bigint,
    volume_value int,
    measure_unit character varying(50)
);

create table if not exists laptops
(
    id bigint primary key,
    serial_number character varying(256),
    producer character varying(256),
    price float,
    amount_at_stock bigint,
    size int
);

create table if not exists monitors
(
    id bigint primary key,
    serial_number character varying(256),
    producer character varying(256),
    price float,
    amount_at_stock bigint,
    diagonal_value float,
    measure_unit character varying(50)
);