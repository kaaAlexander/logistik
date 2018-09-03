package by.tut.alexander.kaa.logistik.exitPoint.service;

import by.tut.alexander.kaa.logistik.exitPoint.repository.ExitPointRepository;
import by.tut.alexander.kaa.logistik.exitPoint.repository.Model.ExitPoint;
import by.tut.alexander.kaa.logistik.exitPoint.service.ModelDTO.ExitPointDTO;
import by.tut.alexander.kaa.logistik.exitPoint.service.util.ExitPointConverter;
import by.tut.alexander.kaa.logistik.province.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
@Service
public class ExitPointServiceImpl implements ExitPointService {

    ExitPointConverter exitPointConverter = new ExitPointConverter();

    @Autowired
    ExitPointRepository exitPointRepository;

    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public List<ExitPointDTO> getExitPointByProvinceId(Long id) {
        List<ExitPoint> exitPointList = exitPointRepository.findExitPointByProvinceId(id);
        List<ExitPointDTO> exitPointDTOList = new ArrayList<>();
        for (ExitPoint exitPoint : exitPointList) {
            ExitPointDTO exitPointDTO = exitPointConverter.convert(exitPoint);
            exitPointDTOList.add(exitPointDTO);
        }
        return exitPointDTOList;
    }

    @Override
    public void createNewExitPoint(ExitPointDTO exitPointDTO) {
        ExitPoint exitPoint = exitPointConverter.convert(exitPointDTO);
        exitPoint.setProvince(provinceRepository.findOneById(exitPointDTO.getProvinceId()));
        exitPointRepository.save(exitPoint);
    }

    @Override
    public void deleteById(Long id) {
        exitPointRepository.deleteById(id);
    }
}
