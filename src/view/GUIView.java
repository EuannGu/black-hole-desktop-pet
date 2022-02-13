package view;

import controller.PetListener;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import model.BlackHolePet;
import model.State;
import java.time.LocalTime;

/**
 * A view for the desktop pet.
 */
public class GUIView extends JFrame {
  private BlackHolePet pet;
  private ArrayList<PetListener> listeners;

  // gifs
  private final String PATH_IDLE = "res/idle.gif";
  private final String PATH_IDLE2 = "res/idle2.gif";
  private final String PATH_SQUIRM = "res/squirm.gif";
  private final String PATH_SLEEP = "res/sleep.gif";
  private final String PATH_EAT = "res/eat.gif";

  private JLabel label;
  private ImageIcon icon;
  private boolean drag;

  private ArrayList<String> comments;

  /**
   * Creates a {@code GuiView} instance.
   */
  public GUIView(BlackHolePet pet) {
    this.pet = pet;
    this.listeners = new ArrayList<>();
    this.drag = false;

    this.comments = new ArrayList<>();
    comments.add("I like your outfit!");
    comments.add("The time is " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
    comments.add("My name is Inky :D");
    comments.add("Don't get too close!");
    comments.add("I like eating rocks :D");
    comments.add("I do not like eating gas giants");
    comments.add("I spinny");
    comments.add("I’m dizzy");
    comments.add("You are doing great!");
    comments.add("You are out of this world!");
    comments.add("You’re a bringer of Jollity!");
    comments.add("!! HackBeanpot !!");
    comments.add("I was born in BeanTown");
    comments.add("Make sure to rest!");
    comments.add("I take naps regularly");
    comments.add("You matter!");
    comments.add("-3-");
    char semicolon = '\u003B';
    char parentheses = '\u0029';
    comments.add(Character.toString(semicolon) + Character.toString(parentheses));

    // create and set up a window
    setTitle("inky");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame is transparent
    setUndecorated(true); // cancel window title bar
    setBackground(new Color(0, 0, 0, 0)); // background is transparent
    setBounds(pet.getX(), pet.getY(), 80, 80);
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
        pet.setState(State.DRAGGED);
        icon.getImage().flush();
        icon = new ImageIcon(PATH_SQUIRM);
        label.setIcon(icon);
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        drag = false;
        pet.setState(State.IDLE);
        icon.getImage().flush();
        icon = new ImageIcon(PATH_IDLE);
        label.setIcon(icon);
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        label.setToolTipText(comments.get((int) (Math.random() * (comments.size()))));
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

  /**
   * Add a listener to this view.
   */
  public void addViewListener(PetListener listener) {
    this.listeners.add(listener);
  }

  /**
   * Gets the path to the gif corresponding to the given state.
   */
  private String getPath(State state) {
    switch (state) {
      case IDLE:
        return PATH_IDLE;
      case IDLE2:
        return PATH_IDLE2;
      case SLEEP:
        return PATH_SLEEP;
      case EATING:
        return PATH_EAT;
      default:
        return "";
    }
  }

  /**
   * Updates this view with image icon if applicable and location.
   */
  public void update() {
    if (!drag && !(pet.getState().equals(State.MOVING))) {
      icon.getImage().flush();
      icon = new ImageIcon(getPath(pet.getState()));
      label.setIcon(icon);
    }
    setLocation(pet.getX(), pet.getY());
  }

  /**
   * Makes the pet show the eating gif once and then return to idle.
   */
  public void eat() {
    toFront();
    update();
    try {
      Thread.sleep(2400);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    pet.setState(State.IDLE);
  }
}