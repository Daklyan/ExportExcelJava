package Mission2.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CourseDao extends Dao<Course> {

    public CourseDao() {
        super("course");
    }

    public ArrayList<Course> recover() {
        String sql = String.format("SELECT * FROM %s;", this.table);

        try {
            Statement stmt = Database.getStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Course> courseArray = new ArrayList<>();
            while (rs.next()) {
                courseArray.add(new Course(
                        rs.getInt("userId"),
                        rs.getString("userName"),
                        rs.getString("driverName"),
                        rs.getString("beginning"),
                        rs.getString("destination"),
                        rs.getInt("estimatedPrice"),
                        rs.getString("createdDate")));
            }

            return courseArray;

        } catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
            return null;
        }
    }
}
