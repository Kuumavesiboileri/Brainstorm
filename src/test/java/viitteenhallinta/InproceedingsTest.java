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
public class InproceedingsTest {
    
    Parser parseri;
    Inproceedings inpro;
    String oikeaRivi;
    
    public InproceedingsTest() {
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
        inpro = new Inproceedings("Tagi1", "Pertti Kananen", "Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa", "Hieno kirja", 1995, parseri);
        oikeaRivi = "Author: Pertti Kananen"
                + "\nTitle: Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa"
                + "\nBooktitle: Hieno kirja"
                + "\nYear: 1995";
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void constructorWorks(){
        assertEquals(oikeaRivi, inpro.toReadableString());
    }
    @Test
    public void testSetEditor(){
        oikeaRivi += "\nEditor: Los Cojones";
        inpro.setEditor("Los Cojones");
        assertEquals(oikeaRivi, inpro.toReadableString());
        
    }
    @Test
    public void testWithAllSetters(){
        oikeaRivi += "\nEditor: Hannu Karpo"
                + "\nVolume: 1"
                + "\nSeries: Ixnay on the Hombre"
                + "\nPages: 12--34"
                + "\nAddress: Burbon Street"
                + "\nMonth: jan"
                + "\nOrganization: Umberella corp."
                + "\nPublisher: WSOY"
                + "\nNote: This is a Note"
                + "\nKey: This is a Key";
        
        inpro.setAddress("Burbon Street");
        inpro.setEditor("Hannu Karpo");
        inpro.setVolume(1);
        inpro.setKey("This is a Key");
        inpro.setMonth("jan");
        inpro.setNote("This is a Note");
        inpro.setOrganization("Umberella corp.");
        inpro.setPages("12--34");
        inpro.setPublisher("WSOY");
        inpro.setSeries("Ixnay on the Hombre");
        inpro.setVolume(1);

        assertEquals(oikeaRivi, inpro.toReadableString());
    }
    @Test
    public void testToLaTexStringWithCompulsoryVariables(){
        String oikeaLaTexRivi = "@InProceedings(Tagi1,"
                + "\nAUTHOR = {Pertti Kananen},"
                + "\nTITLE = {Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa},"
                + "\nBOOKTITLE = {Hieno kirja},"
                + "\nYEAR = {1995},"
                + "\n)";

        assertEquals(oikeaLaTexRivi, inpro.toLaTexString());
    }
    @Test
    public void testToLaTexStringWithAllVariables(){
        String oikeaLaTexRivi = "@InProceedings(Tagi1,"
                + "\nAUTHOR = {Pertti Kananen},"
                + "\nTITLE = {Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa},"
                + "\nBOOKTITLE = {Hieno kirja},"
                + "\nYEAR = {1995},"
                + "\nEDITOR = {Hannu Karpo},"
                + "\nVOLUME = {1},"
                + "\nSERIES = {Ixnay on the Hombre},"
                + "\nPAGES = {12--34},"
                + "\nADDRESS = {Burbon Street},"
                + "\nMONTH = {jan},"
                + "\nORGANIZATION = {Umberella corp.},"
                + "\nPUBLISHER = {WSOY},"
                + "\nNOTE = {This is a Note},"
                + "\nKEY = {This is a Key},"
                + "\n)";
                inpro.setAddress("Burbon Street");
        inpro.setEditor("Hannu Karpo");
        inpro.setVolume(1);
        inpro.setKey("This is a Key");
        inpro.setMonth("jan");
        inpro.setNote("This is a Note");
        inpro.setOrganization("Umberella corp.");
        inpro.setPages("12--34");
        inpro.setPublisher("WSOY");
        inpro.setSeries("Ixnay on the Hombre");
        inpro.setVolume(1);

        assertEquals(oikeaLaTexRivi, inpro.toLaTexString());
    }
}
