package by.tut.alexander.kaa.logistik.province.service.ModelDTO;

import by.tut.alexander.kaa.logistik.country.service.modelDTO.CountryDTO;

/**
 * Created by GM on 30.08.2018.
 */
public class ProvinceDTO {
    private Long id;
    private String provinceName;
    private Long countryId;

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

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
