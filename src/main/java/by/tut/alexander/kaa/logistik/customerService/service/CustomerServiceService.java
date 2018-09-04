package by.tut.alexander.kaa.logistik.customerService.service;

import by.tut.alexander.kaa.logistik.customerService.service.modelDTO.CustomerServiceDTO;

import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
public interface CustomerServiceService {

    List<CustomerServiceDTO> findCustomerServiceByExitPointId(Long id);

    void deleteById(Long id);

    void saveNewCustomerService(CustomerServiceDTO customerServiceDTO);

    CustomerServiceDTO getCustomerServiceById(Long id);
}
