package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface PetListener {

  void handleLeftClickEvent();

  void handleRightClickEvent();

  void handleDragEvent(int x, int y);

}
