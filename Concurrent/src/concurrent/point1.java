package concurrent;

/**
 * @description:
 * @author: Tong
 * @date: 2020-03-13 16:30
 */
public class point1 {
    private int count = 0;
    private static int count1 = 0;

    private Object object = new Object();

    /**
     *  1.锁定当前一个对象
     */
    public void m1(){
        synchronized (object){//执行以下代码，先申请object的锁
            count--;
            System.out.println(Thread.currentThread().getName()+"count = "+count);
        }
    }

    /**
     *  2.锁定当前对象
     */
    public void m2(){
        synchronized (this){//执行以下代码，先申请当前对象的锁
            count--;
            System.out.println(Thread.currentThread().getName()+"count = "+count);
        }
    }

    /**
     *  3.锁定当前对象
     */
    public synchronized void m3(){//执行方法代码，先申请当前对象的锁
        count--;
        System.out.println(Thread.currentThread().getName()+"count = "+count);
    }

    /**
     *  4.静态方法，锁定当前类
     */
    public synchronized static void m4(){//执行静态方法代码，先申请当前(point1.class)的锁
        count1--;
        System.out.println(Thread.currentThread().getName()+"count1 = "+count1);
    }

    /**
     *  5.静态方法，锁定当前类---同4
     */
    public static void m5(){//执行静态方法代码，先申请当前(point1.class)的锁
        synchronized (point1.class){
            count1--;
            System.out.println(Thread.currentThread().getName()+"count1 = "+count1);
        }
    }




}
