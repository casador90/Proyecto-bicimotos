/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package background;

import com.sun.awt.AWTUtilities;
import javax.swing.JFrame;

/**
 *
 * @author jonatan
 */
public class Transparencia {
    public void TrasparenciaFrame(JFrame frame){
        frame.setUndecorated(true);
        AWTUtilities.setWindowOpaque(frame, false);
    }
}
