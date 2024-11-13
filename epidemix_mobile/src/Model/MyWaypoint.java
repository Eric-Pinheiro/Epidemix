/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

/**
 *
 * @author fatec-dsm2
 */
public class MyWaypoint  extends DefaultWaypoint {
    private String nome;
    private JButton button;
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public MyWaypoint() {
    }

    public MyWaypoint(String nome, GeoPosition coord) {
        super(coord);
        this.nome = nome;
        this.button = button;
    }
    
    private void initButton(){
    button = new ButtonWayPoint();
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
                System.out.println("Click: "+ nome);
        }
    });
    
    }
}
