<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/confirm.css">
<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet"> 
<title>Confirm</title>
</head>
<body>
<div class="button-block">
	<h1> Save picture </h1>

			<form action="/GoogleDriveFileNew" method="post">

				<input type="text" name="title" placeholder="Name your photo!">
				<input type="hidden" name="content" value="${link}">
				<input type="hidden" name="id" value="${id}">
				<br>
				<div class="bottom_links">
					<button type="submit" class="buttonShare">Confirm</button>
					<button type="button"
						onClick="javascript:window.location.href='HomePage.html'"
						class="button">Cancel</button>
				</div>
			</form>
</div>
</body>
</html>