package com.maoqis.test.room.db.entity;

import android.arch.persistence.room.ColumnInfo;

class Address {
        public String street;
        public String state;
        public String city;

        @ColumnInfo(name = "post_code")
        public int postCode;
    }