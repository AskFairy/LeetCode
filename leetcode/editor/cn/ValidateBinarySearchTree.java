package editor.cn;

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 730 👎 0

import java.util.Deque;
import java.util.Stack;

class ValidateBinarySearchTree{
	public static void main(String[] args) {
		Solution solution = new ValidateBinarySearchTree().new Solution();
		
	}
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
		return helper(root,null,null);
    }

    // 递归
    public boolean helper(TreeNode node,Integer lower,Integer upper){
    	//跳出
    	if (node == null) return true;

    	// 判断
		int val = node.val;
		if (lower != null && val <= lower) return false;
		if (upper != null && val >= upper) return false;
		// 递归
		if (!helper(node.left,lower,val)) return false;
		if (!helper(node.right,val,upper)) return  false;

		return true;
	}

	// 中序遍历+栈
	public boolean isValidBST2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		Integer pre = null;
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();
			if (pre != null && root.val <= pre) return false;
			pre = root.val;
			root = root.right;
		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
