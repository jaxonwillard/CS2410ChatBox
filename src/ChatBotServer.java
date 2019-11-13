import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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
        System.out.println("hello");

//        while (true) {
//            response = rd.readLine().trim();
//            System.out.println("DEBUG: From Client: " + response);
//            wr.write(response + "\r\n");
//            wr.flush();
//        }
        while (true) {
            System.out.println("hi");
            try{
                System.out.println("Tried");
                socket = sv.accept();
                System.out.println("again");
            } catch (IOException e){
                System.out.println("caught");
                e.printStackTrace();
            }
            System.out.println("Debug in chatbotserver");
            new ClientThread(socket).start();
        }

    }
}