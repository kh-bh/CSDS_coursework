/**@author Bhoomika Khatri */
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
import javafx.scene.layout.VBox;
import javafx.scene.layout.Region;
import javafx.scene.control.Label;
import javafx.application.Application.Parameters;
import javafx.scene.layout.GridPane;

public class MexicanTrainGame extends Application {
  
  /**
   * A field that makes a button that represents two players
   */
  private Button twoPlayer;
  /**
   * A field that makes a button that represents three players
   */
  private Button threePlayer;
  /**
   * A field that makes a button that represents four players
   */
  private Button fourPlayer;
  
  /**
   * A field that makes a button that represents Add on the mexican train
   */
  private Button addToMTrain = new Button("Add");
  /**
   * A field that makes a button that represents Add on the 1st player
   */
  private Button addTo1Train = new Button("Add");
  /**
   * A field that makes a button that represents Add on the 2nd player
   */
  private Button addTo2Train = new Button("Add");
  /**
   * A field that makes a button that represents Add on the 3rd player
   */
  private Button addTo3Train = new Button("Add");
  /**
   * A field that makes a button that represents Add on the 4th player
   */
  private Button addTo4Train = new Button("Add");
  
  /**
   * A field that makes a button that represents draw on the player 1
   */
  private Button addToTrain1;
  /**
   * A field that makes a button that represents draw on the player 2
   */
  private Button addToTrain2;
  /**
   * A field that makes a button that represents draw on the player 3
   */
  private Button addToTrain3;
  /**
   * A field that makes a button that represents draw on the player 4
   */
  private Button addToTrain4;
  
  /**
   * A field that makes a new deck of cards
   */
  private DominoArray da = new DominoArray(0,0,9);
  /**
   * A field that makes a new deck of cards in a linked list
   */
  private LinkedList<Domino> dL = da.createArrayList();
  
  /**
   * A field that makes a new stage for player 1
   */
  private Stage player1 = new Stage();
  /**
   * A field that makes a new stage for player 2
   */
  private Stage player2 = new Stage();
  /**
   * A field that makes a new stage for player 3
   */
  private Stage player3 = new Stage();
  /**
   * A field that makes a new stage for player 4
   */
  private Stage player4 = new Stage();
  
  /**
   * A field that makes a new label for player 1's train
   */
  private Label player1Train = new Label("Player 1's Train: ");
  /**
   * A field that makes a new label for player 2's train
   */
  private Label player2Train = new Label("Player 2's Train: ");
  /**
   * A field that makes a new label for player 3's train
   */
  private Label player3Train = new Label("Player 3's Train: ");
  /**
   * A field that makes a new label for player 4's train
   */
  private Label player4Train = new Label("Player 4's Train: ");
  /**
   * A field that makes a new label for mexican train
   */
  private Label mexicanTrain = new Label("Mexican Train: ");
  
  /**
   * A field that makes a new stage for the button to choose how many players
   */
  private Stage buttonForPlayers = new Stage();
  
  /**
   * A field that makes figures how many players
   */
  private int players = 0;
  
  /**
   * A field that stores the 1st players linked list
   */
  private LinkedList<Domino> p1dominos;

  /**
   * A field that stores the 2nd players linked list
   */
  private LinkedList<Domino> p2dominos;
  
  /**
   * A field that stores the 3rd players linked list
   */
  private LinkedList<Domino> p3dominos;
  
  /**
   * A field that stores the 4st players linked list
   */
  private LinkedList<Domino> p4dominos;
  
