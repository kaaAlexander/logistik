package by.tut.alexander.kaa.logistik.email.service;

import by.tut.alexander.kaa.logistik.customerService.repository.CustomerServiceRepository;
import by.tut.alexander.kaa.logistik.customerService.service.CustomerServiceService;
import by.tut.alexander.kaa.logistik.customerService.service.modelDTO.CustomerServiceDTO;
import by.tut.alexander.kaa.logistik.email.repository.EmailRepository;
import by.tut.alexander.kaa.logistik.email.repository.model.Email;
import by.tut.alexander.kaa.logistik.email.service.ModelDTO.EmailDTO;
import by.tut.alexander.kaa.logistik.email.service.utill.EmailConverter;
import by.tut.alexander.kaa.logistik.user.repository.UserRepository;
import by.tut.alexander.kaa.logistik.user.service.UserService;
import by.tut.alexander.kaa.logistik.user.service.modelDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.TimeZone;

@Service
public class EmailServiceImpl implements EmailService {

    private EmailConverter emailConverter = new EmailConverter();

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    UserService userService;

    @Autowired
    CustomerServiceService customerService;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomerServiceRepository customerServiceRepository;


    @Override
    public void sendEmail(Long userId, Long customerServiceId) {
        EmailDTO emailDTO = new EmailDTO();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+3"));
        emailDTO.setDate(new Date());
        emailDTO.setUserId(userId);
        emailDTO.setCustomerServiceId(customerServiceId);
        UserDTO userDTO = userService.getUserById(userId);
        CustomerServiceDTO customerServiceDTO = customerService.getCustomerServiceById(customerServiceId);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(userDTO.getEmail());
        message.setTo(customerServiceDTO.getCustomerServiceEmail(), userDTO.getEmail(), "logistik.application@gmail.com");
        message.setSubject("тест");
        message.setText("привет!");
        emailSender.send(message);
        saveEmail(emailDTO);
    }

    @Override
    public void saveEmail(EmailDTO emailDTO) {
        Email email = emailConverter.convert(emailDTO);
        email.setUser(userRepository.findUserById(emailDTO.getUserId()));
        email.setCustomerService(customerServiceRepository.findOneById(emailDTO.getCustomerServiceId()));
        emailRepository.save(email);
    }
}
