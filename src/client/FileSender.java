package client;

import common.Constants;
import common.Protocol;
import java.io.*;

public class FileSender {

    public static void sendFile(String fileName, DataOutputStream out, DataInputStream in) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found on client");
            return;
        }

        out.writeLong(file.length());

        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[Constants.BUFFER_SIZE];
        int read;
        while ((read = fis.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
        fis.close();

        System.out.println(in.readUTF());
    }
}
