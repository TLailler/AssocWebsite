<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="button">
    <c:if test="${sessionScope.login == null}">
        <a href="/login">connexion</a>
    </c:if>
    <c:if test="${sessionScope.login != nul}">
        <a href="/logout">deconnexion</a>
    </c:if>
</div>