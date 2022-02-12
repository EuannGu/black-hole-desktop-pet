package view;

import controller.PetListener;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import model.BlackHolePet;
import model.State;

public class GUIView extends JFrame {
  private BlackHolePet pet;
  private ArrayList<PetListener> listeners;

  // gifs
  private final String PATH_IDLE = "res/idle.gif";
  private final String PATH_IDLE2 = "res/idle2.gif";
  private final String PATH_SQUIRM = "res/squirm.gif";
  private final String PATH_SLEEP = "res/sleep.gif";

  private JLabel label;
  private ImageIcon icon;
  private boolean drag;

  /**
   * Creates a {@code GuiView} instance.
   */
  public GUIView(BlackHolePet pet) {
    this.pet = pet;
    this.listeners = new ArrayList<>();
    this.drag = false;
    // create and set up a window
    setTitle("supermassive");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame is transparent
    setUndecorated(true); // cancel window title bar
    setBackground(new Color(0, 0, 0, 0)); // background is transparent
    setBounds(pet.getX(), pet.getY(), 192, 192);
    setAlwaysOnTop(true);

    icon = new ImageIcon(PATH_IDLE);
    label = new JLabel(icon);
    getContentPane().add(label);

    label.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        for (PetListener l : listeners) {
          if (SwingUtilities.isLeftMouseButton(e)) {
            l.handleLeftClickEvent();
          }
          else {
            l.handleRightClickEvent();
          }
        }
      }

      @Override
      public void mousePressed(MouseEvent e) {
        drag = true;
        icon.getImage().flush();
        icon = new ImageIcon(PATH_SQUIRM);
        label.setIcon(icon);
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        drag = false;
        update();
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
          for (PetListener l : listeners) {
            l.handleDragEvent(e.getX(), e.getY());
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

  public void addViewListener(PetListener listener) {
    this.listeners.add(listener);
  }

  private String getPath(State state) {
    switch (state) {
      case IDLE:
        return PATH_IDLE;
      case IDLE2:
        return PATH_IDLE2;
      case SLEEP:
        return PATH_SLEEP;
      default:
        return "";
    }
  }

  public void update() {
    if (!drag) {
      icon.getImage().flush();
      icon = new ImageIcon(getPath(pet.getState()));
      label.setIcon(icon);
    }
    setLocation(pet.getX(), pet.getY());
  }
}