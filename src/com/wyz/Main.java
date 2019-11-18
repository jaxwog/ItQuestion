package com.wyz;



import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.wyz.array.*;
import com.wyz.j2ee.ArraySearch;
import com.wyz.linearlist.SeqList;
import com.wyz.linearlist.SinglyLinkedList;
import com.wyz.linearlist.SinglyLinkedList_reverse;
import com.wyz.linearlist.SortedSinglyLinkedList;
import com.wyz.recursion.DigitTower;
import com.wyz.recursion.Fibonacci;
import com.wyz.stack.Process;
import com.wyz.stack.*;
import com.wyz.test.CharacterParser;
import com.wyz.test.Dog;
import com.wyz.test.RMBTotial;
import com.wyz.tree.BinaryTree;
import com.wyz.tree.TestHH;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.security.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static byte[] enCodeFormat;

    public static void main(String[] args) {
	// write your code here
        System.out.println("Test Start！\n");

//        ProducerConsumer.test();

//        PatternAndMatcher.test12();

       // RunAndThread.runTTSync();

//        StreamAndRead.testObjectIO();

       // testSeqList();
        //testSinglyLinkedList();
        //testSortedSinglyLinkedList();
        // testSeqStack();
        // testLinkedStack();
        //String expstr="((1+2)*3+4))(";
        //System.out.println(expstr+"#######"+ UtilStack.isvalid(expstr));
       // System.out.println(UtilStack.TransportNum(95,8));

        //testSeqQueue();
       // testLinkedQueue();

       // testPrimeRing();
        //testProcess();

        //System.out.println(Factorial.factorial(0));
//        testFibonacci();
        //testDigitTower();
          // testMatrix();
          // testDownTriangleMatrix();
//        testSeqSparseMatrix();
//      System.out.println("************************************************************");
//        testCrossLinkedSparseMatrix();
//        testArraySort();

        //TestNumber.methed(5);
      // TestNumber test = new TestNumber(3.0,5.0,4.0);
//        test.setX(1.0);
//        test.setX(test.getY());

//        TestNumber.sortArray11(new int[]{2,4,6,8,1,3,5,7,9});


//        boolean []arr = new boolean[500];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = true;
//        }
//
//        Count3Quit cout = new Count3Quit(arr);
//        cout.quit();

//        Count3Quit2 test = new Count3Quit2();
//        test.start();

//        String sToDouble = "1,2,3;4,5;6,7,8,9";
//        ArraySearch.stringToDouble(sToDouble);

//        ArraySearch.fileCreat();

//        ArraySearch.findFile();
        //ArraySearch.enumDir(ArraySearch.myColor.black);

//        ArraySearch.collect();

//        findClass1();
//        findClass2();
//        findClass3();

//        findClass4();

//        findclass5();

//        findclass6();

//        System.out.println(getPeopleIn("18000"));
//        int i = 0x0000;
//        System.out.println(i);
//        System.out.println(getWordType( i+""+ i));
//        System.out.println(getWordType1(i+" "+ i));
//        System.out.println(isChineseStr(" 王 永 政 "));
//        System.out.println(interceptString1("王永政王永政王永政王永政",10,"..."));

//        String s1 = "泰康集团股份有限公司股份";
//        String s2 = "股份";
//        System.out.println(includeStr(s1,s2));

//        String s1 = "泰康<em>集团股份有限</em>公司<em>股份</em>";
//        System.out.println(getHe(s1));
//        String s = "10元/月";
//        String s = "125";
//        subStringTwo(s);

//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            list.add("泰康人寿集团"+i+"泰康人寿集团");
//        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println("---------------------------");
//        List<String> list2 = new ArrayList<>();
//        list2 = hitTarget(list,"团");
//
//        for (int i = 0; i < list2.size(); i++) {
//            System.out.println(list2.get(i));
//        }

//        CharacterParser characterParser =  CharacterParser.getInstance();
//
//        System.out.println(characterParser.convert("拗"));
//        System.out.println(characterParser.getSelling("阿尔法罗密欧").toUpperCase());

//        System.out.println(characterParser.getSelling("泰康集团有限公司"));
//        System.out.println(getWordType22(characterParser.convert("王")));
//        String sle = CharacterParser.getInstance().getSelling("王洗司");

//        System.out.println(sle);
//        int i = sle.indexOf("z");
//        System.out.println("位置信息="+i);

//        getAryIndex(sle,"si");

            //位运算计算
//           getEndNumber(-14,2,">>");
//        getEndNumber(13,3,"|");

//        System.out.println(interceptString1("310000",2,"0155"));

//     int i = getMobilePhoneNumber("13085888888");
//     if (i!=0){
//         System.out.println("匹配失败"+i);
//     }else {
//         System.out.println("匹配成功"+i);
//     }


//        System.out.println("返回码="+getPhoneNumber("0085218888877"));

//        StringUtils utils = new StringUtils();
//        utils.simpleTest12();

//        CodeCounter.findFile("/Users/wangyongzheng/IDEA/ItQuestion/src/com/wyz/array");

//      int resultNo =  MatchContact.matchPhone("40187654321");
//        int resultNo =  MatchContact.matchMachine("40187654321");
//        int resultNo =  MatchContact.matchMachine("56 260 08");
//      if (resultNo==0){
//          System.out.println("匹配成功："+resultNo);
//      }else {
//          System.out.println("匹配失败："+resultNo);
//      }

//      String  moneyPay = price("0.1").multiply(BigDecimal.valueOf(0.85)).toString();
//
//        System.out.println(moneyPay);

//  String s = "2017-12-08 00:00:00";
//
//        s = s.replaceAll("-",".");
//
//        System.out.println(s.length());
//      s = s.substring(0,s.length()-3);
//        System.out.println(s);
//        System.out.println(s.length());
//        System.out.println(getWordNumOrLett("0,123423343fbfdaA"));


        jdkAES();

        String content = "test";
        String password = "12345678";
        //加密
        System.out.println("加密前：" + content);
        byte[] encryptResult = encrypt(content, password);
        System.out.println("加密后：" + Base64.encode(encryptResult));
        //解密
        byte[] decryptResult = decrypt(encryptResult,password);
        System.out.println("解密后：" + new String(decryptResult));
//
//        encrypByMD5("test5a6d2bd272588e09448e746862cfa16c9328453fbffdddcff2218fc3");
          //=======================================================================================
//        //模拟安卓消息队列
//        Looper.prepare();//初始化
//        //主线程
//        Handler handler = new Handler(){
//            @Override
//            public void handleMessage(Message msg) {
//                System.out.println(Thread.currentThread().getName()+",接收到消息"+msg.toString());
//            }
//        };
//
//
//        //子线程
//        for (int i = 0; i < 10; i++) {
//            new Thread(){
//                @Override
//                public void run() {
//                   while (true){
//                       Message msg = new Message();
//                       msg.what = 1;
//                       synchronized (UUID.class){
//                           msg.obj = Thread.currentThread().getName()+"，发送消息"+UUID.randomUUID().toString();
//                       }
//                       System.out.println(msg.toString());
//                       handler.sendMessage(msg);
//                       try {
//                           Thread.sleep((long) (1000*Math.random()));
//                       } catch (InterruptedException e) {
//                           e.printStackTrace();
//                       }
//                   }
//                }
//            }.start();
//        }
//
//        Looper.loop();//开始轮询
        //=======================================================================================

//        FutureTest.test();
//        AsyncTaskTest.test();

//        System.out.println("args="+args[0]);

        //检测apk中文件名字
//        ArscTest.Test();

//        AescReleaseMain.test(args);
//        System.out.println(getLengthBit("北京市昌平=-=北京市=-=生命科学园"));
//2019-09-20 下午
//        System.out.println( getDateLine("2019-09-20 下午"));

//         HashMap hashMap = new HashMap();
//        hashMap.put("hh1","hh");
//        hashMap.put("hh2","hh");
//        hashMap.put("hh3","hh");
//        hashMap.put("","hh");
//        System.out.println( hashMap.toString());

//        for (int j = 0; j < 5; ++j) {
//            System.out.println("===="+j);
//
//        }
//        System.out.println("传入长度=224,计算后长度="+tableSizeFor(224));


//        binaryTreeHH();

        System.out.println("\nTest End！");

    }
    static void binaryTreeHH(){
        TestHH hh = new TestHH();
        String temp = "ABD##E##C#F##";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < temp.length(); i++) {
            list.add(temp.substring(i,i+1));
        }
        hh.createBinaryTreePre(list);
        System.out.println("树的高度/深度为:"+hh.getHight());


    }


    static void binaryTree(){
        BinaryTree tree = new BinaryTree();

//        tree.createBinaryTree();
//        System.out.println("树的高度/深度为:"+tree.getHight());
//        System.out.println("树的结点数为:"+tree.getSize());
//        tree.preOrder(tree.getRoot());
//        System.out.println("=================================");
//        tree.nonRecOrder(tree.getRoot());
//        System.out.println("=================================");
//        tree.midOrder(tree.getRoot());
//        System.out.println("=================================");
//        tree.postOrder(tree.getRoot());
//        System.out.println("=================================");

        String temp = "ABD##E##C#F##";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < temp.length(); i++) {
            list.add(temp.substring(i,i+1));
        }
        tree.createBinaryTreePre(list);
        tree.preOrder(tree.getRoot());


    }

    //根据传入数据，转换成2的幂的数据
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }

    public static String getDateLine(String mmm){
        if (mmm.contains("午")&& mmm.length()>12){
            String date = mmm.substring(0,10);
            System.out.println("data = "+date+",data.length = "+date.length());
            String time = mmm.substring(mmm.length()-2);
            SimpleDateFormat fff = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            try {
                return "预约时间：" + sdf.format(fff.parse(date).getTime())+time;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            SimpleDateFormat fff = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
            try {
                return "预约时间：" + sdf.format(fff.parse(mmm).getTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "预约时间：";
    }

    public static String getLengthBit(String s){
        int i ;
        while ((i=s.indexOf("=-="))!=-1){
            s = s.substring(i+3);
        }
        String  router_page_path  =  String.format("Appointment?cardticketId=%1$s&channelType=CKGK2019", "我是卡号啊");
        System.out.println(router_page_path);

      return s;

    }


    /***
     * 对指定的字符串进行MD5加密
     */
    public static String encrypByMD5(String originString) {
        try {
            //创建具有MD5算法的信息摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
            byte[] bytes = md.digest(originString.getBytes("utf-8"));
            System.out.println("转换后"+Base64.encode(bytes));

            //将得到的字节数组变成字符串返回
//            String s = byteArrayToHex(bytes);
//            return s.toUpperCase();
            return new String(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param password  加密密码
     * @return
     */
    public static byte[] encrypt(String content, String password) {
        try {

            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            enCodeFormat = secretKey.getEncoded();
//            enCodeFormat = "5a6d2bd272588e09448e746862cfa16c9328453fbffdddcff2218fc3".getBytes();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**解密
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
//            KeyGenerator kgen = KeyGenerator.getInstance("AES");
//            kgen.init(128, new SecureRandom(password.getBytes()));
//            SecretKey secretKey = kgen.generateKey();
//            byte[] enCodeFormat = secretKey.getEncoded();

            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void jdkAES(){

        String src = "Hello this is Test";
        System.out.println("jdk AES 未加密："+ src);

        try {
            //生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();

            //key转换
           Key key = new SecretKeySpec(keyBytes, "AES");

           //加密
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk AES 加密后："+ Base64.encode(result));

            //解密
            cipher.init(Cipher.DECRYPT_MODE,key);
            result = cipher.doFinal(result);
            System.out.println("jdk AES 解密后："+ new String(result));



        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }



    private  static BigDecimal price(String string){
        if (string.isEmpty())
            return BigDecimal.ZERO;
        return new BigDecimal(string);
    }

    /**
     * 时间格式转换  由"yyyy-MM-dd" 转成yyyy年MM月dd日
     * 2017-12-08 00:00:00
     * @param str
     * @return
     */
    public static String getDateFormatYMDHS(String str) {

        // 替换显示格式  'yyyy-MM-dd HH:mm:ss:SS'

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.CHINA);
        try {
            if (!"".equals(str) && str.length() > 18) {
                String substring = str.substring(0, str.length()-3);
                long time = sdf1.parse(substring).getTime();
                String date = sdf.format(new Date(time));
                return date;
            } else {
                return "";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }



    private static int getPhoneNumber(String telNo){
        if (telNo.isEmpty()){
            System.out.println("数据为空");
            return -1;
        }
        int legth = telNo.length();

        //判断长度
        if (legth ==7 ||(legth==8||(legth==11 ||(legth==12||legth==13)))){

            System.out.println("正确数据长度="+legth);
        }else {
            System.out.println("错误数据长度="+legth);
            return 2;
        }

        //
        if (legth!=13 && telNo.startsWith("00")){
            return 4;
        }

        //港澳台地区
        if (!(legth==13 && (telNo.startsWith("00852")|| telNo.startsWith("00853")))){
            return 8;
        }

        //连续7个相同
        if (!getEqsNums(telNo)){
            return 1;
        }

        //非数字
        if (!getWordType3(telNo,"[0-9]*")){
            return 16;
        }

        //号码以10、11、12、95、400、800、非0（包含区号）等开头

//        if (!getWordType3(telNo,"(10|11|12|95|400|800)[0-9]*")){
//            return 32;
//        }

        return 0;
    }



    /**
     * 手机号判断
     * 先排除中间空格影响(先忽略)
     * @param telNo 手机号码
     * @return 为-1 表示匹配失败
     * 1、 判断为空和长度
     * 2、判断是否为纯数字
     */
    private static int getMobilePhoneNumber(String telNo){

        if (telNo.isEmpty()||telNo.length()!=11){
            System.out.println("长度不足");
            return -1;
        }
        System.out.println("长度为："+telNo.length());
//
//        if (!"纯数字".equals(getWordType1(telNo))){
//            return 2;
//        }

        if (!getWordType3(telNo,"[0-9]*")){
            return 2;
        }

        System.out.println(getWordType1(telNo));

//        if (!getWordType2(telNo)){
//            return 4;
//        }

        if (!getWordType3(telNo,"0?(13|14|15|16|18|17|19)[0-9]{9}")){
            return 4;
        }
        System.out.println("前两位是13、14、15、16、17、18、19开头");


        if (!getEqsNums(telNo)){
            return 8;
        }

      return 0;

    }

    /**
     *
     * @param word 需要匹配的字符串
     * @param rules 匹配规则（正则表达式）
     * @return true表示匹配成功，否则匹配失败
     */
    private static boolean getWordType3(String word,String rules){
        Pattern pattern = Pattern.compile(rules);
        Matcher isSuc = pattern.matcher(word);
        if(isSuc.matches() ){
            return true;
        }
        return false;
    }



    private static boolean getEqsNums(String telNo){
        char temp = 'a';
        int count = 1;

        char[] chars = telNo.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i==1){
               temp =  chars[i];
               continue;
            }else {
                if (String.valueOf(chars[i]).equals(String.valueOf(temp))){
                    count++;
                }else {
                    count = 1;
                    temp = chars[i];
                }
                //需要优化 当count小于2并且后面剩余为5，不进行循环

            }
            System.out.print(chars[i]+" ，");
        }

        System.out.println("出现次数"+count);
        if (count>6){
            return false;
        }else {
            return true;
        }

    }




    private static boolean getWordType2(String word){
        Pattern pattern = Pattern.compile("0?(13|14|15|16|18|17|19)[0-9]{9}");
        Matcher isNum = pattern.matcher(word);
        if(isNum.matches() ){
            return true;
        }
        return false;
    }






    private static void getEndNumber(int i,int j,String c){

        System.out.println("第一个数据为="+get32BitBinString(i));
        System.out.println("第一个数据int值="+i);
        System.out.println("第二个数据为="+get32BitBinString(j));
        System.out.println("第二个数据int值="+j);
        if (c.equals("&")){
            System.out.println("与运算&");
            System.out.println("运算结果为="+get32BitBinString(i&j));
            System.out.println("int值="+(i&j));
        }else if (c.equals("|")){
            System.out.println("或运算|");
            System.out.println("运算结果为="+get32BitBinString(i|j));
            System.out.println("int值="+(i|j));
        }else if (c.equals("^")){
            System.out.println("异或运算^");
            System.out.println("运算结果为="+get32BitBinString(i^j));
            System.out.println("int值="+(i^j));
        }else if (c.equals("~")){
            System.out.println("~反码");
            System.out.println("第一个反码运算结果为="+get32BitBinString(~i));
            System.out.println("第一个反码运算int值="+(~i));
            System.out.println("第一个补码运算结果为="+get32BitBinString(~i+1));
            System.out.println("第一个补码运算int值="+(~i+1));
            System.out.println("补码+原始数据和="+(i+(~i+1)));
        }else if (c.equals("<<")){
            //左移
            System.out.println("左移运算<<");
            System.out.println("第一个左移运算结果为="+get32BitBinString(i<<j));
            System.out.println("第一个左移运算结果为="+(i<<j));
        }else if (c.equals(">>")){
            //右移
            System.out.println("右移运算>>");
            System.out.println("第一个右移运算结果为="+get32BitBinString(i>>j));
            System.out.println("第一个右移运算结果为="+(i>>j));
        }else if (c.equals(">>>")){
            //无符号右移
            System.out.println("无符号右移>>>");
            System.out.println("第一个右移运算结果为="+get32BitBinString(i>>>j));
            System.out.println("第一个右移运算结果为="+(i>>>j));
        }

    }


    /**
     * 将整型数字转换为二进制字符串，舍弃前面的0
     * @param number 整型数字
     * @return 二进制字符串
     */
    private static String getSimpleBinString(int number) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 32; i++){
            sBuilder.append(number & 1);
            number = number >>> 1;
        }
        int index = sBuilder.reverse().indexOf("1");
        return sBuilder.substring(index);
    }


    /**
     * 将整型数字转换为二进制字符串，一共32位，不舍弃前面的0
     * @param number 整型数字
     * @return 二进制字符串
     */
    private static String get32BitBinString(int number) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 32; i++){
            sBuilder.append(number & 1);
            number = number >>> 1;
        }
        return sBuilder.reverse().toString();
    }







    //1.查找在的位置
    private static int getLocLet(String s1,String s2){

        return s1.indexOf(s2);
    }

    //2.根据位置获取数组下标,需要进行算法优化（二分法查找）
    private static void getAryIndex(String s1,String s2){
        int k = s1.indexOf(s2);
        if (k==-1){
            return;
        }
        int [] arr = CharacterParser.getInstance().getArrLeg();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>k){
                System.out.println("下标位置="+i);
                getStrTag("王洗司",i);
                break;
            }
        }
    }

    //3.将下标位置进行替换
    private static void getStrTag(String s1,int i){
//        char ss = s1.charAt(i);
        if (i>s1.length()){
            return;
        }
        String s =String.valueOf(s1.charAt(i));
        System.out.println("得到的汉字="+s);

    }





    private static String getWordType22(String word){
        Pattern pattern = Pattern.compile("[a-z]*");
        Matcher isNum = pattern.matcher(word);
        if(isNum.matches() ){
            return "纯英文";
        }
        return "不是纯英文";
    }





    private static List<String> hitTarget(List<String> list, String word){
        List<String > tempList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            //如果包含字符串，添加到list中返回
            if (include(list.get(i),word)){
              tempList.add(getTaget(list.get(i),word));
            }
        }

        return tempList;

    }

    private static boolean include(String s1,String s2){
        if (s1.equals("")||s2.equals("")){
            return false;
        }
        if (s1.indexOf(s2)!=-1){
            return true;
        }
        return false;
    }

    private static String getTaget(String s1,String s2){
        StringBuffer sBuffer =new StringBuffer("<font color='#517DF7'>");
        sBuffer.append(s2);
        sBuffer.append("</font>");
        s1 = s1.replace(s2,sBuffer);
        return s1;

    }





    private static void subStringTwo(String s){
       int i = s.indexOf("元");
       if (i == -1){
           return;
       }
       String s1 = s.substring(0,i);
        System.out.println(s1);
        System.out.println(s);
        String s2 = s.substring(i,s.length());
        System.out.println(s2);


    }


    private static String getHe(String s){

//        Pattern pattern = Pattern.compile("[^x00-xff]*<em> [^x00-xff]* <//em> [^x00-xff]*");
//        Matcher isNum = pattern.matcher(s);
//        if(isNum.matches() ){
//            return "纯数字";
//        }
//        return "不是纯数字";
        String sHead = "<font color='#517DF7'>";
        String sEnd = "</font>";
        String s1 = "<em>";
        String s2 = "</em>";
       s = s.replaceAll(s1,sHead);
       s= s.replaceAll(s2,sEnd);

        return s;


    }


    public static String includeStr(String s1,String s2){
        String ss =   "<font color='#517DF7'>红颜色</font>";
        StringBuffer sBuffer =new StringBuffer("<font color='#517DF7'>");
        sBuffer.append(s2);
        sBuffer.append("</font>");

//
//        StringBuffer buffer = new StringBuffer(s1);
//        buffer.replace(4,6,"玩勇敢者");
//        System.out.println(buffer);

//        boolean flag = s1.contains(s2);
//        if (flag){
//            return "包含";
//        }
//        return "不包含";

        if (s1.indexOf(s2)!=-1){
            s1 = s1.replace(s2,sBuffer);
            return "包含"+s1;
        }
        return "不包含";
    }









    public static String interceptString(String word,int length,String add){

       if (word.isEmpty()||length<=0||length>=word.length()){
           return word;
       }
       StringBuffer stringBuffer = new StringBuffer(word.substring(0,length));
       stringBuffer.append(add);
       return stringBuffer.toString();

    }
    public static StringBuffer interceptString1(String word,int length,String add){
        StringBuffer sBuffer = new StringBuffer(word);
        if (word.isEmpty()||length<=0||length>=word.length()){
            return sBuffer;
        }
        sBuffer.setLength(length);
        sBuffer.append(add);
        return sBuffer;

    }




    private static String getWordNumOrLett(String word){
        Pattern pattern = Pattern.compile("^[0-9A-Za-z]*");
        Matcher isNum = pattern.matcher(word);
        if(isNum.matches() ){
            return "全部匹配成功";
        }
        return "匹配失败";
    }


    private static String getWordType(String word){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(word);
        if(isNum.matches() ){
            return "纯数字";
        }
        return "不是纯数字";
    }

    private static String getWordType1(String word){
        if (word.isEmpty()){
            return "字符串为空";
        }
        Pattern pattern = Pattern.compile("[0-9]");
        char c[] = word.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (String.valueOf(c[i]).equals(" ")){
                System.out.println("空格");
                continue;
            }
            Matcher isNum = pattern.matcher(String.valueOf(c[i]));
            if(!isNum.matches() ){
                return "不是纯数字";
            }

        }

        return "纯数字";
    }



    public static boolean isChineseStr(String str){
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");

        char c[] = str.toCharArray();
        for(int i=0;i<c.length;i++){
//            System.out.println(c[i]);
            String s = String.valueOf(c[i]);
            if (String.valueOf(c[i]).equals(" ")){
                System.out.println("空格");
               continue;
            }
            Matcher matcher = pattern.matcher(String.valueOf(c[i]));
            if(!matcher.matches()){
                return false;
            }
        }
        return true;
    }


    private static String getPeopleIn(String sCount){
        String s;
        if (sCount.length()>4){
         s =   sCount.substring(0,sCount.length()-4);
         s+="."+sCount.substring(sCount.length()-4,sCount.length()-3)+"万";
           return s ;
        }else {
          return sCount;
        }

    }

    private static void findclass6() {
        RMBTotial rmbTotial = new RMBTotial();
        rmbTotial.setName("apple");
        rmbTotial.setPiece(2);
        rmbTotial.setSum(10);
        System.out.println(rmbTotial);
    }

    //bjsxt ClassLoader Test
    private static void findclass5() {
        String  s = "com.wyz.test.T";
        try {
            //load class T where name = s
          Class c =  Class.forName(s);
          //创建对象o，used invoke
          Object o = c.newInstance();
            Method[] methods =   c.getMethods();
            for (Method method:methods){
                if (method.getName().equals("m")){
                    method.invoke(o);
                }
                if (method.getName().equals("m1")){
                    method.invoke(o,1,2);
                    for (Class paramType:method.getParameterTypes()){
                        System.out.println(paramType);
                    }
                }
                if (method.getName().equals("getString")){
                   Class returnType =   method.getReturnType();
                    System.out.println("class:"+returnType.getName());
                }


                System.out.println(method);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    private static void findClass4() {
        //系统核心ClassLoader，打印出来空值  bootstrap   native  load rt.jar
        System.out.println("native ClassLoder:"+String.class.getClassLoader());
//加载系统一些其它类，extesion   from jre/lib/ext
        System.out.println("system other:"+com.sun.crypto.provider.DESedeKeyFactory.class.getClassLoader().getClass().getName());
//application load user
        System.out.println("Application ClassLoader:"+Main.class.getClassLoader().getClass().getName());
        System.out.println("Application ClassLoader:"+ClassLoader.getSystemClassLoader().getClass().getName());
        //other ClassLoader

        //getParent  Obj引用指向上层Obj
        //找上一层的ClassLoader是否加载，如果上层已经加载就不会重新加载
        ClassLoader classLoader = Main.class.getClassLoader();
        while (classLoader!=null){
            System.out.println("Test getParent"+classLoader.getClass().getName());
             classLoader =  classLoader.getParent();
        }

    }


    //只会加载Dog类，并不会触发其类构造器的初始化
    private static void findClass3() {
        try {
            Class dogClass = Class.forName("com.wyz.test.Dog");
//            Class dogClass = Class.forName("com.wyz.test.Dog",false,Dog.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //通过类名加载方法
    private static void findClass2() {


        Class dogClass = Dog.class;
        Field[] fields =  dogClass.getDeclaredFields();
        for (Field field:fields){
            System.out.println(field);
        }
        Method[] methods =  dogClass.getDeclaredMethods();
        for (Method method:methods){
            System.out.println(method);
//            try {
//                method.invoke("print",String.class,int.class);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
        }

        try {
            Constructor constructor =  dogClass.getConstructor(String.class,int.class);
            constructor.newInstance("tom",10);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

//        try {
//            Dog dog = (Dog) dogClass.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }


//       try {
//           Field name = dogClass.getDeclaredField("name");
//           name.setAccessible(true);
//           Dog dog = (Dog) dogClass.newInstance();
//           name.set(dog, "Tom");
//       } catch (IllegalAccessException e) {
//           e.printStackTrace();
//       } catch (InstantiationException e) {
//           e.printStackTrace();
//       } catch (NoSuchFieldException e) {
//           e.printStackTrace();
//       }


    }

    //通过实例变量方法
    private static void findClass1() {

        // open ClassLoader    init edit congfig  add    -verbose:class
//        Dog dog = new Dog();
//        Class dogClass = dog.getClass();

    }

    private static void testArraySort() {
        int []table = {32,26,87,72,26,17};
        SortedArray.print(table);
       SortedArray.insertSort(table);

       //不能方便的访问一个下标，不能快捷删除一个方法（方便遍历输出数据）
        int[] arr = {1, 2, 3, 4, 5};
        for (int i:arr){
            System.out.println(i);
        }
    }

    private static void testFindArray(){
        int a[] = { 1, 3, 6, 8, 9, 10, 12, 18, 20, 34 };
        int ij = 12;
        ArraySearch search = new ArraySearch(a,ij);
        System.out.println(search.binarySearch());
        System.out.println(search.serach());
        //拷贝过后，引用对象指向同一个内存区域，更改B则A中也更改
        int[][] intArray = {{1,2},{1,2,3},{3,4}};
        int[][] intArrayBak = new int[3][];
        System.arraycopy
                (intArray,0,intArrayBak,0,intArray.length);
        intArrayBak[2][1] = 100;

        for(int i = 0;i<intArray.length;i++){
            for(int j =0;j<intArray[i].length;j++){
                System.out.print(intArray[i][j]+"  ");
            }
            System.out.println();
        }

        String s = "ahgeiqghqphfqpjio12i4u30t4ur90q-twklfADCBBIDHWOPFHPISHOFPH";

        ArraySearch.findAORa(s);
    }




    private static void testCrossLinkedSparseMatrix() {
        Element [] elementsa = {new Element(0,2,11),new Element(0,4,17),
                new Element(1,1,20),new Element(3,0,19),
                new Element(3,5,28),new Element(4,4,50),};
        CrossLinkedSparseMatrix smata = new CrossLinkedSparseMatrix(5,6,elementsa);
        System.out.print("A"+smata.toString());
        Element [] elementsb = {new Element(0,2,-11),new Element(0,4,-17),
                new Element(2,3,51),new Element(3,0,10),
                new Element(4,5,99)};
        CrossLinkedSparseMatrix smatb = new CrossLinkedSparseMatrix(5,6,elementsb);
        System.out.print("B"+smatb.toString());
        smata.add(smatb);
        System.out.println("C=A+B"+smata.toString());
    }

    //测试压缩稀疏矩阵
    private static void testSeqSparseMatrix() {
        Element [] elementsa = {new Element(0,2,11),new Element(0,4,17),
                new Element(1,1,20),new Element(3,0,19),
                new Element(3,5,28),new Element(4,4,50),};
        SeqSparseMatrix smata = new SeqSparseMatrix(5,6,elementsa);
        System.out.print("A"+smata.toString());
        Element [] elementsb = {new Element(0,2,-11),new Element(0,4,-17),
                new Element(2,3,51),new Element(3,0,10),
               new Element(4,5,99)};
        SeqSparseMatrix smatb = new SeqSparseMatrix(5,6,elementsb);
        System.out.print("B"+smatb.toString());

        System.out.println("C=A+B"+smata.plus(smatb).toString());

    }

    //下三角矩阵压缩存储
    private static void testDownTriangleMatrix() {
        int m1[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        DownTriangleMatrix mata = new DownTriangleMatrix(4,m1);
        System.out.println("A"+mata.toString());

        int m2[] = {1,0,1,0,0,1};
        DownTriangleMatrix matb = new DownTriangleMatrix(4,m2);
        matb.set(3,3,1);
        System.out.println("B"+matb.toString());
        mata.add(matb);
        System.out.println("A+B="+mata.toString());



    }

    //矩阵测试
    private static void testMatrix() {
        int m1[][]={{1,2,3},
                {4,5,6}};
        Matrix a=new Matrix(m1);

        int m2[][]={{1,0,0},
                {0,1,0}};
        Matrix b=new Matrix(m2);

        int m3[][]={{1,0,6},
                {0,2,0},
                {0,0,3}};
        Matrix c=new Matrix(m3);

        System.out.print("Matrix a:\n"+a.toString());
        System.out.print("Matrix b:\n"+b.toString());
        System.out.print("Matrix c:\n"+c.toString());

        Matrix d1=a.add(b);
        System.out.print("a+b=\n"+d1.toString());
    }

    //数字塔测试
    private static void testDigitTower() {
        int n=9;
        for(int i=1; i<=n; i++)
        {
            System.out.print(String.format("%"+3*(n-i+1)+"c", ' ')); //前导空格
            DigitTower.line(1, i);
            System.out.println();
        }
    }

    private static void testFibonacci() {
        for (int i = 0; i < 24; i++) {
            System.out.print(Fibonacci.fib(i)+" ");
        }
        System.out.println();
    }

    //测试优先队列
    private static void testProcess() {
        Process process[]={new Process("A",4),new Process("B",3),new Process("C",5),
                new Process("D",4),new Process("E",10),new Process("F",1)};
        PriorityQueue<Process> que = new PriorityQueue<Process>();
        System.out.print("入队进程：");
        for (int i = 0; i < process.length; i++) {
            que.enqueue(process[i]);                     //进程入队
            System.out.print(process[i]+" ");
        }

        System.out.print("\n出队进程：");
        while (!que.isEmpty()) {
            System.out.print(que.dequeue().toString() + " ");          //出队
        }
        System.out.println();

    }

    //素数环测试
    private static void testPrimeRing() {
        PrimeRing ring = new PrimeRing(20);
    }

    //线性队列
    private static void testLinkedQueue() {
        LinkedQueue<Integer> q = new LinkedQueue<Integer>();
        System.out.print("enqueue: ");
        for (int i=1; i<=5; i++)
        {
            Integer intobj = new Integer(i);
            q.enqueue(intobj);
            System.out.print(intobj+"  ");
        }
        System.out.println("\n"+q.toString());

        System.out.print("dequeue : ");
        while (!q.isEmpty())
            System.out.print(q.dequeue().toString()+"  ");
        System.out.println();
    }

    //顺序队列
    private static void testSeqQueue() {
        SeqQueue<Integer> que = new SeqQueue<Integer>(5);
        que.enqueue(new Integer(10));
        que.enqueue(new Integer(20));
        System.out.println("dequeue : "+que.dequeue().toString()+"  "+que.dequeue().toString()+"  ");
        System.out.println(que.toString());
        que.enqueue(new Integer(30));
        que.enqueue(new Integer(40));
        que.enqueue(new Integer(50));
        que.enqueue(new Integer(60));
        System.out.println(que.toString());

        que.enqueue(new Integer(70));
        System.out.println(que.toString());
    }

    //线性表栈
    private static void testLinkedStack() {
        LinkedStack<String> stack = new LinkedStack<String>();
        System.out.print("Push: ");
        char ch='a';
        for(int i=0;i<5;i++)
        {
            String str = (char)(ch+i)+"";
            stack.push(str);
            System.out.print(str+"  ");
        }
        System.out.println("\n"+stack.toString());

        System.out.print("Pop : ");
        while(!stack.isEmpty())
            System.out.print(stack.pop().toString()+"  ");
        System.out.println();
    }

    //顺序表栈
    private static void testSeqStack() {
        SeqStack<String> stack = new SeqStack<String>(20);
        System.out.print("Push: ");
        char ch='a';
        for(int i=0;i<5;i++)
        {
            String str = (char)(ch+i)+"";
            stack.push(str);
            System.out.print(str+"  ");
        }
        System.out.println("\n"+stack.toString());

        System.out.print("Pop : ");
        while(!stack.isEmpty())
            System.out.print(stack.pop().toString()+"  ");
        System.out.println();
    }


    //排序单链表
    private static void testSortedSinglyLinkedList() {
        SortedSinglyLinkedList<Integer> list1 = new SortedSinglyLinkedList<Integer>(random(9));
//        list1.insert(-1, -1);                    //覆盖单链表类的方法，抛出异常
        list1.insert(-2);                        //插入指定值结点，调用排序单链表类的方法
        System.out.println("list1: "+list1.toString());
        SortedSinglyLinkedList<Integer> list2=new SortedSinglyLinkedList<Integer>(list1);//深拷贝
        System.out.println("list2: "+list2.toString());
        list1.remove(list1.length()-1);          //删除最后结点，参数类型是int，调用单链表类的方法
        list1.remove(list1.get(0));              //删除首个结点，参数类型是Integer，调用排序单链表类的方法
        list1.remove(new Integer(50));           //删除指定值结点，可能没删除
        System.out.println("list1: "+list1.toString());
        System.out.println("list2: "+list2.toString());
    }
    public static Integer[] random(int n)              //返回产生n个随机数的数组，同例2.3
    {
        Integer[] elements = new Integer[n];
        for (int i=0; i<n; i++)
            elements[i] = (int)(Math.random()*100);   //产生随机数
        return elements;
    }


    //线性表测试
    private static void testSinglyLinkedList() {
        Integer []element = new Integer[]{11,22,33,44,55,66};
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(element);
        //System.out.println(list.isEmpty());
        System.out.println(list.toString());
//        System.out.println(list.length());
       // System.out.println(list.get(0));
        //list.set(5,((Integer)1));
//        System.out.println(list.toString());
        //list.insert(1,((Integer)22));
       // System.out.println(list.toString());

        SinglyLinkedList_reverse.reverse(list);


//        SinglyLinkedList<Integer> list=new SinglyLinkedList<Integer>();
//        System.out.println(list.toString());
//
//        list.insert(0,new Integer(20));
//        System.out.println(list.toString());
//        list.insert(100,new Integer(200));
//        System.out.println(list.toString());
//        list.append(new Integer(2000));
//        System.out.println(list.toString());
//
       // System.out.println(list.remove(6).toString());
        System.out.println(list.toString());
//        System.out.println(list.toString());
//        System.out.println(list.isEmpty());
//        list.set(0,new Integer(10));
//        System.out.println(list.toString());
//        System.out.println(list.get(1));
//        System.out.println(list.length());
//        list.removeAll();
//        System.out.println(list.isEmpty());
//        System.out.println(list.toString());
//        System.out.println(list.length());
    }

    //顺序表测试
    private static void testSeqList() {
        SeqList<Integer> list=new SeqList<Integer>(5);
        System.out.println(list.toString());

        list.insert(0,new Integer(20));
        System.out.println(list.toString());
        list.insert(100,new Integer(200));
        System.out.println(list.toString());
        list.append(new Integer(2000));
        System.out.println(list.toString());

        System.out.println(list.remove(0).toString());
        System.out.println(list.toString());
        System.out.println(list.isEmpty());
        list.set(0,new Integer(10));
        System.out.println(list.toString());
        System.out.println(list.get(1));
        System.out.println(list.length());
        list.removeAll();
        System.out.println(list.isEmpty());
        System.out.println(list.toString());
        System.out.println(list.length());
    }



}
