package com.maoqis.test.room.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by bjmaoqisheng on 2017/11/29.
 */
@Entity(foreignKeys = @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "user_id"),tableName = "book",indices = {@Index("book_id"),@Index("user_id")})
public class Book {
    @PrimaryKey
    @ColumnInfo(name = "book_id")
    public long bookId;
    public String title;
    @ColumnInfo(name = "user_id")
    public long userId;
    @Ignore
    public Book() {
    }

    public Book(long bookId, String title, long userId) {
        this.bookId = bookId;
        this.title = title;
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                '}';
    }
}
