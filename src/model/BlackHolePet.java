package model;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A desktop pet with a position, change in position at any time, and a state.
 */
public class BlackHolePet {
  private int x;
  private int y;
  private int dx; //destination x and y
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

  public State getState() {
    return this.state;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setState(State state) {
    this.state = state;
  }

  /**
   * Toggles the pet from awake to asleep or vice versa.
   */
  public void toggleSleep() {
    if (state.equals(State.SLEEP)) {
      this.state = State.IDLE;
    }
    else {
      this.state = State.SLEEP;
      this.dx = 0;
      this.dy = 0;
    }
  }

  /**
   * Toggles the pet from one idle to another.
   */
  public void toggleIdle() {
    if (state.equals(State.IDLE)) {
      this.state = State.IDLE2;
    }
    else if (state.equals(State.IDLE2)) {
      this.state = State.IDLE;
    }
  }

  /**
   * Generates a random destination on the screen.
   */
  public void generateDest() {
    dx = (int) (Math.random() * this.screenWidth);
    dy = (int) (Math.random() * this.screenHeight);
  }

  /**
   * Moves the pet one step closer to dx and dy.
   */
  public void move() {
    if (dx == 0 && dy == 0) {
      this.state = State.IDLE;
      return;
    }
    if (x < dx) {
      x++;
    }
    else if (x > dx) {
      x--;
    }
    if (y < dy) {
      y++;
    }
    else if (y > dy) {
      y--;
    }
    if (x == dx && y == dy) {
      dx = 0;
      dy = 0;
    }
  }
}
