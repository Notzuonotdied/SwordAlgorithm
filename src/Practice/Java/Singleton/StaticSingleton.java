package Practice.Java.Singleton;

public class StaticSingleton {

    private StaticSingleton() {

    }

    /**
     * 静态内部类（推荐）
     */
    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * 外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存。
     * 第一次调用getInstance()方法会导致虚拟机加载SingletonHolder类，这种方法不仅能确保线程安全，
     * 也能保证单例的唯一性，同时也延迟了单例的实例化。
     */
    private static class SingletonHolder {
        private static final StaticSingleton instance = new StaticSingleton();
    }
}