/**
 *
 *不修改数组找出重复的数字
 *我们把从1~n的数字从中间的数字m分为两部分，前面一半为1~m，后面一半为m+1~n,如果1~m的数字数目超过m
 *，那么这一半的区间里一定包含重复的数字，否则，另一半m+1~n的区间里一定包含重复的数字。我们可以继续
 *把包含重复数字的区间一分为二，直到找到一个重复的数字，这个过程和二分查找算法很类似，只是多了一步
 *区间里数字的统计。
 *
 */
 public class DuplicationInArrayNoEdit {
	 
	 public int getDuplication(int[] numbers) {
		 if (numbers == null || numbers.length == 0)
			 return -1;
		 int len = numbers.length;
		 int start = 1;
		 int end = len-1;
		 while (end >= start) {
			 int middle = start + (end - start) >> 1;
			 int count = countRange(numbers, start, middle);
			 if (start == end) {
				 if (count > 1)
					 return start;
				 else
					 break;
			 }
			 if (count > (middle-start+1))
				 end = middle;
			 else
				 start = middle+1; 
		 }
		 return -1;
	 }
	 
	 private int countRange(int[] numbers, int start, int end) {
		 int count = 0;
		 for (int i = 0; i < numbers.length; i++) {
			 if (numbers[i] >= start && numbers[i] <= end)
				 ++count;
		 }
		 return count;
	 }
 }