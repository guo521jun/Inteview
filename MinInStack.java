 /**
  * 包含min函数的栈
  * 使用一个辅助栈，每次向数据栈中压入数据的同时，比较当前元素和辅助栈栈顶元素的大小，
  * 如果当前元素比辅助栈的栈顶元素小的话就将当前元素压入辅助栈中，否则就将辅助栈的栈顶元素重复压入辅助栈栈顶
  */
public class MinInStack {
	
	private Stack<Integer> data = new Stack<>();     //数据栈
    private Stack<Integer> min = new Stack<>();     //辅助栈

    public void push(int val) {
        //新元素添加到数据栈
        data.push(val);
        //当前元素比之前的最小元素小时，把新元素插入到辅助栈里
        //否则把之前的最小元素重复插入到辅助栈里
        if (min.size() == 0 || val < min.peek())
            min.push(val);
        else
            min.push(min.peek());
    }

    public void pop() {
        if (data.size() > 0 && min.size() > 0) {
            data.pop();
            min.pop();
        }
    }

    public int min() {
        if (data.size() > 0 && min.size() > 0)
            return min.peek();
        return -1;
    }
}