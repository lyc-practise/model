package com.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        int port = 8888;
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();

        StringBuffer msg = new StringBuffer();
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = inputStream.read(bytes)) != -1){
            String tmpMsg = new String(bytes, 0, len);
            System.out.println(tmpMsg);
            msg.append(tmpMsg);
        }

        inputStream.close();

        socket.close();    // 关闭socket
        server.close();     // 关闭服务端
    }
}
