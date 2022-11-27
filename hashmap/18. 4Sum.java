class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList();
    Arrays.sort(nums);
    for (int k = 0; k < nums.length; k++) {
      if (nums[k] > target && target > 0) {
        break;
      }
      if (k > 0 && nums[k] == nums[k - 1]) {
        continue;
      }
      for (int i = k + 1; i < nums.length; i++) {
        if (nums[k] + nums[i] > target && target > 0) {
          break;
        }
        if (i > k + 1 && nums[i] == nums[i - 1]) {
          continue;
        }
        int l = i + 1, r = nums.length - 1;
        while (r > l) {
          long sum = (long) nums[k] + nums[i] + nums[l] + nums[r];
          if (sum > target) {
            r--;
          } else if (sum < target) {
            l++;
          } else {
            res.add(Arrays.asList(nums[k], nums[i], nums[l], nums[r]));
            while (r > l && nums[r] == nums[r - 1]) {
              r--;
            }
            while (r > l && nums[l] == nums[l + 1]) {
              l++;
            }
            l++;
            r--;
          }
        }
      }
    }
    return res;
  }
}
