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
  public void handleClickEvent() {
    pet.toggleIdle();
    view.update();
  }

}
