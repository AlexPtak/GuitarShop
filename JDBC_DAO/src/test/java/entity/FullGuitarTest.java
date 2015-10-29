package entity;

import dto.FullGuitarDto;
import org.junit.Before;
import org.junit.Test;

public class FullGuitarTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCreateFullGuitarDto() throws Exception {
        FullGuitarDto guitarDto = new FullGuitar().createFullGuitarDto(1);
        System.out.println(guitarDto.toString());
    }
}