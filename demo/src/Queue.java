import java.lang.reflect.Array;

/**
 * Java队列实现
 * Created by pan on 2018/12/6.
 */
public class Queue {
    public static void main(String[] args) {
        test();

    }

    /**
     * Java顺序队列实现
     * @param <E>
     */
    public static class SeqQueue<E> {
        private int maxsize;            //最大的存储容量
        private E[] data;               //储存数据元素
        private int front;              //最近一个离开队列的元素所占的位置的指示器
        private int rear;               //最近一个进入队列的元素的位置的指示器

        public SeqQueue(Class<E> type, int size) {
            maxsize = size;
            data = (E[]) Array.newInstance(type, size);   //创建动态数组，type为数组类型
            front = rear = -1;                           //队列为空时front，rear都为-1
        }

        //判断队列是否为空
        public boolean isEmpty() {
            if (front == rear) {
                return true;
            } else {
                return false;
            }
        }

        //判断队列是否为满
        public boolean isFull() {
            if ((front == -1 && rear == maxsize - 1) || ((rear + 1) % maxsize == front)) {
                return true;
            } else {
                return false;
            }
        }

        //入队列
        public boolean enqueue(E value) {
            if (!isFull()) {
                rear = (rear + 1) % maxsize;          //求余得到的rear指向插入元素的位置
                data[rear] = value;
                return true;
            } else {
                return false;
            }
        }

        //出队列
        public E dequeue() {
            if (!isEmpty()) {
                front = (front + 1) % maxsize;
                return data[front];
            } else {
                return null;
            }
        }

        //获取队头的元素
        public E peek_front() {
            if (!isEmpty()) {
                return data[(front + 1) % maxsize];
            } else {
                return null;
            }
        }

        //获取队尾的元素
        public E peek_rear() {
            if (!isEmpty()) {
                return data[rear];
            } else {
                return null;
            }
        }

        public void clear() {
            front = rear = -1;
        }

        public int size() {
            if (rear > front) {
                return rear - front;
            } else {
                return ((rear - front) + maxsize) % maxsize;
            }
        }

    }

    private static void test() {
        int[] data = {1, 2, 3, 4, 5};
        SeqQueue newQueue = new SeqQueue(Integer.class, 10);
        for (int i = 0; i < data.length; i++) {
            newQueue.enqueue(data[i]);
            System.out.print(data[i] + "/");
        }
        System.out.println("");
        System.out.println("入队前队列的长度=" + newQueue.size());
        System.out.println("队尾数据=" + newQueue.peek_rear());


        int[] b = {6, 7, 8};
        for (int i = 0; i < b.length; i++) {
            newQueue.enqueue(b[i]);
            System.out.print(b[i] + "/");
        }
        System.out.println("");
        System.out.println("入队后队列长度=" + newQueue.size());
        System.out.println("队尾数据=" + newQueue.peek_rear());

        System.out.println("出队前队头数据=" + newQueue.peek_front());
        newQueue.dequeue();
        System.out.println("出队后队头数据=" + newQueue.peek_front());
        System.out.println("出队后队列长度=" + newQueue.size());

        newQueue.clear();
        System.out.println("清空队列后长度=" + newQueue.size());
    }

}
