public class Solution {
  /*
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
