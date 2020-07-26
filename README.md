# LeetCode
LeetCode习题集

## 第三课

### Array 实战题目

#### [盛最多水的容器](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/ContainerWithMostWater.java)

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

### 课后作业

#### [删除数组中的重复项](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/RemoveDuplicatesFromSortedArray.java)

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

#### [旋转数组](https://github.com/AskFairy/LeetCode/blob/master/leetcode/editor/cn/RotateArray .java)

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