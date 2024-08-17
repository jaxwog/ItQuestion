package com.wyz.test;

import java.io.*;

/**
 * 查找文件夹下代码的空白行、注释行、有效行数
 */
public class CodeCounter {


    static long normalLines = 0;
    static long commentLines = 0;
    static long whiteLines = 0;

    //  "/Users/wangyongzheng/IDEA/ItQuestion/src/com/wyz/array"

    public static void findFile(String fileName) {
//       File f = new File("D:\\share\\JavaProjects\\TankWar1.9.11\\src");
        File f = new File(fileName);
        File[] codeFiles = f.listFiles();
        for (File child : codeFiles) {
            if (child.getName().matches(".*\\.java$")) {
                System.out.println("文件名字为" + child.getName());
                parse(child);
            }
        }

        System.out.println("normalLines:" + normalLines);
        System.out.println("commentLines:" + commentLines);
        System.out.println("whiteLines:" + whiteLines);
    }


    private static void parse(File f) {
        BufferedReader br = null;
        boolean comment = false;
        try {
            br = new BufferedReader(new FileReader(f));
            String line = "";
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.matches("^[\\s&&[^\\n]]*$")) {
                    whiteLines++;
                } else if (line.startsWith("/*") && !line.endsWith("*/")) {
                    commentLines++;
                    comment = true;
                } else if (line.startsWith("/*") && line.endsWith("*/")) {
                    commentLines++;
                } else if (true == comment) {
                    commentLines++;
                    if (line.endsWith("*/")) {
                        comment = false;
                    }
                } else if (line.startsWith("//")) {
                    commentLines++;
                } else {
                    normalLines++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    br = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
