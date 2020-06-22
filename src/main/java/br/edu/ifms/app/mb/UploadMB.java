/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.app.mb;

import br.edu.ifms.app.model.NotificacaoCovid;
import br.edu.ifms.app.model.Semana;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.DateFormatter;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author caioc
 */
@ManagedBean
@ViewScoped
public class UploadMB {

    private BarChartModel model;
    private UploadedFile file;
    private EntityManagerFactory emf;
    private EntityManager entityManager;

    @PostConstruct
    public void inicializar() {
        inicializarEntityManager();
        inicializarChartModel();
        inicializarSeries();
    }

    public void inicializarEntityManager() {
        emf = Persistence.createEntityManagerFactory("trabalho-pu");
        entityManager = emf.createEntityManager();
    }

    public void inicializarChartModel() {
        model = new BarChartModel();
        model.getAxis(AxisType.Y).setLabel("Casos Novos");
        model.getAxis(AxisType.X).setLabel("Semana Epidemiológica");
        model.setTitle("Casos Novos de COVID-19 por Semana Epidemiológica de Notificação");
    }

    public void inicializarSeries() {
        List<Object[]> notificacoes = entityManager.createQuery("SELECT n.semanaEpi, SUM(n.casosNovos) FROM NotificacaoCovid n GROUP BY n.semanaEpi").getResultList();
        HashMap<String, ChartSeries> seriesMap = new HashMap();
        ChartSeries series = new ChartSeries("Casos");
        for (Object[] object: notificacoes) {
            series.set(String.valueOf(object[0]), (Number) object[1]);
        }
        model.addSeries(series);
    }

    public void upload() {
        try {
            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            BufferedReader br = new BufferedReader(reader);
            String linha;
            br.readLine();
            String[] campos;
            entityManager.getTransaction().begin();
            NotificacaoCovid notificacao;
            Date data;
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            while (br.ready()) {
                linha = br.readLine();
                campos = linha.split(";");
                notificacao = new NotificacaoCovid();
                notificacao.setRegiao(campos[0]);
                //notificacao.setEstado(campos[1]);
                //notificacao.setMunicipio(campos[2]);
                notificacao.setCodUf(Integer.parseInt(campos[3]));
                //notificacao.setCodMun(Integer.parseInt(campos[4]));
                //notificacao.setCodRegiaoSaude(Integer.parseInt(campos[5]));
                //notificacao.setNomeRegiaoSaude(campos[6]);
                try {
                    notificacao.setData(df.parse(campos[7]));
                } catch (ParseException ex) {
                    Logger.getLogger(UploadMB.class.getName()).log(Level.SEVERE, null, ex);
                }
                notificacao.setSemanaEpi(Integer.parseInt(campos[8]));
                notificacao.setPopulacaoTCU2019(new Long(campos[9]));
                notificacao.setCasosAcumulados(new Long(campos[10]));
                notificacao.setCasosNovos(new Long(campos[11]));
                notificacao.setObitosAcumulados(new Long(campos[12]));
                notificacao.setObitosNovos(new Long(campos[13]));
                //notificacao.setRecuperadosNovos(new Long(campos[14]));
                //notificacao.setEmAcompanhamentoNovos(new Long(campos[15]));
                entityManager.persist(notificacao);
            }
            entityManager.getTransaction().commit();

        } catch (IOException ex) {
            Logger.getLogger(UploadMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        inicializarChartModel();
        inicializarSeries();
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public BarChartModel getModel() {
        return model;
    }

    public void setModel(BarChartModel model) {
        this.model = model;
    }

}
