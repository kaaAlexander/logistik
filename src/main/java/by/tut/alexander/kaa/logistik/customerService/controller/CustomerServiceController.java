package by.tut.alexander.kaa.logistik.customerService.controller;

import by.tut.alexander.kaa.logistik.customerService.service.CustomerServiceService;
import by.tut.alexander.kaa.logistik.customerService.service.modelDTO.CustomerServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
@RestController
@RequestMapping({"/customerservice"})
public class CustomerServiceController {

    @Autowired
    CustomerServiceService customerServiceService;

    @GetMapping(path = {"/{id}"})
    public List<CustomerServiceDTO> getCustomerServiceByExitPointId(@PathVariable("id") Long id) {
        return customerServiceService.findCustomerServiceByExitPointId(id);
    }
}
