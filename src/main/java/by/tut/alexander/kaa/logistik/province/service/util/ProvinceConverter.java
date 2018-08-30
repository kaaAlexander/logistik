package by.tut.alexander.kaa.logistik.province.service.util;

import by.tut.alexander.kaa.logistik.country.service.util.CountryConverter;
import by.tut.alexander.kaa.logistik.province.repository.model.Province;
import by.tut.alexander.kaa.logistik.province.service.ModelDTO.ProvinceDTO;

/**
 * Created by GM on 30.08.2018.
 */
public class ProvinceConverter {

    public Province convert(ProvinceDTO provinceDTO) {
        Province province = new Province();
        province.setId(provinceDTO.getId());
        province.setProvinceName(provinceDTO.getProvinceName());
        return province;
    }

    public ProvinceDTO convert(Province province) {
        ProvinceDTO provinceDTO = new ProvinceDTO();
        provinceDTO.setId(province.getId());
        provinceDTO.setProvinceName(province.getProvinceName());
        provinceDTO.setCountryId(province.getCountry().getId());
        return provinceDTO;
    }
}
