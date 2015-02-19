package bigdata.analytics.rate;

import bigdata.analytics.rategroup.RateGroup;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Rate {

    @Id
    @GeneratedValue
    private int id;
    private String year;
    private Double value;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private RateGroup rateGroup;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public RateGroup getRateGroup() {
        return rateGroup;
    }

    public void setRateGroup(RateGroup rateGroup) {
        this.rateGroup = rateGroup;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Rate other = (Rate) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.year, other.year)
                && Objects.equals(this.value, other.value);
    }
}
