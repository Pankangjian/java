/**
 * 链表存储结构二叉树的结点类
 * Created by pan on 2018/12/8.
 */
public class TreeNode<E> {
    private E data;                         // 数据域
    private TreeNode<E> leftChild;          // 左孩子 -指向左子树的引用域
    private TreeNode<E> rightChild;         // 右孩子 -指向右子树的引用域


    public TreeNode(E value, TreeNode<E> lp, TreeNode<E> rp) {
        data = value;
        leftChild = lp;
        rightChild = rp;
    }

    public TreeNode(E value,TreeNode<E>lp) {
        this(value,lp,null);
    }

    public TreeNode(E value) {
        this(value,null,null);
    }

    public TreeNode() {
        this(null);
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }
}
