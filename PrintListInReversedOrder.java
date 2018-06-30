/**
 *
 *从尾到头打印链表
 *遍历链表的顺序是从头到尾，可输出的顺序是从尾到头
 *第一个遍历到的节点最后一个输出，最后一个遍历到的节点第一个输出
 *后进先出，可以使用栈来实现。
 *
 */
import java.util.Stack;
 
public class PrintListInReversedOrder {
	
	public void printListReversinglyIteratively(ListNode pHead) {
        Stack<ListNode> nodes = new Stack<>();
        ListNode pNode = pHead;
        while (pNode != null) {
            nodes.push(pNode);
            pNode = pNode.next;
        }
        while (!nodes.empty()) {
            pNode = nodes.peek();
            System.out.println(pNode.val);
            nodes.pop();
        }
    }
	
	 public void printListReversinglyRecursively(ListNode pHead) {
        if (pHead != null) {
            if (pHead.next != null)
                printListReversinglyRecursively(pHead.next);
            System.out.println(pHead.val);
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