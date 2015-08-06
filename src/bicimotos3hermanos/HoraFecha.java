/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicimotos3hermanos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author jonatan
 */
public class HoraFecha {
    String meses[] ={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    String dias[]={"Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sabado"};
    Calendar cale = new GregorianCalendar();
    
    public HoraFecha(){
        
    }
    public String getFecha(){
        int dia = cale.get(Calendar.DAY_OF_MONTH);
        int diaSemana = cale.get(Calendar.DAY_OF_WEEK);
        int mes = cale.get(Calendar.MONTH);
        int ano = cale.get(Calendar.YEAR);
        String fecha = dias[diaSemana-1]+", "+dia+" de "+meses[mes]+" de "+ano;
        return fecha;
    }
    public String getHora(){
        int seguundo = cale.get(Calendar.SECOND);
        int minuto = cale.get(Calendar.MINUTE);
        int hora = cale.get(Calendar.HOUR_OF_DAY);
        String HORA = "Hora "+ hora+":"+minuto+":"+seguundo;
        return HORA;
    }
    public String getHoraFecha(){
        int dia = cale.get(Calendar.DAY_OF_MONTH);
        int diaSemana = cale.get(Calendar.DAY_OF_WEEK);
        int mes = cale.get(Calendar.MONTH);
        int ano = cale.get(Calendar.YEAR);
        int seguundo = cale.get(Calendar.SECOND);
        int minuto = cale.get(Calendar.MINUTE);
        int hora = cale.get(Calendar.HOUR_OF_DAY);
        String fechayfecha = dias[diaSemana-1]+". "+dia+" de "+meses[mes]+" de "+ano+" Hora "+ hora+":"+minuto+":"+seguundo;
        return fechayfecha;
    }
    
}
