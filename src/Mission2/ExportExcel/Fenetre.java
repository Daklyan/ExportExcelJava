package Mission2.ExportExcel;

import Mission2.Dao.Course;
import Mission2.Dao.CourseDao;
import jxl.write.WriteException;
import java.io.IOException;
import java.util.ArrayList;

public class Fenetre {

    public void actionPerformed() {
        CourseDao course = new CourseDao();
        ArrayList<Course> courseArray = course.recover();

        try {
            ExcelFile.makeFile(courseArray);
        } catch (IOException e) {
            System.err.println("Error : " + e.getMessage());
        } catch (WriteException e) {
            System.err.println("Error : " + e.getMessage());
        }
    }
}