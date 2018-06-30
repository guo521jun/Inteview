 /**
  * 
  * 顺时针打印矩阵
  * 从外向内一圈一圈的打印
  * 最内圈可能退化成只有一行，或一列，甚至只有一个数字
  * 第一步总是需要的，因为打印一圈至少有一步，如果只有一行，就不用第二步了，需要第二步的条件是终止行号大于起始行号，
  * 需要第三步的条件是圈内至少有两行和两列，也就是说，除了需要终止行号大于起始行号外，还需要终止列号大于起始列号
  * 需要打印第四步的条件是至少是三行两列，因此需要终止行号比起始行号至少大2，同时终止列号要大于起始列号。
  */
public class PrintMatrix {
	
	public void printMatrixClockwisely(int[][] numbers) {

        if (numbers == null || numbers.length == 0 || numbers[0].length == 0)
            return;
        int start = 0;
        int rows = numbers.length;
        int columns = numbers[0].length;
        while (2 * start < rows && 2 * start < columns) {
            printMatrixInCircle(numbers, rows, columns, start);
            ++start;
        }
    }

    private void printMatrixInCircle(int[][] numbers, int rows, int columns, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        //从左到右打印一行
        for (int i = start; i <= endX; i++) {
            System.out.println(numbers[start][i]);
        }
        //从上到下打印一列
        if (start < endY) {
            for (int i = start+1; i <= endY; i++) {
                System.out.println(numbers[i][endX]);
            }
        }
        //从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX-1; i >= start; i--) {
                System.out.println(numbers[endY][i]);
            }
        }
        //从下到上打印一列
        if (start < endX && start < endY-1) {
            for (int i = endY-1; i > start; i--) {
                System.out.println(numbers[i][start]);
            }
        }
    }
}