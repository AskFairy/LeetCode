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

#### [有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)

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
		return true;
    }
```

时间复杂度：O(n)

空间复杂度：O(n)

已做次数：1

#### [最小栈（未完成）](https://leetcode-cn.com/problems/min-stack/)

LeetCode地址：https://leetcode-cn.com/problems/min-stack/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

### 实战题目

#### [柱状图中最大的矩形（未完成）](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)

LeetCode地址：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

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

## 第五课

### 实战题目/课后作业

#### [有效的字母异位词（未完成）](https://leetcode-cn.com/problems/valid-anagram/)

LeetCode地址：https://leetcode-cn.com/problems/valid-anagram/description/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：

#### [字母异位词分组（未完成）](https://leetcode-cn.com/problems/group-anagrams/)

LeetCode地址：https://leetcode-cn.com/problems/group-anagrams/

代码：

```java

```

时间复杂度：

空间复杂度：

已做次数：