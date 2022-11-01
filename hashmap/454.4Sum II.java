public class Solution {
  /*
   * Time: O(N*M)
   * Space: O(N*M*K*L)
   */
  public int fourSumCount(int num1[], int num2[], int num3[], int num4[]) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int a : num1) {
      for (int b : num2) {
        map.put(a + b, map.getOrDefault(a + b, 0) + 1);
      }
    }

    int count = 0;

    for (int c : num3) {
      for (int d : num4) {
        if (map.get(0 - (c + d)) != null) {
          count += map.get(0 - (c + d));
        }
      }
    }

    return count;
  }
}
