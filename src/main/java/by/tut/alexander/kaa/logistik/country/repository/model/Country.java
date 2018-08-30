package by.tut.alexander.kaa.logistik.country.repository.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by GM on 30.08.2018.
 */

@Entity
@Table(name = "Country")
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "countryName")
    private String CountryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }
}
