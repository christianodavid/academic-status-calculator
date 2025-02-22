package com.academicstatuscalculator.controller;

import com.academicstatuscalculator.model.Student;
import com.academicstatuscalculator.service.GoogleSheetsService;
import com.academicstatuscalculator.view.StudentView;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.academicstatuscalculator.util.Constants.*;

public class StudentController {
    private final StudentView view;

    public StudentController(StudentView view) {
        this.view = view;
    }

    public void processStudentData() throws IOException, GeneralSecurityException {
        Sheets sheets = GoogleSheetsService.getSheetService();
        ValueRange response = sheets.spreadsheets().values().get(SPREADSHEET_ID, RANGE).execute();

        List<List<Object>> values = response.getValues();
        if(values == null || values.isEmpty()) {
            view.printNoDataFound();
            return;
        }

        List<Object> headerRow = values.get(2);
        view.printHeader(headerRow);

        for(int i = 3; i < values.size(); i++) {
            Student student = createStudentFromRow(values.get(i));
            calcStudentResults(student);
            updateSpreadsheet(sheets, student, i);
            view.printStudentData(student);
        }
    }

    private Student createStudentFromRow(List<Object> row) {
        return new Student(
                row.get(0).toString(),
                row.get(1).toString(),
                Integer.parseInt(row.get(2).toString()),
                Double.parseDouble(row.get(3).toString()),
                Double.parseDouble(row.get(4).toString()),
                Double.parseDouble(row.get(5).toString())
        );
    }

    private void calcStudentResults(Student student) {
        double average = ((student.getP1() + student.getP2() + student.getP3()) / 3.0) / 10;
        student.setAverage(average);

        int absences = student.getAbsences();
        String result = calculateResult(average, absences);
        student.setResult(result);

        double finalGradeForApproval = result.equals("Exame Final") ? (10 - average) : 0;
        double roundedFinalGradeApproval = Math.ceil(finalGradeForApproval);
        student.setFinalGradeForApproval(roundedFinalGradeApproval);
    }

    private String calculateResult(double average, int absences) {
        if(absences > TOTAL_CLASSES * 0.25) {
            return "Reprovado por Falta";
        } else if(average < 5) {
            return "Reprovado por Nota";
        } else if(average < 7) {
            return "Exame Final";
        } else {
            return "Aprovado";
        }
    }

    private void updateSpreadsheet(Sheets sheets, Student student, int rowIndex) throws IOException {
        List<Object> rowData = Arrays.asList(
                student.getId(),
                student.getName(),
                student.getAbsences(),
                student.getP1(),
                student.getP2(),
                student.getP3(),
                student.getResult(),
                student.getFinalGradeForApproval()
        );

        ValueRange body = new ValueRange().setValues(Collections.singletonList(rowData));

        sheets.spreadsheets()
                .values()
                .update(SPREADSHEET_ID, "engenharia_de_software!A" + (rowIndex + 1) + ":H" + (rowIndex + 1), body)
                .setValueInputOption("USER_ENTERED")
                .execute();
    }
}
