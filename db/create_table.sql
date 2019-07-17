create table statuses (id integer primary key,name text);
create table genres(id integer primary key,name text);
create table sales(id integer primary key,status_id,integer,type_id integer,customer_id integer,
invoice_status_id integer,billing_date text,total_sale real,total_expense real,total_profit real,
created_at text,update_at text);
create table salesa_detail(id integer primary key,sales_id integer,description text,
price real,discount real);
create table distribution(id integer primary key,sales_id,integer,name text,percentage real);

create table customers(id integer primary key,name text,tel text,address1 text,address2 text,address3 text,
zip text,email text,person_in_charge text,created_at text,update_at text);

create table sales_prospects(integer id primary key,year text,month text,total_sales real,total_profit real,
profit_goal real,created_at text,update_at);
