<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="register-block">
    <form action="/login" method="post">
        <input type="text"     name="login"     class="login-input" placeholder="identifiant"  required/>
        <input type="password" name="pwd"       class="login-input" placeholder="mot de passe" required/>
        <input type="checkbox" name="rememberConnexion" id="remember"><label for="remember">se souvenir de moi</label>
        <input type="submit" value="connexion"/>
    </form>
    <p>
        Vous n'avez pas encore de compte? <a href="/signup">Incrivez vous!</a>
    </p>
    <c:if test="${requestScope.errorMessage}"><div class="error">${requestScope.errorMessage}</div></c:if>
</div>