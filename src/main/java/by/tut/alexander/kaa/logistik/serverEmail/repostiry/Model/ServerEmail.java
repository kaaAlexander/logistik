package by.tut.alexander.kaa.logistik.serverEmail.repostiry.Model;

import javax.persistence.*;

@Entity
@Table(name = "server_email")
public class ServerEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "server_email_id")
    private Long id;
    @Column(name = "server_email_login")
    private String email;
    @Column(name = "server_email_password")
    private String password;
    @Column(name = "server_email_smtp")
    private String smtp;
    @Column(name = "server_email_port")
    private Integer port;
    @Column(name = "server_ssl")
    private boolean ssl;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }
}
