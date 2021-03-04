package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author tnebes
 * 3 March 2021
 */
@Entity(name = "course")
public class Course extends Identity {

    @Column(name = "`name`", length = 50, nullable = false)
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private Integer duration;

    @Column(columnDefinition = "tinyint(1)")
    private Boolean verified;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
