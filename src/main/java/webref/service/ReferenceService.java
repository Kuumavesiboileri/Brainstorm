/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webref.database.RefArticleDao;
import webref.database.RefBookDao;
import webref.database.RefDao;
import webref.domain.Viite;

/**
 *
 * @author jarlerik
 */
@Service
public class ReferenceService {
    
    private RefDao refBookDao;
    private RefDao refArticleDao;

    @Autowired
    public ReferenceService(RefBookDao refBookDao, RefArticleDao refArticleDao) {
        this.refBookDao = refBookDao;
        this.refArticleDao = refArticleDao;
    }
    
    public boolean addBook(Viite viite) {
        refBookDao.add(viite);
        return true;
    }
    public boolean addArticle(Viite viite) {
        refArticleDao.add(viite);
        return true;
    }
    public List<Viite> getBooks() {
        return refBookDao.listAll();
    }
    public List<Viite> getArticles() {
        return refArticleDao.listAll();
    }


    
}
