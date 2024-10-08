package com.wyz.test;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchContact {


    /**
     * 1、固定电话
     * 符合一条即阻止，并提示“请提供正确的固定电话”
     * 1） 电话号码长度不是7、8、11、12、13位 Y
     * 2） 号码以10、11、12、95、400、800、非0（包含区号）等开头 Y
     * 3） 电话号码不是13位，以00开头  Y
     * 4） 电话号码13位，数字的前5位不是以00852、00853开头(港澳电话) Y
     * 5） 有7个连续数字相同  Y
     * 6） 含有非数字  Y
     *
     * @param telNo 座机号码
     */
    public static int matchMachine(String telNo) {
//        TextUtils.isEmpty(telNo);
        if (telNo.isEmpty()) {
            return 1;
        }
        System.out.println("长度为：" + telNo.length());

        telNo = telNo.replaceAll("\\s|-", "");
        System.out.println("电话号码为：" + telNo);

        // include non number, length non 7、8、11、12、13
        if (!telNo.matches("\\d{7,8}|\\d{11,13}")) {
            return 2;
        }

        //The machine number is not 13 digits. It begins with 00
        if (telNo.length() != 13 && telNo.startsWith("00")) {
            return 3;
        }

        //There are 7 Numbers that are the same
        if (isSameNumber(telNo, 7)) {
            return 4;
        }

        //Telephone number 13 digits, the first 5 digits of the number does not
        // start with 00852, 00853 (Hong Kong and Macao telephone)
        if (telNo.length() == 13 && !telNo.matches("(00853|00852)[0-9]{8}")) {
            return 5;
        }

        //the number does not start with 10、11、12、95、400、800
        if (telNo.matches("(10|11|12|95|400|800)\\d+")) {
            return 6;
        }

        //Non-zero start (including area code)
        if (telNo.matches("\\d{11,12}") && !telNo.matches("^0\\d+")) {
            return 7;
        }

        //zero start (not contain area code)
        if (telNo.matches("\\d{7,8}") && telNo.matches("0\\d+")) {
            return 8;
        }

        return 0;
    }

    /**
     * 2、手机
     * 符合一条即阻止，并提示“请提供正确的手机号”
     * 1）电话号码长度不是11位 Y
     * 2）电话号码11位，前两位不是13、14、15、16、17、18、19 Y
     * 3）有7个连续数字相同 Y
     * 4）含有非数字 Y
     *
     * @param telNo 手机号码
     * @return 1表示为空字符串；2表示不是11位，不是以13、14、15、16、17、18、19开头，包含非数字；
     * 4表示包含相同7个连续相同字符串；0表示匹配成功
     */
    public static int matchPhone(String telNo) {
        if (telNo.isEmpty()) {
            return 1;
        }
        //length non 11 ，the head  non 13、14、15、16、17、18、19,includ non number
        if (!telNo.matches("(13|14|15|16|18|17|19)[0-9]{9}")) {
            return 2;
        }
        //There are 7 Numbers that are the same
        if (isSameNumber(telNo, 7)) {
            return 4;
        }
        return 0;

    }


    /**
     * 3、地址
     * 地址除省市区外，具体地址少于5个汉字即阻止，并提示“请提供详细地址”
     *
     * @param address 联系地址
     */
    public static void matchAddress(String address) {

    }


    /**
     * @param word  需要匹配的字符串
     * @param rules 匹配规则（正则表达式）
     * @return true表示匹配成功，否则匹配失败
     */
    public static boolean isMatch(String word, String rules) {
        Pattern pattern = Pattern.compile(rules);
        Matcher isSuc = pattern.matcher(word);
        return isSuc.matches();
    }


    /**
     * 判断数字字符串包含连续相同的数字
     *
     * @param telNo  电话号码
     * @param number 多少位连续相同
     * @return true 有number位相同，否则返回false
     */
    public static boolean isSameNumber(String telNo, int number) {
        if (number <= 1) {
            throw new IndexOutOfBoundsException("number must >1 ");
        }
        char temp = 'a';
        int count = 1;

        char[] chars = telNo.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (count > (number - 1)) {
                return true;
            }
            if (i == 1) {
                temp = chars[i];
                continue;
            } else {
                if (String.valueOf(chars[i]).equals(String.valueOf(temp))) {
                    count++;
                } else {
                    count = 1;
                    temp = chars[i];
                }
                //需要优化 当count小于2并且后面剩余为5，不进行循环
            }
            System.out.print(chars[i] + " ，");

        }

//        System.out.println("出现次数"+count);
//        if (count > (number)){
//            return true;
//        }else {
//            return false;
//        }
        return false;
    }


}
