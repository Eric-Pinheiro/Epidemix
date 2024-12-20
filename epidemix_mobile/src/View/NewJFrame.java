/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Conexao;
import Model.HeatmapPainter;
import Model.Localizacao;
import Model.Mapa;
import Model.Registros;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.*;
import org.jxmapviewer.painter.Painter;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.Point2D;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

/**
 *
 * @author fatec-dsm2
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    Registros reg = new Registros();
    Conexao con = new Conexao();
    Mapa mapinha = new Mapa(); 
    
    public NewJFrame() {
        initComponents();
           
        mapa2.init();
         GeoPosition centro = new GeoPosition(-24.49609687511922, -47.846299351792965); // Coordenadas de São Paulo
        mapa2.setAddressLocation(centro);
        mapa2.setZoom(4);

        // Criar o Waypoint e adicioná-lo ao mapa
        // criar um do while com um if a partir do id e dentro do if gerar o codigo de add usando o geoPosition com latitude longitude
         List<Localizacao> listaLocalizacoes = reg.carregarLocalizacoes();

         
        // Cria waypoints a partir das localizações
        Set<Waypoint> waypoints = new HashSet<>();
        for (Localizacao loc : listaLocalizacoes) {
            GeoPosition posicao = new GeoPosition(loc.getLatitude(), loc.getLongitude());
            waypoints.add(new DefaultWaypoint(posicao));
        }
           
           
        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypoints);
HeatmapPainter heatmapPainter = new HeatmapPainter(listaLocalizacoes);

mapa2.setOverlayPainter(heatmapPainter);

        // Adicionar o WaypointPainter ao JXMapViewer
        mapa2.setOverlayPainter(waypointPainter);
 
  class RoutePainter implements Painter<JXMapViewer> {
    private final Set<GeoPosition> waypoints;

    public RoutePainter(Set<GeoPosition> waypoints) {
        this.waypoints = waypoints;
    }

    @Override
    public void paint(Graphics2D g, JXMapViewer map, int width, int height) {
        // Ajusta as coordenadas para o sistema de coordenadas do mapa
        g = (Graphics2D) g.create();
        g.setColor(Color.RED);
        g.setStroke(new BasicStroke(2));

        // Converte GeoPositions em pontos no mapa
        List<Point2D> points = new ArrayList<>();
        for (GeoPosition waypoint : waypoints) {
            Point2D point = map.getTileFactory().geoToPixel(waypoint, map.getZoom());
            points.add(point);
        }

        // Desenha as linhas conectando os pontos
        for (int i = 0; i < points.size() - 1; i++) {
            Point2D from = points.get(i);
            Point2D to = points.get(i + 1);
            g.drawLine((int) from.getX(), (int) from.getY(), (int) to.getX(), (int) to.getY());
        }

        g.dispose();
    }
}

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapa2 = new Model.Mapa();
        txtLongitude = new javax.swing.JTextField();
        txtLatitude = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mapa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapa2MouseClicked(evt);
            }
        });

        txtLongitude.setText("jTextField1");

        txtLatitude.setText("jTextField2");

        javax.swing.GroupLayout mapa2Layout = new javax.swing.GroupLayout(mapa2);
        mapa2.setLayout(mapa2Layout);
        mapa2Layout.setHorizontalGroup(
            mapa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapa2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(mapa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(316, Short.MAX_VALUE))
        );
        mapa2Layout.setVerticalGroup(
            mapa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapa2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(txtLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(txtLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mapa2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mapa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mapa2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapa2MouseClicked
     
        // TODO add your handling code here:
  Point2D pontoPixel = evt.getPoint();

        // Converte o ponto em pixels para uma coordenada geográfica
        GeoPosition geoPos = mapa2.getTileFactory().pixelToGeo(pontoPixel, mapa2.getZoom());

        // Exibe a latitude e a longitude no console ou use conforme necessário
        System.out.println("Latitude: " + geoPos.getLatitude() + ", Longitude: " + geoPos.getLongitude());
txtLatitude.setText(""+ geoPos.getLatitude());
txtLongitude.setText(""+geoPos.getLongitude());
    }//GEN-LAST:event_mapa2MouseClicked

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Model.Mapa mapa2;
    private javax.swing.JTextField txtLatitude;
    private javax.swing.JTextField txtLongitude;
    // End of variables declaration//GEN-END:variables
}
