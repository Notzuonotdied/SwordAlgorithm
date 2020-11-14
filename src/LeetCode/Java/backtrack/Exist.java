package LeetCode.Java.backtrack;

public class Exist {
    public static void main(String[] args) {

    }

    private static class Solution1 {
        /**
         * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
         *
         * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
         * 同一个单元格内的字母不允许被重复使用。
         *
         * 示例:
         *
         * board =
         * [
         *   ['A','B','C','E'],
         *   ['S','F','C','S'],
         *   ['A','D','E','E']
         * ]
         *
         * 给定 word = "ABCCED", 返回 true
         * 给定 word = "SEE", 返回 true
         * 给定 word = "ABCB", 返回 false
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/word-search
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         * 执行用时：9 ms, 在所有 Java 提交中击败了37.88% 的用户
         * 内存消耗：39.4 MB, 在所有 Java 提交中击败了96.62% 的用户
         */
        public boolean exist(char[][] board, String word) {
            int width = board.length;
            int height = board[0].length;
            boolean[][] visited = new boolean[width][height];
            // 循环查找
            for (int i = 0; i < width; ++i) {
                for (int j = 0; j < height; ++j) {
                    boolean flag = check(board, word, i, j, visited, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean check(char[][] board, String word, int i, int j, boolean[][] visited, int length) {
            if (board[i][j] != word.charAt(length)) {
                return false;
            }
            if (length == word.length() - 1) {
                return true;
            }
            visited[i][j] = true;
            // 定义四个方位
            int[][] directions = {{0, 1,}, {1, 0}, {-1, 0}, {0, -1}};
            boolean result = false;
            for (int[] dir : directions) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length) {
                    if (visited[ii][jj]) {
                        continue;
                    }
                    boolean flag = check(board, word, ii, jj, visited, length + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
            visited[i][j] = false;
            return result;
        }
    }

    private static class Solution2 {
        /**
         * 这里主要是修改directions在exist函数中，提高了执行速度，但是内存消耗加剧了。
         *
         * 执行用时：7 ms, 在所有 Java 提交中击败了73.40% 的用户
         * 内存消耗：40.6 MB, 在所有 Java 提交中击败了67.15% 的用户
         */
        public boolean exist(char[][] board, String word) {
            int width = board.length;
            int height = board[0].length;
            boolean[][] visited = new boolean[width][height];
            int[][] directions = {{0, 1,}, {1, 0}, {-1, 0}, {0, -1}};
            // 循环查找
            for (int i = 0; i < width; ++i) {
                for (int j = 0; j < height; ++j) {
                    boolean flag = check(board, word, i, j, visited, directions, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean check(char[][] board, String word, int i, int j, boolean[][] visited, int[][] directions, int length) {
            if (board[i][j] != word.charAt(length)) {
                return false;
            }
            if (length == word.length() - 1) {
                return true;
            }
            visited[i][j] = true;
            // 定义四个方位
            boolean result = false;
            for (int[] dir : directions) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length) {
                    if (visited[ii][jj]) {
                        continue;
                    }
                    boolean flag = check(board, word, ii, jj, visited, directions, length + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
            visited[i][j] = false;
            return result;
        }
    }
}
