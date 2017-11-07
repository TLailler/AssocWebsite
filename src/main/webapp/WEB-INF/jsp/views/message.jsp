<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <c:if test="${requestScope.message}">
        <p class="message">${requestScope.message}</p>
    </c:if>
</div>