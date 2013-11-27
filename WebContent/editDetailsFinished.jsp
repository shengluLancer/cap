<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import="javax.servlet.http.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">



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

<title>Order Delivery Summary</title>
<style> 
.div-a{ float:left;width:40%} 
.div-b{ float:left;width:25%}
.div-c{ float:left;width:47%}
</style>

</head>
<body>

<div id="topbar">
	<div id="leftnav">
		<a href="summary.jsp">Back</a></div>

	<div id="title">
		 Pickup & Deliver</div>
</div>
<div id="content">
    	<fieldset>
    	<%
		if(request.getAttribute("error")!=null){
			out.print("<div><span class='redtitle'>Fields can not be empty!</span><br/><br/></div>");
		}
		%>
		
		<form action="getDeliverLocInitAction.do" method="get">
    	<span class="graytitle">Address & Building</span>
		<ul class="pageitem">
			<li class="bigfield"><input type="text" name="address" readonly value="<%=request.getAttribute("address")%>" /></li>
		</ul>
		<input type="hidden" id="mode" name="mode" value="1"></input>
		<input type="hidden" id="latitude" name="latitude" value="<%=request.getAttribute("latitude")%>"></input>
		<input type="hidden" id="longitude" name="longitude" value="<%=request.getAttribute("longitude")%>"></input>
		<ul class="pageitem">   
		    <li class="button"><input name="Edit" type="submit" value="Edit"/></li>
		</ul>
		</form>
		
		<form action="describe.do" onsubmit="updateAddr()" method="post">
		<input type="hidden" id="finalLatitude" name="finalLatitude" value=""></input>
		<input type="hidden" id="finalLongitude" name="finalLongitude" value=""></input>
		<input type="hidden" id="finalAddress" name="finalAddress" value=""></input>
		
		<span class="graytitle">Detail Description (bld, fl, room)</span>
		<ul class="pageitem">
			<li class="bigfield"><input placeholder="Enter Description" type="text" name="description" /></li>
		</ul>
		<span class="graytitle">How many items to deliver?</span>
		<ul class="pageitem">
			<li class="bigfield"><input placeholder="Enter Number" type="text" name="amount" /></li>
		</ul>
		<ul class="pageitem">
			<li class="button">
			<input name="Confirm" type="submit" value="Confirm"/></li>
		</ul>
		</form>
		</fieldset>
</div>
<div id="footer">
	<a class="noeffect">App powered by Coding Tartans</a></div>

</body>

</html>
