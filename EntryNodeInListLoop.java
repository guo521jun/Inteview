/**
 * 链表中环的入口节点
 *1.找出环中任意一个节点
 *2.得到环中节点的数目
 *3.得到环的入口节点
 */
public class EntryNodeInListLoop {
	
	/**
     * 定义两个指针指向链表的头结点，如果链表中的环有n各节点，则指针1先在链表上向前移动n步，
     * 然后两个指针以相同的速度向前移动，当第二指针指向环的入口节点时，
     * 第一个指针已经围绕环已经走了一圈，又回到了入口节点。
     */
	public ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null)
            return null;
        //得到环中节点的数目
        int nodesInLoop = 1;
        ListNode pNode1 = meetingNode;
        while (pNode1.next != meetingNode) {
            pNode1 = pNode1.next;
            ++nodesInLoop;
        }
        //先移动pNode1，移动次数为环中节点的数目
        pNode1 = pHead;
        for (int i = 0; i < nodesInLoop; i++)
            pNode1 = pNode1.next;
        //在移动pNode1和pNode2
        ListNode pNode2 = pHead;
        while (pNode1 != pNode2) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }

	 /**
     * 定义两个指针，同时从链表的头结点出发，一个指针一次走一步，另一个指针一次走两步，
     * 如果走的快的指针追上了走的慢的指针，那么链表就包含环，
     * 如果走的快的指针走到了链表的末尾都没有赶上追上第一个指针，那么链表就不包含环。
     */
    private ListNode meetingNode(ListNode pHead) {
        if (pHead == null)
            return null;
        ListNode pSlow = pHead.next;
        if (pSlow == null)
            return null;
        ListNode pFast = pSlow.next;
        while (pFast != null && pSlow != null) {
            if (pFast == pSlow)
                return pFast;
            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast != null)
                pFast = pFast.next;
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}