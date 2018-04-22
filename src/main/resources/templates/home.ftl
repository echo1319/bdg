<!DOCTYPE HTML>
<!--	Industrious by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)s-->

<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Big Green Data</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <link rel="stylesheet" href="/assets/css/main.css"/>
    <link rel="stylesheet" href="/assets/css/charts.css"/>


    <!-- Scripts  jquery and chart js need to be together in the header-->
    <script src="/assets/js/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>

</head>
<body class="is-preload">

<!-- Header -->
<#include "partial/header.ftl"/>

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
                    <div class="donut-inner">
                        <h5>${gardenErpiStatus}</h5>
                    </div>
                </div>
            </div>

            <div class="content" style="width: 50%;">

                <h3>Ποιότητα ατμόσφαιρας στο Σύνταγμα</h3>
                <p> Δεικτης ERPI και ΑQI</p>

                <div class="canvas-holder">
                    <canvas id="erpiCity">
                            <#include "charts/erpiCity.ftl">
                    </canvas>

                    <div class="donut-inner">
                        <h5>${cityErpiStatus}</h5>
                    </div>
                </div>
            </div>
        </div>


        <div class="highlights">
            <div class="content" style="width: 50%;">
                <h3>Θερμική Αίσθηση στον Κήπο</h3>
                <p> Δεικτης Humidex </p>
                <div class="canvas-holder">
                    <canvas id="humidexGarden">
                              <#include "charts/humidexGarden.ftl">
                    </canvas>
                    <div class="donut-inner">
                        <h5>${gardenHumidexStatus}</h5>
                    </div>
                </div>
            </div>

            <div class="content" style="width: 50%;">
                <h3>Θερμική Αίσθηση στο Σύνταγμα </h3>
                <p> Δεικτης Humidex </p>
                <div class="canvas-holder-humidexCity">
                    <canvas id="humidexCity">
                            <#include "charts/humidexCity.ftl">
                    </canvas>
                    <div class="donut-inner">
                        <h5>${cityHumidexStatus}</h5>
                    </div>
                </div>
            </div>

        </div>

    </div>
</section>



    <#include "partial/experience.ftl"/>

    <#include "partial/footer.ftl"/>

<!-- Scripts -->
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/js/browser.min.js"></script>
<script src="/assets/js/breakpoints.min.js"></script>
<script src="/assets/js/util.js"></script>
<script src="/assets/js/main.js"></script>

</body>
</html>