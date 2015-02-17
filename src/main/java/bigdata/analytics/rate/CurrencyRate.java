package bigdata.analytics.rate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Created by Arnaud on 12/02/2015.
 */
@Entity
public class CurrencyRate {



    @Id
    @GeneratedValue
    private int id;
    private String currencyName;
    private CurrencyCode currencyCode;

    public CurrencyRate() {
    }

    public CurrencyRate(String currencyName, CurrencyCode currencyCode) {
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
    }

    public int getId() { return id;}

    public String getCurrencyName() {
        return currencyName;
    }
    
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = CurrencyCode.valueOf(currencyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currencyName, currencyCode);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final CurrencyRate other = (CurrencyRate) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.currencyName, other.currencyName)
                && Objects.equals(this.currencyCode, other.currencyCode);
    }
}