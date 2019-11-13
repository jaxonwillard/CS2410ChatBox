

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatBotClient extends Application {
    public void start(Stage stage) throws Exception {
        BufferedWriter wr;
        BufferedReader rd;
        Socket sck;
        ChatBox cb = new ChatBox();
        Scene scene = new Scene(cb);
        stage.setHeight(175);
        stage.show();

        stage.setScene(scene);

        System.out.println("Waiting for Client connection: ");
        sck = new Socket("localhost", 5555);
        rd = new BufferedReader(new InputStreamReader(sck.getInputStream()));
        wr = new BufferedWriter(new OutputStreamWriter(sck.getOutputStream()));

        startSender(wr, cb);
        startListener(rd, cb);
    }

    private void startListener(BufferedReader rd, ChatBox cb) {
        new Thread(() -> {
            while (true) {
                try {
                    String response = rd.readLine().trim();
                    System.out.println("DEBUG: From Server: " + response);

                    cb.writeMessage(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void startSender(BufferedWriter wr, ChatBox cb) {
        new Thread(() -> {
            while (true) {
                String send = cb.getMessage();

                if (send != null) {
                    try {
                        wr.write(send + "\r\n");
                        wr.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


}
