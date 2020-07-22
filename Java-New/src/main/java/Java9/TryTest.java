package Java9;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-15 8:55
 */
public class TryTest {
    public static void main(String[] args) {
        //Java8--资源自动关闭，--必须实现AutoCloseable接口
        try(InputStreamReader reader = new InputStreamReader(System.in)){

        }catch (IOException e){
            e.printStackTrace();
        }

        //Java9--声明在外面
        InputStreamReader reader = new InputStreamReader(System.in);
        try(reader){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
