package forJaxb;

import dto.FullGuitarDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "FULL_GUITARS")
public class FullGuitars {

    private List<FullGuitarDto> fullGuitarDtos;

    public List<FullGuitarDto> getFullGuitarDtos() {
        return fullGuitarDtos;
    }

    @XmlElement(name = "FULL_GUITAR")
    public void setFullGuitarDtos(List<FullGuitarDto> fullGuitarDtos) {
        this.fullGuitarDtos = fullGuitarDtos;
    }
}