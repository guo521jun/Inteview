/**
 *
 *二叉树的下一个节点
 *
 *1.如果一个节点有右子树，那么他的下一个节点就是他的右子树的最左子节点
 *2.如果一个节点没有右子树，如果节点是他父节点的左子节点，那么他的下一个节点就是他的父节点。
 *3.如果一个节点既没有右子树，并且他还是父节点的右子节点，那么我们可以沿着指向父节点的指针
 *一直向上遍历，直到找到一个是他父节点的左子节点的节点，如果这个的节点存在，那么这个节点的父节点
 *就是我们要找的下一个节点。
 *
 */
public class NextNodeInBinaryTrees {
	
	public BinaryTreeNode getNext(BinaryTreeNode pNode) {
        if (pNode == null)
            return null;
        BinaryTreeNode pNext = null;
        if (pNode.right != null) {
            BinaryTreeNode pRight = pNode.right;
            while (pRight.left != null)
                pRight = pRight.left;
            pNext = pRight;
        } else if (pNode.parent != null) {
            BinaryTreeNode pCurrent = pNode;
            BinaryTreeNode pParent = pNode.parent;
            while (pParent != null && pCurrent == pParent.right) {
                pCurrent = pParent;
                pParent = pParent.parent;
            }
            pNext = pParent;
        }
        return pNext;
    }

    class BinaryTreeNode {

        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode parent;

        BinaryTreeNode(int val) {
            this.val = val;
        }
    }
}