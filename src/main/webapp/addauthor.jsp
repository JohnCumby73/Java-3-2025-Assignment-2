<%--
  Created by IntelliJ IDEA.
  User: john.cumby
  Date: 4/14/2025
  Time: 1:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Author</title>
</head>
<body>
    <h1><%= "Add an author"%></h1>
    <br/>
    <form action = "library-servlet" method = "post">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName"><br><br>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName"><br><br>

        <p>ID will be auto generated.</p>

        <input type="hidden" name="submissionType" value="author">

        <input type="submit" value="Submit">
    </form>
    <br>
    <a href="index.jsp">Back to Main Page</a>
</body>
</html>
