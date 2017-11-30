package com.maoqis.test.room.db;

import com.maoqis.test.room.db.entity.Book;
import com.maoqis.test.room.db.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjmaoqisheng on 2017/11/30.
 */

public class DataGenerator {
    public static List<User> generatorUser(){
        List<User> users = new ArrayList<>();
        User user = new User(1,"x","reactive",15,null,null);
        users.add(user);
        user = new User(2,"Shi","YiMing",10,null,null);
        users.add(user);

        return users;
    }
    public static List<Book> generatorBooks() {
        List<Book> books = new ArrayList<>();
        Book book = new Book(1,"RxJava",1);
        books.add(book);
        book = new Book(2,"Android Application Testing and Debugging",2);
        books.add(book);
        book = new Book(3,"RxKotlin",1);
        books.add(book);
        return books;
    }
}
