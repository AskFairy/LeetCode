# LeetCode(已转移)
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
			// 图标是排序，大于0就不用比较了
            if (nums[k] > 0) {
				break;
			}
             // 和前一个数一样就不用比较了
			if (k > 0 && nums[k] == nums[k - 1]){
				continue;
			}
             // 左指针
			int i = k + 1;
             // 右指针
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

既然都是找**字符到索引的映射**，为什么不用256位（一个256个字符）的数组来替代hashmap，以进一步优化。

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

## 链表系列

### [剑指 Offer 24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

#### 问题

```java
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 

限制：

0 <= 节点个数 <= 5000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```



#### 题目解析

1. #### 利用外部空间

   填入数组或者容器，比如 ArrayList 或者 栈 这样的。

   time：o(2n)---->o(n)

   space:O(n)

2. #### 双指针迭代 (推荐)

   申请两个指针，pre、cur。

   第一个指针叫 pre，最初是指向 null 的。
   第二个指针 cur 指向 head，然后不断遍历 cur。
   每次迭代到 cur，都将 cur 的 next 指向 pre，然后 pre 和 cur 前进一位。

   都迭代完了(cur 变成 null 了)，pre 就是最后一个节点了。

   原理：循环，一个个节点拆，改变指针指向

3. ### 递归解法

   双指针是从头部开始调转指针，而递归是从尾部开展调转

   终止条件是当前节点或者下一个节点==null

   在函数内部，改变节点的指向，也就是 head 的下一个节点指向 head 递归函数那句

#### 代码

```java
	//双指针 time: O(n),space:O(1)
    public ListNode reverseList(ListNode head) {
        //申请节点，pre和 cur，pre指向null
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
	// 递归
	public ListNode reverseList(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
       if (head == null || head.next == null) {
           return head;
       }
       //这里的cur就是最后一个节点,先到最底层，再反过来调转指针
       ListNode cur = reverseList(head.next);
       //如果链表是 1->2->3->4->5，那么此时的cur就是5
	   //而head是4，head的下一个是5，下下一个是空
	   //所以head.next.next 就是5->4
       head.next.next = head;
       //防止链表循环，需要将head.next设置为空
       head.next = null;
       //每层递归函数都返回cur，也就是最后一个节点
       return cur;
    }
```



#### 涉及题解

[动画演示+多种解法 面试题24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/dong-hua-yan-shi-duo-chong-jie-fa-206-fan-zhuan-li/)

#### 已做次数：2

### [876. 链表的中间结点](https://leetcode-cn.com/problems/middle-of-the-linked-list/)

#### 问题

```java
给定一个带有头结点 head 的非空单链表，返回链表的中间结点。

如果有两个中间结点，则返回第二个中间结点。

 

示例 1：

输入：[1,2,3,4,5]
输出：此列表中的结点 3 (序列化形式：[3,4,5])
返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
注意，我们返回了一个 ListNode 类型的对象 ans，这样：
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
示例 2：

输入：[1,2,3,4,5,6]
输出：此列表中的结点 4 (序列化形式：[4,5,6])
由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 

提示：

给定链表的结点数介于 1 和 100 之间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```



#### 题目解析

1. 双循环，单指针

   先遍历一次，计算链表的长度，进而计算链表中间结点的下标（注意偶数结点的时候，得到的是中间的第二个结点），然后再遍历一次，来到所要求结点的位置。

   问题：

   - 时间复杂对太高 O(1.5n),需要遍历第二遍找元素

2. 数组存映射关系

   第一次遍历的时候，建立下标到值的映射Map，有因为题目说**给定链表的结点数介于 `1` 和 `100` 之间**，为了速度更快，建立个长度为100的数组就行。

   问题：

   - 空间复杂度太高，O(n)

3. 快慢指针

   快慢指针的前进方向相同，且它们步伐的「差」是恒定的。使用两个指针变量，刚开始都位于链表的第 1 个结点，一个永远一次只走 1 步，一个永远一次只走 2 步，一个在前，一个在后，同时走。这样当快指针走完的时候，慢指针就来到了链表的中间位置。


#### 代码

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        // 偶数：fast ！= null，奇数：fast.next != null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```



#### 涉及题解（重点，快慢的思想）

