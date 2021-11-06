<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<h2>Edit author</h2>
<form:form modelAttribute="author">
    <form:hidden path="id"/>

    First Name: <form:input path="firstName"/><br/>
    <form:errors path="firstName"/><br/>
    Last Name: <form:input path="lastName"/><br/>
    <form:errors path="lastName"/><br/>
    PESEL: <form:input path="pesel"/><br/>
    <form:errors path="pesel"/><br/>
    email: <form:input path="email"/><br/>
    <form:errors path="email"/><br/>

    <input type="submit" value="SAVE CHANGES TO AUTHOR"><br/>

</form:form>