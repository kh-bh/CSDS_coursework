import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;

public class myFirstGUI extends Application{
  String s = "I yelled at the Lorax, 'Now listen here, Dad!'" + 
    "\n" + "All you do is yap-yap and say, `Bad! Bad! Bad! Bad!'" + 
    "\n" + "..." + "\n" + "And, for your information, you Lorax, I'm figgering" + 
    "\n" + "on biggering" + "\n" +"\t" + "and Biggering" + "\n" + "\t" + "\t" + 
    "and BIGGERING" + "\n" + "\t" + "\t" + "\t" + "and BIGGERING," + "\n" + 
    "turning MORE Truffala Trees into Thneeds" + "\n" + "which everyone, Everyone, EVERYONE needs!\"";
  public void start (Stage primaryStage) {
    BorderPane layout = new BorderPane(); 
    TextArea text = new TextArea(s);
    layout.setCenter(text);
    primaryStage.setTitle("The Lorax");
    primaryStage.show();
  }
  public static void main(String[] args) {
    Application.launch(args);
  }
}