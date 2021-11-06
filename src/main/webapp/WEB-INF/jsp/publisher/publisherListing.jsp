<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>


<a href="/book/form/all">BOOKS</a> <a href="/author/form/all">AUTHORS</a> PUBLISHERS <br>
<hr>
<a href="add">Add new publisher</a>      <br>

<c:forEach items="${publishers}" var="p">
    <hr>
    <strong><c:out value="${p.name}"/></strong><br>

    <a href="/publisher/form/edit?idToEdit=${p.id}">Edit publishers</a>
    <a href="/publisher/form/remove?toRemoveId=${p.id}">Remove publishers</a>


</c:forEach>
<hr>


<a href="add">Add new publisher</a>