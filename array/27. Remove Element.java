class Solution {
  /*
   * method1: brute force
   * Time: O(MN)
   * Space: O(1)
   */
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
  /*
   * 分析：此解法只用了一根指針，改進方法可以用雙指針
   */
}


class Solution {
    /*
    method2: two pointer
    runner: 尋找新array的元素
    walker: 指向 更新符合條件元素
    Time: O(N)
    Space: O(1)
    */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int runner = 0, walker = 0;
        while(runner < nums.length) {
            if(nums[runner] != val)  nums[walker++] = nums[runner];
            runner++;
        }
        return walker;
    }
    /*
    3 2 2 3
    
    walker 3
    runner 3
    
    val = 2
    */
}
