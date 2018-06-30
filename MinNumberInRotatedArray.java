/**
 *
 *旋转数组的最小数字
 *由于旋转数组是由两个递增的子数组构成的，即第一个子数组的第一个元素大于第二子数组的最后一个元素
 *1.使用两个指针分别指向数组的第0个位置和最后一个位置
 *2.找到数组中间的位置，比较数组第0个位置与中间位置元素的大小，若大于，则说明该中间元素属于第一个
 *子数组中，则把第一个指针指向中间元素，
 *3.若中间的元素小于第二个指针指向的元素，说明该中间元素属于第二个递增子数组，则把第二个指针指向
 *中间元素
 *4.直到第一个指针与第二个指针相邻，则第二个指针指向的元素即为最小元素。
 *特例：0 1 1 1 1的旋转有两种情况  1 1 1 0 1 和1 0 1 1 1 则需要采取顺序查找的方式
 *
 */
public class MinNumberInRotatedArray {
	
	public int min(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            throw new RuntimeException("invalid parameters");
        int index1 = 0;
        int index2 = numbers.length-1;
        int indexMid = index1;
        while (numbers[index1] >= numbers[index2]) {
			//如果index1和index2指向两个相邻的数
			//则index1指向第一个子数组的最后一个数
			//index2指向第二个子数组的第一个数，也就是最小的那个数
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = index1 + (index2-index1)/2;
            //如果下标index1,index2,indexMid指向的三个数相等，则只能顺序查找
            if (numbers[index1] == numbers[index2] && numbers[indexMid] == numbers[index1])
                return minInOrder(numbers, index1, index2);
            //缩小查找范围
            if (numbers[indexMid] >= numbers[index1])
                index1 = indexMid;
            else if (numbers[indexMid] <= numbers[index2])
                index2 = indexMid;
        }
        return numbers[indexMid];
    }

    private int minInOrder(int[] numbers, int index1, int index2) {
        int result = numbers[index1];
        for (int i = index1+1; i <= index2; i++) {
            if (numbers[i] < result)
                result = numbers[i];
        }
        return result;
    }

}