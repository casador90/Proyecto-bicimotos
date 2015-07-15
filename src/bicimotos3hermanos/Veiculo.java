/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicimotos3hermanos;

/**
 *
 * @author Mario
 */
public class Veiculo {
  private String serie;
  private String motor;
  private String placas;
  private String kilometrage;
  private String modelo;

    public Veiculo() {
    }

    public Veiculo(String serie, String motor, String placas, String kilometrage, String modelo) {
        this.serie = serie;
        this.motor = motor;
        this.placas = placas;
        this.kilometrage = kilometrage;
        this.modelo = modelo;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the motor
     */
    public String getMotor() {
        return motor;
    }

    /**
     * @param motor the motor to set
     */
    public void setMotor(String motor) {
        this.motor = motor;
    }

    /**
     * @return the placas
     */
    public String getPlacas() {
        return placas;
    }

    /**
     * @param placas the placas to set
     */
    public void setPlacas(String placas) {
        this.placas = placas;
    }

    /**
     * @return the kilometrage
     */
    public String getKilometrage() {
        return kilometrage;
    }

    /**
     * @param kilometrage the kilometrage to set
     */
    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
  
}


