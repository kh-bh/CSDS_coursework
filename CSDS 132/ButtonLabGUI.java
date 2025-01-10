import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Window;
import javafx.scene.layout.GridPane;

/** A window with one button
 * @author Bhoomika Khatri
 * @author Michelle Kim
 */
public class ButtonLabGUI extends Application {
  /** A clickable button */
  private Button button;
  
  /** A field for the stage */
  private Stage primaryS;
  
  /** A field for the count of clicks */
  private int count = 0;
  
  /** A field for the text */
  private TextArea text = new TextArea();
  
  /** A field for the gridPane */
  private GridPane gridPane = new GridPane();
  
  /** 
   * Overrides the start method of Application to create the GUI with one button in the center of the main window.
   * @param primaryStage the JavaFX main window
   */
  public void start(Stage primaryStage) {
    primaryS = primaryStage;
    button = new Button("Click me");
    button.setOnAction(new ButtonAction());
    
    text.setText("Click count: 0\n");
    
    BorderPane pane = new BorderPane();      // create a 5 region layout for the window
    pane.setTop(button);                  // add the button to the middle
    pane.setBottom(text);

    Scene scene = new Scene(pane);           // Create a "scene" that contains this border area

    primaryStage.setTitle("Button Lab GUI");
    primaryStage.setScene(scene);            // Add the "scene" to the main window
    primaryStage.show();                     // Display the window
    
    Button[][] buttons = new Button[3][3];
    for(int i = 1; i < 4; i++) {
      for (int j = 1; j < 4; j++) {
        gridPane.add(buttons[i][j],i,j);
      }
    }
    
    pane.setCenter(gridPane);
    
  }
    
  /**
   * The method to launch the program.
   * @param args  The command line arguments.  The arguments are passed on to the JavaFX application.
   */
   public static void main(String[] args) {
     Application.launch(args);
   }
   
   private class ButtonAction implements EventHandler<ActionEvent> {
     /** React to a button click:  change the text on the button
      * @param e  information about the button click event that occurred
      */
     public void handle(ActionEvent e) {
       Button b = (Button) e.getSource(); // this points to what b1 points to!
       count ++;
       text.appendText("Click count: " + count + "\n"); // change the amount of times the button has been clicked.
       primaryS.sizeToScene();
     }     
   }
}