# LeetCode
LeetCode习题集

## 第三课

### Array 实战题目

#### [盛最多水的容器](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/ContainerWithMostWater.java)

LeetCode地址：https://leetcode-cn.com/problems/container-with-most-water/

代码：

```java
	public int maxArea(int[] height) {
		int max = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			max =  height[left] < height[right] ?
					Math.max((right - left) * height[left++], max) :
					Math.max((right - left) * height[right--], max);
		}
		return max;
    }
```

时间复杂度：O（n）

空间复杂度：O（1）

已做次数：2

#### [移动零](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/MoveZeroes.java)

LeetCode地址：https://leetcode-cn.com/problems/move-zeroes/ 

代码：

```java
	public void moveZeroes(int[] nums) {
    	int j = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] != 0){
    			nums[j] = nums[i];
    			if (i != j){
    				nums[i] = 0;
				}
				j++;
			}
		}
    }
```

时间复杂度：O（n）

空间复杂度：O（1）

已做次数：2

#### [爬楼梯](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/ClimbingStairs.java)

LeetCode地址：https://leetcode-cn.com/problems/climbing-stairs/

代码：

```java
	public int climbStairs(int n) {
    	if (n <= 2) {
    		return n;
		}
    	int f1 = 1;
    	int f2 = 2;
    	int f3 = 0;
    	for (int i = 3;i <= n; i++) {
    		f3 = f1 + f2;
    		f1 = f2;
    		f2 = f3;
		}
    	return f3;
    }
```

时间复杂度：O（n）

空间复杂度：O（1）

已做次数：2

#### [三数之和](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/ThreeSum.java)

LeetCode地址：https://leetcode-cn.com/problems/3sum/

代码：

```java
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for(int k = 0; k < nums.length - 2; k++) {
			if (nums[k] > 0) {
				break;
			}
			if (k > 0 && nums[k] == nums[k - 1]){
				continue;
			}
			int i = k + 1;
			int j = nums.length - 1;
			while (i < j) {
				int sum = nums[k] + nums[i] + nums[j];
				if (sum < 0) {
					while(i < j && nums[i] == nums[++i]);
				}
				if (sum > 0) {
					while(i < j && nums[j] == nums[--j]);
				}
				if (sum == 0) {
					res.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
					while(i < j && nums[i] == nums[++i]);
					while(i < j && nums[j] == nums[--j]);
				}
			}
		}
		return res;
    }
```

时间复杂度：O（n ^2）

空间复杂度：O（1）

已做次数：1

### Linked List 实战题目

#### [反转链表（未完成）](https://leetcode-cn.com/problems/reverse-linked-list/)

LeetCode地址：https://leetcode-cn.com/problems/reverse-linked-list/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

#### [两两交换链表中的节点（未完成）](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)

LeetCode地址：https://leetcode-cn.com/problems/swap-nodes-in-pairs/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

#### [环形链表（未完成）](https://leetcode-cn.com/problems/linked-list-cycle/)

LeetCode地址：https://leetcode-cn.com/problems/linked-list-cycle/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

#### [环形链表 II（未完成）](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

LeetCode地址：https://leetcode-cn.com/problems/linked-list-cycle-ii/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

#### [K 个一组翻转链表（未完成）](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)

LeetCode地址：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

### 课后作业

#### [删除数组中的重复项](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/RemoveDuplicatesFromSortedArray.java)

LeetCode地址：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

代码：

```java
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[index] != nums[i]) {
				index += 1;
				nums[index] = nums[i];
			}
		}
		return index + 1;
    }
```

时间复杂度：O（n）

空间复杂度：O（1）

已做次数：2

#### [旋转数组](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/RotateArray.java)

LeetCode地址：https://leetcode-cn.com/problems/rotate-array/ 

代码：

```java
	public void rotate(int[] nums, int k) {
		k %= nums.length;
		reverse(0,nums.length - 1,nums);
		reverse(0,k - 1,nums);
		reverse(k,nums.length - 1,nums);
    }

    public void reverse(int left,int right,int[] nums){
    	while (left < right) {
    		int temp = nums[right];
    		nums[right] = nums[left];
    		nums[left] = temp;
    		left++;
    		right--;
		}
	}
```

时间复杂度：O（n）

空间复杂度：O（1）

已做次数：2

#### [合并两个有序数组](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/MergeSortedArray.java)

LeetCode地址：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 

代码：

```java
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int mIndex = m - 1;
		int nIndex = n - 1;
		int mergeIndex = m + n - 1;
		while (mIndex >= 0 || nIndex >= 0) {
			if (mIndex < 0) {
				nums1[mergeIndex--] = nums2[nIndex--];
			} else if (nIndex < 0) {
				nums1[mergeIndex--] = nums1[mIndex--];
			} else if (nums1[mIndex] > nums2[nIndex]) {
				nums1[mergeIndex--] = nums1[mIndex--];
			}else {
				nums1[mergeIndex--] = nums2[nIndex--];
			}
		}
    }
```

时间复杂度：O（n）

空间复杂度：O（1）

已做次数：2

