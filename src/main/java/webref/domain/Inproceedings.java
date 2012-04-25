/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.domain;

import webref.domain.Parser;
import webref.domain.Viite;

/**
 *
 * @author todjalka
 */
public class Inproceedings implements Viite {

    private String tag;
    //Required fields: author/editor, title, booktitle, year
    private String author;
    private String title;
    private String booktitle;
    private int year;
    //Optional fields: editor,volume/number, series, pages, address, month, organization, publisher, note, key
    private String editor;
    private int volume;
    private String series;
    private String pages;
    private String address;
    private String month;
    private String organization;
    private String publisher;
    private String note;
    private String key;

    public Inproceedings(String tag, String author, String title, String booktitle, int year) {
        this.tag = tag;
        this.author = author;
        this.title = title;
        this.booktitle = booktitle;
        this.year = year;
    }

    public Inproceedings(String tag, String author, String title, String booktitle, int year, String editor, int volume, String series, String pages, String address, String month, String organization, String publisher, String note, String key) {
        this.tag = tag;
        this.author = author;
        this.title = title;
        this.booktitle = booktitle;
        this.year = year;
        this.editor = editor;
        this.volume = volume;
        this.series = series;
        this.pages = pages;
        this.address = address;
        this.month = month;
        this.organization = organization;
        this.publisher = publisher;
        this.note = note;
        this.key = key;
    }

    
    public void setEditor(String editor) {
        this.editor = editor;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String toLaTexString(Parser parser) {
        String palauta = "@InProceedings(" + tag + ",\n";
        palauta += "AUTHOR = {" + parser.parse(author) + "},\n";
        palauta += "TITLE = {" + parser.parse(title) + "},\n";
        palauta += "BOOKTITLE = {" + parser.parse(booktitle) + "},\n";
        palauta += "YEAR = {" + year + "},\n";
        palauta += addOptionalsToLaTex(parser);
        return palauta + ")";
    }

    public String toReadableString() {
        String palauta = "Author: " + author
                + "\nTitle: " + title
                + "\nBooktitle: " + booktitle
                + "\nYear: " + year;
        palauta += addOptionalsToReadable();
        return palauta;
    }

    private String addOptionalsToReadable() {
        String palautettava = "";
        if (editor != null) {
            palautettava += "\nEditor: " + editor;
        }
        if (volume != 0) {
            palautettava += "\nVolume: " + volume;
        }
        if (series != null) {
            palautettava += "\nSeries: " + series;
        }
        if (pages != null) {
            palautettava += "\nPages: " + pages;
        }
        if (address != null) {
            palautettava += "\nAddress: " + address;
        }
        if (month != null) {
            palautettava += "\nMonth: " + month;
        }
        if (organization != null) {
            palautettava += "\nOrganization: " + organization;
        }
        if (publisher != null) {
            palautettava += "\nPublisher: " + publisher;
        }
        if (note != null) {
            palautettava += "\nNote: " + note;
        }
        if (key != null) {
            palautettava += "\nKey: " + key;
        }
        return palautettava;
    }

    private String addOptionalsToLaTex(Parser parser) {
        String palautettava = "";
        if (editor != null && !editor.equals("")) {
            palautettava += "EDITOR = {" + parser.parse(editor) + "},\n";
        }
        if (volume != 0) {
            palautettava += "VOLUME = {" + volume + "},\n";
        }
        if (series != null && !series.equals("")) {
            palautettava += "SERIES = {" + parser.parse(series) + "},\n";
        }
        if (pages != null && !pages.equals("")) {
            palautettava += "PAGES = {" + parser.parse(pages) + "},\n";
        }
        if (address != null && !address.equals("")) {
            palautettava += "ADDRESS = {" + parser.parse(address) + "},\n";
        }
        if (month != null && !month.equals("")) {
            palautettava += "MONTH = {" + parser.parse(month) + "},\n";
        }
        if (organization != null && !organization.equals("")) {
            palautettava += "ORGANIZATION = {" + parser.parse(organization) + "},\n";
        }
        if (publisher != null && !publisher.equals("")) {
            palautettava += "PUBLISHER = {" + parser.parse(publisher) + "},\n";
        }
        if (note != null && !note.equals("")) {
            palautettava += "NOTE = {" + parser.parse(note) + "},\n";
        }
        if (key != null && !key.equals("")) {
            palautettava += "KEY"
                    + " = {" + parser.parse(key) + "},\n";
        }
        return palautettava;
    }
}
