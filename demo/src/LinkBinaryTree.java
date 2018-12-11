import java.util.LinkedList;

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
    void Pre_order(TreeNode<E> root) {
        if (root != null) {
            preOrder(root);
        } else {
            System.out.print("此二叉树为空");
        }
    }

    public void preOrder(TreeNode<E> p) {
        if (p != null) {
            System.out.print(p.getData());
            preOrder(p.getLeftChild());
            preOrder(p.getRightChild());
        }
    }

    // 中序遍历
    void In_order(TreeNode<E> root) {
        if (root != null) {
            inOrder(root);
        } else {
            System.out.print("此二叉树为空");
        }
    }

    public void inOrder(TreeNode<E> p) {
        if (p != null) {                            // 当p==null时结束，
            inOrder(p.getLeftChild());              // 此时的p不为空，p的左结点作为下一个p结点
            System.out.print(p.getData());          // 当p的左结点作为下一个p结点为null时，输出此时p的数据
            inOrder(p.getRightChild());             // 此时的p不为空，p的右结点作为下一个p结点
        }
    }

    // 后序遍历
    void Post_order(TreeNode<E> root) {
        if (root != null) {
            postOrder(root);
        } else {
            System.out.print("此二叉树为空");
        }
    }

    public void postOrder(TreeNode<E> p) {
        if (p != null) {                            // 当p==null时结束，
            postOrder(p.getLeftChild());            // 此时的p不为空，p的左结点作为下一个p结点
            postOrder(p.getRightChild());           //
            System.out.print(p.getData());
        }
    }

    // 层次遍历
    void Leve_order(TreeNode<E> root) {
        if (root != null) {
            leveOrder(root);
        } else {
            System.out.print("此二叉树为空");
        }
    }

    public void leveOrder(TreeNode<E> root) {
        Queue.LinkedQueue queue = new Queue.LinkedQueue();
        // 根结点入队
        queue.enqueue(root);
        // 队列不为空
        while (!queue.isEmpty()) {
            // 结点出队
            TreeNode<E> node = (TreeNode<E>) queue.dequeue();
            System.out.print(node.getData());
            if (!(node.getLeftChild() == null)) {
                queue.enqueue(node.getLeftChild());
            }
            if (!(node.getRightChild() == null)) {
                queue.enqueue(node.getRightChild());
            }
        }
    }

    // 非递归遍历
    // 前序
    public void pre_stack(TreeNode<E> root) {
        Stack.ChainStack stack = new Stack.ChainStack();
        TreeNode<E> parent = root;
        while (parent != null || !stack.isEmpty()) {
            if (parent != null) {
                System.out.print(parent.getData());
                // 入
                stack.push(parent);
                // 把入栈的结点的左子树作为新的根结点
                parent = parent.getLeftChild();
            } else {
                TreeNode node = (TreeNode) stack.pop();
                parent = node.getRightChild();                 // 右结点作为新的根结点
            }
        }
    }

    // 非递归遍历
    // 中序
    public void in_stack(TreeNode<E> root) {
        Stack.ChainStack stack = new Stack.ChainStack();
        TreeNode parent = root;
        while (parent != null || !stack.isEmpty()) {
            if (parent != null) {
                stack.push(parent);
                parent = parent.getLeftChild();
            } else {
                TreeNode<E> node = (TreeNode<E>) stack.pop();
                System.out.print(node.getData());
                parent = node.getRightChild();
            }
        }
    }

    // 非递归遍历
    // 后序
    // 双栈法
    public void epilogue(TreeNode<E> root) {
        Stack.ChainStack stack = new Stack.ChainStack();
        Stack.ChainStack output = new Stack.ChainStack();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                output.push(node);
                node = node.getRightChild();
            } else {
                node = (TreeNode) stack.pop();
                node = node.getLeftChild();
            }
        }
        while (output.size() > 0) {
            TreeNode n = (TreeNode) output.pop();
            System.out.print(n.getData());
        }
    }

    /*
    实现思路：从根节点开始，只要当前节点存在，或者栈不为空，则重复下列操作
    1：如果当前节点开始，进栈并遍历左子树，直到左子树为空
    2：如果栈顶元素的右子树为空，或者栈顶节点的右孩子为刚访问过得节点，则退栈并访问
    3：否则，遍历右子树
    */
    public void Epilogue(TreeNode<E> root) {
        if (root == null) return;
        TreeNode p = root;
        TreeNode q = null;
        Stack.ChainStack stack = new Stack.ChainStack();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.getLeftChild();
            } else {
                p = (TreeNode) stack.peek();    // 获取栈顶数据，作为根结点
                if (p.getRightChild() == null || p.getRightChild() == q) {
                    System.out.print(p.getData());
                    stack.pop();
                    q = p;                      // 用一个标志q来标记节点是否访问过，每次访问过p要置为NULL,否则就会陷入死循环。
                    p = null;
                } else {
                    p = p.getRightChild();
                }
            }
        }
    }

    public void Epilogue1(TreeNode<E> root) {
        Stack.ChainStack stack = new Stack.ChainStack();
        TreeNode node = root;
        while (root != null) {
            //左子树入栈
            for (; root.getLeftChild() != null; root = root.getLeftChild()) {
                stack.push(root);
            }
            // 当前结点无右子树或右子树已经输出
            while (root != null && (root.getRightChild() == null || root.getRightChild() == node)) {
                System.out.print(root.getData());
                node = root;                          // 纪录上一个已输出结点
                if (stack.isEmpty()) return;
                root = (TreeNode<E>) stack.pop();     // 出栈的数据作为新的根结点
            }
            //处理右子树
            stack.push(root);
            root = root.getRightChild();
        }
    }


    // 深度遍历
    public void depth(TreeNode<E> root) {
        if (root == null) return;
        Stack.ChainStack stack = new Stack.ChainStack();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode<E> node = (TreeNode<E>) stack.pop();
            System.out.print(node.getData());
            if(node.getRightChild()!=null){
                stack.push(node.getRightChild());
            }
            if(node.getLeftChild()!=null){
                stack.push(node.getLeftChild());
            }
        }
    }

}
