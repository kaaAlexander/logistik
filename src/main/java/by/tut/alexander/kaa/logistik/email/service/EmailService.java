package by.tut.alexander.kaa.logistik.email.service;

import by.tut.alexander.kaa.logistik.email.service.ModelDTO.EmailDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmailService {

    void sendEmail(Long userId, Long ServiceId, MultipartFile files);

    boolean sendEmail(Long userId, Long ServiceId);

    void saveEmail(EmailDTO emailDTO);

    List<EmailDTO> getAllEmailByUserId(Long id);
}
