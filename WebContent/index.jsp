

<!DOCTYPE html>
<html>



<body>
	Log into an existing account
	<br>
	<br>
	<form action="controller" method="post">
		Username:<input type="text" name="name">
		<br> 
		Password:<input type="password" name="password">
		<br>
		<label for="cars">User Type:</label>

	<select name="userType">
 	 <option value="users">Free User</option>
 	 <option value="admins">Admin</option>
	</select>
		<input type="submit" value="Login">
	</form>
	<br>
	<form action="createAcc.jsp" method="post">
		<input type="submit" value="Create a new account">
	</form>
	<br>
	<form action="forgotPass.jsp" method="post">
		<input type="submit" value="Forgot your password?">
	</form>

</body>
</html>