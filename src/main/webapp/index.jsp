<%@ page import="java.time.LocalDate" %>
<html>
<head>
    <title>Benvenuto</title>
</head>
<body>
    <h1>Benvenuto Utente Curioso, questa e` la mia prima JSP.</h1>
    <p>Oggi e` il giorno <%= LocalDate.now() %></p>
    <p>Autore: <a href="author.jsp">Clicca qui</a></p>
</body>
</html>
