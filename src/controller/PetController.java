package controller;

import java.util.Timer;
import java.util.TimerTask;
import model.BlackHolePet;
import model.Planet;
import model.State;
import view.GUIView;
import view.PlanetView;

public class PetController implements PetListener, PlanetListener {
  private BlackHolePet pet;
  private GUIView view;
  private Planet planet;
  private PlanetView planetView;

  public PetController() {
    pet = new BlackHolePet();
    view = new GUIView(pet);
    planet = new Planet();
    planetView = new PlanetView(planet);
  }

  public void go() {
    view.addViewListener(this);
    planetView.addViewListener(this);

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

  @Override
  public void handlePlanetDragEvent(int x, int y) {
    planet.setX(planet.getX() + x);
    planet.setY(planet.getY() + y);
    planetView.update();
  }
}
