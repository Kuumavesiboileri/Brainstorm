/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.service;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webref.database.RefRepository;
import webref.domain.DatabRef;

/**
 *
 * @author jarlerik
 */
@Service
public class ReferenceServiceImpl implements ReferenceService {

    @Autowired
    private RefRepository repo;
    
    @Override
    @Transactional
    public void create(DatabRef ref) {
        repo.save(ref);
    }

    @Override
    public List<DatabRef> list() {
        return repo.findAll();
    }

    @Override
    public String getAllReferences() {
        List<DatabRef> refList = list();
        String references = "";
        for (Iterator<DatabRef> it = refList.iterator(); it.hasNext();) {
            DatabRef r = it.next();
            references += r.dataObjectToViite().toLaTexString()+"\n";
        }
        return references;
    }
    
}
