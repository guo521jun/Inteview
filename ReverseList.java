/**
 *反转链表
 *一个链表，把i之前所有节点的next都指向前一个节点，导致链表在i,j之间断裂
 *我们在调整节点i的next指针时，除了知道节点i本身，还需要知道i的前一个节点h，
 *因为我们需要把节点i的next指向前一个节点，同时，我们还需要事先保存i的下一个节点
 *，以防止链表断裂
 */
public class ReverseList {
	
	public ListNode reverseList(ListNode pHead) {
        ListNode pReverseHead = null;
        ListNode pNode = pHead;
        ListNode pPrev = null;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            if (pNext == null)
                pReverseHead = pNode;
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pReverseHead;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}