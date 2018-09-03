package by.tut.alexander.kaa.logistik.country.controller;

import by.tut.alexander.kaa.logistik.country.service.CountryService;
import by.tut.alexander.kaa.logistik.country.service.modelDTO.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminCountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countryList")
    public String findAllCountries(Model model) {
        List<CountryDTO> countryDTOList = countryService.getAllCountries();
        model.addAttribute("countries", countryDTOList);
        return "admin/countryList";
    }

    @GetMapping("/addCountry")
    public String newBookPage(Model model) {
        model.addAttribute("country", new CountryDTO());
        return "admin/addCountry";
    }

    @PostMapping("/addCountry")
    public String createNewBook(@ModelAttribute("country") @Valid CountryDTO countryDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/addCountry";
        }
        countryService.addCountry(countryDTO);
        return "redirect:countryList";
    }

    @GetMapping("/deleteCountry")
    public String deleteCountryById(@RequestParam("countryId") Long id) {
        countryService.deleteCountryById(id);
        return "redirect:countryList";
    }
}
