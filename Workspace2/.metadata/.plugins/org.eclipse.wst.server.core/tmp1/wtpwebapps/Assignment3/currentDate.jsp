<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Current Date</title>
</head>
<body>
    <h1>Current Date and Time</h1>
    <p>
        The current date and time is: 
        <%= new java.util.Date() %>
    </p>
</body>
</html>
