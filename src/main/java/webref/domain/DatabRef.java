/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    private String tagString;
    private String type;
    private String tag;
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
    private List<String> searchMonster = new ArrayList<String>();;
    private List<String> tags = new ArrayList<String>();
    
    public Viite dataObjectToViite() {
        if(type.equals("book")) {
            Book book = new Book(tag, author, title, book_publisher, Integer.parseInt(ref_year), new Parser());
        return book;
        }
        else if(type.equals("article")) {
            Article article = new Article(tag, author, title, journal, Integer.parseInt(ref_year), new Parser());
        return article;
        }
        else if(type.equals("inproceedings")) {
            Inproceedings inproceeding = new Inproceedings(tag, author, title, booktitle, Integer.parseInt(ref_year), new Parser());
            return inproceeding;
        }
        else return null;
        
    }

    public boolean monsterFound(String lol) {
        return searchMonster.contains(lol);
    }

    public void addToMonster(String adding) {
        searchMonster.add(adding);
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

     public String getTagString() {
         return tagString;
     }   
    

    public String getSeries() {
        return series;
    }

    public String getTag() {
        return tag;
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
        addToMonster(type);
    }
    
    public boolean tagFound(String name) {
        return tags.contains(name);
    }
    public void setAddress(String address) {
        this.address = address;
        addToMonster(address);
    }

    public void setAuthor(String author) {
        this.author = author;
        addToMonster(author);
    }

    public void setEdition(String edition) {
        this.edition = edition;
        addToMonster(edition);
    }

    public void setRef_key(String ref_key) {
        this.ref_key = ref_key;
        addToMonster(ref_key);
    }

    public void setRef_month(String ref_month) {
        this.ref_month = ref_month;
        addToMonster(ref_month);
    }    

    public void setNote(String note) {
        this.note = note;
        addToMonster(note);
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
        addToMonster(book_publisher);
    }

    public void setInpro_publisher(String inpro_publisher) {
        this.inpro_publisher = inpro_publisher;
        addToMonster(inpro_publisher);
    }

    

    public void setSeries(String series) {
        this.series = series;
        addToMonster(series);
    }

    public void setTag(String tag) {
        this.tag = tag;
        addToMonster(tag);
    }

    public void setTitle(String title) {
        this.title = title;
        addToMonster(title);
    }

    public void setVolume(int volume) {
        this.volume = volume;
        addToMonster(""+volume);
    }

    public void setRef_year(String ref_year) {
        this.ref_year = ref_year;
        addToMonster(ref_year);
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
        addToMonster(booktitle);
    }

    public void setEditor(String editor) {
        this.editor = editor;
        addToMonster(editor);
    }

    public void setOrganization(String organization) {
        this.organization = organization;
        addToMonster(organization);
    }

    public void setTags(String tags) {
        this.tags.add(tags);
        addToMonster(tags);
        tagString();
    }

    public void tagString() {
        this.tagString = tags.toString();
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
        addToMonster(journal);
    }

    public void setNumber(int number) {
        this.number = number;
        addToMonster(""+number);
    }

    public void setPages(String pages) {
        this.pages = pages;
        addToMonster(pages);
    }
    
    
}
