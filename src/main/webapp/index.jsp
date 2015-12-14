<!DOCTYPE HTML>
<html>
<head>
  <title>Pacte des chiens | Éducateur et comportementaliste sur Rennes et sa périphérie </title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta name="keywords" content="Pacte des chiens, Educateur, canin, Rennes, Chiens, Dog, comportementaliste"/>
  <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
  <link href="css/style.css" rel='stylesheet' type='text/css'/>
  <link href='http://fonts.googleapis.com/css?family=Lobster|Raleway:500,400,300' rel='stylesheet' type='text/css'>
  <base href="/">
</head>
<body ng-app="pactedeschiens">
<div ng-show="homeHeader">
  <header></header>
</div>
<div ng-show="!homeHeader">
  <smallheader></smallheader>
</div>

<ng-view></ng-view>

<footer></footer>

<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover"
                                                                         style="opacity: 1;"> </span></a>
<script src="js/jquery.min.js"></script>
<script src="js/move-top.js"></script>
<script src="js/easing.js"></script>
<script src="js/responsiveslides.min.js"></script>
<script src="js/angular.min.js"></script>
<script src="js/angular-route.js"></script>
<script src="js/app.js"></script>
<script src="js/route/route.js"></script>
<script src="js/directive/header.js"></script>
<script src="js/directive/smallheader.js"></script>
<script src="js/directive/footer.js"></script>
<script src="js/controller/homeController.js"></script>
<script src="js/controller/aboutController.js"></script>
<script src="js/controller/blogController.js"></script>
<script src="js/controller/messageController.js"></script>
<script src="js/controller/partenairesController.js"></script>
<script src="js/controller/servicesController.js"></script>
<script src="js/animations.js"></script>

</body>
</html>