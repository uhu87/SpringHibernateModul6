<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<h2>Edit book</h2>
<form:form modelAttribute="book" action="/book/form/saveChange">

    <form:hidden path="id"/>

    Title: <form:input path="title"/><br/>
    <form:errors path="title"/>

    Description: <form:textarea path="description"/><br/>
    <form:errors path="description"/>

    Publisher: <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/><br/>
    <form:errors path="publisher"/>

    Authors: <form:select multiple="true" path="authors" items="${authors}" itemValue="id" itemLabel="fullName"/><br/>
    <form:errors path="authors"/>

    Rating: <form:input path="rating" type="number"/> <br/>
    <form:errors path="rating"/>

    pages: <form:input path="pages" type="number"/> <br/>
    <form:errors path="pages"/>

    <input type="submit" value="SAVE CHANGES BOOK"><br/>

</form:form>