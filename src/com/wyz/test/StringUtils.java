package com.wyz.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {


    public void simpleTest() {
        //.表示任何字符
        p("abc".matches("..."));
        // \d表示数字
        p("a23412b".replaceAll("\\d", "-"));

        //[a-z] 表示字母中a到z ，{3}表示a到z出现次数
        //好处是程序编译时候就加载，省却调用时加载
        Pattern pattern = Pattern.compile("[a-z]{3}");
        Matcher matcher = pattern.matcher("abc");
        p(matcher.matches());

        p("abc".matches("[a-z]{3}"));

    }


    //  .  *  +  ?
    public void simpleTest1() {

        p("a".matches("."));
        p("aa".matches("aa"));
        //* 表示0次或多次
        p("aaaa".matches("a*"));
        //+ 一次或者多次
        p("aaaa".matches("a+"));
        p("".matches("a*"));

        // ? 一次或一次也没有
        p("aaaa".matches("a?"));
        p("".matches("a?"));
        p("a".matches("a?"));
        //{3,100}表示3次或者100次之间 {3,}至少3次 {3}恰好三次
        p("214523145234532".matches("\\d{3,100}"));
        // 适配. 需要\\. 方式
        p("192.168.1.1".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
        p("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
        //[0-2] 表示0到2 区间（0与2包括在内 ）,匹配一个字符  1是不是属于[0-2]
        p("192".matches("[0-2][0-9][0-9]"));


    }

    public void simpleTest2() {
        //字符串a是否在规则里面（abc 中的一个）
        p("a".matches("[abc]"));
        //^表示除了adc以外的其它字符
        p("d".matches("[^abc]"));
        //[a-zA-Z]  小写a到z 与大写A到Z的并集
        p("A".matches("[a-zA-Z]"));
        // [a-z]|[A-Z]  小写a到z 与大写A到Z的并集
        p("A".matches("[a-z]|[A-Z]"));
        //[a-z[A-Z]]小写a到z 与大写A到Z的并集
        p("A".matches("[a-z[A-Z]]"));
        // [A-Z&&[RFG]]  表示大写A到Z 与 RFG 的交集
        p("R".matches("[A-Z&&[RFG]]"));
    }


    public void simpleTest3() {
        // \s表示空白字符
        p(" \n\r\t".matches("\\s{4}"));
        //  \S非空白字符
        p(" ".matches("\\S"));
        // \w单词字符 [a-zA-Z_0-9]
        p("a_8".matches("\\w{3}"));
        //[a-z]{1,3}\d+[&^#%]+  表示：小写字母1-3个，数字一次或者多次，特殊符号中的一个或者多个出现一次或者多次
        p("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
        //适配一个\，正则表达式中需要用4个表示
        p("\\".matches("\\\\"));
    }

    public void simpleTest4() {
        // 小写字母字符[a-z]
        p("a".matches("\\p{Lower}"));
        // ^h.* 以h开头，后面跟着0个或者多个字符
        p("hello sir".matches("^h.*"));
        //.*ir$  前面0个或者多个字符，以ir结尾
        p("hello sir".matches(".*ir$"));
        //^h[a-z]{1,3}o\b.*  以h开头，a-z出现1到3次，字母o，\b单词边界，零个或者多个字符
        p("hello sir".matches("^h[a-z]{1,3}o\\b.*"));
        p("hellosir".matches("^h[a-z]{1,3}o\\b.*"));
        //^[\s&&[^\n]]*\n$   以空白字符与非换行字符的开头，并出现0次或者多次，以换行符结尾
        // ^在[]外面表示开头，在里面表示否定
        p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));

        //.*\d{4}.  0或者多个字符，4个数字，一个字符
        p("aaa 8888c".matches(".*\\d{4}."));
        // .*\b\d{4}.  0或者多个字符，单词的边界，4个数字，一个字符
        p("aaa 8888c".matches(".*\\b\\d{4}."));
        // .*\d{4}.  0或者多个字符，4个数字，一个字符
        p("aaa8888c".matches(".*\\d{4}."));
        p("aaa8888c".matches(".*\\b\\d{4}."));

    }

    public void simpleTest5() {
//        [\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?
        p("asdfasdfsafsf@dsdfsdf.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));
//        \d{3}-\d{8}|\d{4}-\{7,8}  适配电话号码
//        匹配年月日日期格式
//        ([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))

/**
 * matches() 尝试将整个区域与模式进行匹配，匹配后会从把123-截取下来，剩下34345-234-0
 * reset() 重置匹配器，把123-再还原回去为123-34345-234-00
 * m.find() 尝试查找与该模式匹配的输入序列的下一个子序列
 * start() 查找到适配的数据的开始位置  ，如果没有适配的数据 start 和 end 为空，error  IllegalStateException：No match available
 * end() 查找到适配的数据的后一个位置
 * lookingAt() 尝试从区域开头的输入序列与该模式匹配（不会再往后查询）
 * warning：find()会依次往后查询；lookingAt()一直是在第一个匹配位置查询，不会后移
 */
        Pattern p = Pattern.compile("\\d{3,5}");
        String s = "123-34345-234-00";
        Matcher m = p.matcher(s);
        p(m.matches());
        m.reset();
        p(m.find());
        p(m.start() + "-" + m.end());
        p(m.find());
        p(m.start() + "-" + m.end());
        p(m.find());
        p(m.start() + "-" + m.end());
        p(m.find());
//        p(m.start() + "-" + m.end());
        p(m.lookingAt());
        p(m.lookingAt());
        p(m.lookingAt());
        p(m.lookingAt());

    }

    public void simpleTest6() {

        // 忽略大小写，Pattern.CASE_INSENSITIVE标志
        Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher("java Java JAVa JaVa IloveJAVA you hateJava afasdfasdf");
        StringBuffer buf = new StringBuffer();
        int i = 0;
        // 实现非终端的添加和替换步骤
        while (m.find()) {
            //打印出来正则表达式匹配的子串
            p(m.group());
            i++;
            if (i % 2 == 0) {
                m.appendReplacement(buf, "java");
            } else {
                m.appendReplacement(buf, "JAVA");
            }
        }
        //实现终端的添加和替换步骤，添加尾部afasdfasdf
        m.appendTail(buf);
        p(buf);

    }

    public void simpleTest7() {
        //分组：()表示，从左边开始，有多少个小括号就表示是第几组
        // matcher.group(1) 表示输出第一组数据（3到5为数字）
        Pattern pattern = Pattern.compile("(\\d{3,5})([a-z]{2})");
        String s = "123aa-34345bb-234cc-00";
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            p(matcher.group(1));
        }

    }

    //qulifiers
    public void simpleTest8() {
        /**
         * .{3,10}[0-9]  find() 时候从最大的10位开始吞，如果不匹配再往外吐一个比较，依次类推（Greedy 贪婪的）
         * .{3,10}?[0-9] find() 时候从最小的3位开始吞，如果不匹配再往后吞一个比较，依次类推（Reluctant  不情愿的 ）
         * .{3,10}+[0-9] find() 时候从最大的10位开始吞，如果不匹配再往后吞一个比较，依次类推（Possessive  拥有的 ）
         */
        Pattern p = Pattern.compile(".{3,10}+[0-9]");
        String s = "aaaa5bbbb68";
        Matcher m = p.matcher(s);
        if (m.find())
            p(m.start() + "-" + m.end());
        else
            p("not match!");

    }


    public void simpleTest9() {
        //前面三个字符，后面跟着a的字符串，输出没有a
//        Pattern p = Pattern.compile(".{3}(?=a)");
        //a后面两个字符，带a一共三个字符
        Pattern p = Pattern.compile("(?=a).{3}");
//        Pattern p = Pattern.compile("(?=中国人).{3}");
        String s = "444a66b";
//        String s = "baaa中国人";
        Matcher m = p.matcher(s);
        while (m.find()) {
            p(m.group());
        }
    }

    public void simpleTest10() {

        /**
         * 规则  (\d(\d))\2  字符 122  表示适配第二个括号里面的数据（第一个括号为12，第二个括号里面为2），适配第二个括号则第三位需要为2
         * 规则 (\d(\d))\1  字符 1212   表示适配第一个括号里面的数据（第一个括号为12，第二个括号里面为2），适配第一个括号则需要后两位为12
         */
        Pattern p = Pattern.compile("(\\d(\\d))\\1");
        String s = "1212";
        Matcher m = p.matcher(s);
        p(m.matches());

        //flags的简写，(?i) 启用不区分大小写的匹配
        //Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        p("JavA".matches("(?i)(java)"));
    }

    //    号码以10、11、12、95、400、800、非0（包含区号）等开头
    public void simpleTest11() {

//        Pattern p = Pattern.compile("^(00)\\d{3}f$");
//        String s = "00123f";

//        Pattern p = Pattern.compile("(10|11|12|95|400|800)\\d+");
//        String s = "100234567";
//        Matcher m = p.matcher(s);
//        p(m.matches());

        String telNo = "23925626008";
//        p(!telNo.matches("^0\\d+"));

        if (telNo.matches("\\d{11,12}") && !telNo.matches("^0\\d+")) {
            System.out.println("------");
        }
    }

    /**
     *
     */
    public void simpleTest12() {
        Pattern p = Pattern.compile("(?=区).{5,}");
        String s = "北京市昌平区生命科学园区万科生物中心";
        Matcher m = p.matcher(s);
        while (m.find()) {
            p(m.group().replace("区", ""));


        }


    }


    public static void p(Object o) {
        System.out.println(o.toString());
    }


}
