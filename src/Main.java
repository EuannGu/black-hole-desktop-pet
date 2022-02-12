import controller.PetController;
import java.net.MalformedURLException;
import model.BlackHolePet;

public class Main {

  /**
   * Runs a black hold pet instance.
   */
  public static void main(String[] args) {
    PetController controller = new PetController();
    controller.go();
  }

}
