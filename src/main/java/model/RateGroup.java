package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Arnaud on 12/02/2015.
 */
@Entity
public class RateGroup {

    @OneToMany(mappedBy = "rateGroup")
    List<Rate> rates = new ArrayList<Rate>();
    @Id
    @GeneratedValue
    private int id;
    private RateGroupType type;
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    @ManyToOne(fetch = FetchType.EAGER)
    private CurrencyRate currency;

}
