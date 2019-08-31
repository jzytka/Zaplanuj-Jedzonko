<!DOCTYPE html>
<html lang="en">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Zaplanuj Jedzonko</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>
<%@ include file="fragments/headerDashboard.jspf" %>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <ul class="nav flex-column long-bg">
            <li class="nav-item">
                <a class="nav-link" href="/dashboard">
                    <span>Pulpit</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/app-recipeList">
                    <span>Przepisy</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/planList">
                    <span>Plany</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/editData">
                    <span>Edytuj dane</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="/editPassword">
                    <span>Zmień hasło</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <c:if test="${admin.superadmin == 1}">
                <li class="nav-item">
                    <a class="nav-link" href="/LINK">
                        <span>Użytkownicy</span>
                        <i class="fas fa-angle-right"></i>
                    </a>
                </li>
            </c:if>
        </ul>

        <div class="m-4 p-4 width-medium">
            <div class="dashboard-header m-4">
                <div class="dashboard-menu">
                    <div class="menu-item border-dashed">
                        <a href="/app-add-recipe.jsp">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">Dodaj przepis</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="/app-add-schedule.jsp">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">Dodaj plan</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">Dodaj przepis do planu</span>
                        </a>
                    </div>
                </div>

                <div class="dashboard-alerts">
                    <div class="alert-item alert-info">
                        <i class="fas icon-circle fa-info-circle"></i>
                        <span class="font-weight-bold">Liczba przepisów: ${recipesCount}</span>
                    </div>
                    <div class="alert-item alert-light">
                        <i class="far icon-calendar fa-calendar-alt"></i>
                        <span class="font-weight-bold">Liczba planów: ${plansCount}</span>
                    </div>
                </div>
            </div>
            <div class="m-4 p-4 border-dashed">
                <h2 class="dashboard-content-title">
                    <span>Ostatnio dodany plan:</span><c:if test="${not empty lastPlan.name}"> ${lastPlan.name}</c:if><c:if test="${empty lastPlan.name}"> Brak planów</c:if>
                </h2>
                <c:if test="${not empty pon}">

                <table class="table">
                    <thead>
                    <tr class="d-flex">
                        <th class="col-2">Poniedziałek</th>
                        <th class="col-8"></th>
                        <th class="col-2"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pon}" var="rep">
                    <tr class="d-flex">
                        <td class="col-2">${rep.mealName}</td>
                        <td class="col-8">${rep.recipeName}</td>
                        <td class="col-2"><button onclick="location.href='/recipeDetails?recipeId=${rep.recipeId}'" type="button" class="btn btn-primary rounded-0">Szczegóły</button></td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>

                </c:if>

                <c:if test="${not empty wt}">

                    <table class="table">
                        <thead>
                        <tr class="d-flex">
                            <th class="col-2">Wtorek</th>
                            <th class="col-8"></th>
                            <th class="col-2"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${wt}" var="rep">
                            <tr class="d-flex">
                                <td class="col-2">${rep.mealName}</td>
                                <td class="col-8">${rep.recipeName}</td>
                                <td class="col-2"><button onclick="location.href='/recipeDetails?recipeId=${rep.recipeId}'" type="button" class="btn btn-primary rounded-0">Szczegóły</button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </c:if>

                <c:if test="${not empty sr}">

                    <table class="table">
                        <thead>
                        <tr class="d-flex">
                            <th class="col-2">Środa</th>
                            <th class="col-8"></th>
                            <th class="col-2"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sr}" var="rep">
                            <tr class="d-flex">
                                <td class="col-2">${rep.mealName}</td>
                                <td class="col-8">${rep.recipeName}</td>
                                <td class="col-2"><button onclick="location.href='/recipeDetails?recipeId=${rep.recipeId}'" type="button" class="btn btn-primary rounded-0">Szczegóły</button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </c:if>

                <c:if test="${not empty czw}">

                    <table class="table">
                        <thead>
                        <tr class="d-flex">
                            <th class="col-2">Czwartek</th>
                            <th class="col-8"></th>
                            <th class="col-2"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${czw}" var="rep">
                            <tr class="d-flex">
                                <td class="col-2">${rep.mealName}</td>
                                <td class="col-8">${rep.recipeName}</td>
                                <td class="col-2"><button onclick="location.href='/recipeDetails?recipeId=${rep.recipeId}'" type="button" class="btn btn-primary rounded-0">Szczegóły</button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </c:if>

                <c:if test="${not empty pt}">

                    <table class="table">
                        <thead>
                        <tr class="d-flex">
                            <th class="col-2">Piątek</th>
                            <th class="col-8"></th>
                            <th class="col-2"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pt}" var="rep">
                            <tr class="d-flex">
                                <td class="col-2">${rep.mealName}</td>
                                <td class="col-8">${rep.recipeName}</td>
                                <td class="col-2"><button onclick="location.href='/recipeDetails?recipeId=${rep.recipeId}'" type="button" class="btn btn-primary rounded-0">Szczegóły</button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </c:if>

                <c:if test="${not empty sob}">

                    <table class="table">
                        <thead>
                        <tr class="d-flex">
                            <th class="col-2">Sobota</th>
                            <th class="col-8"></th>
                            <th class="col-2"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sob}" var="rep">
                            <tr class="d-flex">
                                <td class="col-2">${rep.mealName}</td>
                                <td class="col-8">${rep.recipeName}</td>
                                <td class="col-2"><button onclick="location.href='/recipeDetails?recipeId=${rep.recipeId}'" type="button" class="btn btn-primary rounded-0">Szczegóły</button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </c:if>

                <c:if test="${not empty ndz}">

                    <table class="table">
                        <thead>
                        <tr class="d-flex">
                            <th class="col-2">Niedziela</th>
                            <th class="col-8"></th>
                            <th class="col-2"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${ndz}" var="rep">
                            <tr class="d-flex">
                                <td class="col-2">${rep.mealName}</td>
                                <td class="col-8">${rep.recipeName}</td>
                                <td class="col-2"><button onclick="location.href='/recipeDetails?recipeId=${rep.recipeId}'" type="button" class="btn btn-primary rounded-0">Szczegóły</button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </c:if>

            </div>
        </div>
    </div>
</section>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>