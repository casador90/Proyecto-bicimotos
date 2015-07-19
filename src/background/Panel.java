/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package background;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author jonatan
 */
public class Panel extends JPanel{
      private Image background;
      
       public void paint(Graphics g){
        int width = this.getSize().width;
        int height = this.getSize().height;
        if (this.background !=null) {
            g.drawImage(this.background, 0, 0, null);
        }
        super.paintComponent(g);
    }
    public void setBackground(String imge){
        this.background = new ImageIcon(imge).getImage();
    }
}
