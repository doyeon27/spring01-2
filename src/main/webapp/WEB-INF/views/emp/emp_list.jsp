<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>직원 목록</title>--%>
<%--    <style>--%>
<%--        table {--%>
<%--            border-collapse: collapse;--%>
<%--            width: 80%;--%>
<%--            margin: 20px auto;--%>
<%--        }--%>

<%--        th, td {--%>
<%--            border: 1px solid #dddddd;--%>
<%--            text-align: left;--%>
<%--            padding: 8px;--%>
<%--        }--%>

<%--        th {--%>
<%--            background-color: #f2f2f2;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>

<%--<body>--%>

<%--<h1>직원 목록</h1>--%>

<%--<form action="/emp/empUpd" method="post">--%>
<%--    <input type="text" name="empName" placeholder="수정할 이름을 입력"><br>--%>
<%--    <input type="text" name="empCode"><br>--%>
<%--    <input type="text" name="empTitle"><br>--%>
<%--    <input type="text" name="empAuth"><br>--%>
<%--    <input type="text" name="empSalary"><br>--%>
<%--    <input type="text" name="empTel"><br>--%>
<%--    <input type="text" name="empId"><br>--%>
<%--    <input type="text" name="empPwd"><br>--%>
<%--    <input type="text" name="deptNo"><br>--%>
<%--    <input type="submit" value="수정"><br>--%>
<%--</form>--%>

<%--<form action="/emp/empDel" method="post">--%>
<%--    <input type="text" name="empName" placeholder="삭제할 이름을 입력">--%>
<%--    <input type="submit" value="삭제">--%>
<%--</form>--%>

<%--<table>--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>코드</th>--%>
<%--        <th>이름</th>--%>
<%--        <th>직책</th>--%>
<%--        <th>권한</th>--%>
<%--        <th>급여</th>--%>
<%--        <th>전화번호</th>--%>
<%--        <th>사원 ID</th>--%>
<%--        <th>비밀번호</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach var="item" items="${list}">--%>
<%--        <tr>--%>
<%--            <td>${item.empCode}</td>--%>
<%--            <td>${item.empName}</td>--%>
<%--            <td>${item.empTitle}</td>--%>
<%--            <td>${item.empAuth}</td>--%>
<%--            <td>${item.empSalary}</td>--%>
<%--            <td>${item.empTel}</td>--%>
<%--            <td>${item.empId}</td>--%>
<%--            <td>${item.empPwd}</td>--%>
<%--            <td>${item.deptNo}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>



<%--</body>--%>
<%--</html>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>직원 목록</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f8f8;
            margin: 20px;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        form {
            margin-bottom: 20px;
        }

        form input[type="text"] {
            padding: 8px;
            margin: 5px;
        }

        form input[type="submit"] {
            padding: 8px 15px;
            margin: 5px;
            background-color: #4caf50;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 12px;
        }

        th {
            background-color: #4caf50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>

<body>

<h1>직원 목록</h1>

<form action="/emp/empUpd" method="post">
    <input type="text" name="empName" placeholder="수정할 이름을 입력">
    <input type="text" name="empCode" placeholder="코드">
    <input type="text" name="empTitle" placeholder="직책">
    <input type="text" name="empAuth" placeholder="권한">
    <input type="text" name="empSalary" placeholder="급여">
    <input type="text" name="empTel" placeholder="전화번호">
    <input type="text" name="empId" placeholder="사원 ID">
    <input type="text" name="empPwd" placeholder="비밀번호">
    <input type="text" name="deptNo" placeholder="부서번호">
    <input type="submit" value="수정">
</form>

<form action="/emp/empDel" method="post">
    <input type="text" name="empName" placeholder="삭제할 이름을 입력">
    <input type="submit" value="삭제">
</form>

<table>
    <thead>
    <tr>
        <th>코드</th>
        <th>이름</th>
        <th>직책</th>
        <th>권한</th>
        <th>급여</th>
        <th>전화번호</th>
        <th>사원 ID</th>
        <th>비밀번호</th>
        <th>부서번호</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${list}">
        <tr>
            <td>${item.empCode}</td>
            <td>${item.empName}</td>
            <td>${item.empTitle}</td>
            <td>${item.empAuth}</td>
            <td>${item.empSalary}</td>
            <td>${item.empTel}</td>
            <td>${item.empId}</td>
            <td>${item.empPwd}</td>
            <td>${item.dept.deptNo}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
