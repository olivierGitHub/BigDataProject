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
    private String currencyCode;

    /***
     * Private enum for set currencyCode with currencyName*
     */
    public int getId() { return id;}

    public String getCurrencyName() {
        return currencyName;
    }
    
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = unitySymbol.valueOf(currencyName).getSymbol();
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

    private enum unitySymbol {
        Dollar("$"),
        Euro("€"),
        Livre("£"),
        Peso("C"),
        Couronne("K"),
        Sheqel("₪"),
        Yen("¥"),
        Won("₩"),
        Zloty("z"),
        Tolar("tolars"),
        Franc("F"),
        Lire("T");

        private String symbol = "";

        //Constructeur
        unitySymbol(String name) {
            this.symbol = name;
        }

        public String toString() {
            return symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }
}