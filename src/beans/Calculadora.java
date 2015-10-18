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
    
    public double acelerecaoDoSistemaPelaEquacaoDeTorriecelli(){
        return -1 * (Math.pow(veiculo.getVelocidadeMaxima(), 2) / (2 * veiculo.getDistanciaFrenagem()));
    }
    
    public double pesoEstaticoDianteira(){
        return pesoTotalDoSistema() * (veiculo.getDistanciaCgTraseira() / veiculo.getDistanciaEntreEixos());
    }
    
    public double pesoEstaticoTraseira(){
        return pesoTotalDoSistema() * (veiculo.getDistanciaCgDianteira() / veiculo.getDistanciaEntreEixos());
    }
    
    public double pesoBaixaVelocidadeDianteira(){
        double s1 = pesoTotalDoSistema() * acelerecaoDoSistemaPelaEquacaoDeTorriecelli() * veiculo.getAlturaCgEmRelacaoSuperficie();
        double s2 = veiculo.ACELERACAO_GRAVITACIONAL * veiculo.getDistanciaEntreEixos();
        return pesoEstaticoDianteira() - (s1 / s2);
    }

    
    public double pesoBaixaVelocidadeTraseira(){
        double s1 = pesoTotalDoSistema() * acelerecaoDoSistemaPelaEquacaoDeTorriecelli() * veiculo.getAlturaCgEmRelacaoSuperficie();
        double s2 = veiculo.ACELERACAO_GRAVITACIONAL * veiculo.getDistanciaEntreEixos();
        return pesoEstaticoTraseira() + (s1 / s2);
    }
    
    public double forcaResultanteRodaDianteira(){
        return pesoBaixaVelocidadeDianteira() * veiculo.getAtritoSolo().getCoeficienteDeAtritoComSolo();
    }
    
    public double momentoGeradoPelaForcaDeFrenagemDianteira(){
        return forcaResultanteRodaDianteira() * veiculo.getRaioPneuDianteiro();
    }
    
    public double forcaAplicadaDiscoDianteiro(){
        return momentoGeradoPelaForcaDeFrenagemDianteira() / veiculo.getRaioDiscoDianteiro();
    }
    
    public double forcaAplicadaPastilhaDianteira(){
        return forcaAplicadaDiscoDianteiro() * veiculo.getAtritoDisco();
    }
    
    public double pressaoTransmitidaAoFluidoPelaDianteira(){
        return forcaAplicadaPastilhaDianteira() / (areaDoEmboloPincaDianteira() * veiculo.getNumeroEmbolosDianteiro());
    }
    
    public double forcaResultanteDaRodaTraseira(){
        return pesoBaixaVelocidadeTraseira() * veiculo.getAtritoSolo().getCoeficienteDeAtritoComSolo();
    }
    
    public double momentoGeradoPelaForcaDeFrenagemTraseira(){
        return forcaResultanteDaRodaTraseira() * veiculo.getRaioPneuTraseiro();
    }
    
    public double forcaAplicadaDiscoTraseiro(){
        return momentoGeradoPelaForcaDeFrenagemTraseira() / veiculo.getRaioDiscoTraseiro();
    }
    
    public double forcaAplicadaPastilhaTraseira(){
        return forcaAplicadaDiscoTraseiro() * veiculo.getAtritoDisco();
    }
    
    public double pressaoTransmitidaAoFluidoPelaTraseira(){
        return forcaAplicadaPastilhaTraseira() / (areaDoEmboloPincaTraseira() * veiculo.getNumeroEmbolosTraseiro());
    }
    
    public double forcaAplicadaPastilhaFreioCorrida(){
        return pegaMaiorPrecao() * areaDoEmboloPincaTraseira() * veiculo.getNumeroEmbolosTraseiro();
    }
    
    public double forcaAplicadaDiscoCorrigido(){
        return forcaAplicadaPastilhaFreioCorrida()/ veiculo.getAtritoDisco();
    }
    
    public double raioDoDiscoCorrigido(){
        return momentoGeradoPelaForcaDeFrenagemTraseira() / forcaAplicadaDiscoCorrigido();
    }
    
    public double relacaoEntreOsDiscos(){
        return veiculo.getRaioDiscoDianteiro() / raioDoDiscoCorrigido();
    }
    
    public double raioMinimoCorrigido(){
        return 0.05 * relacaoEntreOsDiscos();
    }
    
    public double areaDoEmboloCilindroMestre(){
        return (Math.PI * Math.pow(veiculo.getDiametroEmboloCilindroMestre() , 2)) / 4;
    }
    
    public double relacaoPedal(){
        double relacao = veiculo.FORCA_ERGONOMICAMENTE_PARA_FRENAGEM / (this.pegaMaiorPrecao() * areaDoEmboloCilindroMestre());
        return relacao;
    }
    
    public double momentoNovoGeradoRoda(){
        return forcaAplicadaDiscoDianteiro() * veiculo.getRaioDiscoCorrigido();
    }
    
    public double forcaResultanteNova(){
        return momentoNovoGeradoRoda() / veiculo.getRaioPneuDianteiro();
    }
    
    public double pesoDinamicoDianteira(){
        return forcaResultanteNova() / veiculo.getAtritoSolo().getCoeficienteDeAtritoComSolo();
    }
    
    public double desaceleracaoCorrigida(){
        return ((pesoEstaticoDianteira() - pesoDinamicoDianteira()) * veiculo.ACELERACAO_GRAVITACIONAL * veiculo.getDistanciaEntreEixos()) / (pesoTotalDoSistema() * veiculo.getAlturaCgEmRelacaoSuperficie());
    }
    
    public double distanciaDeFrenagem(){
        return (-1 * Math.pow(veiculo.getVelocidadeMaxima() , 2)) / (desaceleracaoCorrigida() * 2);
    }
    
    public double coeficienteDeMelhoria(){
        return 1 - (distanciaDeFrenagem() / veiculo.getDistanciaFrenagem());
    }
    
    public double tempoDeFrenagem(){
        double a = desaceleracaoCorrigida() / 2;
        double b = veiculo.getVelocidadeMaxima();
        double c = -1 * distanciaDeFrenagem();
        double delta = Math.pow( b , 2) - (4 * a * c);
        return ((-1 * b) + Math.sqrt(delta)) / (2 * a);
    }
    
    
    
    
    
    
    
    
/* --------------------------------- METODOS PRIVADOS ----------------------- */
    
    private double pegaMaiorPrecao(){
        if (pressaoTransmitidaAoFluidoPelaDianteira() > pressaoTransmitidaAoFluidoPelaTraseira())
            return pressaoTransmitidaAoFluidoPelaDianteira();
        else
            return pressaoTransmitidaAoFluidoPelaTraseira();
    }
       
}