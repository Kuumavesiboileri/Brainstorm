/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.service;

import java.util.List;
import webref.domain.DatabRef;
import webref.domain.Viite;

/**
 *
 * @author jarlerik
 */
public interface ReferenceService {
    
    void create(DatabRef ref);
    List<DatabRef> list();

    public String getAllReferences();

    public DatabRef findById(String id);

    public DatabRef save(DatabRef ref);

    public List<DatabRef> findByTags(String tag);
    
}
