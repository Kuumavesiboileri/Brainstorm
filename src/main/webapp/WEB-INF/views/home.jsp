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
        <title>webRef | home</title>
    </head>
    <body>
        <h1>webRef</h1>
        <div style="border-style: solid;border-width: thin; border-color:silver; background-color: whitesmoke; margin-bottom: 10px">
            <h2>Add new book reference</h2>
            <form action="book" method="POST">
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
                <input id="book-add" type="submit" value="add" />
            </form>        
        </div>
        <div style="border-style: solid;border-width: thin; border-color:silver; background-color: whitesmoke; margin-bottom: 10px">
            <h2>Add new article reference</h2>
            <form action="article" method="POST">
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
                <input id="article-add" type="submit" value="add" />
                
            </form>
        </div>
        <div style="border-style: solid;border-width: thin; border-color:silver; background-color: whitesmoke; margin-bottom: 10px">
        <h2>References</h2>
        <h3>Books</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>author</th>
                    <th>title</th>
                    <th>publisher</th>
                    <th>year</th>
                    <th>volume</th>
                    <th>series</th>
                    <th>address</th>
                    <th>edition</th>
                    <th>month</th>
                    <th>note</th>
                    <th>key</th>
                </tr>
                
            </thead>
            <tbody>
            <c:forEach var="ref" items="${books}">
                <tr>
                    <td>${ref.author}</td>
                    <td>${ref.title}</td>
                    <td>${ref.publisher}</td>
                    <td>${ref.year}</td>
                    <td>${ref.volume}</td>
                    <td>${ref.series}</td>
                    <td>${ref.address}</td>
                    <td>${ref.edition}</td>
                    <td>${ref.month}</td>
                    <td>${ref.note}</td>
                    <td>${ref.key}</td> 
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <h3>Articles</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>author</th>
                    <th>title</th>
                    <th>Journal</th>
                    <th>year</th>
                    <th>volume</th>
                    <th>number</th>
                    <th>pages</th>
                    <th>month</th>
                    <th>note</th>
                    <th>key</th>
                </tr>
                
            </thead>
            <tbody>
            <c:forEach var="ref" items="${articles}">
                <tr>
                    <td>${ref.author}</td>
                    <td>${ref.title}</td>
                    <td>${ref.journal}</td>
                    <td>${ref.year}</td>
                    <td>${ref.volume}</td>
                    <td>${ref.number}</td>
                    <td>${ref.pages}</td>
                    <td>${ref.month}</td>
                    <td>${ref.note}</td>
                    <td>${ref.key}</td> 
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
        <ul>
    
    </ul>
    </body>
</html>
