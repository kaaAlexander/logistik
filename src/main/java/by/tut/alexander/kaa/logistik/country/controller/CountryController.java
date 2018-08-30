package by.tut.alexander.kaa.logistik.country.controller;

import by.tut.alexander.kaa.logistik.country.service.CountryService;
import by.tut.alexander.kaa.logistik.country.service.modelDTO.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
@RestController
@RequestMapping({"/country"})
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping
    public List<CountryDTO> getCountries() {
        return countryService.getAllCountries();
    }
}
