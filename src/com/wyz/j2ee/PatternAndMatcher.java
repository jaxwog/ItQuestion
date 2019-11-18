package com.wyz.j2ee;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndMatcher {

    public static void test1(){
        print("abc".matches("..."));//字符匹配，.表示任何字符
        print("a1234b".replaceAll("\\d","-"));//把所有的数字替换成"-"

        Pattern pattern = Pattern.compile("[a-z]{3}");//首先进行编译，编译为pattern实例,恰好出现3次
        Matcher matcher = pattern.matcher("ahg");//然后将得到的实例用于创建matcher对象
        print(matcher.matches());

        print(Pattern.matches("[a-z]{3}","ahg"));//不允许重用已编译的模式
    }

    //初步认识  . * + ?
    public static void test2(){
        print("a".matches("."));
        print("aa".matches("aa"));
        print("aaaa".matches("a*"));  //表示a出现零次或者多次（最少0次）
        print("aaaa".matches("a+"));// 表示a出现一次或多次（最少一次）
        print("aaaa".matches("a?")); //一次或者一次都没有（最多一次）
        print("32461781929276".matches("\\d{3,100}"));//数字至少出现3次，最多出现100次；如果{3，}表示最少出现3次
        print("192.168.0.156".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));//  \\.表示

    }
      //范围
    public static void test3(){
        print("a".matches("[abc]"));//一个字符是否属于abc中的某一个
        print("a".matches("[^abc]"));//任何字符，除了a b c
        print("a".matches("[a-zA-z]"));//a到z或者A到Z，取并集
        print("a".matches("[a-z]|[A-Z]"));
        print("a".matches("[a-z[A-Z]]"));
        print("R".matches("[a-z&&[RFG]]"));//取a到z与RFG的交集
    }

    //认识 \s \w \d \
    public static void test4(){
        print(" \n\t\r".matches("\\s{4}")); // \s表示空白字符
        print(" ".matches("\\S"));    //\S表示非空白字符
        print("w_8".matches("\\w{3}"));//  \w表示单词字符，包括：a-z，A-Z ，_ ,0-9
        print("abc12345&^%".matches("[a-z]{1,3}\\d+[&%^]+"));
        print("\\".matches("\\\\")); //一个反斜杠在正则表达式中用\\表示，则第一个与第三个表示转义字符
    }

    //边界处理
    public static void test5(){
        print("hello sir".matches("^h.*"));//以h开头，后面跟了0个或多个字符
        print("hello sir".matches(".*ir$"));//前面多个字符，后面以ir结尾
        print("hello sir".matches("^h[a-z]{1,3}o\\b.*"));//以o为单词边界符号（后面跟空格）
        print("hellosir".matches("^h[a-z]{1,3}o\\b.*"));//边界符是r

        //判断空白行(前面是空格符，后面是回车结尾)
        print(" \n".matches("^[\\s&&[^\\n]]\\s*\\n$"));//开头以空格字符，而非换行符
        print(" \n".matches("^[\\s&&[^\\n]]*\\n$"));//*表示可以为0次或多次（以空格字符开头，后面跟*个空格字符非换行）
        print(" \n".matches("^\\s*\\n$"));

        print("aaa 8888c".matches(".*\\d{4}."));
        print("aaa 8888c".matches(".*\\b\\d{4}."));
        print("aaa8888c".matches(".*\\d{4}."));
        print("aaa8888c".matches(".*\\b\\d{4}."));

    }

    //POSIX 用于处理Unix上
    public static void test6(){
        print("a".matches("\\p{Lower}"));
        //适配邮箱
        print("abgdkA_123@gmail.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.\\w+"));
    }

    //matches  find  lookingAt
    public static void test7(){
        Pattern p = Pattern.compile("\\d{3,5}");
        String s = "123-4567-789-00";
        Matcher m = p.matcher(s);
        print(m.matches());//find 与matches相互影响，matches调用到第四个字符（-），find从第五个字符（4）开始查找
        m.reset();//消除find 与matches相互影响，字符从（头）第一个字符序列开始
        print(m.find());//查找与该模式匹配的输入序列的子序列，下一个find从字符（4）开始查找
        print(m.start()+"-"+m.end());//输出结果为0-3，查找到最后一个字符为3（-）；没有找到匹配内容无法输出开始与结束为止
        print(m.find());
        print(m.start()+"-"+m.end());
        print(m.find());
        print(m.start()+"-"+m.end());
        print(m.find());

        print(m.lookingAt());//从头开始的输入序列与该模式匹配，下一个lookingAt依然从头（第一个）开始
    }

    //字符替换
    public static void test8(){
      Pattern p = Pattern.compile("java",Pattern.CASE_INSENSITIVE);
      String s = "addg java Java JAVa JaVa IloveJAVA you hateJava afasdfasdf";
      Matcher m = p.matcher(s);
      StringBuffer buffer = new StringBuffer();
      int i = 0;
      while (m.find()){
          i++;
          if (i%2==0){
              m.appendReplacement(buffer,"java");//替换字符串
          }else {
              m.appendReplacement(buffer,"JAVA");
          }
      }
      m.appendTail(buffer);//加上尾端不匹配的字符
      print(buffer);

//      while (m.find()){
//          print(m.group());//查找全部java匹配的子串
//          print(m.replaceAll("JAVA"));//替换全部已经找到的字符串
//
//      }

    }

    //分组
    public static void test9(){
        //左边有几个左括号就是第几组，数组是第一组，字母是第二组
        Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");
        String s = "123aa-34345bb-234cc-00";
        Matcher m = p.matcher(s);
        while (m.find()){
            print(m.group(1));//不输入为数字+字母，输入1显示全部数字，输入2显示字母
        }
    }

    //greedy  reluctant   possessive
    public static void test10(){
//        Pattern p = Pattern.compile("(.{3,10})([0-9])");//greedy 方式进行匹配，首先吞如10个，然后从最后依次吐（从第十个吐）
//        Pattern p = Pattern.compile("(.{3,10}?)([0-9])");//reluctant 首先吞吐3个，然后依次往后吞（从第4个开始吞）
        Pattern p = Pattern.compile("(.{3,10}+)([0-9])");//reluctant 首先吞吐10个，然后依次往后吞（从第11个开始吞）
        String s = "aaaa4bbbb5";
        Matcher m = p.matcher(s);
        if (m.find())
            print(m.start()+"-"+m.end());
        else
            print("nothing");
    }
    //non-capturing groups  比较少用，理解
    public static void test11(){
        Pattern p = Pattern.compile(".{3}(?=a)");//写后面不捕获a（输出444）；"(?=a).{3}"写前面捕获（输出a66）
        String s = "444a66b";
        Matcher m = p.matcher(s);
        while(m.find()) {
            print(m.group());
        }
    }

    public static void test12(){

        Pattern p = Pattern.compile("(\\d(\\d))\\2");//第二个组里面进行匹配，是否与第二组（2）一致
        String s = "122";
        Matcher m = p.matcher(s);
        print(m.matches());


        //flags的简写
        //Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
//        print("Java".matches("(?i)(java)"));
    }




    public static void testEmail(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/wangyongzheng/Downloads/javaVideo/email.html"));
            String line = null;
            while ((line=bufferedReader.readLine())!=null){
                matcherEmail(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void matcherEmail(String line){
        Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.\\w+");
        Matcher m = p.matcher(line);
        while (m.find()){
            print(m.group());
        }

    }

    static long normalLines = 0;//代码行
    static long commentLines = 0;//注释行
    static long whiteLines = 0; //空白行

    //统计代码行数
    public static void testCode(){
        File file = new File("/Users/wangyongzheng/IDEA/ItQuestion/src/com/wyz/array");
        File[] files = file.listFiles();
       for (File file1:files){
           if (file1.getName().matches(".*\\.java$")) {
//               print(file1.getName());
               matcherCode(file1);
               //单文件调试程序
//               if (file1.getName().matches("GGenList.java")){
//
//               }

           }
       }

       print("normalLines="+normalLines);
        print("commentLines="+commentLines);
        print("whiteLines="+whiteLines);



    }



    public static void matcherCode(File file){
        BufferedReader buffer = null;
        boolean flag = false;
        try {
            buffer = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line=buffer.readLine())!=null){
                //readLine读取内容没有最后结尾的换行符号(\n)
                line = line.trim();
                if (line.matches("^[\\s&&[^\\n]]*$")){
                    whiteLines++;
                    //以开头，以结尾，表示多行注释中的一行注释
                }else if (line.startsWith("/*")&&line.endsWith("*/")){
                    commentLines++;
                }else if (line.startsWith("/*")&&!line.endsWith("*/")){
                    commentLines++;
                    flag = true;
                }else if (true==flag){
                    commentLines++;
                    if (line.endsWith("*/")){
                       flag = false;
                    }
                    //空格影响判断，可以用正在表达式消除空格影响
                }else if (line.startsWith("//")){
                    commentLines++;
                }else {
                    normalLines++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (buffer!=null){
                try {
                    buffer.close();
                    buffer = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void print(Object o){
        System.out.println(o);
    }
}
