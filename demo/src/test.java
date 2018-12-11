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
        bt.insert('潘', b, false);
        TreeNode p = b.getRightChild();
        bt.insert('健', p, true);
        bt.insert('D', b, true);
        TreeNode d = b.getLeftChild();
        bt.insert('G', d, false);
        bt.insert('康', d, true);

        bt.insert('C', root, false);
        TreeNode c = root.getRightChild();
        bt.insert('E', c, true);
        bt.insert('F', c, false);

        System.out.print("前序遍历:");
        bt.Pre_order(root);
        System.out.print("\n非递归遍历:");
        bt.pre_stack(root);

//        System.out.print("/");
////        bt.delete(c,true);               //删掉c结点处的左子树"E"
//        bt.Pre_order(root);

        System.out.print("\n中序遍历:");
        bt.In_order(root);
        System.out.print("\n非递归遍历:");
        bt.in_stack(root);

        System.out.print("\n后序遍历:");
        bt.Post_order(root);
        System.out.print("\n非递归遍历:");
        bt.Epilogue1(root);

        System.out.print("\n层次遍历:");
        bt.Leve_order(root);

        System.out.print("\n深度遍历:");
        bt.depth(root);

//        LinkBinaryTree<Character> lbt = new LinkBinaryTree<Character>('A',null,c);   // 以c作为有右子树
//        TreeNode<Character> a = lbt.getHead();
//        bt.preorder(a);
    }
}
