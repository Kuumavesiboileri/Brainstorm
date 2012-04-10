/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viitteenhallinta;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author atteaalt
 */
public class ParserTest {
    
    Parser parser;
    
    public ParserTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        parser = new Parser();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void aStringWithNothingToEdit(){
        String originalText = "Satunnaista kirjoittelua";
        String parsedText = parser.parse(originalText);
        assertEquals(originalText, parsedText);
    }
    @Test
    public void aStringWithÄs(){
        String originalText = "Äääh";
        String verrattava = "\\\"{A}\\\"{a}\\\"{a}h";
        String parsedText = parser.parse(originalText);
        assertEquals(verrattava, parsedText);
    }
    @Test
    public void allSpecialCharactersInARow(){
        String originalText = "ÄäÒòÓóÖöÕõÅåÆæØøß";
        String verrattava = "\\\"{A}\\\"{a}\\`{O}\\`{o}\\´{O}\\´{o}\\\"{O}\\\"{o}\\~{O}\\~{o}\\AA\\aa\\AE\\ae\\O\\o\\ss";

        String parsedText = parser.parse(originalText);
        assertEquals(verrattava, parsedText);
    }
    @Test
    public void specialCharactersInTheBeginningAndEndOfATextString(){
        String originalText = "ÄäabcdefghijÖö";
        String verrattava = "\\\"{A}\\\"{a}abcdefghij\\\"{O}\\\"{o}";
        String parsedText = parser.parse(originalText);
        assertEquals(verrattava, parsedText);
    }
    @Test
    public void specialCharactersInTheMiddleOfATextString(){
        String originalText = "abcdÅåÅdcba";
        String verrattava = "abcd\\AA\\aa\\AAdcba";
        String parsedText = parser.parse(originalText);
        assertEquals(verrattava, parsedText);
    }
}
