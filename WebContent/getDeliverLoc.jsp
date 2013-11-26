<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import="javax.servlet.http.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%
   /* String userId = request.getParameter( "userId" ); */
   session.setAttribute( "userId", 1);
%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="index,follow" name="robots" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link href="pics/homescreen.gif" rel="apple-touch-icon" />
<meta content="minimum-scale=1.0, width=device-width, maximum-scale=0.6667, user-scalable=no" name="viewport" />
<link href="css/style.css" rel="stylesheet" media="screen" type="text/css" />
<script src="javascript/functions.js" type="text/javascript"></script>
<script src="javascript/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="javascript/jquery.stayInWebApp.js" type="text/javascript"></script>
<script src="javascript/stay.js" type="text/javascript"></script>

<script type="text/javascript"> 
    function updateAddr() {
    	var address = document.getElementById("address");
    	var latitude = document.getElementById("latitude");
    	var longitude = document.getElementById("longitude");
    	document.getElementById("finalAddress").setAttribute("value", address.getAttribute("value"));
    	document.getElementById("finalLatitude").setAttribute("value", latitude.getAttribute("value"));
    	document.getElementById("finalLongitude").setAttribute("value", longitude.getAttribute("value"));
    }

</script>

<title>Get Items Delivered</title>
<style> 
.div-a{ float:left;width:40%} 
.div-b{ float:left;width:25%}
.div-c{ float:left;width:47%}
</style>


<body>

<div id="topbar">
	<div id="leftnav">
		<a href="summary.jsp">Back</a></div>

	<div id="title">
		 Get Items Delivered</div>
</div>
<div id="content">
    <form action="getDeliverLocInitAction.do" method="get">
    	<fieldset>
    	<span class="graytitle">Your Location</span>
		<ul class="pageitem">
			<li class="bigfield"><input placeholder="Current Address" type="text" id="address" name="address" readonly value="5030 Centre Ave Pittsburgh"/></li>
		</ul>
		<input type="hidden" id="latitude" name="latitude" value="40.4443411"></input>
		<input type="hidden" id="longitude" name="longitude" value="-79.94392949999997"></input>
		<ul class="pageitem">   
		    <li class="button"><input name="Edit" type="submit" value="Edit"/></li>
		</ul>
	</form>
	<form action="deliveryConfirmAction.do" onsubmit="updateAddr()" method="get">
	    <input type="hidden" id="finalLatitude" name="finalLatitude" value=""></input>
		<input type="hidden" id="finalLongitude" name="finalLongitude" value=""></input>
		<input type="hidden" id="finalAddress" name="finalAddress" value=""></input>
		<span class="graytitle">Pick up Range  (miles)</span>
		<ul class="pageitem">
			<li class="bigfield"><input placeholder="Enter Pickup Range" type="text" id="range" name="range" value="0.1" /></li>
		</ul>
		<ul class="pageitem">
			<li class="button"><input name="Confirm" type="submit" value="Confirm"/></li>
		</ul>
		</fieldset>
	</form>
</div>
<div id="footer">
	<a class="noeffect">App powered by Coding Tartans</a></div>

</body>

</html>
