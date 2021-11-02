<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>


<form:form method="post" modelAttribute="person">

    Login: <form:input path="login"/> <br />
    Password: <form:password path="password"/> <br />
    Email: <form:input type="email" path="email"/> <br />

    <input type="submit" value="Wysylam"> <br />



</form:form>



<%-- FROMULARZ DO OBSLUGI PRZEZ @RequesParam --%>
<%--
<form method="post">

    Loing: <input type="text" name="login"> <br />
    Password: <input type="password" name="password"> <br />
    Email: <input type="email" name="email"> <br />

    <input type="submit" value="Wysylam"> <br />


</form>--%>
