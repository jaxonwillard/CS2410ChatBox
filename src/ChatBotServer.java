

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatBotServer {
    public static void main(String[] args) throws Exception {
        ServerSocket sv = new ServerSocket(5555);
        Socket socket = null;
        BufferedWriter wr;
        BufferedReader rd;
        Socket sck;
        String response, send;
        System.out.println("Waiting for Client connection: ");
        sck = sv.accept();
        rd = new BufferedReader(new InputStreamReader(sck.getInputStream()));
        wr = new BufferedWriter(new OutputStreamWriter(sck.getOutputStream()));

//        while (true) {
//            response = rd.readLine().trim();
//            System.out.println("DEBUG: From Client: " + response);
//            wr.write(response + "\r\n");
//            wr.flush();
//        }
        while (true) {
            try{
                socket = sv.accept();
            } catch (IOException e){
                e.printStackTrace();
            }
            new ClientThread(socket).start();
        }

    }
}
