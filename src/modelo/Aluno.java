package modelo;

import java.sql.Date;

public class Aluno {
    private String cpf, nome;
    private float peso;
    private int altura;
    private Date dataNasc;

    public Aluno(String cpf, String nome, Date dataNasc, float peso, int altura) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.peso = peso;
        this.altura = altura;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public float getPeso() {
        return peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}