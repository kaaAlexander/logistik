package by.tut.alexander.kaa.logistik.country.repository;

import by.tut.alexander.kaa.logistik.country.repository.model.Country;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by GM on 30.08.2018.
 */
public interface CountryRepository extends CrudRepository<Country, Long> {

    Country getById(Long id);

}
