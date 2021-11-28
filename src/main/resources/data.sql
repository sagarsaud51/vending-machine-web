
-- drop table if exists items CASCADE;
-- drop table if exists transaction_log CASCADE;
-- drop sequence if exists hibernate_sequence;
-- create sequence hibernate_sequence start with 1 increment by 1;
-- create table items (id bigint not null, amount double, code varchar(255), name varchar(255), stock integer, primary key (id));
-- create table transaction_log (id bigint not null, amount double, item varchar(255), transaction_date timestamp, uuid binary, primary key (id))
--
--
INSERT INTO ITEMS (id,name, amount, stock, code)
VALUES
       (1,'Coke',20,5,'001'),
       (2,'FANTA',20,5,'002'),
       (3,'SPRITE',20,5,'003'),
       (4,'LAYS',30,5,'004'),
       (5,'BEER',50,5,'005'),
       (6,'MILK',15,5,'006'),
       (7,'CHIPS',19,5,'007'),
       (8,'Wine',75,5,'008'),
       (9,'Banana',2,5,'009');

