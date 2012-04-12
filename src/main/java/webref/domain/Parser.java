/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.domain;

/**
 *
 * @author todjalka
 */
public class Parser {

    private String sentence;
    private char[] match = {'Ä', 'ä', 'Ò', 'ò', 'Ó', 'ó', 'Ö', 'ö', 'Õ', 'õ', 'Å', 'å', 'Æ', 'æ', 'Ø', 'ø', 'ß'};
    private String[] match2 = {"Ä", "ä", "Ò", "ò", "Ó", "ó", "Ö", "ö","Õ", "õ", "Å", "å", "Æ", "æ", "Ø", "ø", "ß"};
    private String[] replace = {"\\\"{A}", "\\\"{a}", "\\`{O}", "\\`{o}", "\\´{O}", "\\´{o}", "\\\"{O}", "\\\"{o}", "\\~{O}", "\\~{o}",
        "\\AA", "\\aa", "\\AE", "\\ae", "\\O", "\\o", "\\ss"};

    public Parser() {
    }

    public String parse(String string) {
        sentence = string;
        for (int i = 0; i < sentence.length(); ++i) {
            checkMatches(i);
        }
        return this.sentence;
    }

    private void checkMatches(int i) {
        for (int j = 0; j < match.length; ++j) {
            if (sentence.charAt(i) == match[j]) {
                refactor(i,j);
            }
        }
    }
    private void refactor(int i, int j) {
        String begin = sentence.substring(0, i);
        String end = sentence.substring(i+1, sentence.length());
        sentence = begin + replace[j] + end;
    }
}
