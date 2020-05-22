package IO;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ：Tong
 * @date ：Created in 2020/5/9 10:21
 * @description：
 * @version: $
 */
public class BIODemo {
    ServerSocket serverSocket;
    boolean started;

    public void start() {
        try {
            serverSocket = new ServerSocket(6666);
            started = true;
        } catch (BindException e) {
            System.out.println("端口使用中...."); // 用于处理两次启动Server端
            System.out.println("请重新运行服务器");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("服务器启动失败");
            e.printStackTrace();
        }

        try{
            while (started){
                Socket s = serverSocket.accept();

            }
        }catch (IOException e){

        }
    }

    public static void main(String[] args) {

    }
}
