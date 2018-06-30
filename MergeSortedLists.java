/**
 *
 *合并两个排序的链表
 *1.如果第一个链表为空，则合并后的链表即为第二个链表
 *2.如果第二个链表为空，则合并后的链表为第一个链表
 *3.两个链表都不为空，则使用两个指针指向两个链表的头指针，然后依次进行比较，较小的
 *作为合并链表的头，依次进行递归调用。
 */
public class MergeSortedLists {
	
	public ListNode merge(ListNode pRoot1, ListNode pRoot2) {
        if (pRoot1 == null)
            return pRoot2;
        else if (pRoot2 == null)
            return pRoot1;
        ListNode pMergeHead = null;
        if (pRoot1.val < pRoot2.val) {
            pMergeHead = pRoot1;
            pMergeHead.next = merge(pRoot1.next, pRoot2);
        } else {
            pMergeHead = pRoot2;
            pMergeHead.next = merge(pRoot1, pRoot2.next);
        }
        return pMergeHead;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}