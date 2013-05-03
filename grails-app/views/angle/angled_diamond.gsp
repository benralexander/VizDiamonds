<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>ui tests</title>
    <link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'cow.css')}"/>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

    <script src="http://d3js.org/d3.v3.min.js"></script>
    <style>

    /*body {*/
        /*font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;*/
        /*margin: auto;*/
        /*position: relative;*/
        /*width: 960px;*/
    /*}*/

    /*form {*/
        /*position: absolute;*/
        /*right: 10px;*/
        /*top: 10px;*/
    /*}*/

    </style>
</head>
<body>
<div id="foo"></div>
<script>
    <g:makeSunburst />
//    var width = 960,
//            height = 700,
//            radius = Math.min(width, height) / 2,
//            color = d3.scale.category10().domain([
//                "A",
//                "FLINA",
//                "C",
//                "B",
//                "FLINC",
//                "ABC",
//                "AA"
//            ]);
    </script>
    <script type="text/javascript" src="../js/sunburstPrep.js"></script>
    </body>
</html>

