package by.tut.alexander.kaa.logistik.customerService.controller;

import by.tut.alexander.kaa.logistik.customerService.service.CustomerServiceService;
import by.tut.alexander.kaa.logistik.customerService.service.modelDTO.CustomerServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminCustomerServiceController {


    @Autowired
    private CustomerServiceService customerServiceService;


    @GetMapping("/customerServicesList")
    public String getCustomerServiceList(@RequestParam("exitPointId") Long exitPointId,
                                         @RequestParam("provinceId") Long provinceId,
                                         @RequestParam("provinceName") String provinceName,
                                         @RequestParam("countryId") Long countryId,
                                         @RequestParam("countryName") String countryName,
                                         Model model) {
        List<CustomerServiceDTO> customerServiceDTOList = customerServiceService.findCustomerServiceByExitPointId(exitPointId);
        model.addAttribute("customerServices", customerServiceDTOList);
        model.addAttribute("provinceId", provinceId);
        model.addAttribute("provinceName", provinceName);
        model.addAttribute("countryId", countryId);
        model.addAttribute("countryName", countryName);
        model.addAttribute("exitPointId", exitPointId);
        return "admin/customerService/customerServicesList";
    }

    @GetMapping("/addCustomerService")
    public String newCustomerServicePage(@RequestParam("exitPointId") Long exitPointId,
                                         @RequestParam("provinceId") Long provinceId,
                                         @RequestParam("provinceName") String provinceName,
                                         @RequestParam("countryId") Long countryId,
                                         @RequestParam("countryName") String countryName,
                                         Model model) {
        model.addAttribute("customerService", new CustomerServiceDTO());
        model.addAttribute("provinceId", provinceId);
        model.addAttribute("provinceName", provinceName);
        model.addAttribute("countryId", countryId);
        model.addAttribute("countryName", countryName);
        model.addAttribute("exitPointId", exitPointId);
        return "admin/customerService/addCustomerService";
    }

    @PostMapping("/addCustomerService")
    public String createNewCustomerService(@ModelAttribute("customerService") CustomerServiceDTO customerServiceDTO,
                                           @RequestParam("exitPointId") Long exitPointId,
                                           @RequestParam("provinceId") Long provinceId,
                                           @RequestParam("provinceName") String provinceName,
                                           @RequestParam("countryId") Long countryId,
                                           @RequestParam("countryName") String countryName,
                                           RedirectAttributes redirectAttributes) {
        customerServiceService.saveNewCustomerService(customerServiceDTO);
        redirectAttributes.addAttribute("countryId", countryId);
        redirectAttributes.addAttribute("countryName", countryName);
        redirectAttributes.addAttribute("provinceId", provinceId);
        redirectAttributes.addAttribute("provinceName", provinceName);
        redirectAttributes.addAttribute("exitPointId", exitPointId);
        return "redirect:customerServicesList";
    }

    @GetMapping("/deleteCustomerService")
    public String deleteCustomerServicebyId(@RequestParam("exitPointId") Long exitPointId,
                                            @RequestParam("provinceId") Long provinceId,
                                            @RequestParam("provinceName") String provinceName,
                                            @RequestParam("countryId") Long countryId,
                                            @RequestParam("countryName") String countryName,
                                            @RequestParam("customerServiceId") Long customerServiceId,
                                            RedirectAttributes redirectAttributes) {
        customerServiceService.deleteById(customerServiceId);
        redirectAttributes.addAttribute("countryId", countryId);
        redirectAttributes.addAttribute("countryName", countryName);
        redirectAttributes.addAttribute("provinceId", provinceId);
        redirectAttributes.addAttribute("provinceName", provinceName);
        redirectAttributes.addAttribute("exitPointId", exitPointId);
        return "redirect:customerServicesList";
    }
}
