/*use hospital;
create table paciente(
	idPaciente int primary key auto_increment,
    nome varchar(60) not null,
    dataNascimento date,
    telefone varchar(14),
    idEndereco int,
    idDiagnostico int,
    foreign key (idEndereco) references endereco (idEndereco),
    foreign key (idDiagnostico) references diagnostico(idDiagnostico)
);

create table endereco (
	idEndereco int primary key auto_increment,
	estado varchar(2),
    cidade varchar(40),
    bairro varchar(40),
    logradouro varchar(40),
    numero varchar(6),
    bloco varchar(2)
);

create table diagnostico(
	idDiagnostico int primary key auto_increment,
	descricao varchar(60),
    especialidade varchar(20)
);*/

select * from paciente;