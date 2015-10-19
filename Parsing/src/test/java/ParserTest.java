import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ParserTest {

    Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
    @Ignore
    public void testCreatePidisko() throws Exception {
        parser.createPidisko();
    }

    @Test
    @Ignore
    public void testDomParser() throws Exception {
        parser.DomParser();
    }
}