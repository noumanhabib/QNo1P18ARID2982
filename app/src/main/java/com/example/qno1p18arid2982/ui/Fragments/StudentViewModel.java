package com.example.qno1p18arid2982.ui.Fragments;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.qno1p18arid2982.ui.DBHelper.Student;

import java.util.List;

public class StudentViewModel extends ViewModel {
    private final MutableLiveData<List<Student>> students = new MutableLiveData<>();
    private final MutableLiveData<Integer> selectedClassPos = new MutableLiveData<>();
    private final MutableLiveData<Integer> totalPresent = new MutableLiveData<>();
    private final MutableLiveData<Integer> totalAbsent = new MutableLiveData<>();

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void addStudent(Student std){
        List<Student> myList = students.getValue();
        if(myList == null){
            myList = List.of();
        }
        myList.add(std);
        students.setValue(myList);
    }
    public List<Student> getStudentList(){
        return students.getValue();
    }

    public int totalStudents(){
        return students.getValue().size();
    }

    public void addAll(List<Student> myList){
        students.setValue(myList);
    }
    public void setSelectedClassPos(int pos){
        selectedClassPos.setValue(pos);
    }
    public int getSelectedClassPos(){
        return selectedClassPos.getValue();
    }
    public void setTotalPresent(int pos){
        totalPresent.setValue(pos);
    }
    public int getTotalPresent(){
        return totalPresent.getValue();
    }
    public void setTotalAbsent(int pos){
        totalAbsent.setValue(pos);
    }
    public int getTotalAbsent(){
        return totalAbsent.getValue();
    }

}
