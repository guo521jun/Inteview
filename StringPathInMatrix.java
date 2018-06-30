/**
 *
 * 矩阵中的路径
 *使用了回朔算法
 *由于回溯的递归特性，可以把路径看作是一个栈，当在矩阵中定位了前n个字符的位置之后，在与第n个字符
 *对应的格子的周围都没有找到第n+1个字符，这时候只好在路径上回到n-1个字符，重新定位第n个字符。
 *路径不能重复进入矩阵的格子，所以还需要定义和字符矩阵大小一样的布尔值矩阵，用于标识路径是否
 *已经进入了每个格子。
 *
 */
public class StringPathInMatrix {
	
	public boolean hasPath(char[][] matrix, char[] str) {
        if (matrix == null || str == null || matrix.length == 0)
            return false;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int pathLength = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int row = 0; row < rows; row++)
            for (int column = 0; column < columns; column++)
                if (hasPathCore(matrix, rows, columns, row, column, str, pathLength, visited))
                    return true;
        return false;
    }

	/**
     *当矩阵中坐标为(row, column)的格子和路径字符数组中下标为pathLength的字符一样时，从四个相邻的格子(row, column-1),(row-1, column),
     * (row, column+1),(row+1, column)中去定位路径字符数组中的下标为pathLength+1的字符，如果四个相邻的格子都没有匹配字符数组中下标为pathLength+1
     * 的字符，则表明当前字符数组中下标为pathLength的字符在矩阵中的定位不确定，我们需要回到前一个字符(pathLength-1)，然后重新定位。
     * 一直重复这个过程，直到路径字符数组上的所有字符都在矩阵中找到合适的位置(pathLength == str.length)
     */
    private boolean hasPathCore(char[][] matrix, int rows, int columns, int row, int column, char[] str, int pathLength, boolean[][] visited) {
        if (pathLength == str.length)
            return true;
        boolean hasPath = false;
        if (row >= 0 && row < rows && column >= 0 && column < columns && matrix[row][column] == str[pathLength] && !visited[row][column]) {
            ++pathLength;
            visited[row][column] = true;
            hasPath = hasPathCore(matrix, rows, columns, row, column-1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, columns, row-1, column, str, pathLength, visited)
                    || hasPathCore(matrix, rows, columns, row, column+1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, columns, row+1, column, str, pathLength, visited);
            if (!hasPath) {
                --pathLength;
                visited[row][column] = false;
            }
        }
        return hasPath;
    }
}