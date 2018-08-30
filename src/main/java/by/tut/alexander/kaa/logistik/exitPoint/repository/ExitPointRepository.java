package by.tut.alexander.kaa.logistik.exitPoint.repository;

import by.tut.alexander.kaa.logistik.exitPoint.repository.Model.ExitPoint;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
public interface ExitPointRepository extends CrudRepository<ExitPoint, Long> {

    List<ExitPoint> findExitPointByProvinceId(Long id);
}
