<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <c:if test="${sessionScope.login == null}">
        <p>Ah! Une petite erreur est survenue...</p>
    </c:if>
    <c:if test="${sessionScope.login != null}">
        <c:forEach var="article" begin="0" items="${requestScope.articleList}">
            <div class="article">
                <p>${article.getArticle().getNom()}</p>
                <p>${article.getArticle().getPrix()}</p>
                <p>${article.getQte()}</p>
            </div>
        </c:forEach>
    </c:if>
    <form action="Panier/Clean">
        <input type="submit" value="Annuler la commande"/>
    </form>
</div>