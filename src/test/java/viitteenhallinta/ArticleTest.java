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
        parseri = new Parser();
        artikkeli = new Article("Tagi", "Jussi Paananen", "Suomen MM -juhlimisen herättämästä pahennuksesta vuonna 2011 ja miten se peilaa nyky-yhteiskuntaamme", "Täysin turhia tieteellisiä artikkeleita", 2012);
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
    public void testToLaTexStringWithCompulsoryVariables(){
          String oikeaLaTexRivi = "@Article(Tagi,"
                +"\nAUTHOR = {Jussi Paananen},"
                + "\nTITLE = {Suomen MM -juhlimisen her\\\"{a}tt\\\"{a}m\\\"{a}st\\\"{a} pahennuksesta vuonna 2011 ja miten se peilaa nyky-yhteiskuntaamme},"
                + "\nJOURNAL = {T\\\"{a}ysin turhia tieteellisi\\\"{a} artikkeleita},"
                + "\nYEAR = {2012},"
                + "\n)";
          assertEquals(oikeaLaTexRivi, artikkeli.toLaTexString(parseri));
    }
    @Test
    public void testToLaTexStringWithAllVariables(){
        artikkeli.setPages("158--170");
        artikkeli.setNumber(1);
        artikkeli.setMonth("jan");
        artikkeli.setNote("This is a note");
        artikkeli.setKey("This is a key");
        artikkeli.setVolume(1);
        String oikeaLaTexRivi = "@Article(Tagi,"
                +"\nAUTHOR = {Jussi Paananen},"
                + "\nTITLE = {Suomen MM -juhlimisen her\\\"{a}tt\\\"{a}m\\\"{a}st\\\"{a} pahennuksesta vuonna 2011 ja miten se peilaa nyky-yhteiskuntaamme},"
                + "\nJOURNAL = {T\\\"{a}ysin turhia tieteellisi\\\"{a} artikkeleita},"
                + "\nYEAR = {2012},"
                + "\nVOLUME = {1},"
                + "\nNUMBER = {1},"
                + "\nPAGES = {158--170},"
                + "\nMONTH = {jan},"
                + "\nNOTE = {This is a note},"
                + "\nKEY = {This is a key},"
                + "\n)";
        assertEquals(oikeaLaTexRivi, artikkeli.toLaTexString(parseri));
    }
    @Test
    public void dummyConstructorWorks(){
        Article dummy = new Article();
        assertFalse(dummy == null);
    }
    @Test
    public void settersAndGettersWork(){
       artikkeli.setAuthor("Jussi Parviainen");
       assertEquals("Jussi Parviainen", artikkeli.getAuthor());

       artikkeli.setJournal("Turha artikkeli");
       assertEquals("Turha artikkeli", artikkeli.getJournal());
       
       artikkeli.setTag("Tagi");
       assertEquals("Tagi", artikkeli.getTag());
       
       artikkeli.setTitle("Katoavaisuuden kaihoava kaihi");
       assertEquals("Katoavaisuuden kaihoava kaihi", artikkeli.getTitle());
       
       artikkeli.setNote("Nootti");
       assertEquals("Nootti", artikkeli.getNote());
       
       artikkeli.setYear(1600);
       assertEquals(1600, artikkeli.getYear()); 
       
       artikkeli.setKey("Avain");
       assertEquals("Avain", artikkeli.getKey());
       
       artikkeli.setMonth("feb");
       assertEquals("feb", artikkeli.getMonth());
       
       artikkeli.setNumber(42);
       assertEquals(42, artikkeli.getNumber());
       
       artikkeli.setPages("1--40");
       assertEquals("1--40", artikkeli.getPages());
       
       artikkeli.setVolume(12);
       assertEquals(12, artikkeli.getVolume());
    }
}
