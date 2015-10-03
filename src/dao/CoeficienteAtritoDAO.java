/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.CoeficienteAtrito;
import connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author joaofelipelopes
 */
public class CoeficienteAtritoDAO {
    
    public CoeficienteAtrito pegaCoeficiente(CoeficienteAtrito coeficiente) throws RuntimeException{
        String sql = "SELECT terreno , coeficiente , id FROM coeficiente_de_atrito WHERE terreno = ?";
        try (Connection con = new ConnectionFactory().getConnection()){
            try (PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setString(1, coeficiente.getTerreno());
                try (ResultSet rs = stmt.executeQuery()){
                    CoeficienteAtrito coeficienteSelecionado = new CoeficienteAtrito();
                    while(rs.next()){
                        coeficienteSelecionado.setTerreno(coeficiente.getTerreno());
                        coeficienteSelecionado.setCoeficienteDeAtritoComSolo(rs.getDouble("coeficiente"));
                        coeficienteSelecionado.setId(rs.getInt("id"));
                    }
                    return coeficienteSelecionado;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Tipo de terreno nao existe !!!");
    }   
}
