package com.academicstatuscalculator;

import com.academicstatuscalculator.controller.StudentController;
import com.academicstatuscalculator.view.StudentView;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class AcademicStatusCalculatorApplication {
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        StudentView view = new StudentView();
        StudentController controller = new StudentController(view);

        controller.processStudentData();
    }
}
