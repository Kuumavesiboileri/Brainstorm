<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : home
    Created on : 11.4.2012, 12:14:01
    Author     : jarlerik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            function selectForm() {
                var selection = document.getElementById('selection');
                var bookForm = document.getElementById('book-form');
                var inpro = document.getElementById('inproceeding-form');
                var articleForm = document.getElementById('article-form');
                if(selection.selectedIndex==0) {
                    articleForm.setAttribute("style", "display:block");
                    bookForm.setAttribute("style", "display:none");
                    inpro.setAttribute("style", "display:none");
                }
                else if(selection.selectedIndex==1) {
                    bookForm.setAttribute("style", "display:block");
                    articleForm.setAttribute("style", "display:none");
                    inpro.setAttribute("style", "display:none");
                    
                }
                else if(selection.selectedIndex==2) {
                    inpro.setAttribute("style", "display:block");
                    bookForm.setAttribute("style", "display:none");
                    articleForm.setAttribute("style", "display:none");
                    
                }
            }
            
        </script>
        <script>
            function selectAll() {
                var allSelector = document.getElementById('select-all');
                var chosen = document.getElementsByClassName('checkToBib');
                if(allSelector.checked) {
                    for(var i = 0; i < chosen.length; i++) {
                        chosen[i].checked=true;
                    }
                }
                else {
                    for(var i = 0; i < chosen.length; i++) {
                        chosen[i].checked=false;
                    }
               }
            };
            function selectSome() {
                var allSelector = document.getElementById('select-all');
                allSelector.checked=false;
            };
        </script>
        <title>webRef | home</title>
    </head>
    <body>
        <h1>webRef</h1>
        <div style="border-style: solid;border-width: thin; border-color:silver; background-color: whitesmoke; margin-bottom: 10px">
            <h2>Add new reference</h2>
            <select id="selection" onchange="selectForm()">
                <option>Article</option>
                <option>Book</option>
                <option>Inproceedings</option>
            </select>
            <form id="book-form" action="addRef" method="POST" style="display: none">
                <h3>New book reference</h3>
                <fieldset>
                    <legend>Required fields</legend>
                    <label>tag:</label>
                    <input id="book-tag" type="text" name="tag" />
                    <label>author:</label>
                    <input id="book-author" type="text" name="author"/>
                    <label>title:</label>
                    <input id="book-title" type="text" name="title">
                    <label>publisher:</label> 
                    <input id="publisher" type="text" name="publisher" />
                    <label>year:</label>
                    <input id="book-year" type="text" name="year" />
                </fieldset>
                <fieldset>
                    <legend>Optional fields</legend>
                    <label>note:</label>
                    <textarea rows="10" cols="50" name="note"></textarea> <br>                    
                    <label>volume:</label>
                    <input type="text" value="0" name="volume" />
                    <label>series:</label>
                    <input type="text" name="series"/>
                    <label>address:</label>
                    <input type="text" name="address">
                    <label>edition:</label>
                    <input type="text" name="edition" />
                    <label>month:</label>
                    <input type="text" name="month" />
                    <label>key:</label>
                    <input type="text" name="key" />
                </fieldset>
                <input type="submit" value="add" />
            </form>
            <form id="article-form" action="addRef" method="POST" style="display: block" >
                <h3>New article reference</h3>
                <fieldset>
                    <legend>required fields</legend>
                    <label>tag:</label>
                    <input id="article-tag" type="text" name="tag" />
                    <label>author:</label>
                    <input id="article-author" type="text" name="author"/>
                    <label>title:</label>
                    <input id="article-title" type="text" name="title">
                    <label>journal:</label>
                    <input id="journal" type="text" name="journal" />
                    <label>year:</label>
                    <input id="article-year" type="text" name="year" />
                    
                </fieldset>
                <fieldset>
                    <legend>Optional fields</legend>
                    <label>note:</label>
                    <textarea rows="10" cols="50" name="note"></textarea> <br>                    
                    <label>volume:</label>
                    <input type="text" value="0" name="volume" />
                    <label>number:</label>
                    <input value="0" type="text" name="number"/>
                    <label>pages:</label>
                    <input type="text" name="pages">
                    <label>month:</label>
                    <input type="text" name="month" />
                    <label>key:</label>
                    <input type="text" name="key" />
                </fieldset>
                <input type="submit" value="add" />
                
            </form>
            
            <form id="inproceeding-form" action="addRef" method="POST" style="display: none" >
                <h3>New inproceeding reference</h3>
                <fieldset>
                    <legend>required fields</legend>
                    <label>tag:</label>
                    <input id="inpr-tag" type="text" name="tag" />
                    <label>author:</label>
                    <input id="inpr-author" type="text" name="author"/>
                    <label>title:</label>
                    <input id="inpr-title" type="text" name="title">
                    <label>booktitle:</label>
                    <input id="booktitle" type="text" name="booktitle">
                    <label>year:</label>
                    <input id="inpr-year" type="text" name="year" />
                    
                    
                </fieldset>
                <fieldset>
                    <legend>Optional fields</legend>
                    <label>note:</label>
                    <textarea rows="10" cols="50" name="note"></textarea> <br>
                    <label>editor:</label>
                    <input type="text" name="editor"/>
                    <label>volume:</label>
                    <input type="text" value="0" name="volume" />
                    <label>series:</label>
                    <input type="text" name="series"/>
                    <label>pages:</label>
                    <input type="text" name="pages">
                    <label>address:</label>
                    <input type="text" name="address"/>
                    <label>month:</label>
                    <input type="text" name="month" />
                    <label>organization:</label>
                    <input type="text" name="organization" />
                    <label>publisher:</label>
                    <input type="text" name="publisher" /><br>
                    <label>key:</label>
                    <input type="text" name="key" />
                </fieldset>
                <input type="submit" value="add" />
                
            </form>
        </div>
        <div style="border-style: solid;border-width: thin; border-color:silver; background-color: whitesmoke; margin-bottom: 10px">
        <h2>References</h2>
        
        <button>download bibTex</button>
                
        choose all to bibTex file<input id="select-all" type="checkbox" name="bib" onclick="selectAll()" />
        <table border="1" style="width: 100%">
            <thead>
                <tr>
                    <th>choose to bibTex file</th>
                    <th>author</th>
                    <th>title</th>
                    <th>booktitle</th>
                    <th>publisher</th>
                    <th>journal</th>
                    <th>year</th>
                    <th>volume</th>
                    <th>number</th>
                    <th>series</th>
                    <th>address</th>
                    <th>edition</th>
                    <th>pages</th>
                    <th>month</th>
                    <th>organization</th>
                    <th>note</th>
                    <th>key</th>
                </tr>
                
            </thead>
            <tbody>
            <c:forEach var="ref" items="${references}">
                <tr>
                    <td><input class="checkToBib" type="checkbox" name="bib" onclick="selectSome()"/></td>
                    <td>${ref.author}</td>
                    <td>${ref.title}</td>
                    <td>${ref.booktitle}</td>
                    <td>${ref.publisher}</td>
                    <td>${ref.journal}</td>
                    <td>${ref.ref_year}</td>
                    <td>${ref.volume}</td>
                    <td>${ref.number}</td>
                    <td>${ref.series}</td>
                    <td>${ref.address}</td>
                    <td>${ref.edition}</td>
                    <td>${ref.pages}</td>                    
                    <td>${ref.ref_month}</td>
                    <td>${ref.organization}</td>
                    <td>${ref.note}</td>
                    <td>${ref.ref_key}</td> 
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
       
    </body>
</html>
