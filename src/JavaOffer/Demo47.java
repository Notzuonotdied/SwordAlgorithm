package JavaOffer;

public class Demo47 {
    public static void main(String[] args) {

    }

    public static class Solution1 {
        /**
         * 其实只要先看我们手里有什么牌就能一步一步想到利用短路特性了
         * 我们手里现在可以使用（按优先级高低）单目运算符：++和--,双目运算符：+,-，移位运算符<<和>>，关系运算符>,<等，逻辑运算符&&，||,&,|,^，赋值=
         * 单目和双目的作用是一样的，移位显然没有规律性，因为一个二进制位并不能区分某个数和其他数，这也就排除了&,|,^,因为不需要做位运算了
         * 关系运算符要和if匹配，但这是不行的，这时看看剩下的运算符只能选&&,||了
         * 如果做过Java笔试题，会对这两个运算符非常敏感，他们有短路特性，前面的条件判真（或者假）了，就不会再执行后面的条件了
         * 这时就能联想到--n,直到等于0就能返回值。
         */
        public class Solution {
            public int Sum_Solution(int n) {
                int sum = n;
                boolean flag = (sum > 0) && ((sum += Sum_Solution(--n)) > 0);
                return sum;
            }
        }
    }
}
