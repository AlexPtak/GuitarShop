<%--
  Created by IntelliJ IDEA.
  User: Ptak
  Date: 07.10.2015
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <form action="GetParameterTypesServlet" method="get">
      <h1>Get Parameter Types</h1>
      <input type="submit" value="get parameter types"/>
    </form>

    <form action="GetGuitarBrandsServlet" method="get">
      <h1>Get Guitar Brands</h1>
      <input type="submit" value="get guitar brands"/>
    </form>

    <form action="GetCustomersServlet" method="get">
      <h1>Get Customers</h1>
      <input type="submit" value="get customers"/>
    </form>

    <form action="GetFullGuitarsServlet" method="get">
      <h1>Get Full Guitar</h1>
      <input type="submit" value="get full guitar"/>
    </form>

    <form action="LoginServlet" method="post">
      <h1>Login</h1>
      <input type="text" value="Login" name="login"/>
      <input type="text" value="Password" name="password"/>
      <input type="submit" value="login"/>
    </form>

    <form action="CreateUserServlet" method="post">
      <h1>Create User</h1>
      <%--<input type="text" value="First Name" name="firstName"/>--%>
      <%--<input type="text" value="Last Name" name="lastName"/>--%>
      <%--<input type="text" value="Email" name="email"/>--%>
      <%--<input type="text" value="Phone" name="phone"/>--%>
      <%--<input type="text" value="Login" name="login"/>--%>
      <%--<input type="text" value="Password" name="password"/>--%>
      <input type="submit" value="create user"/>
      <textarea name="textArea"><?xml version="1.0" encoding="UTF-8" standalone="yes"?>
        <CUSTOMER customer_id="4">
          <email>chackSchuldiner@gmail.com</email>
          <first_name>Chack</first_name>
          <last_name>Schuldiner</last_name>
          <login>ChackSchuldinerr</login>
          <pass>46378</pass>
          <phone>544681</phone>
          <status_id>1</status_id>
        </CUSTOMER></textarea>
    </form>
  </body>
</html>
