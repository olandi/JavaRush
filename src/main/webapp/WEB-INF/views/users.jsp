<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Spring MVC and Ajax : User</title>

    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/main.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

    <script src="<c:url value="/resources/js/user.js"/>"></script>

</head>
<body>
<jsp:include page="table.jsp"/>
<div id="container">
    <h2>Submit new User</h2>
    <form id="saveContact">
        <div>
            <label for="nameInput">Name</label>
            <input type="text" name="name" id="nameInput"/>
        </div>
        <div>
            <label for="ageInput">Age</label>
            <input type="text" name="age" id="ageInput"/>
        </div>

        <div><input id="submit" type="submit" value="Save Contact"></div>
    </form>
    <br><br>
    <h2>Javascript Table Filter</h2>

    <input type="search" class="light-table-filter" data-table="order-table" placeholder="Filter">
    <br><br>
    <h2>Table Users</h2>
    <table id="contactTableResponse" class="table tr order-table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>Admin</th>
            <th>Date</th>
            <th>Save</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr class="users">
                <td>${user.id}</td>
                <td><input type="text" name="name"  value="${user.name}"></td>
                <td><input type="text" name="age" value="${user.age}"></td>
                <td>${user.admin}</td>
                <td>${user.date}</td>
                <td><input type="button" value="Update Contact" onclick="updateRow(this)"/></td>
                <td><input type="button" value="Delete" onclick="deleteRow(this)"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav class="pagination-wrap">
        <ul class="pagination">
            <li><a href="/user/home/1">1</a></li>
            <li><a href="/user/home/2">2</a></li>
            <li><a href="/user/home/3">3</a></li>
            <li><a href="/user/home/4">4</a></li>
            <li><a href="/user/home/5">5</a></li>
        </ul>
    </nav>
</div>
</body>
</html>
