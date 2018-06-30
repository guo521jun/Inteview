/**
 *
 *斐波那契数列的应用：
 *1.青蛙跳台阶
 *2.铺地砖问题
 *
 */
public class Fibonacci {
	
	/**
	 *
	 *递归实现
	 */
	public int fibonacci1(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci1(n-1) + fibonacci1(n-2);
    }

	/**
	 *
	 *循环迭代实现
	 */
    public int fibonacci2(int n) {
        int[] result = {0, 1};
        if (n < 2)
            return result[n];
        int fibOfOne = 0;
        int fibOfTwo = 1;
        int fibOfN = 0;
        for (int i = 2; i <= n; i++) {
            fibOfN = fibOfOne + fibOfTwo;
            fibOfOne = fibOfTwo;
            fibOfTwo = fibOfN;
        }
        return fibOfN;
    }
}