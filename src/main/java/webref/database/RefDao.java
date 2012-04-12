/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.database;

import java.util.List;
import webref.domain.Viite;

/**
 *
 * @author jarlerik
 */
public interface RefDao {
    List<Viite> listAll();
    void add(Viite viite);
}
