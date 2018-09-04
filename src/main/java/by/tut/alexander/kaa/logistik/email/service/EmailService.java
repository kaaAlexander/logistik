package by.tut.alexander.kaa.logistik.email.service;

import by.tut.alexander.kaa.logistik.email.service.ModelDTO.EmailDTO;

public interface EmailService {

    void sendEmail(Long userId, Long ServiceId);
    void saveEmail(EmailDTO emailDTO);
}
