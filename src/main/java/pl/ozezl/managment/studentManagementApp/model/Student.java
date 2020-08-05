package pl.ozezl.managment.studentManagementApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String firstName;
    private String lastName;
    private Long semester;
    private String faculty;
    private String email;

    private Student() {}

    public Student(String firstName, String lastName, Long semester, String faculty, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.semester = semester;
        this.faculty = faculty;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSemester() {
        return semester;
    }

    public void setSemester(Long semester) {
        this.semester = semester;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "{" + "id:" +  this.getId() + " firstName:" + this.getFirstName() + " lastName:" + this.getLastName()
        + " semester:" + this.getSemester() + " faculty:" + this.getFaculty() + " email:" + this.getEmail() + "}";
    }
}
