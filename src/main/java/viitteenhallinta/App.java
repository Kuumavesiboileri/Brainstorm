package viitteenhallinta;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Parser parseri = new Parser();
        //Book kirjanen = new Book("herp", "Pertti Kananen", "Miksi paska on jännää", "WSOY", 1995, parseri);
        Book kirjanen = new Book("Tagi1", "Pertti Kananen", "Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa", "WSOY", 1995, parseri);
        //kirjanen.setAddress("Kaunakuja 133");
        Article artikkeli = new Article("arg", "Pertti Kananen" , "Kananlento", "mah journal", 122, parseri);
        System.out.println(artikkeli.toLaTexString());
        System.out.println(kirjanen.toReadableString());
        System.out.println(kirjanen.toLaTexString());
    }
}
