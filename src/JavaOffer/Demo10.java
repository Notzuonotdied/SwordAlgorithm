package JavaOffer;

public class Demo10 {

    public static void main(String[] args) {
        System.out.println(RectCover(5));
    }

    /**
     * 很明显就是斐波拉契数列的题目
     */
    public static int RectCover(int target) {
        if (target <= 2)
            return target;
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 3; i <= target; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
