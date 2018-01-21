<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body onload='document.f.username.focus();'>
  <h3>Login</h3>
  <form name='f' action='/SpringInAction/login' method='POST'>
    <table>
      <tr>
        <td>User:</td>
        <td><input type='text' name='username' value=''/></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td><input type='password' name='password'/></td>
      </tr>
      <tr>
        <td colspan='2'><input type="submit" name="submit" value="Login"/></td>
      </tr>
    </table>
  </form>

</body>
</html>