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
    private Veiculo veiculo;

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public double massaTotalDoSistema(){
        return veiculo.getMassaVeiculo() + veiculo.getMassaPiloto();
    }
    
    public double pesoTotalDoSistema(){
        return massaTotalDoSistema() * veiculo.ACELERACAO_GRAVITACIONAL;
    }
    
    public double areaDoEmboloPincaDianteira(){
        return (Math.pow(veiculo.getDiametroEmboloDianteiro(), 2) * Math.PI) / 4;
    }
    
    public double areaDoEmboloPincaTraseira(){
        return (Math.pow(veiculo.getDiametroEmboloTraseiro(), 2) * Math.PI) / 4;
    }
    
}
