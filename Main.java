import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO dao = new StudentDAO();

        int choice;

        do {

            System.out.println(
                "\n=============================="
            );

            System.out.println(
                "   STUDENT MANAGEMENT SYSTEM"
            );

            System.out.println(
                "=============================="
            );

            System.out.println(
                "1. Add Student"
            );

            System.out.println(
                "2. View All Students"
            );

            System.out.println(
                "3. Search Student"
            );

            System.out.println(
                "4. Update Student"
            );

            System.out.println(
                "5. Delete Student"
            );

            System.out.println(
                "6. Exit"
            );

            System.out.print(
                "Enter your choice: "
            );

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print(
                        "Enter ID: "
                    );
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print(
                        "Enter Name: "
                    );
                    String name = sc.nextLine();

                    System.out.print(
                        "Enter Age: "
                    );
                    int age = sc.nextInt();

                    System.out.print(
                        "Enter Marks: "
                    );
                    double marks = sc.nextDouble();

                    Student s =
                        new Student(
                            id,
                            name,
                            age,
                            marks
                        );

                    dao.addStudent(s);

                    break;


                case 2:

                    dao.viewStudents();

                    break;


                case 3:

                    System.out.print(
                        "Enter Student ID: "
                    );

                    int searchId =
                        sc.nextInt();

                    dao.searchStudent(searchId);

                    break;


                case 4:

                    System.out.print(
                        "Enter Student ID: "
                    );

                    int updateId =
                        sc.nextInt();

                    sc.nextLine();

                    System.out.print(
                        "Enter New Name: "
                    );

                    String newName =
                        sc.nextLine();

                    System.out.print(
                        "Enter New Age: "
                    );

                    int newAge =
                        sc.nextInt();

                    System.out.print(
                        "Enter New Marks: "
                    );

                    double newMarks =
                        sc.nextDouble();

                    Student updatedStudent =
                        new Student(
                            updateId,
                            newName,
                            newAge,
                            newMarks
                        );

                    dao.updateStudent(
                        updatedStudent
                    );

                    break;


                case 5:

                    System.out.print(
                        "Enter Student ID: "
                    );

                    int deleteId =
                        sc.nextInt();

                    dao.deleteStudent(deleteId);

                    break;


                case 6:

                    System.out.println(
                        "Thank you!"
                    );

                    break;


                default:

                    System.out.println(
                        "Invalid choice."
                    );
            }

        } while (choice != 6);

        sc.close();
    }
}
