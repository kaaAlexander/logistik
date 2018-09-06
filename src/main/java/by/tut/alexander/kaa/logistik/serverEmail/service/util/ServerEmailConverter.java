package by.tut.alexander.kaa.logistik.serverEmail.service.util;

import by.tut.alexander.kaa.logistik.serverEmail.repostiry.Model.ServerEmail;
import by.tut.alexander.kaa.logistik.serverEmail.service.modelDTO.ServerEmailDTO;

public class ServerEmailConverter {

    public ServerEmail convert(ServerEmailDTO serverEmailDTO) {
        ServerEmail serverEmail = new ServerEmail();
        serverEmail.setId(serverEmailDTO.getId());
        serverEmail.setEmail(serverEmailDTO.getEmail());
        serverEmail.setPassword(serverEmailDTO.getPassword());
        serverEmail.setPort(serverEmailDTO.getPort());
        serverEmail.setSmtp(serverEmailDTO.getSmtp());
        serverEmail.setSsl(serverEmailDTO.isSsl());
        return serverEmail;
    }

    public ServerEmailDTO convert(ServerEmail serverEmail) {
        ServerEmailDTO serverEmailDTO = new ServerEmailDTO();
        serverEmailDTO.setEmail(serverEmail.getEmail());
        serverEmailDTO.setId(serverEmail.getId());
        serverEmailDTO.setPassword(serverEmail.getPassword());
        serverEmailDTO.setPort(serverEmail.getPort());
        serverEmailDTO.setSmtp(serverEmail.getSmtp());
        serverEmailDTO.setSsl(serverEmail.isSsl());
        return serverEmailDTO;
    }
}
