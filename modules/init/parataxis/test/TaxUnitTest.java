package parataxis.test;

import org.junit.Before;
import org.junit.Test;

import parataxis.dto.Tax;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

/**
 * Created with IntelliJ IDEA.
 * User: yung5027
 * Date: 3/28/13
 * Time: 3:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaxUnitTest {
    private Tax tax;
    private Date startDate;
    private Date endDate;

    @Before
    public void setUp() throws Exception {
        startDate = new Date();
        endDate = new Date();
        tax = new Tax(1.23, startDate, endDate);
    }

    @Test
    public void testPrint_printsCorrectly() throws Exception {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        tax.testPrint();
        assertThat("test print", outContent.toString(), containsString("TaxRate: 1.23, startDate: " + startDate + ", endDate: " + endDate));
    }
}
