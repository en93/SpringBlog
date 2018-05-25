<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="fasle" %>

<html>
	<head>
		<title>Spring Blog Home</title>
		
	</head>
	
	<body>
		<h1>Welcome to Spring Blog</h1>
		<a href="<c:url value="/blogs"/>">Blogs</a>
		<a href="<c:url value="/blog/register"/>">Register</a>
	
	</body>
	
</html>