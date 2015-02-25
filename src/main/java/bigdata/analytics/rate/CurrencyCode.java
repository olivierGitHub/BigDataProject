package bigdata.analytics.rate;

/**
 * Created by Arnaud on 17/02/2015.
 */
public enum CurrencyCode {

    Dollar("USD"),
    Euro("EUR"),
    Livre("GBP"),
    Peso("PES"),
    Couronne("COU"),
    Sheqel("SHE"),
    Yen("YEN"),
    Won("WON"),
    Zloty("ZLT"),
    Tolar("TOL"),
    Franc("F"),
    Lire("L"),
    Forint("For");

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
