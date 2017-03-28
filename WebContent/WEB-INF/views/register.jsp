<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
	border-color: #ff0000;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js" type="text/javascript"></script>
<script>
function addEmployee() {
	var employee = {};
	employee['name'] = $("#name").val();
	employee['email'] = $("#email").val();
	employee['sex'] = $("#sex").val();
	employee['dob'] = $("#dob").val();
	
	
	$.ajax({
		type : "POST",
		contentType : "application/json; charset=utf-8",
		url : "./add",
		data : JSON.stringify(employee),
		success : function(data) {
			console.log("SUCCESS: ", data);
			display(data);
		},
		/* error : function(e) {
			console.log("ERROR: ", e);
			display(e);
		} */
		
		 error: function(xhr,status,error)
         {
			debugger;
				//alert(error);
				if (xhr.status == 0) {
                 location.href = "./add";
              }
         }
	});
	function display(springData) {
		/* var json = "<h4>Ajax Response</h4><pre>"
				+ JSON.stringify(springData, null, 4) + "</pre>"; */
				//alert(springData);
		$('#employee').html(springData);
	}
}

</script>
</head>
<body>
	<form:form id="employee" commandName="employee">
		<%-- <form:errors path="/" cssClass="errorblock" element="div" /> --%>
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><form:input path="sex" /></td>
				<td><form:errors path="sex" cssClass="error" /></td>
			</tr>
			<tr>
				<td>DOB :</td>
				<td><form:input path="dob" /></td>
				<td><form:errors path="dob" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="button" value="Submit" onclick="addEmployee()" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>