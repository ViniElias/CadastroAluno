package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Aluno;

public class AlunoDAO {
    private Connection c;
    
    public AlunoDAO(){
        this.c = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Aluno aluno){
        String sql = "INSERT INTO aluno(nomeAluno) VALUES(?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.execute();
            stmt.close();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}