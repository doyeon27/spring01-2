<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>


<body>
<h1>userList</h1>


<c:forEach var="item" items="${list}">
    <tr>
        <td>${item.userNo}</td>
        <td>${item.userId}</td>
        <td>${item.userName}</td>
        <td>${item.userPassword}</td>
            <%--        <button id="updBtn">수정</button>--%>
            <%--        <button id="delBtn">삭제</button>--%>
    </tr>
    <br>
</c:forEach>


<%--삭제--%>
<form action="/member/userDel" method="post">

    <input type="text" name="userNo" placeholder="삭제할 번호를 입력">
    <input type="submit" value="삭제">
</form>

<hr>

<%--수정--%>
<form action="/member/userUpd" method="post">
    <input type="text" name="userNo" placeholder="수정할 번호를 입력"><br>
    아이디 : <input type="text" name="userId"><br>
    이름 : <input type="text" name="userName"><br>
    비번 : <input type="text" name="userPassword"><br>
    <input type="submit" value="수정"><br>
</form>

</body>
</html>
