package controller;

/**
 * Listener for planet dragging event.
 */
public interface PlanetListener {

  /**
   * Updates planet location based on where it has been dragged.
   */
  void handlePlanetDragEvent(int x, int y);

}
