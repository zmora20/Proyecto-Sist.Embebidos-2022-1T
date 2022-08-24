-- drop database Control_Almacen;

create database Control_Almacen;
use Control_Almacen;

create table stand(
	id Char(1) primary key not null,
    product varchar(50),
    quantity int,
    scanDate Char(35),
    scans int,
    fills int
	);
