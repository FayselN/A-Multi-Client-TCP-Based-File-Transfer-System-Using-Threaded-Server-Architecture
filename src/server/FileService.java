package server;

import common.Constants;
import common.Protocol;
import java.io.*;

public class FileService {

    public static void sendFile(String fileName, DataOutputStream out) throws IOException {
        File file = new File(ServerConfig.FILE_DIR + fileName);
        if (!file.exists()) {
            out.writeUTF(Protocol.FILE_NOT_FOUND);
            return;
        }

        out.writeUTF(Protocol.FILE_FOUND);
        out.writeLong(file.length());

        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[Constants.BUFFER_SIZE];
        int read;
        while ((read = fis.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
        fis.close();
        out.writeUTF(Protocol.TRANSFER_DONE);
    }

    public static void receiveFile(String fileName, DataInputStream in, DataOutputStream out) throws IOException {
        long size = in.readLong();
        File file = new File(ServerConfig.FILE_DIR + fileName);

        FileOutputStream fos = new FileOutputStream(file);
        byte[] buffer = new byte[Constants.BUFFER_SIZE];
        long remaining = size;

        while (remaining > 0) {
            int read = in.read(buffer, 0, (int)Math.min(buffer.length, remaining));
            fos.write(buffer, 0, read);
            remaining -= read;
        }
        fos.close();
        out.writeUTF(Protocol.UPLOAD_OK);
    }
}
