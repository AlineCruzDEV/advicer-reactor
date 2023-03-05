create database advices_db;

create schema public;

create table public.advices (
    id serial PRIMARY KEY,
    advice VARCHAR NOT NULL
);
insert into advices (advice) VALUES ('O melhor conselho que se pode dar a um semelhante é um bom exemplo!');
insert into advices (advice) VALUES ('Persista, insista e não desista!');
insert into advices (advice) VALUES ('Se conselho fosse bom, ninguém dava, vendia!');

create table public.users (
    id serial PRIMARY KEY,
    name VARCHAR NOT NULL,
    email VARCHAR NOT NULL
);
insert into users (name, email) VALUES ('nome1', 'email1@email.com');
insert into users (name, email) VALUES ('nome2', 'email2@email.com');

create table public.topics
(
    id serial PRIMARY KEY,
    name VARCHAR NOT NULL,
    user_id INT not null
);

insert into topics (name) VALUES ('love', '1');
insert into topics (name) VALUES ('god', '1');
insert into topics (name) VALUES ('work', '2');
insert into topics (name) VALUES ('friend', '2');
