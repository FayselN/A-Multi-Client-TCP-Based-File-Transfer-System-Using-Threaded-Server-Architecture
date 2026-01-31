package client;

import common.Protocol;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(ClientConfig.SERVER_IP, ClientConfig.PORT);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);

            System.out.print("Username: ");
            String user = sc.nextLine();
            System.out.print("Password: ");
            String pass = sc.nextLine();

            out.writeUTF("LOGIN " + user + " " + pass);
            if (!in.readUTF().equals(Protocol.AUTH_OK)) {
                System.out.println("Auth failed");
                return;
            }

            System.out.print("GET or UPLOAD: ");
            String action = sc.nextLine().toUpperCase();
            System.out.print("Filename: ");
            String file = sc.nextLine();

            if (action.equals("GET")) {
                out.writeUTF("GET " + file);
                FileReceiver.receiveFile(file, in);
            } else {
                out.writeUTF("UPLOAD " + file);
                FileSender.sendFile(file, out, in);
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
