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
public class ArticleTest {
    private Parser parseri;
    private Article artikkeli;
    private String oikeaRivi;
    
    public ArticleTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        artikkeli = new Article("Tagi", "Jussi Paananen", "Suomen MM -juhlimisen herättämästä pahennuksesta vuonna 2011 ja miten se peilaa nyky-yhteiskuntaamme", "Täysin turhia tieteellisiä artikkeleita", 2012, parseri);
        parseri = new Parser();
        oikeaRivi = "Author: Jussi Paananen"
                + "\nTitle: Suomen MM -juhlimisen herättämästä pahennuksesta vuonna 2011 ja miten se peilaa nyky-yhteiskuntaamme"
                + "\nJournal: Täysin turhia tieteellisiä artikkeleita"
                + "\nYear: 2012";
    }
        //volume, number, pages, month, note, key
    @After
    public void tearDown() {
    }
    
    @Test
    public void constructorWorks(){
        assertEquals(oikeaRivi, artikkeli.toReadableString());
    }
    
    @Test
    public void testSetVolume(){
        artikkeli.setVolume(1);
        oikeaRivi += "\nVolume: 1";
        assertEquals(oikeaRivi, artikkeli.toReadableString());
    }
    
    @Test
    public void testSetVolumeAndPages(){
        artikkeli.setPages("158--170");
        artikkeli.setVolume(1);
        oikeaRivi += "\nVolume: 1\nPages: 158--170";
        assertEquals(oikeaRivi, artikkeli.toReadableString());                
    }
    
    @Test
    public void testWithAllSetters(){
        artikkeli.setPages("158--170");
        artikkeli.setNumber(1);
        artikkeli.setMonth("jan");
        artikkeli.setNote("This is a note");
        artikkeli.setKey("This is a key");
        artikkeli.setVolume(1);
        oikeaRivi += "\nVolume: 1"
                + "\nNumber: 1"
                + "\nPages: 158--170"
                + "\nMonth: jan"
                + "\nNote: This is a note"
                + "\nKey: This is a key";
        assertEquals(oikeaRivi, artikkeli.toReadableString());
    }
    @Test
    public void testToLaTexString(){
        artikkeli.setPages("158--170");
        artikkeli.setNumber(1);
        artikkeli.setMonth("jan");
        artikkeli.setNote("This is a note");
        artikkeli.setKey("This is a key");
        artikkeli.setVolume(1);
        oikeaRivi += "@Book(Tagi,"
                + "\nVOLUME = {1},"
                + "\nNUMBER ={1},"
                + "\nPAGES = {158--170},"
                + "\nMONTH = {jan},"
                + "\nNOTE = {This is a note},"
                + "\nKEY = {This is a key},\n";
        System.out.println(oikeaRivi);
        System.out.println(artikkeli.toLaTexString());
        assertEquals(oikeaRivi, artikkeli.toLaTexString());
    }
    

}
