public class ListNode {
  // 節點的值
  int val;

  // 節點的指針
  ListNode next;

  // 節點無參數的構造函數
  ListNode() {

  }

  // 節點構造函數(一個參數)
  ListNode(int val) {
    this.val = val;
  }

  // 節點構造函數(兩個參數)
  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

}
