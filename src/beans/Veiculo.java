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
    protected final double ACELERACAO_GRAVITACIONAL = 9.81;
    private CoeficienteAtrito atritoSolo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getDistanciaCgDianteira() {
        return distanciaCgDianteira;
    }

    public void setDistanciaCgDianteira(double distanciaCgDianteira) {
        this.distanciaCgDianteira = distanciaCgDianteira;
    }

    public double getDistanciaCgTraseira() {
        return distanciaCgTraseira;
    }

    public void setDistanciaCgTraseira(double distanciaCgTraseira) {
        this.distanciaCgTraseira = distanciaCgTraseira;
    }

    public double getDistanciaEntreEixos() {
        return distanciaEntreEixos;
    }

    public void setDistanciaEntreEixos(double distanciaEntreEixos) {
        this.distanciaEntreEixos = distanciaEntreEixos;
    }

    public double getMassaVeiculo() {
        return massaVeiculo;
    }

    public void setMassaVeiculo(double massaVeiculo) {
        this.massaVeiculo = massaVeiculo;
    }

    public double getMassaPiloto() {
        return massaPiloto;
    }

    public void setMassaPiloto(double massaPiloto) {
        this.massaPiloto = massaPiloto;
    }

    public double getRaioPneuDianteiro() {
        return raioPneuDianteiro;
    }

    public void setRaioPneuDianteiro(double raioPneuDianteiro) {
        this.raioPneuDianteiro = raioPneuDianteiro;
    }

    public double getRaioPneuTraseiro() {
        return raioPneuTraseiro;
    }

    public void setRaioPneuTraseiro(double raioPneuTraseiro) {
        this.raioPneuTraseiro = raioPneuTraseiro;
    }

    public double getAtritoDisco() {
        return atritoDisco;
    }

    public void setAtritoDisco(double atritoDisco) {
        this.atritoDisco = atritoDisco;
    }

    public double getRaioDiscoDianteiro() {
        return raioDiscoDianteiro;
    }

    public void setRaioDiscoDianteiro(double raioDiscoDianteiro) {
        this.raioDiscoDianteiro = raioDiscoDianteiro;
    }

    public double getRaioDiscoTraseiro() {
        return raioDiscoTraseiro;
    }

    public void setRaioDiscoTraseiro(double raioDiscoTraseiro) {
        this.raioDiscoTraseiro = raioDiscoTraseiro;
    }

    public double getDiametroEmboloDianteiro() {
        return diametroEmboloDianteiro;
    }

    public void setDiametroEmboloDianteiro(double diametroEmboloDianteiro) {
        this.diametroEmboloDianteiro = diametroEmboloDianteiro;
    }

    public double getDiametroEmboloTraseiro() {
        return diametroEmboloTraseiro;
    }

    public void setDiametroEmboloTraseiro(double diametroEmboloTraseiro) {
        this.diametroEmboloTraseiro = diametroEmboloTraseiro;
    }

    public int getNumeroEmbolosDianteiro() {
        return numeroEmbolosDianteiro;
    }

    public void setNumeroEmbolosDianteiro(int numeroEmbolosDianteiro) {
        this.numeroEmbolosDianteiro = numeroEmbolosDianteiro;
    }

    public int getNumeroEmbolosTraseiro() {
        return numeroEmbolosTraseiro;
    }

    public void setNumeroEmbolosTraseiro(int numeroEmbolosTraseiro) {
        this.numeroEmbolosTraseiro = numeroEmbolosTraseiro;
    }

    public double getDistanciaFrenagem() {
        return distanciaFrenagem;
    }

    public void setDistanciaFrenagem(double distanciaFrenagem) {
        this.distanciaFrenagem = distanciaFrenagem;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public double getTamanhoPneu() {
        return tamanhoPneu;
    }

    public void setTamanhoPneu(double tamanhoPneu) {
        this.tamanhoPneu = tamanhoPneu;
    }

    public CoeficienteAtrito getAtritoSolo() {
        return atritoSolo;
    }

    public void setAtritoSolo(CoeficienteAtrito atritoSolo) {
        this.atritoSolo = atritoSolo;
    }

    
}
