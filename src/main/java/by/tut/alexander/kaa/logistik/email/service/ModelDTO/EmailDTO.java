package by.tut.alexander.kaa.logistik.email.service.ModelDTO;

import java.util.Date;

public class EmailDTO {
    private Long id;
    private Long userId;
    private Long CustomerServiceId;
    private Date date;
    private String customerServiceName;
    private String customerServiceEmail;
    private String sendingFrom;

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
}
