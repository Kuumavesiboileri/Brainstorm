/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viitteenhallinta;

import java.io.*;

/**
 *
 * @author todjalka
 */
public class Generaattori {

    private Viitearkisto arkisto;

    public Generaattori(Viitearkisto arkisto) {
        this.arkisto = arkisto;
    }

    private String viiteLista() {
        String palautettava = arkisto.palauteViiteLista();
        return palautettava;
    }

    public void generoiBibTex(String nimi) throws IOException {
        if(nimi.equals("")) {
            nimi = "viitteet.bib";
        }
        try {
            FileWriter outFile = new FileWriter(nimi);
            PrintWriter out = new PrintWriter(outFile);
            out.println(viiteLista());
            out.close();
        } catch (IOException e) {
             e.printStackTrace();
        }

    }
}
