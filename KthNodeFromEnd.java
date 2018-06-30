/**
 *链表中倒数第k个节点
 * 定义两个指针，第一个指针从链表的头结点开始遍历向前走k-1步，第二个指针保持不动，
 * 从第k步开始，第二个指针也开始从链表的头结点开始遍历，由于两个指针的距离保持在k-1，
 * 当地一个指针走到链表的尾节点时，第二个指针正好指向倒数第k个节点。
 */
public class KthNodeFromEnd {
	
	public ListNode kthNodeFromEnd(ListNode pHead, int k) {
        //防止出现空指针
        if (pHead == null || k == 0)
            return null;
        ListNode pAhead = pHead;
        ListNode pBehind = null;
        for (int i = 0; i < k-1; i++) {
            //防止链表节点的个数小于k
            if (pAhead.next != null)
                pAhead = pAhead.next;
            else
                return null;
        }
        pBehind = pHead;
        while (pAhead.next != null) {
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }
        return pBehind;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}