package Practice.Java.Source;

/**
 * 作用：测试自动装箱缓存的大小。
 *
 * JVM默认会缓存Integer的-127到127之间的数字。
 *
 * 可以使用-XX:AutoBoxCacheMax=128来配置。如果数值比127小，则默认采用127。
 * 如果数值比127大，则则采用新的范围。
 *
 * 当设置为0的时候，以下结果为true,false。
 * 当设置为128的时候，以下结果为true,true。
 */
public class TextBoxCacheError {
    public static void main(String[] args) {

        Integer n1 = 123;
        Integer n2 = 123;
        Integer n3 = 128;
        Integer n4 = 128;

        System.out.println(n1 == n2);
        System.out.println(n3 == n4);
    }
}
