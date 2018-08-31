package by.tut.alexander.kaa.logistik.user.repository;

import by.tut.alexander.kaa.logistik.user.repository.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by GM on 30.08.2018.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserById(Long id);
}
