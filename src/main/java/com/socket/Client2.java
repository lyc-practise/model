package com.socket;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Client2 {

    public static void main(String[] args) throws IOException {

        int n = 1000;
        for(int i = 0; i < n ;i ++){
            System.out.print("创建第 " + i + " 个socket, ");
            Socket socket = conn("127.0.0.1", 8888);
            System.out.println();
        }

    }


    private static Socket conn(String ip, int port){
        Socket socket = null;
        try{
            socket = new Socket(ip, port);
            System.out.print(ip + ":" + port + " is " + socket.isConnected());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("create socket fail!");
        }

        return socket;

    }

}
