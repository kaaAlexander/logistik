package by.tut.alexander.kaa.logistik.exitPoint.service.util;

import by.tut.alexander.kaa.logistik.exitPoint.repository.Model.ExitPoint;
import by.tut.alexander.kaa.logistik.exitPoint.service.ModelDTO.ExitPointDTO;

/**
 * Created by GM on 30.08.2018.
 */
public class ExitPointConverter {

    public ExitPointDTO convert(ExitPoint exitPoint) {
        ExitPointDTO exitPointDTO = new ExitPointDTO();
        exitPointDTO.setId(exitPoint.getId());
        exitPointDTO.setExitPointName(exitPoint.getExitPointName());
        exitPointDTO.setProvinceId(exitPoint.getProvince().getId());
        return exitPointDTO;
    }
}
