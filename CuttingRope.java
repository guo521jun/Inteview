/**
 *
 *剪绳子
 *使用动态规划或贪婪算法
 *
 *
 *
 */

public class CuttingRope {
	
	/**
     * 动态规划求解
     * 自底向上
     */
    public int maxProductSolution1(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int[] products = new int[length+1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i-j];
                if (max < product)
                    max = product;
                products[i] = max;
            }
        }
        max = products[length];
        return max;
    }

    /**
     * 贪婪算法求解
     */
    public int maxProductSolution2(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        //尽可能多的减去长度为3的绳子段
        int timesOf3 = length / 3;
        //当绳子最后剩下的长度为4时，不能再减去长度为3的绳子段
        //此时更好的方法是把绳子剪成长度为2的两段，2x2 > 1x3
        if (length - timesOf3 * 3 == 1)
            timesOf3 -= 1;
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
} 