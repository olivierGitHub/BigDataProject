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

    //    SHORT_TERM,LONG_TERM,NOMINATIVE,EFFECTIVE
    @OneToMany(mappedBy = "country")
    private final List<Rate> shortTermRates = new ArrayList<Rate>();
    String countryName;
    @GeneratedValue
    @Id
    private Integer id;

    @Override
    public int hashCode() {
        return Objects.hash(id, countryName, shortTermRates);
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
                && Objects.equals(this.countryName, other.countryName)
                && Objects.equals(this.shortTermRates, other.shortTermRates);
    }
}
