public class Solution {
  /*
   * 解法一： HashMap方法，
   * 因為題目要求字串 Megazine 能組成字串 RansomNote，
   * 反向不需要確認, 因此可以使用解法二： array 法
   * Time: O(n)
   * Space: O(n)
   */
  public boolean canConstruct(String ransomNote, String magazine) {
    HashMap<Character, Integer> rSet = new HashMap<>();
    HashMap<Character, Integer> mSet = new HashMap<>();

    boolean res = true;

    for (char c : ransomNote.toCharArray()) {
      rSet.put(c, rSet.getOrDefault(c, 0) + 1);
    }

    for (char c : magazine.toCharArray()) {
      mSet.put(c, mSet.getOrDefault(c, 0) + 1);
    }

    for (Map.Entry<Character, Integer> entry : rSet.entrySet()) {
      if (!mSet.containsKey(entry.getKey()) ||
          mSet.getOrDefault(entry.getKey(), -1) < rSet.get(entry.getKey()))
        res = false;
    }
    return res;
  }
}

public class Solution {
  /*
   * 解法二： array 法，
   * Time: O(n)
   * Space: O(1)
   */
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] record = new int[26];

    for (Character c : magazine.toCharArray()) {
      record[c - 'a']++;
    }

    for (Character c : ransomNote.toCharArray()) {
      record[c - 'a']--;
    }

    for (int i : record) {
      if (i < 0)
        return false;
    }

    return true;

  }
}
