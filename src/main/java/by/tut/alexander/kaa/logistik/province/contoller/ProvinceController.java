package by.tut.alexander.kaa.logistik.province.contoller;

import by.tut.alexander.kaa.logistik.province.service.ModelDTO.ProvinceDTO;
import by.tut.alexander.kaa.logistik.province.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by GM on 30.08.2018.
 */
@RestController
@RequestMapping({"/province"})
public class ProvinceController {

    @Autowired
    ProvinceService provinceService;

    @GetMapping(path = "/{id}")
    public List<ProvinceDTO> getProvinceByCountryId(@PathVariable("id") Long id) {
        return provinceService.getProvinceByCountryId(id);
    }
}
