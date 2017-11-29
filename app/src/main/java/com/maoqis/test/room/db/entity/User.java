package com.maoqis.test.room.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

/**
 * Created by bjmaoqisheng on 2017/11/29.
 */
@Entity(tableName = "user", indices = {@Index(value = {"first_name", "last_name"}, unique = true)})
public class User {
    @PrimaryKey
    public long id;
    @ColumnInfo(name = "first_name")
    public String firstName;
    @ColumnInfo(name = "last_name")
    public String lastName;

    public int age;
    @Ignore
    public Bitmap picture;

    @Embedded
    public Address address;



}
