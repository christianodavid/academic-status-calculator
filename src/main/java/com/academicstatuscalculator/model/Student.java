package com.academicstatuscalculator.model;

public class Student {
    private final String id;
    private final String name;
    private final int absences;
    private final double p1;
    private final double p2;
    private final double p3;
    private double average;
    private String result;
    private double finalGradeForApproval;

    public Student(String id, String name, int absences, double p1, double p2, double p3) {
        this.id = id;
        this.name = name;
        this.absences = absences;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAbsences() {
        return absences;
    }

    public double getP1() {
        return p1;
    }

    public double getP2() {
        return p2;
    }

    public double getP3() {
        return p3;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public double getFinalGradeForApproval() {
        return finalGradeForApproval;
    }

    public void setFinalGradeForApproval(double finalGradeForApproval) {
        this.finalGradeForApproval = finalGradeForApproval;
    }
}
