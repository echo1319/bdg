<!DOCTYPE HTML>
<!--
	Industrious by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Big Green Data</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <link rel="stylesheet" href="/assets/css/main.css"/>

    <!-- Scripts  jquery and chart js need to be together in the header-->
    <script src="/assets/js/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>

</head>
<body class="is-preload">

<!-- Header -->
<header id="header">
    <a class="logo" href="/">Big Green Data</a>
    <nav>
        <a href="#menu">Μενού</a>
    </nav>
</header>

<!-- Nav -->
<nav id="menu">
    <ul class="links">
        <li><a href="/">Αρχική</a></li>
        <li><a href="/garden">Ο Κήπος</a></li>
        <li><a href="/info">Ποιότητα Ατμόσφαιρας</a></li>
        <li><a href="/team">Η ομάδα</a></li>
        <li><a href="/contact">Επικοινωνία</a></li>

    </ul>
</nav>

<!-- Banner -->
<section id="banner">
    <div class="inner">
        <h1>Ο Εθνικος Κηπος</h1>
    </div>
    <video autoplay loop muted playsinline src="/images/banner.mp4"></video>
</section>


<!-- Main -->
<section id="main" class="wrapper">
    <div class="inner">
        <div class="content">
            <header>
                <h2> Ατμοσφαιρικοι Δεικτες</h2>
            </header>

            <h3> Ταξινόμηση ποιότητας αέρα ERPI</h3>
            <div class="table-wrapper">
                <table>
                    <thead>
                    <tr>
                        <th>ERPI</th>
                        <th>Tαξη Μεγεθους</th>
                        <th>Ποιότητας αέρα</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td> 0 – 2</td>
                        <td> 1</td>
                        <td>Πολύ καλή</td>
                    </tr>

                    <tr>
                        <td> 2 – 21</td>
                        <td> 2</td>
                        <td>Καλή</td>
                    </tr>

                    <tr>
                        <td> 21-40</td>
                        <td> 3</td>
                        <td>Ικανοποιητική</td>
                    </tr>


                    <tr>
                        <td> 60 – 79</td>
                        <td> 5</td>
                        <td>Κακή</td>
                    </tr>

                    <tr>
                        <td> >79</td>
                        <td> 6</td>
                        <td>Πολύ κακή</td>
                    </tr>


                    </tbody>
                    <tfoot>

                    <tr>
                        <td colspan="2"></td>
                    </tr>
                    </tfoot>
                </table>

            </div>

        </div>
</section>




        <#include "footer.ftl"/>

<!-- Scripts -->
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/js/browser.min.js"></script>
<script src="/assets/js/breakpoints.min.js"></script>
<script src="/assets/js/util.js"></script>
<script src="/assets/js/main.js"></script>

</body>
</html>