
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color: green; text-align: center">Register the Employee</h1>

<form:form action="add_employee" method="POST" modelAttribute="emp">
	<table align="center" border="0" bgcolor="cyan">
		<tr>
			<td>Emp Name ::</td>
			<td><form:input path="ename" /></td>
		</tr>
		<tr>
			<td>Emp Job ::</td>
			<td><form:input path="job" /></td>
		</tr>
		<tr>
			<td>Emp Salary ::</td>
			<td><form:input path="sal" /></td>
		</tr>
		<tr>
			<td>Emp DeptNo ::</td>
			<td><form:input path="deptno" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Register Employee"></td>
			<td><input type="reset" value="Clear"></td>
		</tr>
	</table>
</form:form>

