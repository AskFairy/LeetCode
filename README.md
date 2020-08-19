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

#### [滑动窗口最大值（未完成）](https://leetcode-cn.com/problems/sliding-window-maximum/)

LeetCode地址：https://leetcode-cn.com/problems/sliding-window-maximum/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

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

## 第12课 动态规划

### 本周作业

#### [91. 解码方法](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/DecodeWays.java)

LeetCode地址：https://leetcode-cn.com/problems/decode-ways/

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

