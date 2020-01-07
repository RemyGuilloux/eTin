
create table association (
       id bigint not null auto_increment,
        avatar varchar(255),
        balance bigint,
        description varchar(255),
        name varchar(20) not null,
        siren varchar(255),
        primary key (id)
    ) engine=InnoDB

create table balance_user_tinee (
       id bigint not null auto_increment,
        balance double precision not null,
        tinee_id bigint not null,
        user_id bigint not null,
        primary key (id)
    ) engine=InnoDB

create table tinee (
       id bigint not null auto_increment,
        active bit not null,
        description varchar(280),
        end_date date not null,
        max_amount bigint not null,
        start_date date not null,
        title varchar(20) not null,
        author_id bigint not null,
        goal_id bigint not null,
        primary key (id)
    ) engine=InnoDB

create table tinee_rules (
       tinee_id bigint not null,
        rules_id bigint not null,
        primary key (tinee_id, rules_id)
    ) engine=InnoDB

create table tinee_swears (
       tinee_id bigint not null,
        swears_id bigint not null,
        primary key (tinee_id, swears_id)
    ) engine=InnoDB

create table tinee_rule (
       id bigint not null auto_increment,
        multiplier double precision not null,
        severity varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

create table tinee_swear (
       id bigint not null auto_increment,
        amount bigint not null,
        author tinyblob not null,
        date datetime not null,
        name varchar(20) not null,
        proof varchar(255),
        reporter tinyblob,
        primary key (id)
    ) engine=InnoDB

create table user (
       id bigint not null auto_increment,
        email varchar(100) not null,
        password varchar(255) not null,
        user_name varchar(20) not null,
        primary key (id)
    ) engine=InnoDB

alter table tinee_rules 
add constraint UK_js2lffmo0chdhd7gn1thbxu9t unique (rules_id)
alter table tinee_swears 
add constraint UK_2554h82jbkw9m4ubonh29mkf7 unique (swears_id)
alter table user 
add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user 
add constraint UK_lqjrcobrh9jc8wpcar64q1bfh unique (user_name)
alter table balance_user_tinee 
add constraint FKq3mk03xf1jqmsl7098v4svg74 
foreign key (tinee_id) 
references tinee (id)
alter table balance_user_tinee 
add constraint FK2aq1vxsquucfjemwgob0qoflm 
foreign key (user_id) 
references user (id)
alter table tinee 
add constraint FKyltrkpmeo0c2ujmp78ac3ifj 
foreign key (author_id) 
references user (id)
alter table tinee 
add constraint FKktrv4pnam914nrg2kwu1vmsde 
foreign key (goal_id) 
references association (id)
alter table tinee_rules 
add constraint FKhc8qndcf89kwxv2l0q576fs0u 
foreign key (rules_id) 
references tinee_rule (id)
alter table tinee_rules 
add constraint FKg29ybkhailv6isp38k2apx3ae 
foreign key (tinee_id) 
references tinee (id)
alter table tinee_swears 
add constraint FKhm8f2n91h815nsfu8vdlhgnes 
foreign key (swears_id) 
references tinee_swear (id)
alter table tinee_swears 
add constraint FKcr1b5dgmk86gbfb6d2s62j4je 
foreign key (tinee_id) 
references tinee (id)