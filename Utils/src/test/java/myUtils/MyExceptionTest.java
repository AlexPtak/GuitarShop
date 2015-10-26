package myUtils;

import org.junit.Test;

public class MyExceptionTest {

    @Test
    public void testGetXmlMassage() {
        try {
            throw new MyException("my exception!");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}