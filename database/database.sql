create database alunos;
use alunos;

create table aluno(
	id int primary key auto_increment,
	cpf varchar(11) not null,
    nome varchar(40) not null,
    dataNasc date not null,
    peso float not null,
    altura float not null
    );
    
select * from aluno;