class Solution {
  public int removeElement(int[] nums, int val) {
    if (nums.length == 0)
      return 0;
    int tail = nums.length;
    for (int i = 0; i < tail; ++i) {
      if (nums[i] == val) {
        for (int j = i; j < tail - 1; ++j) {
          nums[j] = nums[j + 1];
        }
        tail--;
        i--; // 因為 array (tail--) 空間變小了，所以 i 在下次迭代要在原地
      }
    }
    return tail;
  }
}
