import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Window extends Application {
    public void start(Stage stage){
        ChatBox chatBox = new ChatBox();
        stage.setTitle("Chat");
        stage.setHeight(175);

        Scene scene = new Scene(chatBox);
        stage.setScene(scene);
        stage.show();


    }
}
