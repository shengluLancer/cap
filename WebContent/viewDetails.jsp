<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@page import="javax.servlet.http.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sears.SYWL.p2p.dal.*"%>
<%@page import="com.sears.SYWL.p2p.dao.*"%>
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

<title>View Details</title>
<style> 
.div-a{ float:left;width:40%} 
.div-b{ float:left;width:25%}
.div-c{ float:left;width:47%}
.div-d{ float:left;width:70%}
.div-e{ float:left;width:30%}

.div-f{ clear:both}

</style>
</head>
<script>
function change() {
	location.href = "editDetails.jsp";
}
</script>

<body>
<%
// the summary for this page
    SummaryEntryDao seo = new SummaryEntryDaoImpl();
	int summaryEntryId = new Integer(request.getParameter("entry_id"));
	SummaryEntry summaryEntry = seo.loadSummaryEntryById(summaryEntryId);
	String method = summaryEntry.getDeliverMethod();
	Iterator<Order> orderIterator = summaryEntry.getOrders().iterator();
%>

<div id="topbar">
	<div id="title">
		 Order Details</div>
</div>
<div id="content">
    	<ul class="pageitem">
		<li class="textbox"><span class="header"> <font size="5"><%="I am store #" + summaryEntry.getStoreId() %></font></span>
    	</li>
    	<% while(orderIterator.hasNext()){ 
    		   Order order = orderIterator.next();
    		   double price = order.getPreTaxPrice() + order.getTax();
    	%>
    	<li> <div class="div-a" style="margin-left:10%;font-size:15pt"><%=order.getOrderName()%></div> 
    		 <div class="div-b" style="font-size:15pt"><%=order.getCount()%></div>  
    		 <div class="div-b" style="font-size:15pt"><%="$"+ price + " (tax: " + order.getTax() + ")" %></div> 
    	</li> 
    	<% }%>
    	<%=method %>
    	 </ul>
	    
	    <%if (method.equals("pickup")){%>
	    <ul class="pageitem">
			<li>Subtotal Price: <%= summaryEntry.getSubtotalPrice()%>></li>
			<li>Deliver Method: <%= method %></li>
			<% if(summaryEntry.getMaxDeliverCount() > 0) { %>
			    <li>You choose to deliver for other people</li>
			    <li>Max Deliver Count: <%= summaryEntry.getMaxDeliverCount()%>></li>
			    <li>Deliver Address: <%= summaryEntry.getDeliverLocation().getAddress() %></li>
			    <li>Detailed Detailed Description: <%= summaryEntry.getDetailedDescription()%></li>
			    <li>Max SYWL Points: <%= summaryEntry.getMaxPoints() %></li>
			    <li>These orders are placed at time: <%= summaryEntry.getDeliverTime() %></li>
			<% } %>
		</ul>
		<%}%>
        <%if (method.equals("delivered")){%>
		<ul class="pageitem">
			<li>Deliver Address: <%= summaryEntry.getDeliverLocation().getAddress() %></li>
		</ul>
		<%}%>
		</div>
		
		<div class="div-f">
		<ul class="pageitem">
			<li class="button">
<!-- 			<a href="summary.jsp" class="button">Submit</a> -->
				<input type="submit" value="Return" onclick="window.location.href='summary.jsp'; return false;"/>
			</li>
		</ul>
</div>
<div id="footer">
	<a class="noeffect">App powered by Coding Tartans</a>
	</div>
</body>

</html>
