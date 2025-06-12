package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

//conecta metodo 1
public class ConectaBanco {
    public static Connection conexao(){
        Connection conexao = null;
        int dados = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/FraudeDeCompras", "root", "1234");
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM transacoes");
            if (rs.next()){
            dados = rs.getInt(1);
            System.out.println("Conexao ao banco de dados realizada com sucesso!");
            System.out.println(dados + " dados foram carregados.");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "[0] Driver do banco de dados não foi encontrado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "[1] Ocorreu um erro ao conectar ao banco de dados:" + ex.getMessage());
        }
        return conexao;
    }
}
