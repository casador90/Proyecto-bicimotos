/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package background;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jonatanLara
 */
public class BuscarImage {
   // JLabel jlabel;
    String ruta;
    boolean abieto;
    public void BuscarImagen(JLabel jlabel){
        abieto = false;
        int w =jlabel.getWidth();
        int h =jlabel.getHeight();
        JFileChooser buscar = new JFileChooser();
        FileNameExtensionFilter nombre = new FileNameExtensionFilter("Solo archivos Imagen","jpg","png");
        buscar.setFileFilter(nombre);
        if (buscar.showOpenDialog(jlabel)==JFileChooser.APPROVE_OPTION) {
            abieto = true;
            Toolkit tk = Toolkit.getDefaultToolkit();
            ruta = buscar.getSelectedFile().toString();
            Image image = tk.createImage(ruta);
            jlabel.setIcon(new ImageIcon(image.getScaledInstance(w, h, Image.SCALE_AREA_AVERAGING)));
        }
    
    }
    public boolean getAbierto(){
        //System.out.println("abierto"+abieto);
        return abieto;
    }
    public String urlDeImagen()
    {
    return ruta;
    }
}
