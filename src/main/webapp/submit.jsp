<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>
	<h2>SQL Submitter</h2>

	<form:form modelAttribute="TextArea" action="/submit" method="POST">
		<!--form:errors path="*" cssClass="errorblock" element="div" /-->
		<table>
			<tr>
				<td style="border-bottom: thick;" >Enter SQL</td>
			</tr>
			<tr>
				<td><form:textarea path="textArea" rows="5" cols="30" /></td>
				<!--td><form:errors path="textArea" cssClass="error" /></td-->
			</tr>
			<tr>
				<td align="right" colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>