drop database RentCar;

create database RentCar;

use RentCar;

create table brand
(
id int auto_increment primary key,
name varchar(30) not null
);

create table model
(
id int auto_increment primary key,
brand_id int NOT null,
name varchar(20) NOT null,
foreign key (brand_id) references brand(id)
);

create table car
(
id int auto_increment primary key,
registration_plate varchar(10) not null,
vin_number varchar (50) not null,
purchase_date date not null,
brand_id int not null,
model_id int not null,
foreign key (brand_id) references brand(id),
foreign key (model_id) references model(id)
);

create table employee
(
id int auto_increment primary key,
first_name varchar (40) not null,
last_name varchar (40) not null,
pesel varchar(30) not null,
house_number varchar (20) not null,
flat_number varchar (30),
street_name varchar (40) not null,
city varchar (30) not null,
post_code varchar (10) not null
);

create table customer
(
id int auto_increment primary key,
type varchar(1) not null,
company_name varchar(30),
tax_number varchar(30),
first_name varchar (40),
last_name varchar (40),
pesel varchar(20),
house_number varchar (20) not null,
flat_number varchar (30),
street_name varchar (40) not null,
city varchar (30) not null,
post_code varchar (10) not null
);

create table rent_information
(
id int auto_increment primary key,
car_id int not null,
rent_start datetime not null ,
rent_finish datetime not null,
employee_id int not null,
customer_id int not null,
customer_type varchar(1) not null,
customer_company_name varchar(30),
customer_tax_number varchar(30),
customer_first_name varchar (40),
customer_last_name varchar (40) ,
customer_pesel varchar(20),
customer_house_number varchar (20) not null,
customer_flat_number varchar (30),
customer_street_name varchar (40) not null,
customer_city varchar (30) not null,
customer_post_code varchar (10) not null,
rent_net_price decimal(20.2) not null,
rent_percent decimal (20.2) not null,
rent_gross_price decimal (20.2) not null,
foreign key (car_id) references car(id),
foreign key (employee_id) references employee(id),
foreign key (customer_id) references customer(id)
);
