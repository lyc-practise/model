package com.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client1 {

    public static void main(String[] args) throws IOException {

        String host = "127.0.0.1";
        int port = 8888;
        Socket socket = new Socket(host, port);

        String message = "你好，我是客户端1";
        OutputStream output = socket.getOutputStream();
        output.write(message.getBytes());
        output.flush();
        output.close();  // 关闭输出流，关闭输出流，则socket也结束链接，服务端将会获得链接中断讯号
        socket.close();  // 关闭socket信息通道

    }
}
