<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<h1>GET /students</h1>
		<p>
			Returns all the students.
		</p>
		
		<h3>Example Responses</h3>
		<ul>
			<li>
				<c:set var="xml">
					<%@include file="/doc/examples/xml/students.xml" %>
				</c:set>
				
				<p>Accept: application/xml</p>
				<pre><code><c:out value="${xml}"/></code></pre>
			</li>
			<li>
				<c:set var="json">
					<%@include file="/doc/examples/json/students.json" %>
				</c:set>
				
				<p>Accept: application/json</p>
				<pre><code><c:out value="${json}"/></code></pre>
			</li>
		</ul>
	</body>
</html>
