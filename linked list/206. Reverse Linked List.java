/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  /* 雙指針寫法 */
  public ListNode reverseList(ListNode head) {
    ListNode curr = head;
    ListNode pre = null;
    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = pre;
      pre = curr;
      curr = temp;
    }
    return pre;
  }
}

class Solution {
  /* 遞迴寫法 */
  public ListNode reverseList(ListNode head) {
    return reverse(head, null);
  }

  public ListNode reverse(ListNode curr, ListNode pre) {
    if (curr != null) {
      ListNode temp = curr.next;
      curr.next = pre;
      return reverse(temp, curr);
    }
    return pre;
  }
}
