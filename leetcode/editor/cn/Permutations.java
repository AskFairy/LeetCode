package editor.cn;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 804 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Permutations{
	public static void main(String[] args) {
		Solution solution = new Permutations().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		if (len == 0) {
			return res;
		}
		Deque<Integer> path = new ArrayDeque<>();
		boolean[] used = new boolean[len];
		dfs(nums,len,0,path,used,res);
		return res;
    }

	private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
    	if (depth == len) {
    		res.add(new ArrayList<>(path));
    		return;
		}
    	for (int i = 0; i < len; i++){
    		if(used[i]){
    			continue;
			}
    		used[i] = true;
    		path.addLast(nums[i]);
    		dfs(nums,len,depth + 1,path,used,res);
    		used[i] = false;
    		path.removeLast();
		}
	}


}
//leetcode submit region end(Prohibit modification and deletion)

}
