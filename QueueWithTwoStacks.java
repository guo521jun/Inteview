/**
 *
 *用两个栈实现队列
 *删除一个元素的步骤：
 *1.当stack2不为空时，在stack2中的栈顶元素是最先进入队列的元素，可以弹出
 *2.当stack2为空时，我们把stack1中的元素逐个弹出压入到stack2中，由于先进入队列的元素
 *被压入到stack1的栈底，经过弹出和压入操作之后就处于stack2的栈顶，就可以直接弹出。
 *
 */
import java.util.Stack;

public class QueueWithTwoStacks {
	
	private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public void appendTail(Integer t) {
        stack1.push(t);
    }

    public Integer deleteHead() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.size() == 0)
            throw new RuntimeException("query is empty");
        return stack2.pop();
    }
}