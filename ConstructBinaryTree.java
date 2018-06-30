/**
 *
 *重建二叉树
 *在constructCore函数中，我们先根据前序遍历中的第一个数字构建根节点，接下来在中序遍历序列中
 *找到根节点的位置，这样就能确定左右子树节点的数量，在前序遍历和中序遍历序列中划分了左右子树
 *节点的值之后，我们就可以递归的调用函数constructCore去分别构建他的左右子树。
 *
 */
public class ConstructBinaryTree {
	
	public BinaryTree construct(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0 || inOrder.length == 0)
            return null;
        return constructCore(preOrder, inOrder, 0, (preOrder.length-1), 0, (inOrder.length-1));
    }

    private BinaryTree constructCore(int[] preOrder, int[] inOrder, int startPreOrder, int endPreOrder, int startInOrder, int endInOrder) {
        //前序遍历的第一个值是根节点的值
        int rootValue = preOrder[startPreOrder];
        BinaryTree root = new BinaryTree(rootValue);
        root.left = root.right = null;
        if (startPreOrder == endPreOrder) {
            if (startInOrder == endInOrder && preOrder[startPreOrder] == inOrder[startInOrder]) {
                return root;
            } else {
                throw new RuntimeException("Invalid input.");
            }
        }
        //在中序遍历序列中找到根节点的值
        int rootInOrder = startInOrder;
        while (rootInOrder < endInOrder && inOrder[rootInOrder] != rootValue)
            ++rootInOrder;
        if (rootInOrder == endInOrder && inOrder[rootInOrder] != rootValue)
            throw new RuntimeException("Invalid input.");
        int leftLength = rootInOrder - startInOrder;
        int leftPreOrderEnd = startPreOrder + leftLength;
        if (leftLength > 0) {
            //构建左子树
            return root.left = constructCore(preOrder, inOrder, startPreOrder+1, leftPreOrderEnd, startInOrder, rootInOrder-1);
        }
        if (leftLength < endPreOrder - startPreOrder) {
            //构建右子树
            return root.right = constructCore(preOrder, inOrder, leftPreOrderEnd+1, endPreOrder, rootInOrder+1, endInOrder);
        }
        return root;
    }

    class BinaryTree {
        int val;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int val) {
            this.val = val;
        }
    }
}