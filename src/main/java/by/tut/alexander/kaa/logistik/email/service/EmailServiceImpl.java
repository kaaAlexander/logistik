package by.tut.alexander.kaa.logistik.email.service;

import by.tut.alexander.kaa.logistik.customerService.repository.CustomerServiceRepository;
import by.tut.alexander.kaa.logistik.customerService.service.CustomerServiceService;
import by.tut.alexander.kaa.logistik.customerService.service.modelDTO.CustomerServiceDTO;
import by.tut.alexander.kaa.logistik.email.repository.EmailRepository;
import by.tut.alexander.kaa.logistik.email.repository.model.Email;
import by.tut.alexander.kaa.logistik.email.service.ModelDTO.EmailDTO;
import by.tut.alexander.kaa.logistik.email.service.utill.EmailConverter;
import by.tut.alexander.kaa.logistik.serverEmail.repostiry.ServerEmailRepository;
import by.tut.alexander.kaa.logistik.serverEmail.service.ServerEmailService;
import by.tut.alexander.kaa.logistik.serverEmail.service.modelDTO.ServerEmailDTO;
import by.tut.alexander.kaa.logistik.user.repository.UserRepository;
import by.tut.alexander.kaa.logistik.user.service.UserService;
import by.tut.alexander.kaa.logistik.user.service.modelDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
import java.util.*;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private ServerEmailService serverEmailService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerServiceService customerService;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private ServerEmailRepository serverEmailRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerServiceRepository customerServiceRepository;

    private EmailConverter emailConverter = new EmailConverter();
    private Integer count = 0;
    private String emailFrom;
    private Long serverEmailId;
    private String serverEmailName;


    private JavaMailSender getServerEmail() {
        List<ServerEmailDTO> serverEmailDTOList = serverEmailService.getAllServerEmail();
        if (count == serverEmailDTOList.size()) {
            count = 0;
        }
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        ServerEmailDTO serverEmailDTO = serverEmailDTOList.get(count);
        mailSender.setHost(serverEmailDTO.getSmtp());
        mailSender.setPort(serverEmailDTO.getPort());
        mailSender.setUsername(serverEmailDTO.getEmail());
        mailSender.setPassword(serverEmailDTO.getPassword());
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.ssl.enable", serverEmailDTO.isSsl());
        count = count + 1;
        serverEmailName = serverEmailDTO.getEmail();
        emailFrom = serverEmailDTO.getEmail();
        serverEmailId = serverEmailDTO.getId();
        return mailSender;
    }

    @Override
    public boolean sendEmail(Long userId, Long customerServiceId, MultipartFile[] files, EmailDTO emailDTO) {
        String subject;
        String text;
        boolean status = true;
        TimeZone.setDefault(TimeZone.getTimeZone("UTC+3"));
        emailDTO.setDate(new Date());
        emailDTO.setUserId(userId);
        UserDTO userDTO = userService.getUserById(userId);
        subject = ("Компания : " + userDTO.getCompanyName() + "    \n" + "УНП : " + userDTO.getUnp() +
                "    \n" + "ФИО : " + userDTO.getName() + "    \n" + emailDTO.getSubject());
        text = subject + "\n" + "Email : " + userDTO.getEmail() + "\n" + "Телефон : " + userDTO.getPhoneNumber() +
                "\n" + emailDTO.getText();
        CustomerServiceDTO customerServiceDTO = customerService.getCustomerServiceById(customerServiceId);
        JavaMailSender mailSender = getServerEmail();
        emailDTO.setCustomerServiceId(customerServiceId);
        emailDTO.setServerEmailName(serverEmailName);
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            message.setHeader("Disposition-Notification-To", userDTO.getEmail());
            message.setFrom(emailFrom);
            helper.setTo(customerServiceDTO.getCustomerServiceEmail());
            helper.setCc(userDTO.getEmail());
            helper.setCc(emailFrom);
            for (MultipartFile file : files) {
                helper.addAttachment(file.getOriginalFilename(), file);
            }
            helper.setSubject(subject);
            helper.setText(text);
            mailSender.send(message);
            saveEmail(emailDTO);
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    @Override
    public void saveEmail(EmailDTO emailDTO) {
        Email email = emailConverter.convert(emailDTO);
        email.setUser(userRepository.findUserById(emailDTO.getUserId()));
        email.setCustomerService(customerServiceRepository.findOneById(emailDTO.getCustomerServiceId()));
        email.setServerEmailName(emailDTO.getServerEmailName());
        emailRepository.save(email);
    }

    @Override
    public List<EmailDTO> getAllEmailByUserId(Long id) {
        List<Email> emailList = emailRepository.findAllByUserId(id);
        List<EmailDTO> emailDTOList = new ArrayList<>();
        for (Email email : emailList) {
            EmailDTO emailDTO = emailConverter.convert(email);
            emailDTOList.add(emailDTO);
        }
        return emailDTOList;
    }
}
