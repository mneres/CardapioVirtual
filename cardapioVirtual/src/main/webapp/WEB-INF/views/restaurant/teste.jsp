<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }

      #map-canvas {
        height: 100%;
        width: 50%;
      }
      #content-pane {
        float:right;
        width:48%;
        padding-left: 2%;
      }
      #outputDiv {
        font-size: 11px;
      }
    </style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery/jquery.jsonp.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery/jquery.session.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
<script type="text/javascript">

var origin1 = '';
var destinationA = '12312-290';
	
		$(document).ready(function() {
		    $.ajax({
		        url: "http://localhost:8080/cardapioVirtual/restaurants/listByJson"
		    }).then(function(data) {
		    	$.session.set('ADDRESS_CEP', '12232-234');
	    		destinationA = $.session.get('ADDRESS_CEP');
		    	for(i=0; i<=2;i++){
		    		var code =  data[i].address.code;
		    		code = [String(code).slice(0,5),'-' ,String(code).slice(5,8)].join('');		    		
		    		origin1 = code;
		    		calculateDistances();
		    	}
		    });
		});
		
function calculateDistances() {
  var service = new google.maps.DistanceMatrixService();
  service.getDistanceMatrix(
    {
      origins: [origin1],
      destinations: [destinationA],
      travelMode: google.maps.TravelMode.DRIVING,
      unitSystem: google.maps.UnitSystem.METRIC,
      avoidHighways: false,
      avoidTolls: false
    }, callback);
}

function callback(response, status) {
  if (status != google.maps.DistanceMatrixStatus.OK) {
    alert('Error was: ' + status);
  } else {
    var origins = response.originAddresses;
    var destinations = response.destinationAddresses;
		
    for (var i = 0; i < origins.length; i++) {
        var results = response.rows[i].elements;
        for (var j = 0; j < results.length; j++) {
          if(getNumber(results[j].distance.text) <=10){
              outputDiv.innerHTML += origins[i] + ' to ' + destinations[j]
              + ': ' + results[j].distance.text + ' in '
              + results[j].duration.text + '<br>';
          }
        }
      }
    }
  }
function getNumber(string) 
{
    var numsStr = string.replace(/[^0-9][,]/g,'');
    return parseFloat(numsStr);
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%= request.getParameter("kaka") %>

	<div id="content-pane">
	      <div id="inputs">
	        <pre>
	
	        </pre>
	        <p><button type="button" onclick="calculateDistances();">Calculate
	          distances</button></p>
	      </div>
	      <div id="outputDiv"></div>
	    </div>
	    <div id="map-canvas"></div>
</body>
</html>