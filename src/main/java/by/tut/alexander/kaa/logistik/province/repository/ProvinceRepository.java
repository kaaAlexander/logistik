package by.tut.alexander.kaa.logistik.province.repository;

import by.tut.alexander.kaa.logistik.country.repository.model.Country;
import by.tut.alexander.kaa.logistik.province.repository.model.Province;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
public interface ProvinceRepository extends CrudRepository<Province, Long> {

    List<Province> findByCountryId(Long id);
}
