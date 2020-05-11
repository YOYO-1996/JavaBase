package IO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: Tong
 * @date: 2020-05-11 20:19
 */
public class BIOServer {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        byte[] bytes = new byte[1024];

        try{
            ServerSocket serverSocket = new ServerSocket(8090);
            System.out.println("启动端口8090");

            while (true){
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress());
                service.submit(()->{
                    try {
                        socket.getInputStream().read(bytes);
                        System.out.println("当前线程："+Thread.currentThread().getName()+"       "+bytes[0]+"          "+bytes[1]);
                    }catch (IOException e){

                    }
                });
            }
        }catch (IOException e){

        }
    }
}
