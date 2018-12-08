/**
 * 链存储二叉树测试类
 * Created by pan on 2018/12/8.
 */
public class test {
    public static void main(String[] args) {
        LinkBinaryTree<Character> bt = new LinkBinaryTree<Character>('A');
        TreeNode<Character> root = bt.getHead();

        bt.insert('B', root, true);
        TreeNode b = root.getLeftChild();

        bt.insert('D', b, true);
        TreeNode d = b.getLeftChild();
        bt.insert('G', d, false);

        bt.insert('C', root, false);
        TreeNode c = root.getRightChild();
        bt.insert('E', c, true);
        bt.insert('F', c, false);
        System.out.print("前序遍历:");
        bt.preorder(root);

        System.out.print("/");
        bt.delete(c,true);               //删掉c结点处的左子树"E"
        bt.preorder(root);
        System.out.println("");


        LinkBinaryTree<Character> lbt = new LinkBinaryTree<Character>('A',null,c);   // 以c作为有右子树
        TreeNode<Character> a = lbt.getHead();
        bt.preorder(a);
    }
}
