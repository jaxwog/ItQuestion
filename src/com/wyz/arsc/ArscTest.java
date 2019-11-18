package com.wyz.arsc;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
public class ArscTest {

    public static void Test(){
        ArscTest arscTest = new ArscTest();
        try {
//			arscTest.readInputStream("C:/Users/luoding/workspace_test/arscTest/input.apk");
//			arscTest.readInputStream("C:/Users/luoding/workspace_test/arscTest/Lsn10SearchView.apk");
//
//            arscTest.readInputStream( "/Users/wangyongzheng/Movies/com.taikang.tkim.apk");
            arscTest.readInputStream( "/Users/wangyongzheng/Movies/dn_jobschduler.apk");
//            arscTest.readInputStream("C:/Users/luoding/workspace_test/arscTest/dn_jobschduler.apk");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @SuppressWarnings("resource")
    public void readInputStream(String path) throws IOException{

        System.out.println("=========================Resouce Table头部=================");
        //读取zip文件，直接取到里面的文件
        ZipFile zipFile = new ZipFile(path);
        InputStream inputStream = zipFile.getInputStream(new ZipEntry(""+"resources.arsc"));
        LEDataInputStream leDataInputStream = new LEDataInputStream(inputStream);
        //Resource Table 头 ，读取两个字节Short，RES_TABLE_TYPE
        short type = leDataInputStream.readShort();
        //跳过两个字节(头大小)，一个字节为8位
        leDataInputStream.skipBytes(2);
        //文件大小，4字节，int类型
        leDataInputStream.readInt();
        //package数，int类型表示
        int packageNum = leDataInputStream.readInt();
        System.out.println("num of package:"+packageNum);
        System.out.println("=========================Resouce Table结尾=================");

        System.out.println("=========================String Pool块开头=================");
        //StringPool块，RES_STRING_POOL_TYPE和头大小各两个字节，直接读取了int值
        int got =leDataInputStream.readInt();
        //块大小
        int chunkSize = leDataInputStream.readInt();
        System.out.println("String Pool块大小:"+chunkSize);
        //字符串数量
        int stringCount = leDataInputStream.readInt();
        System.out.println("String Pool字符串数量:"+stringCount);
        //style数量
        int styleCount = leDataInputStream.readInt();
        System.out.println("String Pool Style数量:"+styleCount);
        //标记
        int flags = leDataInputStream.readInt();
        //字符串起始位置
        int stringsOffset = leDataInputStream.readInt();
        //style起始位置，用来记录的是存储字符串二进制的起始位置
        int stylesOffset = leDataInputStream.readInt();
        //字符串偏移数组大小为字符串数量的长度
        int[] array = new int[stringCount];
        for (int i = 0; i < stringCount; ++i){
            //每一个表示字符串位置对应的偏移量
            array[i] = leDataInputStream.readInt();
        }
        if (styleCount != 0) {
            for (int i = 0; i < styleCount; ++i)
                //每一个表示style位置对应的偏移量
                array[i] = leDataInputStream.readInt();
        }
        //字符串长度，如果stylesOffset为0表示size中剩下的都为String类型的字符串，
        // 如果不为0表示从stylesOffset头部到stringsOffset的头部中间位置为字符串大小
        int size = ((stylesOffset == 0) ? chunkSize : stylesOffset) - stringsOffset;
        byte[] m_strings = new byte[size];
        StringBuffer ss = new StringBuffer();
        //读取字符串长度的byte类型数据,然后拼接成String的字符串
        leDataInputStream.readFully(m_strings);
        for(int i = 0;i<m_strings.length;i++){
            //(通过打开resources.arsc看到一些乱码 猜得出字符都是ASCII码)
            char c = (char) m_strings[i];
            ss.append(c);
        }
        System.out.println(ss.toString());

        if (stylesOffset != 0) {
            size = chunkSize - stylesOffset;
            if (size % 4 != 0)
                throw new IOException("Style data size is not multiple of 4 (" + size + ").");

            for (int i = 0; i < size / 4; ++i)
                leDataInputStream.readInt();
        }
        System.out.println("=========================String Pool块结尾=================");

        System.out.println("=========================Package Hearder开头=================");
        //nextChunk，RES_TABLE_PACKAGE_TYPE 2字节
        leDataInputStream.readShort();
        //头大小，2字节
        leDataInputStream.skipBytes(2);
        //块大小
        leDataInputStream.readInt();
        //package id
        int id = (byte) leDataInputStream.readInt();
        System.out.println("package id："+id);
        StringBuilder sb = new StringBuilder(16);
        int length = 256;
        while (length-- != 0) {
            short ch = leDataInputStream.readShort();
            if (ch == 0)
                break;

            sb.append((char)ch);
        }
        System.out.println("pacakgeName:"+sb.toString());

    }


}
