package by.tut.alexander.kaa.logistik.customerService.service;

import by.tut.alexander.kaa.logistik.customerService.repository.CustomerServiceRepository;
import by.tut.alexander.kaa.logistik.customerService.repository.model.CustomerService;
import by.tut.alexander.kaa.logistik.customerService.service.modelDTO.CustomerServiceDTO;
import by.tut.alexander.kaa.logistik.customerService.service.util.CustomerServiceConverter;
import by.tut.alexander.kaa.logistik.email.repository.EmailRepository;
import by.tut.alexander.kaa.logistik.email.repository.model.Email;
import by.tut.alexander.kaa.logistik.exitPoint.repository.ExitPointRepository;
import by.tut.alexander.kaa.logistik.exitPoint.service.ExitPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
@Service
public class CustomerServiceServiceImpl implements CustomerServiceService {

    CustomerServiceConverter customerServiceConverter = new CustomerServiceConverter();

    @Autowired
    CustomerServiceRepository customerServiceRepository;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    ExitPointRepository exitPointRepository;

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

    @Override
    public void deleteById(Long id) {
        customerServiceRepository.deleteById(id);
    }

    @Override
    public void saveNewCustomerService(CustomerServiceDTO customerServiceDTO) {
        CustomerService customerService = customerServiceConverter.convert(customerServiceDTO);
        customerService.setExitPoint(exitPointRepository.findOneById(customerServiceDTO.getExitPointId()));
        customerServiceRepository.save(customerService);
    }

    @Override
    public CustomerServiceDTO getCustomerServiceById(Long id) {
        return customerServiceConverter.convert(customerServiceRepository.findOneById(id));
    }

    @Override
    public List<CustomerServiceDTO> getAllCustomerService() {
        List<CustomerService> customerServiceList = customerServiceRepository.findAll();
        List<CustomerServiceDTO> customerServiceDTOList = new ArrayList<>();
        for (CustomerService customerService : customerServiceList) {
            CustomerServiceDTO customerServiceDTO = customerServiceConverter.convert(customerService);
            customerServiceDTO.setEmailCount(emailRepository.countEmailByCustomerService(customerService));
            customerServiceDTOList.add(customerServiceDTO);
        }
        return customerServiceDTOList;
    }

    @Override
    public List<CustomerServiceDTO> getCustomerServiceByEmail(String email) {
        List<CustomerService> customerServiceList = customerServiceRepository.findAllByCustomerServiceEmail(email);
        List<CustomerServiceDTO> customerServiceDTOList = new ArrayList<>();
        for (CustomerService customerService : customerServiceList) {
            CustomerServiceDTO customerServiceDTO = customerServiceConverter.convert(customerService);
            customerServiceDTO.setEmailCount(emailRepository.countEmailByCustomerService(customerService));
            customerServiceDTOList.add(customerServiceDTO);
        }
        return customerServiceDTOList;
    }

    @Override
    public List<CustomerServiceDTO> getCustomerServiceByEmailAndFromDate(String email, Date fromDate) {
        Long count = Long.valueOf(0);
        List<CustomerService> customerServiceList = customerServiceRepository.findAllByCustomerServiceEmail(email);
        List<CustomerServiceDTO> customerServiceDTOList = new ArrayList<>();
        for (CustomerService customerService : customerServiceList) {
            CustomerServiceDTO customerServiceDTO = customerServiceConverter.convert(customerService);
            List<Email> emailList = emailRepository.findAllByCustomerService(customerService);
            count = Long.valueOf(0);
            for (Email entity : emailList) {
                if (entity.getDate().after(fromDate) || entity.getDate().equals(fromDate)) {
                    count = count + 1;
                }
            }
            customerServiceDTO.setEmailCount(count);
            customerServiceDTOList.add(customerServiceDTO);
        }
        return customerServiceDTOList;
    }

    @Override
    public List<CustomerServiceDTO> getCustomerServiceByEmailAndByDate(String email, Date byDate) {
        Long count = Long.valueOf(0);
        List<CustomerService> customerServiceList = customerServiceRepository.findAllByCustomerServiceEmail(email);
        List<CustomerServiceDTO> customerServiceDTOList = new ArrayList<>();
        for (CustomerService customerService : customerServiceList) {
            CustomerServiceDTO customerServiceDTO = customerServiceConverter.convert(customerService);
            List<Email> emailList = emailRepository.findAllByCustomerService(customerService);
            byDate = getEnd(byDate);
            count = Long.valueOf(0);
            for (Email entity : emailList) {
                if (entity.getDate().before(byDate) || entity.getDate().equals(byDate)) {
                    count = count + 1;
                }
            }
            customerServiceDTO.setEmailCount(count);
            customerServiceDTOList.add(customerServiceDTO);
        }
        return customerServiceDTOList;
    }

