package controller;

public interface PetListener {

  void handleLeftClickEvent();

  /**
   * Makes pet sleep on right click.
   */
  void handleRightClickEvent();

  /**
   * Updates pet location based on where it has been dragged.
   */
  void handleDragEvent(int x, int y);

}
