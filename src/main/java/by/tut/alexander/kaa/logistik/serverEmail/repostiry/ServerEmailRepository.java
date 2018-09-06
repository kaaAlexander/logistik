package by.tut.alexander.kaa.logistik.serverEmail.repostiry;

import by.tut.alexander.kaa.logistik.serverEmail.repostiry.Model.ServerEmail;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ServerEmailRepository extends CrudRepository<ServerEmail, Long> {

    List<ServerEmail> findAll();

    void deleteById(Long id);

    ServerEmail findOneByEmail(String email);

    ServerEmail findOneById(Long id);
}
