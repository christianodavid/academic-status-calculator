package com.academicstatuscalculator.view;

import com.academicstatuscalculator.model.Student;

import java.util.List;

public class StudentView {
    public void printNoDataFound() {
        System.out.println("No data found.");
    }

    public void printHeader(List<Object> headerRow) {
        System.out.printf("%n|%-10s|%-14s|%-8s|%-5s|%-5s|%-5s|%-5s|%-25s|%-25s|%n",
                headerRow.get(0), headerRow.get(1), headerRow.get(2), headerRow.get(3),
                headerRow.get(4), headerRow.get(5), "Media", headerRow.get(6), headerRow.get(7));
    }

    public void printStudentData(Student student) {
        System.out.printf("|%-10s|%-14s|%-8s|%-5s|%-5s|%-5s|%-5s|%-25s|%-25s|%n",
                student.getId(),
                student.getName(),
                student.getAbsences(),
                student.getP1(),
                student.getP2(),
                student.getP3(),
                String.format("%.2f", student.getAverage()),
                student.getResult(),
                student.getFinalGradeForApproval());
    }
}
