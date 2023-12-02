package LIBRARY_PROGRAM;

public class Student {
    private String firstName;
    private String lastName;
    private String studentNo;

    public Student(String firstName, String lastName, String studentNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNo = studentNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

}
