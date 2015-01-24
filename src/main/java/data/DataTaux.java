package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Données issues du fichier du prof Olifirenkoff "OCDE Taux d'interet et taux de change" onglet "TauxChangeEffectifs"
 */
@Entity
public class DataTaux {

    @Id
    @GeneratedValue
    private int id;
    private String country;
    private String year2011;
    private String year2012;
    private String year2013;
    private String year2014;

    public DataTaux(){
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear2011() {
        return year2011;
    }
    public void setYear2011(String year2011) {
        this.year2011 = year2011;
    }

    public String getYear2012() {
        return year2012;
    }
    public void setYear2012(String year2012) {
        this.year2012 = year2012;
    }

    public String getYear2013() {
        return year2013;
    }
    public void setYear2013(String year2013) {
        this.year2013 = year2013;
    }

    public String getYear2014() {
        return year2014;
    }
    public void setYear2014(String year2014) {
        this.year2014 = year2014;
    }
}
