package com.academicstatuscalculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    @Test
    public void testStudentGettersAndSetters() {
        Student student = new Student("30", "Fernanda Lima", 2, 85, 88, 92);

        student.setAverage(8.8);
        student.setResult("Aprovado");
        student.setFinalGradeForApproval(0);

        assertEquals(8.8, student.getAverage());
        assertEquals("Aprovado", student.getResult());
        assertEquals(0.0, student.getFinalGradeForApproval());
    }

    @Test
    public void testStudentResultCalc() {
        Student student = new Student("31", "Gabriela da Silva", 8, 65, 70, 75);

        student.setAverage(7.0);
        student.setResult("Aprovado");

        assertEquals(7.0, student.getAverage());
        assertEquals("Aprovado", student.getResult());
    }
}
