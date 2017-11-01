create table hibernate_sequences (  sequence_name varchar(255), next_val bigint );

create table Accreditation (
	id BIGINT not null, 
	name_en varchar(255), 
	name_th varchar(255),
	file_path varchar(255), 
	primary key (id)
);

create table Laboratory (
	id BIGINT not null, 
	name_en varchar(255),
	name_th varchar(255),
	primary key (id)
);

create table AccreditationScope (
	accreditation_id BIGINT not null, 
	scope_name varchar(255) not null,
	primary key (accreditation_id, scope_name)
);

