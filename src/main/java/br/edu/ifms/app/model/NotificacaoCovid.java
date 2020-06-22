/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.app.model;

import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author caioc
 */
@Entity
public class NotificacaoCovid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estado;
    private String regiao;
    private String municipio;
    private int codUf;
    private int codMun;
    private int codRegiaoSaude;
    private String nomeRegiaoSaude;
    private Date data;
    private int semanaEpi;
    private Long populacaoTCU2019;
    private Long casosAcumulados;
    private Long casosNovos;
    private Long obitosAcumulados;
    private Long obitosNovos;
    private Long recuperadosNovos;
    private Long emAcompanhamentoNovos;
    
    public NotificacaoCovid() {}
    
    public NotificacaoCovid (int semanaEpi, Long casosNovos) {
        this.semanaEpi = semanaEpi;
        this.casosNovos = casosNovos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getCodUf() {
        return codUf;
    }

    public void setCodUf(int codUf) {
        this.codUf = codUf;
    }

    public int getCodMun() {
        return codMun;
    }

    public void setCodMun(int codMun) {
        this.codMun = codMun;
    }

    public int getCodRegiaoSaude() {
        return codRegiaoSaude;
    }

    public void setCodRegiaoSaude(int codRegiaoSaude) {
        this.codRegiaoSaude = codRegiaoSaude;
    }

    public String getNomeRegiaoSaude() {
        return nomeRegiaoSaude;
    }

    public void setNomeRegiaoSaude(String nomeRegiaoSaude) {
        this.nomeRegiaoSaude = nomeRegiaoSaude;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getSemanaEpi() {
        return semanaEpi;
    }

    public void setSemanaEpi(int semanaEpi) {
        this.semanaEpi = semanaEpi;
    }

    public Long getPopulacaoTCU2019() {
        return populacaoTCU2019;
    }

    public void setPopulacaoTCU2019(Long populacaoTCU2019) {
        this.populacaoTCU2019 = populacaoTCU2019;
    }

    public Long getCasosAcumulados() {
        return casosAcumulados;
    }

    public void setCasosAcumulados(Long casosAcumulados) {
        this.casosAcumulados = casosAcumulados;
    }

    public Long getCasosNovos() {
        return casosNovos;
    }

    public void setCasosNovos(Long casosNovos) {
        this.casosNovos = casosNovos;
    }

    public Long getObitosAcumulados() {
        return obitosAcumulados;
    }

    public void setObitosAcumulados(Long obitosAcumulados) {
        this.obitosAcumulados = obitosAcumulados;
    }

    public Long getObitosNovos() {
        return obitosNovos;
    }

    public void setObitosNovos(Long obitosNovos) {
        this.obitosNovos = obitosNovos;
    }

    public Long getRecuperadosNovos() {
        return recuperadosNovos;
    }

    public void setRecuperadosNovos(Long recuperadosNovos) {
        this.recuperadosNovos = recuperadosNovos;
    }

    public Long getEmAcompanhamentoNovos() {
        return emAcompanhamentoNovos;
    }

    public void setEmAcompanhamentoNovos(Long emAcompanhamentoNovos) {
        this.emAcompanhamentoNovos = emAcompanhamentoNovos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
