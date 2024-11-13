/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;

/**
 *
 * @author fatec-dsm2
 */
public class Mapa extends JXMapViewer {
    public Mapa(){
    }
    
    public void init(){
    setTileFactory(new DefaultTileFactory(new OSMTileFactoryInfo("","https://b.tile.openstreetmap.fr/hot/")));
    setAddressLocation(new GeoPosition(-24.49609687511922, -47.846299351792965));
    setZoom(20);
    
    
        MouseInputListener mn = new PanMouseInputListener(this);
        addMouseListener(mn);
        addMouseMotionListener(mn);
        addMouseWheelListener(new ZoomMouseWheelListenerCenter(this));
    }
        
    }

