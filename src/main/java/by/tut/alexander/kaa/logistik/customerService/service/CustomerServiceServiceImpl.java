package by.tut.alexander.kaa.logistik.customerService.service;

import by.tut.alexander.kaa.logistik.customerService.repository.CustomerServiceRepository;
import by.tut.alexander.kaa.logistik.customerService.repository.model.CustomerService;
import by.tut.alexander.kaa.logistik.customerService.service.modelDTO.CustomerServiceDTO;
import by.tut.alexander.kaa.logistik.customerService.service.util.CustomerServiceConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
@Service
public class CustomerServiceServiceImpl implements CustomerServiceService {

    CustomerServiceConverter customerServiceConverter = new CustomerServiceConverter();

    @Autowired
    CustomerServiceRepository customerServiceRepository;

    @Override
    public List<CustomerServiceDTO> findCustomerServiceByExitPointId(Long id) {
        List<CustomerService> customerServiceList = customerServiceRepository.findCustomerServiceByExitPointId(id);
        List<CustomerServiceDTO> customerServiceDTOList = new ArrayList<>();
        for (CustomerService customerService : customerServiceList) {
            CustomerServiceDTO customerServiceDTO = customerServiceConverter.convert(customerService);
            customerServiceDTOList.add(customerServiceDTO);
        }
        return customerServiceDTOList;
    }
}