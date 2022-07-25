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
  /*
   * Time: O(n)
   * Space: O(1)
   */
  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode currentNode = dummy;
    while (currentNode.next != null && currentNode.next.next != null) {
      ListNode tempNode = currentNode.next;
      ListNode tempNode1 = currentNode.next.next.next;
      currentNode.next = currentNode.next.next; // 1
      currentNode.next.next = tempNode; // 2
      tempNode.next = tempNode1; // 3
      currentNode = currentNode.next.next;
    }
    return dummy.next;
  }
  /*
   * 考的是對於指標的常規操作，關鍵在於：
   * 1. while 迴圈的終止條件是否正確
   * 2. //1 更新後，原本 currentNode -> 1 的橋樑斷了，所以要另設暫存節點 temp、temp1 來紀錄 //2、//3 要走的節點
   */
}
