<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@page import="javax.servlet.http.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sears.SYWL.p2p.dal.*"%>
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

<title>Order Delivery Summary</title>
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
function change(id) {
	location.href = "editDetails.jsp?entry_id="+id;
}

function viewDetails(id) {
	location.href="viewDetails.jsp?entry_id="+id;
}

function turnToGray(n) {
	document.getElementById('my_submit_button'+n).disabled = 'disabled';
	document.getElementById('my_submit_button'+n).setAttribute("value", "Notification Sent!");
}

</script>

<body>
<%
// the summary for this page
	Summary ss = (Summary)session.getAttribute("my_summary");
	Iterator<SummaryEntry> entryIterator = ss.getEntryList().iterator();
	
%>

<div id="topbar">
	<div id="title">
		 Send Message</div>
</div>
<div id="content">
    <% 
    	int counter=0;
    	while(entryIterator.hasNext()) {
    	counter++;
    	SummaryEntry summaryEntry = entryIterator.next();
    	String method = summaryEntry.getDeliverMethod();
    	if(method.equals("pickup")){
    	Iterator<Order> orderIterator = summaryEntry.getOrders().iterator();
    %>
    	<div class="div-d">
    	<ul class="pageitem">
		<li class="textbox"><span class="header"> <font size="5"><%="Store #" + summaryEntry.getStoreId() %></font></span><br>
    	</li>
    	<% while(orderIterator.hasNext()){ 
    		   Order order = orderIterator.next();
    		   double price = order.getPreTaxPrice() + order.getTax();
    	%>
    	<li> <div class="div-a" style="margin-left:10%;font-size:15pt"><%=order.getOrderName()%></div> 
    		 <div class="div-b" style="font-size:15pt"><%=order.getCount()%></div>  
    		 <div class="div-b" style="font-size:15pt"><%="$"+ price + " (tax: " + order.getTax() + ")" %></div> 
    	</li>
		<li> <div class="div-a" style="margin-left:10%;font-size:15pt">Subtotal</div>
			 <div class="div-c" style="margin-right:2%;font-size:15pt"><%=order.getTotalPrice()%></div> 
		</li> 
    	<% }%>
    	 </ul>
	    </div>
	    
	    <div class="div-e">
		<ul class="pageitem">
			<li class="button">
			<input name="sendMessage" type="submit" id="<%="my_submit_button"+counter %>" value="Send Notification" onclick="turnToGray(<%=counter%>)"/></li>
		</ul>
		</div>
		
		<input type="hidden" name="status" value="<%=method%>" />
		<%}%>
    <% }%>
		
</div>
<div id="footer">
	<a class="noeffect">App powered by Coding Tartans</a>
	</div>
</body>

</html>
