create database alunos;
use alunos;

create table aluno(
	id int primary key auto_increment,
	cpf varchar(11),
    nome varchar(40),
    dataNasc date,
    peso float,
    altura int
    );
    
select * from aluno;