/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicimotos3hermanos;

import background.Background;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import static java.awt.Frame.ICONIFIED;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author jonatan
 */
public class MainFrom extends javax.swing.JFrame {

    /**
     * Creates new form MainFrom
     */
    private Background background = new Background("/background/fondo2.png");
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private boolean b = true;
    private int x, y;
    private Color colorActual;
    private JMenuItem Aj,mn,cer;
    private JPopupMenu menu;
    
    public MainFrom() {
        setUndecorated(true);
        setContentPane(background);
        initComponents();
        CursorHand();
        System.out.println("tu resolucion es " + screenSize.width + "x" + screenSize.height);
        this.setSize(screenSize.width, screenSize.height);
        Panel.setBackground(new Color(0, 0, 0, 10));
        //Panel.setLocation(0, 0);//setSize(822, 749);
        barraTitulo.setBackground(new Color(204,204,204));
        colorActual=barraTitulo.getBackground();
        eventos();
        MenuPanel();
        menu = new JPopupMenu();
        Aj= new JMenuItem();
        mn= new JMenuItem();
        cer= new JMenuItem();
    }
    
    public void CursorHand() {
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btMinimizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btAjustar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btMenuPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    public void eventos(){
         btCerrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cerrar();
            }
        });
        
         btAjustar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Ajustar();
            }
        });
         btMinimizar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Minimizar();
            }
        });
          btCliente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                registros reg = new registros();
                int witdh = Panel.getWidth();
                int height = Panel.getHeight();
                Panel.setLayout(new BorderLayout());//Panel.setSize(822, 749);
                reg.setPreferredSize(new Dimension(witdh, height));
                Panel.add("Center", reg);
                Panel.updateUI();
                Panel.validate();
            }
        });
       
        
    }
    public void cerrar() {
        System.exit(0);
    }

    public void Ajustar() {
        if (b) {
                    setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
                    b = false;
                } else {
                    setSize(900,650);
                    setLocationRelativeTo(null);
                    b = true;
                }
    }

    public void Minimizar() {
        setExtendedState(ICONIFIED);

                if (b == false) {
                    setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
                    b = false;
                } else {        
                    setSize(screenSize);
                    b = true;
                }
    }
    public void MenuPanel(){
       
         btMenuPanel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Minimizar_Azul.png")));
                mn.addActionListener(new ActionListener() {

                @Override
                 public void actionPerformed(ActionEvent e) {
                 Minimizar();
                }
                });
                mn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menu.add(mn);
                Aj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/ajustar_Azul.png")));
                Aj.addActionListener(new ActionListener() {

                 @Override
                  public void actionPerformed(ActionEvent e) {
                  Ajustar();
                 }
                 });
                Aj.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menu.add(Aj);
                cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Cerrar_Rojo.png")));
                cer.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                cerrar();
                }
                });
                cer.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menu.add(cer);
                Component b = (Component)e.getSource();
                Point p=b.getLocationOnScreen();
                 
                menu.show(btMenuPanel, 0, 20);
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraTitulo = new javax.swing.JPanel();
        btMinimizar = new javax.swing.JButton();
        btAjustar = new javax.swing.JButton();
        btCerrar = new javax.swing.JButton();
        btMenuPanel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btCliente = new javax.swing.JButton();
        Panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        barraTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraTituloMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                barraTituloMouseReleased(evt);
            }
        });
        barraTitulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraTituloMouseDragged(evt);
            }
        });

        btMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Minimizar_Gris.png"))); // NOI18N
        btMinimizar.setBorderPainted(false);
        btMinimizar.setContentAreaFilled(false);
        btMinimizar.setFocusPainted(false);
        btMinimizar.setFocusable(false);
        btMinimizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btMinimizar.setPreferredSize(new java.awt.Dimension(20, 20));
        btMinimizar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Minimizar_Verde.png"))); // NOI18N
        btMinimizar.setRequestFocusEnabled(false);
        btMinimizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Minimizar_Azul.png"))); // NOI18N

        btAjustar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/ajustar_Gris.png"))); // NOI18N
        btAjustar.setBorderPainted(false);
        btAjustar.setContentAreaFilled(false);
        btAjustar.setFocusPainted(false);
        btAjustar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAjustar.setPreferredSize(new java.awt.Dimension(20, 20));
        btAjustar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/ajustar_Verde.png"))); // NOI18N
        btAjustar.setRequestFocusEnabled(false);
        btAjustar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/ajustar_Azul.png"))); // NOI18N

        btCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Cerrar_gris.png"))); // NOI18N
        btCerrar.setBorderPainted(false);
        btCerrar.setContentAreaFilled(false);
        btCerrar.setFocusPainted(false);
        btCerrar.setFocusable(false);
        btCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCerrar.setPreferredSize(new java.awt.Dimension(20, 20));
        btCerrar.setRequestFocusEnabled(false);
        btCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Cerrar_Rojo.png"))); // NOI18N

        btMenuPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Maximizar_Gris.png"))); // NOI18N
        btMenuPanel.setBorderPainted(false);
        btMenuPanel.setContentAreaFilled(false);
        btMenuPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btMenuPanel.setFocusPainted(false);
        btMenuPanel.setFocusable(false);
        btMenuPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        btMenuPanel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Maximizar_verde.png"))); // NOI18N
        btMenuPanel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Maximizar_Azul.png"))); // NOI18N

        javax.swing.GroupLayout barraTituloLayout = new javax.swing.GroupLayout(barraTitulo);
        barraTitulo.setLayout(barraTituloLayout);
        barraTituloLayout.setHorizontalGroup(
            barraTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraTituloLayout.createSequentialGroup()
                .addComponent(btMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAjustar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        barraTituloLayout.setVerticalGroup(
            barraTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(barraTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btMinimizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btAjustar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_1_50.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setIconTextGap(1);
        jButton1.setInheritsPopupMenu(true);
        jButton1.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_1 - copia.png"))); // NOI18N
        jButton1.setRequestFocusEnabled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_1.png"))); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_2 - copia - copia.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setIconTextGap(1);
        jButton2.setInheritsPopupMenu(true);
        jButton2.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_2 - copia.png"))); // NOI18N
        jButton2.setRequestFocusEnabled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_2.png"))); // NOI18N

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_3 - copia - copia.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setIconTextGap(1);
        jButton3.setInheritsPopupMenu(true);
        jButton3.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_3 - copia.png"))); // NOI18N
        jButton3.setRequestFocusEnabled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_3.png"))); // NOI18N

        btCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_7 - copia - copia.png"))); // NOI18N
        btCliente.setBorderPainted(false);
        btCliente.setContentAreaFilled(false);
        btCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btCliente.setFocusPainted(false);
        btCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCliente.setIconTextGap(1);
        btCliente.setInheritsPopupMenu(true);
        btCliente.setPreferredSize(new java.awt.Dimension(70, 70));
        btCliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_7 - copia.png"))); // NOI18N
        btCliente.setRequestFocusEnabled(false);
        btCliente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_7.png"))); // NOI18N

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(barraTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 89, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barraTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraTituloMousePressed
         x = evt.getX();
        y = evt.getY();
        this.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        barraTitulo.setBackground(new Color(75,144,189));
        btMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Minimizar_Verde.png")));
        btAjustar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/ajustar_Verde.png")));
        btMenuPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Maximizar_verde.png")));
        btCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Cerrar_Rojo.png")));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_1.png")));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_2.png")));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_3.png")));
        btCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_7.png")));
    }//GEN-LAST:event_barraTituloMousePressed

    private void barraTituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraTituloMouseDragged
       Point point = MouseInfo.getPointerInfo().getLocation(); 
       this.setLocation(point.x - x, point.y - y); 
    }//GEN-LAST:event_barraTituloMouseDragged

    private void barraTituloMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraTituloMouseReleased
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        barraTitulo.setBackground(colorActual);
        btMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Minimizar_Gris.png")));
        btAjustar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/ajustar_Gris.png")));
        btMenuPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Maximizar_Gris.png")));
        btCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_vent/Cerrar_gris.png")));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_1_50.png")));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_2 - copia - copia.png")));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_3 - copia - copia.png")));
        btCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/her_7 - copia - copia.png")));
    }//GEN-LAST:event_barraTituloMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel barraTitulo;
    private javax.swing.JButton btAjustar;
    private javax.swing.JButton btCerrar;
    private javax.swing.JButton btCliente;
    private javax.swing.JButton btMenuPanel;
    private javax.swing.JButton btMinimizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    
}
