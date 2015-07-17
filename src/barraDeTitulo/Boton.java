/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barraDeTitulo;

import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author jonatan
 */
public class Boton extends JLabel{
    JLabel label;
    
    public Boton(final String ruta,final String ruta2,final String ruta3){
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMouseClicked(evt);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label1MouseEntered(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelMouseExited(evt);
            }

            private void labelMouseClicked(MouseEvent evt) {
                 label.setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta)));
            }

            private void label1MouseEntered(MouseEvent evt) {
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta2)));
            }

            private void labelMouseExited(MouseEvent evt) {
                 label.setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta3)));
            }
        });
    }
    
}
