/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicimotos3hermanos;

/**
 *
 * @author jonatan
 */
public class Condicion_Vehiculo {
    
    private boolean espejo_izq_roto;
    private boolean espejo_der_roto;
    private boolean asiento_rot;
    private boolean faro_delantero_funciona;
    private boolean foco_de_stop_funciona;
    private boolean direccional_izq_de_tras;
    private boolean direccional_der_de_tras;
    private boolean cubiertas_golpeadas;
    private boolean tanque_de_gasolina;

    public Condicion_Vehiculo() {
    }

    public Condicion_Vehiculo(boolean espejo_izq_roto, boolean espejo_der_roto, boolean asiento_rot, boolean faro_delantero_funciona, boolean foco_de_stop_funciona, boolean direccional_izq_de_tras, boolean direccional_der_de_tras, boolean cubiertas_golpeadas, boolean tanque_de_gasolina) {
        
        this.espejo_izq_roto = espejo_izq_roto;
        this.espejo_der_roto = espejo_der_roto;
        this.asiento_rot = asiento_rot;
        this.faro_delantero_funciona = faro_delantero_funciona;
        this.foco_de_stop_funciona = foco_de_stop_funciona;
        this.direccional_izq_de_tras = direccional_izq_de_tras;
        this.direccional_der_de_tras = direccional_der_de_tras;
        this.cubiertas_golpeadas = cubiertas_golpeadas;
        this.tanque_de_gasolina = tanque_de_gasolina;
    }
    
    
    /**
     * @return the espejo_izq_roto
     */
    public boolean isEspejo_izq_roto() {
        return espejo_izq_roto;
    }

    /**
     * @param espejo_izq_roto the espejo_izq_roto to set
     */
    public void setEspejo_izq_roto(boolean espejo_izq_roto) {
        this.espejo_izq_roto = espejo_izq_roto;
    }

    /**
     * @return the espejo_der_roto
     */
    public boolean isEspejo_der_roto() {
        return espejo_der_roto;
    }

    /**
     * @param espejo_der_roto the espejo_der_roto to set
     */
    public void setEspejo_der_roto(boolean espejo_der_roto) {
        this.espejo_der_roto = espejo_der_roto;
    }

    /**
     * @return the asiento_rot
     */
    public boolean isAsiento_rot() {
        return asiento_rot;
    }

    /**
     * @param asiento_rot the asiento_rot to set
     */
    public void setAsiento_rot(boolean asiento_rot) {
        this.asiento_rot = asiento_rot;
    }

    /**
     * @return the faro_delantero_funciona
     */
    public boolean isFaro_delantero_funciona() {
        return faro_delantero_funciona;
    }

    /**
     * @param faro_delantero_funciona the faro_delantero_funciona to set
     */
    public void setFaro_delantero_funciona(boolean faro_delantero_funciona) {
        this.faro_delantero_funciona = faro_delantero_funciona;
    }

    /**
     * @return the foco_de_stop_funciona
     */
    public boolean isFoco_de_stop_funciona() {
        return foco_de_stop_funciona;
    }

    /**
     * @param foco_de_stop_funciona the foco_de_stop_funciona to set
     */
    public void setFoco_de_stop_funciona(boolean foco_de_stop_funciona) {
        this.foco_de_stop_funciona = foco_de_stop_funciona;
    }

    /**
     * @return the direccional_izq_de_tras
     */
    public boolean isDireccional_izq_de_tras() {
        return direccional_izq_de_tras;
    }

    /**
     * @param direccional_izq_de_tras the direccional_izq_de_tras to set
     */
    public void setDireccional_izq_de_tras(boolean direccional_izq_de_tras) {
        this.direccional_izq_de_tras = direccional_izq_de_tras;
    }

    /**
     * @return the direccional_der_de_tras
     */
    public boolean isDireccional_der_de_tras() {
        return direccional_der_de_tras;
    }

    /**
     * @param direccional_der_de_tras the direccional_der_de_tras to set
     */
    public void setDireccional_der_de_tras(boolean direccional_der_de_tras) {
        this.direccional_der_de_tras = direccional_der_de_tras;
    }

    /**
     * @return the cubiertas_golpeadas
     */
    public boolean isCubiertas_golpeadas() {
        return cubiertas_golpeadas;
    }

    /**
     * @param cubiertas_golpeadas the cubiertas_golpeadas to set
     */
    public void setCubiertas_golpeadas(boolean cubiertas_golpeadas) {
        this.cubiertas_golpeadas = cubiertas_golpeadas;
    }

    /**
     * @return the tanque_de_gasolina
     */
    public boolean isTanque_de_gasolina() {
        return tanque_de_gasolina;
    }

    /**
     * @param tanque_de_gasolina the tanque_de_gasolina to set
     */
    public void setTanque_de_gasolina(boolean tanque_de_gasolina) {
        this.tanque_de_gasolina = tanque_de_gasolina;
    }
    
}
