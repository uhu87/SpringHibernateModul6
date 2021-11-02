<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Czy chcesz usunac ksiazke:</h2>




<form:form modelAttribute="book" action="/book/form/deleteConfirmation">

    Title: "${book.title}"<br/>
    Publisher: "${book.publisher.name}"<br/>
    Description: "${book.description}"<br/>


    <button type="submit" value="delete" name="confirmed">delete</button>
    <button type="submit" value="cancel" name="confirmed">cancel</button>
    <form:hidden path="id" value="${id}" /><br/>


</form:form>