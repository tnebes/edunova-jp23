package model;

import jdk.jfr.Name;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tnebes
 * 3 March 2021
 */

@Entity(name = "student")
public class Student extends Identity {

    @Column(length = 50)
    private String contractNumber;

    @ManyToOne()
    private Person person;

    @ManyToMany(mappedBy = "students")
    private List<Group> groups = new ArrayList<>();

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
