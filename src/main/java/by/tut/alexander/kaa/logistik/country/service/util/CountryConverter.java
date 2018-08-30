package by.tut.alexander.kaa.logistik.country.service.util;

import by.tut.alexander.kaa.logistik.country.repository.model.Country;
import by.tut.alexander.kaa.logistik.country.service.modelDTO.CountryDTO;

/**
 * Created by GM on 30.08.2018.
 */
public class CountryConverter {

    public Country convert(CountryDTO countryDTO) {
        Country country = new Country();
        country.setId(country.getId());
        country.setCountryName(countryDTO.getCountryName());
        return country;
    }

    public CountryDTO convert(Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(country.getId());
        countryDTO.setCountryName(country.getCountryName());
        return countryDTO;
    }
}
