<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${users}" var="user">
    <tr id="tr_${user.id}">
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>${user.admin}</td>
        <td>${user.date}</td>
    </tr>
</c:forEach>
