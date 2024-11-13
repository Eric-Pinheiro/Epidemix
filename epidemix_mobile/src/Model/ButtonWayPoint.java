/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author fatec-dsm2
 */
public class ButtonWayPoint extends JButton{
    public ButtonWayPoint (){
        setContentAreaFilled(false);
        setIcon(new ImageIcon(getClass().getResource("/Icon/2288553.png")));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setSize(new Dimension(24,24));
    
    }
}
