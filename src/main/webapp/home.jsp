<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Zaplanuj Jedzonko</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>
<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="/" class="navbar-brand main-logo">
            Zaplanuj <span>Jedzonko</span>
        </a>
        <ul class="nav nounderline text-uppercase">
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="login.html">logowanie</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="registration.jsp">rejestracja</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link" href="/aboutapplication">o aplikacji</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="recipes.html">Przepisy</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="/contact">Kontakt</a>
            </li>
        </ul>
    </nav>
</header>

<section class="padding-large bg-light">
    <div id="carouselExampleControls" class="carousel slide main-slider" data-ride="carousel">
        <div class="carousel-inner container">
            <div class="carousel-item active">
                <div class="container w-75 d-flex">
                    <div class="carousel-caption d-block">
                        <h1>Lorem ipsum dolor sit amet</h1>
                        <h3> consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
                            magna aliqua.</h3>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container w-75 d-flex">
                    <div class="carousel-caption d-block">
                        <h1>Torem ipsum dolor sit amet</h1>
                        <h3> consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
                            magna aliqua.</h3>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container w-75 d-flex">
                    <div class="carousel-caption d-block">
                        <h1>Borem ipsum dolor sit amet</h1>
                        <h3> consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
                            magna aliqua.</h3>
                    </div>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</section>

<section class="section-more padding-small">
    <div class="container d-flex justify-content-between">
        <div class="mr-4">
            <h1 class="pb-3">Lorem ipsum dolor sit amet</h1>
            <h4 class="pt-1">consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
                magna aliqua.</h4>
        </div>
        <div class="ml-4 align-self-center">
            <button class="btn btn-color rounded-0 mt-4 pl-4 pr-4">
                <a href="index.html">Lorem ipsum</a>
            </button>
        </div>
    </div>
</section>

<section class="padding-small details bg-light">
    <div class="container">
        <div class="row">
            <div class="col text-center">
                <i class="fas fa-check icon-details"></i>
                <h1>Lorem ipsum dolor sit amet</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at porttitor sem.  Aliquam erat volutpat. Donec placerat nisl magna, et faucibus arcu condimentum sed.
                </p>
            </div>
            <div class="col text-center pr-4 pl-4 mr-4 ml-4">
                <i class="far fa-clock icon-details"></i>
                <h1>Lorem ipsum dolor sit amet</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at porttitor sem.  Aliquam erat volutpat. Donec placerat nisl magna, et faucibus arcu condimentum sed.
                </p>
            </div>
            <div class="col text-center">
                <i class="fas fa-list icon-details"></i>
                <h1>Lorem ipsum dolor sit amet</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at porttitor sem.  Aliquam erat volutpat. Donec placerat nisl magna, et faucibus arcu condimentum sed.
                </p>
            </div>
        </div>
    </div>
</section>


<section class="newsletter-section padding-small">
    <div class="container">
        <div class="row">
            <div class="col">
                <h1>Lorem ipsum dolor sie amet</h1>
            </div>
            <div class="col-5">
                <div class="input-group mb-3">
                    <input type="text" class="form-control border-0 rounded-0" placeholder=""
                           aria-label="Recipient's username" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <button class="input-group-text btn-color border-0 rounded-0" type="submit" id="basic-addon2">
                            <a href="index.html">Lorem</a>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="padding-medium story bg-light" id="about">
    <div class="container d-flex justify-content-center align-items-center">
        <div class="row">
            <div class="col-4 mr-4">
                <div class="div-img">
                </div>
            </div>

            <div class="col-7 ml-4">
                <h1 class="pb-1">Lorem ipsum dolor sit amet</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at porttitor sem. Aliquam erat
                    volutpat. Donec placerat nisl magna, et faucibus arcu condimentum sed. Lorem ipsum dolor sit
                    amet, consectetur adipiscing elit. Aliquam at porttitor sem. Aliquam erat volutpat. Donec
                    placerat nisl magna, et faucibus arcu condimentum sed.
                </p>
            </div>
        </div>
    </div>
</section>

<section class="last-info-section padding-small" id="contact">
    <div class="container">
        <div class="row">
            <div class="col">
                <h3 class="mb-4">Lorem ipsum dolor</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at porttitor sem.  Aliquam erat volutpat. Donec placerat nisl magna.</p>
            </div>
            <div class="col pl-4 ml-4">
                <h3 class="mb-4">Lorem ipsum dolor</h3>
                <ul class="container">
                    <li>consectetur adipiscing elit</li>
                    <li>sed do eiusmod tempor</li>
                    <li>incididunt ut labore</li>
                    <li>et dolore magna aliqua</li>
                </ul>
            </div>
            <div class="col">
                <h3 class="mb-4">Lorem ipsum dolor</h3>
                <div class="input-group mb-3">
                    <input type="text" class="form-control border-0 rounded-0" placeholder=""
                           aria-label="Recipient's username" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <button class="input-group-text btn-color border-0 rounded-0" type="submit" id="basic-addon2"><a
                                href="index.html">Lorem</a></button>
                    </div>
                </div>
                <div class="container d-flex-row">
                    <a href="#">
                        <i class="fab fa-facebook-square mr-4 icon-social"></i>
                    </a>
                    <a href="#">
                        <i class="fab fa-twitter-square mr-4 icon-social"></i>

                    </a>
                    <a href="#">
                        <i class="fab fa-instagram icon-social"></i>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
<footer class="footer-section pt-3 pb-3">
    <div class="container text-center">
        <h5 class="text-light">Copyright <span class="footer-text-color">ZaplanujJedzonko.pl</span></h5>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>