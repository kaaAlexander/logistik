package by.tut.alexander.kaa.logistik.province.service;

import by.tut.alexander.kaa.logistik.country.repository.CountryRepository;
import by.tut.alexander.kaa.logistik.country.repository.model.Country;
import by.tut.alexander.kaa.logistik.country.service.CountryServiceImpl;
import by.tut.alexander.kaa.logistik.country.service.modelDTO.CountryDTO;
import by.tut.alexander.kaa.logistik.country.service.util.CountryConverter;
import by.tut.alexander.kaa.logistik.province.repository.ProvinceRepository;
import by.tut.alexander.kaa.logistik.province.repository.model.Province;
import by.tut.alexander.kaa.logistik.province.service.ModelDTO.ProvinceDTO;
import by.tut.alexander.kaa.logistik.province.service.util.ProvinceConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceConverter provinceConverter = new ProvinceConverter();

    @Autowired
    ProvinceRepository provinceRepository;

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<ProvinceDTO> getProvinceByCountryId(Long id) {
        List<Province> provinceList = provinceRepository.findByCountryId(id);
        List<ProvinceDTO> provinceDTOList = new ArrayList<>();
        for (Province province : provinceList) {
            ProvinceDTO provinceDTO = provinceConverter.convert(province);
            provinceDTOList.add(provinceDTO);
        }
        return provinceDTOList;
    }

    @Override
    public void addProvince(ProvinceDTO provinceDTO) {
        Province province = provinceConverter.convert(provinceDTO);
        Country country = countryRepository.findOneById(provinceDTO.getCountryId());
        province.setCountry(country);
        provinceRepository.save(province);
    }

    @Override
    public void deleteProvinceById(Long id) {
        provinceRepository.deleteById(id);
    }
}
