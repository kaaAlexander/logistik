package by.tut.alexander.kaa.logistik.email.repository;

import by.tut.alexander.kaa.logistik.email.repository.model.Email;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface EmailRepository extends CrudRepository<Email, Long> {
}
