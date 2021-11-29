-- drop table if exists items CASCADE;
-- drop table if exists transaction_log CASCADE;
-- drop sequence if exists hibernate_sequence;
-- create sequence hibernate_sequence start with 1 increment by 1;
-- create table items (id bigint not null, amount double, code varchar(255), name varchar(255), stock integer, primary key (id));
-- create table transaction_log (id bigint not null, amount double, item varchar(255), transaction_date timestamp, uuid binary, primary key (id))
--
--
INSERT INTO ITEMS (id, name, amount, stock, code)
VALUES (1, 'Coke', 20, 50, '001'),
       (2, 'FANTA', 20, 50, '002'),
       (3, 'SPRITE', 20, 50, '003'),
       (4, 'LAYS', 30, 50, '004'),
       (5, 'BEER', 50, 50, '005'),
       (6, 'MILK', 15, 50, '006'),
       (7, 'CHIPS', 19, 50, '007'),
       (8, 'Wine', 75, 50, '008'),
       (9, 'Banana', 2, 50, '009');

