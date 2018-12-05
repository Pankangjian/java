
/**
 * 用顺序表实现线性表
 * Created by pan on 2018/12/4.
 */

public class test {
    public static void main(String[] args) {
        test();
    }

    static class ListData {
        int maxSize;
        double[] datum = null;
        int size;

        public ListData() {
            this.maxSize = 100;
            this.size = 0;
            this.datum = new double[maxSize];
        }

        public boolean isFull() {
            if (size == maxSize) {
                return true;
            } else {
                return false;
            }
        }

        public boolean insert(int i, double number) {
            if (i < 0 || i > size) throw new IndexOutOfBoundsException("i从0开始，不能大于数组长度");

            if (!isFull()) {
                for (int j = size - 1; j >= i; j--) {  // 从最后遍历索引
                    datum[j + 1] = datum[j];            // 插入数值后原来的索引+1
                }
                datum[i] = number;                //得到的插入数组
                size++;
                return true;
            } else {
                return false;
            }
        }

        boolean add(double number) {
            if (!isFull()) {
                datum[size++] = number;
                return true;
            } else {
                return false; //  添加失败 返回 false
            }
        }

        double get(int index) {
            if (index >= size) {
                return -1; // 找不到 返回 -1
            }
            return datum[index];
        }

        void remove(int index) {
            if (index < 0 || index > size) throw new IndexOutOfBoundsException("索引越界异常");
            if (!(size == 0)) {
                for (int j = index; j < size - 1; j++) {
                    datum[j] = datum[j + 1];
                }
                datum[--size] = 0;
            }
        }

        int indexOf(int value) {
//            if (value == 0) {
                for(int i =0;i<size;i++){
                   if(datum[i] == 0){
                       return i;     //返回索引的位置
                   }else if(datum[i] == value){
                           return i;
                       }
                }
            return -1;
        }

        void clear() {
            for (int i = 0; i < size; i++) {
                datum[i] = 0;
                size = 0;
            }
        }
    }

    public static void test() {
        ListData data = new ListData();
        data.add(123.123);
        String result;
        result = (-1 == data.get(4) ? "1 OK" : "1 E");
        System.out.println(result);
        result = (123.123 == data.get(0) ? "2 OK" : "2 E");
        System.out.println(result);



        data.add(1);   //第一位
        data.add(2);   //第二位
        data.add(3);
        data.add(0);
        data.insert(2, 123);
        System.out.println(data.get(2));
        result = (123 == data.get(2) ? "3 OK" : "3 E");
        System.out.println(result);

        data.remove(2);
        System.out.println(data.get(2));
        result = (2 == data.get(2) ? "4 OK" : "4 E");
        System.out.println(result);

        System.out.println(data.indexOf(0));
        result = (2 == data.get(2) ? "5 OK" : "5 E");
        System.out.println(result);

        //遍历数组输出各元素值
        for(int i =0;i<data.size;i++){
            System.out.print(data.get(i)+"/");
        }
        System.out.println("");

//        data.clear();
        System.out.println(data.size);
    }
}