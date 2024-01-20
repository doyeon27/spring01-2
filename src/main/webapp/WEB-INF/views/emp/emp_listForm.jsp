<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/emp/empAdd" method="post">
    코드 : <input type="text" name="empCode"><br>
    이름 : <input type="text" name="empName"><br>
    직급 : <input type="text" name="empTitle"><br>
    권한 : <input type="text" name="empAuth"><br>
    연봉 : <input type="text" name="empSalary"><br>
    전화번호 : <input type="number" name="empTel"><br>
    아이디 : <input type="number" name="empId"><br>
    비밀번호 : <input type="number" name="empPwd"><br>
    부서번호 : <input type="number" name="deptNo"><br>
<%--    퇴사여부 :<input type="number" name="empRetire"><br>--%>
    <input type="submit" value="등록"><br>
</form>
</body>
</html>
