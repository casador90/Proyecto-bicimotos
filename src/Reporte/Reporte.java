/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reporte;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jonatan
 */
public class Reporte {
    public Reporte(){}
    
    public void GenerarReporte(int orden, String fecha, String hora,String equipo,
            String serie, String motor,String kilometro, String placas,String observaciones,
            String nombre,String direccion, String ciudad,String rfc, String telefono){
        
       JasperReport reporte;
       JasperPrint reporte_view;
        try {
            //direccion donde esta el archivo jasper
            URL in = this.getClass().getResource("/reports/reporte.jasper");
            reporte = (JasperReport) JRLoader.loadObject(in);
            Map parametros = new HashMap();
            
            //parametros de entrada.
            parametros.put("Orden", orden);
            parametros.put("Fecha", "Campeche, Camp., a "+fecha);
            parametros.put("Hora", hora);
            parametros.put("Equipo", equipo);
            parametros.put("Serie", serie);
            parametros.put("Motor", motor);
            parametros.put("Kilometro", kilometro);
            parametros.put("Placas", placas);
            parametros.put("Observaciones", observaciones);
            parametros.put("Nombre", nombre);
            parametros.put("Direccion", direccion);
            parametros.put("Ciudad", ciudad);
            parametros.put("Rfc", rfc);
            parametros.put("Telefono", telefono);
            reporte_view = JasperFillManager.fillReport(reporte, parametros,new JREmptyDataSource());
            JasperViewer view = new JasperViewer(reporte_view, false);
            view.setTitle(nombre);
            view.setVisible(true);
            
         //   JasperViewer.viewReport(reporte_view,false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
