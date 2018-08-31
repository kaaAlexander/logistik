package by.tut.alexander.kaa.logistik.province.repository;

import by.tut.alexander.kaa.logistik.province.repository.model.Province;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
@Transactional
public interface ProvinceRepository extends CrudRepository<Province, Long> {

    List<Province> findByCountryId(Long id);
}
