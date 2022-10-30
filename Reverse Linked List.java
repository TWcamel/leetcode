public class ListNode {
  int val;
  LitsNode next;
  ListNode() {}
  ListNode(int _val) {
    this.val = _val;
  }
}

public class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode curr = head;
    ListNode pre = null;
    while (curr != null) {
      ListNode tmp = curr.next;
      curr.next = pre;
      pre = curr;
      curr = temp;
    }
    return pre;
  }
}

public class Soulution {
  public ListNode reverList(ListNode head) {
    helper(head, null);
  }
  public ListNode helper(ListNode curr, ListNode pre){
    if (curr != null) {
      ListNode tmp = curr.next;
      curr.next = pre;
      helper(tmp, curr);
    }   
    return pre;
  }
}


