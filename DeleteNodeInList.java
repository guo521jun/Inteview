 /**
  *删除链表的节点
  *一个链表，在删除节点i之前，先从链表的头结点开始遍历到i前面的一个节点h，把h的next指向i的下一个节点j，再删除节点i
  * 把节点j的内容复制覆盖节点i，接下来再把节点i的next指向节点j的下一个节点，再删除节点j，这种方法不用遍历节点i前面的节点。
  */
public class DeleteNodeInList {
	
	public void deleteNode(ListNode pHead, ListNode pToBeDeleted) {
        if (pHead == null || pToBeDeleted == null)
            return;
        //要删除的节点不是尾节点
        if (pToBeDeleted.next != null) {
            ListNode pNext = pToBeDeleted.next;
            pToBeDeleted.val = pNext.val;
            pToBeDeleted.next = pNext.next;
            pNext = null;
            //链表只有一个节点，删除头结点
        } else if (pHead.val == pToBeDeleted.val) {
            pHead = null;
            pToBeDeleted = null;
            //链表中有多个节点，删除尾节点
        } else {
            ListNode pNode = pHead;
            while (pNode.next.val != pToBeDeleted.val) {
                pNode = pNode.next;
            }
            pNode.next = null;
            pToBeDeleted = null;
        }
   }

   class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
   }
}