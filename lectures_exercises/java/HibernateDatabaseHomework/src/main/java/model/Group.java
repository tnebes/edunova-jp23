package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author tnebes
 * 3 March 2021
 */
@Entity
@Table(name = "`group`")
public class Group extends Identity {

    @Column(length = 20, nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private Course course;

    @ManyToOne
    private Lecturer lecturer;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "number_of_students", nullable = false)
    private Integer numberOfStudents;

    @ManyToMany
    private List<Student> students = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Integer numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
