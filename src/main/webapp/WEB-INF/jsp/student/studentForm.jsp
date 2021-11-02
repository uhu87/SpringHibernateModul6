<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>


<form:form method="post" modelAttribute="student">

    firstName: <form:input path="firstName"/> <br />

    lastName: <form:input path="lastName"/> <br />

    M: <form:radiobutton path="gender" value="M"/>
    F: <form:radiobutton path="gender" value="F"/> <br />

    countries: <form:select path="country" items="${countries}"/> <br />

    notes: <form:textarea path="notes" rows="5" cols="10"/> <br />

    mailingList: <form:checkbox path="mailingList"/> <br />

    programmingSkills: <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/> <br />

    hobbies: <form:checkboxes items="${hobbies}" path="hobbies" /><br />

    <input type="submit" value="Wysylam"> <br />



</form:form>

