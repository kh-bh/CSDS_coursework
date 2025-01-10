import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;
import javafx.scene.layout.HBox;
import javafx.application.Application.Parameters;

public class MexicanTrainGameLogic {
  private LinkedList<Domino> playerHand;
  
  public LinkedList<Domino> dealHand(LinkedList<Domino> deck) {
    playerHand = new LinkedList<Domino>();
    for (int i = 0; i < 12; i++) {
      Domino d = deck.getFirstNode().getElement();
      playerHand.addToEnd(d);
      deck.removeFromFront();
    }
    LLNode<Domino> pl = new LLNode<Domino>(playerHand.getFirstNode().getElement(), null);
    pl = playerHand.getFirstNode();
    for (int i = 0; i != playerHand.length(); i++) {
      System.out.println(pl.getElement().toString());
      pl = pl.getNext();
    }
    return playerHand;
  }
}

