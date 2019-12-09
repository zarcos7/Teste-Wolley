//database dbclientes
create table cliente(
	id serial,
	 cpf varchar (20),
	nome varchar (50),
	telefone varchar (12),
	endereco varchar(100)
);


insert into cliente (nome, cpf, telefone, endereco) values ('Maria', '111.111.111-11', '1111-1111', 'Rua da UMC, 11');
insert into cliente (nome, cpf, telefone, endereco) values ('Pedro', '222.222.222-22', '2222-2222', 'Rua da UMC, 22');
insert into cliente (nome, cpf, telefone, endereco) values ('Fabiano', '444.444.444-44', '4444-4444', 'Rua da UMC, 44');
