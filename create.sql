create table if not exists odontologo(
	id_od int auto_increment primary key,
	mat_od varchar,
	nom_od varchar,
	ape_od varchar
);

create table if not exists domicilio(
	id_domicilio int auto_increment primary key,
	calle_domicilio varchar,
	nro_puerta_domicilio varchar,
	ciudad_domicilio varchar,
	provincia_domicilio varchar
);

create table if not exists paciente(
	id_pac int auto_increment primary key,
	nom_pac varchar,
	ape_pac varchar,
	dni_pac varchar,
	id_domicilio_pac int,
	fecha_ingreso_pac timestamp without time zone,
	foreign key (id_domicilio_pac) references domicilio(id_domicilio)
);


create table if not exists turno (
  id_turno int auto_increment primary key,
  id_pac_turno int,
  id_od_turno int,
  fecha_hora_turno timestamp without time zone,
  foreign key (id_pac) references paciente(id_pac),
  foreign key (id_od) references odontologo(id_od)
);