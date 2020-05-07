 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    const res = [];
    helper(root, 0, res);
    return res;
};

const helper = (root, level, res) => {
    if(root){
        if(!res[level]) {
            res.push([]);
        }
        res[level].push(root.val);
        helper(root.left, level + 1, res);
        helper(root.right, level + 1, res);
    }
}

// O(n) 的时间复杂度
// 官方题解: https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-ci-bian-li-by-leetcode/
