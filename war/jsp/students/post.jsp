<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<h1>POST /students</h1>
		<p>
			Create a new Student.
		</p>
		
		<h3>Example Requests</h3>
		<ul>
			<li>
				<c:set var="xml">
					<%@include file="/doc/examples/xml/student.xml" %>
				</c:set>
				
				<p>Content-Type: application/xml</p>
				<pre><code><c:out value="${xml}"/></code></pre>
			</li>
			<li>
				<c:set var="json">
					<%@include file="/doc/examples/json/student.json" %>
				</c:set>
				
				<p>Content-Type: application/json</p>
				<pre><code><c:out value="${json}"/></code></pre>
			</li>
		</ul>
	</body>
</html>
