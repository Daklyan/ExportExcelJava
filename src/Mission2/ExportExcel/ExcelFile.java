package Mission2.ExportExcel;

import Mission2.Dao.Course;

import java.util.ArrayList;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;

import javax.swing.*;

public class ExcelFile {
    public static void makeFile(ArrayList<Course> courseArray) throws IOException, WriteException {

        WritableWorkbook workbook = null;
        WritableSheet sheet = null;
        String day, month, year;

        JOptionPane jop1, jop2;

        try {
            // Creation of the excel file
            workbook = Workbook.createWorkbook(new File("Exportbdd.xls"));
            // Creation of the notebook
            sheet = workbook.createSheet("Premier classeur", 0);
        } catch (IOException e) {
            System.err.println("Error : " + e.getMessage());
//            jop2 = new JOptionPane();
//            jop2.showMessageDialog(null, "File creation unsuccessful", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Look for the database in Course et insert them in the cells of the notebook
        for (int i = 0; i < courseArray.size(); i++) {
            try {
                Course temp = courseArray.get(i);
                sheet.addCell(new Number(0, i, temp.getUserId()));
                sheet.setColumnView(0, 10);
                sheet.addCell(new Label(1, i, temp.getUserName()));
                sheet.setColumnView(1, 18);
                sheet.addCell(new Label(2, i, temp.getDriverName()));
                sheet.setColumnView(2, 18);
                sheet.addCell(new Label(3, i, temp.getBeginning()));
                sheet.setColumnView(3, 50);
                temp.createdDate = temp.createdDate.substring(0, 10);
                day = temp.createdDate.substring(9, 10);
                month = temp.createdDate.substring(6, 7);
                year = temp.createdDate.substring(0, 4);
                temp.createdDate = day.concat("/").concat(month).concat("/").concat(year);
                sheet.addCell(new Label(4, i, temp.getDestination()));
                sheet.setColumnView(4, 18);
                sheet.addCell(new Number(5, i, temp.getEstimatedPrice()));
                sheet.setColumnView(5, 20);
                sheet.addCell(new Label(6, i, temp.createdDate));
                sheet.setColumnView(6, 20);

            } catch (WriteException e) {
                System.err.println("Error : " + e.getMessage());
//                jop2 = new JOptionPane();
//                jop2.showMessageDialog(null, "Data insertion in the file unsuccessful", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException e) {
                System.err.println("Error : " + e.getMessage());
//                jop2 = new JOptionPane();
//                jop2.showMessageDialog(null, "Memory problem", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Enregistrement du fichier Excel
        try {
            workbook.write();
            workbook.close();

            System.out.println("Course successfully exported");

//            jop1 = new JOptionPane();
//            jop1.showMessageDialog(null, "Course successfully exported", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (WriteException e) {
            System.err.println("Error : " + e.getMessage());
//            jop2 = new JOptionPane();
//            jop2.showMessageDialog(null, "File saving problem", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
