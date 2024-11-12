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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AlunoDAO {
    private Connection c;
    
    public AlunoDAO(){
        this.c = new ConnectionFactory().getConnection();
    }
    
    public void adicionarAluno(Aluno aluno) {
        if (existeCpf(aluno.getCpf())) {
            String sql = "UPDATE aluno SET nome = ?, dataNasc = ?, peso = ?, altura = ? WHERE cpf = ?";
            try {
                PreparedStatement stmt = c.prepareStatement(sql);
                stmt.setString(1, aluno.getNome());
                stmt.setDate(2, aluno.getDataNasc());
                stmt.setFloat(3, aluno.getPeso());
                stmt.setInt(4, aluno.getAltura());
                stmt.setString(5, aluno.getCpf());

                int linhasAfetadas = stmt.executeUpdate();
                stmt.close();

                if (linhasAfetadas > 0) {
                    JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar o aluno.");
                }
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao atualizar aluno: " + e.getMessage(), e);
            }
        } else {
            String sql = "INSERT INTO aluno(cpf, nome, dataNasc, peso, altura) VALUES (?, ?, ?, ?, ?)";
            try {
                PreparedStatement stmt = c.prepareStatement(sql);
                stmt.setString(1, aluno.getCpf());
                stmt.setString(2, aluno.getNome());
                stmt.setDate(3, aluno.getDataNasc());
                stmt.setFloat(4, aluno.getPeso());
                stmt.setInt(5, aluno.getAltura());
                stmt.execute();
                stmt.close();

                JOptionPane.showMessageDialog(null, "Aluno inserido com sucesso.");
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao inserir aluno: " + e.getMessage(), e);
            }
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
                JEditorPane editorPane = new JEditorPane("text/html", result.toString()); // Classe para formatação do texto
                editorPane.setEditable(false);
                JOptionPane.showMessageDialog(null, editorPane);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar aluno: " + e.getMessage(), e);
        }
    }
    
    public Aluno buscarAlunoPorCpf(Aluno aluno) {
        String sql = "SELECT * FROM aluno WHERE cpf = ?";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, aluno.getCpf());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                aluno = new Aluno(null, null, null, 0, 0);
                aluno.setCpf(rs.getString("cpf"));
                aluno.setNome(rs.getString("nome"));
                aluno.setDataNasc(rs.getDate("dataNasc"));
                aluno.setPeso(rs.getFloat("peso"));
                aluno.setAltura(rs.getInt("altura"));
            }

            rs.close();
            stmt.close();

            if (aluno == null) {
                JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado com o CPF fornecido.");
            }
            return aluno;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar aluno: " + e.getMessage(), e);
        }
    }
    
    public boolean existeCpf(String cpf) {
        String sql = "SELECT COUNT(*) FROM aluno WHERE cpf = ?";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            boolean existe = false;
            if (rs.next()) {
                existe = rs.getInt(1) > 0; // Retorna true se a contagem for maior que 0
            }

            rs.close();
            stmt.close();

            return existe;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar CPF: " + e.getMessage(), e);
        }
    }
    
    public Aluno pesquisaImc(String cpf) {
        String sql = "SELECT nome, peso, altura FROM aluno WHERE cpf = ?";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            Aluno aluno = null;
            if (rs.next()) {
                aluno = new Aluno(null, null, null, 0, 0);
                aluno.setCpf(cpf);
                aluno.setNome(rs.getString("nome"));
                aluno.setPeso(rs.getFloat("peso"));
                aluno.setAltura(rs.getInt("altura"));
            }

            rs.close();
            stmt.close();

            if (aluno == null) {
                JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado com o CPF fornecido.");
            }

            return aluno;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar peso e altura: " + e.getMessage(), e);
        }
    }
    
    public void calcularImc(String cpf) {
        Aluno aluno = pesquisaImc(cpf);
        if (aluno != null) {
            float peso = aluno.getPeso();
            float alturaMetros = aluno.getAltura() / 100.0f; // Converter altura de cm para metros
            float imc = peso / (alturaMetros * alturaMetros);
            
            // Interpretação do IMC
            String i;
            if (imc < 18.5) {
                i = "Abaixo do peso";
            } else if (imc >= 18.5 && imc < 24.9) {
                i = "Peso ideal";
            } else if (imc >= 25 && imc < 29.9) {
                i = "Sobrepeso";
            } else {
                i = "Obesidade";
            }

            // Formatar o resultado com nome, CPF, IMC e interpretação
            String resultado = String.format(
                "Nome: %s\nCPF: %s\nCalculado em %tF, %<tT \nResultado: %.2f \nInterpretação: %s\n\n",
                aluno.getNome(), aluno.getCpf(), new java.util.Date(), imc, i
            );

            // Caminho do arquivo de texto, usando CPF do aluno como identificador
            String nomeArquivo = "C:\\Users\\vinic\\Desktop\\PastaIMC\\" + "IMC_" + aluno.getCpf() + ".txt";

            try (FileWriter fw = new FileWriter(nomeArquivo, true); 
                BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(resultado);
                bw.newLine();
                JOptionPane.showMessageDialog(null, "IMC calculado e salvo em: " + nomeArquivo);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao escrever o arquivo: " + e.getMessage());
            }
        }
    }
}