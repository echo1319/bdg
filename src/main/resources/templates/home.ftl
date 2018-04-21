<#--<#ftl encoding="ISO-8859-7">-->
<#import "/spring.ftl" as spring>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : LawnLike
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20131202
Vectors used from:
https://www.vecteezy.com/vector-art/93066-free-vector-weather-icon-set

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet"/>
    <link href="default.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="animate.css" rel="stylesheet" type="text/css" media="all"/>

    <link href="fonts.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!--[if IE 6]>
    <link href="default_ie6.css" rel="stylesheet" type="text/css"/><![endif]-->

</head>
<body>


<div id="header-wrapper">
    <div id="header" class="container">
        <div id="logo">
            <h1><span class="fa fa-bolt"></span><a href="#"><@spring.message "site.logo"/></a></h1>
        </div>
        <div id="menu">
            <ul>
                <li class="current_page_item"><a href="#" accesskey="1" title="">ΑΡΧΙΚΗ</a></li>
                <li><a href="#" accesskey="2" title="">ΠΛΗΡΟΦΟΡΙΕΣ</a></li>
                <li><a href="#" accesskey="3" title="">ΟΜΑΔΑ</a></li>
                <li><a href="#" accesskey="5" title="">ΕΠΙΚΟΙΝΩΝΙΑ</a></li>
            </ul>
        </div>
    </div>
</div>


<div id="header-featured">
    <div id="banner-wrapper">
        <div style="text-align: center">
            <h1>Ο Κήπος Σήμερα</h1>
            <br>
            <img class="fadeIn animated" src="/images/spring.jpg" alt="test"/>
        </div>
    </div>
    <br>
    <br>
    <br>
    <div style="extra2 margin-btm container"></div>
    <div id="banner-wrapper">
        <div id="banner" class="container">

            <h2>Ποιότητα Ατμόσφαιρας </h2>
            <div class="canvas-holder" style="width:40%; height: 60%; display: inline-block">
                <canvas id="donutChartERPI" width="350px;" height="350px;">
                    <script src="scripts/donut.js" type='text/javasript'></script>
                </canvas>
            </div>


            <#--<div class="canvas-holder-second" style="width:40%; height: 60%; display: inline-block">
                <canvas id="donutChartHumidex" width="350px;" height="350px; ">
                    <script src="scripts/donut.js" type='text/javascript'></script>
                </canvas>
            </div>-->

            <a href="#" class="button" style="display: none" onclick="showInfoDiv()">Περισσοτερα</a>

            <div id="infoDiv" style="display:none;" class="infoDiv"></div>


            <div> Ο Δείκτης AQI</div>
        </div>
    </div>
</div>
<div id="wrapper">
    <div id="featured-wrapper">
        <div id="featured" class="extra2 margin-btm container">
            <div class="main-title">
                <h2>Ατμοσφαιρικές Συνθήκες</h2>
                <br>
            </div>

            <div class="ebox1"><span class="fa fa-temperature"></span>
                <div class="title">
                    <h2>Θερμοκρασία</h2>
                    <h3>${temperature} oC</h3>
                </div>

            </div>

            <div class="ebox2"><span class="fa fa-water"></span>
                <div class="title">
                    <h2>Υγρασία</h2>
                    <h3>${humidity} %</h3>
                </div>
            </div>
        </div>

        <div class="extra2 container">

            <div class="ebox1"><span class="fa fa-wind"></span>
                <div class="title">
                    <h2>Άνεμος</h2>
                    <h3>${windSpeed} Km/h</h3>
                </div>
            </div>

            <div class="ebox2"><span class="fa fa-wind-direction"></span>
                <div class="title">
                    <h2>Κατεύθυνση Ανέμου</h2>
                    <h3>${windDirection}</h3>
                </div>
            </div>
        </div>

    </div>
</div>

<div id="copyright" class="container">
    <p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a
            href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>
