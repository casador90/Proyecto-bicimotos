/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicimotos3hermanos;


import Conection.Conector;
import Reporte.Reporte;
import background.BuscarImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author Mario
 */
public class registros extends JPanel {

    private Datos dato;
    private Veiculo vehiculo;
    private Servicio Servicio;
    private CargaDeDatos carga;
    private JLabel fondo = new JLabel(new ImageIcon(getClass().getResource("/background/fondo_p_1.png")));
    private HoraFecha hF;
    public registros() {
        initComponents();
        fondo.setBounds(0, 0,830, 700);
        this.add(fondo);
        texAreaObservaciones.setLineWrap(true);
        hF= new HoraFecha();
        txtCiudad.setText("San Francisco de Campeche");
        txtCorrero.setText("example@gmail.com");
        txtEntrada.setText(hF.getHoraFecha());
        verificacionNumeros(txtTelefono);
        verificacionMayusculas(txtCliente);
        verificacionMayusculas(txtDireccion);
        verificacionMayusculas(txtCiudad);
        todoMayusculas(txtRFC);
        soloTelefono(txtTelefono);
        panelDatosCliente.setOpaque(false);
        panelVehiculo.setOpaque(false);
        panelServicio.setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        btCargarFoto.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
               //new SplashCargando().setVisible(true);
                BuscarImage buscar = new BuscarImage();
                buscar.BuscarImagen(labelFoto);
                buscar.getAbierto();
                if (buscar.getAbierto()==true) {
                    btCargarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Photo_green.png")));
                }
            }
        });
        jButton3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               Data();
               Reporte reporte = new Reporte();
               reporte.GenerarReporte(1, hF.getFecha(), hF.getHora(),vehiculo.getEquipo(),vehiculo.getSerie(),
                       vehiculo.getMotor(),vehiculo.getKilometrage(),vehiculo.getPlacas(),Servicio.getObservaciones()
                       ,dato.getNombre(),dato.getDireccion(),dato.getCiudad(),dato.getRfc(),dato.getTel());
            }
        });
        
    }
    
    public void Data(){
        dato = new Datos(txtCliente.getText(), txtTelefono.getText(), txtCorrero.getText(),txtDireccion.getText() ,txtCiudad.getText(), txtRFC.getText());
        vehiculo = new Veiculo(txtSerie.getText(), txtMotor.getText(), txtPlacas.getText(), txtkilom.getText(), txtEquipo.getText());
        Servicio = new  Servicio(txtServicio.getText(),txtEntrada.getText(),txtSalida.getText(),texAreaObservaciones.getText());
        Double presio  = Double.parseDouble(txtPresio.getText());
        Servicio.setPrecio(presio);
        Acesorios  acesorio = new  Acesorios(chClaxon.isSelected(),chTapon_de_Aceite.isSelected(),chTapon_de_radiador.isSelected(),chFiltro_De_aire.isSelected(),chBateria.isSelected(),chLlaves.isSelected(),"",txtAceite.getText(),txtGasolina.getText());
        
//Servicio.setObservaciones(texAreaObservaciones.getText());
    }
    
    public void verificacionNumeros(JTextField textField){
        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
            char caracter = e.getKeyChar();
            
                if (Character.isLetter(caracter)) {//solo letras isDigit(caracter)
                    getToolkit().beep();
                    e.consume();//no me deja escribir
                }
                
            }
    });
    }
    
    public void soloTelefono(final JTextField textField){
        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
             int limite = 10;
             if (textField.getText().length()==limite) {
                    getToolkit().beep();
                    e.consume();
                }
             if (textField.getText().length()==1) {
                    lbnut.setIcon(new  javax.swing.ImageIcon(getClass().getResource("/Icons/Nut_Rojo.png")));
                }
             if (textField.getText().length()==6) {
                   lbnut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Nut_Amarillo.png"))); 
                }
             if (textField.getText().length()==9) {
                   lbnut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Nut_Verde.png"))); 
                }
                
            }
    });
    }
    
    public void verificacionMayusculas(final JTextField textField){
        textField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e){
                String sCadena= textField.getText();
                String sTitulo = primeraMayuscula(sCadena);
                textField.setText(sTitulo);
            }
    });
    }
    
    /**
     *evento 
     */
    public void todoMayusculas(final JTextField textField){
        textField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e){
                UpperCase(textField);
            }
    });
    }
    
    /**
    *metodo para convertir a mayusculas
    */
    public void UpperCase(JTextField textfield){
        String cadena =  (textfield.getText()).toUpperCase();
        textfield.setText(cadena);
    }
    
    public static String primeraMayuscula(String cadena){
        if (cadena==null||cadena.length()==0) {
            return cadena;
        }
        char[] caracteres = cadena.toCharArray();
        caracteres[0] = Character.toUpperCase(caracteres[0]);
        for (int i = 0; i < cadena.length()-2; i++) 
            if (caracteres[i]==' '||caracteres[i]==','||caracteres[i]=='.') 
                caracteres[i+1]= Character.toUpperCase(caracteres[i+1]);
         return new String (caracteres);
    }
    
    
   public void ingresarDatosClientes(){
       Conector con = new Conector();
       Connection reg = con.getConexion();
       String sql;
       sql = "INSERT INTO clientes (nombre,direccion,RFC,telefono,correo,ciudad) VALUES (?,?,?,?,?,?)";
       try {
           PreparedStatement pst = reg.prepareStatement(sql);
           pst.setString(1, dato.getNombre());
            pst.setString(2, dato.getDireccion());
            pst.setString(3, dato.getRfc());
            pst.setString(4, dato.getTel());
            pst.setString(5, dato.getCorreo());
            pst.setString(6, dato.getCiudad());
            
            int n = pst.executeUpdate();
             if (n>0) {
                 System.out.println("Se agrergaron los datos a la tabla clientes");
            }
       } catch (Exception e) {
       }
      // con.insert("clientes", "nombre,direccion,RFC,telefono,correo,ciudad", TOOL_TIP_TEXT_KEY);
       
   }
   public void ingresarDatosVehiculo(){
       Conector con = new Conector();
       Connection reg = con.getConexion();
       String sql;
       sql = "INSERT INTO vehiculo (serie,placas,motor,kilometraje,equipo) VALUES (?,?,?,?,?)";
       try {
           PreparedStatement pst = reg.prepareStatement(sql);
            pst.setString(1, vehiculo.getSerie());
            pst.setString(2, vehiculo.getPlacas());
            pst.setString(3, vehiculo.getMotor());
            pst.setString(4, vehiculo.getKilometrage());
            pst.setString(5, vehiculo.getEquipo());
            
            int n = pst.executeUpdate();
             if (n>0) {
                 System.out.println("Se agrergaron los datos a la tabla vehiculo");
            }
       } catch (Exception e) {
       }
   }
   public void ingresarDatosServicio(){
       Conector con = new Conector();
       Connection reg = con.getConexion();
       String sql;
       sql = "INSERT INTO servicio (servicio,entrada,salida,presio,observaciones) VALUES (?,?,?,?,?)";
       try {
           PreparedStatement pst = reg.prepareStatement(sql);
            pst.setString(1, Servicio.getServicio());
            pst.setString(2, Servicio.getEntrada());
            pst.setString(3, Servicio.getSalida());
            pst.setDouble(4, Servicio.getPrecio());
            pst.setString(5, Servicio.getObservaciones());
            
            int n = pst.executeUpdate();
             if (n>0) {
                 System.out.println("Se agrergaron los datos a la tabla Servicio");
            }
       } catch (Exception e) {
       }
   }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatosCliente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorrero = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        lbnut = new javax.swing.JLabel();
        panelVehiculo = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMotor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEquipo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPlacas = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtkilom = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lbOrden = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btClausula = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        labelFoto = new javax.swing.JLabel();
        btCargarFoto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelServicio = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtServicio = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtSalida = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtPresio = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        texAreaObservaciones = new javax.swing.JTextArea();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        chClaxon = new javax.swing.JCheckBox();
        chTapon_de_Aceite = new javax.swing.JCheckBox();
        chTapon_de_radiador = new javax.swing.JCheckBox();
        chFiltro_De_aire = new javax.swing.JCheckBox();
        chBateria = new javax.swing.JCheckBox();
        chLlaves = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtAceite = new javax.swing.JTextField();
        txtGasolina = new javax.swing.JTextField();

        panelDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), java.awt.Color.white)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Cliente:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Telefono:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Direccion:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Correo:");

        txtCorrero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreroActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("RFC:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Ciudad:");

        lbnut.setPreferredSize(new java.awt.Dimension(24, 24));

        javax.swing.GroupLayout panelDatosClienteLayout = new javax.swing.GroupLayout(panelDatosCliente);
        panelDatosCliente.setLayout(panelDatosClienteLayout);
        panelDatosClienteLayout.setHorizontalGroup(
            panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliente))
                            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCorrero, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbnut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(98, 98, 98))
        );
        panelDatosClienteLayout.setVerticalGroup(
            panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbnut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorrero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        panelVehiculo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Vehículo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), java.awt.Color.white)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Serie:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Motor:");

        txtMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMotorActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Equipo");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Placas:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Kilometraje:");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setText("Orden de servicio NO.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(lbOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelVehiculoLayout = new javax.swing.GroupLayout(panelVehiculo);
        panelVehiculo.setLayout(panelVehiculoLayout);
        panelVehiculoLayout.setHorizontalGroup(
            panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVehiculoLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelVehiculoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(124, 124, 124)
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMotor, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkilom, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        panelVehiculoLayout.setVerticalGroup(
            panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVehiculoLayout.createSequentialGroup()
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVehiculoLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelVehiculoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtkilom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelVehiculoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de entrada del taller");

        btClausula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/contrato_grey.png"))); // NOI18N
        btClausula.setBorderPainted(false);
        btClausula.setContentAreaFilled(false);
        btClausula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btClausula.setFocusPainted(false);
        btClausula.setFocusable(false);
        btClausula.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btClausula.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/contrata_green.png"))); // NOI18N
        btClausula.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/contrato_blue.png"))); // NOI18N

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Print_black.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Print_green.png"))); // NOI18N
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Print_blue.png"))); // NOI18N

        labelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelFoto.setFocusable(false);
        labelFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btCargarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Photo_grey.png"))); // NOI18N
        btCargarFoto.setBorderPainted(false);
        btCargarFoto.setContentAreaFilled(false);
        btCargarFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCargarFoto.setFocusPainted(false);
        btCargarFoto.setFocusable(false);
        btCargarFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCargarFoto.setPreferredSize(new java.awt.Dimension(32, 32));
        btCargarFoto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Photo_green.png"))); // NOI18N
        btCargarFoto.setRequestFocusEnabled(false);
        btCargarFoto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Photo_blue.png"))); // NOI18N

        jScrollPane2.setOpaque(false);

        panelServicio.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Vehículo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), java.awt.Color.white)); // NOI18N
        panelServicio.setOpaque(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Servicio:");

        txtServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServicioActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Entrada:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Salida:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Precio Aproximado:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Observaciones");

        texAreaObservaciones.setColumns(20);
        texAreaObservaciones.setRows(5);
        jScrollPane1.setViewportView(texAreaObservaciones);

        jCheckBox1.setText("ESPEJO IZQ");
        jCheckBox1.setContentAreaFilled(false);
        jCheckBox1.setFocusPainted(false);
        jCheckBox1.setRequestFocusEnabled(false);
        jCheckBox1.setRolloverEnabled(false);

        jCheckBox2.setText("ESPEJO DER");
        jCheckBox2.setContentAreaFilled(false);
        jCheckBox2.setFocusPainted(false);
        jCheckBox2.setRequestFocusEnabled(false);
        jCheckBox2.setRolloverEnabled(false);

        jCheckBox3.setText("ASIENTO");
        jCheckBox3.setContentAreaFilled(false);
        jCheckBox3.setFocusPainted(false);
        jCheckBox3.setRequestFocusEnabled(false);
        jCheckBox3.setRolloverEnabled(false);

        jCheckBox4.setText("FARO DELANTERO");
        jCheckBox4.setContentAreaFilled(false);
        jCheckBox4.setFocusPainted(false);
        jCheckBox4.setRequestFocusEnabled(false);
        jCheckBox4.setRolloverEnabled(false);

        jCheckBox5.setText("LUZ DE FRENO TRASERO");
        jCheckBox5.setContentAreaFilled(false);
        jCheckBox5.setFocusPainted(false);
        jCheckBox5.setRequestFocusEnabled(false);
        jCheckBox5.setRolloverEnabled(false);

        jCheckBox6.setText("DIRECCIONAL IZQ. DELANT");
        jCheckBox6.setContentAreaFilled(false);
        jCheckBox6.setFocusPainted(false);
        jCheckBox6.setRequestFocusEnabled(false);
        jCheckBox6.setRolloverEnabled(false);

        jCheckBox7.setText("DIRECCIONAL DER. DELANT");
        jCheckBox7.setContentAreaFilled(false);
        jCheckBox7.setFocusPainted(false);
        jCheckBox7.setRequestFocusEnabled(false);
        jCheckBox7.setRolloverEnabled(false);

        jCheckBox8.setText("DIRECCIONAL IZQ. TRAS.");
        jCheckBox8.setContentAreaFilled(false);
        jCheckBox8.setFocusPainted(false);
        jCheckBox8.setRequestFocusEnabled(false);
        jCheckBox8.setRolloverEnabled(false);

        jCheckBox9.setText("DIRECCIONAL DER. TRAS.");
        jCheckBox9.setContentAreaFilled(false);
        jCheckBox9.setFocusPainted(false);
        jCheckBox9.setRequestFocusEnabled(false);
        jCheckBox9.setRolloverEnabled(false);

        jCheckBox10.setText("CUBIERTAS COMPLETAS");
        jCheckBox10.setContentAreaFilled(false);
        jCheckBox10.setFocusPainted(false);
        jCheckBox10.setRequestFocusEnabled(false);
        jCheckBox10.setRolloverEnabled(false);

        jCheckBox11.setText("TAPON DE GASOLINA.");
        jCheckBox11.setContentAreaFilled(false);
        jCheckBox11.setFocusPainted(false);
        jCheckBox11.setRequestFocusEnabled(false);
        jCheckBox11.setRolloverEnabled(false);

        jCheckBox12.setText("ESPEJO IZQ ROTO");
        jCheckBox12.setContentAreaFilled(false);
        jCheckBox12.setFocusPainted(false);
        jCheckBox12.setRequestFocusEnabled(false);
        jCheckBox12.setRolloverEnabled(false);

        jCheckBox13.setText("ESPEJO DER ROTO");
        jCheckBox13.setContentAreaFilled(false);
        jCheckBox13.setFocusPainted(false);
        jCheckBox13.setRequestFocusEnabled(false);
        jCheckBox13.setRolloverEnabled(false);

        jCheckBox14.setText("ASIENTO ROTO");
        jCheckBox14.setContentAreaFilled(false);
        jCheckBox14.setFocusPainted(false);
        jCheckBox14.setRequestFocusEnabled(false);
        jCheckBox14.setRolloverEnabled(false);

        jCheckBox15.setText("FARO DELANTERO FUNCIONA");
        jCheckBox15.setContentAreaFilled(false);
        jCheckBox15.setFocusPainted(false);
        jCheckBox15.setRequestFocusEnabled(false);
        jCheckBox15.setRolloverEnabled(false);

        jCheckBox16.setText("FOCO DE STOP FUNCIONA");
        jCheckBox16.setContentAreaFilled(false);
        jCheckBox16.setFocusPainted(false);
        jCheckBox16.setRequestFocusEnabled(false);
        jCheckBox16.setRolloverEnabled(false);

        jCheckBox17.setText("DIRECCIONAL IQZ. DELANT. FUNCIONA");
        jCheckBox17.setContentAreaFilled(false);
        jCheckBox17.setFocusPainted(false);
        jCheckBox17.setRequestFocusEnabled(false);
        jCheckBox17.setRolloverEnabled(false);

        jCheckBox18.setText("DIRECCINAL DER. DELANT. TRAS. FUNCIONA");
        jCheckBox18.setContentAreaFilled(false);
        jCheckBox18.setFocusPainted(false);
        jCheckBox18.setRequestFocusEnabled(false);
        jCheckBox18.setRolloverEnabled(false);

        jCheckBox19.setText("CUBIERTAS GOLPEADAS O DAÑADAS");
        jCheckBox19.setContentAreaFilled(false);
        jCheckBox19.setFocusPainted(false);
        jCheckBox19.setRequestFocusEnabled(false);
        jCheckBox19.setRolloverEnabled(false);

        jCheckBox20.setText("TANQUE DE GASOLINA GOLPEADO");
        jCheckBox20.setContentAreaFilled(false);
        jCheckBox20.setFocusPainted(false);
        jCheckBox20.setRequestFocusEnabled(false);
        jCheckBox20.setRolloverEnabled(false);

        chClaxon.setText("CLAXON");
        chClaxon.setContentAreaFilled(false);
        chClaxon.setFocusPainted(false);
        chClaxon.setRequestFocusEnabled(false);
        chClaxon.setRolloverEnabled(false);

        chTapon_de_Aceite.setText("TAPON DE ACEITE");
        chTapon_de_Aceite.setContentAreaFilled(false);
        chTapon_de_Aceite.setFocusPainted(false);
        chTapon_de_Aceite.setRequestFocusEnabled(false);
        chTapon_de_Aceite.setRolloverEnabled(false);

        chTapon_de_radiador.setText("TAPON DE RADIADOR");
        chTapon_de_radiador.setContentAreaFilled(false);
        chTapon_de_radiador.setFocusPainted(false);
        chTapon_de_radiador.setRequestFocusEnabled(false);
        chTapon_de_radiador.setRolloverEnabled(false);

        chFiltro_De_aire.setText("FILTRO DE AIRE");
        chFiltro_De_aire.setContentAreaFilled(false);
        chFiltro_De_aire.setFocusPainted(false);
        chFiltro_De_aire.setRequestFocusEnabled(false);
        chFiltro_De_aire.setRolloverEnabled(false);

        chBateria.setText("BATERIA");
        chBateria.setContentAreaFilled(false);
        chBateria.setFocusPainted(false);
        chBateria.setRequestFocusEnabled(false);
        chBateria.setRolloverEnabled(false);

        chLlaves.setText("LLAVES");
        chLlaves.setContentAreaFilled(false);
        chLlaves.setFocusPainted(false);
        chLlaves.setRequestFocusEnabled(false);
        chLlaves.setRolloverEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Nivel de aceite:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Nivel de gasolina:");

        javax.swing.GroupLayout panelServicioLayout = new javax.swing.GroupLayout(panelServicio);
        panelServicio.setLayout(panelServicioLayout);
        panelServicioLayout.setHorizontalGroup(
            panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServicioLayout.createSequentialGroup()
                .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelServicioLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelServicioLayout.createSequentialGroup()
                                .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(152, 152, 152)
                                .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelServicioLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel21))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelServicioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox7)
                            .addComponent(jCheckBox8))
                        .addGap(86, 86, 86)
                        .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox12)
                            .addComponent(jCheckBox15)
                            .addComponent(jCheckBox14)
                            .addComponent(jCheckBox13)
                            .addComponent(jCheckBox17)
                            .addComponent(jCheckBox19)
                            .addComponent(jCheckBox18)
                            .addComponent(jCheckBox20)
                            .addComponent(jCheckBox16))
                        .addGap(24, 24, 24)
                        .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chClaxon)
                            .addComponent(chTapon_de_Aceite)
                            .addComponent(chTapon_de_radiador)
                            .addComponent(chFiltro_De_aire)
                            .addComponent(chBateria)
                            .addComponent(chLlaves)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelServicioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelServicioLayout.createSequentialGroup()
                                .addComponent(jCheckBox9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelServicioLayout.createSequentialGroup()
                                .addComponent(jCheckBox10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel23))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelServicioLayout.createSequentialGroup()
                                .addComponent(jCheckBox11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
                                .addComponent(jLabel20)))
                        .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelServicioLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txtPresio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelServicioLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGasolina, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAceite, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        panelServicioLayout.setVerticalGroup(
            panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServicioLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelServicioLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelServicioLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelServicioLayout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelServicioLayout.createSequentialGroup()
                                .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelServicioLayout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(1, 1, 1)
                        .addComponent(jCheckBox2)
                        .addGap(1, 1, 1)
                        .addComponent(jCheckBox3)
                        .addGap(1, 1, 1)
                        .addComponent(jCheckBox4)
                        .addGap(1, 1, 1)
                        .addComponent(jCheckBox5)
                        .addGap(1, 1, 1)
                        .addComponent(jCheckBox6)
                        .addGap(1, 1, 1)
                        .addComponent(jCheckBox7)
                        .addGap(1, 1, 1)
                        .addComponent(jCheckBox8))
                    .addGroup(panelServicioLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelServicioLayout.createSequentialGroup()
                                .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox12)
                                    .addGroup(panelServicioLayout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jCheckBox15))
                                    .addGroup(panelServicioLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jCheckBox14))
                                    .addGroup(panelServicioLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jCheckBox13)))
                                .addGap(18, 18, 18)
                                .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox17)
                                    .addGroup(panelServicioLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jCheckBox19))
                                    .addGroup(panelServicioLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jCheckBox18))
                                    .addGroup(panelServicioLayout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jCheckBox20))))
                            .addGroup(panelServicioLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jCheckBox16))))
                    .addGroup(panelServicioLayout.createSequentialGroup()
                        .addComponent(chClaxon)
                        .addGap(1, 1, 1)
                        .addComponent(chTapon_de_Aceite)
                        .addGap(1, 1, 1)
                        .addComponent(chTapon_de_radiador)
                        .addGap(1, 1, 1)
                        .addComponent(chFiltro_De_aire)
                        .addGap(1, 1, 1)
                        .addComponent(chBateria)
                        .addGap(1, 1, 1)
                        .addComponent(chLlaves)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelServicioLayout.createSequentialGroup()
                        .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox9)
                            .addComponent(jLabel22))
                        .addGap(1, 1, 1)
                        .addComponent(jCheckBox10)
                        .addGap(1, 1, 1)
                        .addComponent(jCheckBox11))
                    .addGroup(panelServicioLayout.createSequentialGroup()
                        .addComponent(txtAceite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtGasolina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(txtPresio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(panelServicio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(labelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btCargarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btClausula, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(panelVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jLabel1)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCargarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btClausula))
                    .addComponent(labelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreroActionPerformed

    private void txtMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMotorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMotorActionPerformed

    private void txtServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCargarFoto;
    private javax.swing.JButton btClausula;
    private javax.swing.JCheckBox chBateria;
    private javax.swing.JCheckBox chClaxon;
    private javax.swing.JCheckBox chFiltro_De_aire;
    private javax.swing.JCheckBox chLlaves;
    private javax.swing.JCheckBox chTapon_de_Aceite;
    private javax.swing.JCheckBox chTapon_de_radiador;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JLabel lbOrden;
    private javax.swing.JLabel lbnut;
    private javax.swing.JPanel panelDatosCliente;
    private javax.swing.JPanel panelServicio;
    private javax.swing.JPanel panelVehiculo;
    private javax.swing.JTextArea texAreaObservaciones;
    private javax.swing.JTextField txtAceite;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCorrero;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtEquipo;
    private javax.swing.JTextField txtGasolina;
    private javax.swing.JTextField txtMotor;
    private javax.swing.JTextField txtPlacas;
    private javax.swing.JTextField txtPresio;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtSalida;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtServicio;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtkilom;
    // End of variables declaration//GEN-END:variables
}
