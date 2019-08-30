<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/editData" method="post">
        Imię: <br>
        <input type="text" value="${adminData.firstName}" name="firstName"><br><br>
        Nazwisko: <br>
        <input type="text" value="${adminData.lastName}" name="lastName"><br><br>
        email: <br>
        <input type="text" value="${adminData.email}" name="email"><br><br><br>

        <input type="submit" value="Zapisz zmiany">
    </form>
</body>
</html>
