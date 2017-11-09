<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header" class="col s12">
    <div class="col s6"><h1 id="logo">AssocWebsite</h1></div>
    <div class="col s6">
        <c:if test="${sessionScope.login == null}">
            <a class="offset-s4 col s2 waves-effect waves-light btn" href="login">Connexion</a>
        </c:if>
        <c:if test="${sessionScope.login != null}">
            <a class="col s2 waves-effect waves-light btn" href="command">Commander</a>
            <a class="col s2 waves-effect waves-light btn" href="commands">Mes Commandes</a>
            <a class="col s2 waves-effect waves-light btn" href="logout">Deconnexion</a>
        </c:if>
    </div>
</div>

<style>
    #header > div
    {
        display: inline-block;
    }
</style>