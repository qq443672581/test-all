package cn.dlj1.simple;

/**
 * 根据输入的数字和次数生成结果
 * 数字：2
 * 次数：3
 * 结果：2+22+222=246
 *
 *
 */
public class NumberAdd {

    public static void main(String[] args) throws java.io.IOException {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("请输入数字：");
        int number = scan.nextInt();
        System.out.println("请输入次数：");
        int size = scan.nextInt();

        StringBuilder temp = new StringBuilder();
        long count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            temp.setLength(0);
            for (int j = 0; j <= i; j++) {
                temp.append(number);
            }
            count += Integer.parseInt(temp.toString());
            sb.append(temp.toString());
            if (i < size - 1) {
                sb.append("+");
            }

        }
        System.out.println("结果：");
        System.out.println(sb.toString() + "=" + count);

    }

}
