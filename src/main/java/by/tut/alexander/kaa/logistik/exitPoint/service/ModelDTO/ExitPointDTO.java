package by.tut.alexander.kaa.logistik.exitPoint.service.ModelDTO;

/**
 * Created by GM on 30.08.2018.
 */
public class ExitPointDTO {
    private Long id;
    private String exitPointName;
    private Long provinceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExitPointName() {
        return exitPointName;
    }

    public void setExitPointName(String exitPointName) {
        this.exitPointName = exitPointName;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }
}
