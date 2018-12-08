import java.util.Arrays;

/**
 * java二叉树实现
 * Created by pan on 2018/12/7.
 */
public class Tree {
    public static void main(String[] args) {
        test();
    }

    /**
     * 顺序存储二叉树实现
     *
     * @param <E>
     */
    public static class BinaryTree<E> {
        private Object[] data;                 // 使用数组记录所有结点
        private int DEFAULT_DEEP = 10;         // 默认的树的深度
        private int deep;                      // 树的深度
        private int size;                      // 数组长度

        // 构造方法
        public BinaryTree() {
            this.deep = DEFAULT_DEEP;                     // 创建默认深度的二叉树
            this.size = (int) (Math.pow(2, deep) - 1);    // 二叉树特性：深度为k的二叉树中，最多具有2的k次方后减1的结点。
            data = new Object[size];
        }

        // 构造方法
        public BinaryTree(int deep) {
            this.deep = deep;                             // 创建输入指定的参数为深度的二叉树
            this.size = (int) (Math.pow(2, deep) - 1);    // 二叉树特性：深度为k的二叉树中，最多具有2的k次方后减1的结点。
            data = new Object[size];
        }

        // 构造方法
        public BinaryTree(int deep, E value) {
            this.deep = deep;                             // 创建输入指定的参数为深度，指定value数据为根结点的二叉树
            this.size = (int) (Math.pow(2, deep) - 1);    // 二叉树特性：深度为k的二叉树中，最多具有2的k次方后减1的结点。
            data = new Object[size];
            data[0] = value;
        }

        public void add(int index, E datum, boolean left) {       // datum为要添加的数据
            if (data[index] == null) {
                throw new RuntimeException("结点为空，无法添加子结点");
            }
            if (2 * index + 1 >= size) {
                throw new RuntimeException("树的最大层数数组已满，越界异常");
            }
            // 输入true为在下标处添加左结点
            if (left) {
                data[2 * index + 1] = datum;      // 添加左子结点
            } else {
                data[2 * index + 2] = datum;      // 添加右子结点
            }

        }

        // 获取指定索引处的左子结点
        public E left(int index) {
            if (2 * index + 1 >= size) {
                throw new RuntimeException("此结点为叶结点,无子结点");
            }
            return (E) data[2 * index + 1];
        }

        // 获取指定索引处的右子结点
        public E right(int index) {
            if (2 * index + 1 >= size) {
                throw new RuntimeException("此结点为叶结点,无子结点");
            }
            return (E) data[2 * index + 2];
        }

        // 获取指定结点的父结点（获取数组位置索引的数据）
        public E parent(int index) {
            return (E) data[index - 1 / 2];
        }

        // 获取到索引数据的位置
        public int search(E item) {
            if (data[0].equals("")) {
                throw new RuntimeException("二叉树为空");
            }
            for (int i = 0; i < size; i++) {
                if (data[i] == item) {
                    return i;
                }
            }
            return -1;
        }

        // 以字符串方式打印出数组记录的所有结点，包括空结点
        public String toString() {
            return Arrays.toString(data);
        }

        // 删除索引处父结点的子结点
        public void delete(int index, boolean left) {
            if (2 * index + 1 >= size) {
                throw new RuntimeException("索引处此结点为叶结点,无子结点");
            }
            if (data[index] == null) {
                throw new RuntimeException("结点为空，无法删除子结点");
            }
            if (data[2 * index + 1] == null
                    || data[2 * index + 2] == null)
                throw new RuntimeException("索引处结点的子结点已经为空，无需删除");
            if (left) {
                data[2 * index + 1] = null;      // 删除左子结点
            } else {
                data[2 * index + 2] = null;      // 删除右子结点
            }
        }

    }

    private static void test() {
        BinaryTree binaryTree = new BinaryTree<String>(4, "根结点");   // 数组位置为0，添加数据"根结点"
        binaryTree.add(0, "右1", false);                               // 在数组索引位置2添加   2*0+2=2
        binaryTree.add(2, "右2", false);                               // 在数组索引位置6添加   2*2+2=6
        binaryTree.add(6, "右3", false);                               // 在数组索引位置14添加  2*6+2=14
        binaryTree.add(6, "左3", true);                                // 在数组索引位置13添加  2*6+1=13
        binaryTree.add(2, "左2", true);                                // 在数组索引位置5添加  2*2+1=5
        binaryTree.add(0, "左1", true);                                // 在数组索引位置1添加  2*0+1=1
        System.out.println(binaryTree.data[14]);
        System.out.println(binaryTree.data[0]);
        System.out.println(binaryTree.deep);
        System.out.println(binaryTree.left(0));
        System.out.println(binaryTree.parent(5));
        System.out.println(binaryTree.search("右2"));
        System.out.println(binaryTree.toString());
        binaryTree.delete(6, false);                                      // 删除父结点位置为6，右子结点位置为14的数值,"右3"删掉
        System.out.println(binaryTree.toString());
    }
}
