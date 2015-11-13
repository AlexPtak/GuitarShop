package mysql;

import dao.GuitarDao;
import org.junit.Before;
import org.junit.Test;

public class MySqlGuitarDaoTest {

    private GuitarDao guitarDao;

    @Before
    public void setUp() throws Exception {
        guitarDao = new MySqlGuitarDao();
    }

    @Test
    public void testSearchByDtoFilter() throws Exception {

    }
}