#### [合并两个有序链表（未完成）](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

LeetCode地址：https://leetcode-cn.com/problems/merge-two-sorted-lists/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

#### [ 两数之和（未完成）](https://leetcode-cn.com/problems/two-sum/)

LeetCode地址：https://leetcode-cn.com/problems/two-sum/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

#### [加一（未完成）](https://leetcode-cn.com/problems/plus-one/)

LeetCode地址：https://leetcode-cn.com/problems/plus-one/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

## 第四课

### 预习题目

#### [有效的括号](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/ValidParentheses.java)

LeetCode地址：https://leetcode-cn.com/problems/valid-parentheses/

代码：

```java
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '{') {
				stack.push('}');
			} else if (c == '[') {
				stack.push(']');
			} else if (stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
		return stack.isEmpty();
    }
```

时间复杂度：O(n)

空间复杂度：O(n)

已做次数：1

#### [最小栈](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/MinStack.java)

LeetCode地址：https://leetcode-cn.com/problems/min-stack/

代码：

```java
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    
    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }

    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
```

时间复杂度：O(1)

空间复杂度：O(n)

已做次数：1

### 实战题目

#### [柱状图中最大的矩形](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/LargestRectangleInHistogram.java)

LeetCode地址：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/

代码：

```java
// 第一种，单调栈
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
// 第二种，单调栈+哨兵（低于第三种）
 	public int largestRectangleArea(int[] heights) {
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
	public int largestRectangleArea(int[] height) {
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
```

时间复杂度：O(n)

空间复杂度：O(n)

已做次数：1



### 课后作业

#### [设计循环双端队列（未完成）](https://leetcode-cn.com/problems/design-circular-deque/)

LeetCode地址：https://leetcode-cn.com/problems/design-circular-deque

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

#### [接雨水（未完成）](https://leetcode-cn.com/problems/trapping-rain-water/)

LeetCode地址：https://leetcode-cn.com/problems/trapping-rain-water/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

#### 用 add first 或 add last 这套新的 API 改写 Deque 的代码 

#### 分析 Queue 和 Priority Queue 的源码 

## 第五课  Hash表,映射,集合

### 实战题目/课后作业

#### [有效的字母异位词](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/ValidAnagram.java)

LeetCode地址：https://leetcode-cn.com/problems/valid-anagram/description/

代码：

```java
	public boolean isAnagram(String s, String t) {

		if(s.length() != t.length()){
			return false;
		}
		// 计数表
		int[] count = new int[26];

		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a'] ++;
		}

		for (int i = 0; i < t.length(); i++) {
			int index = t.charAt(i) - 'a';
			count[index] --;
			if (count[index] < 0) {
				return false;
			}
		}

		return true;

    }
```

时间复杂度：O(n)

空间复杂度：O(1)

已做次数：2

#### [字母异位词分组（未完成）](https://leetcode-cn.com/problems/group-anagrams/)

LeetCode地址：https://leetcode-cn.com/problems/group-anagrams/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

## 第六课 树、二叉树、二叉搜索树

#### [98. 验证二叉搜索树](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/ValidateBinarySearchTree.java)

LeetCode地址：https://leetcode-cn.com/problems/validate-binary-search-tree/

代码：

```java
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
```

时间复杂度：O(n)

空间复杂度：O(n)

已做次数：1

#### [剑指 Offer 68 - II. 二叉树的最近公共祖先](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/LowestCommonAncestorOfABinaryTree.java)

LeetCode地址：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/

