package by.tut.alexander.kaa.logistik.email.service.ModelDTO;

import java.util.Date;

public class EmailDTO {
    private Long id;
    private Long userId;
    private Long CustomerServiceId;
    private Date date;
    private String serverEmailName;
    private String customerServiceName;
    private String customerServiceEmail;
    private String sendingFrom;
    private String subject;
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCustomerServiceId() {
        return CustomerServiceId;
    }

    public void setCustomerServiceId(Long customerServiceId) {
        CustomerServiceId = customerServiceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerServiceName() {
        return customerServiceName;
    }

    public void setCustomerServiceName(String customerServiceName) {
        this.customerServiceName = customerServiceName;
    }

    public String getCustomerServiceEmail() {
        return customerServiceEmail;
    }

    public void setCustomerServiceEmail(String customerServiceEmail) {
        this.customerServiceEmail = customerServiceEmail;
    }

    public String getSendingFrom() {
        return sendingFrom;
    }

    public void setSendingFrom(String sendingFrom) {
        this.sendingFrom = sendingFrom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getServerEmailName() {
        return serverEmailName;
    }

    public void setServerEmailName(String serverEmailName) {
        this.serverEmailName = serverEmailName;
    }
}
