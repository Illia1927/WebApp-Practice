<html>
<head>

    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/style.css"/>

    <title>Home page</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>
<body>
<div>
    <form>
        <h1>Hello, dear <%=request.getAttribute("name")%>!</h1>
    <button type="submit" class="btn btn-primary btn-block btn-large" onclick="location.href='/webapp_war_exploded/home'">Go to home page</button>
    </form>
</div>

<script  src="js/index.js"></script>
</body>
</html>