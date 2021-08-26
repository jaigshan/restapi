create table user (id bigint not null, email varchar(255), first_name varchar(255), last_name varchar(255), role varchar(255), ssn varchar(255), user_name varchar(255), primary key (id));


insert into user values(101, 'kreddy@stacksimplify.com', 'Kalyan', 'Reddy', 'admin', 'ssn101', 'kreddy');
insert into user values(102, 'gwiser@stacksimplify.com', 'Greg', 'Wiser', 'admin', 'ssn102', 'gwiser');
insert into user values(103, 'dmark@stacksimplify.com', 'David', 'Mark', 'admin', 'ssn103', 'dmark');