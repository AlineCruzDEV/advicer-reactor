create database advices_db;
create schema public;
create table advices (
    id serial PRIMARY KEY,
    advice VARCHAR NOT NULL
);
insert into advices (advice) VALUES ('O melhor conselho que se pode dar a um semelhante é um bom exemplo!');
insert into advices (advice) VALUES ('Persista, insista e não desista!');
insert into advices (advice) VALUES ('Se conselho fosse bom, ninguém dava, vendia!');