package model;

import javax.persistence.*;


/**
 * Created by Arnaud on 12/02/2015.
 */
@Entity
public class Rate {

    @Id
    @GeneratedValue
    private int id;
    private RateType type;
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    private double value;
    private String year;
    @ManyToOne(fetch = FetchType.EAGER)
    private CurrencyRate currency;
}
