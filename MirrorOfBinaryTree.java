/**
 *二叉树的镜像
 *1.交换根节点的左右子树
 *2.交换根节点的左右子节点
 *3.递归交换左右子节点，直到到达叶子节点
 */
public class MirrorOfBinaryTree {
	
	 public void mirrorRecursively(BinaryTreeNode pRoot) {
        if (pRoot == null)
            return;
        if (pRoot.left == null && pRoot.right == null)
            return;
        BinaryTreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        if (pRoot.left != null)
            mirrorRecursively(pRoot.left);
        if (pRoot.right != null)
            mirrorRecursively(pRoot.right);
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