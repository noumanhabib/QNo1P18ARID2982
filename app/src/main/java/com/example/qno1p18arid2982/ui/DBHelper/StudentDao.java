package com.example.qno1p18arid2982.ui.DBHelper;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM students order by registration_number")
    List<Student> getAll();

    @Query("SELECT * FROM students WHERE uid IN (:studentsIds)")
    List<Student> loadAllByIds(int[] studentsIds);

    @Query("SELECT * FROM students WHERE degree = :degree and semester_number = :semester")
    List<Student> findByDegree(String degree, int semester);

    @Query("SELECT * FROM students WHERE uid = :id")
    Student find(int id);

    @Insert
    void insert(Student student);

    @Delete
    void delete(Student student);

    @Update
    void update(Student student);
}