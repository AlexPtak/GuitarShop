package myUtils;

import org.junit.Test;

public class GuitarShopExceptionTest {

    @Test
    public void testGetXmlMassage() {
        try {
            throw new GuitarShopException("sdfsdf");
        } catch (GuitarShopException e) {
            System.out.println(e.getXmlMassage());
        }
    }
}