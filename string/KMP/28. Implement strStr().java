class Solution {
  /*
   * 
   * Test Case (OK): haystack = "hello" needle = "ll" output = 0
   * Test Case (Fail): haystack = "mississippi" needle = "issip" output = 4
   * 
   * haystack h e l e l o
   * hIdx 0
   * needle l l
   * 
   * nIdx 0
   * 
   */
  public int strStr(String haystack, String needle) {
    if (needle.length() == 0)
      return 0;

    int hIdx = 0;
    int nIdx = 0;

    while (hIdx < haystack.length()) {
      if (haystack.charAt(hIdx) == needle.charAt(nIdx)) {
        hIdx++;
        nIdx++;
      } else {
        nIdx = 0;
        hIdx++;
      }
      if (nIdx == needle.length())
        return hIdx - needle.length();
    }

    return -1;
  }
  /*
   * 分析：
   * 沒中時 nIdx 歸零會出錯，關鍵在於 a b a 跳到 b 時，重複字串沒複用到下次迭代，因此需要新增 array 紀錄
   * 
   * haystack a b a b a x
   * hIdx 6
   * 
   * needle a b a x
   * nIdx 4
   * 
   * lhp 0 0 1 0
   * 
   */

}

class Solution {
  /*
   * Test Case (OK): haystack = "hello" needle = "ll" output = 0
   * Test Case (OK): haystack = "mississippi" needle = "issip" output = 4
   */
  public int strStr(String haystack, String needle) {
    if (needle.length() == 0)
      return 0;

    int hIdx = 0;
    int nIdx = 0;
    int[] lhp = generateLHP(needle);

    while (hIdx < haystack.length()) {
      if (haystack.charAt(hIdx) == needle.charAt(nIdx)) {
        hIdx++;
        nIdx++;
      } else {
        if (nIdx > 0) {
          nIdx = lhp[nIdx - 1];
        } else {
          hIdx++;
        }
      }
      if (nIdx == needle.length())
        return hIdx - needle.length();
    }

    return -1;
  }

  public int[] generateLHP(String needle) {
    int[] lhp = new int[needle.length()];
    lhp[0] = 0;

    int i = 1;
    int prefixLen = 0;

    while (i < needle.length()) {
      if (needle.charAt(prefixLen) == needle.charAt(i)) {
        prefixLen++;
        lhp[i] = prefixLen;
        i++;
      } else {
        if (prefixLen > 0) {
          prefixLen = lhp[prefixLen - 1];
        } else {
          lhp[i] = 0;
          prefixLen = 0;
          i++;
        }
      }
    }

    return lhp;

  }
  /*
   * 
   * haystack a b a b a x
   * hIdx 6
   * 
   * needle a b a x
   * nIdx 4
   * 
   * lhp 0 0 1 0
   * 
   */

}
