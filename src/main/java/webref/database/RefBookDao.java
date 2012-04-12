/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.database;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import webref.domain.Viite;

/**
 *
 * @author jarlerik
 */
@Component
public class RefBookDao implements RefDao {
    
    private List<Viite> references;

    public RefBookDao() {
        this.references = new ArrayList<Viite>();
    }
    
    

    @Override
    public List<Viite> listAll() {
        return references;
    }

    @Override
    public void add(Viite viite) {
        references.add(viite);
    }

    public void setReferences(List<Viite> references) {
        this.references = references;
    }

    public List<Viite> getReferences() {
        return references;
    }
    
    
}
