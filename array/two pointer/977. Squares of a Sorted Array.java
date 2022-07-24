class Solution {
    /*
    method: 雙指針 (也可以使用暴力解：Quick Sort (Time: O(n + logn)) 來解)
    time: O(N)
    time: O(N)
    */
    public int[] sortedSquares(int[] nums) {
        int k = nums.length-1;
        int[] res = new int[nums.length];
        for (int i = 0, j = nums.length - 1; i <= j;) {
            if (Math.pow(nums[j],2) > Math.pow(nums[i],2)) { 
                res[k--] = (int)Math.pow(nums[j--],2);
            } else {
                res[k--] = (int)Math.pow(nums[i++],2);
            }
        }
        return res;
    }
    /*
    -4 -1 0 3 10
    
    16  1 0 9 100
    
    i          j
    
    
    return (idx k)
    
    _ _ _ 16 100
          k-- k--
          i++ j--
    */
}
