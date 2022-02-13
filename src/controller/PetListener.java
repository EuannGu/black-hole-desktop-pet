package controller;

/**
 * This interface contains all the behaviors that a listener to a GUI should support for a pet
 * listener.
 */
public interface PetListener {

  /**
   * Toggles spin direction on left click.
   */
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
