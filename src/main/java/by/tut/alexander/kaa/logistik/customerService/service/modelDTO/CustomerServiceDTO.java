package by.tut.alexander.kaa.logistik.customerService.service.modelDTO;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by GM on 30.08.2018.
 */
public class CustomerServiceDTO {
    private Long id;
    private String customerServiceName;
    private String customerServiceEmail;
    private Long exitPointId;
    private Long emailCount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date byDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getExitPointId() {
        return exitPointId;
    }

    public void setExitPointId(Long exitPointId) {
        this.exitPointId = exitPointId;
    }

    public Long getEmailCount() {
        return emailCount;
    }

    public void setEmailCount(Long emailCount) {
        this.emailCount = emailCount;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getByDate() {
        return byDate;
    }

    public void setByDate(Date byDate) {
        this.byDate = byDate;
    }
}
