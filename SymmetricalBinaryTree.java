/**
 *
 *对称二叉树
 *
 */
public class SymmetricalBinaryTree {
	
	 /**
     * 通过二叉树的前序遍历和对称前序遍历来判断二叉树是不是对称的，如果两个序列是一样的，则为对称的。
     * 对称的前序遍历：先遍历右节点再遍历左节点
     */
    public boolean isSymmetrical(BinaryTreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null)
            return true;
        if (pRoot1 == null || pRoot2 == null)
            return false;
        if (pRoot1.val != pRoot2.val) {
            return false;

        }
        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);


    }

    class BinaryTreeNode {

        double val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
        }
    }
}