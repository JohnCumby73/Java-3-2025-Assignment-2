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
    <title>Add Book</title>
</head>
<body>
    <h1><%= "Add a book" %></h1>
    <br/>
    <form action="library-servlet" method="post">
        <label for="title">Title:</label>
        <input type="text" id="Title" name="title"><br><br>

        <label for="ISBN">ISBN:</label>
        <input type="text" id="ISBN" name="ISBN"><br><br>

        <label for="editionNumber">Edition Number:</label>
        <input type="text" id="editionNumber" name = "editionNumber"><br><br>

        <label for="copyright">Copyright Year:</label>
        <input type="text" id="copyright" name = "copyright"><br><br>

        <label for="authorID">Author ID:</label>
        <input type="text" id="authorID" name="authorID"><br><br>

        <input type="hidden" name="submissionType" value="book">

        <input type="submit" value="Submit">
    </form>
    <br>
    <a href="index.jsp">Back to Main Page</a>

</body>
</html>
