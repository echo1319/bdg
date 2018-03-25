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
    <link href="fonts.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
                <li class="current_page_item"><a href="#" accesskey="1"
                                                 title=""><@spring.message "menu.category.main"/></a></li>
                <li><a href="#" accesskey="2" title=""><@spring.message "menu.category.info"/></a></li>
                <li><a href="#" accesskey="3" title=""><@spring.message "menu.category.aboutUs"/></a></li>
                <li><a href="#" accesskey="5" title=""><@spring.message "menu.category.contact"/></a></li>
            </ul>
        </div>
    </div>
</div>
<div id="header-featured">
    <div id="banner-wrapper">
        <div id="banner" class="container">

            <a href="#" class="button">Περισσότερα</a>
        </div>
    </div>
</div>
<div id="wrapper">
    <div id="featured-wrapper">
        <div id="featured" class="extra2 margin-btm container">
            <div class="main-title">
                <h2>Ατμοσφαιρικές Συνθήκες</h2>
<#--
                <span class="byline">Integer sit amet pede vel arcu aliquet pretium</span>
-->
            </div>
            <div class="ebox1"><span class="fa fa-temperature"></span>
                <div class="title">
                    <h2>Θερμοκρασία</h2>
                </div>
                <div class="byline">30</div>

            </div>
            <div class="ebox2"><span class="fa fa-water"></span>
                <div class="title">
                    <h2>Υγρασία</h2>
                    <div class="byline">50%</div>
                </div>
            </div>

<#--            <a href="#" class="button">Etiam posuere</a></div>-->



    <div class="extra2 container">

        <div class="ebox1"><span class="fa fa-wind"></span>
            <div class="title">
                <h2>Άνεμος</h2>

                <div class="byline">25</div>
            </div>
        </div>

        <div class="ebox2"><span class="fa fa-wind-direction"></span>
            <div class="title">
                <h2>Κατεύθυνση Ανέμου</h2>

                <div class="byline">25</div>
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
