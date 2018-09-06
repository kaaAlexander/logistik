package by.tut.alexander.kaa.logistik.email.repository;

import by.tut.alexander.kaa.logistik.customerService.repository.model.CustomerService;
import by.tut.alexander.kaa.logistik.email.repository.model.Email;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface EmailRepository extends CrudRepository<Email, Long> {

    List<Email> findAllByUserId(Long id);

    Long countEmailByCustomerService(CustomerService customerService);

    List<Email> findAllByCustomerService(CustomerService customerService);

}
