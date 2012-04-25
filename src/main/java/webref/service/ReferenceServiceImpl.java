/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webref.database.RefRepository;
import webref.domain.DatabRef;
import webref.domain.Parser;

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
            references += r.dataObjectToViite().toLaTexString(new Parser())+"\n";
        }
        return references;
    }

    @Override
    public DatabRef findById(String id) {
        long idl = Long.parseLong(id);
        return repo.findOne(idl);
        
    }

    @Override
    public DatabRef save(DatabRef ref) {
        return repo.save(ref);
    }

    @Override
    public List<DatabRef> findBySearchWords(String tag) {
        List<DatabRef> all = repo.findAll();
        
        List<DatabRef> result = new ArrayList<DatabRef>();
        Iterator itr = all.iterator();
        while(itr.hasNext()) {
            DatabRef ref = (DatabRef) itr.next();
            if(ref.searchWordsFound(tag)) {
                result.add(ref);
            }
        }
        return result;
    }
    
}
