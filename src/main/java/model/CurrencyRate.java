package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
