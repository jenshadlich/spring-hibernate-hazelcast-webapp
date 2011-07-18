<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Index</title>
</head>

<body>

	<h1>Index</h1>

	<table>
		<tr>
			<td>current user:</td>
			<td><s:property value="%{currentUsername}" /></td>
		</tr>
		<tr>
			<td># user</td>
			<td><s:property value="%{userCount}" /></td>
		</tr>
	</table>

	<hr>

	<s:form action="Index">
		<s:textfield name="createUserCount" value="1" />
		<s:submit method="createXRandomUsers" value="createXRandomUsers" />
	</s:form>

	<hr>

	<s:form action="Index">
		<s:submit method="queryRandomUser" value="queryRandomUser" />
	</s:form>
	
	<hr>

	<s:form action="Index">
		<s:textfield name="queryUserId" value="1" />
		<s:submit method="queryUserX" value="queryUserX" />
	</s:form>

</body>

</html>
