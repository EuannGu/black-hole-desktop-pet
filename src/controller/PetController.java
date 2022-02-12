package controller;

import java.util.Timer;
import java.util.TimerTask;
import model.BlackHolePet;
import model.State;
import view.GUIView;

public class PetController implements PetListener {
  private BlackHolePet pet;
  private GUIView view;

  public PetController() {
    pet = new BlackHolePet();
    view = new GUIView(pet);
  }

  public void go() {
    view.addViewListener(this);

    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        if (pet.getState().equals(State.IDLE) || pet.getState().equals(State.IDLE2)) {
          pet.generateDest();
          pet.setState(State.MOVING);
        }
      }
    }, 0, 10000);
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        if (pet.getState().equals(State.MOVING)) {
          pet.move();
          view.update();
        }
      }
    }, 0, 100);
  }

  @Override
  public void handleLeftClickEvent() {
    pet.toggleIdle();
    view.update();
  }

  @Override
  public void handleRightClickEvent() {
    pet.toggleSleep();
    view.update();
  }

  @Override
  public void handleDragEvent(int x, int y) {
    pet.setX(pet.getX() + x);
    pet.setY(pet.getY() + y);
    view.update();
  }

}
