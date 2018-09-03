package by.tut.alexander.kaa.logistik.customerService.service.util;

import by.tut.alexander.kaa.logistik.customerService.repository.model.CustomerService;
import by.tut.alexander.kaa.logistik.customerService.service.modelDTO.CustomerServiceDTO;

/**
 * Created by GM on 30.08.2018.
 */
public class CustomerServiceConverter {

    public CustomerServiceDTO convert(CustomerService customerService) {
        CustomerServiceDTO customerServiceDTO = new CustomerServiceDTO();
        customerServiceDTO.setId(customerService.getId());
        customerServiceDTO.setCustomerServiceName(customerService.getCustomerServiceName());
        customerServiceDTO.setCustomerServiceEmail(customerService.getCustomerServiceEmail());
        customerServiceDTO.setExitPointId(customerService.getExitPoint().getId());
        return customerServiceDTO;
    }

    public CustomerService convert(CustomerServiceDTO customerServiceDTO) {
        CustomerService customerService = new CustomerService();
        customerService.setId(customerServiceDTO.getId());
        customerService.setCustomerServiceName(customerServiceDTO.getCustomerServiceName());
        customerService.setCustomerServiceEmail(customerServiceDTO.getCustomerServiceEmail());
        return customerService;
    }
}
