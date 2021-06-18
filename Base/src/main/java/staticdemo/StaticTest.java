package staticdemo;

public class StaticTest {
    public static void main(String[] args) {
        staticFunction();
    }
    
    static StaticTest st = new StaticTest();

    static {   //静态代码块
        System.out.println("1");
    }

    {       // 实例代码块
        System.out.println("2");
    }

    StaticTest() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {   // 静态方法
        System.out.println("4");
    }

    int a = 110;    // 实例变量
    static int b = 112;     // 静态变量

    /**
     main 方法属于静态方法，主动引用，开始执行类的初始化：
     1)先初始化StaticTest，对象实例化时，因为类已经被加载，所以执行对象初始化，先对成员变量进行初始化（a赋值为0)，
     然后按照编写顺序进行非静态变量赋值与非静态代码块执行（打印2，a赋值为110)，
     再调用构造方法（打印3，打印a=110，b=0)
     2)再执行静态代码块，打印1
     3)再赋值b为112,
     4)至此类加载完毕，执行main方法，打印4
     
     
     2
     3
     a=110,b=0
     1
     4
     */
}