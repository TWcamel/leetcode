class Solution {
  /*
   * Time: O(N)
   * Space:O(1)
   */

  public int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target)
        return mid;
      if (target > nums[mid])
        l = mid + 1;
      else
        r = mid - 1; // 如果用 mid-- or mid++，會發生 time limit exceeded 問題
    }
    return -1;
  }

  /*
   * -1 0 3 5 9 12
   * l 3
   * r 5
   * mid 4
   * 
   * target = 9
   * 
   */
}
