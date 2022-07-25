/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = 0, lenB = 0;
    ListNode currA = headA, currB = headB;

    while (currA != null) { // 求鍊錶 A 的長度
      lenA++;
      currA = currA.next;
    }

    while (currB != null) { // 求鍊錶 B 的長度
      lenB++;
      currB = currB.next;
    }

    currA = headA;
    currB = headB;

    // 讓 currA 為最長鍊錶的頭，lenA 為其長度
    if (lenB > lenA) {
      // 1. swap (lenA, lenB);
      int tempLen = lenA;
      lenA = lenB;
      lenB = tempLen;
      // 2. swap (curA, curB);
      ListNode tempNode = currA;
      currA = currB;
      currB = tempNode;
    }

    int gap = lenA - lenB;
    while (gap-- > 0) { // 讓 currA 和 currB 在同一起點上（末尾位置對齊）
      currA = currA.next;
    }

    while (currA != null) { // 遍歷 currA 和 currB，遇到相同則直接返回
      if (currA == currB) {
        return currA;
      }
      currA = currA.next;
      currB = currB.next;
    }
    return null;
  }
}
