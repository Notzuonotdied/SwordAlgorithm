package JavaOffer;

public class Demo8 {
    public static void main(String[] args) {
        System.out.println(JumpFloor(5));
    }

    /**
     * 台阶数 组合
     * 1     1
     * 2     2
     * 3     3
     * 4     5
     * 5     8
     * 刚好符合斐波拉契数列
     * */
    public static int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int pre2 = 1, pre1 = 2;
        int result = 1;
        for (int i = 2; i < target; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
