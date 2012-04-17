/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viitteenhallinta;

import java.util.LinkedList;

/**
 *
 * @author todjalka
 */
public class Viitearkisto {

    LinkedList<Viite> lista = new LinkedList<Viite>();
    
    public void lisaaListaan(Viite viite) {
        lista.add(viite);
    }
    public String palauteViiteLista() {
        String palautettava = "";
        for(Viite viite : lista) {
            palautettava += viite.toLaTexString();
        }
        return palautettava;
    }
}
