package init.parataxis.test;

import org.junit.Before;
import org.junit.Test;

import parataxis.dto.Customer;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

/**
 * Created with IntelliJ IDEA.
 * User: yung5027
 * Date: 3/28/13
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerUnitTest {
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer('T', 1234567890, 1.23);
    }

    @Test
    public void testPrint_printsCorrectly() throws Exception {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        customer.testPrint();
        assertThat("print message", outContent.toString(), containsString("Type: T, num: 1234567890, balance: 1.23"));
    }
}
