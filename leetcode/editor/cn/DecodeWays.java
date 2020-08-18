package editor.cn;

//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划 
// 👍 475 👎 0

class DecodeWays{
	public static void main(String[] args) {
		Solution solution = new DecodeWays().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
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
//leetcode submit region end(Prohibit modification and deletion)

}
