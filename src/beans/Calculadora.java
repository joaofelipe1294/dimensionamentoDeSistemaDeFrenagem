/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author joaofelipelopes
 */
public class Calculadora {
    public double massaTotalDoSistema(Veiculo veiculo){
        return veiculo.getMassaVeiculo() + veiculo.getMassaPiloto();
    }
}
