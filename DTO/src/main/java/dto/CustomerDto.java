package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CUSTOMER")
public class CustomerDto {

    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String login;
    private String pass;
    private Integer statusId;

    public Integer getCustomerId() {
        return customerId;
    }

    @XmlAttribute(name = "customer_id")
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement(name = "first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement(name = "last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement(name = "email")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    @XmlElement(name = "phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    @XmlElement(name = "login")
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    @XmlElement(name = "pass")
    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getStatusId() {
        return statusId;
    }

    @XmlElement(name = "status_id")
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
}
