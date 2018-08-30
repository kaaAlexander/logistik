package by.tut.alexander.kaa.logistik.province.service;

import by.tut.alexander.kaa.logistik.country.service.modelDTO.CountryDTO;
import by.tut.alexander.kaa.logistik.province.service.ModelDTO.ProvinceDTO;

import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
public interface ProvinceService {

    List<ProvinceDTO> getProvinceByCountryId(Long id);
}
