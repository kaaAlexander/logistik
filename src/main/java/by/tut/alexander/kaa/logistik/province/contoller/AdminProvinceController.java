package by.tut.alexander.kaa.logistik.province.contoller;


import by.tut.alexander.kaa.logistik.province.service.ModelDTO.ProvinceDTO;
import by.tut.alexander.kaa.logistik.province.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/provinceList")
    public String getProvinceByCountryId(@RequestParam("countryId") Long id, @RequestParam("countryName") String countryName,
                                         Model model) {
        List<ProvinceDTO> provinceDTOList = provinceService.getProvinceByCountryId(id);
        model.addAttribute("provinceList", provinceDTOList);
        model.addAttribute("countryId", id);
        model.addAttribute("countryName", countryName);
        return "admin/provinceList";
    }

    @GetMapping("/addProvince")
    public String newProvincePage(@RequestParam("countryId") Long countryId, @RequestParam("countryName") String countryName, Model model) {
        model.addAttribute("province", new ProvinceDTO());
        model.addAttribute("countryId", countryId);
        model.addAttribute("countryName", countryName);
        return "admin/addProvince";
    }

    @PostMapping("/addProvince")
    public String createNewProvince(@ModelAttribute("province") @Valid ProvinceDTO provinceDTO,
                                    @RequestParam("countryId") Long countryId,
                                    @RequestParam("countryName") String countryName,
                                    RedirectAttributes redirectAttributes,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/addProvince";
        }
        provinceDTO.setCountryId(countryId);
        provinceService.addProvince(provinceDTO);
        redirectAttributes.addAttribute("countryId", countryId);
        redirectAttributes.addAttribute("countryName", countryName);
        return "redirect:provinceList";
    }

    @GetMapping("/deleteProvince")
    public String deleteProvinceById(@RequestParam("provinceId") Long provinceId,
                                     @RequestParam("countryId") Long countryId,
                                     @RequestParam("countryName") String countryName,
                                     RedirectAttributes redirectAttributes) {
        provinceService.deleteProvinceById(provinceId);
        redirectAttributes.addAttribute("countryId", countryId);
        redirectAttributes.addAttribute("countryName", countryName);
        return "redirect:provinceList";
    }

}
