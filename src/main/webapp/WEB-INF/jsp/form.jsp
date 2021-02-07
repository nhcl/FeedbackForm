<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback Form</title>
</head>
<body>
	<form action='submitFeedback' method='POST'>
		<label> Enter your name: <input type='text' name='user'></input></label>
		<br> 
		<br> 
		<label> Enter your rating: <input type='text' name='rating'></input></label> 
		<br> 
		<br>
		<label> Enter your comment: <input type='text' name='comments'></input></label> 
		<br> 
		<br> 
		<input type='submit' value='submit'>
		<h4>${successMessage}</h4>
	</form>
</body>
</html>