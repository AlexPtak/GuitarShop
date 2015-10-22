package forJaxb;

import dto.GuitarBrandDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "GUITAR_BRANDS")
public class GuitarBrands {

    private List<GuitarBrandDto> guitarBrandDtos;

    public List<GuitarBrandDto> getGuitarBrandDtos() {
        return guitarBrandDtos;
    }

    @XmlElement(name = "GUITAR_BRAND")
    public void setGuitarBrandDtos(List<GuitarBrandDto> guitarBrandDtos) {
        this.guitarBrandDtos = guitarBrandDtos;
    }
}
