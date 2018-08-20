package com.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class QQServer {


    public static void main(String[] args) throws IOException {

        int port = 8888;
        ServerSocket serverSocket = new ServerSocket(port);

        while(true){
            Socket socket = serverSocket.accept();

        }

    }
}
