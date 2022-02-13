package view;

import controller.PlanetListener;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Planet;

public class PlanetView extends JFrame {

  private Planet planet;

  private final String PATH = "res/planet.png";

  private JLabel label;
  private ImageIcon icon;
  private boolean drag;
  private ArrayList<PlanetListener> listeners;

  public PlanetView(Planet planet) {
    this.planet = planet;

    this.listeners = new ArrayList<>();
    this.drag = false;

    // create and set up a window
    setTitle("planet");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame is transparent
    setUndecorated(true); // cancel window title bar
    setBackground(new Color(0, 0, 0, 0)); // background is transparent
    setBounds(planet.getX(), planet.getY(), 80, 80);
    setAlwaysOnTop(true);

    icon = new ImageIcon(PATH);
    label = new JLabel(icon);
    getContentPane().add(label);

    label.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
      }

      @Override
      public void mousePressed(MouseEvent e) {
        drag = true;
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        drag = false;
      }

      @Override
      public void mouseEntered(MouseEvent e) {
      }

      @Override
      public void mouseExited(MouseEvent e) {
      }
    });

    label.addMouseMotionListener(new MouseMotionListener() {
      @Override
      public void mouseDragged(MouseEvent e) {
        if (drag) {
          for (PlanetListener l : listeners) {
            l.handlePlanetDragEvent(e.getX(), e.getY());
          }
        }
      }

      @Override
      public void mouseMoved(MouseEvent e) {

      }
    });

    // show
    pack();
    setVisible(true);
  }

  public void addViewListener(PlanetListener listener) {
    this.listeners.add(listener);
  }

  public void update() {
    setLocation(planet.getX(), planet.getY());
  }
}
