/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viitteenhallinta;

import org.junit.*;
import static org.junit.Assert.*;
import webref.domain.*;

/**
 *
 * @author todjalka
 */
public class BookTest {

    private Parser parseri;
    private Book kirja;
    private String oikeaRivi;

    public BookTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        parseri = new Parser();
        kirja = new Book("Tagi1", "Pertti Kananen", "Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa", "WSOY", 1995, parseri);
        oikeaRivi = "Author: Pertti Kananen"
                + "\nTitle: Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa"
                + "\nPublisher: WSOY"
                + "\nYear: 1995";
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setVolume method, of class Book.
     */
    @Test
    public void testSetVolume() {
        kirja.setVolume(12);
        String saatuRivi = kirja.toReadableString();
        oikeaRivi += "\nVolume: 12";
        assertEquals(oikeaRivi, saatuRivi);
    }

    /**
     * Test of setSeries method, of class Book.
     */
    @Test
    public void testSetSeries() {
        kirja.setSeries("Ufot tarjosi kaakaon");
        String saatuRivi = kirja.toReadableString();
        oikeaRivi += "\nSeries: Ufot tarjosi kaakaon";
        assertEquals(oikeaRivi, saatuRivi);
    }

    @Test
    public void testWithMultipleSetters() {
        kirja.setAddress("Kalmankuja 13");
        kirja.setEdition("Thirteenth");
        kirja.setNote("This is a note");
        kirja.setMonth("jan");
        oikeaRivi += "\nAddress: Kalmankuja 13\n"
                + "Edition: Thirteenth\n"
                + "Month: jan\n"
                + "Note: This is a note";
        String saatuRivi = kirja.toReadableString();
        assertEquals(oikeaRivi, saatuRivi);
    }

    @Test
    public void anotherTestWithMultipleSetters() {
        kirja.setKey("This is a key");
        kirja.setVolume(4);
        kirja.setAddress("Mannerheimintie 1");
        oikeaRivi += "\nVolume: 4\nAddress: Mannerheimintie 1\nKey: This is a key";
        String saatuRivi = kirja.toReadableString();
        assertEquals(oikeaRivi, saatuRivi);
    }

    @Test
    public void testToLaTexString() {
        oikeaRivi = "@Book(Tagi1,"
                + "\nAUTHOR = {Pertti Kananen},"
                + "\nTITLE = {Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa},"
                + "\nPUBLISHER = {WSOY},"
                + "\nYEAR = {1995},\n)";
        String saatuRivi = kirja.toLaTexString();
        assertEquals(oikeaRivi, saatuRivi);
    }

    @Test
    public void testToLaTexStringWithOptionals() {
        oikeaRivi = "@Book(Tagi1,"
                + "\nAUTHOR = {Pertti Kananen},"
                + "\nTITLE = {Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa},"
                + "\nPUBLISHER = {WSOY},"
                + "\nYEAR = {1995},"
                + "\nVOLUME = {3},"
                + "\nSERIES = {LOTR},"
                + "\nADDRESS = {Porttipuisto 96},"
                + "\nEDITION = {Special},"
                + "\nMONTH = {feb},"
                + "\nNOTE = {Death},"
                + "\nKEY = {This is a key},\n)";
        
        kirja.setAddress("Porttipuisto 96");
        kirja.setVolume(3);
        kirja.setSeries("LOTR");
        kirja.setMonth("feb");
        kirja.setEdition("Special");
        kirja.setNote("Death");
        kirja.setKey("This is a key");
        String saatuRivi = kirja.toLaTexString();
        assertEquals(oikeaRivi, saatuRivi);
    }
}
