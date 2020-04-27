package SwordOffer.JavaOffer;

import java.util.ArrayList;

public class Demo42 {
    public static void main(String[] args) {

    }

    public static class Solution {
        /**
         * 前后指针，判断即可。
         */
        public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
            ArrayList<Integer> list = new ArrayList<>();
            if (array == null || array.length < 2) {
                return list;
            }
            int i = 0, j = array.length - 1;
            while (i < j) {
                if (array[i] + array[j] == sum) {
                    list.add(array[i]);
                    list.add(array[j]);
                    return list;
                } else if (array[i] + array[j] > sum) {
                    j--;
                } else {
                    i++;
                }

            }
            return list;
        }
    }
}
