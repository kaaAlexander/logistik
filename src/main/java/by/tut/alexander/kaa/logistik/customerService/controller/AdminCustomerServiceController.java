package by.tut.alexander.kaa.logistik.customerService.controller;

import by.tut.alexander.kaa.logistik.customerService.service.CustomerServiceService;
import by.tut.alexander.kaa.logistik.customerService.service.modelDTO.CustomerServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
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
        if (customerServiceDTOList.isEmpty()) {
            model.addAttribute("resultFalse", true);
        }
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

    @GetMapping("/statistic")
    public String getAllCustomersService(Model model) {
        List<CustomerServiceDTO> customerServiceDTOList = customerServiceService.getAllCustomerService();
        if (customerServiceDTOList.isEmpty()) {
            model.addAttribute("resultFalse", true);
        }
        model.addAttribute("customerService", new CustomerServiceDTO());
        model.addAttribute("customerServiceList", customerServiceDTOList);
        return "admin/statistic";
    }

    @PostMapping("/statistic")
    public String getCustomerServiceByProperties(@ModelAttribute("customerService") CustomerServiceDTO customerServiceDTO, Model model) {
        List<CustomerServiceDTO> customerServiceDTOList = new ArrayList<>();
        if (customerServiceDTO.getCustomerServiceEmail() == "" && customerServiceDTO.getByDate() == null && customerServiceDTO.getFromDate() == null) {
            return "redirect:statistic";
        }
        if (customerServiceDTO.getCustomerServiceEmail() != "") {
            if (customerServiceDTO.getByDate() == null && customerServiceDTO.getFromDate() == null) {
                customerServiceDTOList = customerServiceService.getCustomerServiceByEmail(customerServiceDTO.getCustomerServiceEmail());
            }
            if (customerServiceDTO.getByDate() != null && customerServiceDTO.getFromDate() == null) {
                customerServiceDTOList = customerServiceService
                        .getCustomerServiceByEmailAndByDate(customerServiceDTO.getCustomerServiceEmail(), customerServiceDTO.getByDate());
            }
            if (customerServiceDTO.getByDate() == null && customerServiceDTO.getFromDate() != null) {
                customerServiceDTOList = customerServiceService
                        .getCustomerServiceByEmailAndFromDate(customerServiceDTO.getCustomerServiceEmail(), customerServiceDTO.getFromDate());
            }
            if (customerServiceDTO.getByDate() != null && customerServiceDTO.getFromDate() != null) {
                if (customerServiceDTO.getFromDate().after(customerServiceDTO.getByDate())) {
                    Date date = customerServiceDTO.getFromDate();
                    customerServiceDTO.setFromDate(customerServiceDTO.getByDate());
                    customerServiceDTO.setByDate(date);
                }
                customerServiceDTOList = customerServiceService
                        .getCustomerServiceByEmailAndFromDateAndByDate(customerServiceDTO.getCustomerServiceEmail()
                                , customerServiceDTO.getFromDate(), customerServiceDTO.getByDate());
            }

        } else {
            if (customerServiceDTO.getByDate() != null && customerServiceDTO.getFromDate() == null) {
                customerServiceDTOList = customerServiceService
                        .getCustomerServiceByByDate(customerServiceDTO.getByDate());
            }
            if (customerServiceDTO.getByDate() == null && customerServiceDTO.getFromDate() != null) {
                customerServiceDTOList = customerServiceService
                        .getCustomerServiceByFromDate(customerServiceDTO.getFromDate());
            }
            if (customerServiceDTO.getByDate() != null && customerServiceDTO.getFromDate() != null) {
                if (customerServiceDTO.getFromDate().after(customerServiceDTO.getByDate())) {
                    Date date = customerServiceDTO.getFromDate();
                    customerServiceDTO.setFromDate(customerServiceDTO.getByDate());
                    customerServiceDTO.setByDate(date);
                }
                customerServiceDTOList = customerServiceService
                        .getCustomerServiceByFromDateAndByDate(customerServiceDTO.getFromDate(), customerServiceDTO.getByDate());
            }


        }
        if (customerServiceDTOList.isEmpty()) {
            model.addAttribute("resultFalse", true);
        }
        model.addAttribute("customerServiceList", customerServiceDTOList);
        return "admin/statistic";
    }
}
