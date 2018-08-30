package by.tut.alexander.kaa.logistik.adminController;

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
public class AdminController {

    @Autowired
    CountryService countryService;

    @GetMapping("/")
    public String findAllCountries(Model model) {
        List<CountryDTO> countryDTOList = countryService.getAllCountries();
        model.addAttribute("countries", countryDTOList);
        return "index";
    }

    @GetMapping("/addCountry")
    public String newBookPage(Model model) {
        model.addAttribute("country", new CountryDTO());
        return "addCountry";
    }

    @PostMapping("/addCountry")
    public String createNewBook(@ModelAttribute("country") @Valid CountryDTO countryDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addCountry";
        }
        countryService.addCountry(countryDTO);
        return "redirect:/";
    }
}
