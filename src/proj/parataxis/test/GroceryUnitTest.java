package proj.parataxis.test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.containsString;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import parataxis.dto.Grocery;

/**
 * Created with IntelliJ IDEA.
 * User: yung5027
 * Date: 3/28/13
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class GroceryUnitTest {

    private Grocery grocery;
    private Date baseStartDate;
    private Date baseEndDate;
    private Date discountStartDate;
    private Date discountEndDate;
    private Date buyStartDate;
    private Date buyEndDate;

    @Before
    public void setUp() throws Exception {
        baseStartDate = new Date();
        baseEndDate = new Date();
        discountStartDate = new Date();
        discountEndDate = new Date();
        buyStartDate = new Date();
        buyEndDate = new Date();
        grocery = new Grocery("upc", "name", 'T', 'C', 1.23, baseStartDate, baseEndDate, 2.34, discountStartDate,
                discountEndDate, 5, 2, buyStartDate, buyEndDate, 'S');
    }

    @Test
    public void testPrint_printsCorrectly() throws Exception {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        grocery.testPrint();
        assertThat("test print line 1", outContent.toString(), containsString("UPC:upc, name: name, price: $1.23"));
        assertThat("test print line 2", outContent.toString(), containsString("Date:" + baseStartDate + " thru " + baseEndDate));
    }

    @Test
    public void printAll_printsCorrectly() throws Exception {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        grocery.printAll();
        assertThat("print all line 1", outContent.toString(), containsString("Grocery [upc=upc, name=name, type=T, category=C"));
        assertThat("print all line 2", outContent.toString(), containsString("basePrice=1.23, baseStartDate=" + baseStartDate + ", baseEndDate=" + baseEndDate));
        assertThat("print all line 3", outContent.toString(), containsString("discount=2.34, discountStartDate=" + discountStartDate + ", discountEndDate=" + discountEndDate));
        assertThat("print all line 4", outContent.toString(), containsString("buyM=5, buyN=2, buyStartDate=" + buyStartDate + ", buyEndDate=" + buyEndDate + ", salesTax=S]"));
    }
    
    @Test
    public void getName_returnsName() throws Exception {
    	String name = grocery.getName();
    	assertThat("grocery name", name, containsString("name"));
    }
    
    @Test
    public void getCategory_returnsCategory() throws Exception {
    	char category = grocery.getCategory();
    	assertTrue(category == 'C');
    }
    
    @Test
    public void getType_returnsType() throws Exception {
    	char type = grocery.getType();
    	assertTrue(type == 'T');
    }
}
