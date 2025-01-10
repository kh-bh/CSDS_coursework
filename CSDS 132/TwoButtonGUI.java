/**@author Bhoomika Khatri */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class TwoButtonGUI extends Application {
  // two buttons for the GUI
  private Button button1;
  private Button button2;
  
  /**
   * Creates a GUI with two buttons that do different things
   * @param primaryStage the main window of the GUI
   */
  public void start(Stage primaryStage) {
    // create buttons and put them into a layout manager
    BorderPane layout = new BorderPane();
    button1 = new Button("Button 1");
    button2 = new Button("Button 2");
    layout.setTop(button1);
    layout.setBottom(button2);
    // register with the OS to respond to button clicks
    MyButtonAction myAction = new MyButtonAction();
    button1.setOnAction(myAction);
    button2.setOnAction(myAction);
    // put the layout manager with the buttons into the window
    Scene scene = new Scene(layout);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  /**
   * Start the GUI
   * @param args the command line arguments are currently ignored
   */
  public static void main(String[] args) {
    Application.launch(args);
  }
  /** When a button is clicked, this will print a fun message */
  private class MyButtonAction implements EventHandler<ActionEvent> {
    /**
     * The action is to print a message depending on which button is clicked.
     * @param e information about the click event
     */
    public void handle(ActionEvent e) {
      Button b = (Button)e.getSource();
      if (b == button1)
        System.out.println("You clicked Button 1");
      if (b == button2)
        System.out.println("You clicked Button 2");
    }
  }
}
