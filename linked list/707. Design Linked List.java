class ListNode {
  int val;
  ListNode next;
  ListNode prev;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

}

class MyLinkedList {

  /*
   * Method1:單向向鍊錶
   */

  int size;
  ListNode dummyHead;

  public MyLinkedList() {
    size = 0;
    dummyHead = new ListNode(0);
  }

  public int get(int index) {
    if (index >= size || index < 0) {
      return -1;
    }
    ListNode currentNode = dummyHead;
    int i = 0;
    while (i++ <= index) {
      currentNode = currentNode.next;
    }
    return currentNode.val;

  }

  public void addAtHead(int val) {
    addAtIndex(0, val);
  }

  public void addAtTail(int val) {
    addAtIndex(size, val);
  }

  // 在第 index 個節點之前插入一個新節點，例如 index 為 0，那麼新插入的節點為鍊錶的新頭節點。
  // 如果 index 等於鍊錶的長度，則說明是新插入的節點為鍊錶的尾結點
  // 如果 index 大於鍊錶的長度，則返回空
  public void addAtIndex(int index, int val) {
    if (size < index)
      return;
    if (index < 0)
      index = 0;
    ListNode preNode = dummyHead;
    int i = 0;
    while (i++ < index) {
      preNode = preNode.next;
    }
    ListNode newNode = new ListNode(val);
    newNode.next = preNode.next;
    preNode.next = newNode;
    size++;
  }

  // 刪除第 index 個節點，需要將指針指向要刪除的節點的前一個節點，例如 index 為 0，那麼刪除的節點為鍊錶的虛擬頭節點。
  public void deleteAtIndex(int index) {
    if (index < 0 || index >= size)
      return;
    ListNode preNode = dummyHead;
    int i = 0;
    while (i++ < index) {
      preNode = preNode.next;
    }
    preNode.next = preNode.next.next;
    size--;
  }

}

class MyLinkedList {

  /*
   * Method2:雙向鍊錶
   */

  int size;
  ListNode dummyHead, dummyTail;

  public MyLinkedList() {
    size = 0;
    dummyHead = new ListNode(0);
    dummyTail = new ListNode(0);
    dummyHead.next = dummyTail;
    dummyTail.prev = dummyHead;
  }

  // 通過判斷 index < (size - 1) / 2 來決定是從頭結點還是尾節點遍歷，提高效率
  public int get(int index) {
    if (index >= size || index < 0)
      return -1;
    ListNode currentNode = dummyHead;
    int i = 0;
    if (index < (size - 1) / 2) {
      while (i++ <= index) {
        currentNode = currentNode.next;
      }
    } else {
      currentNode = dummyTail;
      while (i++ <= size - index - 1) {
        currentNode = currentNode.prev;
      }
    }
    return currentNode.val;
  }

  public void addAtHead(int val) {
    ListNode currentNode = dummyHead;
    ListNode newHead = new ListNode(val);
    newHead.next = currentNode.next;
    newHead.prev = currentNode;
    currentNode.next.prev = newHead;
    currentNode.next = newHead;
    size++;
  }

  public void addAtTail(int val) {
    ListNode currentNode = dummyTail;
    ListNode newTail = new ListNode(val);
    newTail.next = currentNode;
    newTail.prev = currentNode.prev;
    currentNode.prev.next = newTail;
    currentNode.prev = newTail;
    size++;
  }

  // 在第 index 個節點之前插入一個新節點，例如 index 為 0，那麼新插入的節點為鍊錶的新頭節點。
  // 如果 index 等於鍊錶的長度，則說明是新插入的節點為鍊錶的尾結點
  // 如果 index 大於鍊錶的長度，則返回空
  public void addAtIndex(int index, int val) {
    if (index > size)
      return;
    else if (index < 0)
      index = 0;
    ListNode currentNode = dummyHead;
    int i = 0;
    while (i++ < index) {
      currentNode = currentNode.next;
    }
    ListNode newNode = new ListNode(val);
    newNode.next = currentNode.next;
    newNode.prev = currentNode;
    currentNode.next.prev = newNode;
    currentNode.next = newNode;
    size++;
  }

  // 刪除第 index 個節點，需要將指針指向要刪除的節點的前一個節點，例如 index 為 0，那麼刪除的節點為鍊錶的虛擬頭節點。
  public void deleteAtIndex(int index) {
    if (index >= size)
      return;
    ListNode currentNode = dummyHead;
    int i = 0;
    while (i++ < index) {
      currentNode = currentNode.next;
    }
    currentNode.next.next.prev = currentNode;
    currentNode.next = currentNode.next.next;
    size--;
  }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

// refer to:
// https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0707.%E8%AE%BE%E8%AE%A1%E9%93%BE%E8%A1%A8.md
