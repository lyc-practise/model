package com.socket;

import java.io.IOException;
import java.net.Socket;

public class QQClient1 {

    public static void main(String[] args) throws IOException {

        String host = "127.0.0.1";
        int port = 8888;
        Socket socket = new Socket(host,port);
        socket.setKeepAlive(true);

    }
}
