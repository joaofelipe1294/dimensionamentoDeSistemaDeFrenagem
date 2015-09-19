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
public class Veiculo {
    private long id;
    private double distanciaCgDianteira;
    private double distanciaCgTraseira;
    private double distanciaEntreEixos;
    private double massaVeiculo;
    private double massaPiloto;
    private double raioPneuDianteiro;
    private double raioPneuTraseiro;
    private double atritoDisco;
    private double raioDiscoDianteiro;
    private double raioDiscoTraseiro;
    private double diametroEmboloDianteiro;
    private double diametroEmboloTraseiro;
    private int numeroEmbolosDianteiro;
    private int numeroEmbolosTraseiro;
    private double distanciaFrenagem;
    private double velocidadeMaxima;
    private double tamanhoPneu;
    private final double ACELERACAO_GRAVITACIONAL = 9.81;
    private CoeficienteAtrito atritoSolo;
}
