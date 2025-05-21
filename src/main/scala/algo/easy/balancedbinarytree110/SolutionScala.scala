package r.ian
package algo.easy.balancedbinarytree110

/**
 * @author Melton Smith
 * @since 21.05.2025
 */
object SolutionScala {

  //100% 56% 60 Mb mem
  def isBalanced(root: TreeNode): Boolean = {
    if (root == null)
      return true

    dfs(root) != -1
  }

  def dfs(node : TreeNode): Int = {
    if (node == null)
      return -1
    val left = dfs(node.left)
    if (left == -1)
      return -1
    val right = dfs(node.right)
    if (right == -1)
      return -1

    if (Math.abs(left-right) > 1)
      return -1

    Math.max(left, right) + 1

  }
}


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

