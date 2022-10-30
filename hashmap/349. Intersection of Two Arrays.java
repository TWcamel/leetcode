public class Solution {
  /*
   * Time: O(n)
   * Space: O(n)
   */
  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
      return new int[0];
    HashSet<Integer> SNum1 = new HashSet<>();
    HashSet<Integer> SRes = new HashSet<>();

    for (int i : nums1) {
      SNum1.add(i);
    }

    for (int i : nums2) {
      if (SNum1.contains(i))
        SRes.add(i);
    }

    return SRes.stream().mapToInt(n -> n).toArray();
  }
}
