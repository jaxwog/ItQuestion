package com.wyz.j2ee;

import java.io.*;
import java.util.Date;

//stream是字节流（8bit，8位01010101数据），reader是字符流（2字节）
//buffer缓冲区，字节数组存储
//flush把缓冲区的数据写入目标文件，然后在close（直接切断管道）
public class StreamAndRead {


    //字节流读取文件，中文显示乱码（中文占用两个字节，需要采用字符流读取）
    public static void testFileInputStream() {
        FileInputStream inputStream = null;
        int b = 0;
        long num = 0;
        try {
            inputStream = new FileInputStream("/Users/wangyongzheng/Downloads/TestFileInputStream.java");
            while ((b = inputStream.read()) != -1) {
                System.out.print((char) b);
                num++;
            }

            inputStream.close();
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("没有发现文件");
            System.exit(-1);
            e.printStackTrace();
        } catch (IOException e) {
            System.exit(-1);
            e.printStackTrace();
        }

        System.out.println("输出字节为：" + num);

    }


    public static void testFileOutputStream() {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        int b = 0;

        try {
            inputStream = new FileInputStream("/Users/wangyongzheng/Downloads/TestFileInputStream.java");
            //如果该文件不存在，则会创建TestFile.java文件，不能创建目录
            outputStream = new FileOutputStream("/Users/wangyongzheng/Downloads/TestFile.java");
            while ((b = inputStream.read()) != -1) {
                outputStream.write(b);
            }
            System.out.println("文件复制成功");
        } catch (FileNotFoundException e) {
            System.out.println("没有发现文件");
            System.exit(-1);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件读取错误");
            System.exit(-1);
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void testFileReader() {
        FileReader inputStream = null;
        int b = 0;
        long num = 0;
        try {
            inputStream = new FileReader("/Users/wangyongzheng/Downloads/TestFileInputStream.java");
            while ((b = inputStream.read()) != -1) {
                System.out.print((char) b);
                num++;
            }

            inputStream.close();
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("没有发现文件");
            System.exit(-1);
            e.printStackTrace();
        } catch (IOException e) {
            System.exit(-1);
            e.printStackTrace();
        }

        System.out.println("输出字节为：" + num);

    }

    public static void testBufferedWriter() {
        FileWriter fileWriter = null;
        FileReader fileReader = null;

        try {
            fileWriter = new FileWriter("/Users/wangyongzheng/IDEA/ItQuestion/dir1/dir2/myFile.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (int i = 0; i < 100; i++) {
                String s = String.valueOf(Math.random());
                writer.write(s);
                writer.newLine();
            }
            writer.flush();
            writer.close();

        } catch (IOException e) {
            System.out.println("文件输出错误");
            e.printStackTrace();
        }

        try {
            fileReader = new FileReader("/Users/wangyongzheng/IDEA/ItQuestion/dir1/dir2/myFile.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String s = null;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);//s输入到内存分配的区域中
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void testOutStreamWriter() {
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream("/Users/wangyongzheng/IDEA/ItQuestion/dir1/dir2/myFile.txt");
            OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
            streamWriter.write("我是谁呢？欢迎来到中兴体验社区");
            System.out.println(streamWriter.getEncoding());
            streamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //true 表示在文件后面直接添加
            stream = new FileOutputStream("/Users/wangyongzheng/IDEA/ItQuestion/dir1/dir2/myFile.txt", true);
            OutputStreamWriter streamWriter = new OutputStreamWriter(stream, "UTF8");//指定字符编码
            streamWriter.write("\n我是谁呢？欢迎来到中兴体验社区");

            System.out.println(streamWriter.getEncoding());
            streamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //阻塞方式输入键盘事件
    public static void testInStreamReader() {
        InputStreamReader reader = null;
        reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String s = null;
        try {
            s = bufferedReader.readLine();
            while (s != null) {
                if (s.equalsIgnoreCase("exit")) break;
                System.out.println(s.toUpperCase());
                s = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testDataStream() {
        //输出字节数组,在内存中保留
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            //直接输出8字节，1字节数据
            dos.writeDouble(Math.random());
            dos.writeBoolean(true);
            //从内存中读取字节数组，先进先出
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            System.out.println(bais.available());//一共写了多少字节
            DataInputStream dis = new DataInputStream(bais);
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            dis.close();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void testPrintStream() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            FileWriter fileWriter = new FileWriter("/Users/wangyongzheng/IDEA/ItQuestion/dir1/dir2/myFile.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            while ((s = br.readLine()) != null) {
                if (s.equalsIgnoreCase("exit")) break;
                System.out.println(s);
                printWriter.println("------------------------");
                printWriter.println(s);
                printWriter.flush();
            }
            printWriter.println("=======" + new Date() + "=======");
            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testObjectIO() {
        try {
            T t = new T();
            t.k = 100;
            FileOutputStream fos = new FileOutputStream("/Users/wangyongzheng/IDEA/ItQuestion/dir1/dir2/myFile.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("/Users/wangyongzheng/IDEA/ItQuestion/dir1/dir2/myFile.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            T t1 = (T) ois.readObject();
            System.out.println(t1.i + " ," + t1.j + " ," + t1.d + " ," + t1.k);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}

//标记型接口，没有具体方法
class T implements Serializable {
    int i = 10;
    int j = 2;
    double d = 2.3;
    transient int k = 9;//序列化时候忽略内容
}