  /**
   * @param primaryStage the main window of the GUI
   */
  public void start(Stage primaryStage) {
    // layout manager for how many players are playing
    BorderPane layout = new BorderPane();
    twoPlayer = new Button("Click for a Two Player Game");
    threePlayer = new Button("Click for a Three Player Game");
    fourPlayer = new Button("Click for a Four Player Game");
    layout.setTop(twoPlayer);
    layout.setCenter(threePlayer);
    layout.setBottom(fourPlayer);
    MyButtonAction myAction = new MyButtonAction();
    twoPlayer.setOnAction(myAction);
    threePlayer.setOnAction(myAction);
    fourPlayer.setOnAction(myAction);
    
    int p = Integer.parseInt(this.getParameters().getRaw().get(0));
    
    MexicanTrainGameLogic gl = new MexicanTrainGameLogic();
    
    if (p == 2) 
      players = 2;
    else if (p == 3)
      players = 3;
    else if (p >= 4)
      players = 4;
    else
      players = 2;
    System.out.println(players);
    Scene scene = new Scene(layout);
    
    buttonForPlayers.setScene(scene);
    buttonForPlayers.show();
    
    // put the layout manager into the window
    HBox mbox = new HBox();
    HBox p1box = new HBox();
    HBox p2box = new HBox();
    HBox p3box = new HBox();
    HBox p4box = new HBox();
    
    VBox vb = new VBox();
    
    if (players == 2){ 
      mbox.getChildren().addAll(mexicanTrain, addToMTrain);
      p1box.getChildren().addAll(player1Train, addTo1Train);
      p1dominos = gl.dealHand(dL);
      
      p2box.getChildren().addAll(player2Train, addTo2Train);
      vb.getChildren().addAll(mbox,p1box,p2box);
      p2dominos = gl.dealHand(dL);
      
    }
    if (players == 3){ 
      mbox.getChildren().addAll(mexicanTrain, addToMTrain);
      p1box.getChildren().addAll(player1Train, addTo1Train);
      p1dominos = gl.dealHand(dL);
      p2box.getChildren().addAll(player2Train, addTo2Train);
      p2dominos = gl.dealHand(dL);
      p3box.getChildren().addAll(player3Train, addTo3Train);
      p3dominos = gl.dealHand(dL);
      vb.getChildren().addAll(mbox,p1box,p2box,p3box);
    }
    if (players == 4){ 
      mbox.getChildren().addAll(mexicanTrain, addToMTrain);
      p1dominos = gl.dealHand(dL);
      p1box.getChildren().addAll(player1Train, addTo1Train);
      p2dominos = gl.dealHand(dL);
      p2box.getChildren().addAll(player2Train, addTo2Train);
      p3dominos = gl.dealHand(dL);
      p3box.getChildren().addAll(player3Train, addTo3Train);
      p4dominos = gl.dealHand(dL);
      p4box.getChildren().addAll(player4Train, addTo4Train);
      vb.getChildren().addAll(mbox,p1box,p2box,p3box,p4box);
    }
    
    Scene sceneTrain = new Scene(vb);
    
    primaryStage.setScene(sceneTrain);
    primaryStage.show();
  }
  
  /**
   * Start the GUI
   * @param args the command line arguments are currently ignored
   */
  public static void main(String[] args) {
    Application.launch(args);
  }
  
  /** When a button is clicked, this will call for the correct amount of players */
  private class MyButtonAction implements EventHandler<ActionEvent> {
    
