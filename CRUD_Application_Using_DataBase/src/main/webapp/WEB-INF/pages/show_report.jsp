<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<center>
	<h1 style="color: red; text-align: center">Employee Report</h1>
</center>
<table align="center">
	<tr>
		<th>
			<center>
				<h3 style="color: blue; text-align: center">
					<a href="add_employee"><img src="resources/images/addd.jpeg"
						width=50><br>Add Employee</a>
				</h3>
			</center>
		</th>
		<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		<th>
			<center>
				<h3 style="color: blue; text-align: center">
					<a href="./"><img src="resources/images/home.jpeg" width=50><br>Home</a>
				</h3>
			</center>
		</th>
	</tr>
</table>
<br>

<c:choose>
	<c:when test="${!empty listEmps}">
		<table align="center" bgcolor="cyan" border="1">
			<tr style="color: red">
				<th>EmpNo</th>
				<th>EmpName</th>
				<th>EmpJob</th>
				<th>EmpSalary</th>
				<th>DeptNo</th>
				<th>Operations</th>
			</tr>

			<c:forEach var="emp" items="${listEmps}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.sal}</td>
					<td>${emp.deptno}</td>
					<td><a href="edit_employee?no=${emp.empno}"><img
							src="resources/images/edit.jpeg" width=30></a> &nbsp;&nbsp; <a
						href="delete_employee?no=${emp.empno}"
						onclick="return confirm('Do you want delete?')"><img
							src="resources/images/delete.jpeg" width=30></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>

	<c:otherwise>
		<h2 style="color: red; text-align: center">Recored Not Found</h2>
	</c:otherwise>

</c:choose>

<h2 style="text-align: center; color: green">${resultMsg}</h2>