    @Override
    public List<CustomerServiceDTO> getCustomerServiceByEmailAndFromDateAndByDate(String email, Date fromDate, Date byDate) {
        Long count = Long.valueOf(0);
        List<CustomerService> customerServiceList = customerServiceRepository.findAllByCustomerServiceEmail(email);
        List<CustomerServiceDTO> customerServiceDTOList = new ArrayList<>();
        for (CustomerService customerService : customerServiceList) {
            CustomerServiceDTO customerServiceDTO = customerServiceConverter.convert(customerService);
            List<Email> emailList = emailRepository.findAllByCustomerService(customerService);
            byDate = getEnd(byDate);
            count = Long.valueOf(0);
            for (Email entity : emailList) {
                if (entity.getDate().before(byDate) && entity.getDate().after(fromDate) || entity.getDate().equals(byDate) || entity.getDate().equals(fromDate)) {
                    count = count + 1;
                }
            }
            customerServiceDTO.setEmailCount(count);
            customerServiceDTOList.add(customerServiceDTO);
        }
        return customerServiceDTOList;
    }

    @Override
    public List<CustomerServiceDTO> getCustomerServiceByFromDate(Date fromDate) {
        Long count = Long.valueOf(0);
        List<CustomerService> customerServiceList = customerServiceRepository.findAll();
        List<CustomerServiceDTO> customerServiceDTOList = new ArrayList<>();
        for (CustomerService customerService : customerServiceList) {
            CustomerServiceDTO customerServiceDTO = customerServiceConverter.convert(customerService);
            List<Email> emailList = emailRepository.findAllByCustomerService(customerService);
            count = Long.valueOf(0);
            for (Email entity : emailList) {
                if (entity.getDate().after(fromDate) || entity.getDate().equals(fromDate)) {
                    count = count + 1;
                }
            }
            customerServiceDTO.setEmailCount(count);
            customerServiceDTOList.add(customerServiceDTO);
        }
        return customerServiceDTOList;
    }

    @Override
    public List<CustomerServiceDTO> getCustomerServiceByByDate(Date byDate) {
        Long count = Long.valueOf(0);
        List<CustomerService> customerServiceList = customerServiceRepository.findAll();
        List<CustomerServiceDTO> customerServiceDTOList = new ArrayList<>();
        for (CustomerService customerService : customerServiceList) {
            CustomerServiceDTO customerServiceDTO = customerServiceConverter.convert(customerService);
            List<Email> emailList = emailRepository.findAllByCustomerService(customerService);
            byDate = getEnd(byDate);
            count = Long.valueOf(0);
            for (Email entity : emailList) {
                if (entity.getDate().before(byDate) || entity.getDate().equals(byDate)) {
                    count = count + 1;
                }
            }
            customerServiceDTO.setEmailCount(count);
            customerServiceDTOList.add(customerServiceDTO);
        }
        return customerServiceDTOList;
    }

    @Override
    public List<CustomerServiceDTO> getCustomerServiceByFromDateAndByDate(Date fromDate, Date byDate) {
        Long count = Long.valueOf(0);
        List<CustomerService> customerServiceList = customerServiceRepository.findAll();
        List<CustomerServiceDTO> customerServiceDTOList = new ArrayList<>();
        for (CustomerService customerService : customerServiceList) {
            CustomerServiceDTO customerServiceDTO = customerServiceConverter.convert(customerService);
            List<Email> emailList = emailRepository.findAllByCustomerService(customerService);
            byDate = getEnd(byDate);
            count = Long.valueOf(0);
            for (Email entity : emailList) {
                if (entity.getDate().before(byDate) && entity.getDate().after(fromDate) || entity.getDate().equals(byDate) || entity.getDate().equals(fromDate)) {
                    count = count + 1;
                }
            }
            customerServiceDTO.setEmailCount(count);
            customerServiceDTOList.add(customerServiceDTO);
        }
        return customerServiceDTOList;
    }

    public Date getEnd(Date date) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }


}
