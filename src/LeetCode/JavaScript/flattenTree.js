/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var flatten = function(root) {
    if(!root){
        return null;
    }
    let originRight = null;
    let newRight = null;
    let lastNode = null;
    if(root.right){
        originRight = flatten(root.right);
    }
    if(root.left){
        newRight = flatten(root.left);
    }
    
    lastNode = findRightestNode(newRight);
    if(lastNode){
        lastNode.right = originRight;
    }
    if(newRight) {
        root.right = newRight;
    }
    root.left = null;
    
    
    return root
};

const findRightestNode = (root) => {
    if(root && !root.right){
        return root;
    }
    if(root && root.right){
        return findRightestNode(root.right);
    }
    return null;
}

// 原题解：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
