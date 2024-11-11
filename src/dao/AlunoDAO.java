package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import modelo.Aluno;
import gui.*;

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
    
    public void excluirAluno(Aluno aluno){
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
    
    public void pesquisarAluno(Aluno aluno){
        String sql = "SELECT * FROM aluno WHERE nome LIKE ?";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, "%" + aluno.getNome() + "%");
            ResultSet rs = stmt.executeQuery();

            StringBuilder result = new StringBuilder();  // Para armazenar os resultados da pesquisa
            boolean find = false;

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Date dataNasc = rs.getDate("dataNasc");
                float peso = rs.getFloat("peso");
                float altura = rs.getFloat("altura");

                result.append("<b>ID:</b> ").append(id)
                      .append("<b> ||| NOME:</b> ").append(nome)
                      .append("<b> ||| CPF:</b> ").append(cpf)
                      .append("<b> ||| DATA DE NASCIMENTO:</b> ").append(dataNasc)
                      .append("<b> ||| PESO:</b> ").append(peso)
                      .append("kg  <b> ||| ALTURA:</b> ").append(altura)
                      .append("cm<br>");
                find = true;
            }

            rs.close();
            stmt.close();

            if (find) {
                JEditorPane editorPane = new JEditorPane("text/html", result.toString()); //Classe para formatação do texto
                editorPane.setEditable(false);
                JOptionPane.showMessageDialog(null, editorPane);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar aluno: " + e.getMessage(), e);
        }
    }
        
    public void pesquisaAtualizar(Aluno aluno) {
        String sql = "SELECT * FROM aluno WHERE cpf = ?";

        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, aluno.getCpf());  // Definir o CPF para a consulta
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                int cpf = rs.getInt("cpf");
                Date dataNasc = rs.getDate("dataNasc");
                float peso = rs.getFloat("peso");
                float altura = rs.getFloat("altura");

//                AlunoGUI.getCampoNome.setText(nome);
//                campoCpf.setText(cpf);
//                campoDataNasc.setText(dataNasc);
//                campoPeso.setText(String.valueOf(peso));
//                campoAltura.setText(String.valueOf(altura));
            } else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado com o CPF: " + aluno.getCpf());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar aluno: " + e.getMessage(), e);
        }
    }

    
    public void atualizarAluno(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, cpf = ?, dataNasc = ?, peso = ?, altura = ? WHERE cpf = ?";

        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf()); 
            stmt.setDate(3, aluno.getDataNasc());
            stmt.setDouble(4, aluno.getPeso());
            stmt.setDouble(5, aluno.getAltura());
            stmt.setString(6, aluno.getCpf());  // Condição para identificar o aluno a ser atualizado

            int linhasAfetadas = stmt.executeUpdate();  // Executar a atualização

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Dados do aluno atualizados com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar dados.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar os dados: " + e.getMessage(), e);
        }
    }
}