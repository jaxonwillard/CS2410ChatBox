

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatBotServer {
    public static void main(String[] args) throws Exception {
        ServerSocket sv = new ServerSocket(5555);
        BufferedWriter wr;
        BufferedReader rd;
        Scanner scan;
        Socket sck;
        String response, send;
        while(true) {
            System.out.println("Waiting for Client connection: ");
            sck = sv.accept();
            rd = new BufferedReader(new InputStreamReader(sck.getInputStream()));
            wr = new BufferedWriter(new OutputStreamWriter(sck.getOutputStream()));
            scan = new Scanner(System.in);

            while(true) {
                response = rd.readLine().trim();
                System.out.println("DEBUG: From Client: " + response);
                wr.write(response + "\r\n");
                wr.flush();
            }
        }
    }
}
