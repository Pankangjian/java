
/**
 * 用单链表实现线性表
 * Created by pan on 2018/12/4.
 */
public class test_1 {
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
            Node next;  // 下一个结点引用

            public Node(int data) {
                this.data = data;
            }
        }

        public void add(int data) {
            if (start == null) {
                start = new Node(data);    // 头引用为空时，直接将值附给头引用
            } else {
                Node current = start;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new Node(data);
            }
            size++;
        }

        public int get(int i) {
            int data = 0;
            if (size == 0 || i < 0 || i > size - 1) {
                data = 0;
            }
            Node current = start;
            int j = 0;        // current.data = 2
            while (current.next != null && j < i) {
                current = current.next;
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
        data.add(2);
        data.add(3);

        data.add(4);
        System.out.println(data.get(2));

        for (int i = 0; i < data.size; i++) {
            System.out.print(data.get(i) + "/");
        }
        System.out.println("");
        System.out.println(data.size);
    }
}
