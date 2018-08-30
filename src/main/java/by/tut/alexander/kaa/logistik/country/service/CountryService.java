package by.tut.alexander.kaa.logistik.country.service;

import by.tut.alexander.kaa.logistik.country.service.modelDTO.CountryDTO;

import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
public interface CountryService {

    List<CountryDTO> getAllCountries();

    void addCountry(CountryDTO countryDTO);
}
