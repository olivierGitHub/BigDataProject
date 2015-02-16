package excelParse;

import model.CurrencyRate;

import java.util.Objects;

/**
 * Created by alexandre on 16/02/2015.
 */
public class RateValue {
    private Double taux;
    private CurrencyRate currency;

    public RateValue(Double taux, CurrencyRate currency) {
        this.taux = taux;
        this.currency = currency;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public CurrencyRate getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyRate currency) {
        this.currency = currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taux, currency);
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
                && Objects.equals(this.currency, other.currency);
    }
}
