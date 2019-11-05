create database iblood_db;
use iblood_db;
create table blood_group
(
    bld_grp_id   int auto_increment
        primary key,
    bld_grp_name varchar(10) not null,
    constraint blood_group_bld_grp_name_uindex
        unique (bld_grp_name)
);

create table doctor
(
    doc_id      int auto_increment
        primary key,
    doc_fname   varchar(100) not null,
    doc_lname   varchar(100) not null,
    doc_dob     date         not null,
    doc_address varchar(200) not null,
    doc_email   varchar(50)  not null
);

create table donor
(
    don_id            int auto_increment
        primary key,
    don_fname         varchar(100) not null,
    don_lname         varchar(100) not null,
    don_nic           char(10)     not null,
    don_dob           date         not null,
    don_gender        tinyint(1)   not null,
    registration_date date         not null,
    registration_time time         not null,
    don_address       varchar(200) null,
    don_email         varchar(50)  null,
    don_mobile        char(10)     not null,
    bld_grp_id        int          not null,
    constraint donor_don_nic_uindex
        unique (don_nic),
    constraint donor_blood_group_bld_grp_id_fk
        foreign key (bld_grp_id) references blood_group (bld_grp_id)
            on update cascade on delete cascade
);

create table blood
(
    bld_id     int auto_increment
        primary key,
    hemoglobin decimal(10, 2) null,
    defection  varchar(300)   null,
    don_id     int            not null,
    constraint blood_donor_don_id_fk
        foreign key (don_id) references donor (don_id)
);

create table doctor_contribution
(
    doc_con_id int auto_increment
        primary key,
    bld_id     int not null,
    doc_id     int not null,
    constraint doctor_contribution_blood_bld_id_fk
        foreign key (bld_id) references blood (bld_id)
            on update cascade,
    constraint doctor_contribution_doctor_doc_id_fk
        foreign key (doc_id) references doctor (doc_id)
            on update cascade
);

create table nurse
(
    nur_id      int auto_increment
        primary key,
    nur_fname   varchar(200) not null,
    nur_lname   varchar(200) not null,
    service     varchar(100) null,
    nur_dob     date         not null,
    nur_address varchar(200) not null
);

create table nurse_contribution
(
    nur_con_id int auto_increment
        primary key,
    bld_id     int not null,
    nur_id     int not null,
    constraint nurse_contribution_blood_bld_id_fk
        foreign key (bld_id) references blood (bld_id)
            on update cascade,
    constraint nurse_contribution_nurse_nur_id_fk
        foreign key (nur_id) references nurse (nur_id)
            on update cascade
);

create table patient
(
    pat_id      int auto_increment
        primary key,
    pat_name    varchar(100) not null,
    pat_dob     date         not null,
    pat_gender  tinyint(1)   not null,
    bld_grp_id  int          not null,
    bld_id      int          null,
    requestDate date         null,
    constraint patient_blood_bld_id_fk
        foreign key (bld_id) references blood (bld_id)
            on update cascade on delete cascade,
    constraint patient_blood_group_bld_grp_id_fk
        foreign key (bld_grp_id) references blood_group (bld_grp_id)
            on update cascade on delete cascade
);