[快慢指针（注意链表长度为偶数时，返回第 2 个结点的细节）](https://leetcode-cn.com/problems/middle-of-the-linked-list/solution/kuai-man-zhi-zhen-zhu-yao-zai-yu-diao-shi-by-liwei/)

#### 已做次数：1

### [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

#### 问题

```java
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```



#### 题目解析

递归

- 如果 `l1` 或者 `l2` 一开始就是空链表 ，那么没有任何操作需要合并，所以我们只需要返回非空链表
- 否则，我们要判断 `l1` 和 `l2` 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点
- 如果两个链表有一个为空，递归结束。

迭代

- 首先我们**维护一个 prehead 的哨兵节点**
- 我们其实**只需要调整它的 next 指针**。让它总是**指向l1或者l2中较小的一个，直到l1或者l2任一指向null**
- 样到了最后，如果l1还是l2中任意一方还有余下元素没有用到，那**余下的这些元素一定大于prehead已经合并完的链表（因为是有序链表）**
- 我们只需要将这些元素全部追加到prehead合并完的链表后，最终就得到了我们需要的链表

#### 代码

```java
// 递归
// time:O(n)
// space:O(n) 递归栈空间的大小取决于递归调用的深度
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 终止条件
        if (null == l1) {
            return l2;
        }else if (null == l2) {
            return l1;
        }

        //判断哪个值最小
        if (l1.val < l2.val) {
            // 递归
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            // 递归
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
// 迭代
// time:O(n)
// space:O(1) 只要一个哨兵节点
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode sentry = preHead;
        while (l1 != null && l2 != null) {
            //调整它的 next 指针。让它总是指向l1或者l2中较小的一个，直到l1或者l2任一指向null
            //然后较小的向前移一位
            if (l1.val <= l2.val) {
                sentry.next = l1;
                l1 = l1.next;
            } else {
                sentry.next = l2;
                l2 = l2 .next;
            }
            // 哨兵前移
            sentry = sentry.next;
        } 

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        // 顺便做了传入参数的验证
        sentry.next = l1 == null ? l2 : l1;

        return preHead.next;
    }
}
```



#### 涉及题解

[合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/)

#### 已做次数：1

## X数之和

### 三数之和

#### 问题

```java
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```

#### 题目解析

暴力法

		三层循环，时间复杂度O^3

双指针

		将 a + b + c = 0变为 -c = a + b，先固定一个值，剩下的就是求两数之和

#### 代码

```java
	// time: O^2,space:O(1)
 	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for(int k = 0; k < nums.length - 2; k++) {
			// 图标是排序，大于0就不用比较了
            if (nums[k] > 0) {
				break;
			}
             // 和前一个数一样就不用比较了
			if (k > 0 && nums[k] == nums[k - 1]){
				continue;
			}
             // 左指针
			int i = k + 1;
             // 右指针
			int j = nums.length - 1;
			while (i < j) {
				int sum = nums[k] + nums[i] + nums[j];
				if (sum < 0) {
                     // 去除重复数字
					while(i < j && nums[i] == nums[++i]);
				}
				if (sum > 0) {
                     // 去除重复数字
					while(i < j && nums[j] == nums[--j]);
				}
				if (sum == 0) {
					res.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
					// 去除重复数字
                    while(i < j && nums[i] == nums[++i]);
					while(i < j && nums[j] == nums[--j]);
				}
			}
		}
		return res;
    }
```

#### 涉及题解

[三数之和](https://www.geekxh.com/1.0.%E6%95%B0%E7%BB%84%E7%B3%BB%E5%88%97/008.html#_02%E3%80%81%E9%A2%98%E7%9B%AE%E5%88%86%E6%9E%90)

#### 已做次数：2

## 动态规划

### [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

#### 问题

```java
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```



#### 题目解析

很简单,从高往低推.假设你站着n台阶上,能到达n台阶只有两种方式,

- 由n-1向上走一步
- 由n-2向上走两步

所以f(n) = f(n-1) + f(n-2)

#### 代码

```java
//time:O(n),space:(1)
public int climbStairs(int n) {
    	if (n <= 2) {
    		return n;
		}
    	int f1 = 1;
    	int f2 = 2;
    	int f3 = 0;
        // 从第三位开始
    	for (int i = 3;i <= n; i++) {
    		f3 = f1 + f2;
    		f1 = f2;
    		f2 = f3;
		}
    	return f3;
    }
```



#### 涉及题解

[爬楼梯](https://www.geekxh.com/1.2.%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/201.html#_03-%E3%80%81%E5%9B%BE%E8%A7%A3%E5%88%86%E6%9E%90)

#### 已做次数:2

## 树

### [98. 验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)

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

### [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)

#### 问题

```java
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]



 

示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 

说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```



#### 题目解析

**祖先的定义：**若节点 p 在节点 root的左（右）子树中，或 p = root，则称 root是 p的祖先。

**最近公共祖先**：对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（离他俩最近的）（一个节点也可以是它自己的祖先）。

根据以上定义，若 root 是 p, q的 **最近公共祖先** ，则只可能为以下情况之一：

- p和 q 在 root的子树中，且分列 root的 异侧（即分别在左、右子树中）；
  p = root ，且 q在 root 的左或右子树中；
  q = root ，且 p在 root的左或右子树中；

#### 代码

```java
// time:O(n) 最差遍历所有节点。
// space:O(n) 最差是个链表，深度N
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
        if (root == null || root == p || root == q){
            return root;
        }

        // 递归：不要多想，去人肉递归，就想当前层
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,);

        // 都为空，那就是没有
        if ( left == null && right == null ) return null;
        // right 有值，都在右侧，不管是p是q，第一个返回的就是最近公共祖先
        if (left == null) return right;
        // left 有值，都在左侧，不管是p是q，第一个返回的就是最近公共祖先
        if (right == null) return left;

        // 在异侧，当然就是当前节点了
        return root;
    }
```



#### 涉及题解

[236. 二叉树的最近公共祖先（后序遍历 DFS ，清晰图解）](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/)

#### 已做次数：2

## 排序

### 选择排序

#### 问题

选择排序是一种简单直观的排序算法，无论什么数据进去都是 O(n²) 的时间复杂度。所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。

#### 题目解析

1. 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
2. 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
3. 重复第二步，直到所有元素均排序完毕。

#### 代码

#### 涉及题解

```java
public int[] selectSort(int[] nums) {
    // 经过 n - 1 轮比较
    for (int i = 0; i < nums.length - 1; i++) {
    	// 记录每轮最小值的坐标
        int min = i;
        // 每轮比较 n - 1次
        for (int j = i; j < nums.length - 1; j++) {
            if (nums[min] > nums[j]) {
                min = j;
            }
        }
        
        // 将最小值和当前值替换
        if (i != min) {
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }
    return nums;
}
```



#### 已做次数：1

1. 快排 (0.4)
2. 归并排序 (0.3)
3. 10 万个数中找 TopK(0.3)
4. 最长回文子串 (0.2)
5. 反序字符串 (0.2)
6. 链表反转 (0.2)