<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import="javax.servlet.http.*"%>
<%@ page import="com.sears.SYWL.p2p.controller.*"%>
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

<title>Welcome</title>
<style> 
.div-a{ float:left;width:36%} 
.div-b{ float:left;width:25%}
.div-c{ float:left;width:50%}
.div-d{ float:left;width:28%}
.div-e{ float:left;width:100%}
.div-f{ float:left;width:4%}
</style>

<script type="text/javascript"> 
    function phoneNum1LoseFocus(obj) {
     	if(obj.value.length == 3) {
    		document.getElementById("phoneNum2").focus();
    	}	
    }
    
    function phoneNum2LoseFocus(obj) {
     	if(obj.value.length == 3) {
    		document.getElementById("phoneNum3").focus();
    	}	
    }
</script>


<body>

<div id="topbar">

	<div id="title">
		 SHOP Your Way</div>
</div>
<div id="content">
    <form action="welcomeAction.do" method="get">
    	<fieldset>
    	
		<span class="graytitle">Welcome to SHOP Your Way!</span><br></br>
		<span class="graytitle">Please enter your name</span><br></br>
		   <div class="div-c"><ul class="pageitem"><li class="bigfield"><input placeholder="First Name" type="text" id="firstName" name="firstName"/></li></ul></div>
		   <div class="div-c"><ul class="pageitem"><li class="bigfield"><input placeholder="Last Name" type="text" id="lastName" name="lastName"/></li></ul></div>
		<span class="graytitle">Please enter your phone number</span><br></br>
			<div class="div-d"><ul class="pageitem"><li class="bigfield"><input placeholder="xxx" type="text" id="phoneNum1" name="phoneNum1" onkeyup="phoneNum1LoseFocus(this)"/></li></ul></div>
			<div class="div-f" style="font-size:22pt">-</div>
			<div class="div-d"><ul class="pageitem"><li class="bigfield"><input placeholder="xxx" type="text" id="phoneNum2" name="phoneNum2" onkeyup="phoneNum2LoseFocus(this)"/></li></ul></div>
			<div class="div-f" style="font-size:22pt">-</div>
			<div class="div-a"><ul class="pageitem"><li class="bigfield"><input placeholder="xxxx" type="text" id="phoneNum3" name="phoneNum3"/></li></ul></div>
		<div class="div-e">
		<ul class="pageitem">
			<li class="button"><input type="submit" value="Confirm"/></li>
		</ul>
		</div>
		
		</form>
		</fieldset>
	</form>
</div>
<div id="footer">
	<a class="noeffect">App powered by Coding Tartans</a></div>

</body>

</html>
