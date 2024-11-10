package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Aluno;

public class AlunoDAO {
    private Connection c;
    
    public AlunoDAO(){
        this.c = new ConnectionFactory().getConnection();
    }
    
    public void adicionarAluno(Aluno aluno){
        String sql = "INSERT INTO aluno(cpf, nome, dataNasc, peso, altura) VALUES (?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, aluno.getCpf());
            stmt.setString(2, aluno.getNome());
            stmt.setDate(3, aluno.getDataNasc());
            stmt.setFloat(4, aluno.getPeso());
            stmt.setInt(5, aluno.getAltura());   
            stmt.execute();
            stmt.close();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void excluirAluno(Aluno aluno) {
        String sql = "DELETE FROM aluno WHERE cpf = ?";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, aluno.getCpf());
            int linhasAfetadas = stmt.executeUpdate(); // Retorna o número de linhas afetadas pela operação
            stmt.close();

            if (linhasAfetadas == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado com o CPF fornecido.");
            } else {
                JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}