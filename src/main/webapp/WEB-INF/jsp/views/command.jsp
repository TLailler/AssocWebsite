<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <c:if test="${!userLoggedIn}">
        <p>Ah! Une petite erreur est survenue...</p>
    </c:if>
    <c:if test="${userLoggedIn}">
        
    </c:if>
</div>