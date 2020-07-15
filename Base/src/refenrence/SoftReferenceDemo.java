package refenrence;

import java.lang.ref.SoftReference;

/**
 * 软引用何时被收集
 * 运行参数 -Xmx200m -XX:+PrintGC
 *
 */
public class SoftReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        //100M的缓存数据
        byte[] cacheData = new byte[100 * 1024 * 1024];
        //将缓存数据用软引用持有
        SoftReference<byte[]> cacheRef = new SoftReference<>(cacheData);
        //将缓存数据的强引用去除
        cacheData = null;
        System.out.println("第一次GC前" + cacheData);
        System.out.println("第一次GC前" + cacheRef.get());
        //进行一次GC后查看对象的回收情况
        System.gc();
        //等待GC
        Thread.sleep(500);
        System.out.println("第一次GC后" + cacheData);
        System.out.println("第一次GC后" + cacheRef.get());

        //在分配一个120M的对象，看看缓存对象的回收情况
        byte[] newData = new byte[120 * 1024 * 1024];
        System.out.println("分配后" + cacheData);
        System.out.println("分配后" + cacheRef.get());
    }

}
//
//第一次GC前null
//第一次GC前[B@7d4991ad
//[GC (System.gc())  105728K->103248K(175104K), 0.0009623 secs]
//[Full GC (System.gc())  103248K->103139K(175104K), 0.0049909 secs]
//第一次GC后null
//第一次GC后[B@7d4991ad
//[GC (Allocation Failure)  103805K->103171K(175104K), 0.0027889 secs]
//[GC (Allocation Failure)  103171K->103171K(175104K), 0.0016018 secs]
//[Full GC (Allocation Failure)  103171K->103136K(175104K), 0.0089988 secs]
//[GC (Allocation Failure)  103136K->103136K(199680K), 0.0009408 secs]
//[Full GC (Allocation Failure)  103136K->719K(128512K), 0.0082685 secs]
//分配后null
//分配后null