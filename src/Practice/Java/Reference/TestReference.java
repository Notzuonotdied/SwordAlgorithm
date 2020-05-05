package Practice.Java.Reference;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;

public class TestReference {
    public static void main(String[] args) {
        TestWeakRefDemo();
        TestSoftRefDemo();
        TestPhantomRefDemo();
    }

    /**
     * JVM只有在出现OutOfMemoryError之前才会进行回收。
     */
    private static void TestSoftRefDemo() {
        List<String> myList = new ArrayList<>();
        SoftReference<List<String>> refObj = new SoftReference<>(myList);
        // 正确的使用，使用强引用指向对象保证获得对象之后不会被回收
        List<String> list = refObj.get();
        if (null != list) {
            list.add("hello");
            System.out.println("myList 还没有被回收！");
        } else {
            // 整个列表已经被垃圾回收了，做其他处理
            System.out.println("myList 已经被回收了！");
        }
    }

    /**
     * 测试弱引用的例子
     */
    private static void TestWeakRefDemo() {
        ReferenceQueue<String> refQueue = new ReferenceQueue<>();
        // 用于检查引用队列中的引用值被回收
        Thread checkRefQueueThread = new Thread(() -> {
            while (true) {
                Reference<? extends String> clearRef = refQueue.poll();
                if (null != clearRef) {
                    System.out.println("引用对象被回收, ref = " + clearRef
                            + ", value = " + clearRef.get());
                }
            }
        });
        checkRefQueueThread.start();
        // 需要注意的是，虚引用的第一个参数不能是"value1"，而应该是new String("value1")
        // 传入"value1"，表示在常量池中创建一个"value1"。这个没办法被回收。
        // 传入"new String("value1")"，表示在堆中创建一个"value1"。这个可以被回收。
        WeakReference<String> weakRef1 = new WeakReference<>(new String("value1"), refQueue);
        WeakReference<String> weakRef2 = new WeakReference<>(new String("value2"), refQueue);
        WeakReference<String> weakRef3 = new WeakReference<>(new String("value3"), refQueue);
        System.out.println("ref1 value = " + weakRef1.get());
        System.out.println("ref2 value = " + weakRef2.get());
        System.out.println("ref3 value = " + weakRef3.get());
        System.out.println("开始通知JVM的gc进行垃圾回收");
        // 通知JVM的gc进行垃圾回收
        System.gc();
    }

    /**
     * 使用虚引用来判断是否需要进行资源回收，比finalize()方法更加可靠和灵活
     * <p>
     * PS：JVM并不能保证finalize()一定执行。
     */
    private static void TestPhantomRefDemo() {
        Object obj = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomRef = new PhantomReference<>(obj, refQueue);
        // null
        System.out.println("phantomRef.get()->" + phantomRef.get());
        // null
        System.out.println("refQueue.poll()->" + refQueue.poll());
        // 置空对象，方便后续GC线程回收
        obj = null;
        // 通知JVM的gc进行垃圾回收
        System.out.println("开始进行GC...");
        System.gc();
        System.out.println("GC完毕！");
        // null, 调用phantomRef.get()不管在什么情况下会一直返回null
        System.out.println("phantomRef.get()->" + phantomRef.get());

        // 当GC发现了虚引用，GC会将phantomRef插入进我们之前创建时传入的refQueue队列
        // 注意，此时phantomRef对象，并没有被GC回收。
        // 在我们显式地调用refQueue.poll返回phantomRef之后，GC线程第二次发现虚引用，
        // 而此时JVM将phantomRef插入到refQueue会插入失败，此时GC才会对phantomRef对象进行回收。
        try {
            Thread.sleep(200);
        } catch (InterruptedException ignore) {
        }
        Reference<?> pollObj = refQueue.poll();
        // java.lang.ref.PhantomReference@2f7c7260
        System.out.println("refQueue.poll()->" + pollObj);
        if (null != pollObj) {
            // 进行资源回收的操作
            System.out.println("发现有对象被回收了，开始执行资源回收的操作！");
        }
    }
}
