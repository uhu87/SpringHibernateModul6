<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>


<a href="/book/form/all">BOOKS</a> AUTHORS <a href="/publisher/form/all">PUBLISHERS</a> <br/>
<hr>
<a href="add">Add new author</a>      <br>

<c:forEach items="${authors}" var="a">
    <hr>
    <strong><c:out value="${a.firstName} ${a.lastName}: "/></strong><br>

    <a href="/author/form/edit?idToEdit=${a.id}">Edit Author</a>
    <a href="/author/form/delete?idToDelete=${a.id}">Remove author</a>


</c:forEach>


<hr>
<a href="add">Add new author</a>