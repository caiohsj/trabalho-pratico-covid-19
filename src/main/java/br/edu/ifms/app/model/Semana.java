/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.app.model;

/**
 *
 * @author caioc
 */
public class Semana {
    private int semanaEpi;
    private Long casosNovos;
    
    public Semana(int semanaEpi, Long casosNovos) {
        this.semanaEpi = semanaEpi;
        this.casosNovos = casosNovos;
    }

    public int getSemanaEpi() {
        return semanaEpi;
    }

    public void setSemanaEpi(int semanaEpi) {
        this.semanaEpi = semanaEpi;
    }

    public Long getCasosNovos() {
        return casosNovos;
    }

    public void setCasosNovos(Long casosNovos) {
        this.casosNovos = casosNovos;
    }
    
    
}
