package model;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * An edible celestial body with an x and y position.
 */
public class Planet {

  private int x;
  private int y;

  /**
   * Creates a planet in the middle of your screen.
   */
  public Planet() {
    Dimension screenSize =  Toolkit.getDefaultToolkit().getScreenSize();
    this.x = (int) screenSize.getHeight() / 2 - 96;
    this.y = (int) screenSize.getWidth() / 2 - 96;
  }

  /**
   * Returns the x position of this planet.
   */
  public int getX() {
    int temp = this.x;
    return temp;
  }

  /**
   * Returns the y position of this planet
   */
  public int getY() {
    int temp = this.y;
    return temp;
  }

  /**
   * Sets the x position of this planet.
   * @param x the x position to change to.
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Sets the y position of this planet.
   * @param y the y position to change to.
   */
  public void setY(int y) {
    this.y = y;
  }

  /**
   * Spawns a new planet at a random place on your screen.
   */
  public void respawn() {
    Dimension screenSize =  Toolkit.getDefaultToolkit().getScreenSize();
    this.x = (int) (Math.random() * (screenSize.getWidth() - 50));
    this.y = (int) (Math.random() * (screenSize.getHeight() - 50));
  }

}
