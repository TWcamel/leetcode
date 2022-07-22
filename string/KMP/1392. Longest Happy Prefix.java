/*
    ** 簡單解法：使用程式語言特性解題 **
    test case 1: a b x x a b

    Time: O(N*M)
    Space: O(K)
*/

class Solution {
  public String longestPrefix(String s) {
    int length = 0;
    for (int i = 1; i < s.length(); ++i) {
      if (s.substring(0, i).equals(s.substring(s.length() - i))) {
        length = i;
      }
    }
    return s.substring(0, length);
  }
}

/*
 ** KMP **
 * test case 1: a b x x a b
 * i 6
 * prefix a b
 * prefixLen 2
 * 
 * test case 2: a b a x a b a b a x (重複資料)
 * i 7
 * lhp 0 0 1 0 1 2 3
 * prefix
 * prefixLen 3
 * 
 * Time: O(N)
 * Space: O(M)
 */

class Solution {

  /* test case 1: a b x x a b (OK) */
  /* test case 2: a b a x a b a b a x (Fail) */

  public String longestPrefix(String s) {
    int prefixLen = 0;
    int i = 1;
    while (i < s.length()) {
      if (s.charAt(i) == s.charAt(prefixLen))
        prefixLen++;
      else
        prefixLen = 0;
      i++;
    }
    return s.substring(0, prefixLen);
  }
  /*
   * 分析：每當 prefix 不相等於s[i]，在重複資料的測資下會因為把 prefixLen 歸零而錯誤
   * 錯誤的原因是沒有利用到重複的資訊
   */
}

class Solution {

  /* test case 1: a b x x a b (OK) */
  /* test case 2: a b a x a b a b a x (OK) */

  public String longestPrefix(String s) {
    int prefixLen = 0;
    int i = 1;
    int[] lhp = new int[s.length()];
    while (i < s.length()) {
      if (s.charAt(i) == s.charAt(prefixLen)) {
        prefixLen++;
        lhp[i] = prefixLen;
        i++;
      } else {
        if (prefixLen > 0)
          prefixLen = lhp[prefixLen - 1];
        else {
          lhp[i] = 0;
          prefixLen = 0;
          i++;
        }
      }
    }
    return s.substring(0, prefixLen);
  }
}
