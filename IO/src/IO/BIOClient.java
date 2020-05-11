package IO;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @description:
 * @author: Tong
 * @date: 2020-05-11 20:23
 */
public class BIOClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8090);
            DataOutputStream dis = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String str = br.readLine();
                if (str != null) {
                    dis.write(str.getBytes());
                }
                dis.flush();
            }
        } catch (IOException e) {

        }
    }
}
