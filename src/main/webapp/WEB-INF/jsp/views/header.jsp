<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-xs-12">
    <div id="logo" class="col-lg-6">AssocWebsite</div>
    <div class="menu col-lg-6">
        <c:if test="${sessionScope.login == null}">
            <a class="btn-primary btn col-md-2" href="login">Connexion</a>
        </c:if>
        <c:if test="${sessionScope.login != null}">
            <a class="btn-primary btn col-md-2" href="command">Commander</a>
            <a class="btn-primary btn col-md-2" href="commands">Mes Commandes</a>
            <a class="btn-primary btn col-md-2" href="logout">Deconnexion</a>
        </c:if>
    </div>
</div>