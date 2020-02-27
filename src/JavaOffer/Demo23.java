package JavaOffer;

import java.util.Arrays;

public class Demo23 {

    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    /**
     * 验证一个整数数组，是否是某个二叉搜索树的后续遍历的结果。
     * 假设输入的数组的任意两个数字都互不相同。
     *
     * @param sequence 待判断的数组
     * @return true：是二叉搜索树的后续遍历结果。
     */
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        int len = sequence.length;
        int root = sequence[len - 1];
        int i = 0;
        // 找到第一个比root节点大的下标，即找到右子树的第一个起始索引。
        for (; i < len - 1; i++) {
            if (root <= sequence[i]) {
                break;
            }
        }
        int j = i;
        // 如果在右子树中有值小于root节点的值，那么就不是二叉搜索树的输出序列。
        for (; j < len - 1; j++) {
            if (root > sequence[j]) {
                return false;
            }
        }

        // 到这里表示在该（子）树合理。需要继续拆解判断。
        boolean leftFlag = true;

        // 判断左子树是否合理。
        if (i > 0) {
            leftFlag = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }

        boolean rightFlag = true;

        // 判断右子树是否合理。
        if (i < len - 1) {
            rightFlag = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length - 1));
        }

        return leftFlag && rightFlag;
    }
}
