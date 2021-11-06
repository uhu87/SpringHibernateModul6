<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Czy chcesz usunac autora:</h2>




<form:form modelAttribute="author" action="/author/form/confirmDeleting">

    ${author.firstName} ${author.lastName}<br/>

    <button type="submit" value="delete" name="confirmed">delete</button>
    <button type="submit" value="cancel" name="confirmed">cancel</button>
    <form:hidden path="id" value="${id}" /><br/>

</form:form>