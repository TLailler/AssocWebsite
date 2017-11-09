<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card-panel indigo lighten-5">
    <p>Commander de nouveaux articles:</p>
    <div style="text-align: center">
        <c:forEach var="article" begin="0" items="${requestScope.articleList}">
            <div style="width: 25%; display: inline-block; text-align: center" class="card-panel #d7ccc8 brown lighten-4">
                <form action="command">
                    <h3 style="color: forestgreen">${article.getArticle().getNom()}</h3>
                    <h5>Prix: ${article.getArticle().getPrix()} euros</h5>
                    <h6 style="color: orangered">Quantite disponible: ${article.getQte()}</h6>
                    <label>J'en veux:
                        <input style="width: 100px; text-align: right" name="qte" type="number" value="0" aria-valuemax="${article.getQte()}"/>
                    </label>
                    <input type="hidden" name="ref" value="${article.getArticle().getRef()}"/>
                    <input class="btn brown darken-3" type="submit" value="commander"/>
                </form>
            </div>
        </c:forEach>
    </div>
</div>

