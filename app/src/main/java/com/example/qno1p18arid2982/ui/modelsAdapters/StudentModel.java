package com.example.qno1p18arid2982.ui.modelsAdapters;


public class StudentModel {
    public int uid;
    public String name;
    public String regNumber;
    public int semester;
    public String degree;

    public StudentModel(int uid, String name, String regNumber, int semester, String degree) {
        this.uid = uid;
        this.name = name;
        this.regNumber = regNumber;
        this.semester = semester;
        this.degree = degree;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
