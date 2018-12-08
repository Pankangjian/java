/**
 * 链存储二叉树实现，TreeNode为外部结点类，test为测试类
 * Created by pan on 2018/12/8.
 */
public class LinkBinaryTree<E> {
    private TreeNode<E> head;         //链表头指针引用,表示根结点

    public TreeNode<E> getHead() {
        return head;
    }

    //创建一棵以value为根结点数据域信息，以lp，rp为左右子树的二叉树
    public LinkBinaryTree(E value, TreeNode<E> lp, TreeNode<E> rp) {
        TreeNode<E> p = new TreeNode<E>(value, lp, rp);
        head = p;
    }

    //创建一棵以value为根结点数据域信息的二叉树
    public LinkBinaryTree(E value) {
        this(value, null, null);
    }

    //创建一棵空的二叉树
    public LinkBinaryTree() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    //在p处父结点插入子结点，用true来选择在左子树插入，用false来选择右子树插入
    public void insert(E value, TreeNode<E> p, boolean left) {
        TreeNode<E> tmp = new TreeNode<>(value);
        if (left) {
            tmp.setLeftChild(p.getLeftChild());       //原来p的左子树变为新的结点的左子树
            p.setLeftChild(tmp);                      //将父结点p的左子树变为插入的新结点
        } else {
            tmp.setRightChild(p.getRightChild());
            p.setRightChild(tmp);
        }
    }

    //删除p结点的子结点，用true来选择删除左子树，用false来删除右子树
    public TreeNode<E> delete(TreeNode<E> p, boolean left) {
        if ((p == null)) throw new RuntimeException("此结点不存在");
        TreeNode<E> temp;
        if (left) {
            if (p.getLeftChild() == null) throw new RuntimeException("此父结点没有左子树，无法删除");
            temp = p.getLeftChild();                       // 返回要删除的子树
            p.setLeftChild(null);                          // 赋值为空
        } else {
            if (p.getRightChild() == null) throw new RuntimeException("此父结点没有右子树，无法删除");
            temp = p.getRightChild();
            p.setRightChild(null);
        }
        return temp;
    }

    // 前序遍历
    public void preorder(TreeNode<E> p) {
        if (isEmpty()) {
            System.out.println("空");
            return;
        } else {
            if (p != null) {
                System.out.print(p.getData() + "");
                preorder(p.getLeftChild());
                preorder(p.getRightChild());
            }
        }
    }

    // 中序遍历


    // 后序遍历


    // 层次遍历

}
