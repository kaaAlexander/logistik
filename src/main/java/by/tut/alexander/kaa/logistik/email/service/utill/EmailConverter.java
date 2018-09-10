package by.tut.alexander.kaa.logistik.email.service.utill;

import by.tut.alexander.kaa.logistik.email.repository.model.Email;
import by.tut.alexander.kaa.logistik.email.service.ModelDTO.EmailDTO;

public class EmailConverter {

    public Email convert(EmailDTO emailDTO) {
        Email email = new Email();
        email.setId(emailDTO.getId());
        email.setDate(emailDTO.getDate());
        email.setServerEmailName(emailDTO.getServerEmailName());
        return email;
    }

    public EmailDTO convert(Email email) {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setCustomerServiceId(email.getCustomerService().getId());
        emailDTO.setUserId(email.getUser().getId());
        emailDTO.setDate(email.getDate());
        emailDTO.setCustomerServiceName(email.getCustomerService().getCustomerServiceName());
        emailDTO.setCustomerServiceEmail(email.getCustomerService().getCustomerServiceEmail());
        emailDTO.setSendingFrom(email.getServerEmailName());
        return emailDTO;
    }
}
