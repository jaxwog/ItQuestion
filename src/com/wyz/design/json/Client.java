package com.wyz.design.json;

import java.util.ArrayList;
import java.util.List;

/**
 * com.wyz.design.json
 * Created by jax on 2019/12/30 13:40
 * TODO:封装json，解析在android中编写
 */
public class Client {

    public static void main(String[] args) {
        News news = new News();
        news.setId(1);
        news.setTitle("新年放假通知");
        news.setContent("从今天开始放假啦。");
        news.setAuthor(createAuthor());
        news.setReader(createReaders());
        System.out.println(FastJson.toJson(news));
    }

    private static List<User> createReaders() {
        List<User> readers = new ArrayList<User>();
        User readerA = new User();
        readerA.setId(2);
        readerA.setName("Jack");
        readers.add(readerA);

        User readerB = new User();
        readerB.setId(1);
        readerB.setName("Lucy");
        readers.add(readerB);

        return readers;
    }

    private static User createAuthor() {
        User author = new User();
        author.setId(1);
        author.setName("Fancyy");
        author.setPwd("123456");
        return author;
    }
}
