<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<h1>GET /students/search/{query}</h1>
		<p>
			Returns all the students corresponding to the query. <br/>
			Currently, just the first name and the last name are used by the search.
		</p>
		
		<h3>Example Responses to GET /students/search/jack</h3>
		<ul>
			<li>
				<c:set var="xml">
					<%@include file="/doc/examples/xml/search.xml" %>
				</c:set>
				
				<p>Accept: application/xml</p>
				<pre><code><c:out value="${xml}"/></code></pre>
			</li>
			<li>
				<c:set var="json">
					<%@include file="/doc/examples/json/search.json" %>
				</c:set>
				
				<p>Accept: application/json</p>
				<pre><code><c:out value="${json}"/></code></pre>
			</li>
		</ul>
	</body>
</html>
