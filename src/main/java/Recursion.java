import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Class:Recursion
 * @Author:chujinlong
 * @Description:递归算法 1、方法里调用自身
 * 2、使用递归策略时必须有一个明确的递归结束条件，即递归出口
 * 3、递归次数过多容易造成栈内存溢出
 * @Data:2020/8/14
 */
public class Recursion {

    /**
     * 斐波那契数列
     *
     * @param index
     * @return
     */
    public int add(int index) {
        if (index == 1 || index == 2) {
            return 1;
        } else {
            return add(index - 1) + add(index - 2);
        }
    }

    /**
     * 阶乘
     *
     * @param index
     * @return
     */
    public int multiply(int index) {
        if (index == 1) {
            return 1;
        } else {
            return multiply(index - 1) * index;
        }
    }

    /**
     * 遍历文件夹及文件
     *
     * @param localPath
     */
    public void getDir(String localPath) {
        File file = new File(localPath);
        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            for (int j = 0; j < fileList.length; j++) {
                if (fileList[j].isDirectory()) {
                    System.err.println("文件夹：" + fileList[j].getPath());
                    getDir(fileList[j].getPath());
                }
                if (fileList[j].isFile()) {
                    System.out.println("文件：" + fileList[j].getPath());
                }
            }
        }
    }

    /**
     * 汉诺塔
     *
     * @param num    盘子数量
     * @param first  第一根柱子
     * @param second 第二根柱子
     * @param third  第三根柱子
     */
    private void move(int num, String first, String second, String third) {
        if (num == 1) {
            System.out.println("移动盘子1从:" + first + "到" + third);
        } else {
            move(num - 1, first, third, second);
            System.out.println("移动盘子" + num + "从:" + first + "到" + third);
            move(num - 1, second, first, third);
        }
    }


    public static void main(String[] args) {
        Recursion recursion = new Recursion();
//        int sum1 = recursion.add(10);
//        int sum2 = recursion.multiply(10);
//        System.out.println("斐波那契数列：" + sum1);
//        System.out.println("阶乘：" + sum2);
//        recursion.getDir("/Users/chujinlong/apache-maven-3.6.2");
        recursion.move(5, "柱子A", "柱子B", "柱子C");

        List<Integer> list = new ArrayList<Integer>();
    }
}
