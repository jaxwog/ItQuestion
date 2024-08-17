package com.wyz.array;

/**
 * Created by jax on 2019/11/4 14:57
 * TODO: 大数相乘
 */
public class BigCount {

    public static void main(String[] args) {
        String str1 = "11111111111111111111111111111111";
        String str2 = "11111111111111111111111111111111";

        int len1 = str1.length();
        int len2 = str2.length();

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        // 高低位对调
        covertData(s1, len1);
        covertData(s2, len2);
        System.out.println("乘数：" + str1);
        System.out.println("乘数：" + str2);

        multiply(s1, len1, s2, len2);
    }


    /**
     * 数据进行高低位兑换，只需要遍历长度的一半
     */
    public static void covertData(char data[], int len) {
        //高低位对调,低位在前，方便进行计算
        for (int i = 0; i < len / 2; i++) {
            data[i] += data[len - 1 - i];
            data[len - 1 - i] = (char) (data[i] - data[len - 1 - i]);
            data[i] = (char) (data[i] - data[len - 1 - i]);
        }
    }

    public static void multiply(char a[], int aLen, char b[], int bLen) {
        // 两数乘积位数不会超过乘数位数和+ 3位
        int cSize = aLen + bLen + 3;
        // 开辟乘积数组
        int[] c = new int[cSize];


        // 对齐逐位相乘
        for (int j = 0; j < bLen; j++) {
            for (int i = 0; i < aLen; i++) {
                //首要决定十位的为:[0,1] [1,0] 第一个数的个位和第二个数的十位，第一个数的十位和第二个数的个位   和次要[0,0]两个数的个位最大为81，则8表示十位
                //首先计算两个数的首要决定要素:1、c[i + j] = a[i]*b[j]  2、c[j + i] = a[j]*b[i]，i + j表示对应位置的数据（十位对应的[0,1] [1,0]）
                c[i + j] += Integer.parseInt(String.valueOf(a[i])) * Integer.parseInt(String.valueOf(b[j]));
            }
        }

        int m = 0;
        // 进位处理，个位次要决定十位的数向后（数据进行了倒叙）进位
        for (m = 0; m < cSize; m++) {
            int carry = c[m] / 10;//求出十位数据内容
            c[m] = c[m] % 10;//求出个位数
            if (carry > 0)
                c[m + 1] += carry;
        }

        // 找到最高位，防止数组最后几位为0的输出（最高位）
        for (m = cSize - 1; m >= 0; ) {
            if (c[m] > 0) break;
            m--;
        }

        // 由最高位开始打印乘积
        System.out.print("乘积：");
        //从后向前依次打印数据，打印的数据就为两个大数的乘积
        for (int n = 0; n <= m; n++) {
            System.out.print(c[m - n]);
        }

    }
}
