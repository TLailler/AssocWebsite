<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <c:if test="${sessionScope.login == null}">
        <p>Ah! Une petite erreur est survenue...</p>
    </c:if>
    <c:if test="${sessionScope.login != null}">

    </c:if>
</div>