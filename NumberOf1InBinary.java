/**
 *二进制中1的个数
 *把一个整数减去1再和原来的整数做位与运算，
 *得到的结果相当于把整数的二进制表示中最右边的1变成0
 *
 */
public class NumberOf1InBinary {
	
	/**
     * 首先把n与1做与运算，判断n的最低位是不是1，接着把1左移一位得到2，
     * 再和n做与运算，就能判断n的次低位是不是1，这样反复左移，每次都能判断n的其中一位是不是1
     */
    public int numberOf1Solution1(int n) {
        int count = 0;
        int flag = 1;
        while (flag > 0) {
            if ((flag & n) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 把一个整数减去1，再和原来的整数做与运算，会把该整数最右边的1变成0，
     * 一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作
     */
    public int numberOf1Solution2(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n-1) & n;
        }
        return count;
    }
}