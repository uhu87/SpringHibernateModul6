<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

BOOKS <br>

<a href="add">Add new book</a>      <br>

<c:forEach items="${books}" var="b">

    <strong><c:out value="${b.title}, Publishers: ${b.publisher.name}: "/></strong><br>
    <c:out value="${b.description}"/><br>
    <c:forEach items="${b.authors}" var="a">
        ${a.firstName}  ${a.lastName}
    </c:forEach> <br>
    <a href="/book/form/edit/${b.id}">Edit book</a>
    <a href="/book/form/deleteConfirmation/${b.id}">Remove book</a>
    <hr>

</c:forEach>



<a href="/book/form/show">Add new book</a>