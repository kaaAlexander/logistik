package by.tut.alexander.kaa.logistik.customerService.repository;

import by.tut.alexander.kaa.logistik.customerService.repository.model.CustomerService;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
@Transactional
public interface CustomerServiceRepository extends CrudRepository<CustomerService, Long> {

    List<CustomerService> findCustomerServiceByExitPointId(Long id);

    void deleteById(Long id);

    CustomerService findOneById(Long id);

    List<CustomerService> findAll();

    List<CustomerService> findAllByCustomerServiceEmail(String email);
}
