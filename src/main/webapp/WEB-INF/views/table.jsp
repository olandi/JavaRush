<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Spring MVC and Ajax : User</title>

    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

    <script src="<c:url value="/resources/js/user.js"/>"></script>


</head>
<body>
<div id="container">
    <h2>Find Contact By Name</h2>

    <label for="search">Search</label>
    <input type="text" id="search" name="search">
    <div id="info"></div>
    <table id="loadTable" class="table tr">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>isAdmin</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody id="tbody">
      <!--  <jsp:include page="search.jsp"/> -->
        </tbody>
    </table>
</div>
</body>
</html>