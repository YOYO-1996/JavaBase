package refenrence;

import java.lang.ref.WeakReference;

/**
 * 弱引用关联对象何时被回收
 * 下面是这种机制的内部运行情况。WeakHashMap 使用弱引用（weak references) 保存键。
 * WeakReference 对象将引用保存到另外一个对象中，在这里，就是散列键。对于这种类型的 对象，垃圾回收器用一种特有的方式进行处理。
 * 通常，如果垃圾回收器发现某个特定的对象 已经没有他人引用了，就将其回收。然而， 如果某个对象只能由 WeakReference 引用， 垃圾 回收器仍然回收它，
 * 但要将引用这个对象的弱引用放人队列中。WeakHashMap将周期性地检 查队列， 以便找出新添加的弱引用。一个弱引用进人队列意味着这个键不再被他人使用，
 * 并 且已经被收集起来。于是， WeakHashMap将删除对应的条目
 */
public class WeakReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        //100M的缓存数据
        byte[] cacheData = new byte[100 * 1024 * 1024];
        //将缓存数据用软引用持有
        WeakReference<byte[]> cacheRef = new WeakReference<>(cacheData);
        System.out.println("第一次GC前" + cacheData);
        System.out.println("第一次GC前" + cacheRef.get());
        //进行一次GC后查看对象的回收情况
        System.gc();
        //等待GC
        Thread.sleep(500);
        System.out.println("第一次GC后" + cacheData);
        System.out.println("第一次GC后" + cacheRef.get());

        //将缓存数据的强引用去除
        cacheData = null;
        System.gc();
        //等待GC
        Thread.sleep(500);
        System.out.println("第二次GC后" + cacheData);
        System.out.println("第二次GC后" + cacheRef.get());
    }
}
//第一次GC前[B@7d4991ad
//第一次GC前[B@7d4991ad
//第一次GC后[B@7d4991ad
//第一次GC后[B@7d4991ad
//第二次GC后null
//第二次GC后null