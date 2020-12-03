package Practice.Java.Singleton;

public class LazySingleton1 {
    private static LazySingleton1 instance = null;

    private LazySingleton1() {
    }

    /**
     * 仅仅适用于单线程环境，不能保证线程安全
     */
    public static LazySingleton1 getInstance() {
        if (null == instance) {
            instance = new LazySingleton1();
        }
        return instance;
    }
}
