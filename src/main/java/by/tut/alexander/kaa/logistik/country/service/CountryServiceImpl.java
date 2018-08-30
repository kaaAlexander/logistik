package by.tut.alexander.kaa.logistik.country.service;

import by.tut.alexander.kaa.logistik.country.repository.CountryRepository;
import by.tut.alexander.kaa.logistik.country.repository.model.Country;
import by.tut.alexander.kaa.logistik.country.service.modelDTO.CountryDTO;
import by.tut.alexander.kaa.logistik.country.service.util.CountryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
@Service
public class CountryServiceImpl implements CountryService {

    private CountryConverter countryConverter = new CountryConverter();

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<CountryDTO> getAllCountries() {
        List<CountryDTO> countryDTOList = new ArrayList<>();
        List<Country> countryList = countryRepository.findAll();
        for (Country country : countryList) {
            CountryDTO countryDTO = countryConverter.convert(country);
            countryDTOList.add(countryDTO);
        }
        return countryDTOList;
    }

    @Override
    public void addCountry(CountryDTO countryDTO) {
        Country country = countryConverter.convert(countryDTO);
        countryRepository.save(country);
    }
}
