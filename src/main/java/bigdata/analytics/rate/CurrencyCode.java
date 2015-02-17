package bigdata.analytics.rate;

/**
 * Created by Arnaud on 17/02/2015.
 */
public enum CurrencyCode {

    Dollar("USD"),
    Euro("EUR"),
    Livre("GBP"),
    Peso("C"),
    Couronne("K"),
    Sheqel("₪"),
    Yen("¥"),
    Won("₩"),
    Zloty("z"),
    Tolar("tolars"),
    Franc("F"),
    Lire("T");

    private String code = "";

    //Constructeur
    CurrencyCode(String name) {
        this.code = name;
    }

    public String toString() {
        return code;
    }

    public String getCode() {
        return code;
    }
}
