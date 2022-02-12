package controller;

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
