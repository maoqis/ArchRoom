package com.maoqis.test.room.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by bjmaoqisheng on 2017/11/29.
 */
@Entity(foreignKeys = @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "user_id"))
public class Book {
    @PrimaryKey
    public long bookId;
    public String title;
    @ColumnInfo(name = "user_id")
    public long userId;
}
