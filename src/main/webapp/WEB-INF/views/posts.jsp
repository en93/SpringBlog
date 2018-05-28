<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="fasle" %>

<html>
	<head>
		<title>Spring Blog Posts</title>		
	</head>
	
	<body>
		<h1>Spring posts</h1>
		<c:forEach items="${postList}" var ="post">
			<li id="post_<c:out value="post.id"/>">
				<div class="postMessage">
					<c:out value="${post.message}"/>
				</div>
				<div>
					<span class="postTime"><c:out value="${post.time}"/></span>
					<span class="postLocation">
						(<c:out value="${post.latitude}"/>,
						<c:out value="${post.longitude}"/>)
					</span>
				</div>
			</li>
		</c:forEach>
	</body>
	
</html>