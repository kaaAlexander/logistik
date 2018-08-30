package by.tut.alexander.kaa.logistik.exitPoint.repository.Model;

import by.tut.alexander.kaa.logistik.country.repository.model.Country;
import by.tut.alexander.kaa.logistik.province.repository.model.Province;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by GM on 30.08.2018.
 */
@Entity
@Table(name = "exit_point")
public class ExitPoint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "exit_point_name")
    private String ExitPointName;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    @NotNull
    private Province province;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExitPointName() {
        return ExitPointName;
    }

    public void setExitPointName(String exitPointName) {
        ExitPointName = exitPointName;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
