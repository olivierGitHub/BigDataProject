package bigdata.analytics.rategroup;

import bigdata.analytics.country.Country;
import bigdata.analytics.rate.CurrencyRate;
import bigdata.analytics.rate.Rate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Created by Arnaud on 12/02/2015.
 */
@Entity
public class RateGroup implements Serializable{

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    Country country;
    @Id
    @GeneratedValue
    private int id;
    private RateGroupType type;
    @ManyToOne(fetch = FetchType.EAGER)
    private CurrencyRate currency;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rateGroup")
    private List<Rate> rates = new ArrayList<Rate>();

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RateGroupType getType() {
        return type;
    }

    public void setType(RateGroupType type) {
        this.type = type;
    }


    public CurrencyRate getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyRate currency) {
        this.currency = currency;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, currency, rates);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final RateGroup other = (RateGroup) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.type, other.type)
                && Objects.equals(this.currency, other.currency)
                && Objects.equals(this.rates, other.rates);
    }

    @Override
    public String toString() {
        return "RateGroup{" +
                "rates=" + rates +
                ", id=" + id +
                ", type=" + type +
                ", currency=" + currency +
                '}';
    }

    public void addRate(Rate rate) {
        rates.add(rate);
    }
}
