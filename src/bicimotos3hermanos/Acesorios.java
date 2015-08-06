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
public class Acesorios {
    
    private boolean claxon;
    private boolean tapon_de_aceite;
    private boolean tapon_de_radiador;
    private boolean filtro_de_aire;
    private boolean bateria;
    private boolean llaves;
    private String observacion;
    private String nivel_de_aceite;
    private String nivel_de_gasolina;

    public Acesorios() {
    }

    public Acesorios(boolean claxon, boolean tapon_de_aceite, boolean tapon_de_radiador, boolean filtro_de_aire, boolean bateria, boolean llaves, String observacion, String nivel_de_aceite, String nivel_de_gasolina) {
        this.claxon = claxon;
        this.tapon_de_aceite = tapon_de_aceite;
        this.tapon_de_radiador = tapon_de_radiador;
        this.filtro_de_aire = filtro_de_aire;
        this.bateria = bateria;
        this.llaves = llaves;
        this.observacion = observacion;
        this.nivel_de_aceite = nivel_de_aceite;
        this.nivel_de_gasolina = nivel_de_gasolina;
    }
    
    
    /**
     * @return the claxon
     */
    public boolean isClaxon() {
        return claxon;
    }

    /**
     * @param claxon the claxon to set
     */
    public void setClaxon(boolean claxon) {
        this.claxon = claxon;
    }

    /**
     * @return the tapon_de_aceite
     */
    public boolean isTapon_de_aceite() {
        return tapon_de_aceite;
    }

    /**
     * @param tapon_de_aceite the tapon_de_aceite to set
     */
    public void setTapon_de_aceite(boolean tapon_de_aceite) {
        this.tapon_de_aceite = tapon_de_aceite;
    }

    /**
     * @return the tapon_de_radiador
     */
    public boolean isTapon_de_radiador() {
        return tapon_de_radiador;
    }

    /**
     * @param tapon_de_radiador the tapon_de_radiador to set
     */
    public void setTapon_de_radiador(boolean tapon_de_radiador) {
        this.tapon_de_radiador = tapon_de_radiador;
    }

    /**
     * @return the filtro_de_aire
     */
    public boolean isFiltro_de_aire() {
        return filtro_de_aire;
    }

    /**
     * @param filtro_de_aire the filtro_de_aire to set
     */
    public void setFiltro_de_aire(boolean filtro_de_aire) {
        this.filtro_de_aire = filtro_de_aire;
    }

    /**
     * @return the bateria
     */
    public boolean isBateria() {
        return bateria;
    }

    /**
     * @param bateria the bateria to set
     */
    public void setBateria(boolean bateria) {
        this.bateria = bateria;
    }

    /**
     * @return the llaves
     */
    public boolean isLlaves() {
        return llaves;
    }

    /**
     * @param llaves the llaves to set
     */
    public void setLlaves(boolean llaves) {
        this.llaves = llaves;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * @return the nivel_de_aceite
     */
    public String getNivel_de_aceite() {
        return nivel_de_aceite;
    }

    /**
     * @param nivel_de_aceite the nivel_de_aceite to set
     */
    public void setNivel_de_aceite(String nivel_de_aceite) {
        this.nivel_de_aceite = nivel_de_aceite;
    }

    /**
     * @return the nivel_de_gasolina
     */
    public String getNivel_de_gasolina() {
        return nivel_de_gasolina;
    }

    /**
     * @param nivel_de_gasolina the nivel_de_gasolina to set
     */
    public void setNivel_de_gasolina(String nivel_de_gasolina) {
        this.nivel_de_gasolina = nivel_de_gasolina;
    }
    
}
