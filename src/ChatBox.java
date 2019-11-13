import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Queue;

public class ChatBox extends VBox {
    private Integer cfIndex = 0;
    private int cfLimit = 7;
    private Queue<String> messages = new LinkedList<>();
    private Text[] chatText = new Text[cfLimit];
    private String name = "You: ";

    public ChatBox() {
        VBox chatField = new VBox();
        TextField textField = new TextField("Type Here");

        for (int i = 0; i < chatText.length; i++) {
            chatText[i] = new Text(" ");
            chatField.getChildren().add(chatText[i]);
        }

        textField.setOnKeyPressed(e -> {
            getText(textField, e);
        });

        this.getChildren().add(chatField);
        this.getChildren().add(textField);
    }

    public synchronized String getMessage() {
        if (messages.peek() != null) {
            return messages.poll();
        }
        return null;
    }

    private synchronized void getText(TextField textField, KeyEvent e) {
        KeyCode keyCode = e.getCode();
        if (keyCode.getCode() == 10) {
            System.out.println(keyCode.getCode() + " " + keyCode);
            String message = textField.getText();
            messages.add(name + message);
            textField.setText("");

        }
    }

    private void addMessage(String message) {
        if (cfIndex < cfLimit) {
            chatText[cfIndex].setText(message);
            cfIndex++;
        } else {
            for (int i = 0; i < chatText.length - 1; i++) {
                chatText[i].setText(chatText[i + 1].getText());
            }
            chatText[cfIndex - 1].setText(message);
        }
    }

    public synchronized void writeMessage(String response) {
        addMessage(response);
    }
}
