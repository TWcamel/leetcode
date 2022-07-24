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
  public ListNode removeElements(ListNode head, int val) {

    if (head == null)
      return head; // 如果收到空頭節點，直接返回

    // 若頭節點開始有一個以上的目標值符合條件，就要一直更換節點值，因此用 while，而不是 if
    while (head != null && head.val == val) {
      head = head.next;
    }

    // 要刪除的節點要用上一個節點來指向下下個節點，要將目前節點節點做紀錄，因此用 cur = head，而不是 cur = head.next
    ListNode cur = head;

    // cur && cur.next 皆不能為 null，因為要用這兩個節點的值來判斷與 val 是否相同
    while (cur != null && cur.next != null) {
      if (cur.next.val == val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }

    return head;
  }

  /*
   * 分析：
   * 這裡用的解法需要區分，1. 節點剛好是 target，2.若不是頭節點 == target.
   * 那能否找到一個統一的方式來新增以及刪除節點元素呢？
   * -> 關鍵在於我們不知道 head 沒有上一個節點，
   * 所以我們只要給一個虛擬節點就可以完成上述操作
   */
}

class Solution {
  public ListNode removeElements(ListNode head, int val) {

    if (head == null)
      return head; // 如果收到空頭節點，直接返回

    ListNode dummyHead = new ListNode(0); // 產生新的 dummyHead
    dummyHead.next = head; // 指向原來 linked list 的頭節點，讓最後結果更新後的 linked list 可以返回
    ListNode cur = dummyHead; // 要刪除的是原 linked list 的內容，因此用 dummyHead，而不是 dummyHead.next

    while (cur.next != null) {
      if (cur.next.val == val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }

    return dummyHead.next; // 返回原來 linked list 的頭節點
  }
}
