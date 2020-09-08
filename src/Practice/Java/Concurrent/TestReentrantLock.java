package Practice.Java.Concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁的使用。
 *
 * 说明：
 * 1. 可重入锁可以实现分组唤醒需要唤醒的线程，而synchronized无法做到。
 *    synchronized要么唤醒一个线程，要么唤醒所有的线程。
 * 2. ReentrantLock需要用户去手动释放锁若没有主动释放锁, 就有可能导致出现死锁现象。(lock、unlock)
 *    synchronized不需要用户手动释放锁，当synchronized包裹的代码块执行完毕后，会自动释放锁。
 *
 */
class TestReentrantLock {
    public static void main(String[] args) {
        TestReentrantLock testReentrantLock = new TestReentrantLock();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                testReentrantLock.print5();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                testReentrantLock.print10();
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                testReentrantLock.print15();
            }
        }, "CC").start();

    }

    // A:1 B:2 C:3
    private int number = 1;

    // 可重入锁
    private final Lock lock = new ReentrantLock();
    // 三个等待条件
    private final Condition c1 = lock.newCondition();
    private final Condition c2 = lock.newCondition();
    private final Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            // 1、判断
            while (number != 1) {
                c1.await();
            }
            // 2、干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3、通知
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            // 1、判断
            while (number != 2) {
                c2.await();
            }
            // 2、干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3、通知
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            // 1、判断
            while (number != 3) {
                c3.await();
            }
            // 2、干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3、通知
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}