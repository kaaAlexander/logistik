package by.tut.alexander.kaa.logistik.customerService.service.modelDTO;

/**
 * Created by GM on 30.08.2018.
 */
public class CustomerServiceDTO {
    private Long id;
    private String customerServiceName;
    private String customerServiceEmail;
    private Long exitPointId;

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
}
