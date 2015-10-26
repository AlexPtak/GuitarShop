package forJaxb;

import dto.CustomerDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "CUSTOMERS")
public class Customers {

    private List<CustomerDto> customerDtos;

    public List<CustomerDto> getCustomerDtos() {
        return customerDtos;
    }

    @XmlElement(name = "CUSTOMER")
    public void setCustomerDtos(List<CustomerDto> customerDtos) {
        this.customerDtos = customerDtos;
    }
}
