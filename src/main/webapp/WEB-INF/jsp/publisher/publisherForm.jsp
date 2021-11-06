<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<h2>save publisher</h2>
<form:form modelAttribute="publisher">

    Name: <form:input path="name"/><br/>
    <form:errors path="name"/><br/>
    nip: <form:input path="nip"/><br/>
    <form:errors path="nip"/><br/>
    regon: <form:input path="regon"/><br/>
    <form:errors path="regon"/><br/>
    <form:hidden path="id"/><br/>
    <input type="submit" value="SAVE PUBLISHER"><br/>

</form:form>