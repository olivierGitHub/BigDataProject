package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by alexandre on 12/02/2015.
 */
@Entity
public class Country {

    @OneToMany(mappedBy = "country")
    private final List<RateGroup> rateGroups = new ArrayList<RateGroup>();
    String countryName;
    @GeneratedValue
    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<RateGroup> getRateGroups() {
        return rateGroups;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rateGroups, countryName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Country other = (Country) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.rateGroups, other.rateGroups)
                && Objects.equals(this.countryName, other.countryName);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", rateGroups=" + rateGroups +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
