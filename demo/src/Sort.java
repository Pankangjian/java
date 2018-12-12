/**
 * 排序算法
 * Created by pan on 2018/12/9.
 */
public class Sort {
    public static void main(String[] args) {
        test_sort();
    }

    /**
     * 插入排序--直接插入排序
     * 在要排序的一组数中，假定前n-1个数已经排好序，
     * 现在将第n个数插到前面的有序数列中，
     * 使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
     */
    public void insertSort(int arr[], int length) {
        int temp;
        for (int i = 1; i < length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.print("插入排序:");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]);
        }
    }

    /**
     * 插入排序--希尔排序
     * 在要排序的一组数中，根据某一增量分为若干子序列，并对子序列分别进行插入排序。
     * 然后逐渐将增量减小,并重复上述过程。直至增量为1,此时数据序列基本有序,最后进行插入排序。
     */
    public void shellSort(int arr[], int length) {
        int increment = length / 3;
        for (int m = increment; m >= 1; m--) {
            int d = m;                           // d为当前增量
            for (int i = d; i < length; i++) {
                if (arr[i] < arr[i - d]) {       // 分别插入各组当前的有序区
                    int temp = arr[i];
                    int j = i;
                    while (j > 0 && temp < arr[j - d]) {
                        arr[j] = arr[j - d];
                        j = j - d;
                        if (j - d < 0) break;
                    }
                    arr[j] = temp;              // 插入arr[i]到正确位置
                }
            }
        }
        System.out.print("\n希尔排序:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    /**
     * 选择排序--直接选择排序
     * 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
     * 第二次遍历n-2个数，找到最小的数值与第二个元素交换；
     * ....
     * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
     */
    public void selectSort(int arr[], int length) {
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;                        // 找出最小值位置进行交换
                }
            }
            if (min != i) {                         // 元素交换
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.print("\n选择排序:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    /**
     * 选择排序--堆排序
     * 利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，
     * 并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
     * 实现堆算法前，先实现将完全二叉树构建成最大堆
     */
    // 构建最大堆算法 --最大堆的根结点是堆中关键码最大的结点
    public void createHeap(int[] data, int low, int high) {
        if ((low < high) && high < data.length) {
            for (int i = high / 2; i >= low; i--) {
                int temp = data[i];
                int k = i;
                int j = 2 * k + 1;
                while (j <= high) {
                    if ((j < high) && (j + 1 <= high) && (data[j] < data[j + 1])) {
                        j++;
                    }
                    if (temp < data[j]) {
                        data[k] = data[j];
                        k = j;
                        j = 2 * k + 1;
                    } else {
                        break;
                    }
                }
                data[k] = temp;
            }
        }
    }

    // 堆排序算法
    public void heapsort(int arr[], int length) {
        int temp;
        createHeap(arr, 0, length - 1);
        for (int i = length - 1; i > 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            createHeap(arr, 0, i - 1);
        }
        System.out.print("\n堆排序:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    /**
     * 交换排序--冒泡排序
     * 两个数比较大小，较大的数下沉，较小的数冒起来
     */
    public void bubbleSort(int arr[], int length) {
        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.print("\n冒泡排序:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    /**
     * 交换排序--快速排序
     * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，
     * 其中一部分记录的关键字均比另一部分的关键字小，
     * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     * 先从数列中取出一个数作为key值；将比这个数小的数全部放在它的左边，大于或等于它的数全部放在它的右边；
     * 对左右两个小数列重复第二步，直至各区间只有1个数。
     */
    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int i = left;
        int j = right;
        int key = arr[left];    // 取第一个数为key
        while (i < j) {
            while (i < j && arr[j] >= key) {       // 从右向左找第一个小于或等于key的值
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];                   // 进行交换
                i++;
            }
            while (i < j && arr[i] <= key) {       // 从左向右找第一个大于或等于key的值
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];                   // 进行交换
                j--;
            }
        }
        arr[i] = key;
        quickSort(arr, left, i - 1);   // 递归调用
        quickSort(arr, j + 1, right);  // 递归调用
    }

    private static void test_sort() {
        int arr[] = {1, 0, 3, 9, 8, 6, 7, 2, 5, 4, -1};
        Sort s = new Sort();
//        s.insertSort(arr, arr.length);
//        s.shellSort(arr, arr.length);
//        s.selectSort(arr, arr.length);
//        s.heapsort(arr, arr.length);
//        s.bubbleSort(arr, arr.length);
        s.quickSort(arr, 0, arr.length - 1);
        System.out.print("\n快速排序:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
