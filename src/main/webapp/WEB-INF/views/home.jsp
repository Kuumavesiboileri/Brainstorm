 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
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
        <link href='http://fonts.googleapis.com/css?family=Monoton' rel='stylesheet' type='text/css'>
        <style>
            .border {
                -webkit-border-radius: 15px;
                -moz-border-radius: 15px;
                 border-radius: 15px;
                 padding: 7px;
            }
            #logo {
                
                font-family: 'Monoton', cursive;
                font-size: 2em;
                size: 10em;
                border-style: solid;
                border-width: thin;
                border-color: silver;
                background-color: whitesmoke;
                margin-bottom: 10px;
                
                                /* Firefox */
                display:-moz-box;
                -moz-box-orient:horizontal;
                -moz-box-pack:center;
                -moz-box-align:center;

                /* Safari and Chrome */
                display:-webkit-box;
                -webkit-box-orient:horizontal;
                -webkit-box-pack:center;
                -webkit-box-align:center;

                /* W3C */
                display:box;    
                box-orient:horizontal;
                box-pack:center;
                box-align:center;
                
            }
            #reference-add {
                border-style: solid;
                border-width: thin; 
                border-color:silver; 
                background-color: whitesmoke; 
                margin-bottom: 10px
            }
            #reference-show {
                border-style: solid;
                border-width: thin; border-color:silver; 
                background-color: whitesmoke; 
                margin-bottom: 10px;
            }
            table, th, tr, td {
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-bottom-right-radius: 5px;
            border-color: silver;
                
            }
            th {
                background-color: silver;
            }
            
        </style>
        <script>
            function selectFields() {
                var selection = document.getElementById('selection');
                if(selection.selectedIndex==0) {
                    selectFieldsToHide('book');
                    selectFieldsToHide('inproceedings');
                    selectFieldsToShow('article');
                    
                }
                else if(selection.selectedIndex==1) {
                    selectFieldsToHide('article');
                    selectFieldsToHide('inproceedings');
                    selectFieldsToShow('book');
                }
                else if(selection.selectedIndex==2) {
                    selectFieldsToHide('article');
                    selectFieldsToHide('book');
                    selectFieldsToShow('inproceedings');
                }
            }
            function selectFieldsToHide(className) {
             var  reference = document.getElementsByClassName(className);
                    for(var i = 0; i < reference.length; i++) {
                        reference[i].setAttribute("style", "display:none");
                    }
            }
            function selectFieldsToShow(className) {
                var  reference = document.getElementsByClassName(className);
                    for(var i = 0; i < reference.length; i++) {
                        reference[i].setAttribute("style", "display:inline");
                    }
                    setButtonText(className);
            }
            function setButtonText(className) {
                var button = document.getElementById('submit');
                button.setAttribute('value', 'add new '+className);
                setReferenceType(className);
            }
            function setReferenceType(type) {
                var input = document.getElementById('type');
                input.setAttribute("value", type);
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
        <div id="logo" class="border">
            <h1>webRef</h1>
        </div>
        
        <div id="reference-add" class="border">
            <h2>Add new reference</h2>
            <select id="selection" onchange="selectFields()">
                <option value="Article">Article</option>
                <option value="Book">Book</option>
                <option value="Inproceeding">Inproceedings</option>
            </select>
            
        <form:form commandName="ref" id="ref-form" action="addRef" method="POST">
                <fieldset>
                    <legend>Required fields</legend>
                    <label>Reference Name:</label>
                    <input id="tag" type="text" name="tag" />
                    <label>author:</label>
                    <input id="author" type="text" name="author"/>
                    <label>title:</label>
                    <input id="title" type="text" name="title">
                    <label class="inproceedings" >booktitle:</label>
                    <input class="inproceedings" id="booktitle" type="text" name="booktitle">
                    <label class="book" >publisher:</label> 
                    <input class="book" id="book-publisher" type="text" name="book_publisher" />
                    <label class="article">journal:</label>
                    <input class="article" id="journal" type="text" name="journal" />
                    <label>year:</label>
                    <form:input path="ref_year" id="year" type="text" name="ref_year" /><form:errors path="ref_year"/>
                </fieldset>
                <fieldset>
                    <legend>Optional fields</legend>
                    <label>note:</label>
                    <textarea rows="10" cols="50" name="note"></textarea> <br>
                    <label class="inproceedings">editor:</label>
                    <input class="inproceedings" type="text" name="editor"/>
                    <label>volume:</label>
                    <input type="text" value="0" name="volume" />
                    <label class="article" >number:</label>
                    <input class="article" value="0" type="text" name="number"/>
                    <label class="article" >pages:</label>
                    <input class="article" type="text" name="pages">
                    <label>series:</label>
                    <input type="text" name="series"/>
                    <label class="book inproceedings"  >address:</label>
                    <input class="book inproceedings" type="text" name="address">
                    <label>edition:</label>
                    <input type="text" name="edition" />
                    <label>month:</label>
                    <input type="text" name="ref_month" />
                    <label class="inproceedings">publisher:</label>
                    <input class="inproceedings" id="inpro-publisher" type="text" name="inpro_publisher" /><br>
                    <label class="inproceedings" >organization:</label>
                    <input class="inproceedings" type="text" name="organization" />
                    <label>key:</label>
                    <input type="text" name="ref_key" />
                    <input id="type" type="hidden" value="article" name="type"/>
                </fieldset>
                <input id="submit" type="submit" value="add new article" />
            </form:form>
        </div>
        <div  id="reference-show" class="border">
        <h2>References</h2>
        <form method="GET" ><button id="genBib" type="submit" formaction="bibtex">download bibTex</button></form>
        
                
        choose all to bibTex file<input id="select-all" type="checkbox" name="bib" onclick="selectAll()" />
        <div>
            <form method="POST">
                <input id="search" type="search" name="etsi"/><input id="search-submit" type="submit" formaction="search" value="search"/>
            </form>
        </div>
        <c:set var="size1" value="${size}"/>
        <c:if test="${(size1 > 0)}">
                <p>Found ${size1} matches</p>
        </c:if>
        
        <table border="1" style="width: 100%">
            <thead>
                <tr>
                    <th>choose to bibTex file</th>
                    <th>type</th>
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
                    <th>tags</th>
                    <th>add new tag</th>
                </tr>
                
            </thead>
            <tbody>
            <c:forEach var="ref" items="${references}">
                
                <tr>
                    <td><input class="checkToBib" type="checkbox" name="bib" onclick="selectSome()"/></td>
                    <td>${ref.type}</td>
                    <td>${ref.author}</td>
                    <td>${ref.title}</td>
                    <td>${ref.booktitle}</td>
                    <td>${ref.book_publisher}${ref.inpro_publisher}</td>
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
                    <td>${ref.tags}</td>
                    <td> <form method="POST"><input type="hidden" value="${ref.id}" name="id" /><input type="text" name="newTag"/><input id="tagsubmit" type="submit" value="add" formaction="addTags"/></form></td>
                </tr>
            </c:forEach>     
            </tbody>
        </table>
        
        </div>
        <script>
            selectFieldsToHide('book');
            selectFieldsToHide('inproceedings');
        </script>
    </body>
</html>
