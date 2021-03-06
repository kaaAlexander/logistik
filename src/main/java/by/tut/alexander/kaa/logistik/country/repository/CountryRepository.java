package by.tut.alexander.kaa.logistik.country.repository;

import by.tut.alexander.kaa.logistik.country.repository.model.Country;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
@Transactional
public interface CountryRepository extends CrudRepository<Country, Long> {
    List<Country> findAll();

    void deleteCountryById(Long id);

    Country findOneById(Long Id);
}
