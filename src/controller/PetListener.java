package controller;

public interface PetListener {

  void handleLeftClickEvent();

  void handleRightClickEvent();

  void handleDragEvent(int x, int y);

}
