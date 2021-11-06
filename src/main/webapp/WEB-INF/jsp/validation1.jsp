<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Validations errors:</h2>

<c:forEach items="${errors}" var = "e">

    ${e.message}<br>


</c:forEach>

${success}