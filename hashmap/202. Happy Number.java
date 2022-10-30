public class Solution {
  /*
   * Time: O(n)
   * Space: O(n)
   */
  public int getSum(int x) {
    int tmp = x;
    int sum = 0;
    while (tmp > 0) {
      sum += (tmp % 10) * (tmp % 10);
      tmp /= 10;
    }
    return sum;
  }

  public boolean isHappy(int n) {
    HashSet<Integer> set = new HashSet<>();
    while (true) {
      int sum = getSum(n);
      if (sum == 1)
        return true;
      if (set.contains(sum))
        return false;
      else
        set.add(sum);
      n = sum;
    }
  }
}
