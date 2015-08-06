/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jonatan
 */
public class Conector {
    public String bd = "bd_bisimotos";
    public String url = "jdbc:mysql://localhost/"+bd;
    public String user = "root";
    public String pass = "";
    Connection link = null;
    public Conector(){}
    /**
     *Conecta la base de datos
     */
/*-------------------------------------------------------------------------------------------------------------------------*/    
/*-------------------------------------------------------------------------------------------------------------------------*/    

    public  void Conectar(){
       try {
                //cargamos el Driver Mysql
                Class.forName("com.mysql.jdbc.Driver");
                //creamos un enlace hacia la base de datos
                link = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);///(Connection) DriverManager.getConnection(this.url, this.user, this.pass);
                if (link!=null) {
                        JOptionPane.showMessageDialog(null, "Se establecio una conexion con la base de datos "+bd);
                 }
        }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de conexion ");
                System.out.println("Error de conexion ");
        }
    }
/*-------------------------------------------------------------------------------------------------------------------------*/    
/*-------------------------------------------------------------------------------------------------------------------------*/    

    /**
     *Desconecta la base de datos 
     */
    public void desconectar(){
        link = null;
        JOptionPane.showMessageDialog(null, " conexion de base de datos "+bd+" desactivada");
    }
/*-------------------------------------------------------------------------------------------------------------------------*/    
/*-------------------------------------------------------------------------------------------------------------------------*/    
    
    public Connection getConexion(){
        return this.link;
    }
/*-------------------------------------------------------------------------------------------------------------------------*/    
/*-------------------------------------------------------------------------------------------------------------------------*/    

/**
*  Metodo para realizar una consulta ala base de datos
* Input:
*      table => nombre de la tabla donde se realiza la consulta
*      fields -> String con los nombre de los capos a devolver
*      where -> condicion para la consulta
* output: un object[][] con los datos resultantes, sino retorno un NULL
*/
    public Object[][] select(String table,String fields,String where){
        int registros =0;
        String colname[]=fields.split(",");
        /*consuta*/
        String consulta1= "SELECT "+fields + " FROM " +table;
        String consulta2= "SELECT count(*) as total From" +table;
        if (where!=null) {
            consulta1+="WHERE "+where;
            consulta2+="WHERE "+where;
        }
        try {
            PreparedStatement pstm = link.prepareStatement(consulta2);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        //se crea una matriz con tantas filas y columnas que necesites
        Object[][] data = new String[registros][fields.split(",").length];
        //relizamos la consulta sql y llenamos los datos en la matriz "Object"
        try {
            PreparedStatement pstm = link.prepareStatement(consulta1);
            ResultSet res = pstm.executeQuery();
            int i =0;
            while (res.next()) {                
                for (int j = 0; j < fields.split(",").length-1; j++) {
                    data[i][j] = res.getString(colname[j].trim());
                    
                }
                i++;
              }
             res.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }
/*-------------------------------------------------------------------------------------------------------------------------*/    
/*-------------------------------------------------------------------------------------------------------------------------*/    
//"INSERT INTO estudiante (Nombre,Apellido_P,Apellido_M,matricula,Sexo,Licenciatura,Grado) VALUES (?,?,?,?,?,?,?)";
    /*Metodo para ingresar un registro*/
    /*table = nombre de la tabla
    fields = String on los nombres de los campons donde insertar ej.: campo1,campo2,campoN....
    values = los datos de los camposa insertar Ej. valor1,valor2,valorN...*/
    
    public boolean insert(String table,String fields,String values){
        boolean res = false;
        //se arma la consulta
        String constulta =" INSERT INTO "+ table + " ( " + fields + " ) VALUES ( " + values + " ) ";
        //se ejecuta la consulta
        try {
            PreparedStatement pstm = link.prepareStatement(constulta);
            pstm.execute();
            pstm.close();
            res = true;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return  res;
    }
/*-------------------------------------------------------------------------------------------------------------------------*/    
/*-------------------------------------------------------------------------------------------------------------------------*/    

    public void Update(String tabla,String valor, String columna,String condicion){
        String update = " UPADTE "+ tabla+" SET "+columna+ "=" +valor+" Where "+condicion;
        try {
            PreparedStatement pstm = link.prepareCall(update);
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
  
}
