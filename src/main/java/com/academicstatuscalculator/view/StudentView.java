package com.academicstatuscalculator.view;

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
}
