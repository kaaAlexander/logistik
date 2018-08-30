package by.tut.alexander.kaa.logistik.exitPoint.controller;

import by.tut.alexander.kaa.logistik.exitPoint.service.ExitPointService;
import by.tut.alexander.kaa.logistik.exitPoint.service.ModelDTO.ExitPointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
@RestController
@RequestMapping({"/exitpoint"})
public class ExitPointController {

    @Autowired
    ExitPointService exitPointService;

    @GetMapping(path = "{/id}")
    public List<ExitPointDTO> getExitPointByProvinceId(@PathVariable("id") Long id) {
        return exitPointService.getExitPointByProvinceId(id);
    }
}
