package editor.cn;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 850 👎 0

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

class LargestRectangleInHistogram{
	public static void main(String[] args) {
		Solution solution = new LargestRectangleInHistogram().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
		// 存数组下标
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int maxArea = 0;
		for (int i = 0; i < heights.length; i++) {
			while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
				// 小于栈顶元素，证明找到栈顶元素的左右边界。
				// 右边界为当前元素，左边界为次栈顶元素
				maxArea = Math.max(maxArea,heights[stack.pop()] * (i - stack.peek() - 1));
			}
			// 将当前元素加入
			stack.push(i);
		}
		// 除了不为-1
		while (stack.peek() != -1) {
			maxArea = Math.max(maxArea,heights[stack.pop()] * (heights.length - stack.peek() - 1));
		}
		return maxArea;
    }

    // 栈+哨兵
	public int largestRectangleArea1(int[] heights) {
		int len = heights.length;
		if (len == 0) {
			return 0;
		}
		if (len == 1) {
			return heights[0];
		}

		// copy 一个新数组，在前后打上哨兵
		int[] newHeights = new int[len + 2];
		newHeights[0] = 0;
		System.arraycopy(heights,0,newHeights,1,len);
		newHeights[len + 1] = 0;
		heights = newHeights;
		len += 2;

		Deque<Integer> stack = new ArrayDeque<>(len);
		int maxArea = 0;
		stack.addLast(0);

		for (int i = 1; i < len; i++) {
			while (heights[i] < heights[stack.peekLast()]) {
				// 小于栈顶元素，证明找到栈顶元素的左右边界。
				// 右边界为当前元素，左边界为次栈顶元素
				int height = heights[stack.pollLast()];
				int width = i - stack.peekLast() - 1;
				maxArea = Math.max(maxArea,height * width);
			}
			stack.addLast(i);
		}
		return maxArea;
	}

	// 第三种，（国际站，性能最好的）(未手打)
	public int largestRectangleArea3(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		// idx of the first bar the left that is lower than current
		int[] lessFromLeft = new int[height.length];
		// idx of the first bar the right that is lower than current
		int[] lessFromRight = new int[height.length];
		lessFromRight[height.length - 1] = height.length;
		lessFromLeft[0] = -1;

		for (int i = 1; i < height.length; i++) {
			int p = i - 1;

			while (p >= 0 && height[p] >= height[i]) {
				p = lessFromLeft[p];
			}
			lessFromLeft[i] = p;
		}

		for (int i = height.length - 2; i >= 0; i--) {
			int p = i + 1;

			while (p < height.length && height[p] >= height[i]) {
				p = lessFromRight[p];
			}
			lessFromRight[i] = p;
		}

		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
		}

		return maxArea;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
