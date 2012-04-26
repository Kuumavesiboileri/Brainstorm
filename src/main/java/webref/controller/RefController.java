/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import webref.domain.DatabRef;
import webref.domain.Viite;
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
        List<DatabRef> result = refService.list();
        model.addAttribute("references", refService.list());
        model.addAttribute("size", result.size());
        model.addAttribute("ref", new DatabRef());
            
        return "home";
    }
    @RequestMapping(value="addRef", method=RequestMethod.POST)
    public String addReference(Model model,@Valid @ModelAttribute("ref") DatabRef ref, BindingResult result) {
        if(result.hasErrors()) 
            return "home";
        refService.create(ref);
        return "redirect:/";
    }
     @RequestMapping(value="bibtex", method=RequestMethod.GET)
    public String getBibtex(Model model, HttpServletResponse response ) throws IOException {
         response.setContentType("application/octet-stream");
         response.setHeader("Content-Disposition","attachment;filename=bibtex.bib");
        StringBuilder sb = new StringBuilder(refService.getAllReferences());
        InputStream in = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));
        ServletOutputStream out = response.getOutputStream();
        byte[] outputByte = new byte[4096];
        //copy binary contect to output stream
        while(in.read(outputByte, 0, 4096) != -1)
        {
                out.write(outputByte, 0, 4096);
        }
        in.close();
        out.flush();
        out.close();
        return "redirect:/";
    }
     @RequestMapping(value="addTags" ,method= RequestMethod.POST)
     public String addTags(@RequestParam String id, @RequestParam String newTag) {
         DatabRef ref = refService.findById(id);         
         ref.setTags(newTag);
         refService.save(ref);
         return "redirect:/";
     }
     @RequestMapping(value="search", method= RequestMethod.POST)
     public String search(@RequestParam String etsi, Model model) {
         System.out.println(etsi);
         List<DatabRef> result = refService.findBySearchWords(etsi);
         model.addAttribute("ref", new DatabRef());
         model.addAttribute("references", result);
         model.addAttribute("size", result.size());
         return "home";
     }
}