    /**
     * The action is to display the stages for players
     * @param e information about the click event
     */
    public void handle(ActionEvent e) {
      Button b = (Button)e.getSource();
      

      
      // This determines the amount of players!
      if (b == twoPlayer){
        HBox p1box = new HBox();
        VBox layout1 = new VBox();
        Scene scene1 = new Scene(layout1);
        addToTrain1 = new Button("Draw");
        Label label1 = new Label("Player 1's Hand:");
        
        LLNode<Domino> p1 = new LLNode<Domino>(p1dominos.getFirstNode().getElement(), null);
        p1 = p1dominos.getFirstNode();
        for (int i = 0; i != p1dominos.length(); i++) {
          Button tempB = new Button(p1.getElement().toString());
          p1box.getChildren().addAll(tempB);
          p1 = p1.getNext();
        }
        layout1.getChildren().addAll(label1, p1box, addToTrain1);
        
        HBox p2box = new HBox();
        VBox layout2 = new VBox();
        Scene scene2 = new Scene(layout2);
        addToTrain2 = new Button("Draw");
        Label label2 = new Label("Player 2's Hand:");
        
        LLNode<Domino> p2 = new LLNode<Domino>(p2dominos.getFirstNode().getElement(), null);
        p2 = p2dominos.getFirstNode();
        for (int i = 0; i != p2dominos.length(); i++) {
          Button tempB = new Button(p2.getElement().toString());
          p2box.getChildren().addAll(tempB);
          p2 = p2.getNext();
        }
        layout2.getChildren().addAll(label2, p2box, addToTrain2);
        
        players = 2;
        player1.setScene(scene1);
        player1.show();
        player1.setTitle("Player 1");
        
        player2.setScene(scene2);
        player2.show();
        player2.setTitle("Player 2");
        buttonForPlayers.hide();
      }
      if (b == threePlayer) {
        HBox p1box = new HBox();
        VBox layout1 = new VBox();
        Scene scene1 = new Scene(layout1);
        addToTrain1 = new Button("Draw");
        Label label1 = new Label("Player 1's Hand:");
        
        LLNode<Domino> p1 = new LLNode<Domino>(p1dominos.getFirstNode().getElement(), null);
        p1 = p1dominos.getFirstNode();
        for (int i = 0; i != p1dominos.length(); i++) {
          Button tempB = new Button(p1.getElement().toString());
          p1box.getChildren().addAll(tempB);
          p1 = p1.getNext();
        }
        layout1.getChildren().addAll(label1, p1box, addToTrain1);
        
        HBox p2box = new HBox();
        VBox layout2 = new VBox();
        Scene scene2 = new Scene(layout2);
        addToTrain2 = new Button("Draw");
        Label label2 = new Label("Player 2's Hand:");
        
        LLNode<Domino> p2 = new LLNode<Domino>(p2dominos.getFirstNode().getElement(), null);
        p2 = p2dominos.getFirstNode();
        for (int i = 0; i != p2dominos.length(); i++) {
          Button tempB = new Button(p2.getElement().toString());
          p2box.getChildren().addAll(tempB);
          p2 = p2.getNext();
        }
        layout2.getChildren().addAll(label2, p2box, addToTrain2);
        
        HBox p3box = new HBox();
        VBox layout3 = new VBox();
        Scene scene3 = new Scene(layout3);
        addToTrain3 = new Button("Draw");
        Label label3 = new Label("Player 3's Hand:");
        
        LLNode<Domino> p3 = new LLNode<Domino>(p3dominos.getFirstNode().getElement(), null);
        p3 = p3dominos.getFirstNode();
        for (int i = 0; i != p3dominos.length(); i++) {
          Button tempB = new Button(p3.getElement().toString());
          p3box.getChildren().addAll(tempB);
          p3 = p3.getNext();
        }
        layout3.getChildren().addAll(label3, p3box, addToTrain3);
        
        players = 3;
        player1.setScene(scene1);
        player1.show();
        player1.setTitle("Player 1");
        
        player2.setScene(scene2);
        player2.show();
        player2.setTitle("Player 2");
        buttonForPlayers.hide();
        
        player3.setScene(scene3);
        player3.show();
        player3.setTitle("Player 3");
      }
      if (b == fourPlayer) {
        HBox p1box = new HBox();
        VBox layout1 = new VBox();
        Scene scene1 = new Scene(layout1);
        addToTrain1 = new Button("Draw");
        Label label1 = new Label("Player 1's Hand:");
        
        LLNode<Domino> p1 = new LLNode<Domino>(p1dominos.getFirstNode().getElement(), null);
        p1 = p1dominos.getFirstNode();
        for (int i = 0; i != p1dominos.length(); i++) {
          Button tempB = new Button(p1.getElement().toString());
          p1box.getChildren().addAll(tempB);
          p1 = p1.getNext();
        }
        layout1.getChildren().addAll(label1, p1box, addToTrain1);
        
        HBox p2box = new HBox();
        VBox layout2 = new VBox();
        Scene scene2 = new Scene(layout2);
        addToTrain2 = new Button("Draw");
        Label label2 = new Label("Player 2's Hand:");
        
        LLNode<Domino> p2 = new LLNode<Domino>(p2dominos.getFirstNode().getElement(), null);
        p2 = p2dominos.getFirstNode();
        for (int i = 0; i != p2dominos.length(); i++) {
          Button tempB = new Button(p2.getElement().toString());
          p2box.getChildren().addAll(tempB);
          p2 = p2.getNext();
        }
        layout2.getChildren().addAll(label2, p2box, addToTrain2);
        
        HBox p3box = new HBox();
        VBox layout3 = new VBox();
        Scene scene3 = new Scene(layout3);
        addToTrain3 = new Button("Draw");
        Label label3 = new Label("Player 3's Hand:");
        
        LLNode<Domino> p3 = new LLNode<Domino>(p3dominos.getFirstNode().getElement(), null);
        p3 = p3dominos.getFirstNode();
        for (int i = 0; i != p3dominos.length(); i++) {
          Button tempB = new Button(p3.getElement().toString());
          p3box.getChildren().addAll(tempB);
          p3 = p3.getNext();
        }
        layout3.getChildren().addAll(label3, p3box, addToTrain3);
        
        HBox p4box = new HBox();
        VBox layout4 = new VBox();
        Scene scene4 = new Scene(layout4);
        addToTrain4 = new Button("Draw");
        Label label4 = new Label("Player 4's Hand:");
        LLNode<Domino> p4 = new LLNode<Domino>(p4dominos.getFirstNode().getElement(), null);
        p4 = p4dominos.getFirstNode();
        for (int i = 0; i != p4dominos.length(); i++) {
          Button tempB = new Button(p4.getElement().toString());
          p4box.getChildren().addAll(tempB);
          p4 = p4.getNext();
        }
        layout4.getChildren().addAll(label4, p4box, addToTrain4);
        
        players = 4;
        player1.setScene(scene1);
        player1.show();
        player1.setTitle("Player 1");
        
        player2.setScene(scene2);
        player2.show();
        player2.setTitle("Player 2");
        buttonForPlayers.hide();
        
        player3.setScene(scene3);
        player3.show();
        player3.setTitle("Player 3");
        
        player4.setScene(scene4);
        player4.show();
        player4.setTitle("Player 4");
        buttonForPlayers.hide();
      }
    }
  }
}