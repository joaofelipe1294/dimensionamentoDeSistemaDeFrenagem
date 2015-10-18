package dao;

import beans.Calculadora;
import connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;

/**
 *
 * @author joaofelipelopes
 */
public class RespostasDAO {
    private DecimalFormat dfDuasCasas;
    private DecimalFormat dfTresCasas;
    private DecimalFormat dfQuatroCasas;
            
    public void cadastra(Calculadora calculadora){
        dfDuasCasas = new DecimalFormat("0.00");
        dfTresCasas = new DecimalFormat("0.000");
        dfQuatroCasas = new DecimalFormat("0.0000");
        String sql = "INSERT INTO respostas (relacao_pedal , relacao_entre_discos , desaceleracao , coeficiente_melhoria , distancia_frenagem , tempo_frenagem , equacao_1 , equacao_2) \n" +
                     "VALUES (? , ? , ? , ? , ? , ? , ? , ?);";
        try (Connection con = new ConnectionFactory().getConnection()){
            con.setAutoCommit(false);
            try (PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setDouble(1, calculadora.relacaoPedal());
                stmt.setDouble(2, calculadora.relacaoEntreOsDiscos());
                stmt.setDouble(3, calculadora.desaceleracaoCorrigida());
                stmt.setDouble(4, calculadora.coeficienteDeMelhoria());
                stmt.setDouble(5, calculadora.distanciaDeFrenagem());
                stmt.setDouble(6, calculadora.tempoDeFrenagem());
                stmt.setString(7, "Deslocamento x Tempo : S = " + dfDuasCasas.format(calculadora.getVeiculo().getVelocidadeMaxima()) + "t + (" + dfQuatroCasas.format(calculadora.desaceleracaoCorrigida()) + " * (t ˆ 2)) / 2");
                stmt.setString(8, "Velocidade x Tempo : (V ˆ 2) = (" + dfDuasCasas.format(calculadora.getVeiculo().getVelocidadeMaxima()) + " ˆ 2) + 2 * " + dfQuatroCasas.format(calculadora.desaceleracaoCorrigida()) + " * S");
                stmt.execute();
                con.commit();
            } catch (Exception e) {
                con.rollback();
                e.printStackTrace();
                throw new RuntimeException("Erro no sql");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro no sql");
        }
    }
    
}
