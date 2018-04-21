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



<!-- Highlights -->
<section class="wrapper">
    <div class="inner">
        <header class="special">
            <h2>Ατμοσφαιρικες συνθηκες</h2>
            <p>Η ποιότητα της ατμόσφαιρας στον Κήπο, συγκρινόμενη με τις αντίστοιχες συνθήκες στο κέντρο της πόλης.</p>
        </header>


        <div class="highlights">
            <div class="content" style="width: 50%;">
                <h3>Ποιότητα ατμόσφαιρας στον Κήπο</h3>
                <p> Δεικτης ERPI και ΑQI</p>
                <div class="canvas-holder">
                    <canvas id="erpiGarden">
                              <#include "charts/erpiGarden.ftl">
                    </canvas>
                </div>
            </div>

            <div class="content" style="width: 50%;">

                <h3>Ποιότητα ατμόσφαιρας στο Σύνταγμα</h3>
                <p> Δεικτης ERPI και ΑQI</p>
                <div class="canvas-holder">
                    <canvas id="erpiCity">
                            <#include "charts/erpiCity.ftl">
                    </canvas>
                </div>
            </div>

        </div>


        <div class="highlights">
            <div class="content" style="width: 50%;">
                <h3>Ποιότητα ατμόσφαιρας στον Κήπο</h3>
                <p> Δεικτης Humidex </p>
                <div class="canvas-holder">
                    <canvas id="humidexGarden">
                              <#include "charts/humidexGarden.ftl">
                    </canvas>
                </div>
            </div>

            <div class="content" style="width: 50%;">

                <h3>Ποιότητα ατμόσφαιρας στο Σύνταγμα</h3>
                <p> Δεικτης Humidex </p>
                <div class="canvas-holder">
                    <canvas id="humidexCity">
                            <#include "charts/humidexCity.ftl">
                    </canvas>
                </div>
            </div>

        </div>


        <header class="special">
            <h2>Μετρησεις</h2>
        </header>

        <div class="highlights">
            <section>
                <div class="content">


                    <header>
                        <a href="#" class="icon  fa-temperature"><span class="label">Icon</span></a>
                        <h3>Θερμοκρασία</h3>
                    </header>
                    <h3 style="font-weight: bold">${temperature} oC</h3>
                </div>
            </section>
            <section>
                <div class="content">
                    <header>
                        <a href="#" class="icon  fa-water"><span class="label">Icon</span></a>
                        <h3>Υγρασια</h3>
                    </header>
                    <h3 style="font-weight: bold">${humidity} %</h3>
                </div>
            </section>
            <section>
                <div class="content">
                    <header>
                        <a href="#" class="icon  fa-wind"><span class="label">Icon</span></a>
                        <h3>Ανεμος</h3>
                    </header>
                    <h3 style="font-weight: bold">${windSpeed} %</h3>
                </div>
            </section>

            <section>
                <div class="content">
                    <header>
                        <a href="#" class="icon fa-wind-direction"><span class="label">Icon</span></a>
                        <h3>Κατευθυνση Ανεμου</h3>
                    </header>
                    <h3 style="font-weight: bold">${windDirection}</h3>
                </div>
            </section>


            <section>
                <div class="content">
                    <header>
                        <a href="#" class="icon fa-truck-moving"><span class="label">Icon</span></a>
                        <h3>Διοξειδιο του Ανθρακα</h3>
                    </header>
                    <h3 style="font-weight: bold">0.1%</h3>
                </div>
            </section>


            <section>
                <div class="content">
                    <header>
                        <a href="#" class="icon fa-volume-up"><span class="label">Icon</span></a>
                        <h3>Ηχορυπανση</h3>
                    </header>
                    <h3 style="font-weight: bold">10%</h3>
                </div>
            </section>

        </div>

    </div>
</section>

<!-- CTA -->
<section id="cta" class="wrapper">
    <div class="inner">
        <h2>Μια βολτα στον κηπο</h2>
        <p></p>
    </div>
</section>

<!-- Testimonials -->
<section class="wrapper">
    <div class="inner">
        <header class="special">
            <h2>ΕΜΠΕΙΡΙΕΣ ΑΠΟ ΤΟΝ ΚΗΠΟ</h2>
            <p>Ο Εθνικός Κήπος φιλοξενεί κατά μέσο όρο 1000 επισκέπτες μεταξύ των οποίων είναι εκπαιδευτικές εκδρομές
                και περιβαλλοντικές δραστηριότητες. </p>
        </header>
        <div class="testimonials">
            <section>
                <div class="content">
                    <blockquote>
                        <p>Επιλεγμένα Σχόλια επισκεπτών.</p>
                    </blockquote>
                    <div class="author">
                        <div class="image">
                            <img src="/images/pic01.jpg" alt=""/>
                        </div>
                        <p class="credit">- <strong>Jane Doe</strong> <span>CEO - ABC Inc.</span></p>
                    </div>
                </div>
            </section>
            <section>
                <div class="content">
                    <blockquote>
                        <p>Επιλεγμένα Σχόλια επισκεπτών.</p>
                    </blockquote>
                    <div class="author">
                        <div class="image">
                            <img src="/images/pic03.jpg" alt=""/>
                        </div>
                        <p class="credit">- <strong>John Doe</strong> <span>CEO - ABC Inc.</span></p>
                    </div>
                </div>
            </section>
            <section>
                <div class="content">
                    <blockquote>
                        <p>Επιλεγμένα Σχόλια επισκεπτών.</p>
                    </blockquote>
                    <div class="author">
                        <div class="image">
                            <img src="/images/pic02.jpg" alt=""/>
                        </div>
                        <p class="credit">- <strong>Janet Smith</strong> <span>CEO - ABC Inc.</span></p>
                    </div>
                </div>
            </section>
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