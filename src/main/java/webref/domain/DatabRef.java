/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.xerces.impl.dv.xs.MonthDV;
import org.apache.xerces.impl.dv.xs.YearDV;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 *
 * @author jarlerik
 */
@Entity
public class DatabRef implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }/*
     * book fields
     * Required fields: tag, author, title, publisher, year
     * Optional fields: volume, series, address, edition, month, note, key
     *
     * 
     * article fields
     * Required fields: author, title, journal, year
     * Optional fields: volume, number, pages, month, note, key
     * 
     * 
     * inproceeding fields
     * Required fields: author, title, booktitle, year
     * Optional fields: editor, volume, series, pages, address, month, organization, publisher, note, key
    */
    private String type;
    private String refName;
    private String author;
    private String title;
    private String book_publisher;
    private String inpro_publisher;
    @NotNull(message="a year must be given")
    @Pattern(regexp="[1-2][0-9][0-9][0-9]", message="a year must be between 1000-2999")
    private String ref_year;
    private int volume;
    private String series;
    private String address;
    private String edition;
    private String ref_month;
    private String note;
    private String ref_key;
    
    private String journal;
    private int number;
    private String pages;
    
    private String booktitle;
    private String editor;
    private String organization;
    private List<String> searchWords = new ArrayList<String>();;
    private List<String> tags = new ArrayList<String>();
    
    public Viite dataObjectToViite() {
        if(type.equals("book")) {
            Book book = new Book(refName,author,title,book_publisher, Integer.parseInt(ref_year),volume,series,address,edition,ref_month,note,ref_key);
        return book;
        }
        else if(type.equals("article")) {
            Article article = new Article(refName, author,title,journal,Integer.parseInt(ref_year), volume,number,pages,ref_month,note,ref_key);
        return article;
        }
        else if(type.equals("inproceedings")) {
            Inproceedings inproceeding = new Inproceedings(refName,author,title,booktitle,Integer.parseInt(ref_year),editor,volume,series,pages,address,ref_month,organization,inpro_publisher,note,ref_key);
            return inproceeding;
        }
        else return null;
        
    }

    public boolean searchWordsFound(String lol) {
        Iterator itworks= searchWords.iterator();
        while(itworks.hasNext()) {
            String comparable =(String) itworks.next();
            if(comparable.contains(lol)) {
                return true;
            }
        }
        return false;
    }

    private void addToSearchWords(String adding) {
        searchWords.add(adding);
    }

    public String getType() {
        return type;
    }
    
        

    public String getAddress() {
        return address;
    }

    public String getAuthor() {
        return author;
    }

    public String getEdition() {
        return edition;
    }

    public String getRef_key() {
        return ref_key;
    }

    public String getRef_month() {
        return ref_month;
    }

    public String getNote() {
        return note;
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    public String getInpro_publisher() {
        return inpro_publisher;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getSeries() {
        return series;
    }

    public String getTag() {
        return refName;
    }

    public String getTitle() {
        return title;
    }

    public int getVolume() {
        return volume;
    }

    public String getRef_year() {
        return ref_year;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public String getEditor() {
        return editor;
    }

    public String getOrganization() {
        return organization;
    }

    public void setType(String type) {
        this.type = type;
        addToSearchWords(type);
    }
    
    public boolean tagFound(String name) {
        return tags.contains(name);
    }
    public void setAddress(String address) {
        this.address = address;
        addToSearchWords(address);
    }

    public void setAuthor(String author) {
        this.author = author;
        addToSearchWords(author);
    }

    public void setEdition(String edition) {
        this.edition = edition;
        addToSearchWords(edition);
    }

    public void setRef_key(String ref_key) {
        this.ref_key = ref_key;
        addToSearchWords(ref_key);
    }

    public void setRef_month(String ref_month) {
        this.ref_month = ref_month;
        addToSearchWords(ref_month);
    }    

    public void setNote(String note) {
        this.note = note;
        addToSearchWords(note);
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
        addToSearchWords(book_publisher);
    }

    public void setInpro_publisher(String inpro_publisher) {
        this.inpro_publisher = inpro_publisher;
        addToSearchWords(inpro_publisher);
    }

    

    public void setSeries(String series) {
        this.series = series;
        addToSearchWords(series);
    }

    public void setTag(String tag) {
        this.refName = tag;
        addToSearchWords(tag);
    }

    public void setTitle(String title) {
        this.title = title;
        addToSearchWords(title);
    }

    public void setVolume(int volume) {
        this.volume = volume;
        addToSearchWords(""+volume);
    }

    public void setRef_year(String ref_year) {
        this.ref_year = ref_year;
        addToSearchWords(ref_year);
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
        addToSearchWords(booktitle);
    }

    public void setEditor(String editor) {
        this.editor = editor;
        addToSearchWords(editor);
    }

    public void setOrganization(String organization) {
        this.organization = organization;
        addToSearchWords(organization);
    }

    public void setTags(String tags) {
        this.tags.add(tags);
        addToSearchWords(tags);
    }

    public String getJournal() {
        return journal;
    }

    public int getNumber() {
        return number;
    }

    public String getPages() {
        return pages;
    }

    public void setJournal(String journal) {
        this.journal = journal;
        addToSearchWords(journal);
    }

    public void setNumber(int number) {
        this.number = number;
        addToSearchWords(""+number);
    }

    public void setPages(String pages) {
        this.pages = pages;
        addToSearchWords(pages);
    }
    
    
}
