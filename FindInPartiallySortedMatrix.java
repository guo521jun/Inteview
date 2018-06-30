/**
 *
 *二维数组中的查找
 *首先选取数字右上角的数字，如果该数字等于要查找的数字，则查找结束。
 *如果该数字大于要查找的数字，则剔除这个数字所在的列，
 *如果该数字小于要查找的数字，则剔除这个数字所在的行。
 *如果要查找的数字不在右上角，则每一次都在数组的查找范围内剔除一行或一列，
 *这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。
 *
 */
public class FindInPartiallySortedMatrix {
	
	public boolean find(int[][] matrix, int target) {
		boolean found = false;
		if (matrix == null || matrix.length == 0)
			return found;
		int rows = matrix.length;
		int columns = matrix[0].length;
		if (rows > 0 && columns > 0) {
			int row = 0;
			int column = columns-1;
			while (row < rows && column >= 0) {
				if (matrix[row][column] == target) {
					found = true;
					break;
				} else if (matrix[row][column] > target) {
					--column;
				} else {
					++row;
				}
			}
		}
		return found;
	}
}