<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="fasle"%>

<html>
<head>
<title>Spring Blog Posts</title>
</head>
<body>
	<div class="postView">
		<div class="postMessage>">
			<c:out value="${post.message}" />
		</div>
		<div>
			<span class="postTime"><c:out value="${post.time}" /></span>
		</div>
	</div>


</body>

</html>