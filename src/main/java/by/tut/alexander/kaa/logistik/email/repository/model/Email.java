package by.tut.alexander.kaa.logistik.email.repository.model;

import by.tut.alexander.kaa.logistik.customerService.repository.model.CustomerService;
import by.tut.alexander.kaa.logistik.serverEmail.repostiry.Model.ServerEmail;
import by.tut.alexander.kaa.logistik.user.repository.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "email")
public class Email implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "email_id")
    private Long id;
    @Column(name = "departure_date")
    private Date date;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_service_id")
    private CustomerService customerService;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "server_email_id")
    private ServerEmail serverEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public ServerEmail getServerEmail() {
        return serverEmail;
    }

    public void setServerEmail(ServerEmail serverEmail) {
        this.serverEmail = serverEmail;
    }
}
