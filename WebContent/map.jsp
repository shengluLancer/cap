<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import="javax.servlet.http.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">


<head id="Head1" runat="server">  
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

    <title>Choose Location</title>  
    <style> 
    .div-a{ float:left;width:40%} 
    .div-b{ float:left;width:25%}
    .div-c{ float:left;width:47%}
    </style>
  
    <script src="http://maps.google.com/maps?file=api&v=2&AIzaSyA0pN_fGQIvH58XsO8LERRTPOrvSIxHMVk&sensor=false"  
        type="text/javascript"></script>  
         
    <script type="text/javascript">  
    
$(document).ready(function() {
	
	var this_mode = document.getElementById("mode").value;
	// mode 0 : get delivery
	// mode 1 : pick up self
	
	var innerHtml = "";
    
	var target_url;
	document.getElementById("out_mode").setAttribute("value", this_mode);	
	if(this_mode == 0) {
		target_url= "getbuyerlochis.do";
	}
	else{
		//mode == 1
		target_url= "getdellochis.do";
	}
	
	/* console.log(target_url); */
	
    //get location history info
    $.ajax({
    	url : target_url,
    	data : {
    		user_id : <%=request.getAttribute("user_id")%>
    	},
    	success : function(result) {
    		
    		var obj = $.parseJSON( result );
    		var locations = obj.LocationHistory.locations;

        	var i = 1;
          	while(i < locations.length+1 && i < 4 ) {
        		innerHtml += 
        		"<form action=\"#\" onsubmit=\"showAddr(this.hisLoc" + i + ".value); return false\">" +
        		"<ul class=\"pageitem\">" +
                "<li class=\"button\"><input name=\"hisLoc" + i + "\" id=\"hisLoc" + i + "\" type=\"submit\" value=\""+ locations[i-1].address +"\"/></li>" +
                "</ul></form>";
        		i++;
        	} 

        	var locHistDiv = document.getElementById("locHistDiv");
        	locHistDiv.innerHTML = innerHtml;
    		
    	} 
    });
    
    

}) ;
    
    
    //google maps
    
    var i=1;  
    var map;  
    var currentOverlay = null;  
    var geocoder;  
    var address;  
    var gdir;  
    var addressMarker;  
    function load() {  
    	
    	
    	/* var json = JSON.parse(text); */

/*     	document.getElementById("hisLoc1").setAttribute("value",json.location);
    	document.getElementById("hisLoc2").setAttribute("value",json.LocationHistory.locations[1].address); */
    	
 //GBroswerIsCompatible()If Api support this browser  
        if (GBrowserIsCompatible()) {  
            map = new GMap2(document.getElementById("map"));  
            var point = new GLatLng(40.4443411,-79.9439295);  
            map.setCenter(point,16);   
            map.addControl(new GMapTypeControl());          
            var customUI = map.getDefaultUI();    
            customUI.maptypes.hybrid = false;  
            map.enableDoubleClickZoom();  
            map.setUI(customUI);   
            var marker = new GMarker(point);  
            map.addOverlay(marker);  
            geocoder = new GClientGeocoder();  
            geocoder.getLocations("Carnegie Mellon University", function (response) {  
            place = response.Placemark[0];  
            marker.openInfoWindowHtml(  
            		'<b>Address:</b>' + place.address + '<br>' +    
            		'<b>Latitude Longitude:</b>' + place.Point.coordinates[1] + "," + place.Point.coordinates[0]);  
            }  
            )  
                       
            var currentAddress = document.getElementById("currentAddress");
            var confirmAddr = document.getElementById("confirmAddr");
            confirmAddr.setAttribute("value", currentAddress.getAttribute("value"));
            var confirmLongitude = document.getElementById("confirmLongitude");
            confirmLongitude.setAttribute("value",point.lng());
            var confirmLatitude = document.getElementById("confirmLatitude");
            confirmLatitude.setAttribute("value",point.lat());
            
            GEvent.addListener(map, 'click',getAddress);  
            map.addControl(new GScaleControl());
            //Inside Searching 

        }  
    }  
    function removeCurrentOverlay() {  
        map.removeOverlay(currentOverlay);  
    }  
  
    function getAddress(overlay, latlng) {  
      if (latlng != null) {  
        address = latlng;  
        geocoder.getLocations(latlng, showAddress);  
      }  
    }  
  
    function showAddress(response) {  
      map.clearOverlays();  
      if (!response || response.Status.code != 200) {  
        alert("HTTPStatusCode:" + response.Status.code);  
      } else {  
        place = response.Placemark[0];  
        point = new GLatLng(place.Point.coordinates[1],  
                            place.Point.coordinates[0]);  
        marker = new GMarker(point);  
    
        map.addOverlay(marker);  
        marker.openInfoWindowHtml(  
        '<b>Address:</b>' + place.address + '<br>' +  
        '<b>LongitudeLatitude:</b>' + place.Point.coordinates[1] + "," + place.Point.coordinates[0]);  
        
        var confirmAddr = document.getElementById("confirmAddr");
        confirmAddr.setAttribute("value", place.address);
        var confirmLongitude = document.getElementById("confirmLongitude");
        confirmLongitude.setAttribute("value",place.Point.coordinates[0]);
        var confirmLatitude = document.getElementById("confirmLatitude");
        confirmLatitude.setAttribute("value",place.Point.coordinates[1]);
      }  
    }  
  
    ///Outside Searching, only address  
    function showAddr(address) {  
      if (geocoder) {  
        geocoder.getLatLng(  
          address,  
          function(point) {  
            if (!point) {  
              alert("Error: " + address);  
            } else {  
              map.setCenter(point, 16);  
            }  
    geocoder.getLocations(address, showAddress);  
          }  
        );  
      }  
    }  

   </script>  
  
