package concurrent.ex3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AlternativeDemo {

    // 所有线程共享lock和conditions
    private static class AlternativeDemoInner implements Runnable {
        private int nextThread = 1;
        private Lock lock = new ReentrantLock();
        private Condition[] conditions;
        private int totalTimes;

        public AlternativeDemoInner(int threadNum, int totalTimes) {
            this.totalTimes = totalTimes;
            this.conditions = new Condition[threadNum];
            for (int i = 0; i < threadNum; ++i) {
                conditions[i] = lock.newCondition();
            }
        }

        public void run() {
            for (int i = 1; i <= totalTimes; ++i) {
                lock.lock();
                // currentThread 取值为1,2,3
                // currentThread-1为当前线程对应的Condition
                int currentThread = Thread.currentThread().getName().charAt(0) - '0';
                try {
                    // 下一个不是自己，则等待
                    if (currentThread != nextThread) {
                        conditions[currentThread - 1].await();
                    }
                    System.out.println("线程" + currentThread + ":" + currentThread);
                    // 计算下一个要打印的线程
                    // 3 % 3 + 1 = 1  线程3后面的是线程1
                    nextThread = nextThread % conditions.length + 1;
                    // 唤醒下一个要打印的线程
                    conditions[nextThread - 1].signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        int threadNum = 3;
        int loopTimes = 20;
        AlternativeDemoInner atomicDemo = new AlternativeDemoInner(threadNum, loopTimes);
        for (int i = 1; i <= threadNum; ++i) {
            new Thread(atomicDemo, String.valueOf(i)).start();
        }
    }
}
