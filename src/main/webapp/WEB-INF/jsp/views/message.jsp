<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${requestScope.message != null}">
    <div>
        <p>${requestScope.message}</p>
    </div>
</c:if>
