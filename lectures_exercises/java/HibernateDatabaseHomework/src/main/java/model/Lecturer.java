package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author tnebes
 * 3 March 2021
 */

@Entity(name = "lecturer")
public class Lecturer extends Identity {

    @ManyToOne
    private Person person;

    @Column(length = 50)
    private String iban;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
