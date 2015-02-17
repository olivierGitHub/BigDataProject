package excelParse;

import java.util.Objects;

/**
 * Created by alexandre on 16/02/2015.
 */
public class RateValue {
    private Double taux;
    private String currencyName;

    public RateValue(Double taux, String currency) {
        this.taux = taux;
        this.currencyName = currency;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public String getCurrency() {
        return currencyName;
    }

    public void setCurrency(String currency) {
        this.currencyName = currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taux, currencyName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final RateValue other = (RateValue) obj;
        return Objects.equals(this.taux, other.taux)
                && Objects.equals(this.currencyName, other.currencyName);
    }

    @Override
    public String toString() {
        return "RateValue{" +
                "taux=" + taux +
                ", currencyName='" + currencyName + '\'' +
                '}';
    }
}