</head>  

<body onload="load()" onunload="GUnload()">  

<div id="topbar">
	<div id="leftnav"></div>

	<div id="title">
		 Choose Location</div>
</div>
<div id="content">
   
    <fieldset>
        
        <input type="hidden" name="mode" id="mode" value="<%=request.getAttribute("mode")%>"/>
        <form action="#" onsubmit="showAddr(this.currentAddress.value); return false"> 
    	<span class="graytitle">Current Location</span> 
        <ul class="pageitem">
            <li class="button"><input name="currentAddress" id="currentAddress" type="submit" value="5030 Centre Ave, Pittsburgh"/></li>
		</ul>
        </form>
     
        <span class="graytitle">Recent Locations</span>
        <div id="locHistDiv">
        </div>
            
        <form action="#" onsubmit="showAddr(this.newAddress.value); return false">  
        <span class="graytitle">Enter New Location</span>
        <ul class="pageitem">
			<li class="bigfield"><input placeholder="Enter New Location" type="text" id="newAddress" name="newAddress" /></li>
		</ul>
		<ul class="pageitem">
			<li class="button"><input name="select" type="submit" value="Select"/></li>
		</ul> 
        </form>  
        
        <span class="graytitle">Chosen Location</span> 
        <ul class="pageitem">
            <div id="map" style="width: 100%; height: 300px; border: solid 1px #999; float: left">  </div>
        </ul>
        
        <ul class="pageitem">
            <form action="locationAction.do" method="get">
            	<input type="hidden" id="entry_id" name="entry_id" value="<%= request.getParameter("entry_id") %>"></input>
                <input type="hidden" id="confirmAddr" name="confirmAddr" value=""></input>
                <input type="hidden" id="confirmLongitude" name="confirmLongitude" value=""></input>
                <input type="hidden" id="confirmLatitude" name="confirmLatitude" value=""></input>
                <input type="hidden" id="out_mode" name="out_mode"></input>
                <li class="button"><input name="confirm" type="submit" value="Confirm Location"/></li>
            </form>
        </ul>
        
    </div>  
</body>  
</html>  