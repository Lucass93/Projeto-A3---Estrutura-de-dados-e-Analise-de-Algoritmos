package SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import script.Transacao;
import script.TransacaoSuspeita;

public class BancoDeDados {
    
    //metodo que seleciona os dados no banco
    public List<Transacao> carregarTransacoes() throws SQLException {
        List<Transacao> transacoes = new ArrayList<>();

        try (Connection conn = ConectaBanco.conexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM transacoes")) {
            
            while (rs.next()) {
                transacoes.add(Transacao.fromResultSet(rs));
            }
        }  
        return transacoes;
    }
    
    //metodo que envia os classificados como fraude para o banco
    public void inserirFraude(List<TransacaoSuspeita> suspeitas) throws SQLException {
        try (Connection conn = ConectaBanco.conexao();
             PreparedStatement stmt = conn.prepareStatement(
             "INSERT INTO suspeitas (id_transacao_original, distancia_de_casa, distancia_da_ultima_transacao, " +
             "razao_preco_medio_compra, repetiu_estabelecimento, usou_chip, usou_pin, pedido_online, suspeita_detectada) " +
             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            
            for (TransacaoSuspeita s : suspeitas) {
                stmt.setInt(1, s.getIdTransacaoOriginal());
                stmt.setFloat(2, s.getDistanciaDeCasa());
                stmt.setFloat(3, s.getDistanciaUltimaTransacao());
                stmt.setFloat(4, s.getRazaoPrecoMedioCompra());
                stmt.setBoolean(5, s.isRepetiuEstabelecimento());
                stmt.setBoolean(6, s.isUsouChip());
                stmt.setBoolean(7, s.isUsouPin());
                stmt.setBoolean(8, s.isPedidoOnline());
                stmt.setBoolean(9, s.isFraude());
                
                stmt.addBatch();
            }        
            stmt.executeBatch();        
        }
    }

}
