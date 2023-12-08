--liquibase formatted sql

--changeset Maks:1
create table payment
(
    id           bigserial PRIMARY KEY,
    payment_from varchar(70),
    payment_to   varchar(70),
    payment_type varchar(70)
);

create table payment_byerip
(
    field_for_insertion varchar(70),
    value_for_insertion varchar(70),
    id                  bigint PRIMARY KEY REFERENCES payment (id)
);

create table payment_by_requisite
(
    destination varchar(70),
    receiver    varchar(70),
    unp         varchar(70),
    id          bigint PRIMARY KEY REFERENCES payment (id)
);
