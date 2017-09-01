<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/GoogleDriveFileListing.css">
<link href="https://fonts.googleapis.com/css?family=Permanent+Marker" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Comfortaa" rel="stylesheet"> 
</head>
<title>Your Drive</title>
<body>
  

<h1>Files in your Drive</h1>

	<div class="container">
	
		<p class="message">${message}</p>
				
		<table id="files">
			<tr>
				<th>Name</th>
				<th>Size</th>
				<th>Last modification date</th>
				<th>Open on Drive</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${requestScope.files.items}" var="file">
				<tr>
				<td><c:out value="${file.title}"/></td>
				<td><c:out value="${file.fileSize}"/></td>
				<td><c:out value="${file.modifiedDate}"/></td>
				<td><a href="<c:out value="${file.embedLink}"/>"><img src="./images/drive.png" width="30px"></a></td>
				<td>
				  <a href="GoogleDriveFileUpdate?id=${file.id}"><img src="./images/edit.png" width="30px"></a>
				</td>
				<td>
					<a href="GoogleDriveFileDelete?id=${file.id}"><img src="./images/delete.png" width="30px"></a>
				</td>
				</tr>
			</c:forEach>			
		</table>
		<p>
	</div>

</body>
</html>
