package client;

import common.Protocol;
import java.io.*;

public class FileReceiver {

    public static void receiveFile(String fileName, DataInputStream in) throws IOException {
        if (!in.readUTF().equals(Protocol.FILE_FOUND)) {
            System.out.println("File not found on server");
            return;
        }

        long size = in.readLong();
        FileOutputStream fos = new FileOutputStream(fileName);
        byte[] buffer = new byte[4096];
        long remaining = size;

        while (remaining > 0) {
            int read = in.read(buffer, 0, (int)Math.min(buffer.length, remaining));
            fos.write(buffer, 0, read);
            remaining -= read;
        }
        fos.close();
        in.readUTF();
        System.out.println("Download completed");
    }
}
