class Solution {
  /*
   * Method1: 暴力解
   * Time: O(N^2)
   * Space: O(1)
   */
  public int minSubArrayLen(int target, int[] nums) {
    int result = Integer.MAX_VALUE; // 最後的輸出結果
    int sum = 0; // 紀錄每次 subArray 內元素加總和
    int subLen = 0; // 紀錄每次 subArray 元素個數和
    for (int i = 0; i < nums.length; ++i) { // 起始位置
      sum = 0;
      for (int j = i; j < nums.length; ++j) { // 終止位置
        sum += nums[j];
        if (sum >= target) { // 發現 sum 超過目標值，符合題意，開始更新 result
          subLen = j - i + 1;
          result = Math.min(result, subLen);
          break; // 題目是找找最短的 subArray，因此符合條件就跳出迴圈
        }
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;

  }
  /*
   * 分析：Sum 用來找 nums 內最小長度 sunArray，使用雙迴圈歷遍整個 nums
   * 但可以使用 two pointer 來做到紀錄 subArray 內兩個迴圈的工作
   */
}

class Solution {
  /*
   * Method2: Sliding Window
   * Time: O(N)
   * Space: O(1)
   */
  public int minSubArrayLen(int target, int[] nums) {
    int result = Integer.MAX_VALUE; // 最後的輸出結果
    int sum = 0;
    int sumLen = 0;
    int i = 0;
    for (int j = 0; j < nums.length; ++j) {
      sum += nums[j];
      // 用 while 而非 if 的範例：nums = [1,1,1,1,1,100], target = 100
      while (sum >= target) {
        sumLen = j - i + 1; // 取得subArray 大小
        result = Math.min(result, sumLen);
        sum -= nums[i++]; // 移動起始點
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;

  }
}
