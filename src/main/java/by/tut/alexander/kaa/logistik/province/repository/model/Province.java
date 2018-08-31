package by.tut.alexander.kaa.logistik.province.repository.model;

import by.tut.alexander.kaa.logistik.country.repository.model.Country;
import by.tut.alexander.kaa.logistik.exitPoint.repository.Model.ExitPoint;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
@Entity
@Table(name = "province")
public class Province implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "province_id")
    private Long id;
    @Column(name = "province_name")
    private String provinceName;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    @NotNull
    private Country country;
    @OneToMany(mappedBy = "province", fetch = FetchType.LAZY, orphanRemoval = true)
    List<ExitPoint> exitPointList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<ExitPoint> getExitPointList() {
        return exitPointList;
    }

    public void setExitPointList(List<ExitPoint> exitPointList) {
        this.exitPointList = exitPointList;
    }
}
