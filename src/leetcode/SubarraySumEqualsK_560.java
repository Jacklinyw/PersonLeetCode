package leetcode;

import java.util.HashMap;
import java.util.Map;

/** Created with IntelliJ IDEA. User: Linyw Date: 2021/9/4 Time: 11:08 Description: 和为K的子数组 */
public class SubarraySumEqualsK_560 {
  /*
   给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
   示例 1：
   输入：nums = [1,1,1], k = 2
   输出：2
   示例 2：
   输入：nums = [1,2,3], k = 3
   输出：2
   提示：
   1 <= nums.length <= 2 * 104
   -1000 <= nums[i] <= 1000
   -107 <= k <= 107
  */

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    int k = 3;
    System.out.println(subArraySum(nums, k));
  }

  /*
  前缀和 + 哈希优化
  和为K
  num[i] + k = num[pre]
  和为k，实际上是pre-i=k
  给map里面放pre (前缀和)
  然后判断 map里面有没有pre - k
   */
  public static int subArraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int count = 0;
    int pre = 0;
    for (int num : nums) {
      pre += num;
      if (map.containsKey(pre - k)) {
        count += map.get(pre - k);
      }
      map.put(pre, map.getOrDefault(pre, 0) + 1);
    }
    return count;
  }
}
