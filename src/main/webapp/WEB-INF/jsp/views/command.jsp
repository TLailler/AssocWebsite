<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <c:if test="${sessionScope.login == null}">
        <p>Ah! Une petite erreur est survenue...</p>
    </c:if>
    <c:if test="${sessionScope.login != null}">
        <c:forEach var="article" begin="0" items="${requestScope.articleList}">
            <form action="Panier/AddArticle">
                <div class="article">
                    <p>${article.getArticle().getNom()}</p>
                    <p>${article.getArticle().getPrix()}</p>
                    <input name="qte" type="number" value="0" aria-valuemax="${article.getQte()}"/>/<p>${article.getQte()}</p>
                    <input type="hidden" name="ref" value="${article.getArticle().getRef()}"/>
                </div>
                <input type="submit" value="commander"/>
            </form>
        </c:forEach>
    </c:if>
</div>