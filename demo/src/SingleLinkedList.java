
/**
 * 用单链表实现线性表
 * Created by pan on 2018/12/4.
 */
public class SingleLinkedList {
    public static void main(String[] args) {

        test_node();
    }
    static class ListData {
        Node start;  // 头引用
        int size;     //单链表长度

        public ListData() {
            start = null;
        }
        static class Node {
            int data;          // 结点数据
            Node next;  // 指向下一个结点

            public Node(int data) {
                this.data = data;
            }
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if (start == null) {
                start = newNode;    // 头引用为空时，直接将值赋给头引用
            } else {
                Node current = start;      // 当前的结点
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;   // 当前结点指向下一个结点为空时，直接赋值
            }
            size++;
        }

        public boolean insert(int i, int value) {
//            i = i-1;      // 直观显示，索引不从0开始 1245,直接索引3插入
            Node rear;               // 后面的结点
            Node front = null;       // 前面的结点
            if (i < 0 || i > size) throw new IndexOutOfBoundsException("索引超出范围");
            Node newNode = new Node(value);
            if (i == 0) {
                newNode.next = start;    // 头引用变为插入的结点指向的下一个结点
                start = newNode;         // 把插入的结点作为头引用
                size++;
            } else {
                rear = start;
                int j = 0;
                while (rear != null && j < i) {  // 当前结点指向下一个结点为空时跳出循环
                    front = rear;
                    rear = rear.next;
                    j++;
                }
                if (j == i) {                      //在俩元素之间插入，在索引i位置的前面插入
                    front.next = newNode;          //前面的结点指向下一个结点为插入的结点
                    newNode.next = rear;           //插入的结点指向下一个结点为后面的结点
                    size++;
                }
            }
            return true;
        }

        public void remove(int i) {
            if (i < 0 || i > size) throw new IndexOutOfBoundsException("索引超出范围");
            Node current = start;
            if (i == 0) {                //索引为0时执行
                start = current.next;
                size--;
            } else {
                Node previous = null;   //以前的结点
                int j = 1;              // 索引从1开始执行
                while (current.next != null && j <= i) {
                    previous = current;
                    current = current.next;
                    j++;
                }
                previous.next = current.next;   //删除（current）索引元素之后,前面元素的next指向后面元素的头引用（current.next）
                size--;
            }
        }

        public void clear() {
            Node x = start;
            while (x != null) {        // 头引用不为空时，循环一个个移除
                Node a = x.next;
                x.next = null;
                x.data = 0;
                x = a;
            }
            start = null;            //不用循环直接用也可达到清除效果，将链表所有头引用设为空，可能引起其他问题
            size = 0;
        }

        // 查找数值value第一次出现的位置
        public int index(int value) {
            int i = 0;
            for (Node x = start; x != null; x = x.next) {
                if (value == x.data)
                    return i;
                i++;
            }
            return -1;
        }

        public int get(int i) {
            int data = 0;
            if (size == 0 || i < 0 || i > size - 1) throw new IndexOutOfBoundsException("索引越界异常");
            Node current = start;       //    current.data = 2
            int j = 0;
            while (current.next != null && j < i) {  // 当前结点指向下一个结点为空时跳出循环
                current = current.next;              // 前一个指向下一个结点转为当前结点的头引用
                j++;
            }
            if (j == i) {
                data = current.data;
            }
            return data;
        }
    }

    public static void test_node() {
        ListData data = new ListData();
        data.add(1);
        data.add(2);
        data.add(4);
        data.add(5);
        for (int i = 0; i < data.size; i++) {
            System.out.print(data.get(i) + "/");
        }
        System.out.println("");


        data.insert(2, 3);
        data.insert(0, 77);
        for (int i = 0; i < data.size; i++) {
            System.out.print(data.get(i) + "/");
        }
        System.out.println("");

        data.remove(1);
        for (int i = 0; i < data.size; i++) {
            System.out.print(data.get(i) + "/");
        }
        System.out.println("");


//        System.out.println(data.get(2));
//        System.out.println(data.size);
//        data.clear();
//        System.out.println(data.size);

        System.out.println(data.index(20));
    }
}
