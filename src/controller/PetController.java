package controller;

import model.BlackHolePet;
import view.GUIView;

public class PetController {
  private BlackHolePet pet;
  private GUIView view;

  public PetController() {
    pet = new BlackHolePet();
    view = new GUIView(pet);
  }

  public void go() {

  }

}
