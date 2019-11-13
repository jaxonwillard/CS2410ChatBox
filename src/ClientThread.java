import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientThread extends Thread {
    BufferedWriter wr;
    BufferedReader rd;
    Socket sck;
    String response, send;
    Socket socket;


    public ClientThread(Socket clientSocket) throws IOException {
        this.socket = clientSocket;

        rd = new BufferedReader(new InputStreamReader(sck.getInputStream()));
        wr = new BufferedWriter(new OutputStreamWriter(sck.getOutputStream()));

    }


    public void run(){
        while (true){
            try {
                response = rd.readLine().trim();
                wr.write(response + "\r\n");
                wr.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
