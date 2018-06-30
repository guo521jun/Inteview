/**
 *机器人的运动范围
 *使用了回溯算法
 *物体或人在二维方格上的运动都可以使用回朔算法解决
 *
 */
public class RobotMove {
	
	public int movingCount(int[][] threshold, int k) {
        if (threshold == null || threshold.length == 0 || threshold[0].length == 0)
            return 0;
        boolean[][] visited = new boolean[threshold.length][threshold[0].length];
        int rows = threshold.length;
        int columns = threshold[0].length;
        int count = movingCountCore(threshold, rows, columns, 0, 0, visited, k);
        return count;
    }

    private int movingCountCore(int[][] threshold, int rows, int columns, int row, int column, boolean[][] visited, int k) {
        int count = 0;
        if (check(threshold, rows, columns, row, column, visited, k)) {
            visited[row][column] = true;
            count = 1 + movingCountCore(threshold, rows, columns, row, column-1, visited, k)
                      +  movingCountCore(threshold, rows, columns, row-1, column, visited, k)
                      + movingCountCore(threshold, rows, columns, row, column+1, visited, k)
                      + movingCountCore(threshold, rows, columns, row+1, column, visited, k);
        }
        return count;
    }

    /**
     * 判断此方格是否符合要求
     */
    private boolean check(int[][] threshold, int rows, int columns, int row, int column, boolean[][] visited, int k) {
        if (row >= 0 && row < rows && column >= 0 && column < columns && (getDigitSum(row) + getDigitSum(column) <= k) && !visited[row][column])
            return true;
        return false;
    }

    /**
     * 得到坐标的数位和
     */
    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}