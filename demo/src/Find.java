/**
 * Created by pan on 2018/12/13.
 */
public class Find {
    public static void main(String[] args) {
        test_Search();
    }

    /**
     * 二分查找
     * 二分查找法要求：线性表必须是有序表
     *
     * @param arr--数组
     * @param key--要搜索的关键字
     * @return
     */
    public int binarySearch(int[] arr, int key) {
        int low = 0;                      // 左边取第一位
        int high = arr.length - 1;        // 右边为数组最后一位位置
        int mid;                          // 中间位置
        while (high >= low) {
            mid = (low + high) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 哈希表查找算法--
     * 哈希表最大的优点是：数据的存储和查找消耗时间大大降低，但是需消耗较多内存
     * 构建哈希函数方法:除余法，平方取中法，折叠移位法，直接寻址法，数字分析法，随机数法
     * 解决哈希冲突方法：开放定址法，链表法，再哈希法
     * 下面通过用除余法构建哈希函数，用链表法解决哈希冲突
     */
    public static class HashSearch {

        // 哈希结点
        private class Node {
            int key;             // 链表中的键
            Node next;           // 下一个同义词
        }

        // 用求余法，链表法构建哈希表
        public Node[] hashTable(int[] data, int p) {    // p值为取表长
            Node[] hashNode = new Node[p];
            int k;                                      // 哈希函数计算的单元地址
            for (int i = 0; i < data.length; i++) {
                Node node = new Node();
                node.key = data[i];
                node.next = null;
                k = data[i] % p;
                if (hashNode[k] == null) {
                    hashNode[k] = node;
                } else {
                    Node current = hashNode[k];
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = node;
                }
            }
            return hashNode;
        }

        // 哈希函数
        public boolean HashFunction(int[] data, int key) {
            int p = 1;
            // 寻找小于或等于最接近表的长度的质数
            for (int i = data.length; i > 1; i--) {
                if (isPrimes(i)) {
                    p = i;
                    break;
                }
            }
            Node[] table = hashTable(data, p);  // 创建哈希表
            // 查找key的值是否在哈希表中
            int k = key % p;
            Node current = table[k];
            while (current != null && current.key != key) {
                current = current.next;
            }
            if (current == null) {
                return false;
            } else {
                return true;
            }
        }

        /*判断是否为质数*/
        public boolean isPrimes(int n) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    private static void test_Search() {
        int[] arr = {1, 0, 3, 9, 8, 6, 7, 2, 5, 4, 60,};
//        Sort s = new Sort();
//        s.insertSort(arr, arr.length);
//        Find find = new Find();
//        System.out.print("\n下标为：" + find.binarySearch(arr, 7));
        Find.HashSearch hash = new Find.HashSearch();
        if (hash.HashFunction(arr, 6)) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 6) {
                    System.out.print(i);
                }
            }
        } else System.out.print("不存在");
    }
}
