<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel=”shortcut icon” href=”/favicon.ico” type=”image/x-icon” />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Passion+One" rel="stylesheet"> 
<link rel="stylesheet" type="text/css" href="css/success.css">
<style>
#map {
	height: 400px;
	width: 100%;
}
</style>


<title>Search results</title>

</head>
<body>
<section class="container">
<div class="right-screen">
	<fieldset id="googlemaps">
		<legend>
			Google Maps search for the location: 
			<c:out value="${param.searchQuery}" />
		</legend>
<div class="Cancel-button">
	<button type="button"
						onClick="javascript:window.location.href='HomePage.html'"
						class="button">New search</button>
</div>

		<div id="map"></div>
		<script>
      function initMap() {
        var uluru = {lat: ${lat}, lng: ${lng}};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 13,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
    </script>

		<script async defer
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDMPX-BlAy9WQULw6ghUPdinLeGACrjA70&callback=initMap">
    </script>
	</fieldset>
	</div>
<div class="left-screen">
	<fieldset id="flickr">
		<legend>
			Flickr search for the location: 
			<c:out value="${param.searchQuery}" />
		</legend>

		<c:forEach items="${requestScope.photos.photo}" var="photo">
			<img
				src='http://farm<c:out value="${photo.farm}"/>.staticflickr.com/<c:out value="${photo.server}"/>/<c:out value="${photo.id}"/>_<c:out value="${photo.secret}"/>.jpg' />
			<br />
			<form action="/ConfirmController" method="post">

				
				<input type="hidden" name="link" value="http://farm<c:out value="${photo.farm}"/>.staticflickr.com/<c:out value="${photo.server}"/>/<c:out value="${photo.id}"/>_<c:out value="${photo.secret}"/>.jpg">
				<input type="hidden" name="id" value="${photo.id}">
				
				
				<br>
				<div class="bottom_links">
					<button type="submit" class="buttonShare">Upload photo to Google Drive</button>
				
				</div>
			</form>
		</c:forEach>
	</fieldset>
	</div>
</section>
</body>
</html>