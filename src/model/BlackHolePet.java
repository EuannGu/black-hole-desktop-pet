package model;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A desktop pet with a position, change in position at any time, and a state.
 */
public class BlackHolePet {
  private int x;
  private int y;
  private int dx;
  private int dy;
  private State state;

  private final double screenHeight;
  private final double screenWidth;

  /**
   * Creates an idle BlackHoldPet in the middle of the screen and initializes other values to zero.
   */
  public BlackHolePet() {
    Dimension screenSize =  Toolkit.getDefaultToolkit().getScreenSize();
    this.screenHeight = screenSize.getHeight();
    this.screenWidth = screenSize.getWidth();
    this.x = (int) screenWidth / 2 - 96;
    this.y = (int) screenHeight / 2 - 96;
    this.dx = 0;
    this.dy = 0;
    this.state = State.IDLE;
  }

  public int getX() {
    int temp = this.x;
    return temp;
  }

  public int getY() {
    int temp = this.y;
    return temp;
  }
}
