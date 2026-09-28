import java.sql.*;

public class StudentDAO {

    public void addStudent(Student s) {

        String sql =
            "INSERT INTO student " +
            "(id, name, age, marks) " +
            "VALUES (?, ?, ?, ?)";

        try (
            Connection con =
                DatabaseConnection.getConnection();

            PreparedStatement ps =
                con.prepareStatement(sql)
        ) {

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setDouble(4, s.getMarks());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(
                    "Student added successfully."
                );
            }

        } catch (SQLException e) {
            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }


    public void viewStudents() {

        String sql = "SELECT * FROM student";

        try (
            Connection con =
                DatabaseConnection.getConnection();

            Statement stmt =
                con.createStatement();

            ResultSet rs =
                stmt.executeQuery(sql)
        ) {

            System.out.println(
                "\nID\tName\tAge\tMarks"
            );

            System.out.println(
                "--------------------------------"
            );

            while (rs.next()) {

                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getInt("age") + "\t" +
                    rs.getDouble("marks")
                );
            }

        } catch (SQLException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }


    public void searchStudent(int id) {

        String sql =
            "SELECT * FROM student WHERE id = ?";

        try (
            Connection con =
                DatabaseConnection.getConnection();

            PreparedStatement ps =
                con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ResultSet rs =
                ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                    "\nStudent Found"
                );

                System.out.println(
                    "ID: " +
                    rs.getInt("id")
                );

                System.out.println(
                    "Name: " +
                    rs.getString("name")
                );

                System.out.println(
                    "Age: " +
                    rs.getInt("age")
                );

                System.out.println(
                    "Marks: " +
                    rs.getDouble("marks")
                );

            } else {

                System.out.println(
                    "Student not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }


    public void updateStudent(Student s) {

        String sql =
            "UPDATE student " +
            "SET name = ?, age = ?, marks = ? " +
            "WHERE id = ?";

        try (
            Connection con =
                DatabaseConnection.getConnection();

            PreparedStatement ps =
                con.prepareStatement(sql)
        ) {

            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setDouble(3, s.getMarks());
            ps.setInt(4, s.getId());

            int rows =
                ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                    "Student updated successfully."
                );

            } else {

                System.out.println(
                    "Student ID not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }


    public void deleteStudent(int id) {

        String sql =
            "DELETE FROM student WHERE id = ?";

        try (
            Connection con =
                DatabaseConnection.getConnection();

            PreparedStatement ps =
                con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int rows =
                ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                    "Student deleted successfully."
                );

            } else {

                System.out.println(
                    "Student ID not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }
}
