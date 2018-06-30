/**
 *
 *一维数组中重复的数字
 *重排这个数组，从头到尾依次扫描这个数组中的每个数字，当扫描到下标为i的数字时，首先比较这个数字
 *（用m表示）是不是等于i。如果是，则接着扫描下一个数字，如果不是，则再拿他和第m个数字进行比较，
 *如果他和第m个数字相等，就找到了一个重复的数字（该数字在下标为i和m的位置都出现了），如果他和第m个数字
 *不相等，就把第i个数字和第m个数字交换，把m放到属于属于他的位置。接下来再重复这个比较，交换的过程，
 *直到我们发现一个重复的数字。
 *
 *
*/
public class DuplicationInArray {
	
	public boolean duplicate(int[] arr, int[] duplication) {
		if (arr == null || arr.length == 0)
			return false;
		int len = arr.length, j = 0;
		for (int i = 0; i < len; i++)
			if (arr[i] < 0 || arr[i] > len-1)
				return false;
		for (int i = 0; i < len; i++) {
			while (arr[i] != i) {
				if (arr[i] == arr[arr[i]]) {
					duplication[j++] = arr[i];
					return true;
				}
				int temp = arr[i];
				arr[i] = arr[temp];
				arr[temp] = temp;
			}
		}
		return false;
	}
}