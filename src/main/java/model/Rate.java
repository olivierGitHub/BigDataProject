package model;

import javax.persistence.*;

/**
 * Created by Arnaud on 13/02/2015.
 */
@Entity
public class Rate {

    @Id
    @GeneratedValue
    private int id;
    private String year;
    private Integer value;
    @ManyToOne(fetch = FetchType.LAZY)
    private RateGroup rateGroup;
}
