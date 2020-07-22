package Java9;

/**
 * @description:
 * @author: Tong
 * @date: 2020-07-15 8:45
 */
public interface MyInterface {
    void abstractMethod();

    /**
     * Java8开始有方法体
     */
    static void methodStatic(){

    }

    /**
     * Java8开始有默认方法
     */
    default void methodDefault(){

    }

    /**
     * Java9开始有私有方法
     */
    private void methodPrivate(){

    }
}
