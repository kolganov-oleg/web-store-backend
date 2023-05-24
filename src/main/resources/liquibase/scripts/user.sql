-- liquibase formatted sql

-- changeset demaz:1
create table if not exists users(
    id                  int generated by default as identity primary key,
    email               varchar,
    first_name          varchar,
    last_name           varchar,
    phone               varchar,
    image               varchar,
    password            varchar,
    role                int
);

-- changeset demaz:2
alter table users drop column image;
alter table users add column avatar_id int;