<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${requestScope.errorMessage != null}">
    <div class="card-panel red darken-1">
        <p>${requestScope.errorMessage}</p>
    </div>
</c:if>
