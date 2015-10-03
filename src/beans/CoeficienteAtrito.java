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
public class CoeficienteAtrito {
    private int id;
    private String terreno;
    private double coeficienteDeAtritoComSolo;

    public CoeficienteAtrito(String terreno) {
        this.terreno = terreno;
    }

    public CoeficienteAtrito() {
    }
    
    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public double getCoeficienteDeAtritoComSolo() {
        return coeficienteDeAtritoComSolo;
    }

    public void setCoeficienteDeAtritoComSolo(double coeficienteDeAtritoComSolo) {
        this.coeficienteDeAtritoComSolo = coeficienteDeAtritoComSolo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "CoeficienteAtrito{" + "id=" + id + ", terreno=" + terreno + ", coeficienteDeAtritoComSolo=" + coeficienteDeAtritoComSolo + '}';
    }
}