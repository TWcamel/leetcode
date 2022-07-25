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
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = dummy;
    while (n-- > 0 && fast != null) { // 先讓 fast 走 n 步
      fast = fast.next;
    }
    fast = fast.next; // 開始移動 slow 前，共讓 fast 走 n + 1 步
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    // 此時 slow 指向要刪除節點的前一個
    slow.next = slow.next.next; // 刪除目標節點
    return dummy.next;
  }
}
