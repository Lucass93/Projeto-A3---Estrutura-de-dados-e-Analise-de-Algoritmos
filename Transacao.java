package script;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Transacao{
    private int id;
    private float distanciaDeCasa;
    private float distanciaUltimaTransacao;
    private float razaoPrecoMedioCompra;
    private boolean repetiuEstabelecimento;
    private boolean usouChip;
    private boolean usouPin;
    private boolean pedidoOnline;
    private boolean fraude;

    public Transacao(int id, float distanciaDeCasa, float distanciaUltimaTransacao, float razaoPrecoMedioCompra, boolean repetiuEstabelecimento, boolean usouChip, boolean usouPin, boolean pedidoOnline, boolean fraude) {
        this.id = id;
        this.distanciaDeCasa = distanciaDeCasa;
        this.distanciaUltimaTransacao = distanciaUltimaTransacao;
        this.razaoPrecoMedioCompra = razaoPrecoMedioCompra;
        this.repetiuEstabelecimento = repetiuEstabelecimento;
        this.usouChip = usouChip;
        this.usouPin = usouPin;
        this.pedidoOnline = pedidoOnline;
        this.fraude = fraude;
    }
    
    //atribuindo variaveis e colunas
    public static Transacao fromResultSet(ResultSet rs) throws SQLException {
        return new Transacao(
            rs.getInt("id"),
            rs.getFloat("distancia_de_casa"),
            rs.getFloat("distancia_da_ultima_transacao"),
            rs.getFloat("razao_preco_medio_compra"),
            rs.getBoolean("repetiu_estabelecimento"),
            rs.getBoolean("usou_chip"),
            rs.getBoolean("usou_pin"),
            rs.getBoolean("pedido_online"),
            rs.getBoolean("fraude")
        );
    }

    public int getId() {
        return id;
    }

    public float getDistanciaDeCasa() {
        return distanciaDeCasa;
    }

    public float getDistanciaUltimaTransacao() {
        return distanciaUltimaTransacao;
    }

    public float getRazaoPrecoMedioCompra() {
        return razaoPrecoMedioCompra;
    }

    public boolean isRepetiuEstabelecimento() {
        return repetiuEstabelecimento;
    }

    public boolean isUsouChip() {
        return usouChip;
    }

    public boolean isUsouPin() {
        return usouPin;
    }

    public boolean isPedidoOnline() {
        return pedidoOnline;
    }

    public boolean isFraude() {
        return fraude;
    } 
}