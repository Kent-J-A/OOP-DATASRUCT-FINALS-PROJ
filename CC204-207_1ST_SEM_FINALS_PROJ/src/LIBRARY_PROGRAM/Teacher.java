package LIBRARY_PROGRAM;

public class Teacher {
    private String firstName;
    private String lastName;
    private String facultyID;

    public Teacher(String firstName, String lastName, String facultyID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.facultyID = facultyID;
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

    public String getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(String facultyID) {
        this.facultyID = facultyID;
    }

}
