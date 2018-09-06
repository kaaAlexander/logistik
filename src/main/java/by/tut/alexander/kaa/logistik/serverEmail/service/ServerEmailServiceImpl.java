package by.tut.alexander.kaa.logistik.serverEmail.service;

import by.tut.alexander.kaa.logistik.serverEmail.repostiry.Model.ServerEmail;
import by.tut.alexander.kaa.logistik.serverEmail.repostiry.ServerEmailRepository;
import by.tut.alexander.kaa.logistik.serverEmail.service.modelDTO.ServerEmailDTO;
import by.tut.alexander.kaa.logistik.serverEmail.service.util.ServerEmailConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServerEmailServiceImpl implements ServerEmailService {

    ServerEmailConverter serverEmailConverter = new ServerEmailConverter();

    @Autowired
    ServerEmailRepository serverEmailRepository;

    @Override
    public List<ServerEmailDTO> getAllServerEmail() {
        List<ServerEmail> serverEmailList = serverEmailRepository.findAll();
        List<ServerEmailDTO> serverEmailDTOList = new ArrayList<>();
        for (ServerEmail serverEmail : serverEmailList) {
            ServerEmailDTO serverEmailDTO = serverEmailConverter.convert(serverEmail);
            serverEmailDTOList.add(serverEmailDTO);
        }
        return serverEmailDTOList;
    }

    @Override
    public void deleteServerEmail(Long id) {
        serverEmailRepository.deleteById(id);
    }

    @Override
    public void addServerEmail(ServerEmailDTO serverEmailDTO) {
        serverEmailRepository.save(serverEmailConverter.convert(serverEmailDTO));
    }
}
