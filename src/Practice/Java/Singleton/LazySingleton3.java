package Practice.Java.Singleton;

public class LazySingleton3 {
    // 这一步不是线程安全的
    private static LazySingleton3 instance = null;

    private LazySingleton3() {
    }

    /**
     * 双重检查加锁（推荐）；问题：不能彻底保证线程安全。
     */
    public static synchronized LazySingleton3 getInstance() {
        // 先判断实例是否存在，若不存在再对类对象进行加锁处理
        if (instance == null) {
            // 类锁，确保创建唯一的对象
            synchronized (LazySingleton3.class) {
                if (instance == null) {
                    instance = new LazySingleton3();
                }
            }
        }
        return instance;
    }
}
