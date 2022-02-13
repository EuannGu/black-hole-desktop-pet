package model;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Planet {

  private int x;
  private int y;

  public Planet() {
    Dimension screenSize =  Toolkit.getDefaultToolkit().getScreenSize();
    this.x = (int) screenSize.getHeight() / 2 - 96;
    this.y = (int) screenSize.getWidth() / 2 - 96;
  }

  public int getX() {
    int temp = this.x;
    return temp;
  }

  public int getY() {
    int temp = this.y;
    return temp;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void respawn() {
    Dimension screenSize =  Toolkit.getDefaultToolkit().getScreenSize();
    this.x = (int) (Math.random() * screenSize.getWidth());
    this.y = (int) (Math.random() * screenSize.getHeight());
  }

}
