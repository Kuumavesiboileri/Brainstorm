package viitteenhallinta;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Parser parseri = new Parser();
        //Book kirjanen = new Book("herp", "Pertti Kananen", "Miksi paska on jännää", "WSOY", 1995, parseri);
        Book kirjanen = new Book("Tagi1", "Pertti Känänen", "Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa", "WSOY", 1995, parseri);
        //kirjanen.setAddress("Kaunakuja 133");
     
        Viitearkisto arkisto = new Viitearkisto();
        arkisto.lisaaListaan(kirjanen);
        Generaattori generator = new Generaattori(arkisto);
        generator.generoiBibTex("viitteet.bib");
        
    }
}
