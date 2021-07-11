package com.example.qno1p18arid2982.ui.DBHelper;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "students")
public class Student {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "registration_number")
    public String regNumber;

    @ColumnInfo(name = "semester_number")
    public int semester;

    @ColumnInfo(name = "degree")
    public String degree;
}

