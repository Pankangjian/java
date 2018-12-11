import java.lang.reflect.Array;

/**
 * java栈的实现
 * Created by pan on 2018/12/5.
 */
public class Stack {
    public static void main(String[] args) {
//        test();
        test_1();
    }

    /**
     * java顺序栈的实现
     *
     * @param <E>
     */
    public static class SeqStack<E> {
        private int maxsize;           // 栈的最大存储空间
        private E[] data;              // 存储栈中的数据
        private int top;               // 栈顶变量

        public SeqStack(Class<E> type, int size) {
//            this.data = new int[100];
            this.data = (E[]) Array.newInstance(type, size);
            this.maxsize = size;
            top = -1;         // 空栈时，栈顶为-1

        }

        //栈长度
        public int size() {
            return top + 1;
        }

        //判断栈是否为空
        public boolean isFull() {
            if (top == maxsize - 1) {    // maxsize为0时,top是-1则为空栈
                return true;
            }
            return false;
        }

        //入栈
        public E push(E value) {
            if (!isFull()) {
                data[++top] = value;
                return value;
            }
            return null;
        }

        //出栈
        public E pop() {
            E temp = null;
            if (top != -1) {         // 栈不为空时
                temp = data[top--];
            }
            return temp;
        }

        //获取栈顶数据元素
        public E peek() {
            E temp;
            if (top == -1) throw new RuntimeException("栈为空");
//            if (top !=  -1){
//                temp = data[top];
//            }
            temp = data[top];
            return temp;
        }

        //从栈顶开始搜寻，第一次出现数值的位置，以1为栈底初始位置
        public int search(E value) {
            while (top != -1) {
                if (peek() != value) {    //得到栈顶数据不等于数值时循环查找
                    top--;
                }
                break;
            }
            int result = top + 1;   //空栈为-1,位置输出要加上1
            return result;
        }
    }

    private static void test() {
        int[] data = {1, 2, 3, 4, 5};
        SeqStack newStack = new SeqStack(Integer.class, data.length);
        for (int i = 0; i < data.length; i++) {
            newStack.push(data[i]);
            System.out.print(data[i] + "/");
        }
        System.out.println("");
        System.out.println(newStack.size());

        int[] a = new int[10];
        a[1] = 1;
        a[2] = 2;
        a[4] = 4;
        a[5] = 5;
        a[6] = 0;
        SeqStack b = new SeqStack(Integer.class, 5);
        for (int i = 0; i < 6; i++) {
            System.out.print(b.push(a[i]) + "/");
        }
        System.out.println("");
        //栈元素0/1/2/0/4/null/   栈的maxsize = 5
        System.out.println(b.top);       //出栈前栈顶为4
        System.out.println(b.peek());    //出栈前栈顶数据为4
        b.pop();                         //出栈
        System.out.println(b.peek());    //出栈后栈顶数据为0
        System.out.println(b.top);       //出栈后栈顶为3

        System.out.println(b.search(2));       //从栈顶向下搜寻第一次出现的位置，输出为3

    }


    /**
     * java链栈的实现
     *
     * @param <E>
     */
    public static class ChainStack<E> {
        private StackNode<E> top;     //栈顶指示器，指向结点
        private int size;             //结点个数

        //链栈的结点的内部类
        public class StackNode<E> {
            private E data;                //数据域
            private StackNode<E> next;     //引用域

            public StackNode(E data) {
                this.data = data;

            }

            public StackNode(E data, StackNode<E> next) {
                super();
                this.data = data;
                this.next = next;
            }

            //生成getter和setter方法
            // 数据域get属性
            public E getData() {
                return data;
            }

            //数据域set属性
            public void setData(E data) {
                this.data = data;
            }

            // 引用域get属性
            public StackNode<E> getNext() {
                return next;
            }

            //引用域set属性
            public void setNext(StackNode<E> next) {
                this.next = next;
            }
        }

        //初始化
        public ChainStack() {
            top = null;
            size = 0;
        }

        public boolean isEmpty() {
            if ((top == null) && (size == 0)) {
                return true;
            } else {
                return false;
            }
        }

        // 入栈
        public E push(E value) {
            if (!isEmpty()) {
                StackNode<E> newNode = new StackNode(value, top);
                newNode.setNext(top);              // 新加入的结点的next指向原来的top
                top = newNode;                     // 新加入的结点变为top
            } else {
                StackNode stackNode = new StackNode(value, null);
                top = stackNode;
            }
            ++size;                               // 结点个数自增
            return value;
        }

        //出栈
        public E pop() {
            E data = null;
            if (!isEmpty()) {
                data = top.getData();          // 出栈前，得到数据
                top = top.getNext();           // 出栈后，top变为原来元素的next引用域
                size--;
            }
            return data;
        }


        //获取栈顶数据
        public E peek() {
            E data = null;
            if (!isEmpty()) {
                data = top.data;          //得到栈顶数据
            }
            return data;
        }

        //清空栈
        public void clear() {
            top = null;
            size = 0;
        }

        public int size() {
            return size;
        }
    }

    private static void test_1() {
        int[] data = {1, 2, 3, 4, 5};
        ChainStack newStack = new ChainStack();
        for (int i = 0; i < data.length; i++) {
            newStack.push(data[i]);
            System.out.print(data[i] + "/");
        }
        System.out.println("（原始元素）");
        System.out.println("结点数=" + newStack.size);
        int[] a = {6, 7, 8};
        for (int i = 0; i < a.length; i++) {
            newStack.push(a[i]);
            System.out.print(a[i] + "/");
        }
        System.out.println("（添加元素）");
        System.out.println("结点数=" + newStack.size);

        System.out.println("没出栈前栈顶数据=" + newStack.peek());
        newStack.pop();
        System.out.println("结点数=" + newStack.size);
        System.out.println("出栈后获取栈顶数据=" + newStack.peek());

        newStack.clear();
        System.out.println("清空后结点数=" + newStack.size);
    }
}
