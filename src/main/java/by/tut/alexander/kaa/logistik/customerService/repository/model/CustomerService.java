package by.tut.alexander.kaa.logistik.customerService.repository.model;

import by.tut.alexander.kaa.logistik.exitPoint.repository.Model.ExitPoint;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

/**
 * Created by GM on 30.08.2018.
 */
@Entity
@Table(name = "customer_service")
public class CustomerService implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "customer_service_id")
    private Long id;
    @Column(name = "customer_service_name")
    private String customerServiceName;
    @Column(name = "customer_service_email")
    @Email
    private String customerServiceEmail;
    @ManyToOne
    @JoinColumn(name = "exit_point_id")
    private ExitPoint exitPoint;

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

    public ExitPoint getExitPoint() {
        return exitPoint;
    }

    public void setExitPoint(ExitPoint exitPoint) {
        this.exitPoint = exitPoint;
    }
}
