<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card-panel indigo lighten-5">
    <p>Recapitulatif de votre commande:</p>
    <div style="text-align: center">
        <c:forEach var="article" begin="0" items="${requestScope.articleList}">
            <div style="width: 25%; display: inline-block; text-align: center" class="card-panel #d7ccc8 brown lighten-4">
                <h3 style="color: forestgreen">${article.getArticle().getNom()}</h3>
                <h5>Prix: ${article.getArticle().getPrix()} euros</h5>
                <h6 style="color: orangered">Quantite achetee: ${article.getQte()}</h6>
            </div>
        </c:forEach>
        <form action="cleancart">
            <input class="btn brown darken-3" type="submit" value="Annuler toute la commande"/>
        </form>
    </div>
</div>
