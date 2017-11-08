<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
    <div id="logo">AssocWebsite</div>
    <div class="menu">
        <c:if test="${sessionScope.login == null}">
            <a href="login">connexion</a>
        </c:if>
        <c:if test="${sessionScope.login != null}">
            <a href="command">Nouvelle Commande</a>
            <a href="commands">Mes Commandes</a>
            <a href="logout">deconnexion</a>
        </c:if>
    </div>
</div>