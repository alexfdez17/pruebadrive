<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/EditFile.css">
<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
<title>Edit file</title>
</head>
<body>


	<div class="container">
	
		<p class="message">${message}</p>
				
		<form action="GoogleDriveFileUpdate" method="post" >
			
				<input type="hidden" name="id" value="${file.id}">
			
			File name: <input type="text" name="title" placeholder="${title}"><br>
			<input type="hidden" name="content" value="${content}">
			<div class="bottom_links">
				<button type="submit" class="button">Change your photo's name</button>
				<button type="button" onClick="javascript:window.location.href='contactlist'" class="button">Cancel</button>
			</div>
		</form>
	</div>

</body>
</html>
