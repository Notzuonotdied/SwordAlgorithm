/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
    return validate(root, Infinity, -Infinity)
};

const validate = (root, upper, lower) => {
    if(!root){
        return true;
    }
    if((root.val >= upper) || (root.val <= lower)){
        return false
    }
    return validate(root.left, root.val, lower) && validate(root.right, upper, root.val);
}

// 两种方式：递归/中序遍历 都可以实现。时间复杂度O(n)

