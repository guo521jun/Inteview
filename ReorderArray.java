/**
 *
 *调整数组顺序使奇数位于偶数前面
 *
 *
 *
 *
 */
public class ReorderArray {
	
	//方法一
	/**
     * 1.把第一个指针指向数组的第一个位置，第二个指针指向数组的最后一个位置
     * 2.向后移动第一个指针直到他遇到偶数停止，向前移动第二个指针直到他遇到奇数停止
     * 3.交换两个指针指向的数字
     * 4.继续重复前面的操作，直到第一个指针指向第二个指针的后面，则结束。
     */
	public void reorderOddEven1(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return;
        int pBegin = 0;
        int pEnd = numbers.length-1;
        while (pBegin < pEnd) {
            //向后移动pBegin，直到他指向偶数
            while (pBegin < pEnd && (numbers[pBegin] & 0x1) != 0)
                pBegin++;
            //向前移动pEnd，直到他指向奇数
            while (pBegin < pEnd && (numbers[pEnd] & 0x1) == 0)
                pEnd--;
            if (pBegin < pEnd) {
                int temp = numbers[pBegin];
                numbers[pBegin] = numbers[pEnd];
                numbers[pEnd] = temp;
            }
        }
    }
}