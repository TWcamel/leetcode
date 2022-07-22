class Solution {
  public String intToRoman(int num) {
    int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] strs = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    Map<Integer, String> maps = new HashMap<>();
    for (int i = 0; i < values.length; ++i) {
      maps.put(values[i], strs[i]);
    }

    int power = 1000;
    StringBuilder result = new StringBuilder();

    while (power > 0.5) {
      int lead = (int) Math.floor(num / power) % 10;
      if (power > 0) {
        StringBuilder c = new StringBuilder();
        String r = maps.getOrDefault(power * lead, "Q");
        if (!r.equals("Q"))
          c.append(r);
        else {
          if (lead < 4)
            c = new StringBuilder(maps.get(power).repeat(lead));
          else if (lead > 5)
            c.append(maps.get(power * 5)).append(maps.get(power).repeat(lead - 5));
        }
        result.append(c);
      }
      power /= 10;
    }
    return result.toString();
  }
  /*
   * maps = {
   * 1000: {
   * 1: M
   * },
   * 100: {
   * 1: C, 4: CD, 5: D, 9: CM
   * },
   * 10: {
   * 1: X, 4: XL, 5: L, 9: XC
   * },
   * 1: {
   * 1: I, 4: IV, 5: V, 9: IX
   * }
   * }
   */
}
