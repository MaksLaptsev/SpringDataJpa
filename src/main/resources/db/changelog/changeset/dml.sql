--liquibase formatted sql

--changeset Maks:2

insert into payment (id, payment_from, payment_to, payment_type)
values  (1, 'from1', 'from1', 'REQUISITE'),
        (2, '1234567', '23456789', 'REQUISITE'),
        (3, '22245632', '1235124', 'REQUISITE'),
        (4, '123512341', '11254512', 'REQUISITE'),
        (5, '123512341', '11254512', 'ERIP'),
        (6, '12551234', '33112532', 'ERIP'),
        (7, '12551234', '77562246', 'ERIP'),
        (8, '12551234', '77562246', 'CARD'),
        (9, '125611', '12545124', 'CARD'),
        (10, '375295556021', '3754412354', 'PHONE');

insert into payment_by_requisite (destination, receiver, unp, id)
values  ('unp1', 'receiver1', 'destination1', 1),
        ('111111', 'OOO zubravik', 'Za vse horoshee', 2),
        ('25542354', 'OOO nashe delo', 'Za vse plohoe', 3),
        ('666', 'OOO vse tam bydem', 'strashno vspomnit', 4);

insert into payment_byerip (field_for_insertion, value_for_insertion, id)
values  ('Insertion field', '555055', 5),
        ('Insertion field', '788045', 6),
        ('Insertion field', '123561132', 7);