/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private String tag;
    private String author;
    private String title;
    private String book_publisher;
    private String inpro_publisher;
    private int ref_year;
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
    
    public Book dataObjectToBook() {
        Book book = new Book(tag, author, title, book_publisher, ref_year, new Parser());
        return book;
    }
    public Article dataObjectToArticle() {
        Article article = new Article(tag, author, title, journal, ref_year, new Parser());
        return article;
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

    public int getRef_year() {
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
    
    public void setAddress(String address) {
        this.address = address;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setRef_key(String ref_key) {
        this.ref_key = ref_key;
    }

    public void setRef_month(String ref_month) {
        this.ref_month = ref_month;
    }    

    public void setNote(String note) {
        this.note = note;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }

    public void setInpro_publisher(String inpro_publisher) {
        this.inpro_publisher = inpro_publisher;
    }

    

    public void setSeries(String series) {
        this.series = series;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setRef_year(int ref_year) {
        this.ref_year = ref_year;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
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
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }
    
    
}
