/**
 *
 *删除链表中重复的节点
 *
 *
 */
public class DeleteDuplicatedNode {
	
	public void deleteDuplication(ListNode pRoot) {
        if (pRoot == null)
            return;
        ListNode pPreNode = null;
        ListNode pNode = pRoot;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            boolean needDelete = false;
            if (pNext != null && pNext.val == pNode.val)
                needDelete = true;
            if (!needDelete) {
                pPreNode = pNode;
                pNode = pNode.next;
            } else {
                int value = pNode.val;
                ListNode pToBeDel = pNode;
                while (pToBeDel != null && pToBeDel.val == value) {
                    pNext = pToBeDel.next;
                    pToBeDel = null;
                    pToBeDel = pNext;
                }
                if (pPreNode == null)
                    pRoot = pNext;
                else
                    pPreNode.next = pNext;
                pNode = pNext;
            }
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