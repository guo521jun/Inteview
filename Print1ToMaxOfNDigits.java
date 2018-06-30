/**
 *打印从1到最大的n位数
 *
 *
 */
public class Print1ToMaxOfNDigits {
	
	 /**
	  * 方法一：
      * 在字符串上模拟数字的加法
      */
   public void print1ToMaxOfNDigits1(int n) {
        if (n <= 0)
            return;
        char[] numbers = new char[n];
        for (int i = 0; i < n; i++)
            numbers[i] = '0';
        while (!increment(numbers))
            printNumber(numbers);
   }

    /**
     * 字符串numbers表示一个数字，数字有若干个0开头
     * 打印出这个数字，并忽略开头的0
     */
    private void printNumber(char[] numbers) {
        boolean isBegining0 = true;
        int nLength = numbers.length;
        for (int i = 0; i < nLength; i++) {
            if (isBegining0 && numbers[i] != '0')
                isBegining0 = false;
            if (!isBegining0)
                System.out.println(numbers[i]);
        }
    }

    /**
     * 字符串numbers表示一个数字，在numbers上增加1
     * 如果做加法溢出，则返回true，否则返回false
     */
    private boolean increment(char[] numbers) {
        boolean isOverFlow = false;
        int nTakeOver = 0;
        int nLength = numbers.length;
        for (int i = nLength-1; i >= 0; i--) {
            int nSum = numbers[i] - '0' + nTakeOver;
            if (i == nLength-1)
                nSum++;
            if (nSum >= 10) {
                if (i == 0)
                    isOverFlow = true;
                else {
                    nSum -= 10;
                    nTakeOver = 1;
                    numbers[i] = (char) ('0' + nSum);
                }
            } else {
                numbers[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isOverFlow;
    }

    /**
	 * 方法二：
     * 数字排列的解法，使用递归
     */
    public void print1ToMaxOfNDigits2(int n) {
        if (n <= 0)
            return;
        char[] numbers = new char[n];
        for (int i = 0; i < 10; i++) {
            numbers[0] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(numbers, n, 0);
        }
    }

    private void print1ToMaxOfNDigitsRecursively(char[] numbers, int length, int index) {
        if (index == length-1) {
            printNumber(numbers);
            return;
        }
        for (int i = 0; i < 10; i++) {
            numbers[index+1] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(numbers, length, index+1);
        }
    }
}