代码：

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ( root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if (left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
```

时间复杂度：O(n)

空间复杂度：O(n)

已做次数：1

#### 二叉搜索树的最近公共祖先(未完成)

LeetCode地址：https://leetcode-cn.com/problems/group-anagrams/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

## 第12课 动态规划

### 本周作业

#### [91. 解码方法](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/DecodeWays.java)

LeetCode地址：https://leetcode-cn.com/problems/decode-ways/

题目

```

```

代码：

```java
class Solution {
    public int numDecodings(String s) {
		int len = s.length();
		int[] dp = new int[len+1];
		// 哨兵,比输入数组多一位
		dp[len] = 1;
		// 个位不为0，则课编码为1
		if (s.charAt(len-1) != '0') {
			dp[len-1] = 1;
		}

		// 由十位开始
		for (int i = len - 2; i >= 0; i--) {
			if(s.charAt(i) == '0'){
				dp[i] = 0;
				continue;
			}

			int dpi1 = dp[i+1];
			int dpi2 = 0;
			// 如果小于26，正常公式
			int ten = (s.charAt(i) - '0') * 10;
			int one = s.charAt(i+1) - '0';
			// 如果 s.charAt(i) == 0 肯定能进这个判断
			if(ten + one <= 26){
				dpi2 = dp[i+2];
			}
			// 大于26，就和 i+1 的编码数一样了
			dp[i] = dpi1 + dpi2;
		}
		return dp[0];
    }
}
```

时间复杂度：O(n)

空间复杂度：O(n)

已做次数：1

## 优先队列

#### [703. 数据流中的第K大元素](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/KthLargestElementInAStream.java)

LeetCode地址：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/

题目

```java
设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。

你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。

示例:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
说明:
你可以假设 nums 的长度≥ k-1 且k ≥ 1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```

代码：

```java
class KthLargest {

    final PriorityQueue<Integer> queue;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for(int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        if (queue.size() < k){
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
```

时间复杂度：O(nlogn)

空间复杂度：O(1)

已做次数：1

# 算法

## 滑动窗口系列

### 滑动窗口介绍

对于大部分滑动窗口类型的题目，一般是**考察字符串的匹配**

比较标准的题目，会给出一个**模式串B**，以及一个**目标串A**。然后提出问题，找到**A中符合对B一些限定规则的子串或者对A一些限定规则的结果，\**最终\**再将搜索出的子串完成题意中要求的组合或者其他**。

比如：

- 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
- 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
- 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

以上属于这一类的标准题型

常用的解题思路，**是去维护一个可变长度的滑动窗口**。无论是使用**双指针**，还是使用**双端队列**，又或者用**游标**等其他奇技淫巧，目的都是一样的。



### [滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)

LeetCode地址：https://leetcode-cn.com/problems/sliding-window-maximum/

#### 问题

```java
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。

 

进阶：

你能在线性时间复杂度内解决此题吗？

 

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 

提示：

1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sliding-window-maximum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```

#### 代码

```java
// 暴力
// O(nk)
// O(n-k+1) 用于输出数组。
public int[] maxSlidingWindow(int[] nums, int k) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return new int[0];
        }  
        // 最后有一个窗口也要取
        int[] res = new int[nums.length - k + 1];
        // 遍历结果集合，填数
        for (int i =0; i < res.length; i++){
            int max = nums[i];
            for(int j = 1; j < k; j++) {
                max = Math.max(max,nums[i+j]);
            }
            res[i] = max;
        }
        return res;
    }

// 双端队列
// O(n) 每个元素被处理两次- 其索引被添加到双向队列中和被双向队列删除。
// O(n) 输出数组使用了 {O}(N - k + 1)O(N−k+1) 空间，双向队列使用了 {O}(k)O(k)。
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 边界条件
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        // 返回数组的标识
        int index = 0;
        // 存储数组下标
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            // 如果队列第一个下标 < i - k 剔除
            if ( !q.isEmpty() && q.peekFirst() <= i - k ) {
                q.pollFirst();
            }
            // 为保证，队首最大，移除队列中比填入一个值的时候移除比它小的
            //相当于队列排序了
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.PollLast;
            }
            q.addLast(i);
            // 将队首元素填入res
            if (i >= k -1) {
                res[index++] = nums[q.peekFirst()];
            }
        }
        return res;
    }
}


// 优先队列，大顶堆。不行，只能获取最大值，无法删除元素
// 官方题解的动态规划（两端扫描），为了动态强行动态，时间复杂度O(n)，空间复杂度都O(n)了


```

#### 涉及题解

[ 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/)

[239. 滑动窗口最大值（3种解决方式）](https://leetcode-cn.com/problems/sliding-window-maximum/solution/3chong-jie-jue-fang-shi-by-sdwwld/)

#### 已做次数：1

### 无重复字符的最长子串

#### 问题

```java
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```

#### 题目解析

##### 思路

1. 维护一个窗口，当下一个元素在窗口没有出现过时，我们扩大窗口
2. 当下一个元素在窗口中出现过时，我们缩小窗口，将**出现过的元素**以及**其左边的元素**统统移出
3. 在整个过程中，我们**记录下窗口出现过的最大值**即可。而我们唯一要做的，只需要**尽可能扩大窗口**

##### 实现

###### 双指针

​	维护左右指针和一个容器（set）集合（存已经出现过的字符）。

​	遇到重复字符（在容器（set）中存在），一步步移动剔除左指针的字符，直到不存在为止。

​	问题：如果是最坏情况的话，我们每一个字符都可能会访问两次，left一次，right一次，时间复杂度达到了O(2N)。

增加Map优化

​	我们可以定义**字符到索引的映射**，而不是简单通过一个集合来判断字符是否存在。这样的话，当我们**找到重复的字符时，我们可以立即跳过该窗口**，而不需要对之前的元素进行再次访问。

用数组继续优化

既然都是找**字符到索引的映射**，并替换下标，为什么不用256位（一个256个字符）的数组来替代hashmap，以进一步优化。

#### 代码

```java
// 时间 复杂度 O(n)
// 空间复杂度 o(1) 常数级
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        //字符到索引的映射
        int[] charIndex = new int[256];
        // 最大长度
        int result = 0;
        for (int left = 0, right = 0; right < size; right++) {
            char c = s.charAt(right);
            // 获取左指针
            left = Math.max(charIndex[c],left);
            result = Math.max(result, right - left + 1);
            // 在这个位置时，左指针应该在的位置
            charIndex[c] = right + 1;
        }
        return result;
    }
}
```

#### 涉及题解

[无重复字符的最长子串（3）](https://www.geekxh.com/1.5.滑动窗口系列/502.html)

#### 已做次数：1