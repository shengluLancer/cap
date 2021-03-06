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

<title>Get Items Delivered</title>

<script type="text/javascript"> 
    function switchItem() {
    	window.location.reload();
    }
</script>


<body>

<div id="topbar">

	<div id="title">
		 SHOP Your Way</div>
</div>
<div id="content">
    <form action="addItemAction.do" method="get">
    	<fieldset>
    	
    	<%  
    	int num = 1;
    	session = request.getSession();
    	
    	if(session.getAttribute("entry_data_number")==null) {

        	session.setAttribute("entry_data_number", 1);	
    	}
    	else {
    		num = (Integer)session.getAttribute("entry_data_number");
    		num++;
    		if(num == 4) {
    			num =1;
    		}
    		session.setAttribute("entry_data_number", num);
    		
    	}
    	
    	
    	%>
    	
				    	<% if(num==1) {
				    	%>
				    	
				    	<span class="graytitle"><%= Controller.api.getStoreDao().loadStoreById(1).getStoreName() %></span>
						<ul class="pageitem">
							<li class="bigfield"><input type="text" id="item" name="item" readonly value="Beef Burger * 1"/></li>
						</ul>
						
						<% } %>
						
						
						<% if(num==2) {
				    	%>
				    	
				    	<span class="graytitle"><%=Controller.api.getStoreDao().loadStoreById(2).getStoreName()%></span>
						<ul class="pageitem">
							<li class="bigfield"><input type="text" id="item" name="item" readonly value="Mocha * 2"/></li>
						</ul>
						
						<% } %>
						
						
						<% if(num==3){
				    	%>
				    	
				    	<span class="graytitle"><%=Controller.api.getStoreDao().loadStoreById(3).getStoreName()%></span>
						<ul class="pageitem">
							<li class="bigfield"><input type="text" id="item" name="item" readonly value="Bubble Tea * 1"/></li>
						</ul>
						
						<% } %>
		
		
		<ul class="pageitem">
			<li class="button"><input name="buy" id="buy" type="submit" value="BUY"/></li>
		</ul>
		
		<ul class="pageitem">
			<li class="button"><input name="buy" id="buy" type="button" value="Switch Store & Item" onclick="switchItem()"/></li>
		</ul>
		
		</form>
		</fieldset>
	</form>
</div>
<div id="footer">
	<a class="noeffect">App powered by Coding Tartans</a></div>

</body>

</html>
