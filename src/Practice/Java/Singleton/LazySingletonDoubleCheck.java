package Practice.Java.Singleton;

public class LazySingletonDoubleCheck {

    // 单单的static并不能保证线程安全，应该加上volatile
    private static volatile LazySingletonDoubleCheck instance = null;

    private LazySingletonDoubleCheck() {
    }

    /**
     * 双重检查加锁（推荐）
     */
    public static synchronized LazySingletonDoubleCheck getInstance() {
        // 先判断实例是否存在，若不存在再对类对象进行加锁处理
        if (instance == null) {
            synchronized (LazySingletonDoubleCheck.class) {
                if (instance == null) {
                    instance = new LazySingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
