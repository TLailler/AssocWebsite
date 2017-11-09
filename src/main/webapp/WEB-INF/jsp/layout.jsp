<html>
<meta charset="UTF-8"></meta>

<!-- Compiled and minified JQuery -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>

<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
<head>
    <title>${pageTitle}</title>

</head>
<body>
    <div class="container">
        <jsp:include page="views/header.jsp"></jsp:include>
        <jsp:include page="views/${includeView}.jsp"></jsp:include>
        <jsp:include page="views/error.jsp"></jsp:include>
    </div>
</body>
</html>