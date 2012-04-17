/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import webref.domain.Article;
import webref.domain.Book;
import webref.domain.DatabRef;
import webref.service.ReferenceService;

/**
 *
 * @author jarlerik
 */
@Controller
public class RefController {
    
    @Autowired
    private ReferenceService refService;
    
    @RequestMapping(value="/")
    public String home(Model model) {        
//        Book book = new Book("Tagi1", "Pertti Kananen", "Ergonomisten hammastikkujen historia ja vaikutus talouspolitiikaan 1800 -luvun Ruotsi-Suomessa", "WSOY", 1995, new Parser());
//        refService.addReference(book);
//        Article article = new Article("Tagi", "Jussi Paananen", "Suomen MM -juhlimisen herattamasta pahennuksesta vuonna 2011 ja miten se peilaa nyky-yhteiskuntaamme", "Taysin turhia tieteellisia artikkeleita", 2012, new Parser());
//        refService.addReference(article);
        model.addAttribute("references", refService.list());
        return "home";
    }
    @RequestMapping(value="addRef", method=RequestMethod.POST)
    public String addBook(Model model, @ModelAttribute DatabRef ref) {
        refService.create(ref);
        return "redirect:/";
    }
}
