import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by pan on 2018/12/3.
 */
public class Hello {


    public static void main(String[] args) {
        Random random = new Random();
        int[] s = new int[1000];

//        int intRd = 0; //存放随机数
//        int count = 0; //记录生成的随机数个数
//        int flag = 0; //是否已经生成过标志

        for (int i = 0; i < s.length; i++) {
            s[i] = random.nextInt(10000);//获取100内的随机数
//          long a = Math.round(Math.random() * (5 - 1) + 1);//产生Min-Max之间的数字 Math.round(Math.random()*(Max-Min)+Min)

//            if (s[i] == intRd) {
//                flag = 1;
//                break;
//            } else {
//                flag = 0;
//            }
    }

        try {
            FileOutputStream Output = new FileOutputStream("C:\\Users\\pan\\Desktop\\test.txt");
            StringBuffer sb = new StringBuffer();
            for (int string : s) {
                sb.append(string + ",");
            }
            try {
                Output.write(sb.toString().getBytes());
//                System.out.println(i_num);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
