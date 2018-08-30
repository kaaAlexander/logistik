package by.tut.alexander.kaa.logistik.customerService.repository;

import by.tut.alexander.kaa.logistik.customerService.repository.model.CustomerService;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
public interface CustomerServiceRepository extends CrudRepository<CustomerService, Long> {

    List<CustomerService> findCustomerServiceByExitPointId(Long id);
}
