package services;

import org.junit.Before;
import org.junit.Test;

public class GetParameterValuesTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetCatalogInXml() throws Exception {
        GetParameterValues getParameterValues = new GetParameterValues();
        System.out.println(getParameterValues.getCatalogInXml());
    }

    @Test
    public void testGetSingleInstanseFromCatalogById() throws Exception {

    }
}