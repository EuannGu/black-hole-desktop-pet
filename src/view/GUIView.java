package view;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.BlackHolePet;

public class GUIView extends JFrame {
  private BlackHolePet pet;

  // gifs
  private final String PATH_IDLE = "res/idle.gif";

  private JLabel label;

  /**
   * Creates a {@code GuiView} instance.
   */
  public GUIView(BlackHolePet pet) {
    this.pet = pet;
    // create and set up a window
    setTitle("supermassive");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame is transparent
    setUndecorated(true); // cancel window title bar
    setBackground(new Color(0, 0, 0, 0)); // background is transparent
    setBounds(pet.getX(), pet.getY(), 192, 192);
    setAlwaysOnTop(true);

    Icon icon = new ImageIcon(PATH_IDLE);
    label = new JLabel(icon);
    getContentPane().add(label);

    // show
    pack();
    setVisible(true);
  }
}
