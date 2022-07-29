/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
  /*
   * 如何想到快慢指針解法：
   * 因為快指針走兩步 = 慢指針走一步,
   * 若鏈表中存在環，則兩指針一定相遇
   * 
   * 題目有兩個主要問題：
   * 1. 鍊錶中是否存在環
   * 2. 存在環的鍊表如何找到入口處
   * 設:
   * x = 從 head 走到入口處的距離
   * y = 從入口處到快、慢指針相遇的地點
   * z = 從相遇地到入口處
   * 可畫簡單的圖，可找到 x = z
   */
  public ListNode detectCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        ListNode idx1 = head;
        while (fast != idx1) {
          fast = fast.next;
          idx1 = idx1.next;
        }
        return idx1;
      }
    }
    return null;
  }
}
