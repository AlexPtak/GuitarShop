package forJaxb;

import dto.GuitarTypeDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "GUITAR_TYPES")
public class GuitarTypes {

    private List<GuitarTypeDto> guitarTypeDtos;

    public List<GuitarTypeDto> getGuitarTypeDtos() {
        return guitarTypeDtos;
    }

    @XmlElement(name = "GUITAR_TYPE")
    public void setGuitarTypeDtos(List<GuitarTypeDto> guitarTypeDtos) {
        this.guitarTypeDtos = guitarTypeDtos;
    }
}
