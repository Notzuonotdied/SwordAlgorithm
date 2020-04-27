package SwordOffer.KotlinOffer

fun main(args: Array<String>) {

}

private data class TreeNode(var value: Int,
                            var left: TreeNode?,
                            var right: TreeNode?)

private fun hasSubTree(root: TreeNode?, children: TreeNode?): Boolean {
    if (root == null) return false
    if (children == null) return true
    if (root == children) return true

    var result = false

    if (root.value == children.value) {
        result = match(root, children)
    }

    if (result) return true

    return hasSubTree(root.left, children) || hasSubTree(root.right, children)
}

private fun match(root: TreeNode?, children: TreeNode?): Boolean {
    if (root == null) return false
    if (children == null) return true
    if (root == children) return true

    if (root.value == children.value) {
        return match(root.left, children.left)
                && match(root.right, children.right)
    }

    return false
}