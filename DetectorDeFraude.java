package script;

import java.util.ArrayList;
import java.util.List;

public class DetectorDeFraude {
    
    //lista
    public List<TransacaoSuspeita> detectarSuspeitas(List<Transacao> transacoes) {
        List<TransacaoSuspeita> suspeitas = new ArrayList<>();
        
        float limiteRazaoPreco = 4.0f;
        float limiteDistanciaCasa = 100.0f;
        float limiteUltimaTrans = 30.0f;
        float limitePrecoExtremo = 20.0f;

        for (Transacao t : transacoes) {
            boolean eFraude = false;
            
            //condicoes para fraude
            if (!t.isUsouPin() && t.isPedidoOnline()) {
                int condicoesAdicionaisSuspeitas = 0;
                if (t.getRazaoPrecoMedioCompra() > limiteRazaoPreco) {
                    condicoesAdicionaisSuspeitas++;
                }
                if (t.getDistanciaDeCasa() > limiteDistanciaCasa) {
                    condicoesAdicionaisSuspeitas++;
                }
                if (t.getDistanciaUltimaTransacao() > limiteUltimaTrans) {
                    condicoesAdicionaisSuspeitas++;
                }
                if (!t.isUsouChip()) {
                    condicoesAdicionaisSuspeitas++;
                }
                if (condicoesAdicionaisSuspeitas >= 2) {
                    eFraude = true;
                }
            } else if (t.getRazaoPrecoMedioCompra() > limitePrecoExtremo) {
                eFraude = true;
            }
            else if (t.getDistanciaDeCasa() > 1000.0f) {
                eFraude = true;
            }
            else if (t.getDistanciaUltimaTransacao() > 500.0f) {
                eFraude = true;
            }

            if (eFraude) {
                suspeitas.add(new TransacaoSuspeita(t, true));
            }
        }
        return suspeitas;
    }
}