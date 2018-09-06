package by.tut.alexander.kaa.logistik.customerService.service;

import by.tut.alexander.kaa.logistik.customerService.service.modelDTO.CustomerServiceDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
public interface CustomerServiceService {

    List<CustomerServiceDTO> findCustomerServiceByExitPointId(Long id);

    void deleteById(Long id);

    void saveNewCustomerService(CustomerServiceDTO customerServiceDTO);

    CustomerServiceDTO getCustomerServiceById(Long id);

    List<CustomerServiceDTO> getAllCustomerService();

    List<CustomerServiceDTO> getCustomerServiceByEmail(String email);

    List<CustomerServiceDTO> getCustomerServiceByEmailAndFromDate(String email, Date date);

    List<CustomerServiceDTO> getCustomerServiceByEmailAndByDate(String email, Date date);

    List<CustomerServiceDTO> getCustomerServiceByEmailAndFromDateAndByDate(String email, Date fromDate, Date byDate);

    List<CustomerServiceDTO> getCustomerServiceByFromDate(Date fromDate);

    List<CustomerServiceDTO> getCustomerServiceByByDate(Date date);

    List<CustomerServiceDTO> getCustomerServiceByFromDateAndByDate(Date fromDate, Date byDate);
}
