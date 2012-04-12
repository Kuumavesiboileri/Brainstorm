/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.database;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import webref.domain.Article;
import webref.domain.Viite;

/**
 *
 * @author jarlerik
 */
@Component
public class RefArticleDao implements RefDao {
    private List<Viite> articles;

    public RefArticleDao() {
        this.articles = new ArrayList<Viite>();
    }
    
    

    @Override
    public List<Viite> listAll() {
        return articles;
    }

    @Override
    public void add(Viite viite) {
        articles.add(viite);
    }
    
}
