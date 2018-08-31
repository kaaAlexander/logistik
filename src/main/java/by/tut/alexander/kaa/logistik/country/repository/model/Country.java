package by.tut.alexander.kaa.logistik.country.repository.model;

import by.tut.alexander.kaa.logistik.province.repository.model.Province;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */

@Entity
@Table(name = "country")
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "country_id")
    private Long id;
    @Column(name = "country_name")
    private String CountryName;
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Province> provinceList;

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

    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }
}
