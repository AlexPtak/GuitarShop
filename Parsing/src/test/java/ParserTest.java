import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
    public void testCreatePidisko() throws Exception {
        parser.createPidisko();
    }

    @Test
    public void testDomParser() throws Exception {
        parser.DomParser();
    }
}