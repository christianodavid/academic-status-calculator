package com.academicstatuscalculator.controller;

import com.academicstatuscalculator.service.GoogleSheetsService;
import com.academicstatuscalculator.view.StudentView;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
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
    }
}
