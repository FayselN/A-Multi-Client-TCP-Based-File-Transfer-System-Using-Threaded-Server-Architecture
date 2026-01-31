package server;

import common.Protocol;
import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String login = in.readUTF();
            String[] parts = login.split(" ");

            if (!AuthService.authenticate(parts[1], parts[2])) {
                out.writeUTF(Protocol.AUTH_FAIL);
                socket.close();
                return;
            }
            out.writeUTF(Protocol.AUTH_OK);

            String command = in.readUTF();
            String[] cmd = command.split(" ");

            if (cmd[0].equals("GET")) {
                FileService.sendFile(cmd[1], out);
            } else if (cmd[0].equals(Protocol.UPLOAD)) {
                FileService.receiveFile(cmd[1], in, out);
            }

            socket.close();
        } catch (Exception e) {
            System.out.println("Client disconnected");
        }
    }
}
