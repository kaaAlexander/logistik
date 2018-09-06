package by.tut.alexander.kaa.logistik.serverEmail.service;

import by.tut.alexander.kaa.logistik.serverEmail.service.modelDTO.ServerEmailDTO;

import java.util.List;

public interface ServerEmailService {

    List<ServerEmailDTO> getAllServerEmail();

    void deleteServerEmail(Long id);

    void addServerEmail(ServerEmailDTO serverEmailDTO);

}
