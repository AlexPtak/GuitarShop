package mysql;

import dao.GuitarStatusDao;
import entity.GuitarStatus;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MySqlGuitarStatusDaoTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSearchById() throws Exception {

    }

    @Test
    public void testGetStatusById() throws Exception {
        GuitarStatusDao guitarStatus = new MySqlGuitarStatusDao();
        System.out.println(guitarStatus.getStatusById(1));
    }

    @Test
    public void testGetAll() throws Exception {

    }
}