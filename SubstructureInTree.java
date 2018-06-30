/**
 *树的子结构
 *
 */
public class SubstructureInTree {
	
	 /**
     * 在树A中查找与树B根节点的值一样的节点，
     * 递归调用hasSubTree遍历二叉树A，如果发现某一节点的值和树B的头结点的值相同，则调用doesTreeHasTree2，进行第二步判断
     * 第二步判断树A中以R为根节点的子树是不是和树B具有相同的结构，可以用递归来解决
     * 如果节点R的值与树B的根节点不相同，则以R为根节点的子树和树B肯定不具有相同的结构，
     * 如果他们的相同的话，则递归的判断他们各自的左右子节点的值是不是相同
     * 递归的终止条件是我到达了树A和树B的叶节点
     */
	public boolean hasSubTree(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        boolean result = false;
        if (pRoot1 != null && pRoot2 != null) {
            if (equal(pRoot1.val, pRoot2.val))
                result = doesTreeHasTree2(pRoot1, pRoot2);
            if (!result)
                result = hasSubTree(pRoot1.left, pRoot2);
            if (!result)
                result = hasSubTree(pRoot1.right, pRoot2);
        }
        return result;
    }

    private boolean equal(double num1, double num2) {
        if ((num1-num2) > -0.0000001 && (num1-num2) < 0.0000001)
            return true;
        return false;
    }

    private boolean doesTreeHasTree2(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        if (pRoot2 == null)
            return true;
        if (pRoot1 == null)
            return false;
        if (!equal(pRoot1.val, pRoot2.val))
            return false;
        return doesTreeHasTree2(pRoot1.left, pRoot2.left) && doesTreeHasTree2(pRoot1.right, pRoot2.right);
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