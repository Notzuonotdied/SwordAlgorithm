package Practice.Java.Singleton;

public class EagerSingleton {
    // 由于这个实例在Application创建的时候就会被创建，不管这个实例是否会被使用。
    // 这可能会导致内存泄露的问题。
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    /**
     * 饿汉模式
     */
    public static EagerSingleton getInstance() {
        return instance;
    }
}
