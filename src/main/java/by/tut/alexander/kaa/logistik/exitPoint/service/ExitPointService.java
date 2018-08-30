package by.tut.alexander.kaa.logistik.exitPoint.service;

import by.tut.alexander.kaa.logistik.exitPoint.service.ModelDTO.ExitPointDTO;

import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
public interface ExitPointService {

    List<ExitPointDTO> getExitPointByProvinceId(Long id);
}
