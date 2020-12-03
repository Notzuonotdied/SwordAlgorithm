package Practice.Java.Singleton;

public class LazySingleton2 {
    private static LazySingleton2 instance = null;

    private LazySingleton2() {
    }

    /**
     * 适用于多线程环境，但是由于加了方法锁，强行将并行变串行，效率低下。
     */
    public static synchronized LazySingleton2 getInstance() {
        if (instance == null) {
            instance = new LazySingleton2();
        }
        return instance;
    }
}
