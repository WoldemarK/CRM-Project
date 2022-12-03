create table Company
(
    id           int primary key generated by default as identity,
    name         varchar(100) not null,
    email        varchar(50)  not null,
    phone_number varchar(50)  not null,
    descriptions varchar(2000),
    type         varchar(50)  not null,
    website      varchar(50),
    creation     timestamp default now(),
    update       timestamp default now()
);

create table Contact
(
    id           int primary key generated by default as identity,
    company_id   int          references Company (id) on delete set null,
    name         varchar(100) not null,
    email        varchar(50)  not null,
    phone_number varchar(50)  not null,
    descriptions varchar(2000),
    post         varchar(20)  not null,
    creation     timestamp default now(),
    update       timestamp default now()
);
drop table Contact;

create table Task
(
    id           int primary key generated by default as identity,
    name         varchar(100) not null,
    descriptions varchar(5000),
    executor     varchar(100) not null,
    company_id   int          references Company (id) on delete set null,
    contact_id   int          references Company (id) on delete set null,
    creation     timestamp default now(),
    update       timestamp default now()
);