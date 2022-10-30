public class Solution {
  /*
   * Time: O(n)
   * Space: O(n)
   */
  public boolean isAnagram(String s, String t) {
    int[] alphabetMap = new int[26];
    for (int i = 0; i < s.length(); i++) {
      alphabetMap[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      alphabetMap[s.charAt(i) - 'a']--;
    }
    for (int i =0; i < 26; i++) {
      if (alphabetMap[i] != 0)
        return false;
    }
    return true;
  }
}
